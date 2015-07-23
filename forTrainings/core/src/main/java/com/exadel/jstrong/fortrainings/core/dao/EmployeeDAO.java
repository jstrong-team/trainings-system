package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Employee;

public interface EmployeeDAO extends GenericDAO<Employee> {

    Employee selectByAuthorization(String login, String password);
    //Employee getEmployeeByFullName(String name, String surname);
    //List<Employee> getAllEnglishTeachers();
}