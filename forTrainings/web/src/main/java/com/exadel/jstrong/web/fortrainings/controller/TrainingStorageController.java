package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.model.*;

import java.util.List;

public interface TrainingStorageController {
    TrainingUI getTraining(int tId, int uId);
    void addTraining(Training training);
    Subscribe buildSubscriber(int uId, int tId);
    boolean isTrainer(int uId, int tId);
    int addSubscriber(Subscribe s);
    boolean check(int uId, int tId);
    void addEmployeeFeedback(EmployeeFeedback ef);
    List<SubscriberUI> getSubscribers(int uId, int tId);
//    List<EmployeeFeedbackUI> getEmployeeFeedback(int id);
    List<EmployeeNamedFeedbackUI> getEmployeeNamedFeedback(int id, boolean isAdmin);
    boolean deleteFeedback(int id);
    boolean deleteSuscriber(int userId, int trainingId);
    void editTraining(TrainingUI training);
    MergedTrainingUI mergeTraining(int transactionID);
}

