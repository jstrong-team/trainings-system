package com.exadel.jstrong.web.fortrainings.services.scheduleservice_;

import com.exadel.jstrong.fortrainings.core.model.Notice;
import org.apache.log4j.Logger;

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
        return null;
    }

    private void createSchedule(){

    }

}
