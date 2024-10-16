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
import models.Student;
@Stateless
public class StudentSession implements StudentSessionLocal {
private EntityManagerFactory emf = 
                        Persistence
                        .createEntityManagerFactory("EADBai01-ejbPU"); 

    @Override
    public ArrayList<Student> findAll() {
        EntityManager em=emf.createEntityManager();  
        Query query = em.createNamedQuery("Students.findAll");
        List<Student> results = query.getResultList();
        return (ArrayList<Student>) results;
    }

    @Override
    public ArrayList<Student> searchStudentByName(String fullName) {        
        EntityManager em=emf.createEntityManager();  
        Query query = em.createNamedQuery("Students.findByStudentName");
        query.setParameter("fullName", fullName);                
        List<Student> results = query.getResultList();
        return (ArrayList<Student>) results;
    }

    @Override
    public void removeStudentById(int id) {
        EntityManager em=emf.createEntityManager();  
        Query query = em.createNamedQuery("Students.findByStudentName");
        Student student = (Student)query.setParameter("id", id).getSingleResult();                        
        em.getTransaction().begin();  
        em.remove(student);
        em.getTransaction().commit();
    }
    @Override
    public void insertStudent(Student newStudent) {
        EntityManager em=emf.createEntityManager();          
        em.getTransaction().begin();  
        em.remove(newStudent);
        em.getTransaction().commit();
    }
}
