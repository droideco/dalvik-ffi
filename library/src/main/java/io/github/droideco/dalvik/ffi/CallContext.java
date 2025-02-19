package io.github.droideco.dalvik.ffi;

import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

public final class CallContext {

    static {
        System.loadLibrary("dalvikffi");
    }

    private static final Map<Integer, CallContext> CIF_MAP = new WeakHashMap<>();
    public static CallContext getCallContext(Type rtype, Type[] atypes, int atypesOffset, int nfixedargs, int ntotalargs) {
        if (ntotalargs < 0) throw new IllegalArgumentException("Negative array length");
        //else if (ntotalargs > 255) throw new IllegalArgumentException("parameter limit exceeded: " + ntotalargs);
        if (nfixedargs < 0) nfixedargs = ntotalargs;
        else if (nfixedargs > ntotalargs)
            throw new IllegalArgumentException(nfixedargs + " > " + ntotalargs);
        if (atypes == null) {
            if (ntotalargs != 0) throw new IllegalArgumentException(ntotalargs + " > 0");
        }
        else {
            Type[] _atypes = new Type[ntotalargs];
            for (int i = 0; i < ntotalargs; i ++) {
                Type atype = atypes[atypesOffset + i];
                if (atype == Type.VOID) throw new IllegalArgumentException("Unsupported type");
                _atypes[i] = atype;
            }
            atypes = _atypes;
        }
        int hashCode = Long.hashCode(rtype.handle);
        hashCode = 31 * hashCode + nfixedargs;
        hashCode = 31 * hashCode + ntotalargs;
        hashCode = 31 * hashCode + Arrays.hashCode(atypes);
        Integer boxed = hashCode;
        if (!CIF_MAP.containsKey(boxed)) {
            synchronized (CIF_MAP) {
                if (!CIF_MAP.containsKey(boxed)) {
                    long handle = nAllocateCIF();
                    if (handle == 0L) throw new IllegalStateException("Failed to initialize ffi_cif");
                    long atypes_memory = Memory.allocate(ntotalargs * Memory.ADDRESS_SIZE);
                    if (atypes_memory == 0L) {
                        Memory.free(handle);
                        throw new IllegalStateException("Failed to initialize ffi_cif");
                    }
                    for (int i = 0; i < ntotalargs; i ++) {
                        Memory.putAddress(atypes_memory + Memory.ADDRESS_SIZE * i, atypes[i].handle);
                    }
                    int result;
                    if (nfixedargs == ntotalargs) result = nInitializeCIF(handle, rtype.handle, atypes_memory, ntotalargs);
                    else result = nInitializeCIFVariadic(handle, rtype.handle, atypes_memory, nfixedargs, ntotalargs);
                    if (result != 0) {
                        Memory.free(handle);
                        Memory.free(atypes_memory);
                        throw new IllegalStateException("Failed to initialize ffi_cif");
                    }
                    CIF_MAP.put(boxed, new CallContext(handle, atypes_memory, rtype, atypes));
                }
            }
        }
        return CIF_MAP.get(boxed);
    }
    public static CallContext getCallContext(Type rtype, Type[] atypes, int nfixedargs, int ntotalargs) {
        return getCallContext(rtype, atypes, 0, nfixedargs, ntotalargs);
    }
    public static CallContext getCallContext(Type rtype, Type[] atypes, int nfixedargs) {
        return getCallContext(rtype, atypes, 0, nfixedargs, atypes.length);
    }
    public static CallContext getCallContext(Type rtype, Type... atypes) {
        return getCallContext(rtype, atypes, 0, -1, atypes.length);
    }

    private static native long nAllocateCIF();
    private static native int nInitializeCIF(long cif, long rtype, long atypes, int nargs);
    private static native int nInitializeCIFVariadic(long cif, long rtype, long atypes, int nfixedargs, int ntotalargs);

    final long handle;
    private final long atypes_memory;
    final Type rtype;
    final Type[] atypes;

    private CallContext(long handle, long atypes_memory, Type rtype, Type[] atypes) {
        this.handle = handle;
        this.atypes_memory = atypes_memory;
        this.rtype = rtype;
        this.atypes = atypes;
    }

    public Type getReturnType() {
        return rtype;
    }

    public Type[] getParameterTypes() {
        return atypes.clone();
    }

    public int getParameterCount() {
        return atypes.length;
    }

    public Type getParameterType(int index) {
        return atypes[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("cdecl");
        builder.append(' ');
        Type returnType = getReturnType();
        builder.append(returnType == null ? "void" : returnType);
        builder.append(' ');
        builder.append('(').append('*').append(')');
        builder.append('(');
        if (atypes.length > 0) {
            builder.append(atypes[0]);
            for (int i = 1; i < atypes.length; i ++) {
                builder.append(',').append(' ').append(atypes[i]);
            }
        }
        builder.append(')');
        return builder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            Memory.free(handle);
            Memory.free(atypes_memory);
        }
        finally {
            super.finalize();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallContext cif = (CallContext) o;
        return handle == cif.handle;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(handle);
    }
    
}
