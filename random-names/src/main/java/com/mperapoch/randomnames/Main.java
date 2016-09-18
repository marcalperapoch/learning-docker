package com.mperapoch.randomnames;

import com.mperapoch.randomnames.api.RandomNamesResource;
import net.codestory.http.WebServer;

/**
 * Created by marcal.perapoch on 08/07/16.
 */
public class Main {

    public static void main(String[] args) {
        new WebServer().configure(routes -> routes
                .get("/", "Random Names API")
                .get("/hello/:who", (context, who) -> "Hello " + who)
                .add("random_names", new RandomNamesResource())
        ).start();
    }
}
