package exadel.jsTrong.forTrainings.controller;

import exadel.jsTrong.forTrainings.model.Employee;

public interface EmployeeController {
    void authorization(String login, String password);
    String getResponse();
}
