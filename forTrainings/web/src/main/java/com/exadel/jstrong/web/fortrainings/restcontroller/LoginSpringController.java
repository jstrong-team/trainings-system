package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.fortrainings.core.model.Account;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import com.google.gson.JsonParseException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Maria on 20.07.2015.
 */
@RestController
public class LoginSpringController {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private TokenDAO tokenDAO;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    EmployeeUI login(@RequestBody Account rempl, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = rempl.getLogin();
            String password = DigestUtils.md5Hex(rempl.getPassword());
            if (login != null && password != null) {
                EmployeeUI employeeUI = employeeController.authorization(login, password);
                if (employeeUI == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found");
                } else {
                    String cookieValue = CookieUtil.generateToken();
                    Cookie cookie = null;
                    if (rempl.isRememberMe()) {
                        cookie = new Cookie("token", cookieValue);
                        employeeController.updateToken(employeeUI.getId(), cookieValue);
                        cookie.setPath("/");
                        cookie.setMaxAge(-1);
                        response.addCookie(cookie);
                    }
                    cookieValue = CookieUtil.generateToken();
                    cookie = new Cookie("session", cookieValue);
                    employeeController.updateSession(employeeUI.getId(), cookieValue);
                    employeeController.updateDate(employeeUI.getId(), new Date());
                    cookie.setPath("/");
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                    return employeeUI;
                }
            }
        } catch (JsonParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }
}
