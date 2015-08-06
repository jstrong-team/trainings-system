package com.exadel.jstrong.web.fortrainings.model;

import java.util.List;

/**
 * Created by Anton on 05.08.2015.
 */
public class ReportList {

    private List<EmployeeInfo> users;
    private List<TrainingInfo> trainings;

    public List<EmployeeInfo> getUsers() {
        return users;
    }

    public void setUsers(List<EmployeeInfo> users) {
        this.users = users;
    }

    public List<TrainingInfo> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<TrainingInfo> trainings) {
        this.trainings = trainings;
    }
}
