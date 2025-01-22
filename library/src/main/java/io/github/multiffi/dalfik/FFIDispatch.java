package io.github.multiffi.dalfik;

import java.nio.Buffer;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

public final class FFIDispatch {

    private FFIDispatch() {
        throw new AssertionError("No io.github.multiffi.dalfik.FFIDispatch instances for you!");
    }

    static {
        System.loadLibrary("dalfik");
    }

    private static native void call(long cif, long fn, long rvalue, long avalues);
    @FastNative
    private static native void fastCall(long cif, long fn, long rvalue, long avalues);
    @CriticalNative
    private static native void criticalCall(long cif, long fn, long rvalue, long avalues);

    private static final ThreadLocal<Long> CALL_STACK = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return Memory.allocate(4096);
        }
    };

    public static Object call(FFICallContext context, long function, Object... args) {
        FFIType rtype = context.rtype;
        long rvalue = CALL_STACK.get();
        long avalues = rvalue + context.rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = rtype.compound ? 1 : 0; i < context.atypes.length; i ++) {
                Object arg = args[i];
                FFIType atype = context.atypes[i];
                Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                if (atype == FFIType.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                else if (atype == FFIType.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                else if (atype == FFIType.SINT32) Memory.putInt(avalue, ((Number) arg).intValue());
                else if (atype == FFIType.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                else if (atype == FFIType.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                else if (atype == FFIType.POINTER) Memory.putAddress(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                else if (atype == FFIType.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.SIZE) Memory.putSize(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.WCHAR) Memory.putWChar(avalue, ((Number) arg).intValue());
                else Memory.putDirectBuffer(avalue, (Buffer) arg, (int) atype.size);
                avalue += atype.size;
            }
            call(context.handle, function, rvalue, avalues);
        }

        if (rtype == FFIType.SINT8) return Memory.getByte(rvalue);
        else if (rtype == FFIType.SINT16) return Memory.getShort(rvalue);
        else if (rtype == FFIType.SINT32) return Memory.getInt(rvalue);
        else if (rtype == FFIType.SINT64) return Memory.getLong(rvalue);
        else if (rtype == FFIType.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == FFIType.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == FFIType.POINTER) return Memory.getAddress(rvalue);
        else if (rtype == FFIType.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == FFIType.LONG) return Memory.getNativeLong(rvalue);
        else if (rtype == FFIType.SIZE) return Memory.getSize(rvalue);
        else if (rtype == FFIType.WCHAR) return Memory.getWChar(rvalue);
        else {
            Object arg = args[0];
            Memory.getDirectBuffer(rvalue, (Buffer) arg, (int) rtype.size);
            return arg;
        }
    }

    public static Object fastCall(FFICallContext context, long function, Object... args) {
        FFIType rtype = context.rtype;
        long rvalue = CALL_STACK.get();
        long avalues = rvalue + context.rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = rtype.compound ? 1 : 0; i < context.atypes.length; i ++) {
                Object arg = args[i];
                FFIType atype = context.atypes[i];
                Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                if (atype == FFIType.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                else if (atype == FFIType.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                else if (atype == FFIType.SINT32) Memory.putInt(avalue, ((Number) arg).intValue());
                else if (atype == FFIType.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                else if (atype == FFIType.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                else if (atype == FFIType.POINTER) Memory.putAddress(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                else if (atype == FFIType.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.SIZE) Memory.putSize(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.WCHAR) Memory.putWChar(avalue, ((Number) arg).intValue());
                else Memory.putDirectBuffer(avalue, (Buffer) arg, (int) atype.size);
                avalue += atype.size;
            }
            fastCall(context.handle, function, rvalue, avalues);
        }

        if (rtype == FFIType.SINT8) return Memory.getByte(rvalue);
        else if (rtype == FFIType.SINT16) return Memory.getShort(rvalue);
        else if (rtype == FFIType.SINT32) return Memory.getInt(rvalue);
        else if (rtype == FFIType.SINT64) return Memory.getLong(rvalue);
        else if (rtype == FFIType.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == FFIType.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == FFIType.POINTER) return Memory.getAddress(rvalue);
        else if (rtype == FFIType.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == FFIType.LONG) return Memory.getNativeLong(rvalue);
        else if (rtype == FFIType.SIZE) return Memory.getSize(rvalue);
        else if (rtype == FFIType.WCHAR) return Memory.getWChar(rvalue);
        else {
            Object arg = args[0];
            Memory.getDirectBuffer(rvalue, (Buffer) arg, (int) rtype.size);
            return arg;
        }
    }

    public static Object criticalCall(FFICallContext context, long function, Object... args) {
        FFIType rtype = context.rtype;
        long rvalue = CALL_STACK.get();
        long avalues = rvalue + context.rtype.size;
        if (context.atypes != null) {
            long avalue = avalues + context.atypes.length * Memory.ADDRESS_SIZE;
            for (int i = rtype.compound ? 1 : 0; i < context.atypes.length; i ++) {
                Object arg = args[i];
                FFIType atype = context.atypes[i];
                Memory.putAddress(avalues + Memory.ADDRESS_SIZE * i, avalue);
                if (atype == FFIType.SINT8) Memory.putByte(avalue, ((Number) arg).byteValue());
                else if (atype == FFIType.SINT16) Memory.putShort(avalue, ((Number) arg).shortValue());
                else if (atype == FFIType.SINT32) Memory.putInt(avalue, ((Number) arg).intValue());
                else if (atype == FFIType.SINT64) Memory.putLong(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.FLOAT) Memory.putFloat(avalue, ((Number) arg).floatValue());
                else if (atype == FFIType.DOUBLE) Memory.putDouble(avalue, ((Number) arg).doubleValue());
                else if (atype == FFIType.POINTER) Memory.putAddress(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.BOOLEAN) Memory.putAddress(avalue, ((Boolean) arg) ? 1L : 0L);
                else if (atype == FFIType.LONG) Memory.putNativeLong(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.SIZE) Memory.putSize(avalue, ((Number) arg).longValue());
                else if (atype == FFIType.WCHAR) Memory.putWChar(avalue, ((Number) arg).intValue());
                else Memory.putDirectBuffer(avalue, (Buffer) arg, (int) atype.size);
                avalue += atype.size;
            }
            criticalCall(context.handle, function, rvalue, avalues);
        }

        if (rtype == FFIType.SINT8) return Memory.getByte(rvalue);
        else if (rtype == FFIType.SINT16) return Memory.getShort(rvalue);
        else if (rtype == FFIType.SINT32) return Memory.getInt(rvalue);
        else if (rtype == FFIType.SINT64) return Memory.getLong(rvalue);
        else if (rtype == FFIType.FLOAT) return Memory.getFloat(rvalue);
        else if (rtype == FFIType.DOUBLE) return Memory.getDouble(rvalue);
        else if (rtype == FFIType.POINTER) return Memory.getAddress(rvalue);
        else if (rtype == FFIType.BOOLEAN) return Memory.getAddress(rvalue) != 0;
        else if (rtype == FFIType.LONG) return Memory.getNativeLong(rvalue);
        else if (rtype == FFIType.SIZE) return Memory.getSize(rvalue);
        else if (rtype == FFIType.WCHAR) return Memory.getWChar(rvalue);
        else {
            Object arg = args[0];
            Memory.getDirectBuffer(rvalue, (Buffer) arg, (int) rtype.size);
            return arg;
        }
    }

}
