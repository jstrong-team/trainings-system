package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeNoticeDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.EmployeeNoticeDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeNoticeController;
import com.exadel.jstrong.web.fortrainings.model.NoticeCountUI;
import org.springframework.stereotype.Component;

/**
 * Created by stas on 30.07.15.
 */
@Component
public class EmployeeNoticeControllerImpl implements EmployeeNoticeController {

    @Override
    public NoticeCountUI getNoticeCount(int userId) {
        EmployeeNoticeDAO employeeNotice = new EmployeeNoticeDAOImpl();
        NoticeCountUI noticeCount = new NoticeCountUI();
        noticeCount.setBadgeCount(employeeNotice.getNoticeCount(userId));
        return noticeCount;
    }
}
