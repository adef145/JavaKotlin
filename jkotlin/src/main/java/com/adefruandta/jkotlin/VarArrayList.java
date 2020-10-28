package com.adefruandta.jkotlin;

import java.util.ArrayList;

public class VarArrayList<T> extends ValArrayList<T> implements Var<ArrayList<T>> {

    public static <T> VarBuilder<ArrayList<T>, VarArrayList<T>> var(Class<T> classOfVal) {
        return new VarBuilder<>(VarArrayList.class);
    }
}
