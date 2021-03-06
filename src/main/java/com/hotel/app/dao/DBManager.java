package com.hotel.app.dao;

import java.sql.*;
import java.util.logging.Logger;

public class DBManager {
    private static final Logger log = Logger.getLogger(DBManager.class.getName());
    private final static String user = "postgres";
    private final static String password = "266";
    private final static String url = "jdbc:postgresql://localhost:5432/hotel";
    private final static int connectionCount= 5;

    private static DBManager instance;
    private static ConnectionPool connectionPool;

    private DBManager() {
        connectionPool = new ConnectionPool(url, user, password, connectionCount);
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connectionPool.retrieve();
    }

    public void commit(Connection connection) {
        try {
            connection.commit();
            connectionPool.putBack(connection);
        } catch (SQLException exception) {
            log.severe(exception.getMessage());
        }
    }

    public void rollback(Connection connection) {
        try {
            connection.rollback();
            connectionPool.putBack(connection);
        } catch (SQLException exception) {
            log.severe(exception.getMessage());
        }
    }
}