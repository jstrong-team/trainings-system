package exadel.jsTrong.forTrainings.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/something";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "04968786";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
