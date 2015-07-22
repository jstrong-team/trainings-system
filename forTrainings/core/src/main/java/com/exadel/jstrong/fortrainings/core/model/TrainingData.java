package com.exadel.jstrong.fortrainings.core.model;

/**
 * Created by Администратор on 21.07.2015.
 */
public class TrainingData {
    private int id;
    private String name;
    private String annotation;
    private String description;
    private String target;
    private boolean paid;
    private int max_participants;
    private String place;
    private boolean internal;

    public TrainingData(int id, String name, String annotation, String description, String target, boolean paid, int max_participants, String place, boolean internal) {
        this.id = id;
        this.name = name;
        this.annotation = annotation;
        this.description = description;
        this.target = target;
        this.paid = paid;
        this.max_participants = max_participants;
        this.place = place;
        this.internal = internal;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
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

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(int max_participants) {
        this.max_participants = max_participants;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
