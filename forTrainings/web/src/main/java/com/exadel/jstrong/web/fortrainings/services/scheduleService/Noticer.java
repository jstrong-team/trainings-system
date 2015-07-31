package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 29.07.2015.
 */
@Component
public class Noticer implements Runnable{

    private Notice notice;

    @Autowired
    SubscribeDAO subscribeDAO;

    public Noticer(){};

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
    public void run(){

    }

    @Transactional
    private void sendNotice(){
        List<EmployeeNotice> employeeNotices = getSubscribersNotices(notice.getTrainingId(), notice.getId());

    }

    private List<EmployeeNotice> getSubscribersNotices(int trainingId, int noticeId){
        List<Subscribe> subscribers = subscribeDAO.getSubscribersByStatus(trainingId, "Approve");
        List<EmployeeNotice> employeeNotices = new ArrayList<>();
        EmployeeNotice employeeNotice;
        for (EmployeeNotice en: employeeNotices){
            employeeNotice = new EmployeeNotice();
            employeeNotice.setEmployeeId(en.getEmployeeId());
            employeeNotice.setNoticeId(noticeId);
            employeeNotices.add(employeeNotice);
        }
        return employeeNotices;
    }

}
