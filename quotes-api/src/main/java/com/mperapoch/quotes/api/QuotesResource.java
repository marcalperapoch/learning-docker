package com.mperapoch.quotes.api;

import com.mperapoch.quotes.model.Quote;
import com.mperapoch.quotes.services.Repository;
import com.mperapoch.quotes.services.RepositoryException;
import net.codestory.http.annotations.Get;

import java.util.*;

/**
 * Created by marcal.perapoch on 08/07/16.
 */
public class QuotesResource {

    private final Repository repository;

    public QuotesResource(Repository repository) {
        this.repository = repository;
    }

    @Get("/:quoteId")
    public Quote getQuoteById(long quoteId) {
        try {
            return repository.loadQuote(quoteId);
        } catch (RepositoryException e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Get("/?offset=:offset&limit=:limit")
    public Set<Quote> getQuotes(int offset, int limit) {
        try {
            return repository.loadQuotes(offset, limit);
        } catch (RepositoryException e) {
            throw new ApiException(e.getMessage());
        }
    }
}
