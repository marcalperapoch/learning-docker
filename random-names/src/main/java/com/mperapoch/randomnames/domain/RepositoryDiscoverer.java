package com.mperapoch.randomnames.domain;

import com.mperapoch.randomnames.services.Repository;
import com.mperapoch.randomnames.services.ServiceDiscoverer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public class RepositoryDiscoverer implements ServiceDiscoverer {

    private final Repository repository;
    private final ScheduledExecutorService scheduler;

    public RepositoryDiscoverer(Repository repository) {
        this.repository = repository;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void execute(long timeOut) {

    }

    @Override
    public void notifyTimeOutReached() {

    }

}
