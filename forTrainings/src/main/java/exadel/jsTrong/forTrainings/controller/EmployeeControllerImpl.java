package exadel.jsTrong.forTrainings.controller;

import exadel.jsTrong.forTrainings.dao.EmployeeDAO;
import exadel.jsTrong.forTrainings.dao.impl.EmployeeDAOImpl;
import exadel.jsTrong.forTrainings.model.Employee;

public class EmployeeControllerImpl implements EmployeeController {

    private EmployeeDAO employeeDao;

    public Employee authorization(String login, String password) {
        Employee  employee;
        this.employeeDao = new EmployeeDAOImpl();
        employee = employeeDao.selectByAuthorization(login, password);
        int a = login.compareToIgnoreCase(employee.getLogin());
        int b = password.compareToIgnoreCase(employee.getPassword());
        if(!(a == 0 && b == 0))
            employee = null;
        return employee;
    }
}
