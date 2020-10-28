package com.adefruandta.jkotlin;

import java.util.Objects;

import static com.adefruandta.jkotlin.JKUtils.let;

public class JKObject<T> {

    protected com.adefruandta.jkotlin.Factory1<T, T> getterFactory;

    protected Factory1<T, T> setterFactory;

    protected T value;

    protected Factory0<T> initiatorFactory;

    T getterHandler() {
        if (initiatorFactory != null && value == null) {
            value = initiatorFactory.get();
        }

        if (getterFactory != null) {
            value = getterFactory.get(value);
        }

        return value;
    }

    void setterHandler(T value) {
        if (setterFactory != null) {
            this.value = setterFactory.get(value);
        }
        else {
            this.value = value;
        }
    }

    @Override
    public boolean equals(Object o) {
        return let(value, in -> {
            if (in instanceof JKObject) {
                return value.equals(((JKObject) in).value);
            }

            return value.equals(o);
        }, o == null);
    }

    @Override
    public int hashCode() {
        return let(value, Objects::hashCode, super.hashCode());
    }

    @Override
    public String toString() {
        return let(value, Object::toString, super.toString());
    }
}