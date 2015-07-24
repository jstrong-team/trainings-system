package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.model.enums.SubscribeStatus;

/**
 * Created by Maria on 24.07.2015.
 */
public class SubscriberUI {

    private int id;
    private String name;
    private SubscribeStatus status;

    public SubscriberUI() {
    }

    public SubscriberUI(int id, String name, SubscribeStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    public SubscribeStatus getStatus() {
        return status;
    }

    public void setStatus(SubscribeStatus status) {
        this.status = status;
    }
}
