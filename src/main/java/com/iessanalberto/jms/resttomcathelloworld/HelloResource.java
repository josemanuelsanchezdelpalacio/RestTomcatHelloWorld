package com.iessanalberto.jms.resttomcathelloworld;

import jakarta.ws.rs.*;

@Path("/hello-world")
public class HelloResource {
    @GET
    public String hello() {
        return "Hello, World!";
    }

}

