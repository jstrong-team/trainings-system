package com.exadel.jstrong.web.fortrainings.model.comparator;

import com.exadel.jstrong.web.fortrainings.model.NoticeUI;

import java.util.Comparator;

/**
 * Created by Anton on 30.07.2015.
 */
public class NoticeUIComp implements Comparator<NoticeUI> {

    @Override
    public int compare(NoticeUI a, NoticeUI b){
        return b.getAddDate().compareTo(a.getAddDate());
    }

}
