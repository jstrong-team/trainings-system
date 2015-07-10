package com.exadel.jstrong.fortrainings.core.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class ConnectionManager {

    private static String driverName;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static void setProperties() throws IOException {
        Properties prop = new Properties();
        InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("dbConnection.properties");
        prop.load(in);
        driverName = prop.getProperty("driver");
        URL = prop.getProperty("connectionurl");
        USERNAME = prop.getProperty("dbusername");
        PASSWORD = prop.getProperty("dbpassword");
        in.close();
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            setProperties();
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