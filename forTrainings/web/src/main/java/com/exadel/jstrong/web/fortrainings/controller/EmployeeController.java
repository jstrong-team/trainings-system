package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;
import com.exadel.jstrong.web.fortrainings.model.ExternalUserUI;

import java.util.Date;

public interface EmployeeController {
    EmployeeUI authorization(String login, String password);
    void updateToken(int id, String token);
    boolean checkToken (String token);
    int getIdByToken(String token);
    boolean isAdmin(int id);
    void updateSession(int id, String session);
    void updateDate(int id, Date date);
    void updateDateBySession(String session, Date date);
    boolean checkSession (String session);
    Date getDateBySession(String session);
    int getIdBySession(String session);
}
