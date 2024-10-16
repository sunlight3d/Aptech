/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import javax.ejb.Local;
import models.Student;

/**
 *
 * @author w11
 */
@Local
public interface StudentSessionLocal {
    ArrayList<Student> findAll();
    ArrayList<Student> searchStudentByName(String fullName);
    void insertStudent(Student newStudent); 
    void removeStudentById(int id);
}
