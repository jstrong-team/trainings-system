package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateDeserializer;
import com.exadel.jstrong.fortrainings.core.jsonutil.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Maria on 24.07.2015.
 */
@Entity
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "text")
    private String text;

    @Column(name = "add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "status")
    private String status;

    @Column(name = "training_id")
    private Integer trainingId;

    @Column(name = "approve")
    private Boolean isApproveTraining;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", insertable = false, updatable = false)
    private Training training;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "notice")
    private List<EmployeeNotice> employeeNotices;

    public Notice() {
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Notice(String text) {
        this.text = text;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public List<EmployeeNotice> getEmployeeNotices() {
        return employeeNotices;
    }

    public void setEmployeeNotices(List<EmployeeNotice> employeeNotices) {
        this.employeeNotices = employeeNotices;
    }

    @JsonSerialize(using= DateSerializer.class)
    public Date getAddDate() {
        return addDate;
    }

    @JsonDeserialize(using=DateDeserializer.class)
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Boolean isApproveTraining() {
        return isApproveTraining;
    }

    public void setIsApproveTraining(Boolean isApproveTraining) {
        this.isApproveTraining = isApproveTraining;
    }
}
