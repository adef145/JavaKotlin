package com.adefruandta.jkotlin;

public class VarInteger extends ValInteger implements Var<Integer> {

    public static VarBuilder<Integer, VarInteger> var() {
        return new VarBuilder<>(VarInteger.class);
    }
}
