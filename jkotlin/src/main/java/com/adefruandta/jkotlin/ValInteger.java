package com.adefruandta.jkotlin;

public class ValInteger extends JKObject<Integer> implements Val<Integer>, ValNumber<Integer> {

    public static ValBuilder<Integer, ValInteger> val() {
        return new ValBuilder<>(ValInteger.class);
    }

    public static LazyBuilder<Integer, ValInteger> lazy() {
        return new LazyBuilder<>(ValInteger.class);
    }
}
