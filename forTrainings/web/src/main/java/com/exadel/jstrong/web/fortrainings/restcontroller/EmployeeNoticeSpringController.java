package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeNoticeController;
import com.exadel.jstrong.web.fortrainings.model.NoticeCountUI;
import com.exadel.jstrong.web.fortrainings.model.NoticesHistoryUI;
import com.exadel.jstrong.web.fortrainings.model.NoticesUI;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by stas on 30.07.15.
 */


@RestController
@RequestMapping(value = "/news")
public class EmployeeNoticeSpringController {

    @Autowired
    private EmployeeController ec;

    @Autowired
    private EmployeeNoticeController employeeNoticeController;

    @RequestMapping(value = "/badgeCount", method = RequestMethod.GET)
    public @ResponseBody NoticeCountUI getNoticeCount(HttpServletRequest request, HttpServletResponse response) {
        NoticeCountUI n = null;
        try {
            Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
            int id = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
            n = employeeNoticeController.getNoticeCount(id);
        } catch(Throwable e){
            e.printStackTrace();
        }
        return n;
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public @ResponseBody
    NoticesUI getEmployeeNotices(HttpServletRequest request, HttpServletResponse response) {
        NoticesUI notices = null;
        try {
            Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
            int id = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
            int count = Integer.parseInt(request.getParameter("count"));
            notices = employeeNoticeController.getEmployeeNotices(id, count);
        } catch(Throwable e){
            e.printStackTrace();
        }
        return notices;
    }

    @RequestMapping(value = "/noticeHistory", method = RequestMethod.GET)
    public @ResponseBody
    NoticesHistoryUI getEmployeeNoticesHistory(HttpServletRequest request, HttpServletResponse response) {
        NoticesHistoryUI notices = null;
        try {
            Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
            int id = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
            int count = Integer.parseInt(request.getParameter("count"));
            int page = Integer.parseInt(request.getParameter("page"));
            notices = employeeNoticeController.getEmployeeNoticesHistoryByPage(id, count, page);
        } catch(Throwable e){
            e.printStackTrace();
        }
        return notices;
    }

}
