package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.web.fortrainings.services.NoticeService;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;

import java.util.List;

/**
 * Created by Администратор on 07.08.2015.
 */
public class DeleteSubscriberTask implements Runnable {
    private EmployeeDAO eDAO;
    private TrainingDAO tDAO;
    private NoticeService noticeService;

    private int userId;
    private int trainingId;

    public DeleteSubscriberTask() {

    }

    public DeleteSubscriberTask(int userId, int trainingId) {
        this.userId = userId;
        this.trainingId = trainingId;
    }


    @Override
    public void run() {
        Employee system = eDAO.getById(NoticeFactory.systemId);
        Notice employeeNotice = NoticeFactory.getDeletedParticipantNotice(system.getId(), tDAO.getTrainingById(trainingId));
        Employee employee = eDAO.getById(userId);
        Notice adminNotice = NoticeFactory.getDeletedParticipantNotice(system.getId(), tDAO.getTrainingById(trainingId), employee);
        noticeService.addNotices(employeeNotice, employee);
        List<Employee> admins = eDAO.getAdmins();
        noticeService.addNotices(adminNotice, admins);
    }

    public void seteDAO(EmployeeDAO eDAO) {
        this.eDAO = eDAO;
    }

    public void settDAO(TrainingDAO tDAO) {
        this.tDAO = tDAO;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
}
