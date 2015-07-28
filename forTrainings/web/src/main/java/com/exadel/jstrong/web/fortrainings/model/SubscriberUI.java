package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.service.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by Maria on 24.07.2015.
 */
public class SubscriberUI {

    private int id;
    private String name;
    private String status;

    private Date date;

    public SubscriberUI() {
    }

    public SubscriberUI(int id, String name, String status, Date date) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
