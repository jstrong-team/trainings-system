package com.exadel.jstrong.web.fortrainings.model;

/**
 * Created by Администратор on 29.07.2015.
 */
public class ApproveUI {
    private int newTrainingId;
    private int oldTrainingId;
    private String adminAnswer;

    public int getNewTrainingId() {
        return newTrainingId;
    }

    public void setNewTrainingId(int newTrainingId) {
        this.newTrainingId = newTrainingId;
    }

    public int getOldTrainingId() {
        return oldTrainingId;
    }

    public void setOldTrainingId(int oldTrainingId) {
        this.oldTrainingId = oldTrainingId;
    }

    public String getAdminAnswer() {
        return adminAnswer;
    }

    public void setAdminAnswer(String adminAnswer) {
        this.adminAnswer = adminAnswer;
    }
}
