package io.github.droideco.dalvik.ffi;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FFIClosure {

    static {
        System.loadLibrary("dalvikffi");
    }

    private static final Map<Long, FFICallContext> CIF_MAP = new HashMap<>();
    private static final Map<Long, FFIClosure> USER_DATA_MAP = new HashMap<>();

    private final FFICallContext context;
    private final FFIRawClosureHandler handler;
    private final long closure;
    private final long pfp;
    private final long fp;
    private final long rvalue;
    private final AtomicBoolean recycled = new AtomicBoolean(false);

    public static FFIClosure newClosure(FFICallContext context, FFIRawClosureHandler handler) {
        return new FFIClosure(context, handler);
    }

    private FFIClosure(FFICallContext context, FFIRawClosureHandler handler) {
        this.context = Objects.requireNonNull(context);
        this.handler = Objects.requireNonNull(handler);
        this.pfp = Memory.allocate(Memory.ADDRESS_SIZE);
        FFIType rtype = context.rtype;
        if (rtype.compound) {
            long rvalue = Memory.allocate(rtype.size);
            if (rvalue == 0L) throw new IllegalStateException("Failed to initialize ffi_closure");
            this.rvalue = rvalue;
        }
        else rvalue = 0L;
        this.closure = nAllocateClosure(pfp);
        if (closure == 0L) {
            Memory.free(pfp);
            throw new IllegalStateException("Failed to initialize ffi_closure");
        }
        try {
            if (nInitializeClosure(closure, context.handle, closure, fp = Memory.getAddress(pfp)) != 0) {
                Memory.free(pfp);
                throw new IllegalStateException("Failed to initialize ffi_closure");
            }
        }
        finally {
            Long boxed = context.handle;
            if (!CIF_MAP.containsKey(boxed)) synchronized (CIF_MAP) {
                if (!CIF_MAP.containsKey(boxed)) CIF_MAP.put(boxed, context);
            }
            boxed = closure;
            if (!USER_DATA_MAP.containsKey(boxed)) synchronized (USER_DATA_MAP) {
                if (!USER_DATA_MAP.containsKey(boxed)) USER_DATA_MAP.put(boxed, this);
            }
        }
    }

    public FFICallContext getCallContext() {
        return context;
    }

    public FFIRawClosureHandler getClosureHandler() {
        return handler;
    }

    public long address() {
        return fp;
    }

    public void recycle() {
        if (recycled.compareAndSet(false, true)) {
            if (rvalue != 0L) Memory.free(rvalue);
            try {
                synchronized (USER_DATA_MAP) {
                    USER_DATA_MAP.remove(closure);
                }
            }
            finally {
                synchronized (CIF_MAP) {
                    CIF_MAP.remove(context.handle);
                }
                nFreeClosure(closure);
                Memory.free(pfp);
            }
        }
    }

    public boolean isRecycled() {
        return recycled.get();
    }

    private static void nDispatch(long cif, long rvalue, long avalues, long user_data) {
        FFICallContext context = CIF_MAP.get(cif);
        FFIClosure closure = USER_DATA_MAP.get(user_data);
        closure.handler.preInvoke(context);
        try {
            if (context.rtype.compound) {
                closure.handler.invoke(context, closure.rvalue, avalues);
                Memory.putAddress(rvalue, closure.rvalue);
            }
            else closure.handler.invoke(context, rvalue, avalues);
        }
        catch (RuntimeException | Error e) {
            throw e;
        }
        catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
        finally {
            closure.handler.postInvoke(context);
        }
    }

    private static native long nAllocateClosure(long pfp);
    private static native int nInitializeClosure(long closure, long cif, long user_data, long fp);
    private static native void nFreeClosure(long closure);

}
