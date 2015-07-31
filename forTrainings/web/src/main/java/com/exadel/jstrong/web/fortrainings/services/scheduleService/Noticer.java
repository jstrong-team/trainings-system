package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

import com.exadel.jstrong.fortrainings.core.dao.NoticeDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
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

    public Noticer() {
    }

    ;

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
            notice = noticeDAO.addNotice(notice);
            List<EmployeeNotice> employeeNotices = getSubscribersNotices(notice.getTrainingId(), notice.getId());
            notice.setEmployeeNotices(employeeNotices);
            logger.info("Send notice");
        } catch (Throwable e) {
            logger.warn(e.toString());
        }
    }

    private List<EmployeeNotice> getSubscribersNotices(int trainingId, int noticeId) {
        logger.info("Send notice to subscribers");
        try {
            List<Subscribe> subscribers = subscribeDAO.getSubscribersByStatus(trainingId, "Approve");
            List<EmployeeNotice> employeeNotices = new ArrayList<>();
            EmployeeNotice employeeNotice;
            for (Subscribe s : subscribers) {
                employeeNotice = new EmployeeNotice();
                employeeNotice.setEmployeeId(s.getEmployeeId());
                employeeNotice.setNoticeId(noticeId);
                employeeNotices.add(employeeNotice);
            }
            return employeeNotices;
        } catch (Throwable e) {
            logger.warn(e.toString());
            return new ArrayList<EmployeeNotice>();
        }
    }

}
