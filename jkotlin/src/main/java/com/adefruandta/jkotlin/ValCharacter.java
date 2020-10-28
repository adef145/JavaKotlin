package com.adefruandta.jkotlin;

public class ValCharacter extends JKObject<Character> implements Val<Character> {

    public static ValBuilder<Character, ValCharacter> val() {
        return new ValBuilder<>(ValCharacter.class);
    }

    public static LazyBuilder<Character, ValCharacter> lazy() {
        return new LazyBuilder<>(ValCharacter.class);
    }
}
