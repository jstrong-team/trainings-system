package com.exadel.jstrong.fortrainings.core.jsonutil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateListDeserializer extends JsonDeserializer<List<Date>>
{
    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    public List<Date> deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<Date> dates = new ArrayList<>();
        try {
            while(!jsonparser.isClosed()){
                dates.add(format.parse(jsonparser.nextTextValue()));
            }
        } catch (Exception e) {

        }
        return dates;
    }

}
