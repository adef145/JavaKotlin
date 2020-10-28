package com.adefruandta.jkotlin;

import java.util.ArrayList;

public class ValArrayList<T> extends JKObject<ArrayList<T>> implements Val<ArrayList<T>>, ValList<T, ArrayList<T>> {

    public static <T> ValBuilder<ArrayList<T>, ValArrayList<T>> val() {
        return new ValBuilder<>(ValArrayList.class);
    }

    public static <T> LazyBuilder<ArrayList<T>, ValArrayList<T>> lazy() {
        return new LazyBuilder<>(ValArrayList.class);
    }
}
