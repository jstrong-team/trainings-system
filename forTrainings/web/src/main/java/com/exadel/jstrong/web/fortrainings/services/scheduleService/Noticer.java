package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

/**
 * Created by Anton on 29.07.2015.
 */
public class Noticer implements Runnable{

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run(){

    }

}
