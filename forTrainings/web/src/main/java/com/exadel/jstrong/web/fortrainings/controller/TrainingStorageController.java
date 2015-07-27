package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.model.EmployeeFeedbackUI;
import com.exadel.jstrong.web.fortrainings.model.SubscriberUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingUI;

import java.util.List;

public interface TrainingStorageController {
    TrainingUI getTraining(int tId, int uId);
    void addTraining(Training training);
    Subscribe buildSubscriber(int uId, int tId);
    boolean isTrainer(int uId, int tId);
    int addSubscriber(Subscribe s);
    boolean check(int uId, int tId);
    void addEmployeeFeedback(EmployeeFeedback ef);
    List<SubscriberUI> getSubscribers(int id);
    List<EmployeeFeedbackUI> getEmployeeFeedback(int id);
}

