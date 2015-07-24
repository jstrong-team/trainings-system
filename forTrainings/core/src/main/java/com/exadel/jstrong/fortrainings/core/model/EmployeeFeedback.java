package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;

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
    private String addDate;

    private boolean understand;

    private boolean interested;

    private boolean continueWithThisTrainer;

    private boolean smthNew;

    private boolean recommend;

    private int rate;

    private String other;

    @Transient
    private String employeeName;

    public EmployeeFeedback() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public boolean isUnderstand() {
        return understand;
    }

    public void setUnderstand(boolean understand) {
        this.understand = understand;
    }

    public boolean isInterested() {
        return interested;
    }

    public void setInterested(boolean interested) {
        this.interested = interested;
    }

    public boolean isContinueWithThisTrainer() {
        return continueWithThisTrainer;
    }

    public void setContinueWithThisTrainer(boolean continueWithThisTrainer) {
        this.continueWithThisTrainer = continueWithThisTrainer;
    }

    public boolean isSmthNew() {
        return smthNew;
    }

    public void setSmthNew(boolean smthNew) {
        this.smthNew = smthNew;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
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
}
