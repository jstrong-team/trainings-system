package exadel.jsTrong.forTrainings.controller;

import exadel.jsTrong.forTrainings.dao.*;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forTrainings")
public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(LoginServlet.class.getName());
    private DaoGeneric employeeDao;
    private boolean status;

    @Override
    public void init() throws ServletException {
            this.employeeDao = new EmployeeDaoImpl();
            status = false;
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
                st = formResponse();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.print(st);
                out.flush();
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "'token' parameter needed");
            }
        } catch (SAXException | ParserConfigurationException e) {
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
        status = employeeDao.selectByAuthorization(login, password);
        logger.info("Status " + status);
    }

    private String formResponse() throws SAXException, IOException, ParserConfigurationException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        return jsonObject.toJSONString();
    }
}
