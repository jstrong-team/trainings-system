package com.exadel.jstrong.web.fortrainings.model;

import java.util.List;

/**
 * Created by Администратор on 30.07.2015.
 */
public class TrainingReportUI {
    private String trainingName;
    private List<MeetReportUI> meetReportUIs;

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }


    public List<MeetReportUI> getMeetReportUIs() {
        return meetReportUIs;
    }

    public void setMeetReportUIs(List<MeetReportUI> meetReportUIs) {
        this.meetReportUIs = meetReportUIs;
    }
}
