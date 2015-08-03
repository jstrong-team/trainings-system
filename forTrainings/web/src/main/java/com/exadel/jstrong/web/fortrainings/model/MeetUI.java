package com.exadel.jstrong.web.fortrainings.model;
import com.exadel.jstrong.fortrainings.core.jsonutil.DateDeserializer;
import com.exadel.jstrong.fortrainings.core.jsonutil.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class MeetUI {
    private Integer id;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonSerialize(using= DateSerializer.class)
    public Date getDate() {
        return date;
    }

    @JsonDeserialize(using= DateDeserializer.class)
    public void setDate(Date date) {
        this.date = date;
    }
}
