package com.adefruandta.serializer;

import com.adefruandta.jkotlin.Var;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JKSerializerTest {

    @Test
    public void serialize_test() {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(Var.class, new JKSerializer()).create();

        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("byte", 1);
        jsonObject1.addProperty("double", 2.0);
        jsonObject1.addProperty("float", 3.0);
        jsonObject1.addProperty("integer", 4);
        jsonObject1.addProperty("long", 5);
        jsonObject1.addProperty("short", 6);
        jsonObject1.addProperty("string", "Text");

        JsonArray jsonArray = new JsonArray();
        jsonArray.add("Text1");
        jsonArray.add(1);
        jsonArray.add(true);
        jsonArray.add('a');

        JsonArray jsonArrayString = new JsonArray();
        jsonArrayString.add("Text1");
        jsonArrayString.add("1");
        jsonArrayString.add("true");
        jsonArrayString.add("a");

        jsonObject1.add("list", jsonArray);
        jsonObject1.add("list_var_string", jsonArrayString);
        jsonObject1.add("list_string", jsonArrayString);
        jsonObject.add("response", jsonObject1);
        jsonObject.add("var_response", jsonObject1);

        Response response = gson.fromJson(jsonObject, Response.class);
        VarResponse varResponse = gson.fromJson(jsonObject, VarResponse.class);

        assertEquals(1, response.response1.let(in -> in.varByte).get(), 0);
        assertEquals(1, response.varResponse1.let(in -> in.varByte).get(), 0);
        assertEquals(1, varResponse.let(in -> in.response1.get().varByte).get(), 0);
        assertEquals(1, varResponse.let(in -> in.response1.get().varByte).get(), 0);

        assertEquals(2, response.response1.let(in -> in.varDouble).get(), 0);
        assertEquals(2, response.varResponse1.let(in -> in.varDouble).get(), 0);
        assertEquals(2, varResponse.let(in -> in.response1.get().varDouble).get(), 0);
        assertEquals(2, varResponse.let(in -> in.response1.get().varDouble).get(), 0);

        assertEquals(3, response.response1.let(in -> in.varFloat).get(), 0);
        assertEquals(3, response.varResponse1.let(in -> in.varFloat).get(), 0);
        assertEquals(3, varResponse.let(in -> in.response1.get().varFloat).get(), 0);
        assertEquals(3, varResponse.let(in -> in.response1.get().varFloat).get(), 0);

        assertEquals(4, response.response1.let(in -> in.varInteger).get(), 0);
        assertEquals(4, response.varResponse1.let(in -> in.varInteger).get(), 0);
        assertEquals(4, varResponse.let(in -> in.response1.get().varInteger).get(), 0);
        assertEquals(4, varResponse.let(in -> in.response1.get().varInteger).get(), 0);

        assertEquals(5, response.response1.let(in -> in.varLong).get(), 0);
        assertEquals(5, response.varResponse1.let(in -> in.varLong).get(), 0);
        assertEquals(5, varResponse.let(in -> in.response1.get().varLong).get(), 0);
        assertEquals(5, varResponse.let(in -> in.response1.get().varLong).get(), 0);

        assertEquals(6, response.response1.let(in -> in.varShort).get(), 0);
        assertEquals(6, response.varResponse1.let(in -> in.varShort).get(), 0);
        assertEquals(6, varResponse.let(in -> in.response1.get().varShort).get(), 0);
        assertEquals(6, varResponse.let(in -> in.response1.get().varShort).get(), 0);

        assertEquals("Text", varResponse.let(in -> in.response1.get().varString).get());
        assertEquals("T", varResponse.let(in -> in.response1.get().varString.subSequence(0, 1)).get());
        assertEquals(4, varResponse.let(in -> in.response1.get().varObjectList).size().get(), 0);
        assertEquals("Text1", varResponse.let(in -> in.response1.get().varObjectList.get(0)).get());
        assertEquals(1, ((Number) varResponse.let(in -> in.response1.get().varObjectList.get(1)).get()).intValue(), 0);

        assertEquals(jsonObject.toString(), gson.toJson(response));
    }
}
