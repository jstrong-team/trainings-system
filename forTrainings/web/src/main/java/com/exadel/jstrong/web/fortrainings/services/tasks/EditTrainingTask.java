package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.services.NoticeService;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 07.08.2015.
 */
public class EditTrainingTask implements Runnable {
    private EmployeeDAO eDAO;
    private SubscribeDAO sDAO;
    private NoticeService noticeService;

    private Training training;
    private Integer senderId;
    private Integer transactionId;
    //private List<Employee>

    public EditTrainingTask(Training training, Integer senderId, Integer transactionId) {
        this.senderId = senderId;
        this.training = training;
        this.transactionId = transactionId;
    }

    @Override
    public void run() {
        Notice notice = NoticeFactory.getNotApprovedEditedTrainingNotice(training, senderId, transactionId);
        List<Employee> admins = eDAO.getAdmins();
        List<Employee> subscribers = sDAO.getSubscribersAsEmployees(training.getId());
        noticeService.addNotices(notice, admins);
        noticeService.addNotices(notice, subscribers);
    }

    public void seteDAO(EmployeeDAO eDAO) {
        this.eDAO = eDAO;
    }

    public void setSubscribeDAO(SubscribeDAO sDAO) {
        this.sDAO = sDAO;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
}
