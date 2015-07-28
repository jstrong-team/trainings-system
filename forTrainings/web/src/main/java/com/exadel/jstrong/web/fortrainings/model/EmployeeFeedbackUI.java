package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.service.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by Администратор on 27.07.2015.
 */
public class EmployeeFeedbackUI {
    private int id;

    private int employeeId;

    private int trainingId;

    private Date addDate;

    private boolean understand;

    private boolean interested;

    private boolean continueWithThisTrainer;

    private boolean smthNew;

    private boolean recommend;

    private int rate;

    private String other;

    public EmployeeFeedbackUI(int id, int employeeId, int trainingId, Date addDate, boolean understand, boolean interested, boolean continueWithThisTrainer, boolean smthNew, boolean recommend, int rate, String other) {
        this.id = id;
        this.employeeId = employeeId;
        this.trainingId = trainingId;
        this.addDate = addDate;
        this.understand = understand;
        this.interested = interested;
        this.continueWithThisTrainer = continueWithThisTrainer;
        this.smthNew = smthNew;
        this.recommend = recommend;
        this.rate = rate;
        this.other = other;
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

    @JsonSerialize(using= DateSerializer.class)
    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
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
