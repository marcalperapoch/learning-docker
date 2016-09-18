package com.mperapoch.quotes.domain;

import com.mperapoch.quotes.services.ServiceDiscoverer;

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
