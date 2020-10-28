package com.adefruandta.jkotlin;

public class VarShort extends ValShort implements Var<Short> {

    public static VarBuilder<Short, VarShort> var() {
        return new VarBuilder<>(VarShort.class);
    }
}
