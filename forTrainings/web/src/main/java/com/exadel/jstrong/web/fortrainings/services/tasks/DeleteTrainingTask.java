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
public class DeleteTrainingTask implements Runnable {
    private EmployeeDAO eDAO;
    private NoticeService noticeService;
    private TrainingDAO tDAO;

    private Integer trainingId;
    private Employee system;

    public DeleteTrainingTask(Integer trainingId, Employee system) {
        this.trainingId = trainingId;
        this.system = system;
    }

    @Override
    public void run() {
        Notice notice = NoticeFactory.getTrainingDeleteNotice(tDAO.getTrainingById(trainingId), system);
        List<Employee> admins = eDAO.getAdmins();
        noticeService.addNotices(notice, admins);
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
