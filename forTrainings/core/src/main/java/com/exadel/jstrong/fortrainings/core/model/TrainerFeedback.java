package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Maria on 24.07.2015.
 */
@Entity
@Table(name = "trainer_feedback")
public class TrainerFeedback {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "feedbacker_id")
    private Integer feedbackerId;

    @Column(name = "training_id")
    private Integer trainingId;

    @Column(name = "add_date")
    private Date addDate;

    @Column
    private String presence;

    @Column
    private String attitude;

    @Column
    private String communication;

    @Column
    private String question;

    @Column
    private String interest;

    @Column
    private String result;

    @Column
    private String level;

    @Column
    private Integer rating;

    @Column
    private String other;

    @Transient
    private final String PRESENCE = "Presence: ";
    @Transient
    private final String ATTITUDE = "Attitude: ";
    @Transient
    private final String COMMUNICATION = "Communication: ";
    @Transient
    private final String QUESTION = "Question: ";
    @Transient
    private final String INTEREST = "Interest: ";
    @Transient
    private final String RESULT = "Result: ";
    @Transient
    private final String LEVEL = "Level: ";
    @Transient
    private final String RATING = "Rating: ";
    @Transient
    private final String OTHER = "Other: ";
    @Transient
    private final String SEPARATOR = "\n";

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    public TrainerFeedback() {
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

    public Integer getFeedbackerId() {
        return feedbackerId;
    }

    public void setFeedbackerId(Integer feedbackerId) {
        this.feedbackerId = feedbackerId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    @JsonDeserialize(using= DateDeserializer.class)
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getAddDate() {
        return addDate;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTextBody(){
        StringBuilder str = new StringBuilder();
        str.append(PRESENCE);
        str.append(presence).append(SEPARATOR);
        str.append(ATTITUDE);
        str.append(attitude).append(SEPARATOR);
        str.append(COMMUNICATION);
        str.append(communication).append(SEPARATOR);
        str.append(QUESTION);
        str.append(question).append(SEPARATOR);
        str.append(INTEREST);
        str.append(interest).append(SEPARATOR);
        str.append(RESULT);
        str.append(result).append(SEPARATOR);
        str.append(LEVEL);
        str.append(level).append(SEPARATOR);
        str.append(RATING);
        str.append(rating.toString()).append(SEPARATOR);
        str.append(OTHER);
        str.append(other).append(SEPARATOR);
        return str.toString();
    }
}
