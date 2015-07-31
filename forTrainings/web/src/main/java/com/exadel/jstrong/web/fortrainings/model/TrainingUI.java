package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateDeserializer;
import com.exadel.jstrong.fortrainings.core.jsonutil.DateListSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Maria on 24.07.2015.
 */
public class TrainingUI {

    private Integer id;
    private String name;
    private String trainerName;
    private String annotation;
    private String description;
    private String target;
    private Boolean paid;
    private Integer max_participants;
    private String place;
    private Boolean interested;
    private Boolean approve;
    private Integer trainer_id;
    private List<Date> dates;
    private Boolean isSubscribe;
    private Integer rate;

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public TrainingUI(Integer id, String name, String trainerName, String annotation, String description, String target, Boolean paid, Integer max_participants, String place, Boolean interested, Boolean approve, Integer trainer_id, List<Date> dates, Boolean isSubscribe) {
        this.id = id;
        this.name = name;
        this.trainerName = trainerName;
        this.annotation = annotation;
        this.description = description;
        this.target = target;
        this.paid = paid;
        this.max_participants = max_participants;
        this.place = place;
        this.interested = interested;
        this.approve = approve;
        this.trainer_id = trainer_id;
        this.dates = dates;
        this.isSubscribe = isSubscribe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean isPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Integer getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(Integer max_participants) {
        this.max_participants = max_participants;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Boolean isInternal() {
        return interested;
    }

    public void setInternal(Boolean interested) {
        this.interested = interested;
    }

    public Boolean isApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public Integer getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }

    @JsonSerialize(using= DateListSerializer.class)
    public List<Date> getdates() {
        return dates;
    }

    @JsonDeserialize(using= DateDeserializer.class)
    public void setdates(List<Date> dates) {
        this.dates = dates;
    }

    @JsonGetter("isSubscribe")
    public Boolean isSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(Boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
