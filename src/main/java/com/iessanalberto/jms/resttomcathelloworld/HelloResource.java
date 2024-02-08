package com.iessanalberto.jms.resttomcathelloworld;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    // Objeto para convertir JSON a Java
    private ObjectMapper objectMapper = new ObjectMapper();
    // Unidad de persistencia
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveToDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            File jsonFile = new File("src/main/resources/insertEntity.json");
            List<EntityEntity> entityEntities = objectMapper.readValue(jsonFile, new TypeReference<List<EntityEntity>>() {});
            for (EntityEntity entity : entityEntities) {
                entityManager.persist(entity);
            }
            transaction.commit();
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return Response.status(Response.Status.BAD_REQUEST).entity("Error al procesar el JSON: " + e.getMessage()).build();
        } finally {
            entityManager.close(); // Cerrar EntityManager
        }
    }
}
