package com.mperapoch.quotes.store;

import com.mperapoch.quotes.model.Quote;
import com.mperapoch.quotes.model.QuoteBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by marcalperapochamado on 18/09/16.
 */
public class QuotesDBUtils {

    private static final String ALL_COLUMNS = "quote_id, author, text, votes";
    public static final String SELECT_BY_ID = String.format("SELECT %s FROM quotes WHERE quote_id = ?", ALL_COLUMNS);
    public static final String SELECT_RANGE = String.format("SELECT %s FROM quotes WHERE quote_id > ? limit ?;", ALL_COLUMNS);

    public static Quote toQuote(final ResultSet resultSet) throws SQLException {
        QuoteBuilder quoteBuilder = new QuoteBuilder();
        quoteBuilder.quoteId(resultSet.getLong(1));
        quoteBuilder.author(resultSet.getString(2));
        quoteBuilder.text(resultSet.getString(3));
        quoteBuilder.votes(resultSet.getLong(4));
        return quoteBuilder.build();
    }
}
