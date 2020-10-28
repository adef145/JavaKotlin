package com.adefruandta.serializer;

import com.adefruandta.jkotlin.VarArrayList;
import com.adefruandta.jkotlin.VarByte;
import com.adefruandta.jkotlin.VarDouble;
import com.adefruandta.jkotlin.VarFloat;
import com.adefruandta.jkotlin.VarInteger;
import com.adefruandta.jkotlin.VarLong;
import com.adefruandta.jkotlin.VarObject;
import com.adefruandta.jkotlin.VarShort;
import com.adefruandta.jkotlin.VarString;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Response1 implements Serializable {

    @SerializedName("byte")
    public VarByte varByte = VarByte.var().build();

    @SerializedName("double")
    public VarDouble varDouble = VarDouble.var().build();

    @SerializedName("float")
    public VarFloat varFloat = VarFloat.var().build();

    @SerializedName("integer")
    public VarInteger varInteger = VarInteger.var().build();

    @SerializedName("long")
    public VarLong varLong = VarLong.var().build();

    @SerializedName("short")
    public VarShort varShort = VarShort.var().build();

    @SerializedName("string")
    public VarString varString = VarString.var().build();

    @SerializedName("list")
    public VarArrayList<VarObject> varObjectList = VarArrayList.var(VarObject.class).build();

    @SerializedName("list_var_string")
    public VarArrayList<VarString> varStringList = VarArrayList.var(VarString.class).build();

    @SerializedName("list_string")
    public VarArrayList<String> varObjectStringList = VarArrayList.var(String.class).build();
}
