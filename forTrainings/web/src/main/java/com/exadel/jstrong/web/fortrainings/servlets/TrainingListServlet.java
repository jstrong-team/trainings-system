package com.exadel.jstrong.web.fortrainings.servlets;

import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.controller.impl.TrainingsControllerImpl;
import com.exadel.jstrong.web.fortrainings.responsebuilder.ResponseBuilder;
import com.exadel.jstrong.web.fortrainings.util.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/forTrainings/trainings/trainingHistory")
public class TrainingListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(SigninServlet.class.getName());
    private TrainingsController trainingsController;
    private ResponseBuilder<List<Training>> rb;

    @Override
    public void init() throws ServletException {
        trainingsController = new TrainingsControllerImpl();
        rb = new ResponseBuilder<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet");
        try {
            List<Training> trainings = trainingsController.getAllTrainings();
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
        }
        catch (Exception e){
            logger.error(e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
