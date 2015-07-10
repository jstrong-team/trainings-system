package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.Employee;

public interface EmployeeController {
    Employee authorization(String login, String password);
}
