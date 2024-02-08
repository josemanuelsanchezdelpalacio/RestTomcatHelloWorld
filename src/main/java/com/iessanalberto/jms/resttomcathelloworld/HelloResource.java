package com.iessanalberto.jms.resttomcathelloworld;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    //objeto para convertir JSON a Java
    private ObjectMapper objectMapper = new ObjectMapper();

    //metodo para peticiones GET
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    //metodo para manejar peticiones POST
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarEnDatabase(String json) {
        try {
            // Convertir el JSON recibido en un objeto Java
            YourObject yourObject = objectMapper.readValue(json, EntityEntity.class); 
            database.save(yourObject);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error al procesar el JSON: " + e.getMessage()).build();
        }
    }
}
