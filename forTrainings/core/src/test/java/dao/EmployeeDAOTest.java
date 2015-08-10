package dao;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOTest extends BaseDAOTest {

    public static final String INITIAL_DATA_LOCATION = "/testdata/initial/employee";
    public static final String EXPECTED_DATA_LOCATION = "/testdata/expected/emploee";

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

        List<Employee> actualList = new LinkedList<>();
        actualList = employeeDAO.getAllUsers();

        Assert.assertEquals(expectedList, actualList);
    }
}