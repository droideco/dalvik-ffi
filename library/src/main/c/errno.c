#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <errno.h>

static void JNICALL
setErrno(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jint errnum) {
    errno = errnum;
}

static jint JNICALL
getErrno(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return errno;
}

__attribute__ ((visibility ("hidden"))) jint JNICALL Errno_OnLoad(JNIEnv *env) {
    jclass clazz = (*env)->FindClass(env, "io/github/droideco/dalvik/ffi/Errno");
    if (clazz == NULL) return JNI_ERR;
    if (android_get_device_api_level() < __ANDROID_API_O__) {
        JNINativeMethod methods[] = {
                {"getErrno", "!()I", &getErrno},
                {"setErrno", "!(I)V", &setErrno}
        };
        if ((*env)->RegisterNatives(env, clazz, methods, sizeof(methods) / sizeof(methods[0])) !=
            JNI_OK)
            return JNI_ERR;
    } else {
        JNINativeMethod methods[] = {
                {"getErrno", "()I", &getErrno},
                {"setErrno", "(I)V", &setErrno}
        };
        if ((*env)->RegisterNatives(env, clazz, methods, sizeof(methods) / sizeof(methods[0])) !=
            JNI_OK)
            return JNI_ERR;
    }
    return JNI_OK;
}

#ifdef __cplusplus
}
#endif
