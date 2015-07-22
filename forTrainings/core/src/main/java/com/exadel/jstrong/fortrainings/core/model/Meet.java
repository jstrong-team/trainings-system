package com.exadel.jstrong.fortrainings.core.model;

/**
 * Created by Администратор on 21.07.2015.
 */
public class Meet {
    private String date;
    private int id;
    private int training_id;

    public int getId() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
