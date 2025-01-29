#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <dlfcn.h>

__attribute__ ((visibility ("hidden"))) JavaVM *VM;

extern jint Dispatch_OnLoad(JNIEnv *env);
extern jint FFI_OnLoad(JNIEnv *env);
extern jint Memory_OnLoad(JNIEnv *env);
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, __attribute__((unused)) void *reserved) {
    JNIEnv *env;
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) return JNI_ERR;
    if (Dispatch_OnLoad(env) != JNI_OK) return JNI_ERR;
    if (FFI_OnLoad(env) != JNI_OK) return JNI_ERR;
    if (Memory_OnLoad(env) != JNI_OK) return JNI_ERR;
    VM = vm;
    return JNI_VERSION_1_6;
}

extern void FFI_OnUnload(JNIEnv *env);

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM* vm, __attribute__((unused)) void* reserved) {
    JNIEnv *env;
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) env = NULL;
    FFI_OnUnload(env);
    VM = NULL;
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Library_dlsym(JNIEnv *env, __attribute__((unused)) jclass clazz,
                                             jstring symbol) {
    jboolean is_copy = JNI_FALSE;
    const char *c_symbol = (*env)->GetStringUTFChars(env, symbol, &is_copy);
    if (c_symbol == NULL) return (jlong) NULL;
    void *result = dlsym(RTLD_DEFAULT, c_symbol);
    if (is_copy) (*env)->ReleaseStringUTFChars(env, symbol, c_symbol);
    return (jlong) result;
}

JNIEXPORT jstring JNICALL
Java_io_github_droideco_dalvik_ffi_Library_dlerror(JNIEnv *env, __attribute__((unused)) jclass clazz) {
    char *error = dlerror();
    if (error == NULL) return NULL;
    else return (*env)->NewStringUTF(env, error);
}

JNIEXPORT jstring JNICALL
Java_io_github_droideco_dalvik_ffi_Library_nABI(JNIEnv *env, __attribute__((unused)) jclass clazz) {
#ifdef __aarch64__
    return (*env)->NewStringUTF(env, "arm64-v8a");
#elif defined(__arm__)
    return (*env)->NewStringUTF(env, "armeabi-v7a");
#elif defined(__x86_64__)
    return (*env)->NewStringUTF(env, "x86_64");
#elif defined(__i386__)
    return (*env)->NewStringUTF(env, "x86");
#else
#error unsupported target
#endif
}

#ifdef __cplusplus
}
#endif
