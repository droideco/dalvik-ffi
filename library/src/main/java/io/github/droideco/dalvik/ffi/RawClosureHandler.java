package io.github.droideco.dalvik.ffi;

@FunctionalInterface
public interface RawClosureHandler {

    void invoke(Closure closure, long rvalue, long avalues) throws Throwable;

    default void preInvoke(Closure closure) {}
    default void postInvoke(Closure closure) {}

}
