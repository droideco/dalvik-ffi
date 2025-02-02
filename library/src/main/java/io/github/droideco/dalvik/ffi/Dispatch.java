package io.github.droideco.dalvik.ffi;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

public final class Dispatch {

    private Dispatch() {
        throw new AssertionError("No io.github.droideco.dalvik.ffi.Dispatch instances for you!");
    }

    static {
        System.loadLibrary("dalvikffi");
    }

    private static native void nCall(long cif, long fn, long rvalue, long avalues);
    @FastNative
    private static native void nFastCall(long cif, long fn, long rvalue, long avalues);
    @CriticalNative
    private static native void nCriticalCall(long cif, long fn, long rvalue, long avalues);

    public static void rawCall(CallContext context, long function, long rvalue, long avalues) {
        nCall(context.handle, function, rvalue, avalues);
    }

    public static void rawFastCall(CallContext context, long function, long rvalue, long avalues) {
        nFastCall(context.handle, function, rvalue, avalues);
    }

    public static void rawCriticalCall(CallContext context, long function, long rvalue, long avalues) {
        nCriticalCall(context.handle, function, rvalue, avalues);
    }

    public static Object call(CallContext context, long function, Object... args) {
        Type rtype = context.rtype;
        long rvalue = Memory.BUFFER.get();
        Memory.putAddress(rvalue, 0L);
        long avalues;
        if (rtype.compound) avalues = rvalue + Memory.ADDRESS_SIZE;
        else avalues = rvalue + rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = 0; i < context.atypes.length; i ++) {
                Object arg = args[i + (rtype.compound ? 1 : 0)];
                Type atype = context.atypes[i];
                if (atype.compound) Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, (long) arg);
                else {
                    Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                    if (atype == Type.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                    else if (atype == Type.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                    else if (atype == Type.JCHAR) Memory.putChar(avalue, (Character) arg);
                    else if (atype == Type.SINT32 || atype == Type.WCHAR) Memory.putInt(avalue, ((Number) arg).intValue());
                    else if (atype == Type.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                    else if (atype == Type.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                    else if (atype == Type.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                    else if (atype == Type.POINTER || atype == Type.SIZE) Memory.putAddress(avalue, ((Number) arg).longValue());
                    else if (atype == Type.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                    else if (atype == Type.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                    avalue += atype.size;
                }
            }
        }
        nCall(context.handle, function, rvalue, avalues);

        if (rtype == Type.VOID) return null;
        else if (rtype == Type.SINT8) return Memory.getByte(rvalue);
        else if (rtype == Type.SINT16) return Memory.getShort(rvalue);
        else if (rtype == Type.JCHAR) return Memory.getChar(rvalue);
        else if (rtype == Type.SINT32 || rtype == Type.WCHAR) return Memory.getInt(rvalue);
        else if (rtype == Type.SINT64) return Memory.getLong(rvalue);
        else if (rtype == Type.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == Type.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == Type.POINTER || rtype == Type.SIZE) return Memory.getAddress(rvalue);
        else if (rtype == Type.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == Type.LONG) return Memory.getNativeLong(rvalue);
        else {
            long arg = (long) args[0];
            Memory.copy(arg, Memory.getAddress(rvalue), rtype.size);
            return arg;
        }
    }

    public static Object fastCall(CallContext context, long function, Object... args) {
        Type rtype = context.rtype;
        long rvalue = Memory.BUFFER.get();
        Memory.putAddress(rvalue, 0L);
        long avalues;
        if (rtype.compound) avalues = rvalue + Memory.ADDRESS_SIZE;
        else avalues = rvalue + rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = 0; i < context.atypes.length; i ++) {
                Object arg = args[i + (rtype.compound ? 1 : 0)];
                Type atype = context.atypes[i];
                if (atype.compound) Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, (long) arg);
                else {
                    Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                    if (atype == Type.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                    else if (atype == Type.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                    else if (atype == Type.JCHAR) Memory.putChar(avalue, (Character) arg);
                    else if (atype == Type.SINT32 || atype == Type.WCHAR) Memory.putInt(avalue, ((Number) arg).intValue());
                    else if (atype == Type.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                    else if (atype == Type.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                    else if (atype == Type.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                    else if (atype == Type.POINTER || atype == Type.SIZE) Memory.putAddress(avalue, ((Number) arg).longValue());
                    else if (atype == Type.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                    else if (atype == Type.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                    avalue += atype.size;
                }
            }
        }
        nFastCall(context.handle, function, rvalue, avalues);

        if (rtype == Type.VOID) return null;
        else if (rtype == Type.SINT8) return Memory.getByte(rvalue);
        else if (rtype == Type.SINT16) return Memory.getShort(rvalue);
        else if (rtype == Type.JCHAR) return Memory.getChar(rvalue);
        else if (rtype == Type.SINT32 || rtype == Type.WCHAR) return Memory.getInt(rvalue);
        else if (rtype == Type.SINT64) return Memory.getLong(rvalue);
        else if (rtype == Type.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == Type.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == Type.POINTER || rtype == Type.SIZE) return Memory.getAddress(rvalue);
        else if (rtype == Type.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == Type.LONG) return Memory.getNativeLong(rvalue);
        else {
            long arg = (long) args[0];
            Memory.copy(arg, Memory.getAddress(rvalue), rtype.size);
            return arg;
        }
    }

    public static Object criticalCall(CallContext context, long function, Object... args) {
        Type rtype = context.rtype;
        long rvalue = Memory.BUFFER.get();
        Memory.putAddress(rvalue, 0L);
        long avalues;
        if (rtype.compound) avalues = rvalue + Memory.ADDRESS_SIZE;
        else avalues = rvalue + rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = 0; i < context.atypes.length; i ++) {
                Object arg = args[i + (rtype.compound ? 1 : 0)];
                Type atype = context.atypes[i];
                if (atype.compound) Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, (long) arg);
                else {
                    Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                    if (atype == Type.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                    else if (atype == Type.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                    else if (atype == Type.JCHAR) Memory.putChar(avalue, (Character) arg);
                    else if (atype == Type.SINT32 || atype == Type.WCHAR) Memory.putInt(avalue, ((Number) arg).intValue());
                    else if (atype == Type.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                    else if (atype == Type.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                    else if (atype == Type.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                    else if (atype == Type.POINTER || atype == Type.SIZE) Memory.putAddress(avalue, ((Number) arg).longValue());
                    else if (atype == Type.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                    else if (atype == Type.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                    avalue += atype.size;
                }
            }
        }
        nCriticalCall(context.handle, function, rvalue, avalues);

        if (rtype == Type.VOID) return null;
        else if (rtype == Type.SINT8) return Memory.getByte(rvalue);
        else if (rtype == Type.SINT16) return Memory.getShort(rvalue);
        else if (rtype == Type.JCHAR) return Memory.getChar(rvalue);
        else if (rtype == Type.SINT32 || rtype == Type.WCHAR) return Memory.getInt(rvalue);
        else if (rtype == Type.SINT64) return Memory.getLong(rvalue);
        else if (rtype == Type.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == Type.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == Type.POINTER || rtype == Type.SIZE) return Memory.getAddress(rvalue);
        else if (rtype == Type.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == Type.LONG) return Memory.getNativeLong(rvalue);
        else {
            long arg = (long) args[0];
            Memory.copy(arg, Memory.getAddress(rvalue), rtype.size);
            return arg;
        }
    }

}
