/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface StudentSessionBeanLocal {
    public List<Student> getAllStudents();
    public Student findStudentById(int id);
    public void deleteStudent(int id);
    public void addStudent(Student student);
    public void updateStudent(Student student);
}
//http://localhost:8089/project01-war/CalculatorServlet