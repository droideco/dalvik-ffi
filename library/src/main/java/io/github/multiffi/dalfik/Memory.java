package io.github.multiffi.dalfik;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import dalvik.annotation.optimization.CriticalNative;

public final class Memory {

    private Memory() {
        throw new AssertionError("No io.github.multiffi.dalfik.Memory instances for you!");
    }

    @FunctionalInterface
    private interface LongUnaryOperator {
        long applyAsLong(long operand);
    }

    @FunctionalInterface
    private interface LongLongConsumer {
        void accept(long first, long second);
    }

    static {
        System.loadLibrary("dalfik");
    }

    public static long addressSize() {
        return ADDRESS_SIZE;
    }
    public static long diffSize() {
        return DIFF_SIZE;
    }
    public static long nativeLongSize() {
        return NATIVE_LONG_SIZE;
    }
    public static long wcharSize() {
        return WCHAR_SIZE;
    }
    public static long pageSize() {
        return PAGE_SIZE;
    }
    public static long alignSize() {
        return ADDRESS_SIZE;
    }

    static final long ADDRESS_SIZE = sizeOfAddress();
    static final long WCHAR_SIZE = sizeOfWChar();
    static final long DIFF_SIZE = sizeOfDiff();
    static final long NATIVE_LONG_SIZE = sizeOfNativeLong();

    static final long PAGE_SIZE = getPageSize();

    @CriticalNative
    private static native long sizeOfAddress();
    @CriticalNative
    private static native long sizeOfWChar();
    @CriticalNative
    private static native long sizeOfDiff();
    @CriticalNative
    private static native long sizeOfNativeLong();

    private static native long getPageSize();

    public static native long getDirectBufferAddress(Buffer buffer);
    public static native ByteBuffer newDirectByteBuffer(long address, long capacity);
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

    @CriticalNative
    public static native void putBoolean(long address, boolean value);
    @CriticalNative
    public static native void putByte(long address, byte value);
    @CriticalNative
    public static native void putChar(long address, char value);
    @CriticalNative
    public static native void putShort(long address, short value);
    @CriticalNative
    public static native void putInt(long address, int value);
    @CriticalNative
    public static native void putLong(long address, long value);
    @CriticalNative
    public static native void putFloat(long address, float value);
    @CriticalNative
    public static native void putDouble(long address, double value);
    @CriticalNative
    public static native void putAddress(long address, long value);
    @CriticalNative
    public static native void putSize(long address, long value);
    @CriticalNative
    public static native void putWChar(long address, int value);
    private static final LongLongConsumer putNativeLongFunction;
    static {
        if (NATIVE_LONG_SIZE == 4L) putNativeLongFunction = (address, value) -> putInt(address, (int) value);
        else putNativeLongFunction = Memory::putLong;
    }
    public static void putNativeLong(long address, long value) {
        putNativeLongFunction.accept(address, value);
    }
    private static native void putDirectBuffer(long address, Buffer buffer, int position, int size);
    public static void putDirectBuffer(long address, Buffer buffer, int size) {
        if (!buffer.isDirect()) throw new IllegalArgumentException("buffer is non-direct");
        else if (size < buffer.remaining()) throw new IndexOutOfBoundsException("Index out of range: " + size);
        putDirectBuffer(address, buffer, buffer.position(), size);
    }

    @CriticalNative
    public static native boolean getBoolean(long address);
    @CriticalNative
    public static native byte getByte(long address);
    @CriticalNative
    public static native char getChar(long address);
    @CriticalNative
    public static native short getShort(long address);
    @CriticalNative
    public static native int getInt(long address);
    @CriticalNative
    public static native long getLong(long address);
    @CriticalNative
    public static native float getFloat(long address);
    @CriticalNative
    public static native double getDouble(long address);
    @CriticalNative
    public static native long getAddress(long address);
    @CriticalNative
    public static native long getSize(long address);
    @CriticalNative
    public static native int getWChar(long address);
    private static final LongUnaryOperator getNativeLongFunction;
    static {
        if (NATIVE_LONG_SIZE == 4L) getNativeLongFunction = (address) -> getInt(address) & 0xFFFFFFFFL;
        else getNativeLongFunction = Memory::getLong;
    }
    public static long getNativeLong(long address) {
        return getNativeLongFunction.applyAsLong(address);
    }
    private static native void getDirectBuffer(long address, Buffer buffer, int position, int size);
    public static void getDirectBuffer(long address, Buffer buffer, int size) {
        if (!buffer.isDirect()) throw new IllegalArgumentException("buffer is non-direct");
        else if (size < buffer.remaining()) throw new IndexOutOfBoundsException("Index out of range: " + size);
        getDirectBuffer(address, buffer, buffer.position(), size);
    }

}
