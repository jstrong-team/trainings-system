package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.db.ConnectionManager;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import org.apache.log4j.Logger;

import javax.persistence.Query;
import java.sql.*;

public class EmployeeDAOImpl extends ConnectionManager implements EmployeeDAO {
    private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());

    public Employee selectByAuthorization(String login, String password) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.login = :log  AND  e.password = :pas", Employee.class).setParameter("log", login).setParameter("pas", password);
        Employee employee = (Employee)query.getSingleResult();
        em.getTransaction().commit();
        return employee;
    }
/*
    public boolean checkToken(String token){
        boolean isCorrect = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM token WHERE value = ?");
            preparedStatement.setString(1, token);
            resultSet = preparedStatement.executeQuery();

            isCorrect = (resultSet.next());

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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
        return isCorrect;
    }

    private String getRoleById(int id) {
        String role = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employee_role INNER JOIN role ON employee_role.role_id=role.id WHERE employee_id = "
                    + Integer.toString(id));
            resultSet.next();
            role = resultSet.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
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
        return role;
    }

    public void updateTokenById (int id, String token){

    }

    @Override
    public int getIdByToken(String token) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        int id = 0;
        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement("SELECT employee_id FROM token WHERE value = ?");
            preparedStatement.setString(1, token);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            id = resultSet.getInt("employee_id");

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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
        return id;
    }
/*
    public Employee getByID(String id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Employee employee = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            rs =  statement.executeQuery("SELECT * FROM employee WHERE id = " + Integer.parseInt(id));
            rs.next();
            employee = new Employee(rs.getString("id"), rs.getString("login"), rs.getString("password"),
                    rs.getString("name"), rs.getString("surname"), rs.getString("mail"),
                    rs.getString("phone"), rs.getBoolean("admin"), rs.getBoolean("external"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
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
*/
    //----------------------------------------
/*
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

   // @Override
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

   // @Override
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

   // @Override
    public boolean delete(String id) {
        boolean boolRes = false;
        int res = executeUpdate("DELETE FROM employees WHERE id = " + id);

        if (res > 0)
            boolRes = true;

        return boolRes;
    }

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
    }*/

}