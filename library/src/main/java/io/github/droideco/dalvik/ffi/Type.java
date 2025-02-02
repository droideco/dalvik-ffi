package io.github.droideco.dalvik.ffi;

import java.util.Map;
import java.util.WeakHashMap;

import dalvik.annotation.optimization.CriticalNative;

public final class Type {

    static {
        System.loadLibrary("dalvikffi");
    }

    private static final Map<Integer, Type> SINT8_ARRAY_MAP = new WeakHashMap<>();
    public static Type ofSize(int size) {
        Integer boxed = size;
        if (!SINT8_ARRAY_MAP.containsKey(boxed)) {
            synchronized (SINT8_ARRAY_MAP) {
                if (!SINT8_ARRAY_MAP.containsKey(boxed)) {
                    long count = Integer.toUnsignedLong(size);
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
                    SINT8_ARRAY_MAP.put(boxed, new Type(handle, count, elements));
                }
            }
        }
        return SINT8_ARRAY_MAP.get(boxed);
    }

    public static final Type VOID = new Type(nGetFFITypeVoid(), 0);
    public static final Type SINT8 = new Type(nGetFFITypeSInt8(), 1);
    public static final Type SINT16 = new Type(nGetFFITypeSInt16(), 2);
    public static final Type JCHAR = new Type(nGetFFITypeUInt16(), 2);
    public static final Type SINT32 = new Type(nGetFFITypeSInt32(), 4);
    public static final Type SINT64 = new Type(nGetFFITypeSInt64(), 8);
    public static final Type FLOAT = new Type(nGetFFITypeFloat(), 4);
    public static final Type DOUBLE = new Type(nGetFFITypeDouble(), 8);
    public static final Type POINTER = new Type(nGetFFITypePointer(), Memory.ADDRESS_SIZE);
    public static final Type LONG = new Type((Memory.NATIVE_LONG_SIZE == 4L ? SINT32 : SINT64).handle, Memory.NATIVE_LONG_SIZE);
    public static final Type SIZE = new Type((Memory.ADDRESS_SIZE == 4L ? SINT32 : SINT64).handle, Memory.ADDRESS_SIZE);
    public static final Type BOOLEAN = new Type(POINTER.handle, POINTER.size);
    public static final Type WCHAR = new Type(SINT32.handle, SINT32.size);

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

    private Type(long handle, long size) {
        this(handle, size, 0L);
    }

    private Type(long handle, long size, long elements) {
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

        Type type = (Type) o;
        return size == type.size;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(handle);
    }

}
