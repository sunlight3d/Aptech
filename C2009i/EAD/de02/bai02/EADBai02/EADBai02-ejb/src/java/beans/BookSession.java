/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.Book;

/**
 *
 * @author w11
 */
@Stateless
public class BookSession implements BookSessionLocal {
private EntityManagerFactory emf = 
                        Persistence
                        .createEntityManagerFactory("EADBai02-ejbPU"); 

    @Override
    public ArrayList<Book> findAll() {
        EntityManager em=emf.createEntityManager();  
        Query query = em.createNamedQuery("Books.findAll");
        List<Book> results = query.getResultList();
        return (ArrayList<Book>) results;
    }

    @Override
    public ArrayList<Book> searchBookByName(String bookName) {        
        EntityManager em=emf.createEntityManager();  
        Query query = em.createNamedQuery("Books.findByBookName");
        query.setParameter("bookName", bookName);                
        List<Book> results = query.getResultList();
        return (ArrayList<Book>) results;
    }

    @Override
    public void removeBookById(int id) {
        EntityManager em=emf.createEntityManager();  
        Query query = em.createNamedQuery("Books.findByBookName");
        Book book = (Book)query.setParameter("id", id).getSingleResult();                        
        em.getTransaction().begin();  
        em.remove(book);
        em.getTransaction().commit();
    }
}
