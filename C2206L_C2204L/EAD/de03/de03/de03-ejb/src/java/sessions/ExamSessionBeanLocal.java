/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package sessions;

import jakarta.ejb.Local;
import java.util.List;
import models.Exam;

/**
 *
 * @author hoangnd
 */
@Local
public interface ExamSessionBeanLocal {
    List<Exam> findAllExams();
    public void saveExam(String name, int duration, String description);
}
