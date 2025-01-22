#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <limits.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

static JNIEXPORT jlong JNICALL
sizeOfAddress(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sizeof(void *);
}

static JNIEXPORT jlong JNICALL
sizeOfWChar(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sizeof(wchar_t);
}

static JNIEXPORT jlong JNICALL
sizeOfNativeLong(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sizeof(long);
}

static JNIEXPORT jlong JNICALL
sizeOfDiff(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sizeof(size_t);
}

static JNIEXPORT void JNICALL
putBoolean(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jboolean value) {
    ((jboolean *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putByte(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jbyte value) {
    ((jbyte *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putChar(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jchar value) {
    ((jchar *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putShort(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jshort value) {
    ((jshort *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putInt(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jint value) {
    ((jint *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putLong(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jlong value) {
    ((jlong *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putFloat(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jfloat value) {
    ((jfloat *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putDouble(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jdouble value) {
    ((jdouble *) address)[0] = value;
}

static JNIEXPORT void JNICALL
putAddress(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jlong value) {
#if defined(__x86_64__) || defined(__aarch64__)
    ((jlong *) address)[0] = value;
#elif defined(__i386__) || defined(__arm__)
    ((jint *) address)[0] = (jint) value;
#else
#error unsupported target
#endif
}

static JNIEXPORT void JNICALL
putSize(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jlong value) {
#if SIZE_MAX == UINT64_MAX
    ((jlong *) address)[0] = value;
#elif SIZE_MAX == UINT32_MAX
    ((jint *) address)[0] = (jint) value;
#else
#error unsupported target
#endif
}

static JNIEXPORT void JNICALL
putWChar(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jint value) {
    ((wchar_t *) address)[0] = (wchar_t) value;
}

static JNIEXPORT jboolean JNICALL
getBoolean(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jboolean *) address)[0];
}

static JNIEXPORT jbyte JNICALL
getByte(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jbyte *) address)[0];
}

static JNIEXPORT jchar JNICALL
getChar(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jchar *) address)[0];
}

static JNIEXPORT jshort JNICALL
getShort(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jshort *) address)[0];
}

static JNIEXPORT jint JNICALL
getInt(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jint *) address)[0];
}

static JNIEXPORT jlong JNICALL
getLong(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jlong *) address)[0];
}

static JNIEXPORT jfloat JNICALL
getFloat(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jfloat *) address)[0];
}

static JNIEXPORT jdouble JNICALL
getDouble(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return ((jdouble *) address)[0];
}

static JNIEXPORT jlong JNICALL
getAddress(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
#if defined(__x86_64__) || defined(__aarch64__)
    return ((jlong *) address)[0];
#elif defined(__i386__) || defined(__arm__)
    return ((jint *) address)[0] & 0xFFFFFFFFLL;
#else
#error unsupported target
#endif
}

static JNIEXPORT jlong JNICALL
getSize(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
#if SIZE_MAX == UINT64_MAX
    return ((jlong *) address)[0];
#elif SIZE_MAX == UINT32_MAX
    return ((jint *) address)[0] & 0xFFFFFFFFLL;
#else
#error unsupported target
#endif
}

static JNIEXPORT jint JNICALL
getWChar(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return (jint) ((wchar_t *) address)[0];
}

JNIEXPORT jint JNICALL Memory_OnLoad(JNIEnv *env) {
    jclass memory_class = (*env)->FindClass(env, "io/github/multiffi/dalfik/Memory");
    if (memory_class == NULL) return JNI_ERR;
    JNINativeMethod memory_methods[] = {
            {"sizeOfAddress", "!()J", &sizeOfAddress},
            {"sizeOfWChar", "!()J", &sizeOfWChar},
            {"sizeOfDiff", "!()J", &sizeOfDiff},
            {"sizeOfNativeLong", "!()J", &sizeOfNativeLong},
            {"putBoolean", "!(JZ)V", &putBoolean},
            {"putByte", "!(JB)V", &putByte},
            {"putChar", "!(JC)V", &putChar},
            {"putShort", "!(JS)V", &putShort},
            {"putInt", "!(JI)V", &putInt},
            {"putLong", "!(JJ)V", &putLong},
            {"putFloat", "!(JF)V", &putFloat},
            {"putDouble", "!(JD)V", &putDouble},
            {"putAddress", "!(JJ)V", &putAddress},
            {"putSize", "!(JJ)V", &putSize},
            {"putWChar", "!(JI)V", &putWChar},
            {"getBoolean", "!(J)Z", &getBoolean},
            {"getByte", "!(J)B", &getByte},
            {"getChar", "!(J)C", &getChar},
            {"getShort", "!(J)S", &getShort},
            {"getInt", "!(J)I", &getInt},
            {"getLong", "!(J)J", &getLong},
            {"getFloat", "!(J)F", &getFloat},
            {"getDouble", "!(J)D", &getDouble},
            {"getAddress", "!(J)J", &getAddress},
            {"getSize", "!(J)J", &getSize},
            {"getWChar", "!(J)I", &getWChar}
    };
    if ((*env)->RegisterNatives(env, memory_class, memory_methods, sizeof(memory_methods) / sizeof(memory_methods[0])) != JNI_OK) return JNI_ERR;
    return JNI_OK;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Memory_getDirectBufferAddress(JNIEnv *env,
                                                             __attribute__((unused)) jclass clazz,
                                                             jobject buffer) {
    return (jlong) (*env)->GetDirectBufferAddress(env, buffer);
}

JNIEXPORT jobject JNICALL
Java_io_github_multiffi_dalfik_Memory_newDirectByteBuffer(JNIEnv *env,
                                                          __attribute__((unused)) jclass clazz,
                                                          jlong address,
                                                          jlong capacity) {
    return (*env)->NewDirectByteBuffer(env, (void *) address, capacity);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Memory_allocate(__attribute__((unused)) JNIEnv *env,
                                               __attribute__((unused)) jclass clazz, jlong size) {
    return (jlong) malloc((size_t) size);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Memory_allocateInitialized(__attribute__((unused)) JNIEnv *env,
                                                          __attribute__((unused)) jclass clazz,
                                                          jlong count, jlong size) {
    return (jlong) calloc((size_t) count, (size_t) size);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Memory_reallocate(__attribute__((unused)) JNIEnv *env,
                                                 __attribute__((unused)) jclass clazz,
                                                 jlong address,
                                                 jlong size) {
    return (jlong) realloc((void *) address, (size_t) size);
}

JNIEXPORT void JNICALL
Java_io_github_multiffi_dalfik_Memory_free(__attribute__((unused)) JNIEnv *env,
                                           __attribute__((unused)) jclass clazz, jlong address) {
    free((void *) address);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Memory_getPageSize(__attribute__((unused)) JNIEnv *env,
                                                  __attribute__((unused)) jclass clazz) {
    return getpagesize();
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Memory_fill(__attribute__((unused)) JNIEnv *env,
                                           __attribute__((unused)) jclass clazz, jlong address,
                                           jint value, jlong size) {
    return (jlong) memset((void *) address, value, (size_t) size);
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_Memory_compare(__attribute__((unused)) JNIEnv *env,
                                              __attribute__((unused)) jclass clazz, jlong a_address,
                                              jlong b_address, jlong size) {
    return memcmp((const void *) a_address, (const void *) b_address, (size_t) size);
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Memory_copy(__attribute__((unused)) JNIEnv *env,
                                           __attribute__((unused)) jclass clazz, jlong dest_address,
                                           jlong src_address, jlong size) {
    return (jlong) memmove((void *) dest_address, (void *) src_address, (size_t) size);
}

JNIEXPORT void JNICALL
Java_io_github_multiffi_dalfik_Memory_putDirectBuffer(JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                      jobject buffer, jint position,
                                                      jint size) {
    memcpy((void *) address, ((uint8_t *) (*env)->GetDirectBufferAddress(env, buffer)) + (size_t) position, (size_t) size);
}

JNIEXPORT void JNICALL
Java_io_github_multiffi_dalfik_Memory_getDirectBuffer(JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address,
                                                      jobject buffer, jint position,
                                                      jint size) {
    memcpy(((uint8_t *) (*env)->GetDirectBufferAddress(env, buffer)) + (size_t) position, (void *) address, (size_t) size);
}

#ifdef __cplusplus
}
#endif



