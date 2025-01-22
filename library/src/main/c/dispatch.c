#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>

#ifdef __x86_64__

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR0(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
         jlong function) {
    return ((jlong (*)(void)) ((void *) (function)))();
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong rdi) {
    return ((jlong (*)(jlong)) ((void *) (function)))(rdi);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong rdi, jlong rsi) {
    return ((jlong (*)(jlong, jlong)) ((void *) (function)))(rdi, rsi);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong rdi, jlong rsi, jlong rdx) {
    return ((jlong (*)(jlong, jlong, jlong)) ((void *) (function)))(rdi, rsi, rdx);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong rdi, jlong rsi, jlong rdx, jlong rcx) {
    return ((jlong (*)(jlong, jlong, jlong, jlong)) ((void *) (function)))(rdi, rsi, rdx, rcx);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))(rdi, rsi, rdx, rcx, r8);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8, jlong r9) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))(rdi, rsi, rdx, rcx, r8, r9);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM0(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function) {
    return ((jvalue) ((jdouble (*)(void)) ((void *) (function)))()).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0) {
    return ((jvalue) ((jdouble (*)(jdouble)) ((void *) (function)))(((jvalue) xmm0).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0, jlong xmm1) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble)) ((void *) (function)))(((jvalue) xmm0).d, ((jvalue) xmm1).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0, jlong xmm1, jlong xmm2) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble)) ((void *) (function)))(((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM7(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5, jlong xmm6) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d, ((jvalue) xmm6).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5, jlong xmm6, jlong xmm7) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d, ((jvalue) xmm6).d, ((jvalue) xmm7).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR1XMM1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function, jlong rdi, jlong xmm0) {
    return ((jlong (*)(jlong, jdouble)) ((void *) (function)))(rdi, ((jvalue) xmm0).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR2XMM2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function, jlong rdi, jlong rsi, jlong xmm0, jlong xmm1) {
    return ((jlong (*)(jlong, jlong, jdouble, jdouble)) ((void *) (function)))(rdi, rsi, ((jvalue) xmm0).d, ((jvalue) xmm1).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR3XMM3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function, jlong rdi, jlong rsi, jlong rdx, jlong xmm0, jlong xmm1, jlong xmm2) {
    return ((jlong (*)(jlong, jlong, jlong, jdouble, jdouble, jdouble)) ((void *) (function)))
    (rdi, rsi, rdx, ((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR4XMM4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function,
                                                            jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (rdi, rsi, rdx, rcx, ((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR5XMM5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8,
                                                            jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (rdi, rsi, rdx, rcx, r8, ((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8, jlong r9,
                                                            jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (rdi, rsi, rdx, rcx, r8, r9, ((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM7(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8, jlong r9,
                                                            jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5, jlong xmm6) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (rdi, rsi, rdx, rcx, r8, r9,
            ((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d, ((jvalue) xmm6).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8, jlong r9,
                                                            jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5, jlong xmm6, jlong xmm7) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (rdi, rsi, rdx, rcx, r8, r9,
            ((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d, ((jvalue) xmm6).d, ((jvalue) xmm7).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM1R1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function, jlong xmm0, jlong rdi) {
    return ((jvalue) ((jdouble (*)(jdouble, jlong)) ((void *) (function)))(((jvalue) xmm0).d, rdi)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM2R2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function, jlong xmm0, jlong xmm1, jlong rdi, jlong rsi) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jlong, jlong)) ((void *) (function)))(((jvalue) xmm0).d, ((jvalue) xmm1).d, rdi, rsi)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM3R3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function, jlong xmm0, jlong xmm1, jlong xmm2, jlong rdi, jlong rsi, jlong rdx) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, rdi, rsi, rdx)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM4R4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong rdi, jlong rsi, jlong rdx, jlong rcx) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, rdi, rsi, rdx, rcx)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM5R5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4,
                                                          jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, rdi, rsi, rdx, rcx, r8)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM6R6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5,
                                                          jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8, jlong r9) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d, rdi, rsi, rdx, rcx, r8, r9)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM7R6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5, jlong xmm6,
                                                          jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8, jlong r9) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
            (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d, ((jvalue) xmm6).d,
                    rdi, rsi, rdx, rcx, r8, r9)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM8R6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong xmm0, jlong xmm1, jlong xmm2, jlong xmm3, jlong xmm4, jlong xmm5, jlong xmm6, jlong xmm7, 
                                                          jlong rdi, jlong rsi, jlong rdx, jlong rcx, jlong r8, jlong r9) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
            (((jvalue) xmm0).d, ((jvalue) xmm1).d, ((jvalue) xmm2).d, ((jvalue) xmm3).d, ((jvalue) xmm4).d, ((jvalue) xmm5).d, ((jvalue) xmm6).d, ((jvalue) xmm7).d,
                    rdi, rsi, rdx, rcx, r8, r9)).j;
}

#elif defined(__aarch64__)

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX0(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
         jlong function) {
    return ((jlong (*)(void)) ((void *) (function)))();
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0) {
    return ((jlong (*)(jlong)) ((void *) (function)))(x0);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0, jlong x1) {
    return ((jlong (*)(jlong, jlong)) ((void *) (function)))(x0, x1);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0, jlong x1, jlong x2) {
    return ((jlong (*)(jlong, jlong, jlong)) ((void *) (function)))(x0, x1, x2);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0, jlong x1, jlong x2, jlong x3) {
    return ((jlong (*)(jlong, jlong, jlong, jlong)) ((void *) (function)))(x0, x1, x2, x3);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0, jlong x1, jlong x2, jlong x3, jlong x4) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))(x0, x1, x2, x3, x4);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))(x0, x1, x2, x3, x4, x5);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX7(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5, jlong x6) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))(x0, x1, x2, x3, x4, x5, x6);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5, jlong x6, jlong x7) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))(x0, x1, x2, x3, x4, x5, x6, x7);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD0(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function) {
    return ((jvalue) ((jdouble (*)(void)) ((void *) (function)))()).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0) {
    return ((jvalue) ((jdouble (*)(jdouble)) ((void *) (function)))(((jvalue) d0).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0, jlong d1) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble)) ((void *) (function)))(((jvalue) d0).d, ((jvalue) d1).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0, jlong d1, jlong d2) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble)) ((void *) (function)))(((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0, jlong d1, jlong d2, jlong d3) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0, jlong d1, jlong d2, jlong d3, jlong d4) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD7(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5, jlong d6) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d, ((jvalue) d6).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
           jlong function, jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5, jlong d6, jlong d7) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d, ((jvalue) d6).d, ((jvalue) d7).d)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX1D1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function, jlong x0, jlong d0) {
    return ((jlong (*)(jlong, jdouble)) ((void *) (function)))(x0, ((jvalue) d0).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX2D2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function, jlong x0, jlong x1, jlong d0, jlong d1) {
    return ((jlong (*)(jlong, jlong, jdouble, jdouble)) ((void *) (function)))(x0, x1, ((jvalue) d0).d, ((jvalue) d1).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX3D3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function, jlong x0, jlong x1, jlong x2, jlong d0, jlong d1, jlong d2) {
    return ((jlong (*)(jlong, jlong, jlong, jdouble, jdouble, jdouble)) ((void *) (function)))
    (x0, x1, x2, ((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX4D4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                            jlong function,
                                                            jlong x0, jlong x1, jlong x2, jlong x3, jlong d0, jlong d1, jlong d2, jlong d3) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (x0, x1, x2, x3, ((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX5D5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong x0, jlong x1, jlong x2, jlong x3, jlong x4,
                                                            jlong d0, jlong d1, jlong d2, jlong d3, jlong d4) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (x0, x1, x2, x3, x4, ((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX6D6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5,
                                                            jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (x0, x1, x2, x3, x4, x5, ((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX7D7(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5, jlong x6,
                                                            jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5, jlong d6) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (x0, x1, x2, x3, x4, x5, x6, 
            ((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d, ((jvalue) d6).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX8D8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                            jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5, jlong x6, jlong x7,
                                                            jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5, jlong d6, jlong d7) {
    return ((jlong (*)(jlong, jlong, jlong, jlong, jlong, jlong, jlong, jlong, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble)) ((void *) (function)))
    (x0, x1, x2, x3, x4, x5, x6, x7, 
            ((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d, ((jvalue) d6).d, ((jvalue) d7).d);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD1X1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function, jlong d0, jlong x0) {
    return ((jvalue) ((jdouble (*)(jdouble, jlong)) ((void *) (function)))(((jvalue) d0).d, x0)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD2X2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function, jlong d0, jlong d1, jlong x0, jlong x1) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jlong, jlong)) ((void *) (function)))(((jvalue) d0).d, ((jvalue) d1).d, x0, x1)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD3X3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function, jlong d0, jlong d1, jlong d2, jlong x0, jlong x1, jlong x2) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, x0, x1, x2)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD4X4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong d0, jlong d1, jlong d2, jlong d3, jlong x0, jlong x1, jlong x2, jlong x3) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, x0, x1, x2, x3)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD5X5(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong d0, jlong d1, jlong d2, jlong d3, jlong d4,
                                                          jlong x0, jlong x1, jlong x2, jlong x3, jlong x4) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, x0, x1, x2, x3, x4)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD6X6(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5,
                                                          jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
    (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d, x0, x1, x2, x3, x4, x5)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD7X7(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5, jlong d6,
                                                          jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5, jlong x6) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
            (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d, ((jvalue) d6).d,
                    x0, x1, x2, x3, x4, x5, x6)).j;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD8X8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
                                                          jlong d0, jlong d1, jlong d2, jlong d3, jlong d4, jlong d5, jlong d6, jlong d7, 
                                                          jlong x0, jlong x1, jlong x2, jlong x3, jlong x4, jlong x5, jlong x6, jlong x7) {
    return ((jvalue) ((jdouble (*)(jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jlong, jlong, jlong, jlong, jlong, jlong, jlong, jlong)) ((void *) (function)))
            (((jvalue) d0).d, ((jvalue) d1).d, ((jvalue) d2).d, ((jvalue) d3).d, ((jvalue) d4).d, ((jvalue) d5).d, ((jvalue) d6).d, ((jvalue) d7).d, 
                    x0, x1, x2, x3, x4, x5, x6, x7)).j;
}

#elif defined(__arm__)

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR0(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
         jlong function) {
    return ((jint (*)(void)) ((void *) (function)))();
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR1(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jint r0) {
    return ((jint (*)(jint)) ((void *) (function)))(r0);
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR2(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jint r0, jint r1) {
    return ((jint (*)(jint, jint)) ((void *) (function)))(r0, r1);
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR3(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jint r0, jint r1, jint r2) {
    return ((jint (*)(jint, jint, jint)) ((void *) (function)))(r0, r1, r2);
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR4(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong function,
         jint r0, jint r1, jint r2, jint r3) {
    return ((jint (*)(jint, jint, jint, jint)) ((void *) (function)))(r0, r1, r2, r3);
}

#elif defined(__i386__)

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_X86CDeclDispatch_invokeEAX(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function) {
    return ((jint (*)(void)) ((void *) (function)))();
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_X86CDeclDispatch_invokeST0(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                          jlong function) {
    return ((jvalue) ((jfloat (*)(void)) ((void *) (function)))()).i;
}

#endif

JNIEXPORT jint JNICALL Dispatch_OnLoad(JNIEnv *env) {
#ifdef __aarch64__
    jclass dispatch_class = (*env)->FindClass(env, "io/github/multiffi/dalfik/AArch64Dispatch");
    if (dispatch_class == NULL) return JNI_ERR;
    JNINativeMethod dispatch_methods[] = {
            {"fastInvokeX0", "!(J)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX0},
            {"fastInvokeX1", "!(JJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX1},
            {"fastInvokeX2", "!(JJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX2},
            {"fastInvokeX3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX3},
            {"fastInvokeX4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX4},
            {"fastInvokeX5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX5},
            {"fastInvokeX6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX6},
            {"fastInvokeD0", "!(J)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD0},
            {"fastInvokeD1", "!(JJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD1},
            {"fastInvokeD2", "!(JJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD2},
            {"fastInvokeD3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD3},
            {"fastInvokeD4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD4},
            {"fastInvokeD5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD5},
            {"fastInvokeD6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD6},
            {"fastInvokeD7", "!(JJJJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD7},
            {"fastInvokeX1D1", "!(JJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX1D1},
            {"fastInvokeX2D2", "!(JJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX2D2},
            {"fastInvokeX3D3", "!(JJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX3D3},
            {"fastInvokeX4D4", "!(JJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX4D4},
            {"fastInvokeX5D5", "!(JJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX5D5},
            {"fastInvokeX6D6", "!(JJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX6D6},
            {"fastInvokeX7D7", "!(JJJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX7D7},
            {"fastInvokeX8D8", "!(JJJJJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX8D8},
            {"criticalInvokeX0", "!(J)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX0},
            {"criticalInvokeX1", "!(JJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX1},
            {"criticalInvokeX2", "!(JJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX2},
            {"criticalInvokeX3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX3},
            {"criticalInvokeX4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX4},
            {"criticalInvokeX5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX5},
            {"criticalInvokeX6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX6},
            {"criticalInvokeD0", "!(J)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD0},
            {"criticalInvokeD1", "!(JJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD1},
            {"criticalInvokeD2", "!(JJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD2},
            {"criticalInvokeD3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD3},
            {"criticalInvokeD4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD4},
            {"criticalInvokeD5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD5},
            {"criticalInvokeD6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD6},
            {"criticalInvokeD7", "!(JJJJJJJJ)J", Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeD7},
            {"criticalInvokeX1D1", "!(JJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX1D1},
            {"criticalInvokeX2D2", "!(JJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX2D2},
            {"criticalInvokeX3D3", "!(JJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX3D3},
            {"criticalInvokeX4D4", "!(JJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX4D4},
            {"criticalInvokeX5D5", "!(JJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX5D5},
            {"criticalInvokeX6D6", "!(JJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX6D6},
            {"criticalInvokeX7D7", "!(JJJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX7D7},
            {"criticalInvokeX8D8", "!(JJJJJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_AArch64Dispatch_invokeX8D8}
    };
#elif defined(__x86_64__)
    jclass dispatch_class = (*env)->FindClass(env, "io/github/multiffi/dalfik/SysVX64Dispatch");
    if (dispatch_class == NULL) return JNI_ERR;
    JNINativeMethod dispatch_methods[] = {
            {"fastInvokeR0", "!(J)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR0},
            {"fastInvokeR1", "!(JJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR1},
            {"fastInvokeR2", "!(JJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR2},
            {"fastInvokeR3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR3},
            {"fastInvokeR4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR4},
            {"fastInvokeR5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR5},
            {"fastInvokeR6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6},
            {"fastInvokeXMM0", "!(J)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM0},
            {"fastInvokeXMM1", "!(JJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM1},
            {"fastInvokeXMM2", "!(JJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM2},
            {"fastInvokeXMM3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM3},
            {"fastInvokeXMM4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM4},
            {"fastInvokeXMM5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM5},
            {"fastInvokeXMM6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM6},
            {"fastInvokeXMM7", "!(JJJJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM7},
            {"fastInvokeR1XMM1", "!(JJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR1XMM1},
            {"fastInvokeR2XMM2", "!(JJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR2XMM2},
            {"fastInvokeR3XMM3", "!(JJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR3XMM3},
            {"fastInvokeR4XMM4", "!(JJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR4XMM4},
            {"fastInvokeR5XMM5", "!(JJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR5XMM5},
            {"fastInvokeR6XMM6", "!(JJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM6},
            {"fastInvokeR6XMM7", "!(JJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM7},
            {"fastInvokeR6XMM8", "!(JJJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM8},
            {"criticalInvokeR0", "!(J)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR0},
            {"criticalInvokeR1", "!(JJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR1},
            {"criticalInvokeR2", "!(JJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR2},
            {"criticalInvokeR3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR3},
            {"criticalInvokeR4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR4},
            {"criticalInvokeR5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR5},
            {"criticalInvokeR6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6},
            {"criticalInvokeXMM0", "!(J)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM0},
            {"criticalInvokeXMM1", "!(JJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM1},
            {"criticalInvokeXMM2", "!(JJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM2},
            {"criticalInvokeXMM3", "!(JJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM3},
            {"criticalInvokeXMM4", "!(JJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM4},
            {"criticalInvokeXMM5", "!(JJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM5},
            {"criticalInvokeXMM6", "!(JJJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM6},
            {"criticalInvokeXMM7", "!(JJJJJJJJ)J", Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeXMM7},
            {"criticalInvokeR1XMM1", "!(JJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR1XMM1},
            {"criticalInvokeR2XMM2", "!(JJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR2XMM2},
            {"criticalInvokeR3XMM3", "!(JJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR3XMM3},
            {"criticalInvokeR4XMM4", "!(JJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR4XMM4},
            {"criticalInvokeR5XMM5", "!(JJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR5XMM5},
            {"criticalInvokeR6XMM6", "!(JJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM6},
            {"criticalInvokeR6XMM7", "!(JJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM7},
            {"criticalInvokeR6XMM8", "!(JJJJJJJJJJJJJJJ)J",Java_io_github_multiffi_dalfik_SysVX64Dispatch_invokeR6XMM8}
    };
#elif defined(__arm__)
    jclass dispatch_class = (*env)->FindClass(env, "io/github/multiffi/dalfik/ARMELDispatch");
    if (dispatch_class == NULL) return JNI_ERR;
    JNINativeMethod dispatch_methods[] = {
            {"fastInvokeR0", "!(J)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR0},
            {"fastInvokeR1", "!(JI)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR1},
            {"fastInvokeR2", "!(JII)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR2},
            {"fastInvokeR3", "!(JIII)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR3},
            {"fastInvokeR4", "!(JIIII)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR4},
            {"criticalInvokeR0", "!(J)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR0},
            {"criticalInvokeR1", "!(JI)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR1},
            {"criticalInvokeR2", "!(JII)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR2},
            {"criticalInvokeR3", "!(JIII)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR3},
            {"criticalInvokeR4", "!(JIIII)I", Java_io_github_multiffi_dalfik_ARMELDispatch_invokeR4}
    };
#elif defined(__i386__)
    jclass dispatch_class = (*env)->FindClass(env, "io/github/multiffi/dalfik/X86CDeclDispatch");
    if (dispatch_class == NULL) return JNI_ERR;
    JNINativeMethod dispatch_methods[] = {
            {"fastInvokeEAX", "!(J)I", Java_io_github_multiffi_dalfik_X86CDeclDispatch_invokeEAX},
            {"fastInvokeST0", "!(J)I", Java_io_github_multiffi_dalfik_X86CDeclDispatch_invokeST0},
            {"criticalInvokeEAX", "!(J)I", Java_io_github_multiffi_dalfik_X86CDeclDispatch_invokeEAX},
            {"criticalInvokeST0", "!(J)I", Java_io_github_multiffi_dalfik_X86CDeclDispatch_invokeST0}
    };
#endif
    if ((*env)->RegisterNatives(env, dispatch_class, dispatch_methods, (sizeof(dispatch_methods) / sizeof(dispatch_methods[0]))) != JNI_OK) return JNI_ERR;
    return JNI_OK;
}

#ifdef __cplusplus
}
#endif

JNIEXPORT jboolean JNICALL
Java_io_github_multiffi_dalfik_AArch64Dispatch_supported(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
#ifdef __aarch64__
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

JNIEXPORT jboolean JNICALL
Java_io_github_multiffi_dalfik_SysVX64Dispatch_supported(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
#ifdef __x86_64__
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

JNIEXPORT jboolean JNICALL
Java_io_github_multiffi_dalfik_ARMELDispatch_supported(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
#ifdef __arm__
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

JNIEXPORT jboolean JNICALL
Java_io_github_multiffi_dalfik_X86CDeclDispatch_supported(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
#ifdef __i386__
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}
