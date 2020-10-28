package com.adefruandta.jkotlin;

public class ValObject<T> extends JKObject<T> implements Val<T> {

    public static <T> ValBuilder<T, com.adefruandta.jkotlin.ValObject<T>> val(Class<T> classOfT) {
        return new ValBuilder<>(ValObject.class);
    }

    public static <T> LazyBuilder<T, com.adefruandta.jkotlin.ValObject<T>> lazy(Class<T> classOfT) {
        return new LazyBuilder<>(com.adefruandta.jkotlin.ValObject.class);
    }
}
