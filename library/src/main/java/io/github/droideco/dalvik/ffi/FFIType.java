package io.github.droideco.dalvik.ffi;

import java.util.Map;
import java.util.WeakHashMap;

import dalvik.annotation.optimization.CriticalNative;

public final class FFIType {

    static {
        System.loadLibrary("dalvikffi");
    }

    private static final Map<Integer, FFIType> SINT8_ARRAY_MAP = new WeakHashMap<>();
    public static FFIType ofSize(int size) {
        Integer boxed = size;
        if (!SINT8_ARRAY_MAP.containsKey(boxed)) {
            synchronized (SINT8_ARRAY_MAP) {
                if (!SINT8_ARRAY_MAP.containsKey(boxed)) {
                    long count = size & 0xFFFFFFFFL;
                    long elements = Memory.allocateInitialized(count + 1, Memory.ADDRESS_SIZE);
                    if (elements == 0L) throw new IllegalStateException("Failed to initialize ffi_type");
                    for (long i = 0; i < count; i ++) {
                        Memory.putAddress(elements + i * Memory.ADDRESS_SIZE, SINT8.handle);
                    }
                    long handle = nAllocateFFITypeSInt8Array(count, elements);
                    if (handle == 0L) {
                        Memory.free(elements);
                        throw new IllegalStateException("Failed to initialize ffi_type");
                    }
                    SINT8_ARRAY_MAP.put(boxed, new FFIType(handle, Integer.toUnsignedLong(size), elements));
                }
            }
        }
        return SINT8_ARRAY_MAP.get(boxed);
    }

    public static final FFIType VOID = new FFIType(nGetFFITypeVoid(), 0);
    public static final FFIType SINT8 = new FFIType(nGetFFITypeSInt8(), 1);
    public static final FFIType SINT16 = new FFIType(nGetFFITypeSInt16(), 2);
    public static final FFIType JCHAR = new FFIType(nGetFFITypeUInt16(), 2);
    public static final FFIType SINT32 = new FFIType(nGetFFITypeSInt32(), 4);
    public static final FFIType SINT64 = new FFIType(nGetFFITypeSInt64(), 8);
    public static final FFIType FLOAT = new FFIType(nGetFFITypeFloat(), 4);
    public static final FFIType DOUBLE = new FFIType(nGetFFITypeDouble(), 8);
    public static final FFIType POINTER = new FFIType(nGetFFITypePointer(), Memory.ADDRESS_SIZE);
    public static final FFIType LONG = new FFIType((Memory.NATIVE_LONG_SIZE == 4L ? SINT32 : SINT64).handle, Memory.NATIVE_LONG_SIZE);
    public static final FFIType SIZE = new FFIType((Memory.ADDRESS_SIZE == 4L ? SINT32 : SINT64).handle, Memory.ADDRESS_SIZE);
    public static final FFIType BOOLEAN = new FFIType(SIZE.handle, SIZE.size);
    public static final FFIType WCHAR = new FFIType(SINT32.handle, SINT32.size);

    @CriticalNative
    private static native long nGetFFITypeVoid();
    @CriticalNative
    private static native long nGetFFITypeSInt8();
    @CriticalNative
    private static native long nGetFFITypeSInt16();
    @CriticalNative
    private static native long nGetFFITypeUInt16();
    @CriticalNative
    private static native long nGetFFITypeSInt32();
    @CriticalNative
    private static native long nGetFFITypeSInt64();
    @CriticalNative
    private static native long nGetFFITypeFloat();
    @CriticalNative
    private static native long nGetFFITypeDouble();
    @CriticalNative
    private static native long nGetFFITypePointer();

    private static native long nAllocateFFITypeSInt8Array(long size, long elements);

    final long handle;
    private final long elements;
    final long size;
    final boolean compound;

    private FFIType(long handle, long size) {
        this(handle, size, 0);
    }

    private FFIType(long handle, long size, long elements) {
        this.handle = handle;
        this.size = size;
        this.elements = elements;
        compound = elements != 0L;
    }

    public int size() {
        return (int) size;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            Memory.free(handle);
            Memory.free(elements);
        }
        finally {
            super.finalize();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FFIType type = (FFIType) o;
        return size == type.size;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(handle);
    }

}
