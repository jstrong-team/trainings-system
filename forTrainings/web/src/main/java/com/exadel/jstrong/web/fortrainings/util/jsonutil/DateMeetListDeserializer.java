package com.exadel.jstrong.web.fortrainings.util.jsonutil;

import com.exadel.jstrong.web.fortrainings.model.MeetUI;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 03.08.2015.
 */
public class DateMeetListDeserializer extends JsonDeserializer<List<MeetUI>> {

    @Override
    public List<MeetUI> deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<MeetUI> meets = new ArrayList<>();
        MeetUI meet = null;
        try {
            while(!jsonparser.isClosed()){
                meet = new MeetUI();
                String str = jsonparser.nextTextValue();
            }
        } catch (Exception e) {

        }
        return meets;
    }

}
