package io.github.droideco.dalvik.ffi;

public interface FFIClosureHandler {
    void invoke(FFICallContext context, long rvalue, long avalues) throws Throwable;
}
