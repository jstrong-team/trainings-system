package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Training;

/**
 * Created by Администратор on 07.08.2015.
 */
public interface TaskFactory {

    /**
     * Creates {@link DeleteSubscriberTask} instance
     * @param userId the id of user
     * @param trainigId the id of training
     * @return created instance
     */
    DeleteSubscriberTask createDeleteSubscriberTask(Integer userId, Integer trainigId);
    AddSubscriberTask createAddSubscriberTask(String status, Integer tId, Integer systemId, Employee employee);
    EditTrainingTask createEditTrainingTask(Training training, Integer senderId, Integer transactionId);
    ApproveEditTask createApproveEditTask(Training data, Integer systemId);
    AddTrainerFeedbackTask createAddTrainerFeedbackTask(Training training, Employee sender, Employee empoyee);
    AddTrainingTask createAddTrainingTask(Training training);
    AddEmpoyeeFeedbackTask createAddEmpoyeeFeedbackTask(Training training, Employee sender);
    CreateTrainingTask createCreateTrainingTask(Integer trainingId, Integer systemId);
    DeleteTrainingTask createDeleteTrainingTask(Integer trainingId, Employee system);
    AddExternalTask createAddExternalTask(Employee employee);
}
