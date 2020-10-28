package com.adefruandta.jkotlin;

public class VarDouble extends ValDouble implements Var<Double> {

    public static VarBuilder<Double, VarDouble> var() {
        return new VarBuilder<>(VarDouble.class);
    }
}
