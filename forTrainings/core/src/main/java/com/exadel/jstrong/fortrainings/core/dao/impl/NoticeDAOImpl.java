package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.NoticeDAO;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Anton on 31.07.2015.
 */
@Service
public class NoticeDAOImpl extends BaseDAO<Notice> implements NoticeDAO {

    @Override
    @Transactional
    public Notice addNotice(Notice notice) {
        try {
            return notice = save(notice);
        } catch(Throwable e){
            return new Notice();
        }
    }
}
