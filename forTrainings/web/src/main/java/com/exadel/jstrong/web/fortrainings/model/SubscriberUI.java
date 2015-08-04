package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateSerializer;
import com.exadel.jstrong.fortrainings.core.model.Participant;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Maria on 24.07.2015.
 */
public class SubscriberUI {

    private Integer id;
    private String name;
    private String status;
    private Date date;
    private List<Participant> participants;

    public SubscriberUI() {
    }

    public SubscriberUI(Integer id, String name, String status, Date date, List<Participant> participants) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.date = date;
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonSerialize(using= DateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
