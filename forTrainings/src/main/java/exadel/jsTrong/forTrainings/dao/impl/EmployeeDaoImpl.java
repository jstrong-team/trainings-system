package exadel.jsTrong.forTrainings.dao.impl;

import exadel.jsTrong.forTrainings.dao.EmployeeDAO;
import exadel.jsTrong.forTrainings.model.Employee;
import exadel.jsTrong.forTrainings.db.ConnectionManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Employee employee;
    private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());

    public Employee selectByAuthorization(String ulogin, String upassword) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE" +
                    " login = ? " + " AND  " + " password = ?");
            preparedStatement.setString(1, ulogin);
            preparedStatement.setString(2, upassword);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee(resultSet.getString("id"), resultSet.getString("login"),
                        resultSet.getString("password"), resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("mail"), resultSet.getString("phone"), resultSet.getBoolean("admin"),
                        resultSet.getBoolean("external"));
            }

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
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByFullName(String name, String surname) {
        return null;
    }

    @Override
    public List<Employee> getAllEnglishTeachers() {
        return null;
    }

    @Override
    public Employee getByID(String ID) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}