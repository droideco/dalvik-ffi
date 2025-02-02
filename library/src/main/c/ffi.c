#ifdef __cplusplus
extern "C" {
#endif

#include <jni.h>
#include <stdlib.h>
#include <string.h>
#include <ffi.h>

JNIEXPORT jlong JNICALL
nGetFFITypeVoid(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_void;
}

JNIEXPORT jlong JNICALL
nGetFFITypeSInt8(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint8;
}

JNIEXPORT jlong JNICALL
nGetFFITypeSInt16(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint16;
}

JNIEXPORT jlong JNICALL
nGetFFITypeUInt16(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_uint16;
}

JNIEXPORT jlong JNICALL
nGetFFITypeSInt32(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint32;
}

JNIEXPORT jlong JNICALL
nGetFFITypeSInt64(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_sint64;
}

JNIEXPORT jlong JNICALL
nGetFFITypeFloat(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_float;
}

JNIEXPORT jlong JNICALL
nGetFFITypeDouble(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_double;
}

JNIEXPORT jlong JNICALL
nGetFFITypePointer(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz) {
    return (jlong) &ffi_type_pointer;
}

JNIEXPORT void JNICALL
Java_io_github_droideco_dalvik_ffi_Dispatch_nCriticalCall(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong cif, jlong fn, jlong rvalue, jlong avalues) {
    ffi_call((ffi_cif *) cif, FFI_FN(fn), (void *) rvalue, (void **) avalues);
}

static jclass ffi_closure_class;
static jmethodID nDispatch_methodID;

__attribute__ ((visibility ("hidden"))) jint JNICALL FFI_OnLoad(JNIEnv *env) {
    jclass ffi_type_class = (*env)->FindClass(env, "io/github/droideco/dalvik/ffi/Type");
    if (ffi_type_class == NULL) return JNI_ERR;
    if (android_get_device_api_level() < __ANDROID_API_O__) {
        JNINativeMethod ffi_type_methods[] = {
                {"nGetFFITypeVoid",    "!()J", &nGetFFITypeVoid},
                {"nGetFFITypeSInt8",    "!()J", &nGetFFITypeSInt8},
                {"nGetFFITypeSInt16",   "!()J", &nGetFFITypeSInt16},
                {"nGetFFITypeUInt16",   "!()J", &nGetFFITypeUInt16},
                {"nGetFFITypeSInt32",   "!()J", &nGetFFITypeSInt32},
                {"nGetFFITypeSInt64",   "!()J", &nGetFFITypeSInt64},
                {"nGetFFITypeFloat",   "!()J", &nGetFFITypeFloat},
                {"nGetFFITypeDouble",  "!()J", &nGetFFITypeDouble},
                {"nGetFFITypePointer", "!()J", &nGetFFITypePointer}
        };
        if ((*env)->RegisterNatives(env, ffi_type_class, ffi_type_methods, sizeof(ffi_type_methods) / sizeof(ffi_type_methods[0])) != JNI_OK)
            return JNI_ERR;
    }
    else {
        JNINativeMethod ffi_type_methods[] = {
                {"nGetFFITypeVoid",    "()J", &nGetFFITypeVoid},
                {"nGetFFITypeSInt8",    "()J", &nGetFFITypeSInt8},
                {"nGetFFITypeSInt16",   "()J", &nGetFFITypeSInt16},
                {"nGetFFITypeUInt16",   "()J", &nGetFFITypeUInt16},
                {"nGetFFITypeSInt32",   "()J", &nGetFFITypeSInt32},
                {"nGetFFITypeSInt64",   "()J", &nGetFFITypeSInt64},
                {"nGetFFITypeFloat",   "()J", &nGetFFITypeFloat},
                {"nGetFFITypeDouble",  "()J", &nGetFFITypeDouble},
                {"nGetFFITypePointer", "()J", &nGetFFITypePointer}
        };
        if ((*env)->RegisterNatives(env, ffi_type_class, ffi_type_methods, sizeof(ffi_type_methods) / sizeof(ffi_type_methods[0])) != JNI_OK)
            return JNI_ERR;
    }
    jclass ffi_dispatch_class = (*env)->FindClass(env, "io/github/droideco/dalvik/ffi/Dispatch");
    if (ffi_dispatch_class == NULL) return JNI_ERR;
    if (android_get_device_api_level() < __ANDROID_API_O__) {
        JNINativeMethod ffi_dispatch_methods[] = {
                {"nFastCall",    "!(JJJJ)V", &Java_io_github_droideco_dalvik_ffi_Dispatch_nCriticalCall},
                {"nCriticalCall",    "!(JJJJ)V", &Java_io_github_droideco_dalvik_ffi_Dispatch_nCriticalCall}
        };
        if ((*env)->RegisterNatives(env, ffi_dispatch_class, ffi_dispatch_methods, sizeof(ffi_dispatch_methods) / sizeof(ffi_dispatch_methods[0])) != JNI_OK)
            return JNI_ERR;
    }
    else {
        JNINativeMethod ffi_dispatch_methods[] = {
                {"nFastCall",    "(JJJJ)V", &Java_io_github_droideco_dalvik_ffi_Dispatch_nCriticalCall},
                {"nCriticalCall",    "(JJJJ)V", &Java_io_github_droideco_dalvik_ffi_Dispatch_nCriticalCall}
        };
        if ((*env)->RegisterNatives(env, ffi_dispatch_class, ffi_dispatch_methods, sizeof(ffi_dispatch_methods) / sizeof(ffi_dispatch_methods[0])) != JNI_OK)
            return JNI_ERR;
    }
    ffi_closure_class = (*env)->FindClass(env, "io/github/droideco/dalvik/ffi/Closure");
    if (ffi_closure_class == NULL) return JNI_ERR;
    ffi_closure_class = (*env)->NewGlobalRef(env, ffi_closure_class);
    nDispatch_methodID = (*env)->GetStaticMethodID(env, ffi_closure_class, "nDispatch", "(JJJJ)V");
    if (nDispatch_methodID == NULL) return JNI_ERR;
    return JNI_OK;
}

__attribute__ ((visibility ("hidden"))) void JNICALL FFI_OnUnload(JNIEnv *env) {
    if (env != NULL) {
        (*env)->DeleteGlobalRef(env, ffi_closure_class);
    }
    nDispatch_methodID = NULL;
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Type_nAllocateFFITypeSInt8Array(__attribute__((unused)) JNIEnv *env,
                                                                   __attribute__((unused)) jclass clazz,
                                                                   jlong size, jlong elements) {
    ffi_type *type = (ffi_type *) malloc(sizeof(ffi_type));
    if (type == NULL) return (jlong) NULL;
    type->size = (size_t) size;
    type->alignment = 1;
    type->type = FFI_TYPE_STRUCT;
    type->elements = (ffi_type **) elements;
    return (jlong) type;
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_CallContext_nAllocateCIF(__attribute__((unused)) JNIEnv *env,
                                                            __attribute__((unused)) jclass clazz) {
    return (jlong) malloc(sizeof(ffi_cif));
}

JNIEXPORT jint JNICALL
Java_io_github_droideco_dalvik_ffi_CallContext_nInitializeCIF(__attribute__((unused)) JNIEnv *env,
                                                              __attribute__((unused)) jclass clazz, jlong cif,
                                                              jlong rtype,
                                                              jlong atypes, jint nargs) {
    return ffi_prep_cif((ffi_cif *) cif, FFI_DEFAULT_ABI, (unsigned int) nargs,(ffi_type *) rtype,
                        (ffi_type **) atypes);
}

JNIEXPORT jint JNICALL
Java_io_github_droideco_dalvik_ffi_CallContext_nInitializeCIFVariadic(__attribute__((unused)) JNIEnv *env,
                                                                      __attribute__((unused)) jclass clazz,
                                                                      jlong cif,
                                                                      jlong rtype, jlong atypes,
                                                                      jint nfixedargs, jint ntotalargs) {
    return ffi_prep_cif_var((ffi_cif *) cif, FFI_DEFAULT_ABI,
                            (unsigned int) nfixedargs, (unsigned int) ntotalargs,
                            (ffi_type *) rtype, (ffi_type **) atypes);
}

extern JavaVM *VM;

static void nDispatch(ffi_cif *cif, void *rvalue, void **avalues, void *user_data) {
    JNIEnv *env;
    if ((*VM)->AttachCurrentThread(VM, &env, NULL) != JNI_OK) return;
    (*env)->CallStaticVoidMethod(env, ffi_closure_class, nDispatch_methodID, (jlong) cif, (jlong) rvalue, (jlong) avalues, (jlong) user_data);
}

JNIEXPORT jlong JNICALL
Java_io_github_droideco_dalvik_ffi_Closure_nAllocateClosure(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz, jlong pfp) {
    return (jlong) ffi_closure_alloc(sizeof(ffi_closure), (void **) pfp);
}

JNIEXPORT jint JNICALL
Java_io_github_droideco_dalvik_ffi_Closure_nInitializeClosure(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                              jlong closure, jlong cif,
                                                              jlong user_data, jlong fp) {
    return ffi_prep_closure_loc((ffi_closure *) closure, (ffi_cif *) cif, &nDispatch, (void *) user_data, (void *) fp);
}

JNIEXPORT void JNICALL
Java_io_github_droideco_dalvik_ffi_Closure_nFreeClosure(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                        jlong closure) {
    ffi_closure_free((void *) closure);
}

JNIEXPORT jobject JNICALL
Java_io_github_droideco_dalvik_ffi_FFIClosure_nNewDirectByteBuffer(JNIEnv *env, __attribute__((unused)) jclass clazz,
                                                               jlong address, jlong capacity) {
    return (*env)->NewDirectByteBuffer(env, (void *) address, capacity);
}

#ifdef __cplusplus
}
#endif
