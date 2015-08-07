package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.services.NoticeService;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;

import java.util.List;

/**
 * Created by Администратор on 07.08.2015.
 */
public class CreateTrainingTask implements Runnable {
    private EmployeeDAO eDAO;
    private NoticeService noticeService;
    private TrainingDAO tDAO;

    private Integer trainingId;
    private Integer systemId;

    public CreateTrainingTask(Integer trainingId, Integer systemId) {
        this.trainingId = trainingId;
        this.systemId = systemId;
    }

    @Override
    public void run() {
        Notice notice = NoticeFactory.getTrainingCreateNotice(tDAO.getTrainingById(trainingId), systemId);
        List<Employee> employees = eDAO.getAllUsers();
        noticeService.addNotices(notice, employees);
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
