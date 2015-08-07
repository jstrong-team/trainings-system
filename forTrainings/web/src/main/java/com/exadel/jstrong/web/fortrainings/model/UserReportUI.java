package com.exadel.jstrong.web.fortrainings.model;

import java.util.List;

/**
 * Created by Anton on 05.08.2015.
 */
public class UserReportUI {

    private String name;
    private Integer absentCount;
    private List<MeetReportUI> meets;
    private List<FeedbackReportUI> positiveFeedbacks;
    private List<FeedbackReportUI> negativeFeedbacks;

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

    public Integer getAbsentCount() {
        return absentCount;
    }

    public void setAbsentCount(Integer absentCount) {
        this.absentCount = absentCount;
    }

    public String meetsToString(){
        StringBuilder str = new StringBuilder();
        for (MeetReportUI m : meets){
            str.append(m.toString() + "\r\n");
        }
        return str.toString();
    }

    public String positiveFeedbacksToString(){
        StringBuilder str = new StringBuilder();
        for (FeedbackReportUI f : positiveFeedbacks){
            str.append(f.toString() + "\r\n");
        }
        return str.toString();
    }

    public String negativeFeedbacksToString(){
        StringBuilder str = new StringBuilder();
        for (FeedbackReportUI f : negativeFeedbacks){
            str.append(f.toString() + "\r\n");
        }
        return str.toString();
    }

}
