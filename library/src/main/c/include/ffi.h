#ifndef DALFIK_FFI_H
#define DALFIK_FFI_H

#ifdef __x86_64__
#include <x86_64/ffi.h>
#elif defined(__i386__)
#include <x86/ffi.h>
#elif defined(__aarch64__)
#include <arm64-v8a/ffi.h>
#elif defined(__arm__)
#include <armeabi-v7a/ffi.h>
#else
#error unsupported target
#endif

#endif //DALFIK_FFI_H
