package com.adefruandta.jkotlin;

public class VarByte extends ValByte implements Var<Byte> {

    public static VarBuilder<Byte, VarByte> var() {
        return new VarBuilder<>(VarByte.class);
    }
}
