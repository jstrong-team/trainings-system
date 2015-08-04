package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Anton on 04.08.2015.
 */
@Component
public class RestService {

    @Autowired
    private EmployeeController ec;

    public int getUserId(HttpServletRequest request){
        Map<String, Cookie> map = CookieUtil.cookiesToMap(request.getCookies());
        Cookie session = map.get(CookieUtil.SESSION);
        Cookie token = map.get(CookieUtil.TOKEN);
        return (session == null) ? ec.getIdByToken(token.getValue()) : ec.getIdBySession(session.getValue());
    }

}
