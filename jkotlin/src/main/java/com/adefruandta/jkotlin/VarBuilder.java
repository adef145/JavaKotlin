package com.adefruandta.jkotlin;

public class VarBuilder<T, V extends Var<T>> implements Builder<V> {

    private Class<? extends JKObject> jkObjectClass;

    private T initialValue;

    private com.adefruandta.jkotlin.Factory1<T, T> getterFactory;

    private com.adefruandta.jkotlin.Factory1<T, T> setterFactory;

    public VarBuilder(Class<? extends JKObject> jkObjectClass) {
        this.jkObjectClass = jkObjectClass;
    }

    public static <T, V extends Var<T>> VarBuilder<T, V> of(Class<V> classOfVal) {
        return new VarBuilder<>((Class<? extends JKObject>) classOfVal);
    }

    public VarBuilder<T, V> value(T value) {
        this.initialValue = value;
        return this;
    }

    public VarBuilder<T, V> getter(com.adefruandta.jkotlin.Factory1<T, T> getterFactory) {
        this.getterFactory = getterFactory;
        return this;
    }

    public VarBuilder<T, V> setter(Factory1<T, T> setterFactory) {
        this.setterFactory = setterFactory;
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V build() {
        try {
            JKObject<T> jkObject = (JKObject<T>) jkObjectClass.newInstance();
            jkObject.value = initialValue;
            jkObject.getterFactory = getterFactory;
            jkObject.setterFactory = setterFactory;
            return (V) jkObject;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
