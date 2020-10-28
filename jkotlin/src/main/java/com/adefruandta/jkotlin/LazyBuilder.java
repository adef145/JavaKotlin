package com.adefruandta.jkotlin;

public class LazyBuilder<T, V extends com.adefruandta.jkotlin.Val<T>> implements Builder<V> {

    private Class<? extends JKObject> jkObjectClass;

    private Factory0<T> initiatorFactory;

    public LazyBuilder(Class<? extends JKObject> jkObjectClass) {
        this.jkObjectClass = jkObjectClass;
    }

    public static <T, V extends Val<T>> LazyBuilder<T, V> of(Class<V> classOfVal) {
        return new LazyBuilder<>((Class<? extends JKObject>) classOfVal);
    }

    public LazyBuilder<T, V> initiator(Factory0<T> initiatorFactory) {
        this.initiatorFactory = initiatorFactory;
        return this;
    }

    @Override
    public V build() {
        try {
            JKObject<T> jkObject = (JKObject<T>) jkObjectClass.newInstance();
            jkObject.initiatorFactory = initiatorFactory;
            return (V) jkObject;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
