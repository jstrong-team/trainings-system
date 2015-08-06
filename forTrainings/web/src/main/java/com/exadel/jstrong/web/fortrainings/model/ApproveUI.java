package com.exadel.jstrong.web.fortrainings.model;

/**
 * Created by ������������� on 29.07.2015.
 */
public class ApproveUI {
    private Integer transactionId;
    private Integer trainingId;
    private String adminAnswer;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public String getAdminAnswer() {
        return adminAnswer;
    }

    public void setAdminAnswer(String adminAnswer) {
        this.adminAnswer = adminAnswer;
    }
}
