package io.github.droideco.dalvik.ffi;

@FunctionalInterface
public interface FFIRawClosureHandler {

    void invoke(FFICallContext context, long rvalue, long avalues) throws Throwable;

    default void preInvoke(FFICallContext context) {}
    default void postInvoke(FFICallContext context) {}

}
