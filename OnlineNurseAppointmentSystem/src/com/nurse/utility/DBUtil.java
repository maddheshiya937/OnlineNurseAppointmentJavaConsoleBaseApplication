package com.nurse.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    private static Connection connNurse;

    public static Connection createConnection() throws SQLException {
    	ResourceBundle resMySQL = ResourceBundle.getBundle("com.nurse.utility.mysql");


        String url = resMySQL.getString("url");
        String username = resMySQL.getString("username");
        String password = resMySQL.getString("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found", e);
        }

        connNurse = DriverManager.getConnection(url, username, password);
        return connNurse;
    }

    public static void closeConnection() throws SQLException {
        if (connNurse != null) {
            connNurse.close();
        }
    }
}
