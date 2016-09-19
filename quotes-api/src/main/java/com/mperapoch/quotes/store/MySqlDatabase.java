package com.mperapoch.quotes.store;

import com.mperapoch.quotes.model.Quote;
import com.mperapoch.quotes.services.Repository;
import com.mperapoch.quotes.services.RepositoryException;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public class MySqlDatabase implements Repository {

    private static final String CONNECTION_URL = "jdbc:mysql://%s/%s?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String HOST = "QUOTES_DB_HOST";
    private static final String DATABASE = "QUOTES_DB_NAME";
    private static final String USER = "QUOTES_DB_USER";
    private static final String PASSWORD = "QUOTES_DB_PASSWORD";
    private final String host;
    private final String database;
    private final String user;
    private final String password;
    private final String connectionUrl;

    public MySqlDatabase() {
        host = System.getenv(HOST);
        database = System.getenv(DATABASE);
        user = System.getenv(USER);
        password = System.getenv(PASSWORD);
        connectionUrl = String.format(CONNECTION_URL, host, database);
    }


    @Override
    public boolean isAvailable() {
        try {
            return getConnection().isValid(0);
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Quote loadQuote(long quoteId) throws RepositoryException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QuotesDBUtils.SELECT_BY_ID)) {
                preparedStatement.setLong(1, quoteId);
                final ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return QuotesDBUtils.toQuote(resultSet);
                }
                throw new RepositoryException(String.format("No quote exists with id %d", quoteId));
            }
        } catch (SQLException e) {
            throw new RepositoryException(String.format("Unable to load quote with id %d", quoteId), e);
        }
    }

    @Override
    public Set<Quote> loadQuotes(long offset, int limit) throws RepositoryException {
        final Set<Quote> quotes = new HashSet<>();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(QuotesDBUtils.SELECT_RANGE)) {
                preparedStatement.setLong(1, offset);
                preparedStatement.setInt(2, limit);
                final ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    quotes.add(QuotesDBUtils.toQuote(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quotes;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, user, password);
    }

    @Override
    public String toString() {
        return connectionUrl;
    }
}
