package com.exadel.jstrong.web.fortrainings.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 07.08.2015.
 */
public class TaskExecutor {
    private final int THREADCOUNT = 10;
    private ExecutorService executor;
    private Logger logger = Logger.getLogger(TaskExecutor.class.getName());

    public void init() {
        logger.info("TaskExecutor init");
        try {
            executor = Executors.newFixedThreadPool(THREADCOUNT);
        } catch (Throwable e) {
            logger.warn(e.getMessage());
        }

    }

    public void submitTask(Runnable task) {
        executor.submit(task);
    }

    private void destroy(){
        executor.shutdown();
    }
}
