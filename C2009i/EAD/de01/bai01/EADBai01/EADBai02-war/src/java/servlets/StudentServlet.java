/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.StudentSessionLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Student;

public class StudentServlet extends HttpServlet {
    @EJB
    private StudentSessionLocal studentSessionBean; 
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {        
        super.doGet(request, response); 
        ArrayList<Student> students = studentSessionBean.findAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); 
        Student newStudent = new Student();
        newStudent.setStudentName(req.getParameter("fullName"));
        newStudent.setEmail(req.getParameter("email"));
        newStudent.setAge(Integer.valueOf(req.getParameter("age")));
        
        studentSessionBean.insertStudent(newStudent);
        request.setAttribute("newStudent", newStudent);
        request.getRequestDispatcher("addstudent.jsp").forward(request, response);
        
    }
    
}
