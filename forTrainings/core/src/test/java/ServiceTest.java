import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.EmployeeDAOImpl;
import com.exadel.jstrong.fortrainings.core.dao.impl.TokenDAOImpl;
import com.exadel.jstrong.fortrainings.core.dao.impl.TrainingDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import org.junit.Test;

/**
 * Created by Maria on 20.07.2015.
 */
public class ServiceTest {

    private EmployeeDAO employeeDAO;
    private TokenDAO tokenDAO;
    private TrainingDAO trainingDAO;

    public ServiceTest() {
        employeeDAO = new EmployeeDAOImpl();
        tokenDAO = new TokenDAOImpl();
        trainingDAO = new TrainingDAOImpl();
    }

//    @Test
    public void test() {
        tokenDAO.checkToken("5");
    }

   /* @Test
    public void testSelectByAuthorization() {
        Employee employee =  employeeDAO.selectByAuthorization("admin", "1111");
        System.out.println(employee);
    }

    @Test
    public void testUpdateToken() {
        tokenDAO.updateTokenByID(1, "5555");
    }*/
}
