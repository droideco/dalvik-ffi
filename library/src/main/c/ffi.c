#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <stdlib.h>
#include <string.h>
#include <ffi.h>

JNIEXPORT jlong JNICALL
getFFITypeVoid(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_void;
}

JNIEXPORT jlong JNICALL
getFFITypeSInt8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint8;
}

JNIEXPORT jlong JNICALL
getFFITypeSInt16(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint16;
}

JNIEXPORT jlong JNICALL
getFFITypeSInt32(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint32;
}

JNIEXPORT jlong JNICALL
getFFITypeSInt64(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint64;
}

JNIEXPORT jlong JNICALL
getFFITypeFloat(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_float;
}

JNIEXPORT jlong JNICALL
getFFITypeDouble(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_double;
}

JNIEXPORT jlong JNICALL
getFFITypePointer(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_pointer;
}

JNIEXPORT void JNICALL
fastCall(__attribute__((unused)) JNIEnv *env,
                                                __attribute__((unused)) jclass clazz, jlong cif,
                                                jlong fn,
                                                jlong rvalue, jlong avalues) {
    return ffi_call((ffi_cif *) cif, FFI_FN(fn), (void *) rvalue, (void **) avalues);
}

JNIEXPORT void JNICALL
criticalCall(__attribute__((unused)) JNIEnv *env,
                                                __attribute__((unused)) jclass clazz, jlong cif,
                                                jlong fn,
                                                jlong rvalue, jlong avalues) {
    return ffi_call((ffi_cif *) cif, FFI_FN(fn), (void *) rvalue, (void **) avalues);
}

JNIEXPORT jint JNICALL FFI_OnLoad(JNIEnv *env) {
    jclass ffi_type_class = (*env)->FindClass(env, "io/github/multiffi/dalfik/FFIType");
    if (ffi_type_class == NULL) return JNI_ERR;
    JNINativeMethod ffi_type_methods[] = {
            {"getFFITypeVoid",    "!()J", &getFFITypeVoid},
            {"getFFITypeSInt8",    "!()J", &getFFITypeSInt8},
            {"getFFITypeSInt16",   "!()J", &getFFITypeSInt16},
            {"getFFITypeSInt32",   "!()J", &getFFITypeSInt32},
            {"getFFITypeSInt64",   "!()J", &getFFITypeSInt64},
            {"getFFITypeFloat",   "!()J", &getFFITypeFloat},
            {"getFFITypeDouble",  "!()J", &getFFITypeDouble},
            {"getFFITypePointer", "!()J", &getFFITypePointer}
    };
    if ((*env)->RegisterNatives(env, ffi_type_class, ffi_type_methods, sizeof(ffi_type_methods) / sizeof(ffi_type_methods[0])) != JNI_OK)
        return JNI_ERR;
    jclass ffi_dispatch_class = (*env)->FindClass(env, "io/github/multiffi/dalfik/FFIDispatch");
    if (ffi_dispatch_class == NULL) return JNI_ERR;
    JNINativeMethod ffi_dispatch_methods[] = {
            {"fastCall",    "!(JJJJ)V", &fastCall},
            {"criticalCall",    "!(JJJJ)V", &criticalCall}
    };
    if ((*env)->RegisterNatives(env, ffi_dispatch_class, ffi_dispatch_methods, sizeof(ffi_dispatch_methods) / sizeof(ffi_dispatch_methods[0])) != JNI_OK)
        return JNI_ERR;
    return JNI_OK;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_FFIType_allocateFFITypeSInt8Array(__attribute__((unused)) JNIEnv *env,
                                                                 __attribute__((unused)) jclass clazz,
                                                                 jlong size) {
    size_t count = (size_t) size;
    const uint8_t *allocated = (uint8_t *) malloc(sizeof(ffi_type) + count * sizeof(ffi_type *));
    ffi_type *type = (ffi_type *) allocated;
    type->size = count;
    type->alignment = 1;
    type->type = FFI_TYPE_STRUCT;
    ffi_type **elements = (ffi_type **) (allocated + sizeof(ffi_type));
    for (size_t i = 0; i < count; i++) {
        elements[i] = &ffi_type_sint8;
    }
    type->elements = elements;
    return (jlong) allocated;
}

JNIEXPORT jlong JNICALL
Java_io_github_multiffi_dalfik_FFICallContext_allocateFFICIF(__attribute__((unused)) JNIEnv *env,
                                                  __attribute__((unused)) jclass clazz) {
    return (jlong) memset(malloc(sizeof(ffi_cif)), 0, sizeof(ffi_cif));
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_FFICallContext_initializeFFICIF(__attribute__((unused)) JNIEnv *env,
                                                    __attribute__((unused)) jclass clazz, jlong cif,
                                                    jlong rtype,
                                                    jlong atypes, jint nargs) {
    return ffi_prep_cif((ffi_cif *) cif, FFI_DEFAULT_ABI, (unsigned int) nargs, (ffi_type *) rtype,
                        (ffi_type **) atypes);
}

JNIEXPORT jint JNICALL
Java_io_github_multiffi_dalfik_FFICallContext_initializeFFICIFVariadic(__attribute__((unused)) JNIEnv *env,
                                                            __attribute__((unused)) jclass clazz,
                                                            jlong cif,
                                                            jlong rtype, jlong atypes,
                                                            jint nfixedargs, jint ntotalargs) {
    return ffi_prep_cif_var((ffi_cif *) cif, FFI_DEFAULT_ABI,
                            (unsigned int) nfixedargs, (unsigned int) ntotalargs,
                            (ffi_type *) rtype, (ffi_type **) atypes);
}

JNIEXPORT void JNICALL
Java_io_github_multiffi_dalfik_FFIDispatch_call(__attribute__((unused)) JNIEnv *env,
                                                __attribute__((unused)) jclass clazz, jlong cif,
                                                jlong fn,
                                                jlong rvalue, jlong avalues) {
    return ffi_call((ffi_cif *) cif, FFI_FN(fn), (void *) rvalue, (void **) avalues);
}

#ifdef __cplusplus
}
#endif
