package dao;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOTest extends BaseDAOTest {

    public static final String INITIAL_DATA_LOCATION = "/testdata/initial/employee";
    public static final String EXPECTED_DATA_LOCATION = "/testdata/expected/employee";

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void selectByAuthorization() {

        Employee expectedEmployee = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", "null", null);

        Employee actualEmployee = employeeDAO.selectByAuthorization("masha", "masha");
        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testGetNameById() {
        String expectedName = "Maria Grakova";
        String actualName = employeeDAO.getNameById(2);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testIsAdmin() {
        Assert.assertTrue(employeeDAO.isAdmin(2));
        Assert.assertFalse(employeeDAO.isAdmin(4));
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testGetAllUsers() {
        List<Employee> expectedList = new LinkedList<>();
        Employee masha = new Employee();
        masha.setId(2);
        Employee stas = new Employee();
        stas.setId(3);
        Employee kolya = new Employee();
        kolya.setId(4);
        expectedList.add(masha);
        expectedList.add(stas);
        expectedList.add(kolya);

        List<Employee> actualList = employeeDAO.getAllUsers();

        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testGetEmail() {
        String expectedMail = new String("mariagracova96@gmail.com");
        String actualMail = employeeDAO.getEmail(2);

        Assert.assertEquals(expectedMail, actualMail);
    }

    @Test
    public void testGetEmployeesMails() {
        List<String> expectedMails = new LinkedList<>();
        expectedMails.add("mariagracova96@gmail.com");
        expectedMails.add("staspetrovichbsu@gmail.com");
        expectedMails.add("nickylebedev@gmail.com");

        List<Employee> employees = new LinkedList<>();
        Employee masha = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", null, null);
        Employee stas = new Employee(3, "stas", "c211c9e7e7689217c0cb99aafe30f3d7", "Stas Petrovich", "staspetrovichbsu@gmail.com", null, null);
        Employee kolya = new Employee(4, "kolya", "ec3da25081aa81b637fe6faa3debe26e", "Nikolay Lebedev", "nickylebedev@gmail.com", null, null);
        employees.add(masha);
        employees.add(stas);
        employees.add(kolya);

        List<String> actualMails = employeeDAO.getEmployeesMails(employees);

        Assert.assertEquals(expectedMails, actualMails);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testGetAdmins() {
        List<Employee> expectedEmployees = new LinkedList<>();
        Employee masha = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", null, null);
        Employee stas = new Employee(3, "stas", "c211c9e7e7689217c0cb99aafe30f3d7", "Stas Petrovich", "staspetrovichbsu@gmail.com", null, null);
        expectedEmployees.add(masha);
        expectedEmployees.add(stas);

        List<Employee> actualEmployees = employeeDAO.getAdmins();
        Assert.assertEquals(expectedEmployees, actualEmployees);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testGetById() {
        Employee expectedEmployee = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", null, null);
        Employee actualEmployee = employeeDAO.getById(2);

        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/save.xml")
    @ExpectedDatabase(value = EXPECTED_DATA_LOCATION + "/save.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSaveEmployee() {
        Employee expectedEmployee = new Employee();
        expectedEmployee.setLogin("dima");
        expectedEmployee.setPassword("dima");
        expectedEmployee.setName("Dmitriy Nedelko");

        Employee actualEmployee = employeeDAO.saveEmployee(expectedEmployee);

        Assert.assertEquals(expectedEmployee.getLogin(), actualEmployee.getLogin());
        Assert.assertEquals("0f5b25cd58319cde0e6e33715b66db4c", actualEmployee.getPassword());
        Assert.assertEquals(expectedEmployee.getName(), actualEmployee.getName());
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/role.xml")
    @ExpectedDatabase(value = EXPECTED_DATA_LOCATION + "/role.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSetEmployeeRole() {
        Employee employee = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", null, null);

        employeeDAO.setEmployeeRole(employee, "admin");
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/external.xml")
    public void testGetAllInsideUsers() {
        List<Employee> expectedEmployees = new LinkedList<>();
        Employee masha = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", null, null);
        Employee stas = new Employee(3, "stas", "c211c9e7e7689217c0cb99aafe30f3d7", "Stas Petrovich", "staspetrovichbsu@gmail.com", null, null);
        expectedEmployees.add(masha);
        expectedEmployees.add(stas);

        List<Employee> actualEmployees = new LinkedList<>();
        actualEmployees = employeeDAO.getAllInsideUsers();

        Assert.assertEquals(expectedEmployees, actualEmployees);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testGetEmployee() {
        Employee expectedEmployee = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", null, null);
        Employee actualEmployee = employeeDAO.getEmployee(2);
        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testGetEmployeeRoleId() {
        Integer expectedRoleID = 3;
        Integer actualRoleID = employeeDAO.getEmployeeRoleId(4);
        Assert.assertEquals(expectedRoleID, actualRoleID);
    }
}