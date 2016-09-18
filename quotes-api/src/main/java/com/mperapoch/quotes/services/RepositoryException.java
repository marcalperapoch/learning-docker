package com.mperapoch.quotes.services;

/**
 * Created by marcalperapochamado on 18/09/16.
 */
public class RepositoryException extends Exception {

    public RepositoryException(String message, Exception cause) {
        super(message, cause);
    }

    public RepositoryException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
