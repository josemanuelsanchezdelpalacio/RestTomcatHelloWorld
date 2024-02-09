package com.iessanalberto.jms.resttomcathelloworld;

import jakarta.ws.rs.*;


@Path("/read-json")
public class ReadResource {

    @GET
    //@Consumes("application/json")
    @Produces("application/json")
    public String readJson(String json){
        return json;
    }

}