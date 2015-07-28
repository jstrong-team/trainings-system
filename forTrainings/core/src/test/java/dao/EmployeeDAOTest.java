package dao;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDAOTest extends BaseDAOTest {

    public static final String INITIAL_DATA_LOCATION = "/testdata/initial/employee";
    public static final String EXPECTED_DATA_LOCATION = "/testdata/expected/emploee";

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void selectByAuthorization() {

        Employee expectedEmployee = new Employee(2, "masha", "c3cc6e312d2bad42cf535aac3a259abd", "Maria Grakova", "mariagracova96@gmail.com", "null", null);

        Employee actualEmployee = employeeDAO.selectByAuthorization("masha", "c3cc6e312d2bad42cf535aac3a259abd");
        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/get.xml")
    public void testSelectNameById() {
        String expectedName = "Maria Grakova";
        String actualName = employeeDAO.getNameById(2);
        Assert.assertEquals(expectedName, actualName);
    }
}