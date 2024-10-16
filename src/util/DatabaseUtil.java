//1. Database Integration with JDBC (util/DatabaseUtil.java)
//To simulate a real-world project, integrate an actual database instead of using in-memory lists.


package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:h2:~/testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // Method to get database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to close database connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//Explanation: This utility provides a database connection using JDBC. It connects to an H2 database (in-memory or file-based) to simulate real-world persistence.