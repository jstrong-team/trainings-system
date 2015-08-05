package com.exadel.jstrong.web.fortrainings.model;

import java.util.Date;

/**
 * Created by Maria on 04.08.2015.
 */
public class TrainerFeedbackUI {

    private String feedbackerName;
    private String trainingName;
    private Date addDate;
    private String presence;
    private String attitude;
    private String communication;
    private String question;
    private String interest;
    private String result;
    private String level;
    private Integer rating;
    private String other;

    public TrainerFeedbackUI(Date addDate, String presence, String attitude, String communication, String question, String interest, String result, String level, Integer rating, String other) {
        this.addDate = addDate;
        this.presence = presence;
        this.attitude = attitude;
        this.communication = communication;
        this.question = question;
        this.interest = interest;
        this.result = result;
        this.level = level;
        this.rating = rating;
        this.other = other;
    }

    public String getFeedbackerName() {
        return feedbackerName;
    }

    public void setFeedbackerName(String feedbackerName) {
        this.feedbackerName = feedbackerName;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
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
}
