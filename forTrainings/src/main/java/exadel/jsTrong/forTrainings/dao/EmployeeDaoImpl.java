package exadel.jsTrong.forTrainings.dao;

import exadel.jsTrong.forTrainings.model.Employee;
import exadel.jsTrong.forTrainings.db.ConnectionManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl implements DaoGeneric<Employee> {
    private Employee employee;
    private static Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName());

    public Employee selectByAuthorization(String ulogin, String upassword) {
       /* boolean status = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String login = null;
        String password = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM staff");//!!!!!!
            while (resultSet.next()) {
                login = resultSet.getString("login");
                password = resultSet.getString("password");
            }
            int a = ulogin.compareToIgnoreCase(login);
            int b = upassword.compareToIgnoreCase(password);
            if(a == 0 && b == 0)
                status = true;

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }*/
        return employee;
    }
}
