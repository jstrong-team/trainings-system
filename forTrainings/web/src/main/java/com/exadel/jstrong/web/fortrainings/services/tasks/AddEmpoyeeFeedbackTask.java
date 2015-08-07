package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.services.NoticeService;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;

import java.util.List;

/**
 * Created by Администратор on 07.08.2015.
 */
public class AddEmpoyeeFeedbackTask implements  Runnable {
    private EmployeeDAO eDAO;
    private NoticeService noticeService;

    private Training training;
    private Employee sender;

    public AddEmpoyeeFeedbackTask(Training training, Employee sender) {
        this.sender = sender;
        this.training = training;
    }

    @Override
    public void run() {
        Notice notice = NoticeFactory.getEmployeeFeedbackNotice(training, sender);
        List<Employee> admins = eDAO.getAdmins();
        noticeService.addNotices(notice, admins);
    }

    public void seteDAO(EmployeeDAO eDAO) {
        this.eDAO = eDAO;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
}
