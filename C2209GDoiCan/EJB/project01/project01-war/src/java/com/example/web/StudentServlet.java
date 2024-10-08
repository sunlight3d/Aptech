/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.web;

import com.example.ejb.CalculatorBeanLocal;
import com.example.ejb.Student;
import com.example.ejb.StudentSessionBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
    @EJB
    private StudentSessionBeanLocal studentSessionBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //call method
        List<Student> students = studentSessionBean.getAllStudents();
        // Gửi danh sách sinh viên xuống trang JSP
        req.setAttribute("students", students);
        
        // Chuyển tiếp request và response tới trang JSP để hiển thị
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
