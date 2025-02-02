-keepclasseswithmembernames, includedescriptorclasses class io.github.droideco.dalvik.ffi.* {
    native <methods>;
}

-keep class io.github.droideco.dalvik.ffi.Closure {
    void nDispatch(long, long, long, long);
}
