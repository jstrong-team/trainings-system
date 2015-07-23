package com.exadel.jstrong.fortrainings.core.model;

/**
 * Created by Администратор on 21.07.2015.
 */
import javax.persistence.*;

@Entity
public class SearchEvent {
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
    private String description;
    @Column
    private String date;

    public SearchEvent() {}

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
