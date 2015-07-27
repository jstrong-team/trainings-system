package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.TrainingStorageController;
import com.exadel.jstrong.web.fortrainings.model.EmployeeFeedbackUI;
import com.exadel.jstrong.web.fortrainings.model.RoleUI;
import com.exadel.jstrong.web.fortrainings.model.SubscriberUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingUI;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value="/storagetraining")
public class TrainingStorageSpringController {

    @Autowired
    private TrainingStorageController tsci;

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

    @RequestMapping(value = "/getTraining", method = RequestMethod.GET)
    public @ResponseBody TrainingUI getTraining (HttpServletRequest request, HttpServletResponse response) {
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

    @RequestMapping(value = "/addsubscriber", method = RequestMethod.POST)
    public void addSubscriber(HttpServletRequest request, HttpServletResponse response) {
        try {
            int trainingId = Integer.parseInt(request.getParameter("id"));
            Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
            int userId = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
            if(!tsci.isTrainer(userId, trainingId)) {
                if(tsci.addSubscriber(tsci.buildSubscriber(userId, trainingId))==0) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        } catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/addemployeefeedback", method = RequestMethod.POST)
    public void addFeedback(@RequestBody EmployeeFeedback ef, HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("id"));
        Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
        int userId = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
        ef.setEmployeeId(userId);
        ef.setTrainingId(trainingId);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ef.setAddDate(dateFormat.format(date));

        if(tsci.check(userId, ef.getTrainingId())) {
            tsci.addEmployeeFeedback(ef);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET)
    public @ResponseBody List<EmployeeFeedbackUI> getFeedbacks(HttpServletRequest request, HttpServletResponse response) {
        try {
            int trainingId = Integer.parseInt(request.getParameter("id"));
            //ADMIN!!!
            return tsci.getEmployeeFeedback(trainingId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/kola3", method = RequestMethod.GET)
    public @ResponseBody List<SubscriberUI> getSubscribers(HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("id"));
        return tsci.getSubscribers(trainingId);
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public @ResponseBody RoleUI getRole(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
        int userId = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
        int trainingId = Integer.parseInt(request.getParameter("id"));
        RoleUI role = new RoleUI();
        if(tsci.isTrainer(userId, trainingId)) {
            role.setRole("trainer");
        } else {
            role.setRole("user");
        }
        return role;
    }

}

