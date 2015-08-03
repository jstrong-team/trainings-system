package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeNoticeDAO;
import com.exadel.jstrong.fortrainings.core.dao.NoticeDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import com.exadel.jstrong.web.fortrainings.services.mailservice.Sender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 29.07.2015.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Noticer implements Runnable {

    private Notice notice;

    private Logger logger = Logger.getLogger(Noticer.class.getName());

    @Autowired
    SubscribeDAO subscribeDAO;

    @Autowired
    NoticeDAO noticeDAO;

    @Autowired
    EmployeeNoticeDAO employeeNoticeDAO;

    public Noticer() {
    }

    public Noticer(Notice notice) {
        this.notice = notice;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    @Override
    public void run() {
        sendNotice();
    }

    @Transactional
    private void sendNotice() {
        try {
            logger.info("Send notice");
            noticeDAO.addNotice(notice);
            List<EmployeeNotice> employeeNotices = getSubscribersNotices(notice.getTrainingId(), notice.getId());
            logger.info("Send employee notices");
            noticeDAO.addEmployeeNotices(notice.getId(), employeeNotices);
            logger.info("Send mails");
            Sender.send(notice, subscribeDAO.getSubscribersEmailsByStatus(notice.getTrainingId(), "Approve"));
        } catch (Throwable e) {
            logger.warn(e.toString());
        }
    }

    @Transactional
    private List<EmployeeNotice> getSubscribersNotices(int trainingId, int noticeId) {
        logger.info("Get subscribers");
        try {
            List<Subscribe> subscribers = subscribeDAO.getSubscribersByStatus(trainingId, "Approve");
            EmployeeNotice employeeNotice;
            List<EmployeeNotice> employeeNotices = new ArrayList<>();
            for (Subscribe s : subscribers) {
                employeeNotice = new EmployeeNotice();
                employeeNotice.setEmployeeId(s.getEmployeeId());
                employeeNotice.setNoticeId(noticeId);
                employeeNotice.setComplete(false);
                employeeNotices.add(employeeNotice);
            }
            return employeeNotices;
        } catch (Throwable e) {
            logger.warn(e.toString());
            return new ArrayList<EmployeeNotice>();
        }
    }

}
