package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;

@Entity
@Table(name = "new_view")
public class Event {

    @Id
    @Column
    private int id;

    @Column
    private int training_id;

    @Column
    private String name;

    @Column
    private String annotation;

    @Column
    private String date;

    @Transient
    private boolean isSubscribe;

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraining_id() {
        return training_id;
    }

    public void setTraining_id(int training_id) {
        this.training_id = training_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }
}
