package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;

import java.util.List;

/**
 * Created by stas on 30.07.15.
 */
public interface EmployeeNoticeDAO extends GenericDAO<EmployeeNotice> {

    List<Notice> getEmployeeActualNotices(int userId);
    List<Notice> getEmployeeFirstHistoryNotices(int userId);
    List<Notice> getTrainingNotices(int trainingId);
    List<Notice> getCompletedEmployeeNotices();
    int getNoticeCount(int userId);
    int getHistoryNoticeCount(int userId);
}

