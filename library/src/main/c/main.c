#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>

JNIEXPORT jint JNICALL Dispatch_OnLoad(JNIEnv *env);
JNIEXPORT jint JNICALL FFI_OnLoad(JNIEnv *env);
JNIEXPORT jint JNICALL Memory_OnLoad(JNIEnv *env);
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, __attribute__((unused)) void *reserved) {
    JNIEnv *env;
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) return JNI_ERR;
    if (Dispatch_OnLoad(env) != JNI_OK) return JNI_ERR;
    if (FFI_OnLoad(env) != JNI_OK) return JNI_ERR;
    if (Memory_OnLoad(env) != JNI_OK) return JNI_ERR;
    return JNI_VERSION_1_6;
}

#ifdef __cplusplus
}
#endif