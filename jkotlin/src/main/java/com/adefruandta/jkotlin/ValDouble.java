package com.adefruandta.jkotlin;

public class ValDouble extends JKObject<Double> implements Val<Double>, ValNumber<Double> {

    public static ValBuilder<Double, ValDouble> val() {
        return new ValBuilder<>(ValDouble.class);
    }

    public static LazyBuilder<Double, ValDouble> lazy() {
        return new LazyBuilder<>(ValDouble.class);
    }
}
