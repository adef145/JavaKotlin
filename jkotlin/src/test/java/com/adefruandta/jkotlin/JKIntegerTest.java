package com.adefruandta.jkotlin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JKIntegerTest {

    @Test
    public void val_test() {
        ValInteger val = ValInteger.val().build();
        assertTrue(val.isNull().get());

        val = ValInteger.val().value(1).build();
        assertEquals(1, val.get(), 0);

        val = ValInteger.val().getter(in -> 1).build();
        assertEquals(1, val.get(), 0);

        val = ValInteger.lazy().initiator(() -> 1).build();
        assertEquals(1, val.get(), 0);
        assertEquals(1, val.toInteger().get(), 0);
    }

    @Test
    public void var_test() {
        VarInteger var = VarInteger.var().build();
        assertTrue(var.isNull().get());

        var = VarInteger.var()
                .value(1)
                .getter(in -> 1)
                .setter(in -> {
                    assertEquals(in, 1, 0);
                    return in;
                })
                .build();
        assertEquals(1, var.get(), 0);
        var.set(1);
    }
}
