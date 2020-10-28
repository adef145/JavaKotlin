package com.adefruandta.jkotlin;

public class VarFloat extends ValFloat implements Var<Float> {

    public static VarBuilder<Float, VarFloat> var() {
        return new VarBuilder<>(VarFloat.class);
    }
}
