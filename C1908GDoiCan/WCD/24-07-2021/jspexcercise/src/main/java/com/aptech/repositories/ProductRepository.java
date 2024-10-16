package com.aptech.repositories;
import javax.persistence.*;
import com.aptech.models.*;

import java.util.List;
import java.util.Optional;
public class ProductRepository {
	private EntityManager entityManager;
    public ProductRepository() {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jspexcercise");
    	this.entityManager = entityManagerFactory.createEntityManager();        
    }
    //Optional = can be null
    public Optional<Product> findById(Integer id) {
    	Product product = entityManager.find(Product.class, id);
        return (Optional<Product>) (product != null ? Optional.of(product) : Optional.empty()); //.Where(..).FirstOrDefault()
    }
    public List<Product> findAll() {
        return entityManager.createQuery("from Product").getResultList();
    }
    public Optional<Product> findByName(String name) {
        Product product = entityManager.createNamedQuery("Product.findByName", Product.class)
                .setParameter("name", name)
                .getSingleResult();
        return (Optional<Product>) (product != null ? Optional.of(product) : Optional.empty());
    }
    public Optional<Product> save(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return Optional.of(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
