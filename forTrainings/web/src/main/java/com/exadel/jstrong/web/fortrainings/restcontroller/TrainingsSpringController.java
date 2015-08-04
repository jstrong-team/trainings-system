package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;
import com.exadel.jstrong.web.fortrainings.model.SearchEventUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingsUI;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import com.exadel.jstrong.web.fortrainings.services.RestService;
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
    @Autowired
    private RestService restService;

    //TODO: replace e.printStackTrace --> logger.warn/error
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody TrainingsUI getHistory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = restService.getUserId(request);
            TrainingsUI trainingsUI = trainingsController.getAllTrainings(id);
            if(trainingsUI == null) {
                response.sendError(HttpServletResponse.SC_NO_CONTENT, "No data about events in db");
            }
            else {
                return trainingsUI;
            }
        } catch (Exception e){
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

    //TODO: add error login
    @RequestMapping(value = "/logOut", method = RequestMethod.DELETE)
    public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Map<String, Cookie> cookieMap = CookieUtil.cookiesToMap(request.getCookies());
            Cookie token = cookieMap.get(CookieUtil.TOKEN);
            Cookie session = cookieMap.get(CookieUtil.SESSION);
            Cookie temp = null;
            if (token != null) {
                temp = new Cookie(CookieUtil.TOKEN, CookieUtil.generateToken());
                temp.setPath("/");
                temp.setMaxAge(0);
                response.addCookie(temp);
            }
            if (session != null){
                temp = new Cookie(CookieUtil.SESSION, CookieUtil.generateToken());
                temp.setPath("/");
                temp.setMaxAge(0);
                response.addCookie(temp);
            }
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    //TODO: add error logging
    @RequestMapping(value = "/searchTrainings", method = RequestMethod.GET)
    public @ResponseBody List<SearchEventUI> getSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
            try {
            String str = request.getParameter("search");
            List<SearchEventUI> events = trainingsController.getSearchData(str);
            if(events == null) {
                response.sendError(HttpServletResponse.SC_NO_CONTENT, "No data about events in db");
            }
            else {
                return events;
            }
        }
        catch (Exception e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<EmployeeUI> getUsers(HttpServletRequest request, HttpServletResponse response) {
        return trainingsController.getUsersToReport();
    }

}
