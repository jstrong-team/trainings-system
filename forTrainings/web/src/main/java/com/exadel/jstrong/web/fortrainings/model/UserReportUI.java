package com.exadel.jstrong.web.fortrainings.model;

import java.util.List;

/**
 * Created by Anton on 05.08.2015.
 */
public class UserReportUI {

    private int trainingId;
    private String trainingName;
    private String name;
    private List<MeetReportUI> meets;
    private List<FeedbackReportUI> positiveFeedbacks;
    private List<FeedbackReportUI> negativeFeedbacks;

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public List<MeetReportUI> getMeets() {
        return meets;
    }

    public void setMeets(List<MeetReportUI> meets) {
        this.meets = meets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FeedbackReportUI> getPositiveFeedbacks() {
        return positiveFeedbacks;
    }

    public void setPositiveFeedbacks(List<FeedbackReportUI> positiveFeedbacks) {
        this.positiveFeedbacks = positiveFeedbacks;
    }

    public List<FeedbackReportUI> getNegativeFeedbacks() {
        return negativeFeedbacks;
    }

    public void setNegativeFeedbacks(List<FeedbackReportUI> negativeFeedbacks) {
        this.negativeFeedbacks = negativeFeedbacks;
    }
}
