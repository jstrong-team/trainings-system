package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.service.DateListSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Maria on 24.07.2015.
 */
public class TrainingUI {

    private int id;
    private String name;
    private String annotation;
    private String description;
    private String target;
    private boolean paid;
    private int max_participants;
    private String place;
    private boolean internal;
    private boolean approve;
    private int trainer_id;
    private List<Date> dates;
    private boolean isSubscribe;
    private int rate;

    public TrainingUI(int id, String name, String annotation, String description, String target, boolean paid, int max_participants, String place, boolean internal, boolean approve, int trainer_id, List<Date> dates, boolean isSubscribe) {
        this.id = id;
        this.name = name;
        this.annotation = annotation;
        this.description = description;
        this.target = target;
        this.paid = paid;
        this.max_participants = max_participants;
        this.place = place;
        this.internal = internal;
        this.approve = approve;
        this.trainer_id = trainer_id;
        this.dates = dates;
        this.isSubscribe = isSubscribe;
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

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    @JsonSerialize(using= DateListSerializer.class)
    public List<Date> getdates() {
        return dates;
    }

    public void setdates(List<Date> dates) {
        this.dates = dates;
    }

    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
