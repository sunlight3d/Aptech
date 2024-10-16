/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
http://localhost:8089/project01-war/StudentServlet
 * @author nguye
 */
@Stateless
public class StudentSessionBean implements StudentSessionBeanLocal {
    @PersistenceContext(unitName = "project01-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    public void deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            em.remove(student);
        }
    }

    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }
    @Override
    public void updateStudent(Student student) {
        // Cập nhật thông tin sinh viên trong cơ sở dữ liệu
        Student existingStudent = findStudentById(student.getId());
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setEmail(student.getEmail());
            em.merge(existingStudent);
        }
    }

}
//http://localhost:8089/project01-war/CalculatorServlet