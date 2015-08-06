package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.*;
import com.exadel.jstrong.web.fortrainings.model.*;

import java.util.List;

public interface TrainingStorageController {
    TrainingUI getTraining(int tId, int uId);
    int addTraining(Training training);
    Subscribe buildSubscriber(int uId, int tId);
    boolean isTrainer(int uId, int tId);
    int addSubscriber(Subscribe s);
    boolean check(int uId, int tId);
    void addEmployeeFeedback(EmployeeFeedback ef);
    List<SubscriberUI> getSubscribers(int uId, int tId);
    int getEmployeeIdBySubscribe(int subscribeId);
    List<EmployeeNamedFeedbackUI> getEmployeeNamedFeedback(int id, boolean isAdmin);
    boolean deleteFeedback(int id);
    boolean deleteSubscriber(int userId, int trainingId);
    void editTraining(int oldTrainingId, Training training, int senderId);
    void changeTrainingStatus(int trainingId);
    int approveTraining(int transactionId);
    List<MeetReportUI> getMeetReportUIs(int subscribeId);
    List<TrainingReportUI> getReportUI(int employeeId);
    void updateParticipants(List<Participant> participants);
    void killTransaction(int transactionId);
    MergedTrainingUI mergeTraining(int transactionId);
    void addTrainerFeedback(TrainerFeedback trainerFeedback);
    List<TrainerFeedbackUI> getTrainerFeedbacks(int employeeID);
    void addExternalUser(ExternalUserUI newEmployeeUI, int trainingId);
}

