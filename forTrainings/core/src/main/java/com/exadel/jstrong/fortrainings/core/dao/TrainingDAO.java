package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Training;

import java.util.List;

public interface TrainingDAO extends GenericDAO<Training> {

    List<Training> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo, boolean isUser);
    // List<Training> getNotUserTrainingsLast3Month (int userId);
    /*List<Training> getTrainingsByTrainer(Employee trainer);
    List<Training> getTrainingsByField(String columnName, String columnValue);  // columnName = "name", "annotation"...
    List<Training> getPaidTrainings();*/
}
