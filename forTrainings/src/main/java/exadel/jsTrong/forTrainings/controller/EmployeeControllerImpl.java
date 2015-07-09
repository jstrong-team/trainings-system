package exadel.jsTrong.forTrainings.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exadel.jsTrong.forTrainings.dao.EmployeeDAO;
import exadel.jsTrong.forTrainings.dao.impl.EmployeeDAOImpl;
import exadel.jsTrong.forTrainings.model.Employee;
import com.google.gson.JsonParseException;

public class EmployeeControllerImpl implements Controller {
    private Employee  employee;
    private EmployeeDAO employeeDao;

    @Override
    public void authorization(String login, String password) {
        this.employeeDao = new EmployeeDAOImpl();
        employee = employeeDao.selectByAuthorization(login, password);
    }

    @Override
    public String getResponse() throws JsonParseException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(employee);
        return json;
    }
}
