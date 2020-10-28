package com.adefruandta.jkotlin;

public class ValBuilder<T, V extends com.adefruandta.jkotlin.Val<T>> implements Builder<V> {

    private Class<? extends JKObject> jkObjectClass;

    private T initialValue;

    private com.adefruandta.jkotlin.Factory1<T, T> getterFactory;

    public ValBuilder(Class<? extends JKObject> jkObjectClass) {
        this.jkObjectClass = jkObjectClass;
    }

    public static <T, V extends Val<T>> ValBuilder<T, V> of(Class<V> classOfVal) {
        return new ValBuilder<>((Class<? extends JKObject>) classOfVal);
    }

    public ValBuilder<T, V> value(T value) {
        this.initialValue = value;
        return this;
    }

    public ValBuilder<T, V> getter(Factory1<T, T> getterFactory) {
        this.getterFactory = getterFactory;
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V build() {
        try {
            JKObject<T> jkObject = (JKObject<T>) jkObjectClass.newInstance();
            jkObject.value = initialValue;
            jkObject.getterFactory = getterFactory;
            return (V) jkObject;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
