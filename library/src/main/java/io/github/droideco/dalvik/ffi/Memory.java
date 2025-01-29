package io.github.droideco.dalvik.ffi;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

public final class Memory {

    private Memory() {
        throw new AssertionError("No io.github.droideco.dalvik.ffi.Memory instances for you!");
    }

    static {
        System.loadLibrary("dalvikffi");
    }

    static final ThreadLocal<Long> BUFFER = new ThreadLocal<>() {
        @Override
        protected Long initialValue() {
            return Memory.allocate(4096);
        }
    };

    public static long addressSize() {
        return ADDRESS_SIZE;
    }
    public static long nativeLongSize() {
        return NATIVE_LONG_SIZE;
    }

    static final long ADDRESS_SIZE = nAddressSize();
    static final long NATIVE_LONG_SIZE = nNativeLongSize();

    @CriticalNative
    private static native long nAddressSize();
    @CriticalNative
    private static native long nNativeLongSize();

    public static native long allocate(long size);
    public static native long allocateInitialized(long count, long size);
    public static native long reallocate(long address, long size);
    public static native void free(long address);
    public static native long fill(long address, int value, long size);
    public static long fill(long address, byte value, long size) {
        return fill(address, value & 0xFF, size);
    }
    public static native int compare(long aAddress, long bAddress, long size);
    public static native long copy(long destAddress, long srcAddress, long size);
    public static native long copyOverlapped(long destAddress, long srcAddress, long size);

    private interface Int64Adapter {
        long get(long address);
        void put(long address, long newValue);
        Int64Adapter SIZE32 = new Int64Adapter() {
            @Override
            public long get(long address) {
                return getInt(address) & 0xFFFFFFFFL;
            }
            @Override
            public void put(long address, long newValue) {
                putInt(address, (int) newValue);
            }
        };
        Int64Adapter SIZE64 = new Int64Adapter() {
            @Override
            public long get(long address) {
                return getLong(address);
            }
            @Override
            public void put(long address, long newValue) {
                putLong(address, newValue);
            }
        };
        Int64Adapter ADDRESS = ADDRESS_SIZE == 8L ? SIZE64 : SIZE32;
        Int64Adapter NATIVE_LONG = NATIVE_LONG_SIZE == 8L ? SIZE64 : SIZE32;
    }

    @FastNative
    public static native void putByte(long address, byte value);
    @FastNative
    public static native void putChar(long address, char value);
    @FastNative
    public static native void putShort(long address, short value);
    @FastNative
    public static native void putInt(long address, int value);
    @FastNative
    public static native void putLong(long address, long value);
    @FastNative
    public static native void putFloat(long address, float value);
    @FastNative
    public static native void putDouble(long address, double value);
    public static void putAddress(long address, long value) {
        Int64Adapter.ADDRESS.put(address, value);
    }
    public static void putNativeLong(long address, long value) {
        Int64Adapter.NATIVE_LONG.put(address, value);
    }

    @FastNative
    public static native byte getByte(long address);
    @FastNative
    public static native char getChar(long address);
    @FastNative
    public static native short getShort(long address);
    @FastNative
    public static native int getInt(long address);
    @FastNative
    public static native long getLong(long address);
    @FastNative
    public static native float getFloat(long address);
    @FastNative
    public static native double getDouble(long address);
    public static long getAddress(long address) {
        return Int64Adapter.ADDRESS.get(address);
    }
    public static long getNativeLong(long address) {
        return Int64Adapter.NATIVE_LONG.get(address);
    }

}
