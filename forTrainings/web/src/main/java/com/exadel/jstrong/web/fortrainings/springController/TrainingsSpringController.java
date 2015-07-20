package com.exadel.jstrong.web.fortrainings.springcontroller;

import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Anton on 20.07.2015.
 */

@RestController
@RequestMapping(value="/trainings")
public class TrainingsSpringController {

    @Autowired
    private EmployeeController ec;
    @Autowired
    private TrainingsController trainingsController;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Training> getHistory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
            int id = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
            List<Training> trainings = trainingsController.getAllTrainings(id);
            if(trainings == null) {
                response.sendError(HttpServletResponse.SC_NO_CONTENT, "No data about trainings in db");
            }
            else {
                return trainings;
            }
        } catch (Exception e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "/logOut", method = RequestMethod.DELETE)
    public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Map<String, Cookie> cookieMap = CookieUtil.cookiesToMap(request.getCookies());
            Cookie token = cookieMap.get(CookieUtil.TOKEN);
            Cookie temp = null;
            if (token != null) {
                temp = new Cookie(CookieUtil.TOKEN, CookieUtil.generateToken());
                temp.setPath("/");
                response.addCookie(temp);
            }
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/searchTrainings", method = RequestMethod.GET)
    public @ResponseBody List<Training> getSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String str = request.getParameter("search");
            List<Training> trainings = trainingsController.getSearchData(str);
            if(trainings == null) {
                response.sendError(HttpServletResponse.SC_NO_CONTENT, "No data about trainings in db");
            }
            else {
                return trainings;
            }
        }
        catch (Exception e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

}
