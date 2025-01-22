package io.github.multiffi.dalfik;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class FFICallContext {

    static {
        System.loadLibrary("dalfik");
    }

    private static final Map<Integer, FFICallContext> CIF_MAP = new HashMap<>();
    public static FFICallContext of(FFIType rtype, FFIType[] atypes, int atypesOffset, int nfixedargs, int ntotalargs) {
        if (ntotalargs < 0) throw new IllegalArgumentException("Negative array length");
        else if (ntotalargs > 255) throw new IllegalArgumentException("parameter limit exceeded: " + Integer.toUnsignedLong(ntotalargs));
        if (nfixedargs < 0) nfixedargs = ntotalargs;
        else if (nfixedargs > ntotalargs)
            throw new IllegalArgumentException(nfixedargs + " > " + ntotalargs);
        if (atypes == null) {
            if (ntotalargs != 0) throw new IllegalArgumentException(ntotalargs + " > 0");
        }
        else atypes = Arrays.copyOfRange(atypes, atypesOffset, ntotalargs);
        int hashCode = Long.hashCode(rtype.handle);
        hashCode = 31 * hashCode + nfixedargs;
        hashCode = 31 * hashCode + ntotalargs;
        hashCode = 31 * hashCode + Arrays.hashCode(atypes);
        Integer boxed = hashCode;
        if (!CIF_MAP.containsKey(boxed)) {
            synchronized (CIF_MAP) {
                if (!CIF_MAP.containsKey(boxed)) {
                    long handle = allocateFFICIF();
                    if (handle == 0L) throw new IllegalStateException("Failed to initialize FFI CIF");
                    long allocated = Memory.allocate(ntotalargs * Memory.ADDRESS_SIZE);
                    for (int i = 0; i < ntotalargs; i ++) {
                        Memory.putAddress(allocated + Memory.ADDRESS_SIZE * i, atypes[i].handle);
                    }
                    int result;
                    if (nfixedargs == ntotalargs) result = initializeFFICIF(handle, rtype.handle, allocated, ntotalargs);
                    else result = initializeFFICIFVariadic(handle, rtype.handle, allocated, nfixedargs, ntotalargs);
                    if (result != 0) {
                        Memory.free(allocated);
                        throw new IllegalStateException("Failed to initialize FFI CIF");
                    }
                    CIF_MAP.put(boxed, new FFICallContext(handle, rtype, atypes));
                }
            }
        }
        return CIF_MAP.get(boxed);
    }
    public static FFICallContext of(FFIType rtype, FFIType[] atypes, int nfixedargs, int ntotalargs) {
        return of(rtype, atypes, 0, nfixedargs, ntotalargs);
    }
    public static FFICallContext of(FFIType rtype, FFIType[] atypes, int nfixedargs) {
        return of(rtype, atypes, 0, nfixedargs, atypes.length);
    }
    public static FFICallContext of(FFIType rtype, FFIType... atypes) {
        return of(rtype, atypes, 0, -1, atypes.length);
    }

    private static native long allocateFFICIF();
    private static native int initializeFFICIF(long cif, long rtype, long atypes, int nargs);
    private static native int initializeFFICIFVariadic(long cif, long rtype, long atypes, int nfixedargs, int ntotalargs);

    final long handle;
    final FFIType rtype;
    final FFIType[] atypes;

    private FFICallContext(long handle, FFIType rtype, FFIType[] atypes) {
        this.handle = handle;
        this.rtype = rtype;
        this.atypes = atypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FFICallContext cif = (FFICallContext) o;
        return handle == cif.handle;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(handle);
    }
    
}
