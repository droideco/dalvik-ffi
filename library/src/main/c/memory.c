#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <limits.h>
#include <stdlib.h>
#include <string.h>

static jlong JNICALL
nAddressSize(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sizeof(void *);
}

static jlong JNICALL
nNativeLongSize(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return sizeof(long);
}

static void JNICALL
putByte(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jbyte value) {
    *((jbyte *) address) = value;
}

static void JNICALL
putChar(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jchar value) {
    *((jchar *) address) = value;
}

static void JNICALL
putShort(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jshort value) {
    *((jshort *) address) = value;
}

static void JNICALL
putInt(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jint value) {
    *((jint *) address) = value;
}

static void JNICALL
putLong(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jlong value) {
    *((jlong *) address) = value;
}

static void JNICALL
putFloat(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jfloat value) {
    *((jfloat *) address) = value;
}

static void JNICALL
putDouble(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address, jdouble value) {
    *((jdouble *) address) = value;
}

static jbyte JNICALL
getByte(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jbyte *) address);
}

static jchar JNICALL
getChar(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jchar *) address);
}

static jshort JNICALL
getShort(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jshort *) address);
}

static jint JNICALL
getInt(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jint *) address);
}

static jlong JNICALL
getLong(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jlong *) address);
}

static jfloat JNICALL
getFloat(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jfloat *) address);
}

static jdouble JNICALL
getDouble(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong address) {
    return *((jdouble *) address);
}

__attribute__ ((visibility ("hidden"))) jint JNICALL Memory_OnLoad(JNIEnv *env) {
    jclass clazz = (*env)->FindClass(env, "io/github/droideco/dalvik/ffi/Memory");
    if (clazz == NULL) return JNI_ERR;
    if (android_get_device_api_level() < __ANDROID_API_O__) {
        JNINativeMethod methods[] = {
                {"nAddressSize", "!()J", &nAddressSize},
                {"nNativeLongSize", "!()J", &nNativeLongSize},
                {"putByte", "!(JB)V", &putByte},
                {"putChar", "!(JC)V", &putChar},
                {"putShort", "!(JS)V", &putShort},
                {"putInt", "!(JI)V", &putInt},
                {"putLong", "!(JJ)V", &putLong},
                {"putFloat", "!(JF)V", &putFloat},
                {"putDouble", "!(JD)V", &putDouble},
                {"getByte", "!(J)B", &getByte},
                {"getChar", "!(J)C", &getChar},
                {"getShort", "!(J)S", &getShort},
                {"getInt", "!(J)I", &getInt},
                {"getLong", "!(J)J", &getLong},
                {"getFloat", "!(J)F", &getFloat},
                {"getDouble", "!(J)D", &getDouble}
        };
        if ((*env)->RegisterNatives(env, clazz, methods, sizeof(methods) / sizeof(methods[0])) != JNI_OK) return JNI_ERR;
    }
    else {
        JNINativeMethod methods[] = {
                {"nAddressSize", "()J", &nAddressSize},
                {"nNativeLongSize", "()J", &nNativeLongSize},
                {"putByte", "(JB)V", &putByte},
                {"putChar", "(JC)V", &putChar},
                {"putShort", "(JS)V", &putShort},
                {"putInt", "(JI)V", &putInt},
                {"putLong", "(JJ)V", &putLong},
                {"putFloat", "(JF)V", &putFloat},
                {"putDouble", "(JD)V", &putDouble},
                {"getByte", "(J)B", &getByte},
                {"getChar", "(J)C", &getChar},
                {"getShort", "(J)S", &getShort},
                {"getInt", "(J)I", &getInt},
                {"getLong", "(J)J", &getLong},
                {"getFloat", "(J)F", &getFloat},
                {"getDouble", "(J)D", &getDouble}
        };
        if ((*env)->RegisterNatives(env, clazz, methods, sizeof(methods) / sizeof(methods[0])) != JNI_OK) return JNI_ERR;
    }
    return JNI_OK;
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_allocate(__attribute__((unused)) JNIEnv *env,
                                               __attribute__((unused)) jclass clazz, jlong size) {
    return (jlong) malloc((size_t) size);
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_allocateInitialized(__attribute__((unused)) JNIEnv *env,
                                                          __attribute__((unused)) jclass clazz,
                                                          jlong count, jlong size) {
    return (jlong) calloc((size_t) count, (size_t) size);
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_reallocate(__attribute__((unused)) JNIEnv *env,
                                                 __attribute__((unused)) jclass clazz,
                                                 jlong address,
                                                 jlong size) {
    return (jlong) realloc((void *) address, (size_t) size);
}

JNIEXPORT void JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_free(__attribute__((unused)) JNIEnv *env,
                                           __attribute__((unused)) jclass clazz, jlong address) {
    free((void *) address);
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_fill(__attribute__((unused)) JNIEnv *env,
                                           __attribute__((unused)) jclass clazz, jlong address,
                                           jint value, jlong size) {
    return (jlong) memset((void *) address, value, (size_t) size);
}

JNIEXPORT jint JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_compare(__attribute__((unused)) JNIEnv *env,
                                              __attribute__((unused)) jclass clazz, jlong a_address,
                                              jlong b_address, jlong size) {
    return memcmp((const void *) a_address, (const void *) b_address, (size_t) size);
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_copy(__attribute__((unused)) JNIEnv *env,
                                           __attribute__((unused)) jclass clazz, jlong dest_address,
                                           jlong src_address, jlong size) {
    return (jlong) memcpy((void *) dest_address, (void *) src_address, (size_t) size);
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Memory_copyOverlapped(__attribute__((unused)) JNIEnv *env,
                                           __attribute__((unused)) jclass clazz, jlong dest_address,
                                           jlong src_address, jlong size) {
    return (jlong) memmove((void *) dest_address, (void *) src_address, (size_t) size);
}

#ifdef __cplusplus
}
#endif
