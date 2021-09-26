package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private final static String user = "postgres";
    private final static String password = "266";
    private final static String url = "jdbc:postgresql://localhost:5432/hotel";
    private final static String driver = "org.postgresql.driver";

    public static void DBConnection() {
        try {
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createTable() throws SQLException {
        String createTableSQL = "SELECT * FROM room;";

        Connection conn = null;
        Statement statement = null;

        try {
            conn = getConnection();
            statement = conn.createStatement();
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private static Connection getConnection() {
        Connection conn = null;
//        try {
//            Class.forName(driver);
//        } catch (Exception e) {
//            System.out.println("Where your driver?");
//            e.printStackTrace();
//        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}