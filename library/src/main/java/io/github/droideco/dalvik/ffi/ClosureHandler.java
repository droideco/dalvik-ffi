package io.github.droideco.dalvik.ffi;

@FunctionalInterface
public interface ClosureHandler {

    Object invoke(Object... args) throws Throwable;

    default Object invoke(Closure closure, Object... args) throws Throwable {
        return invoke(args);
    }
    default void preInvoke(Closure closure) {}
    default void postInvoke(Closure closure) {}

}
