package io.github.multiffi.dalfik;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

/**
 * <h2>x86 C Declaration Intrinsics</h2>
 * <p>CDecl uses EAX to return integer value, ST0 to return decimal value.</p>
 */
public final class X86CDeclDispatch {

    private X86CDeclDispatch() {
        throw new AssertionError("No io.github.multiffi.dalfik.X86CDeclDispatch instances for you!");
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

    public static native int invokeEAX(long function);
    public static native int invokeST0(long function);

    @FastNative
    public static native int fastInvokeEAX(long function);
    @FastNative
    public static native int fastInvokeST0(long function);

    @CriticalNative
    public static native int criticalInvokeEAX(long function);
    @CriticalNative
    public static native int criticalInvokeST0(long function);

}
