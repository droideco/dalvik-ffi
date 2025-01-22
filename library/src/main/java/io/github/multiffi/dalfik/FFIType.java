package io.github.multiffi.dalfik;

import java.util.HashMap;
import java.util.Map;

import dalvik.annotation.optimization.CriticalNative;

public final class FFIType {

    static {
        System.loadLibrary("dalfik");
    }

    private static final Map<Integer, FFIType> SINT8_ARRAY_MAP = new HashMap<>();
    public static FFIType of(int size) {
        Integer boxed = size;
        if (!SINT8_ARRAY_MAP.containsKey(boxed)) {
            synchronized (SINT8_ARRAY_MAP) {
                if (!SINT8_ARRAY_MAP.containsKey(boxed)) {
                    long handle = allocateFFITypeSInt8Array(size & 0xFFFFFFFFL);
                    if (handle == 0L) throw new IllegalStateException("Failed to initialize FFI Type");
                    SINT8_ARRAY_MAP.put(boxed, new FFIType(handle, Integer.toUnsignedLong(size), true));
                }
            }
        }
        return SINT8_ARRAY_MAP.get(boxed);
    }

    public static final FFIType VOID = new FFIType(getFFITypeVoid(), 0);
    public static final FFIType SINT8 = new FFIType(getFFITypeSInt8(), 1);
    public static final FFIType SINT16 = new FFIType(getFFITypeSInt16(), 2);
    public static final FFIType SINT32 = new FFIType(getFFITypeSInt32(), 4);
    public static final FFIType SINT64 = new FFIType(getFFITypeSInt64(), 8);
    public static final FFIType FLOAT = new FFIType(getFFITypeFloat(), 4);
    public static final FFIType DOUBLE = new FFIType(getFFITypeDouble(), 8);
    public static final FFIType POINTER = new FFIType(getFFITypePointer(), Memory.ADDRESS_SIZE);
    public static final FFIType BOOLEAN = new FFIType(POINTER.handle, POINTER.size);
    public static final FFIType LONG = new FFIType((Memory.NATIVE_LONG_SIZE == 4L ? SINT32 : SINT64).handle, Memory.NATIVE_LONG_SIZE);
    public static final FFIType SIZE = new FFIType((Memory.DIFF_SIZE == 4L ? SINT32 : SINT64).handle, Memory.DIFF_SIZE);
    public static final FFIType WCHAR = new FFIType(SINT32.handle, SINT32.size);

    @CriticalNative
    private static native long getFFITypeVoid();
    @CriticalNative
    private static native long getFFITypeSInt8();
    @CriticalNative
    private static native long getFFITypeSInt16();
    @CriticalNative
    private static native long getFFITypeSInt32();
    @CriticalNative
    private static native long getFFITypeSInt64();
    @CriticalNative
    private static native long getFFITypeFloat();
    @CriticalNative
    private static native long getFFITypeDouble();
    @CriticalNative
    private static native long getFFITypePointer();

    private static native long allocateFFITypeSInt8Array(long size);

    final long handle;
    final long size;
    final boolean compound;

    private FFIType(long handle, long size) {
        this(handle, size, false);
    }

    private FFIType(long handle, long size, boolean compound) {
        this.handle = handle;
        this.size = size;
        this.compound = compound;
    }

    public boolean isCompound() {
        return compound;
    }

    public boolean isScalar() {
        return !compound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FFIType type = (FFIType) o;
        return handle == type.handle;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(handle);
    }

}
