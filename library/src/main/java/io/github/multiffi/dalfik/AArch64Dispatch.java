package io.github.multiffi.dalfik;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

/**
 * <h2>AArch64 (arm64-v8a) Intrinsics</h2>
 * <p>AArch64 uses X0-X7 for first 8 integer arguments, D0-D7 for first 8 decimal arguments.</p>
 */
public final class AArch64Dispatch {

    private AArch64Dispatch() {
        throw new AssertionError("No io.github.multiffi.dalfik.AArch64Dispatch instances for you!");
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

    public static native long invokeX0(long function);
    public static native long invokeX1(long function, long x0);
    public static native long invokeX2(long function, long x0, long x1);
    public static native long invokeX3(long function, long x0, long x1, long x2);
    public static native long invokeX4(long function, long x0, long x1, long x2, long x3);
    public static native long invokeX5(long function, long x0, long x1, long x2, long x3, long x4);
    public static native long invokeX6(long function, long x0, long x1, long x2, long x3, long x4, long x5);
    public static native long invokeX7(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6);
    public static native long invokeX8(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7);
    public static native long invokeD0(long function);
    public static native long invokeD1(long function, long d0);
    public static native long invokeD2(long function, long d0, long d1);
    public static native long invokeD3(long function, long d0, long d1, long d2);
    public static native long invokeD4(long function, long d0, long d1, long d2, long d3);
    public static native long invokeD5(long function, long d0, long d1, long d2, long d3, long d4);
    public static native long invokeD6(long function, long d0, long d1, long d2, long d3, long d4, long d5);
    public static native long invokeD7(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6);
    public static native long invokeD8(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long d7);
    public static native long invokeX1D1(long function, long x0, long d0);
    public static native long invokeX2D2(long function, long x0, long x1, long d0, long d1);
    public static native long invokeX3D3(long function, long x0, long x1, long x2, long d0, long d1, long d2);
    public static native long invokeX4D4(long function, long x0, long x1, long x2, long x3, long d0, long d1, long d2, long d3);
    public static native long invokeX5D5(long function, long x0, long x1, long x2, long x3, long x4, long d0, long d1, long d2, long d3, long d4);
    public static native long invokeX6D6(long function, long x0, long x1, long x2, long x3, long x4, long x5, long d0, long d1, long d2, long d3, long d4, long d5);
    public static native long invokeX7D7(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long d0, long d1, long d2, long d3, long d4, long d5, long d6);
    public static native long invokeX8D8(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long d7);
    public static native long invokeD1X1(long function, long d0, long x0);
    public static native long invokeD2X2(long function, long d0, long d1, long x0, long x1);
    public static native long invokeD3X3(long function, long d0, long d1, long d2, long x0, long x1, long x2);
    public static native long invokeD4X4(long function, long d0, long d1, long d2, long d3, long x0, long x1, long x2, long x3);
    public static native long invokeD5X5(long function, long d0, long d1, long d2, long d3, long d4, long x0, long x1, long x2, long x3, long x4);
    public static native long invokeD6X6(long function, long d0, long d1, long d2, long d3, long d4, long d5, long x0, long x1, long x2, long x3, long x4, long x5);
    public static native long invokeD7X7(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long x0, long x1, long x2, long x3, long x4, long x5, long x6);
    public static native long invokeD8X8(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long d7, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7);

    @FastNative
    public static native long fastInvokeX0(long function);
    @FastNative
    public static native long fastInvokeX1(long function, long x0);
    @FastNative
    public static native long fastInvokeX2(long function, long x0, long x1);
    @FastNative
    public static native long fastInvokeX3(long function, long x0, long x1, long x2);
    @FastNative
    public static native long fastInvokeX4(long function, long x0, long x1, long x2, long x3);
    @FastNative
    public static native long fastInvokeX5(long function, long x0, long x1, long x2, long x3, long x4);
    @FastNative
    public static native long fastInvokeX6(long function, long x0, long x1, long x2, long x3, long x4, long x5);
    @FastNative
    public static native long fastInvokeX7(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6);
    @FastNative
    public static native long fastInvokeX8(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7);
    @FastNative
    public static native long fastInvokeD0(long function);
    @FastNative
    public static native long fastInvokeD1(long function, long d0);
    @FastNative
    public static native long fastInvokeD2(long function, long d0, long d1);
    @FastNative
    public static native long fastInvokeD3(long function, long d0, long d1, long d2);
    @FastNative
    public static native long fastInvokeD4(long function, long d0, long d1, long d2, long d3);
    @FastNative
    public static native long fastInvokeD5(long function, long d0, long d1, long d2, long d3, long d4);
    @FastNative
    public static native long fastInvokeD6(long function, long d0, long d1, long d2, long d3, long d4, long d5);
    @FastNative
    public static native long fastInvokeD7(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6);
    @FastNative
    public static native long fastInvokeD8(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long d7);
    @FastNative
    public static native long fastInvokeX1D1(long function, long x0, long d0);
    @FastNative
    public static native long fastInvokeX2D2(long function, long x0, long x1, long d0, long d1);
    @FastNative
    public static native long fastInvokeX3D3(long function, long x0, long x1, long x2, long d0, long d1, long d2);
    @FastNative
    public static native long fastInvokeX4D4(long function, long x0, long x1, long x2, long x3, long d0, long d1, long d2, long d3);
    @FastNative
    public static native long fastInvokeX5D5(long function, long x0, long x1, long x2, long x3, long x4, long d0, long d1, long d2, long d3, long d4);
    @FastNative
    public static native long fastInvokeX6D6(long function, long x0, long x1, long x2, long x3, long x4, long x5, long d1, long d2, long d3, long d4, long d5);
    @FastNative
    public static native long fastInvokeX7D7(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long d1, long d2, long d3, long d4, long d5, long d6);
    @FastNative
    public static native long fastInvokeX8D8(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7, long d1, long d2, long d3, long d4, long d5, long d6, long d7);
    @FastNative
    public static native long fastInvokeD1X1(long function, long d0, long x0);
    @FastNative
    public static native long fastInvokeD2X2(long function, long d0, long d1, long x0, long x1);
    @FastNative
    public static native long fastInvokeD3X3(long function, long d0, long d1, long d2, long x0, long x1, long x2);
    @FastNative
    public static native long fastInvokeD4X4(long function, long d0, long d1, long d2, long d3, long x0, long x1, long x2, long x3);
    @FastNative
    public static native long fastInvokeD5X5(long function, long d0, long d1, long d2, long d3, long d4, long x0, long x1, long x2, long x3, long x4);
    @FastNative
    public static native long fastInvokeD6X6(long function, long d0, long d1, long d2, long d3, long d4, long d5, long x0, long x1, long x2, long x3, long x4, long x5);
    @FastNative
    public static native long fastInvokeD7X7(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long x0, long x1, long x2, long x3, long x4, long x5, long x6);
    @FastNative
    public static native long fastInvokeD8X8(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long d7, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7);

    @CriticalNative
    public static native long criticalInvokeX0(long function);
    @CriticalNative
    public static native long criticalInvokeX1(long function, long x0);
    @CriticalNative
    public static native long criticalInvokeX2(long function, long x0, long x1);
    @CriticalNative
    public static native long criticalInvokeX3(long function, long x0, long x1, long x2);
    @CriticalNative
    public static native long criticalInvokeX4(long function, long x0, long x1, long x2, long x3);
    @CriticalNative
    public static native long criticalInvokeX5(long function, long x0, long x1, long x2, long x3, long x4);
    @CriticalNative
    public static native long criticalInvokeX6(long function, long x0, long x1, long x2, long x3, long x4, long x5);
    @CriticalNative
    public static native long criticalInvokeX7(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6);
    @CriticalNative
    public static native long criticalInvokeX8(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7);
    @CriticalNative
    public static native long criticalInvokeD0(long function);
    @CriticalNative
    public static native long criticalInvokeD1(long function, long d0);
    @CriticalNative
    public static native long criticalInvokeD2(long function, long d0, long d1);
    @CriticalNative
    public static native long criticalInvokeD3(long function, long d0, long d1, long d2);
    @CriticalNative
    public static native long criticalInvokeD4(long function, long d0, long d1, long d2, long d3);
    @CriticalNative
    public static native long criticalInvokeD5(long function, long d0, long d1, long d2, long d3, long d4);
    @CriticalNative
    public static native long criticalInvokeD6(long function, long d0, long d1, long d2, long d3, long d4, long d5);
    @CriticalNative
    public static native long criticalInvokeD7(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6);
    @CriticalNative
    public static native long criticalInvokeD8(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long d7);
    @CriticalNative
    public static native long criticalInvokeX1D1(long function, long x0, long d0);
    @CriticalNative
    public static native long criticalInvokeX2D2(long function, long x0, long x1, long d0, long d1);
    @CriticalNative
    public static native long criticalInvokeX3D3(long function, long x0, long x1, long x2, long d0, long d1, long d2);
    @CriticalNative
    public static native long criticalInvokeX4D4(long function, long x0, long x1, long x2, long x3, long d0, long d1, long d2, long d3);
    @CriticalNative
    public static native long criticalInvokeX5D5(long function, long x0, long x1, long x2, long x3, long x4, long d0, long d1, long d2, long d3, long d4);
    @CriticalNative
    public static native long criticalInvokeX6D6(long function, long x0, long x1, long x2, long x3, long x4, long x5, long d1, long d2, long d3, long d4, long d5);
    @CriticalNative
    public static native long criticalInvokeX7D7(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long d1, long d2, long d3, long d4, long d5, long d6);
    @CriticalNative
    public static native long criticalInvokeX8D8(long function, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7, long d1, long d2, long d3, long d4, long d5, long d6, long d7);
    @CriticalNative
    public static native long criticalInvokeD1X1(long function, long d0, long x0);
    @CriticalNative
    public static native long criticalInvokeD2X2(long function, long d0, long d1, long x0, long x1);
    @CriticalNative
    public static native long criticalInvokeD3X3(long function, long d0, long d1, long d2, long x0, long x1, long x2);
    @CriticalNative
    public static native long criticalInvokeD4X4(long function, long d0, long d1, long d2, long d3, long x0, long x1, long x2, long x3);
    @CriticalNative
    public static native long criticalInvokeD5X5(long function, long d0, long d1, long d2, long d3, long d4, long x0, long x1, long x2, long x3, long x4);
    @CriticalNative
    public static native long criticalInvokeD6X6(long function, long d0, long d1, long d2, long d3, long d4, long d5, long x0, long x1, long x2, long x3, long x4, long x5);
    @CriticalNative
    public static native long criticalInvokeD7X7(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long x0, long x1, long x2, long x3, long x4, long x5, long x6);
    @CriticalNative
    public static native long criticalInvokeD8X8(long function, long d0, long d1, long d2, long d3, long d4, long d5, long d6, long d7, long x0, long x1, long x2, long x3, long x4, long x5, long x6, long x7);

}
