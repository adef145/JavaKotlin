package com.adefruandta.jkotlin;

public class JKUtils {

    public static <T, R extends JKObject<T>> R of(Class<R> rClass, T value, Factory0<T> initiatorFactory,
                                                  Factory1<T, T> getterFactory, Factory1<T, T> setterFactory) {
        try {
            R val = rClass.newInstance();
            val.value = value;
            val.initiatorFactory = initiatorFactory;
            val.getterFactory = getterFactory;
            val.setterFactory = setterFactory;
            return val;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T, R extends JKObject<T>> R val(Class<R> rClass, T value, Factory0<T> initiatorFactory,
                                                    Factory1<T, T> getterFactory) {
        return of(rClass, value, initiatorFactory, getterFactory, null);
    }

    public static <T, R extends JKObject<T>> R var(Class<R> rClass, T value, Factory1<T, T> getterFactory,
                                                    Factory1<T, T> setterFactory) {
        return of(rClass, value, null, getterFactory, setterFactory);
    }

    public static <T, R> R let(T in, Factory1<T, R> factory) {
        try {
            return factory.get(in);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T, R> R let(T in, Factory1<T, R> factory, R defaultValue) {
        try {
            return factory.get(in);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T also(T in, Factory1<T, T> factory) {
        try {
            return factory.get(in);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T also(T in, Factory1<T, T> factory, T defaultValue) {
        try {
            return factory.get(in);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T apply(T in, Apply1<T> factory) {
        try {
            factory.run(in);
        } catch (Exception e) {
            // do nothing
        }

        return in;
    }
}
