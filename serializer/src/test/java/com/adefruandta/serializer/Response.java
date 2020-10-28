package com.adefruandta.serializer;

import com.adefruandta.jkotlin.VarBuilder;
import com.adefruandta.jkotlin.VarObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Response implements Serializable {

    @SerializedName("response")
    public VarObject<Response1> response1 = VarObject.var(Response1.class).build();

    @SerializedName("var_response")
    public VarResponse1 varResponse1 = VarBuilder.of(VarResponse1.class).build();
}
