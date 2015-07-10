package com.exadel.jstrong.web.fortrainings.servlets;

import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.impl.EmployeeControllerImpl;
import com.exadel.jstrong.web.fortrainings.responsebuilder.ResponseBuilder;
import com.exadel.jstrong.web.fortrainings.servlets.util.ServletUtil;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import com.google.gson.JsonParseException;
import com.google.gson.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forTrainings")
public class SigninServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(SigninServlet.class.getName());
    private EmployeeController employeeController;
    private ResponseBuilder<Employee> rb;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        employeeController = new EmployeeControllerImpl();
        rb = new ResponseBuilder<>();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        String data = ServletUtil.getEmployeeBody(request);
        try {
            /*JSONObject json = ServletUtil.stringToJson(data);
            Object login = json.get("login");
            Object password = json.get("password");*/
            Employee rempl = gson.fromJson(data, Employee.class);
            String login = rempl.getLogin();
            String password = rempl.getPassword();
            logger.info("Login: " + login + "; Password: " + password);
            if(login != null && password != null) {
                Employee employee = employeeController.authorization(login, password);
                if (employee == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found");
                } else {
                    response.setCharacterEncoding(ServletUtil.UTF_8);
                    response.setContentType(ServletUtil.APPLICATION_JSON);
                    PrintWriter out = response.getWriter();
                    out.print(rb.getResponse(employee));
                    out.flush();
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            }
        }
        catch (JsonParseException e) {
            logger.error(e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
