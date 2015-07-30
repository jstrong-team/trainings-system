package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;

import java.util.List;

/**
 * Created by stas on 30.07.15.
 */
public interface EmployeeNoticeDAO extends GenericDAO<EmployeeNotice> {

    List<Notice> getEmployeeNotices(Employee employee);
    List<Notice> getTrainingNotices(Training training);
    List<Notice> getCompletedEmployeeNotices();
    int getNoticeCount(int userId);
}

