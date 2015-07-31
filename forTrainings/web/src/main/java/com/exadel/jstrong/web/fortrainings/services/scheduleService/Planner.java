package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

import com.exadel.jstrong.fortrainings.core.dao.MeetDAO;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 29.07.2015.
 */
@Service
public class Planner implements Runnable {

    @Autowired
    MeetDAO meetDAO;

    @Autowired
    private ApplicationContext context;

    private int plannerDelay = 30;
    public static ScheduledExecutorService executor;
    private Logger logger = Logger.getLogger(Planner.class.getName());

    private void init() {
        logger.info("Planner init");
        try {
            executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(this, 0, plannerDelay, TimeUnit.MINUTES);
        } catch (Throwable e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            logger.info("Planner iteration run");
            createSchedule(getNotices());
        } catch (Throwable e) {
            logger.warn(e.toString());
        }
    }

    private List<Notice> getNotices(){
        logger.info("Get meet in 3 hour");
        try {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            calendar.set(Calendar.HOUR, hour + 3);
            Date dateFrom = calendar.getTime();
            calendar.set(Calendar.MINUTE, minute + plannerDelay);
            Date dateTo = calendar.getTime();
            List<Meet> meets = meetDAO.getMeetsInDateScope(dateFrom, dateTo);
            List<Notice> notices = new ArrayList<>();
            for (Meet m : meets) {
                notices.add(NoticeFactory.getMeetIn3HourNotice(m, m.getTraining()));
            }
            return notices;
        } catch(Throwable e){
            logger.warn(e.toString());
            return new ArrayList<Notice>();
        }
    }

    private void createSchedule(List<Notice> notices){
        logger.info("Create schedule");
        try {
            Noticer noticer;
            long delay;
            for (Notice n : notices) {
                noticer = context.getBean(Noticer.class);
                noticer.setNotice(n);
                delay = n.getAddDate().getTime() - (new Date()).getTime();
                executor.schedule(noticer, delay, TimeUnit.MILLISECONDS);
            }
        } catch(Throwable e){
            logger.warn(e.toString());
        }
    }

    private void destroy(){
        executor.shutdown();
    }

}
