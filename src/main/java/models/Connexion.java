package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    // private static final String URL = "jdbc:mysql://localhost:3306/db_s2_etu003245";
    // private static final String USER = "root";
    // private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003245";
    private static final String USER = "ETU003245";
    private static final String PASSWORD = "HrzZL2VS";

    public Connection getConnexion() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
        return connection;
    }
}