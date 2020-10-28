package com.adefruandta.serializer;

import com.adefruandta.jkotlin.Val;
import com.adefruandta.jkotlin.ValList;
import com.adefruandta.jkotlin.Var;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class JKSerializer implements JsonDeserializer<Var<?>>, JsonSerializer<Var<?>> {

    @Override
    public Var<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            Class<Var<?>> classOfVar = getClassOfVar(typeOfT);

            if (classOfVar == null) {
                return null;
            }

            Var var = classOfVar.newInstance();
            Class<?> classOfT = getClassOfType(typeOfT);

            if (json instanceof JsonArray) {
                JsonArray jsonArray = (JsonArray) json;
                var.set(getTypeOfList(classOfVar).newInstance());
                ValList<?, ?> valList = (ValList<?, ?>) var;
                for (JsonElement jsonElement : jsonArray) {
                    valList.add(context.deserialize(jsonElement, classOfT));
                }
            }
            else if (classOfT == null) {
                if (json.isJsonPrimitive()) {
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) json;
                    if (jsonPrimitive.isNumber()) {
                        var.set(jsonPrimitive.getAsNumber());
                    }
                    else if (jsonPrimitive.isString()) {
                        var.set(jsonPrimitive.getAsString());
                    }
                    else if (jsonPrimitive.isBoolean()) {
                        var.set(jsonPrimitive.getAsBoolean());
                    }
                    else {
                        var.set(context.deserialize(json, Object.class));
                    }
                }
                else {
                    var.set(context.deserialize(json, Object.class));
                }
            }
            else {
                var.set(context.deserialize(json, classOfT));
            }
            return var;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JsonElement serialize(Var<?> src, Type typeOfSrc, JsonSerializationContext context) {
        if (src instanceof ValList) {
            JsonArray jsonArray = new JsonArray();
            ValList<?, ?> valList = (ValList<?, ?>) src;
            valList.forEach(in -> {
                if (in instanceof Val) {
                    Val<?> val = (Val<?>) in;
                    if (val.isNull().get()) {
                        return;
                    }

                    Type typeOfT = getClassOfType(val.getClass());
                    if (typeOfT != null) {
                        jsonArray.add(context.serialize(val.get(), typeOfT));
                    }
                    else if (val.is(Number.class).get()) {
                        jsonArray.add(val.getAs(Number.class));
                    }
                    else if (val.is(Boolean.class).get()) {
                        jsonArray.add(val.getAs(Boolean.class));
                    }
                    else if (val.is(Character.class).get()) {
                        jsonArray.add(val.getAs(Character.class));
                    }
                    else if (val.is(String.class).get()) {
                        jsonArray.add(val.getAs(String.class));
                    }
                    else {
                        jsonArray.add(context.serialize(val.get()));
                    }
                }
                else {
                    jsonArray.add(context.serialize(in));
                }
            });
            return jsonArray;
        }
        return context.serialize(src.get());
    }

    private Class<?> getClassOfType(Type typeOfT) {
        try {
            if (typeOfT instanceof ParameterizedType) {
                return Class.forName(((ParameterizedType) typeOfT).getActualTypeArguments()[0].getTypeName());
            }

            return getClassOfType(((Class<?>) typeOfT).getGenericInterfaces()[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private Class<?> getTypeOfList(Type typeOfT) {
        if (typeOfT instanceof Class) {
            Class<?> clazz = (Class<?>) typeOfT;
            if (List.class.isAssignableFrom(clazz)) {
                return clazz;
            }

            return getTypeOfList(clazz.getGenericInterfaces()[0]);
        }

        ParameterizedType parameterizedType = (ParameterizedType) typeOfT;
        Class<?> clazz = (Class<?>) parameterizedType.getRawType();

        if (List.class.isAssignableFrom(clazz)) {
            return clazz;
        }

        return getTypeOfList(parameterizedType.getActualTypeArguments()[0]);
    }

    private Class<Var<?>> getClassOfVar(Type typeOfT) {
        try {
            if (typeOfT instanceof ParameterizedType) {
                return getClassOfVar(((ParameterizedType) typeOfT).getRawType());
            }

            return (Class<Var<?>>) Class.forName(typeOfT.getTypeName());
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}