package com.adefruandta.jkotlin;

public class ValFloat extends JKObject<Float> implements Val<Float>, ValNumber<Float> {

    public static ValBuilder<Float, ValFloat> val() {
        return new ValBuilder<>(ValFloat.class);
    }

    public static LazyBuilder<Float, ValFloat> lazy() {
        return new LazyBuilder<>(ValFloat.class);
    }
}
