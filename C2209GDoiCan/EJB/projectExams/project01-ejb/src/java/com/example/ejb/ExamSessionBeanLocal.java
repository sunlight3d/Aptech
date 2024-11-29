/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.ejb;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ExamSessionBeanLocal {
    // CRUD Methods
    List<Exam> getAllExams();
    Exam findExamById(int id);
    void addExam(Exam exam);
    void updateExam(Exam exam);
    void deleteExam(int id);

    // New Method: Save Exam to JMS Topic
    void saveExam(String name, int duration, String description);
}

//http://localhost:8089/project01-war/CalculatorServlet