package com.adefruandta.jkotlin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JKObjectTest {

    @Test
    public void val_test() {
        ValObject<String> val = ValObject.val(String.class).build();
        assertTrue(val.isNull().get());

        val = ValObject.val(String.class).value("Test").build();
        assertEquals("Test", val.get());

        val = ValObject.val(String.class).getter(in -> "Test").build();
        assertEquals("Test", val.get());

        val = ValObject.lazy(String.class).initiator(() -> "Test").build();
        assertEquals("Test", val.get());
    }

    @Test
    public void var_test() {
        VarObject<String> var = VarObject.var(String.class).build();
        assertTrue(var.isNull().get());

        var = VarObject.var(String.class)
                .value("Test")
                .getter(in -> "Test")
                .setter(in -> {
                    assertEquals(in, "Test");
                    return in;
                })
                .build();
        assertEquals("Test", var.get());
        var.set("Test");
    }
}
