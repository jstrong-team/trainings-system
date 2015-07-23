package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.TrainingStorageController;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping(value="/storagetraining")
public class TrainingStorageSpringController {

    @Autowired
    TrainingStorageController tsci;

    @Autowired
    private EmployeeController ec;

    @RequestMapping(method = RequestMethod.POST)
    public void addTraining(@RequestBody Training training, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
            int id = ec.getIdByToken(cookies.get("token").getValue());
            training.setTrainer_id(id);
            tsci.addTraining(training);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Training getTraining (HttpServletRequest request, HttpServletResponse response) {
        try{
            int tId = Integer.parseInt(request.getParameter("id"));
            Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
            int uId = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
            return tsci.getTraining(tId, uId);
        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

}

