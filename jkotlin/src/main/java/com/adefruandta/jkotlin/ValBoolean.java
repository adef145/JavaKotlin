package com.adefruandta.jkotlin;

public class ValBoolean extends JKObject<Boolean> implements Val<Boolean> {

    public static ValBuilder<Boolean, ValBoolean> val() {
        return new ValBuilder<>(ValBoolean.class);
    }

    public static LazyBuilder<Boolean, ValBoolean> lazy() {
        return new LazyBuilder<>(ValBoolean.class);
    }
}
