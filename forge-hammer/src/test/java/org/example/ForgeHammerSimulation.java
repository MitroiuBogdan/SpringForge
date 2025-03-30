package org.example;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ForgeHammerSimulation extends Simulation {

    // Define the HTTP protocol configuration
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080") // Adjust to your application's base URL
            .acceptHeader("application/json");

    // Define the scenario
    ScenarioBuilder scn = scenario("DummyEndpointSimulation")
            .exec(
                    http("GET Dummy Response")
                            .get("/dummy-response")
                            .check(status().is(200))
            );

    {
        // Set up the simulation to achieve 1,500 RPS for 1 minute
        setUp(
                scn.injectOpen(
                        constantUsersPerSec(500).during(Duration.ofMinutes(1))
                )
        ).protocols(httpProtocol);
    }
}
