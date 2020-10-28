package com.adefruandta.jkotlin;

public class ValByte extends JKObject<Byte> implements Val<Byte>, ValNumber<Byte> {

    public static ValBuilder<Byte, ValByte> val() {
        return new ValBuilder<>(ValByte.class);
    }

    public static LazyBuilder<Byte, ValByte> lazy() {
        return new LazyBuilder<>(ValByte.class);
    }
}
