package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.web.fortrainings.services.NoticeService;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Администратор on 07.08.2015.
 */
public class AddSubscriberTask implements Runnable {
    private NoticeService noticeService;
    private TrainingDAO tDAO;
    private EmployeeDAO eDAO;

    private String status;
    private int tId;
    private int systemId;
    private Employee employee;

    public AddSubscriberTask(String status, int tId, int systemId, Employee employee) {
        this.status = status;
        this.tId = tId;
        this.employee = employee;
        this.systemId = systemId;
    }

    @Override
    public void run() {
        Notice userNotice = NoticeFactory.getNewParticipantNotice(systemId, tDAO.getTrainingById(tId), status);
        Notice adminNotice = NoticeFactory.getNewParticipantNotice(systemId, tDAO.getTrainingById(tId), status, employee);
        noticeService.addNotices(userNotice, employee);
        List<Employee> admins = eDAO.getAdmins();
        noticeService.addNotices(adminNotice, admins);
    }

    public void settDAO(TrainingDAO tDAO) {
        this.tDAO = tDAO;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public void seteDAO(EmployeeDAO eDAO) {
        this.eDAO = eDAO;
    }
}
