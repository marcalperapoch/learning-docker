package com.mperapoch.quotes.services;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public interface ServiceDiscoverer {

    boolean isRepositoryAvailable(long timeOut);

    void notifyTimeOutReached();
}
