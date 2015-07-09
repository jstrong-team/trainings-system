package exadel.jsTrong.forTrainings.servlets;

import exadel.jsTrong.forTrainings.controller.Controller;
import exadel.jsTrong.forTrainings.controller.EmployeeController;
import exadel.jsTrong.forTrainings.controller.EmployeeControllerImpl;
import org.apache.log4j.Logger;
import com.google.gson.JsonParseException;

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
    private Controller controller;

    @Override
    public void init() throws ServletException {
        this.controller = new EmployeeControllerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        logger.info("Login " + login);
        logger.info("Password " + password);
        try {
            if (login != null) {
                String st;
                st = controller.getResponse();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.print(st);
                out.flush();
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "'token' parameter needed");
            }
        } catch (JsonParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        logger.info("Login " + login);
        logger.info("Password " + password);
        response.setStatus(HttpServletResponse.SC_OK);
        controller.authorization(login, password);
    }
}
