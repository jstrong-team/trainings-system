package com.exadel.jstrong.web.fortrainings.services.scheduleservice;

import com.exadel.jstrong.fortrainings.core.model.Notice;

/**
 * Created by Anton on 29.07.2015.
 */
public class Noticer implements Runnable{

    private Notice notice;

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

    private void sendNotice(){

    }

}
