/*
 
 */
package beans;

import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Student;

@Stateless
public class StudentBean implements StudentBeanLocal {
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("De07-ejbPU")
                .createEntityManager();            
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")        

    @Override
    public void insert(Integer rollnumber, String name, String email) {
        try {
            entityManager.getTransaction().begin();        
            Student student = new Student(rollnumber, name, email);
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(Exception e) {
            System.err.println("Cannot insert student, error: "+e.getMessage());
        }
    }
    @Override
    public void delete(String rollNumber){    
       Student employee = entityManager
                            .createNamedQuery("Student.findByRollNo", Student.class)  
                            .setParameter("rollNumber", rollNumber)
                            .getSingleResult();        
                entityManager.getTransaction().begin();
                entityManager.remove(employee);            
                entityManager.getTransaction().commit();                  
    }
    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> students = 
                        (ArrayList<Student>)entityManager
                            .createNamedQuery("Student.findAll", Student.class)                            
                            .getResultList();
        return students;
    }
}
