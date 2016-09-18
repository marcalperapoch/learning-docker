package com.mperapoch.randomnames.domain;

import com.mperapoch.randomnames.services.ServiceDiscoverer;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public class TimeOutKiller implements Runnable {

    final ServiceDiscoverer serviceDiscoverer;

    public TimeOutKiller(ServiceDiscoverer serviceDiscoverer) {
        this.serviceDiscoverer = serviceDiscoverer;
    }

    @Override
    public void run() {
        serviceDiscoverer.notifyTimeOutReached();
    }
}
