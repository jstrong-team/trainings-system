package com.exadel.jstrong.web.fortrainings.model;

import java.util.List;

/**
 * Created by Anton on 30.07.2015.
 */
public class NoticesUI {

    private List<NoticeUI> actualNotices;
    private List<NoticeUI> historyNotices;

    public List<NoticeUI> getActualNotices() {
        return actualNotices;
    }

    public void setActualNotices(List<NoticeUI> actualNotices) {
        this.actualNotices = actualNotices;
    }

    public List<NoticeUI> getHistoryNotices() {
        return historyNotices;
    }

    public void setHistoryNotices(List<NoticeUI> historyNotices) {
        this.historyNotices = historyNotices;
    }
}
