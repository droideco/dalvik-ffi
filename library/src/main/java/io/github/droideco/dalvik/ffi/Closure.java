package io.github.droideco.dalvik.ffi;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Closure {

    static {
        System.loadLibrary("dalvikffi");
    }

    private static final Map<Long, CallContext> CIF_MAP = new HashMap<>();
    private static final Map<Long, Closure> USER_DATA_MAP = new HashMap<>();

    private final CallContext context;
    private final RawClosureHandler handler;
    private final long closure;
    private final long address_memory;
    private final long address;
    private final long rvalue;
    private final AtomicBoolean recycled = new AtomicBoolean(false);

    public static Closure newRawClosure(CallContext context, RawClosureHandler handler) {
        return new Closure(context, handler);
    }

    public static Closure newClosure(CallContext context, ClosureHandler handler) {
        return new Closure(context, new RawClosureHandler() {
            @Override
            public void invoke(Closure closure, long rvalue, long avalues) throws Throwable {
                Type rtype = closure.context.rtype;
                Type[] atypes = closure.context.atypes;
                Object[] args = new Object[atypes.length];
                for (int i = 0; i < atypes.length; i ++) {
                    Type atype = atypes[i];
                    long avalue = Memory.getAddress(avalues + Memory.ADDRESS_SIZE * i);
                    if (atype == Type.SINT8) args[i] = Memory.getByte(avalue);
                    else if (atype == Type.SINT16) args[i] = Memory.getShort(avalue);
                    else if (atype == Type.UNICHAR) args[i] = Memory.getChar(avalue);
                    else if (atype == Type.SINT32 || atype == Type.WCHAR) args[i] = Memory.getInt(avalue);
                    else if (atype == Type.SINT64) args[i] = Memory.getLong(avalue);
                    else if (atype == Type.FLOAT) args[i] = Memory.getFloat(avalue);
                    else if (atype == Type.DOUBLE) args[i] = Memory.getDouble(avalue);
                    else if (atype == Type.POINTER || atype == Type.SIZE) args[i] = Memory.getAddress(avalue);
                    else if (atype == Type.BOOLEAN) args[i] = Memory.getAddress(avalue) != 0;
                    else if (atype == Type.SLONG) args[i] = Memory.getNativeLong(avalue);
                    else args[i] = avalue;
                }
                Object result = handler.invoke(closure, args);
                if (rtype != Type.VOID) {
                    Objects.requireNonNull(result);
                    if (rtype == Type.SINT8) Memory.putByte(rvalue, ((Number) result).byteValue());
                    else if (rtype == Type.SINT16) Memory.putShort(rvalue, ((Number) result).shortValue());
                    else if (rtype == Type.UNICHAR) Memory.putChar(rvalue, (Character) result);
                    else if (rtype == Type.SINT32 || rtype == Type.WCHAR) Memory.putInt(rvalue, ((Number) result).intValue());
                    else if (rtype == Type.SINT64) Memory.putLong(rvalue, ((Number) result).longValue());
                    else if (rtype == Type.FLOAT) Memory.putFloat(rvalue, ((Number) result).floatValue());
                    else if (rtype == Type.DOUBLE) Memory.putDouble(rvalue, ((Number) result).doubleValue());
                    else if (rtype == Type.POINTER || rtype == Type.SIZE) Memory.putAddress(rvalue, ((Number) result).longValue());
                    else if (rtype == Type.BOOLEAN) Memory.putAddress(rvalue, ((Boolean) result) ? 1 : 0);
                    else if (rtype == Type.SLONG) Memory.putNativeLong(rvalue, ((Number) result).longValue());
                    else Memory.copy(rvalue, (long) result, rtype.size);
                }
            }
            @Override
            public void preInvoke(Closure closure) {
                handler.preInvoke(closure);
            }
            @Override
            public void postInvoke(Closure closure) {
                handler.postInvoke(closure);
            }
        });
    }

    private Closure(CallContext context, RawClosureHandler handler) {
        this.context = Objects.requireNonNull(context);
        this.handler = Objects.requireNonNull(handler);
        this.address_memory = Memory.allocate(Memory.ADDRESS_SIZE);
        Type rtype = context.rtype;
        if (rtype.compound) {
            long rvalue = Memory.allocate(rtype.size);
            if (rvalue == 0L) throw new IllegalStateException("Failed to initialize ffi_closure");
            this.rvalue = rvalue;
        }
        else rvalue = 0L;
        this.closure = nAllocateClosure(address_memory);
        if (closure == 0L) {
            Memory.free(address_memory);
            throw new IllegalStateException("Failed to initialize ffi_closure");
        }
        try {
            if (nInitializeClosure(closure, context.handle, closure, address = Memory.getAddress(address_memory)) != 0) {
                Memory.free(address_memory);
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

    public CallContext getCallContext() {
        return context;
    }

    public long address() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("0x%016X", address);
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
                Memory.free(address_memory);
            }
        }
    }

    public boolean isRecycled() {
        return recycled.get();
    }

    private static void nDispatch(long cif, long rvalue, long avalues, long user_data) {
        CallContext context = CIF_MAP.get(cif);
        Closure closure = USER_DATA_MAP.get(user_data);
        closure.handler.preInvoke(closure);
        try {
            if (context.rtype.compound) {
                closure.handler.invoke(closure, closure.rvalue, avalues);
                Memory.putAddress(rvalue, closure.rvalue);
            }
            else closure.handler.invoke(closure, rvalue, avalues);
        }
        catch (RuntimeException | Error e) {
            throw e;
        }
        catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
        finally {
            closure.handler.postInvoke(closure);
        }
    }

    private static native long nAllocateClosure(long pfp);
    private static native int nInitializeClosure(long closure, long cif, long user_data, long fp);
    private static native void nFreeClosure(long closure);

}
