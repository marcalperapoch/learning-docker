package com.mperapoch.randomnames.store;

import com.mperapoch.randomnames.services.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public class MySqlDatabase implements Repository {

    private static final String CONNECTION_URL = "jdbc:mysql://%s/%s?user=%s&password=%s";
    private static final String HOST = "RN_DB_HOST";
    private static final String DATABASE = "RN_DB_NAME";
    private static final String USER = "RN_DB_USER";
    private static final String PASSWORD = "RN_DB_PASSWORD";
    private final String host;
    private final String database;
    private final String user;
    private final String password;

    public MySqlDatabase() {
        host = System.getenv(HOST);
        database = System.getenv(DATABASE);
        user = System.getenv(USER);
        password = System.getenv(PASSWORD);
    }


    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public List<String> loadNames(int max) {
        final List<String> names = new ArrayList<>();
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(String.format(CONNECTION_URL, host, database), user, password);
    }
}
