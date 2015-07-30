package com.exadel.jstrong.web.fortrainings.model;

import java.util.List;

/**
 * Created by Администратор on 30.07.2015.
 */
public class TrainingReportUI {
    private String trainingName;
    private EmployeeNamedFeedbackUI employeeNamedFeedbackUI;
    private List<MeetReportUI> meetReportUIs;

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public EmployeeNamedFeedbackUI getEmployeeNamedFeedbackUI() {
        return employeeNamedFeedbackUI;
    }

    public void setEmployeeNamedFeedbackUI(EmployeeNamedFeedbackUI employeeNamedFeedbackUI) {
        this.employeeNamedFeedbackUI = employeeNamedFeedbackUI;
    }

    public List<MeetReportUI> getMeetReportUIs() {
        return meetReportUIs;
    }

    public void setMeetReportUIs(List<MeetReportUI> meetReportUIs) {
        this.meetReportUIs = meetReportUIs;
    }
}
