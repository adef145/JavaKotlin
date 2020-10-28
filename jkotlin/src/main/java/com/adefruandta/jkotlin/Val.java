package com.adefruandta.jkotlin;

public interface Val<T> extends Comparable<T> {

    boolean equals(Object o);

    int hashCode();

    String toString();

    @Override
    default int compareTo(T t) {
        if (isNull().get()) {
            return 1;
        }

        if (get() instanceof Comparable) {
            return ((Comparable<T>) get()).compareTo(t);
        }

        return get().equals(t) ? 0 : -1;
    }

    default VarBoolean isNull() {
        return VarBoolean.var().value(get() == null).build();
    }

    default <R> R let(Factory1<T, R> factory) {
        return JKUtils.let(get(), factory);
    }

    default <R> R let(Factory1<T, R> factory, R defaultValue) {
        return JKUtils.let(get(), factory, defaultValue);
    }

    default T also(Factory1<T, T> factory) {
        return JKUtils.also(get(), factory);
    }

    default T also(Factory1<T, T> factory, T defaultValue) {
        return JKUtils.also(get(), factory, defaultValue);
    }

    default T apply(Apply1<T> apply) {
        return JKUtils.apply(get(), apply);
    }

    @SuppressWarnings("unchecked")
    default T get() {
        if (this instanceof JKObject) {
            return ((JKObject<T>) this).getterHandler();
        }

        throw new RuntimeException("This instance not inherited from JKObject");
    }

    @SuppressWarnings("unchecked")
    default <V> V getAs(Class<V> vClass) {
        return (V) get();
    }

    default T getOrDefault(T defaultValue) {
        return JKUtils.also(get(), in -> in, defaultValue);
    }

    default <V> VarBoolean is(Class<V> vClass) {
        return let(in -> VarBoolean.var().value(vClass.isAssignableFrom(in.getClass())), VarBoolean.var().value(false))
                .build();
    }
}
