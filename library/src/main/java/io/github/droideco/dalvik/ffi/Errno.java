package io.github.droideco.dalvik.ffi;

import dalvik.annotation.optimization.CriticalNative;

public final class Errno {

    private Errno() {
        throw new AssertionError("No io.github.droideco.dalvik.ffi.Errno instances for you!");
    }

    static {
        System.loadLibrary("dalvikffi");
    }

    @CriticalNative
    public static native int getErrno();
    @CriticalNative
    public static native void setErrno(int errnum);

}
