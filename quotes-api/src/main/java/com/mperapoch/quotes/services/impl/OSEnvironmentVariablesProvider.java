package com.mperapoch.quotes.services.impl;

import com.mperapoch.quotes.services.EnvironmentVariablesProvider;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by marcal.perapoch on 30/11/16.
 */
public class OSEnvironmentVariablesProvider implements EnvironmentVariablesProvider {

    @Override
    public String get(String name, String defaultValue) {
        String value = System.getenv(name);
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value;
    }
}
