package com.adefruandta.serializer;

import com.adefruandta.jkotlin.JKObject;

public class JKResponse extends JKObject<Response> {

    public Class<Response> getTypeOfT() {
        return Response.class;
    }
}
