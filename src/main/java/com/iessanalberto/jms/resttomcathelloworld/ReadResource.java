package com.iessanalberto.jms.resttomcathelloworld;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


@Path("/read-json")
public class ReadResource {
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response readJson(@QueryParam("mensaje") String mensaje) {
        if (mensaje != null) {
            System.out.println(mensaje);
            return Response.ok("Mensaje recibido").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al leer el mensaje")
                    .build();
        }
    }
}