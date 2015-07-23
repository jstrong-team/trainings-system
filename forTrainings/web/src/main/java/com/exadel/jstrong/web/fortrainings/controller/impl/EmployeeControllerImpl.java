package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.EmployeeDAOImpl;
import com.exadel.jstrong.fortrainings.core.dao.impl.EmployeeDAOImpl;
import com.exadel.jstrong.fortrainings.core.dao.impl.TokenDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;
    @Autowired
    private TokenDAO tokenDAO;

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
        tokenDAO.updateTokenByID(id, token);
    }

    public boolean checkToken (String token){
        return tokenDAO.checkToken(token);
    }

    public int getIdByToken(String token) {return tokenDAO.getIdByToken(token);}
}
