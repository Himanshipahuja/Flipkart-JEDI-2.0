package com.flipkart.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.rest.*;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<Configuration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new HelloRestController());
        e.jersey().register(new GymOwnerFlipFitController());
        // e.jersey().register(new AdminGMSRESTService());
        //  e.jersey().register(new GymOwnerGMSRESTService());
        //e.jersey().register(new UserGMSRESTService());
        //  e.jersey().register(new CustomerGMSRESTService());
//        e.jersey().register(new EmployeeRESTController(e.getValidator()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}