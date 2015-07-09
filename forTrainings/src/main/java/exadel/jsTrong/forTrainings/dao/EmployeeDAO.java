package exadel.jsTrong.forTrainings.dao;

import exadel.jsTrong.forTrainings.model.Employee;

import java.util.List;

public interface EmployeeDAO extends GenericDAO<Employee> {

    Employee selectByAuthorization(String login, String password);
    Employee getEmployeeByFullName(String name, String surname);
    List<Employee> getAllEnglishTeachers();
}