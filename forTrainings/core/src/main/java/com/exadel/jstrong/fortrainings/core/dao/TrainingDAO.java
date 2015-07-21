package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Event;

import java.util.List;

public interface TrainingDAO extends HibernateDAO{

    List<Event> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo);
    //List<Event> getUserTrainingsLast3MonthIsUser (int userId, String dateFrom, String dateTo);
    List<Event> getSearchResponse(String st);
    // List<Event> getNotUserTrainingsLast3Month (int userId);
    /*List<Event> getTrainingsByTrainer(Employee trainer);
    List<Event> getTrainingsByField(String columnName, String columnValue);  // columnName = "name", "annotation"...
    List<Event> getPaidTrainings();*/
}
