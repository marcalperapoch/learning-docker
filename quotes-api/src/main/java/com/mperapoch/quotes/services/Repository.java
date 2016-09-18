package com.mperapoch.quotes.services;

import com.mperapoch.quotes.model.Quote;

import java.util.Set;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public interface Repository {

    boolean isAvailable();

    Quote loadQuote(long quoteId) throws RepositoryException;

    Set<Quote> loadQuotes(long offset, int limit) throws RepositoryException;
}
