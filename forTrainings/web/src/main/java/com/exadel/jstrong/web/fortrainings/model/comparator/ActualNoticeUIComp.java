package com.exadel.jstrong.web.fortrainings.model.comparator;

import com.exadel.jstrong.web.fortrainings.model.NoticeUI;

import java.util.Comparator;

/**
 * Created by Anton on 31.07.2015.
 */
public class ActualNoticeUIComp implements Comparator<NoticeUI> {

    public int compare(NoticeUI a, NoticeUI b){

        if (a.getStatus().equals(b.getStatus())){
            return b.getAddDate().compareTo(a.getAddDate());
        } else {

        }
        return 0;
    }

}
