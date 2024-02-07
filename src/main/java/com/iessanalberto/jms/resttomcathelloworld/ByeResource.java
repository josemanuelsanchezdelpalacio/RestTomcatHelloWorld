package com.iessanalberto.jms.resttomcathelloworld;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/bye-world")
public class ByeResource {
    @GET
    //@Consumes("application/json")
    @Produces("application/json")
    public String bye() { return "{\"text\": \"Bye\"}"; }
}