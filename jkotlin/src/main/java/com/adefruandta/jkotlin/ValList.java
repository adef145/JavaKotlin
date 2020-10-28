package com.adefruandta.jkotlin;

import java.util.List;

public interface ValList<T, V extends List<T>> extends Val<V> {

    default T get(int position) {
        return let(in -> in.get(position));
    }

    default VarBoolean add(T value) {
        return let(in -> VarBoolean.var().value(in.add(value)), VarBoolean.var()).build();
    }

    default void forEach(Apply1<T> apply) {
        apply(in -> {
            for (T value : in) {
                apply.run(value);
            }
        });
    }

    default T getOrDefault(int position, T defaultValue) {
        return let(in -> in.get(position), defaultValue);
    }

    default VarInteger size() {
        return let(in -> VarInteger.var().value(in.size()), VarInteger.var()).build();
    }

    default VarBoolean isEmpty() {
        return let(in -> VarBoolean.var().value(in.isEmpty()), VarBoolean.var().value(false)).build();
    }

    default VarBoolean contains(Object var1) {
        return let(in -> VarBoolean.var().value(in.contains(var1)), VarBoolean.var()).build();
    }
}
