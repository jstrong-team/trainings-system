package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Maria on 23.07.2015.
 */
@Entity
@Table(name = "employee_feedback")
public class EmployeeFeedback {

    @Id
    @Column
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "training_id")
    private int trainingId;

    @Column(name = "add_date")
    private Date addDate;

    @Column
    private Boolean understand;

    @Column
    private Boolean interested;

    @Column
    private Boolean continueWithThisTrainer;

    @Column
    private Boolean smthNew;

    @Column
    private Boolean recommend;

    @Column
    private int rate;

    @Column
    private String other;

    @Column
    private Boolean isDelete;

    public Boolean isDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", insertable = false, updatable = false)
    private Training training;

    public EmployeeFeedback() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public Date getAddDate() {
        return addDate;
    }

    @JsonDeserialize(using= DateDeserializer.class)
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Boolean isUnderstand() {
        return understand;
    }

    public void setUnderstand(Boolean understand) {
        this.understand = understand;
    }

    public Boolean isInterested() {
        return interested;
    }

    public void setInterested(Boolean interested) {
        this.interested = interested;
    }

    public Boolean isContinueWithThisTrainer() {
        return continueWithThisTrainer;
    }

    public void setContinueWithThisTrainer(Boolean continueWithThisTrainer) {
        this.continueWithThisTrainer = continueWithThisTrainer;
    }

    public Boolean isSmthNew() {
        return smthNew;
    }

    public void setSmthNew(Boolean smthNew) {
        this.smthNew = smthNew;
    }

    public Boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
