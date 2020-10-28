package com.adefruandta.jkotlin;

public class ValLong extends JKObject<Long> implements Val<Long>, ValNumber<Long> {

    public static ValBuilder<Long, ValLong> val() {
        return new ValBuilder<>(ValLong.class);
    }

    public static LazyBuilder<Long, ValLong> lazy() {
        return new LazyBuilder<>(ValLong.class);
    }
}
