package exadel.jsTrong.forTrainings.servlets;

import exadel.jsTrong.forTrainings.controller.EmployeeController;
import exadel.jsTrong.forTrainings.controller.EmployeeControllerImpl;
import exadel.jsTrong.forTrainings.model.Employee;
import exadel.jsTrong.forTrainings.rb.ResponseBuilder;
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
    private EmployeeController employeeController;
    private ResponseBuilder<Employee> rb;

    @Override
    public void init() throws ServletException {
        employeeController = new EmployeeControllerImpl();
        rb = new ResponseBuilder<>();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        logger.info("Login " + login);
        logger.info("Password " + password);

        Employee employee = employeeController.authorization(login, password);
        if(employee == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
        }
        else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(rb.getResponse(employee));
            out.flush();
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

}
