package com.mperapoch.randomnames.services;

import java.util.List;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public interface Repository {

    boolean isAvailable();

    List<String> loadNames(int max);
}
