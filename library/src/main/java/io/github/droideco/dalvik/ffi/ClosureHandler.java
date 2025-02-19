package io.github.droideco.dalvik.ffi;

@FunctionalInterface
public interface ClosureHandler {

    Object invoke(Closure closure, Object... args) throws Throwable;
    default void preInvoke(Closure closure) {}
    default void postInvoke(Closure closure) {}

}
