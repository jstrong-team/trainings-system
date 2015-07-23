package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.SearchEvent;
import com.exadel.jstrong.fortrainings.core.model.Training;

import java.util.List;

public interface TrainingDAO extends GenericDAO<Training>{

    List<Event> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo);
    List<SearchEvent> getSearchResponse(String st);
    int add (Training training);
    boolean isSubscribeById(int employeeId, int trainingId);
    Training getTrainingById(int id);
    boolean isTrainer(int userId, int trainingId);
    boolean isApprove(int trainingId);
    boolean isSubscriber(int userId, int trainingId);

}