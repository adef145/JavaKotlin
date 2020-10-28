package com.adefruandta.jkotlin;

public class VarString extends ValString implements Var<String> {

    public static VarBuilder<String, VarString> var() {
        return new VarBuilder<>(VarString.class);
    }
}
