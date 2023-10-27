package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DBUrl = "jdbc:mysql://localhost/winFuel";
    private static final String user = "OOPacc";
    private final static String password = "1234";

    /**
     * loads the mysql jdbc driver and creates a new connection to the database
     *
     * @return a new connection
     */
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection(DBUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
