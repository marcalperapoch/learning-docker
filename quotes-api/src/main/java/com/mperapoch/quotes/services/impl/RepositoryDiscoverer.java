package com.mperapoch.quotes.services.impl;

import com.mperapoch.quotes.services.Repository;
import com.mperapoch.quotes.services.ServiceDiscoverer;
import com.mperapoch.quotes.services.TimeOutKiller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by marcalperapochamado on 07/08/16.
 */
public class RepositoryDiscoverer implements ServiceDiscoverer {

    private static final Logger LOGGER = LogManager.getLogger(RepositoryDiscoverer.class);
    private final static int SLEEP_INCREMENT = 500;

    private final Repository repository;
    private final ScheduledExecutorService scheduler;

    private ScheduledFuture scheduledFuture;
    private AtomicBoolean timeOutReached;

    public RepositoryDiscoverer(Repository repository) {
        this.repository = repository;
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.timeOutReached = new AtomicBoolean(false);
    }

    @Override
    public boolean isRepositoryAvailable(long timeOut) {
        scheduledFuture = scheduler.schedule(new TimeOutKiller(this), timeOut, TimeUnit.MILLISECONDS);
        boolean isRepositoryAvailable = repository.isAvailable();
        int delay = 1;
        while(!timeOutReached.get() && !isRepositoryAvailable) {
            isRepositoryAvailable = repository.isAvailable();
            final long timeToWait = delay++ * SLEEP_INCREMENT;
            LOGGER.info(String.format("%s is going to sleep %d ms before trying again...", this.getClass().getSimpleName(), timeToWait));
            silentSleep(timeToWait);
        }
        closePendingTasks();
        return isRepositoryAvailable;
    }

    private void closePendingTasks() {
        if (scheduledFuture != null && !scheduledFuture.isCancelled() && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }
        scheduler.shutdown();
    }

    private void silentSleep(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {}
    }

    @Override
    public void notifyTimeOutReached() {
        timeOutReached.set(true);
    }

}
