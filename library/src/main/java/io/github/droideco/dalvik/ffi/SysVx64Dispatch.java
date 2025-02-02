package io.github.droideco.dalvik.ffi;

import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;

/**
 * <h2>System V x86_64 Intrinsics</h2>
 * <p>SysVX64 uses RDI, RSI, RDX, RCX, R8, R9 for first 6 integer arguments, XMM0-XMM7 for first 8 decimal arguments.</p>
 */
public final class SysVx64Dispatch {

    private SysVx64Dispatch() {
        throw new AssertionError("No io.github.droideco.dalvik.ffi.SysVx64Dispatch instances for you!");
    }

    static {
        System.loadLibrary("dalvikffi");
    }

    public static boolean isSupported() {
        return IS_SUPPORTED;
    }
    private static final boolean IS_SUPPORTED = Library.ABI.equals("x86_64");

    public static native long invokeR0(long function);
    public static native long invokeR1(long function, long rdi);
    public static native long invokeR2(long function, long rdi, long rsi);
    public static native long invokeR3(long function, long rdi, long rsi, long rdx);
    public static native long invokeR4(long function, long rdi, long rsi, long rdx, long rcx);
    public static native long invokeR5(long function, long rdi, long rsi, long rdx, long rcx, long r8);
    public static native long invokeR6(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    public static native long invokeXMM0(long function);
    public static native long invokeXMM1(long function, long xmm0);
    public static native long invokeXMM2(long function, long xmm0, long xmm1);
    public static native long invokeXMM3(long function, long xmm0, long xmm1, long xmm2);
    public static native long invokeXMM4(long function, long xmm0, long xmm1, long xmm2, long xmm3);
    public static native long invokeXMM5(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4);
    public static native long invokeXMM6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5);
    public static native long invokeXMM7(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6);
    public static native long invokeXMM8(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7);
    public static native long invokeR1XMM1(long function, long rdi, long xmm0);
    public static native long invokeR2XMM2(long function, long rdi, long rsi, long xmm0, long xmm1);
    public static native long invokeR3XMM3(long function, long rdi, long rsi, long rdx, long xmm0, long xmm1, long xmm2);
    public static native long invokeR4XMM4(long function, long rdi, long rsi, long rdx, long rcx, long xmm0, long xmm1, long xmm2, long xmm3);
    public static native long invokeR5XMM5(long function, long rdi, long rsi, long rdx, long rcx, long r8, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4);
    public static native long invokeR6XMM6(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5);
    public static native long invokeR6XMM7(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6);
    public static native long invokeR6XMM8(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7);
    public static native long invokeXMM1R1(long function, long xmm0, long rdi);
    public static native long invokeXMM2R2(long function, long xmm0, long xmm1, long rdi, long rsi);
    public static native long invokeXMM3R3(long function, long xmm0, long xmm1, long xmm2, long rdi, long rsi, long rdx);
    public static native long invokeXMM4R4(long function, long xmm0, long xmm1, long xmm2, long xmm3, long rdi, long rsi, long rdx, long rcx);
    public static native long invokeXMM5R5(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long rdi, long rsi, long rdx, long rcx, long r8);
    public static native long invokeXMM6R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    public static native long invokeXMM7R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    public static native long invokeXMM8R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7, long rdi, long rsi, long rdx, long rcx, long r8, long r9);

    @FastNative
    public static native long fastInvokeR0(long function);
    @FastNative
    public static native long fastInvokeR1(long function, long rdi);
    @FastNative
    public static native long fastInvokeR2(long function, long rdi, long rsi);
    @FastNative
    public static native long fastInvokeR3(long function, long rdi, long rsi, long rdx);
    @FastNative
    public static native long fastInvokeR4(long function, long rdi, long rsi, long rdx, long rcx);
    @FastNative
    public static native long fastInvokeR5(long function, long rdi, long rsi, long rdx, long rcx, long r8);
    @FastNative
    public static native long fastInvokeR6(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    @FastNative
    public static native long fastInvokeXMM0(long function);
    @FastNative
    public static native long fastInvokeXMM1(long function, long xmm0);
    @FastNative
    public static native long fastInvokeXMM2(long function, long xmm0, long xmm1);
    @FastNative
    public static native long fastInvokeXMM3(long function, long xmm0, long xmm1, long xmm2);
    @FastNative
    public static native long fastInvokeXMM4(long function, long xmm0, long xmm1, long xmm2, long xmm3);
    @FastNative
    public static native long fastInvokeXMM5(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4);
    @FastNative
    public static native long fastInvokeXMM6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5);
    @FastNative
    public static native long fastInvokeXMM7(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6);
    @FastNative
    public static native long fastInvokeXMM8(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7);
    @FastNative
    public static native long fastInvokeR1XMM1(long function, long rdi, long xmm0);
    @FastNative
    public static native long fastInvokeR2XMM2(long function, long rdi, long rsi, long xmm0, long xmm1);
    @FastNative
    public static native long fastInvokeR3XMM3(long function, long rdi, long rsi, long rdx, long xmm0, long xmm1, long xmm2);
    @FastNative
    public static native long fastInvokeR4XMM4(long function, long rdi, long rsi, long rdx, long rcx, long xmm0, long xmm1, long xmm2, long xmm3);
    @FastNative
    public static native long fastInvokeR5XMM5(long function, long rdi, long rsi, long rdx, long rcx, long r8, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4);
    @FastNative
    public static native long fastInvokeR6XMM6(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5);
    @FastNative
    public static native long fastInvokeR6XMM7(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6);
    @FastNative
    public static native long fastInvokeR6XMM8(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7);
    @FastNative
    public static native long fastInvokeXMM1R1(long function, long xmm0, long rdi);
    @FastNative
    public static native long fastInvokeXMM2R2(long function, long xmm0, long xmm1, long rdi, long rsi);
    @FastNative
    public static native long fastInvokeXMM3R3(long function, long xmm0, long xmm1, long xmm2, long rdi, long rsi, long rdx);
    @FastNative
    public static native long fastInvokeXMM4R4(long function, long xmm0, long xmm1, long xmm2, long xmm3, long rdi, long rsi, long rdx, long rcx);
    @FastNative
    public static native long fastInvokeXMM5R5(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long rdi, long rsi, long rdx, long rcx, long r8);
    @FastNative
    public static native long fastInvokeXMM6R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    @FastNative
    public static native long fastInvokeXMM7R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    @FastNative
    public static native long fastInvokeXMM8R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7, long rdi, long rsi, long rdx, long rcx, long r8, long r9);

    @CriticalNative
    public static native long criticalInvokeR0(long function);
    @CriticalNative
    public static native long criticalInvokeR1(long function, long rdi);
    @CriticalNative
    public static native long criticalInvokeR2(long function, long rdi, long rsi);
    @CriticalNative
    public static native long criticalInvokeR3(long function, long rdi, long rsi, long rdx);
    @CriticalNative
    public static native long criticalInvokeR4(long function, long rdi, long rsi, long rdx, long rcx);
    @CriticalNative
    public static native long criticalInvokeR5(long function, long rdi, long rsi, long rdx, long rcx, long r8);
    @CriticalNative
    public static native long criticalInvokeR6(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    @CriticalNative
    public static native long criticalInvokeXMM0(long function);
    @CriticalNative
    public static native long criticalInvokeXMM1(long function, long xmm0);
    @CriticalNative
    public static native long criticalInvokeXMM2(long function, long xmm0, long xmm1);
    @CriticalNative
    public static native long criticalInvokeXMM3(long function, long xmm0, long xmm1, long xmm2);
    @CriticalNative
    public static native long criticalInvokeXMM4(long function, long xmm0, long xmm1, long xmm2, long xmm3);
    @CriticalNative
    public static native long criticalInvokeXMM5(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4);
    @CriticalNative
    public static native long criticalInvokeXMM6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5);
    @CriticalNative
    public static native long criticalInvokeXMM7(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6);
    @CriticalNative
    public static native long criticalInvokeXMM8(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7);
    @CriticalNative
    public static native long criticalInvokeR1XMM1(long function, long rdi, long xmm0);
    @CriticalNative
    public static native long criticalInvokeR2XMM2(long function, long rdi, long rsi, long xmm0, long xmm1);
    @CriticalNative
    public static native long criticalInvokeR3XMM3(long function, long rdi, long rsi, long rdx, long xmm0, long xmm1, long xmm2);
    @CriticalNative
    public static native long criticalInvokeR4XMM4(long function, long rdi, long rsi, long rdx, long rcx, long xmm0, long xmm1, long xmm2, long xmm3);
    @CriticalNative
    public static native long criticalInvokeR5XMM5(long function, long rdi, long rsi, long rdx, long rcx, long r8, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4);
    @CriticalNative
    public static native long criticalInvokeR6XMM6(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5);
    @CriticalNative
    public static native long criticalInvokeR6XMM7(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6);
    @CriticalNative
    public static native long criticalInvokeR6XMM8(long function, long rdi, long rsi, long rdx, long rcx, long r8, long r9, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7);
    @CriticalNative
    public static native long criticalInvokeXMM1R1(long function, long xmm0, long rdi);
    @CriticalNative
    public static native long criticalInvokeXMM2R2(long function, long xmm0, long xmm1, long rdi, long rsi);
    @CriticalNative
    public static native long criticalInvokeXMM3R3(long function, long xmm0, long xmm1, long xmm2, long rdi, long rsi, long rdx);
    @CriticalNative
    public static native long criticalInvokeXMM4R4(long function, long xmm0, long xmm1, long xmm2, long xmm3, long rdi, long rsi, long rdx, long rcx);
    @CriticalNative
    public static native long criticalInvokeXMM5R5(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long rdi, long rsi, long rdx, long rcx, long r8);
    @CriticalNative
    public static native long criticalInvokeXMM6R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    @CriticalNative
    public static native long criticalInvokeXMM7R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long rdi, long rsi, long rdx, long rcx, long r8, long r9);
    @CriticalNative
    public static native long criticalInvokeXMM8R6(long function, long xmm0, long xmm1, long xmm2, long xmm3, long xmm4, long xmm5, long xmm6, long xmm7, long rdi, long rsi, long rdx, long rcx, long r8, long r9);

}
