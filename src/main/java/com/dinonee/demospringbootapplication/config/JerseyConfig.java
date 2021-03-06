package com.dinonee.demospringbootapplication.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Clase de configuracion
 * @author epaic
 */
@ApplicationPath("/api")
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        this.packages("com.dinonee.demospringbootapplication.controllers");
    }
}
