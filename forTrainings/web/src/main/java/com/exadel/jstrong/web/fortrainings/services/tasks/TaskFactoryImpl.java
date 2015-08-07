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
public class TaskFactoryImpl implements TaskFactory {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private TrainingDAO trainingDAO;

    @Override
    public DeleteSubscriberTask createDeleteSubscriberTask(Integer userId, Integer trainigId) {
        DeleteSubscriberTask task = new DeleteSubscriberTask(userId, trainigId);
        task.seteDAO(employeeDAO);
        task.setNoticeService(noticeService);
        task.settDAO(trainingDAO);
        return task;
    }

    @Override
    public AddSubscriberTask createAddSubscriberTask(String status, Integer tId, Integer systemId, Employee employee) {
        AddSubscriberTask task = new AddSubscriberTask(status, tId, systemId, employee);
        task.settDAO(trainingDAO);
        task.setNoticeService(noticeService);
        task.seteDAO(employeeDAO);
        return task;
    }

    @Override
    public EditTrainingTask createEditTrainingTask(Training training, Integer senderId, Integer transactionId) {
        EditTrainingTask task = new EditTrainingTask(training, senderId, transactionId);
        task.seteDAO(employeeDAO);
        task.setNoticeService(noticeService);
        return task;
    }

    @Override
    public ApproveEditTask createApproveEditTask(Training data, Integer systemId, Integer transactionId) {
        ApproveEditTask task = new ApproveEditTask(data, systemId, transactionId);
        task.seteDAO(employeeDAO);
        task.setNoticeService(noticeService);
        return task;
    }

    @Override
    public AddTrainerFeedbackTask createAddTrainerFeedbackTask(Training training, Employee sender, Employee employee) {
        AddTrainerFeedbackTask task = new AddTrainerFeedbackTask(training, sender, employee);
        task.setNoticeService(noticeService);
        task.seteDAO(employeeDAO);
        return task;
    }

    @Override
    public AddTrainingTask createAddTrainingTask(Training training) {
        AddTrainingTask task = new AddTrainingTask(training);
        task.setNoticeService(noticeService);
        task.seteDAO(employeeDAO);
        return task;
    }

    @Override
    public AddEmpoyeeFeedbackTask createAddEmpoyeeFeedbackTask(Training training, Employee sender) {
        AddEmpoyeeFeedbackTask task = new AddEmpoyeeFeedbackTask(training, sender);
        task.setNoticeService(noticeService);
        task.seteDAO(employeeDAO);
        return task;
    }

    @Override
    public CreateTrainingTask createCreateTrainingTask(Integer trainingId, Integer systemId) {
        CreateTrainingTask task = new CreateTrainingTask(trainingId, systemId);
        task.seteDAO(employeeDAO);
        task.setNoticeService(noticeService);
        task.settDAO(trainingDAO);
        return task;
    }

    @Override
    public DeleteTrainingTask createDeleteTrainingTask(Integer trainingId, Employee system) {
        DeleteTrainingTask task = new DeleteTrainingTask(trainingId, system);
        task.seteDAO(employeeDAO);
        task.setNoticeService(noticeService);
        task.settDAO(trainingDAO);
        return task;
    }

    @Override
    public AddExternalTask createAddExternalTask(Employee employee) {
        AddExternalTask task = new AddExternalTask(employee);
        return task;
    }
}
