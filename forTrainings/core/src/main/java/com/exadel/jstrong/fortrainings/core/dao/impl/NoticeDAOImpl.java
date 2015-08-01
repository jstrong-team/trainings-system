package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.NoticeDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 31.07.2015.
 */
@Service
public class NoticeDAOImpl extends BaseDAO<Notice> implements NoticeDAO {

    @Override
    @Transactional
    public int addNotice(Notice notice) {
        try {
            notice =  save(notice);
            return notice.getId();
        } catch(Throwable e){
            return 0;
        }
    }

    @Override
    @Transactional
    public void addEmployeeNotices(int noticeId, List<EmployeeNotice> employeeNotices) {
        Notice notice = getById(Notice.class, noticeId);
        notice.setEmployeeNotices(employeeNotices);
    }
}
