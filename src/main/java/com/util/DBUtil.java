package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DBUtil {

    private static final String DBUrl;
    private static final String user;
    private final static String password;

    static {
        InputStream propInput = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();

        try {
            properties.load(propInput);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db details from");
        }

        String host = Objects.requireNonNull(properties.getProperty("host"));
        String db = Objects.requireNonNull(properties.getProperty("dbName"));
        user = Objects.requireNonNull(properties.getProperty("username"));
        password = Objects.requireNonNull(properties.getProperty("password"));
        DBUrl = "jdbc:mysql://" + host + "/" + db;
    }


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
