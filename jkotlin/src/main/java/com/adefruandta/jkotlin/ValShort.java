package com.adefruandta.jkotlin;

public class ValShort extends JKObject<Short> implements Val<Short>, ValNumber<Short> {

    public static ValBuilder<Short, ValShort> val() {
        return new ValBuilder<>(ValShort.class);
    }

    public static LazyBuilder<Short, ValShort> lazy() {
        return new LazyBuilder<>(ValShort.class);
    }
}
