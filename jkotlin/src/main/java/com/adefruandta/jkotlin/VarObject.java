package com.adefruandta.jkotlin;

public class VarObject<T> extends ValObject<T> implements Var<T> {

    public static <T> VarBuilder<T, VarObject<T>> var(Class<T> classOfT) {
        return new VarBuilder<>(VarObject.class);
    }
}
