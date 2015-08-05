package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;

public interface EmployeeController {
    EmployeeUI authorization(String login, String password);
    void updateToken(int id, String token);
    boolean checkToken (String token);
    int getIdByToken(String token);
    boolean isAdmin(int id);
    void updateSession(int id, String session);
    boolean checkSession (String session);
    int getIdBySession(String session);
}
