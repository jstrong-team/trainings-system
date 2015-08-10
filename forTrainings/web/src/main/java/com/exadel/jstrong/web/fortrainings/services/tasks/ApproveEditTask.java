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
public class ApproveEditTask implements Runnable {
    private EmployeeDAO eDAO;
    private NoticeService noticeService;

    private Training data;
    private Integer systemId;

    public ApproveEditTask(Training data, Integer senderId) {
        this.systemId = senderId;
        this.data = data;
    }

    @Override
    public void run() {
        Notice notice = NoticeFactory.getTrainingEditNotice(data, systemId);
        List<Employee> employees = eDAO.getEmployeesBySubscribe(data.getId());
        List<Employee> admins = eDAO.getAdmins();
        employees.addAll(admins);
        noticeService.addNotices(notice, employees);
    }

    public void seteDAO(EmployeeDAO eDAO) {
        this.eDAO = eDAO;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
}
