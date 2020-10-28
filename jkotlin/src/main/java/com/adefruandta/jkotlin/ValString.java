package com.adefruandta.jkotlin;

public class ValString extends JKObject<String> implements Val<String>, ValCharSequence<String> {

    public static ValBuilder<String, ValString> val() {
        return new ValBuilder<>(ValString.class);
    }

    public static LazyBuilder<String, ValString> lazy() {
        return new LazyBuilder<>(ValString.class);
    }
}
