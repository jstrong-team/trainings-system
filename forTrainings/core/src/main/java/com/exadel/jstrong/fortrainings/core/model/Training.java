package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateListDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by Maria on 21.07.2015.
 */
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String annotation;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String target;

    @Column(columnDefinition = "TINYINT(4)")
    private Boolean paid;

    @Column
    private Integer max_participants;

    @Column
    private String place;

    @Column(columnDefinition = "TINYINT(4)")
    private Boolean internal;

    @Column(columnDefinition = "TINYINT(4)")
    private Boolean approve;

    @Column
    private Integer trainer_id;

    @Transient
    private List<Date> date;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "training")
    private List<Meet> meets;

    @Transient
    private Boolean isSubscribe;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subscribeTrainings")
//    private List<Employee> subscribers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "training")
    private List<EmployeeFeedback> feedbacks;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "training")
    private List<Subscribe> subscribes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "training")
    private List<Notice> notices;

    public List<Subscribe> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<Subscribe> subscribes) {
        this.subscribes = subscribes;
    }

    public Training() {
    }

    public Training(Training training) {
        this.name = training.name;
        this.annotation = training.annotation;
        this.description = training.description;
        this.target = training.target;
        this.paid = training.paid;
        this.max_participants = training.max_participants;
        this.place = training.place;
        this.internal = training.internal;
        this.approve = training.approve;
        this.trainer_id = training.trainer_id;
        this.date = training.date;
        this.meets = training.meets;
        this.isSubscribe = training.isSubscribe;
        this.feedbacks = training.feedbacks;
        this.subscribes = training.subscribes;
    }

    public List<Meet> getMeets() {
        return meets;
    }

    public void setMeets(List<Meet> meets) {
        this.meets = meets;
    }

    @JsonDeserialize(using= DateListDeserializer.class)
    public void setDate(List<Date> date){
        this.date = new ArrayList<>(date);
    }

    public Boolean isSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(Boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public Boolean isApprove() {
        return approve;
    }

    public List<Date> getDate() {
        return date;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public Boolean isInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
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

    public Integer getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }

//    public List<Employee> getSubscribers() {
//        return subscribers;
//    }
//
//    public void setSubscribers(List<Employee> subscribers) {
//        this.subscribers = subscribers;
//    }

    public List<EmployeeFeedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<EmployeeFeedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }
}
