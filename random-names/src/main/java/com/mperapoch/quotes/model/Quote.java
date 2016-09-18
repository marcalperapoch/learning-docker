package com.mperapoch.quotes.model;

/**
 * Created by marcalperapochamado on 18/09/16.
 */
public class Quote {

    private final long quoteId;
    private final String author;
    private final String text;
    private final long votes;

    public Quote(final QuoteBuilder quoteBuilder) {
        this.quoteId = quoteBuilder.getQuoteId();
        this.author = quoteBuilder.getAuthor();
        this.text = quoteBuilder.getText();
        this.votes = quoteBuilder.getVotes();
    }

    public long getQuoteId() {
        return quoteId;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public long getVotes() {
        return votes;
    }
}
