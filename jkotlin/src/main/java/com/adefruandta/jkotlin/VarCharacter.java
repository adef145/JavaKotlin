package com.adefruandta.jkotlin;

public class VarCharacter extends ValCharacter implements Var<Character> {

    public static VarBuilder<Character, VarCharacter> var() {
        return new VarBuilder<>(VarCharacter.class);
    }
}
