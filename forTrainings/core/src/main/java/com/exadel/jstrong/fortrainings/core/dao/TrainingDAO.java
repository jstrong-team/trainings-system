package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import com.exadel.jstrong.fortrainings.core.model.Training;

import java.util.Date;
import java.util.List;

public interface TrainingDAO extends GenericDAO<Training>{

    List<Event> getTrainingsInDateScope(int userId, Date dateFrom, Date dateTo);
    List<Training> getSearchResponse(String st);
    int add (Training training);
    boolean isSubscribeById(int employeeId, int trainingId);
    Training getTrainingById(int id);
    boolean isTrainer(int userId, int trainingId);
    boolean isApprove(int trainingId);
    int getRate(Training training);
    List<Subscribe> getSubscribers(int trainingId);
    void editTraining(Training training);
   // boolean isSubscriber(int userId, int trainingId);

}