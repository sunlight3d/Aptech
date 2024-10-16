/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question01;

import jakarta.ejb.Stateless;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class StudentBean {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    // Create a new student
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createStudent(Student student) {
        em.persist(student);
    }

    // Read a student by roll number
    public Student findStudent(Long rollNumber) {
        return em.find(Student.class, rollNumber);
    }

    // Update a student
     @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateStudent(Student student) {
        em.merge(student);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)    
    public void deleteStudent(Long rollNumber) {
        Student student = findStudent(rollNumber);
        if (student != null) {
            em.remove(student);
        }
    }

    // List all students
    public List<Student> listStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
}
