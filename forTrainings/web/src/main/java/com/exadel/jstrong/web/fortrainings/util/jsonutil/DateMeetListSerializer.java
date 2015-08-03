package com.exadel.jstrong.web.fortrainings.util.jsonutil;

import com.exadel.jstrong.web.fortrainings.model.MeetUI;
import com.exadel.jstrong.web.fortrainings.model.SerializeMeetUI;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DateMeetListSerializer extends JsonSerializer<List<MeetUI>> {

    @Override
    public void serialize(List<MeetUI> meets, JsonGenerator gen, SerializerProvider arg) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<SerializeMeetUI> serializeMeets = new ArrayList<>();
        SerializeMeetUI meet = null;
        for (MeetUI m: meets){
            meet = new SerializeMeetUI();
            meet.setId(m.getId());
            meet.setDate(formatter.format(m.getDate()));
            serializeMeets.add(meet);
        }

        gen.writeObject(serializeMeets);

    }

}
