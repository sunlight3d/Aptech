/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package services;

import models.Computer;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import models.*;

@Path("/computer")
@WebService
public class ComputerService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("computerPU");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @WebMethod
    public Computer getComputer(@PathParam("id") int id) {
        return entityManager.find(Computer.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @WebMethod
    public List<Computer> getAllComputers() {
        return entityManager.createQuery("SELECT c FROM Computer c", Computer.class).getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @WebMethod
    public void addComputer(Computer computer) {
        entityManager.getTransaction().begin();
        entityManager.persist(computer);
        entityManager.getTransaction().commit();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @WebMethod
    public void updateComputer(@PathParam("id") int id, Computer updatedComputer) {
        entityManager.getTransaction().begin();
        Computer computer = entityManager.find(Computer.class, id);
        if (computer != null) {
            computer.setName(updatedComputer.getName());
            computer.setPrice(updatedComputer.getPrice());
            computer.setManufacture(updatedComputer.getManufacture());
            entityManager.merge(computer);
        }
        entityManager.getTransaction().commit();
    }

    @DELETE
    @Path("/{id}")
    @WebMethod
    public void deleteComputer(@PathParam("id") int id) {
        entityManager.getTransaction().begin();
        Computer computer = entityManager.find(Computer.class, id);
        if (computer != null) {
            entityManager.remove(computer);
        }
        entityManager.getTransaction().commit();
    }
}
