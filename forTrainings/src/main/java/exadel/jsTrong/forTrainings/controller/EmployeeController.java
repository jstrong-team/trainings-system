package exadel.jsTrong.forTrainings.controller;

import exadel.jsTrong.forTrainings.model.Employee;

public interface EmployeeController {
    Employee authorization(String login, String password);
}
