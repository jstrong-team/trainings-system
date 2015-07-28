package com.exadel.jstrong.fortrainings.core.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateListSerializer extends JsonSerializer<List<Date>> {

    @Override
    public void serialize(List<Date> value, JsonGenerator gen, SerializerProvider arg) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> dates = new ArrayList<>();
        for (Date d: value){
            dates.add(formatter.format(d));
        }

        gen.writeObject(dates);

    }
}
