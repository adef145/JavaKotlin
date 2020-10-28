package com.adefruandta.jkotlin;

public interface ValNumber<T extends Number> extends Val<T> {

    default VarByte toByte() {
        return let(in -> VarByte.var().value(in.byteValue()), VarByte.var()).build();
    }

    default VarDouble toDouble() {
        return let(in -> VarDouble.var().value(in.doubleValue()), VarDouble.var()).build();
    }

    default VarFloat toFloat() {
        return let(in -> VarFloat.var().value(in.floatValue()), VarFloat.var()).build();
    }

    default VarInteger toInteger() {
        return let(in -> VarInteger.var().value(in.intValue()), VarInteger.var()).build();
    }

    default VarLong toLong() {
        return let(in -> VarLong.var().value(in.longValue()), VarLong.var()).build();
    }

    default VarShort toShort() {
        return let(in -> VarShort.var().value(in.shortValue()), VarShort.var()).build();
    }
}
