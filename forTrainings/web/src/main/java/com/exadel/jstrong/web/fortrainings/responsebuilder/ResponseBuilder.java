package com.exadel.jstrong.web.fortrainings.responsebuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ResponseBuilder<TYPE> {

    public String getResponse(TYPE data) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(data);
        return json;
    }
}
