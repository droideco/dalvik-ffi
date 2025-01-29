package io.github.droideco.dalvik.ffi;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

/**
 * <h2>ARMEL (armeabi-v7a) Intrinsics</h2>
 * <p><b>No ARMHF for Android!</b></p>
 * <p>ARMEL uses R0-R4 for first 4 arguments, no VFP register in use to pass argument.</p>
 */
public final class ARMELDispatch {

    private ARMELDispatch() {
        throw new AssertionError("No io.github.droideco.dalvik.ffi.ARMELDispatch instances for you!");
    }

    static {
        System.loadLibrary("dalvikffi");
    }

    public static boolean isSupported() {
        return IS_SUPPORTED;
    }
    private static final boolean IS_SUPPORTED = Library.ABI.equals("armeabi-v7a");

    public static native int invokeR0(long function);
    public static native int invokeR1(long function, int r0);
    public static native int invokeR2(long function, int r0, int r1);
    public static native int invokeR3(long function, int r0, int r1, int r2);
    public static native int invokeR4(long function, int r0, int r1, int r2, int r3);

    @FastNative
    public static native int fastInvokeR0(long function);
    @FastNative
    public static native int fastInvokeR1(long function, int r0);
    @FastNative
    public static native int fastInvokeR2(long function, int r0, int r1);
    @FastNative
    public static native int fastInvokeR3(long function, int r0, int r1, int r2);
    @FastNative
    public static native int fastInvokeR4(long function, int r0, int r1, int r2, int r3);

    @CriticalNative
    public static native int criticalInvokeR0(long function);
    @CriticalNative
    public static native int criticalInvokeR1(long function, int r0);
    @CriticalNative
    public static native int criticalInvokeR2(long function, int r0, int r1);
    @CriticalNative
    public static native int criticalInvokeR3(long function, int r0, int r1, int r2);
    @CriticalNative
    public static native int criticalInvokeR4(long function, int r0, int r1, int r2, int r3);

}
