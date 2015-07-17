package com.exadel.jstrong.web.fortrainings.servlets;

import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.controller.impl.TrainingsControllerImpl;
import com.exadel.jstrong.web.fortrainings.responsebuilder.ResponseBuilder;
import com.exadel.jstrong.web.fortrainings.util.AppUtil;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/rest/trainings")
public class TrainingListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(TrainingListServlet.class.getName());
    private TrainingsController trainingsController;
    private ResponseBuilder<List<Training>> rb;
    private Gson gson;
    private final String TOKEN = "token";

    @Override
    public void init() throws ServletException {
        trainingsController = new TrainingsControllerImpl();
        rb = new ResponseBuilder<>();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<Training> trainings = trainingsController.getAllTrainings(id);
            if(trainings == null) {
                response.sendError(HttpServletResponse.SC_NO_CONTENT, "No data about trainings in db");
                logger.info("No data about trainings in db");
            }
            else {
                response.setCharacterEncoding(AppUtil.UTF_8);
                response.setContentType(AppUtil.APPLICATION_JSON);
                PrintWriter out = response.getWriter();
                String trainingsJSONString = rb.getResponse(trainings);
                out.print(trainingsJSONString);
                out.flush();
                response.setStatus(HttpServletResponse.SC_OK);
                logger.info(trainingsJSONString);
            }
        } catch (Exception e){
            logger.error(e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void doDelete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        logger.info("doDelete");
        try {
            Map<String, Cookie> cookieMap = CookieUtil.cookiesToMap(request.getCookies());
            Cookie token = cookieMap.get(TOKEN);
            if (token != null) {
                token.setMaxAge(0);
                response.addCookie(token);
            }
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e){
            logger.error(e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
