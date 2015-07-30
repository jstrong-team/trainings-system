package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

import com.exadel.jstrong.fortrainings.core.dao.MeetDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.MeetDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import org.apache.log4j.Logger;

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
public class NoticePlanner implements Runnable {

    public static ScheduledExecutorService executor;
    private Logger logger = Logger.getLogger(NoticePlanner.class.getName());

    private void init() {
        System.out.println("INIT");
        try {
            executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(this, 0, 30, TimeUnit.MINUTES);
        } catch (Throwable e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {

        } catch (Throwable e) {
            logger.warn(e.getMessage());
        }
    }

    private List<Notice> getNotices(){
        MeetDAO meetDAO = new MeetDAOImpl();
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.HOUR, hour + 3);
        Date dateFrom = calendar.getTime();
        calendar.set(Calendar.MINUTE, minute + 20);
        Date dateTo = calendar.getTime();
        List<Meet> meets = meetDAO.getMeetsInDateScope(dateFrom, dateTo);
        List<Notice> notices = new ArrayList<>();
        return notices;
    }

    private void createSchedule(){
        
    }

}
