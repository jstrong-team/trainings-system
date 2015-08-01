package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;

import java.util.List;

/**
 * Created by Anton on 31.07.2015.
 */
public interface NoticeDAO {

    Notice addNotice(Notice notice);
    void addEmployeeNotices(int noticeId, List<EmployeeNotice> employeeNotices);

}
