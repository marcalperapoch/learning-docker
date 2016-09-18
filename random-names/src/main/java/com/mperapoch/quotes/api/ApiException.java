package com.mperapoch.quotes.api;

/**
 * Created by marcalperapochamado on 18/09/16.
 */
public class ApiException extends RuntimeException {

    public ApiException(String cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
