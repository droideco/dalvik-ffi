package io.github.droideco.dalvik.ffi;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

public final class FFIDispatch {

    private FFIDispatch() {
        throw new AssertionError("No io.github.droideco.dalvik.ffi.FFIDispatch instances for you!");
    }

    static {
        System.loadLibrary("dalvikffi");
    }

    private static native void nCall(long cif, long fn, long rvalue, long avalues);
    @FastNative
    private static native void nFastCall(long cif, long fn, long rvalue, long avalues);
    @CriticalNative
    private static native void nCriticalCall(long cif, long fn, long rvalue, long avalues);

    public static Object call(FFICallContext context, long function, Object... args) {
        FFIType rtype = context.rtype;
        long rvalue = Memory.BUFFER.get();
        long avalues;
        if (rtype.compound) avalues = rvalue + Memory.ADDRESS_SIZE;
        else avalues = rvalue + rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = 0; i < context.atypes.length; i ++) {
                Object arg = args[i + (rtype.compound ? 1 : 0)];
                FFIType atype = context.atypes[i];
                if (atype.compound) Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, (long) arg);
                else {
                    Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                    if (atype == FFIType.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                    else if (atype == FFIType.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                    else if (atype == FFIType.JCHAR) Memory.putChar(avalue, (Character) arg);
                    else if (atype == FFIType.SINT32 || atype == FFIType.WCHAR) Memory.putInt(avalue, ((Number) arg).intValue());
                    else if (atype == FFIType.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                    else if (atype == FFIType.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                    else if (atype == FFIType.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                    else if (atype == FFIType.POINTER || atype == FFIType.SIZE) Memory.putAddress(avalue, ((Number) arg).longValue());
                    else if (atype == FFIType.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                    else if (atype == FFIType.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                    avalue += atype.size;
                }
            }
            nCall(context.handle, function, rvalue, avalues);
        }

        if (rtype == FFIType.VOID) return null;
        else if (rtype == FFIType.SINT8) return Memory.getByte(rvalue);
        else if (rtype == FFIType.SINT16) return Memory.getShort(rvalue);
        else if (rtype == FFIType.JCHAR) return Memory.getChar(rvalue);
        else if (rtype == FFIType.SINT32 || rtype == FFIType.WCHAR) return Memory.getInt(rvalue);
        else if (rtype == FFIType.SINT64) return Memory.getLong(rvalue);
        else if (rtype == FFIType.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == FFIType.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == FFIType.POINTER || rtype == FFIType.SIZE) return Memory.getAddress(rvalue);
        else if (rtype == FFIType.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == FFIType.LONG) return Memory.getNativeLong(rvalue);
        else {
            long arg = (long) args[0];
            Memory.copy(arg, Memory.getAddress(rvalue), rtype.size);
            return arg;
        }
    }

    public static Object fastCall(FFICallContext context, long function, Object... args) {
        FFIType rtype = context.rtype;
        long rvalue = Memory.BUFFER.get();
        long avalues;
        if (rtype.compound) avalues = rvalue + Memory.ADDRESS_SIZE;
        else avalues = rvalue + rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = 0; i < context.atypes.length; i ++) {
                Object arg = args[i + (rtype.compound ? 1 : 0)];
                FFIType atype = context.atypes[i];
                if (atype.compound) Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, (long) arg);
                else {
                    Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                    if (atype == FFIType.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                    else if (atype == FFIType.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                    else if (atype == FFIType.JCHAR) Memory.putChar(avalue, (Character) arg);
                    else if (atype == FFIType.SINT32 || atype == FFIType.WCHAR) Memory.putInt(avalue, ((Number) arg).intValue());
                    else if (atype == FFIType.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                    else if (atype == FFIType.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                    else if (atype == FFIType.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                    else if (atype == FFIType.POINTER || atype == FFIType.SIZE) Memory.putAddress(avalue, ((Number) arg).longValue());
                    else if (atype == FFIType.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                    else if (atype == FFIType.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                    avalue += atype.size;
                }
            }
            nFastCall(context.handle, function, rvalue, avalues);
        }

        if (rtype == FFIType.VOID) return null;
        else if (rtype == FFIType.SINT8) return Memory.getByte(rvalue);
        else if (rtype == FFIType.SINT16) return Memory.getShort(rvalue);
        else if (rtype == FFIType.JCHAR) return Memory.getChar(rvalue);
        else if (rtype == FFIType.SINT32 || rtype == FFIType.WCHAR) return Memory.getInt(rvalue);
        else if (rtype == FFIType.SINT64) return Memory.getLong(rvalue);
        else if (rtype == FFIType.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == FFIType.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == FFIType.POINTER || rtype == FFIType.SIZE) return Memory.getAddress(rvalue);
        else if (rtype == FFIType.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == FFIType.LONG) return Memory.getNativeLong(rvalue);
        else {
            long arg = (long) args[0];
            Memory.copy(arg, Memory.getAddress(rvalue), rtype.size);
            return arg;
        }
    }

    public static Object criticalCall(FFICallContext context, long function, Object... args) {
        FFIType rtype = context.rtype;
        long rvalue = Memory.BUFFER.get();
        long avalues;
        if (rtype.compound) avalues = rvalue + Memory.ADDRESS_SIZE;
        else avalues = rvalue + rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = 0; i < context.atypes.length; i ++) {
                Object arg = args[i + (rtype.compound ? 1 : 0)];
                FFIType atype = context.atypes[i];
                if (atype.compound) Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, (long) arg);
                else {
                    Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                    if (atype == FFIType.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                    else if (atype == FFIType.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                    else if (atype == FFIType.JCHAR) Memory.putChar(avalue, (Character) arg);
                    else if (atype == FFIType.SINT32 || atype == FFIType.WCHAR) Memory.putInt(avalue, ((Number) arg).intValue());
                    else if (atype == FFIType.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                    else if (atype == FFIType.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                    else if (atype == FFIType.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                    else if (atype == FFIType.POINTER || atype == FFIType.SIZE) Memory.putAddress(avalue, ((Number) arg).longValue());
                    else if (atype == FFIType.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                    else if (atype == FFIType.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                    avalue += atype.size;
                }
            }
            nCriticalCall(context.handle, function, rvalue, avalues);
        }

        if (rtype == FFIType.VOID) return null;
        else if (rtype == FFIType.SINT8) return Memory.getByte(rvalue);
        else if (rtype == FFIType.SINT16) return Memory.getShort(rvalue);
        else if (rtype == FFIType.JCHAR) return Memory.getChar(rvalue);
        else if (rtype == FFIType.SINT32 || rtype == FFIType.WCHAR) return Memory.getInt(rvalue);
        else if (rtype == FFIType.SINT64) return Memory.getLong(rvalue);
        else if (rtype == FFIType.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == FFIType.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == FFIType.POINTER || rtype == FFIType.SIZE) return Memory.getAddress(rvalue);
        else if (rtype == FFIType.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == FFIType.LONG) return Memory.getNativeLong(rvalue);
        else {
            long arg = (long) args[0];
            Memory.copy(arg, Memory.getAddress(rvalue), rtype.size);
            return arg;
        }
    }

}
