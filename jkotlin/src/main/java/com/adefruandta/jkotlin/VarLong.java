package com.adefruandta.jkotlin;

public class VarLong extends ValLong implements Var<Long> {

    public static VarBuilder<Long, VarLong> var() {
        return new VarBuilder<>(VarLong.class);
    }
}
