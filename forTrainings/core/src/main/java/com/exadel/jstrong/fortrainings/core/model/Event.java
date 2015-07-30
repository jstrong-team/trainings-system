package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "new_view")
public class Event {

    @Id
    @Column
    @Cascade({})
    private int id;

    @Column(name="training_id")
    private int trainingId;

    @Column
    private String name;

    @Column
    private String annotation;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Transient
    private boolean isSubscribe;

    @Transient
    private boolean isTrainer;

    public Event() {
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    @JsonGetter("isTrainer")
    public boolean isTrainer() {
        return isTrainer;
    }

    public void setIsTrainer(boolean isTrainer) {
        this.isTrainer = isTrainer;
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

    @JsonSerialize(using=DateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonGetter("isSubscribe")
    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }
}
