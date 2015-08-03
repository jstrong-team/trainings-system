package com.exadel.jstrong.web.fortrainings.services.noticeservice;

import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by Anton on 30.07.2015.
 */
public class NoticeFactory {

    private static Logger logger = Logger.getLogger(NoticeFactory.class);

    public static Notice getMeetByDelayNotice(Meet meet, Training training, String delay){
        try {
            Notice notice = new Notice();
            notice.setTheme("Meet is coming!");
            notice.setText("Meet of training " + training.getName() + "will be in" + delay);
            notice.setSenderId(1);
            notice.setStatus("info");
            notice.setTrainingId(training.getId());
            Date date = meet.getDate();
            int hour = date.getHours();
            date.setHours(hour - 3);
            notice.setAddDate(date);
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }



}
