package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;

public interface EmployeeController {
    EmployeeUI authorization(String login, String password);
    void updateToken(int id, String token);
    boolean checkToken (String token);
    int getIdByToken(String token);
}
