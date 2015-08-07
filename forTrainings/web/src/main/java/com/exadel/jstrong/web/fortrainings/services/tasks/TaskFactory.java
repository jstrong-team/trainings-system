package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;

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
    ApproveEditTask createApproveEditTask(Training data, Integer systemId, Integer transactionId);
}
