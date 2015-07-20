package com.exadel.jstrong.web.fortrainings.springcontroller;

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maria on 20.07.2015.
 */
@RestController
public class LoginSpringController {

    @Autowired
    private EmployeeController employeeController;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Employee login(@RequestBody Employee rempl, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = rempl.getLogin();
            String password = rempl.getPassword();
            if(login != null && password != null) {
                Employee employee = employeeController.authorization(login, password);
                if (employee == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found");
                } else {
                    String token = CookieUtil.generateToken();
                    Cookie cookie = new Cookie("token", token);
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                    employeeController.updateToken(employee.getId(), token);
                    return employee;
                }
            }
        }
        catch (JsonParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }
}
