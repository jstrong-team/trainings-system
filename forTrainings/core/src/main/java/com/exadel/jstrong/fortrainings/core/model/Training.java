package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;
import java.util.ArrayList;
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
    private int id;

    @Column
    private String name;

    @Column
    private String annotation;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String target;

    @Column(columnDefinition = "TINYINT(4)")
    private boolean paid;

    @Column
    private int max_participants;

    @Column
    private String place;

    @Column(columnDefinition = "TINYINT(4)")
    private boolean internal;

    @Column(columnDefinition = "TINYINT(4)")
    private boolean approve;

    @Column
    private int trainer_id;

    @Transient
    private List<String> date;

    @Transient
    private boolean isSubscribe;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subscribeTrainings")
    private List<Employee> subscribers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "training")
    private List<EmployeeFeedback> feedbacks;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "training")
//    private List<Subscribe> subscribes;

    public Training() {
        date = new ArrayList<>();
    }

    public void setDate(List<String> date){
        this.date = new ArrayList<String>(date);
    }

    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public boolean isApprove() {
        return approve;
    }

    public List<String> getDate() {
        return date;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
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

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public List<Employee> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Employee> subscribers) {
        this.subscribers = subscribers;
    }

    public List<EmployeeFeedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<EmployeeFeedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
