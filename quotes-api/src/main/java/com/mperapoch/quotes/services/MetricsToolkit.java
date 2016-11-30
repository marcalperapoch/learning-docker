package com.mperapoch.quotes.services;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.mperapoch.quotes.services.impl.OSEnvironmentVariablesProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by marcal.perapoch on 30/11/16.
 */
public class MetricsToolkit {

    private static final Logger LOG = LogManager.getLogger();
    private static final String DEFAULT_GRAPHITE_URL = "localhost";
    private static final String DEFAULT_GRAPHITE_PORT = "2003";
    private static final String APP_PACKAGE = "com.mperapoch.quotes";

    private final MetricRegistry metrics = new MetricRegistry();
    private final GraphiteReporter reporter;

    private static class MetricsToolkitHolder {
        public static MetricsToolkit metricsToolkit = new MetricsToolkit(new OSEnvironmentVariablesProvider());
    }

    private MetricsToolkit(EnvironmentVariablesProvider environmentVariablesProvider) {
        final String graphiteUrl = environmentVariablesProvider.get("GRAPHITE_URL", DEFAULT_GRAPHITE_URL);
        final String graphitePort = environmentVariablesProvider.get("GRAPHITE_PORT", DEFAULT_GRAPHITE_PORT);
        LOG.info(String.format("Setting up metrics at %s:%s", graphiteUrl, graphitePort));
        final Graphite graphite = new Graphite(new InetSocketAddress(graphiteUrl, Integer.valueOf(graphitePort)));
        reporter = GraphiteReporter.forRegistry(metrics)
                .prefixedWith(APP_PACKAGE)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(graphite);
    }

    public static MetricsToolkit getInstance() {
        return MetricsToolkitHolder.metricsToolkit;
    }

    public void start() {
        reporter.start(1, TimeUnit.SECONDS);
    }

    public Counter getCounter(String counterName) {
        return metrics.counter(counterName);
    }
}
