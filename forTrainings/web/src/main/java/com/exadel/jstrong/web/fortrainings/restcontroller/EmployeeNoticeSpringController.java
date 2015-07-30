package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeNoticeController;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.model.NoticeCountUI;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by stas on 30.07.15.
 */


@RestController
public class EmployeeNoticeSpringController {

    @Autowired
    private EmployeeController ec;

    @Autowired
    private EmployeeNoticeController employeeNoticeController;

    @RequestMapping(value = "/badgeCount", method = RequestMethod.GET)
    public @ResponseBody
    NoticeCountUI getNoticeCount(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
        int id = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
        return employeeNoticeController.getNoticeCount(id);
    }
}
