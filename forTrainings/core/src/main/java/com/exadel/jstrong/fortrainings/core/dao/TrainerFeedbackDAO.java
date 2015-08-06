package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.TrainerFeedback;

import java.util.List;

/**
 * Created by Maria on 04.08.2015.
 */
public interface TrainerFeedbackDAO extends GenericDAO<TrainerFeedback> {

    void addFeedback(TrainerFeedback feedback);
    List<TrainerFeedback> getAllFeedbacks(int employeeId);
    List<TrainerFeedback> getTrainingFeedbacks(int employeeId, int trainingId);

}
