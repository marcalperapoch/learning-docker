package com.mperapoch.randomnames.services;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public interface ServiceDiscoverer {

    void execute(long timeOut);

    void notifyTimeOutReached();
}
