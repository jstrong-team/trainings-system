package com.exadel.jstrong.web.fortrainings.model;

/**
 * Created by Maria on 24.07.2015.
 */
public class SubscriberUI {

    private int id;
    private String name;
    private String status;
    private String date;

    public SubscriberUI() {
    }

    public SubscriberUI(int id, String name, String status, String date) {
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
}
