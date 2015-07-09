package exadel.jsTrong.forTrainings.dao.impl;

import exadel.jsTrong.forTrainings.dao.EmployeeDAO;
import exadel.jsTrong.forTrainings.model.Employee;
import exadel.jsTrong.forTrainings.db.ConnectionManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends ConnectionManager implements EmployeeDAO {
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
        Employee employee = null;
        ResultSet rs = executeQuery("SELECT * FROM employees WHERE name = " + name +
                " AND surname = " + surname);

        try {
            employee = new Employee(rs.getString("id"), rs.getString("login"), rs.getString("password"),
                    rs.getString("name"), rs.getString("surname"), rs.getString("mail"),
                    rs.getString("phone"), rs.getBoolean("admin"), rs.getBoolean("external"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEnglishTeachers() {
        // TODO
        return null;
    }

    @Override
    public Employee getByID(String ID) {
        Employee employee = null;
        ResultSet rs = executeQuery("SELECT * FROM employees WHERE id = " + ID);

        try {
            employee = new Employee(rs.getString("id"), rs.getString("login"), rs.getString("password"),
                    rs.getString("name"), rs.getString("surname"), rs.getString("mail"),
                    rs.getString("phone"), rs.getBoolean("admin"), rs.getBoolean("external"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean update(Employee employee) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean boolRes = false;
        int res = 0;
        String sql = "UPDATE employees SET login = ?, password = ?, name = ?, surname = ?, " +
                "mail = ?,  phone = ?, admin = ?, external = ?" +
                "WHERE id = " + employee.getId();

        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, employee.getLogin());
            ps.setString(2, employee.getPassword());
            ps.setString(3, employee.getName());
            ps.setString(4, employee.getSurname());
            ps.setString(5, employee.getMail());
            ps.setString(6, employee.getPhone());
            ps.setBoolean(7, employee.getAdmin());
            ps.setBoolean(8, employee.getExternal());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, ps, connection);
        }

        if (res > 0)
            boolRes = true;

        return boolRes;
    }

    @Override
    public boolean save(Employee employee) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean boolRes = false;
        int res = 0;
        String sql = "INSERT INTO employees (login, password, name, surname, mail, phone, admin, external) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, employee.getLogin());
            ps.setString(2, employee.getPassword());
            ps.setString(3, employee.getName());
            ps.setString(4, employee.getSurname());
            ps.setString(5, employee.getMail());
            ps.setString(6, employee.getPhone());
            ps.setBoolean(7, employee.getAdmin());
            ps.setBoolean(8, employee.getExternal());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, ps, connection);
        }

        if (res > 0)
            boolRes = true;

        return boolRes;
    }

    @Override
    public boolean delete(String id) {
        boolean boolRes = false;
        int res = executeUpdate("DELETE FROM employees WHERE id = " + id);

        if (res > 0)
            boolRes = true;

        return boolRes;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        Employee employee = null;

        ResultSet rs = executeQuery("SELECT * FROM employees");

        try {
            while (rs.next()) {
                employee = new Employee(rs.getString("id"), rs.getString("login"), rs.getString("password"),
                        rs.getString("name"), rs.getString("surname"), rs.getString("mail"),
                        rs.getString("phone"), rs.getBoolean("admin"), rs.getBoolean("external"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}