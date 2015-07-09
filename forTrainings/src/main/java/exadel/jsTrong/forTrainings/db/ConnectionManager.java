package exadel.jsTrong.forTrainings.db;

import java.sql.*;

public abstract class ConnectionManager {

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/for_trainings";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public ResultSet executeQuery(String sql) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);
        }

        return resultSet;
    }

    public int executeUpdate(String sql) {

        Connection connection = null;
        Statement statement = null;
        int res = 0;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            res = statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, statement, connection);
        }

        return res;
    }

    public void closeAll(ResultSet resultSet, Statement statement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}