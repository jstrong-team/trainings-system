package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by ������������� on 27.07.2015.
 */
public class EmployeeFeedbackUI {
    private Integer id;

    private Integer employeeId;

    private Integer trainingId;

    private Date addDate;

    private Boolean understand;

    private Boolean interested;

    private Boolean continueWithThisTrainer;

    private Boolean smthNew;

    private Boolean recommend;

    private Integer rate;

    private String other;

    private Boolean isDelete;

    public EmployeeFeedbackUI(Integer id, Integer employeeId, Integer trainingId, Date addDate, Boolean understand, Boolean interested, Boolean continueWithThisTrainer, Boolean smthNew, Boolean recommend, Integer rate, String other, Boolean isDelete) {
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
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    @JsonSerialize(using= DateSerializer.class)
    public Date getAddDate() {
        return addDate;
    }

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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
