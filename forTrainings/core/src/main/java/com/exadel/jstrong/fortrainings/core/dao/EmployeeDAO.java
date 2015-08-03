package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Employee;

import java.util.List;

public interface EmployeeDAO extends GenericDAO<Employee> {

    Employee selectByAuthorization(String login, String password);
    String getNameById(int id);
    boolean isAdmin (int id);
    List<Employee> getAllUsers();
    String getEmail(int id);
    //Employee getEmployeeByFullName(String name, String surname);
    //List<Employee> getAllEnglishTeachers();
}