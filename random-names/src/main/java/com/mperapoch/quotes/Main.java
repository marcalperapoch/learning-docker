package com.mperapoch.quotes;

import com.mperapoch.quotes.api.QuotesResource;
import com.mperapoch.quotes.domain.RepositoryDiscoverer;
import com.mperapoch.quotes.services.Repository;
import com.mperapoch.quotes.services.ServiceDiscoverer;
import com.mperapoch.quotes.store.MySqlDatabase;
import net.codestory.http.WebServer;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by marcal.perapoch on 08/07/16.
 */
public class Main {

    private static final String WAITING_ENV_TIME = "QUOTES_WAITING_TIME";
    private static final long MAX_WAITING_TIME = 10000L;

    public static void main(String[] args) {
        final Repository repository = new MySqlDatabase();
        final ServiceDiscoverer serviceDiscoverer = new RepositoryDiscoverer(repository);
        if (serviceDiscoverer.isRepositoryAvailable(getMaxWaitingTime())) {
            new WebServer().configure(routes -> routes
                    .get("/", "Quotes API")
                    .add("quotes", new QuotesResource(repository))
            ).start();
        } else {
            System.err.println("Unable to connect to repository service at: ");
        }
    }

    public static long getMaxWaitingTime() {
        final String waitingEnvTime = System.getenv(WAITING_ENV_TIME);
        if (StringUtils.isBlank(waitingEnvTime)) {
            return MAX_WAITING_TIME;
        } else {
            return Long.valueOf(waitingEnvTime);
        }
    }
}
