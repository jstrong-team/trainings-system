package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.Employee;

public interface EmployeeController {
    Employee authorization(String login, String password);
    void updateToken(int id, String token);
    boolean checkToken (String token);
    int getIdByToken(String token);
}
