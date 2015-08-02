package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

import com.exadel.jstrong.fortrainings.core.dao.MeetDAO;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;
import javafx.util.Pair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private final long PLANNER_DELAY = 20*60*1000;
    private final Pair<Long, String> THREE_HOUR = new Pair((long)(3*60*60*1000), "3 hour");
    private final Pair<Long, String> ONE_HOUR = new Pair((long)(1*60*60*1000), "1 hour");
    private final Pair<Long, String> ONE_DAY = new Pair((long)(24*60*60*1000), "1 day");
    public static ScheduledExecutorService executor;
    private Logger logger = Logger.getLogger(Planner.class.getName());

    private void init() {
        Pair<Long, String> a = new Pair(20, "in 20 mitutes");
        logger.info("Planner init");
        try {
            executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(this, 0, PLANNER_DELAY, TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            logger.info("Planner iteration run");
            createSchedule(getNoticesByDelay(THREE_HOUR));
        } catch (Throwable e) {
            logger.warn(e.toString());
        }
    }

    private List<Notice> getNoticesByDelay(Pair<Long, String> delay){
        try {
            long time = (new Date()).getTime();
            logger.info("Get meet in " + delay.getValue());
            Date dateFrom = new Date(time + delay.getKey());
            Date dateTo = new Date(time + delay.getKey() + PLANNER_DELAY);
            List<Meet> meets = meetDAO.getMeetsInDateScope(dateFrom, dateTo);
            List<Notice> notices = new ArrayList<>();
            for (Meet m : meets) {
                notices.add(NoticeFactory.getMeetByDelayNotice(m, m.getTraining(), delay));
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
