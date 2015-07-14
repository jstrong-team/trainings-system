package com.exadel.jstrong.fortrainings.core.model;

public class Training {

    private int id;
    private String name;
    private String annotation;
    private String date;
    private boolean isSubscribe;

    public Training(int id, String name, String annotation, String date, boolean isSubscribe) {
        this.id = id;
        this.name = name;
        this.annotation = annotation;
        this.date = date;
        this.isSubscribe = isSubscribe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAnnotation() {return annotation;}

    public void setDate(String date) {this.date = date;}

    public String getDate() {return date;}

    public void setIsUser(boolean isUser) {this.isSubscribe = isUser;}

    public boolean getIsUser() {return isSubscribe;}

}
