package com.mperapoch.quotes.services;

/**
 * Created by marcal.perapoch on 30/11/16.
 */
public interface EnvironmentVariablesProvider {

    String get(String name, String defaultValue);
}
