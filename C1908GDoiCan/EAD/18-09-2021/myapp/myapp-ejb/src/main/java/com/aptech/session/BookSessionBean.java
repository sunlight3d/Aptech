/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.session;

import com.aptech.entities.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sunli
 */
@Stateless
public class BookSessionBean implements BookSessionBeanLocal {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookWeb-ejbPU");
    @Override
    public List<Book> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Book.findAll", Book.class);
        return query.getResultList();        
    }

    @Override
    public void insert(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();        
    }

    @Override
    public void delete(String bookCode) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, bookCode);
        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();        
    }

    @Override
    public void update(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book foundBook = entityManager.find(Book.class, book.getBookcode());
        entityManager.getTransaction().begin();
        foundBook.setNickname(book.getNickname());
        foundBook.setName(book.getName());
        foundBook.setProducer(book.getProducer());
        foundBook.setPrice(book.getPrice());
        entityManager.getTransaction().commit();        
    }    
}
