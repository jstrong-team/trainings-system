package com.exadel.jstrong.web.fortrainings.responsebuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class ResponseBuilder<TYPE> {

    public String getResponse(TYPE data) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(data);
        return json;
    }
}
