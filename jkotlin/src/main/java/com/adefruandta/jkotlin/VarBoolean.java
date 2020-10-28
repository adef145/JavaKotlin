package com.adefruandta.jkotlin;

public class VarBoolean extends ValBoolean implements Var<Boolean> {

    public static VarBuilder<Boolean, VarBoolean> var() {
        return new VarBuilder<>(VarBoolean.class);
    }
}
