package com.adefruandta.jkotlin;

public interface Var<T> extends Val<T> {

    @SuppressWarnings("unchecked")
    default void set(T value) {
        if (this instanceof JKObject) {
            ((JKObject<T>) this).setterHandler(value);
            return;
        }

        throw new RuntimeException("This instance not inherited from JKObject");
    }
}
