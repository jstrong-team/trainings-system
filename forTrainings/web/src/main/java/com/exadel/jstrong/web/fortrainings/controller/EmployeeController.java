package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;
import com.exadel.jstrong.web.fortrainings.model.ExternalUserUI;

public interface EmployeeController {
    EmployeeUI authorization(String login, String password);
    void updateToken(int id, String token);
    boolean checkToken (String token);
    int getIdByToken(String token);
    boolean isAdmin(int id);
}
