package com.adefruandta.jkotlin;

import java.util.stream.IntStream;

public interface ValCharSequence<T extends CharSequence> extends Val<T> {

    default VarInteger length() {
        return let(in -> VarInteger.var().value(in.length()), VarInteger.var()).build();
    }

    default VarCharacter charAt(int var1) {
        return let(in -> VarCharacter.var().value(in.charAt(var1)), VarCharacter.var()).build();
    }

    @SuppressWarnings("unchecked")
    default ValCharSequence<T> subSequence(int var1, int var2) {
        return (ValCharSequence<T>) let(in -> ValBuilder.of(getClass()).value(in.subSequence(var1, var2)),
                                        ValBuilder.of(getClass())).build();
    }

    default VarObject<IntStream> chars() {
        return let(in -> VarObject.var(IntStream.class).value(in.chars()), VarObject.var(IntStream.class)).build();
    }

    default VarObject<IntStream> codePoints() {
        return let(in -> VarObject.var(IntStream.class).value(in.codePoints()), VarObject.var(IntStream.class)).build();
    }
}
