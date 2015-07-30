package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.model.NoticeCountUI;
import com.exadel.jstrong.web.fortrainings.model.NoticesUI;

/**
 * Created by stas on 30.07.15.
 */
public interface EmployeeNoticeController {

    NoticeCountUI getNoticeCount(int userId);
    NoticesUI getEmployeeNotices(int userId);
}
