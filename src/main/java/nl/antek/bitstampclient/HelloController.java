package nl.antek.bitstampclient;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    public String sayHello() {
        log.info("Hello good morning");
        return "Hello World";
    }
}
