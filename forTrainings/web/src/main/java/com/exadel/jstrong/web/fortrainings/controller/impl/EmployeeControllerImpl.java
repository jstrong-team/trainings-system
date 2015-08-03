package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;
    @Autowired
    private TokenDAO tokenDAO;

    //TODO: why we checks password and login here? We got an entity using login and pass
    public EmployeeUI authorization(String login, String password) {

        Employee employee = employeeDao.selectByAuthorization(login, password);
        EmployeeUI  employeeUI = null;
        if(employee != null) {
            int a = login.compareToIgnoreCase(employee.getLogin());
            int b = password.compareToIgnoreCase(employee.getPassword());
            if(!(a == 0 || b == 0)) {
                employee = null;
            }
        }
        employeeUI = new EmployeeUI(employee.getId(), employee.getName());
        return employeeUI;
    }

    public void updateToken (int id, String token){
        tokenDAO.updateTokenByID(id, token);
    }

    public boolean checkToken (String token){
        return tokenDAO.checkToken(token);
    }

    public int getIdByToken(String token) {return tokenDAO.getIdByToken(token);}

    public boolean isAdmin(int id) {
        return employeeDao.isAdmin(id);
    }

    @Override
    public void updateSession(int id, String session) {
        tokenDAO.updateSession(id, session);
    }

    @Override
    public void updateDateBySession(String session, Date date) {
        tokenDAO.updateDateBySession(session, date);
    }

    @Override
    public void updateDate(int id, Date date) {
        tokenDAO.updateDate(id, date);
    }

    public boolean checkSession (String session){
        return tokenDAO.checkSession(session);
    }

    @Override
    public Date getDateBySession(String session) {
        return tokenDAO.getDateBySession(session);
    }

    @Override
    public int getIdBySession(String session) {
        return tokenDAO.getIdBySession(session);
    }
}
