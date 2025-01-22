#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <dlfcn.h>

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_Library_dlsym(JNIEnv *env, __attribute__((unused)) jclass clazz,
                                             jstring symbol) {
    jboolean is_copy = JNI_FALSE;
    const char *c_symbol = (*env)->GetStringUTFChars(env, symbol, &is_copy);
    if (c_symbol == NULL) return (jlong) NULL;
    void *result = dlsym(RTLD_DEFAULT, c_symbol);
    if (is_copy) (*env)->ReleaseStringUTFChars(env, symbol, c_symbol);
    return (jlong) result;
}

JNIEXPORT jstring JNICALL
Java_io_github_multiffi_dalfik_Library_dlerror(JNIEnv *env, __attribute__((unused)) jclass clazz) {
    char *error = dlerror();
    if (error == NULL) return NULL;
    else return (*env)->NewStringUTF(env, error);
}

#ifdef __cplusplus
}
#endif
