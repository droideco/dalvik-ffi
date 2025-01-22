package io.github.multiffi.dalfik;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

/**
 * <h2>ARMEL (armeabi, armeabi-v7) Intrinsics</h2>
 * <p><b>No ARMHF for Android!</b></p>
 * <p>ARMEL uses R0-R4 for first 4 arguments, no VFP register in use to pass argument.</p>
 */
public final class ARMELDispatch {

    private ARMELDispatch() {
        throw new AssertionError("No io.github.multiffi.dalfik.ARMELDispatch instances for you!");
    }

    static {
        System.loadLibrary("dalfik");
    }

    public static boolean isSupported() {
        return IS_SUPPORTED;
    }

    private static final boolean IS_SUPPORTED = supported();
    @CriticalNative
    private static native boolean supported();

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
