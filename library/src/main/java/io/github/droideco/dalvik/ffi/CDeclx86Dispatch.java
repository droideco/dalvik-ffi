package io.github.droideco.dalvik.ffi;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

/**
 * <h2>x86 C Declaration Intrinsics</h2>
 * <p>CDecl uses EAX to return integer value, ST0 to return decimal value.</p>
 */
public final class CDeclx86Dispatch {

    private CDeclx86Dispatch() {
        throw new AssertionError("No io.github.droideco.dalvik.ffi.CDeclx86Dispatch instances for you!");
    }

    static {
        System.loadLibrary("dalvikffi");
    }

    public static boolean isSupported() {
        return IS_SUPPORTED;
    }
    private static final boolean IS_SUPPORTED = Library.ABI.equals("x86");

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
