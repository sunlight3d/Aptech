/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import models.Student;

/**
 *
 * @author w11
 */
@Local
public interface StudentBeanLocal {
    public void insert(Integer rollnumber, String name, String email);
    public ArrayList<Student> findAll();
    public void delete(String rollNumber);
}

