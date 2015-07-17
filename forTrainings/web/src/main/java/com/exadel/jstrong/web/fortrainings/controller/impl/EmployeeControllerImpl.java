package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.EmployeeDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;

public class EmployeeControllerImpl implements EmployeeController {

    private EmployeeDAO employeeDao;

    public EmployeeControllerImpl() {
        this.employeeDao = new EmployeeDAOImpl();
    }

    public Employee authorization(String login, String password) {
        Employee  employee;
        employee = employeeDao.selectByAuthorization(login, password);
        if(employee != null) {
            int a = login.compareToIgnoreCase(employee.getLogin());
            int b = password.compareToIgnoreCase(employee.getPassword());
            if(!(a == 0 || b == 0)) {
                employee = null;
            }
        }
        return employee;
    }

    public void updateToken (int id, String token){
        employeeDao.updateTokenByID(id, token);
    }

    public boolean checkToken (String token){
        return employeeDao.checkToken(token);
    }
}
