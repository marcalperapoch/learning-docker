package com.mperapoch.quotes.model;

/**
 * Created by marcalperapochamado on 18/09/16.
 */
public class QuoteBuilder {

    private long quoteId;
    private String author;
    private String text;
    private long votes;

    public QuoteBuilder() {
    }

    public long getQuoteId() {
        return quoteId;
    }

    public QuoteBuilder quoteId(long quoteId) {
        this.quoteId = quoteId;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public QuoteBuilder author(String author) {
        this.author = author;
        return this;
    }

    public String getText() {
        return text;
    }

    public QuoteBuilder text(String text) {
        this.text = text;
        return this;
    }

    public long getVotes() {
        return votes;
    }

    public QuoteBuilder votes(long votes) {
        this.votes = votes;
        return this;
    }

    public Quote build() {
        return new Quote(this);
    }
}
