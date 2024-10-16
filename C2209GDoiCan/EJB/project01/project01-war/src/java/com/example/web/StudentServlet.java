/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.web;
//http://localhost:8089/project01-war/CalculatorServlet

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
        String action = req.getParameter("action");
        action = action == null ? "list" : action;
        

        switch (action) {
            case "edit":
                showEditForm(req, resp);
                break;            
            case "add":
                showAddForm(req, resp);
                break;
            case "list":
            default:
                listStudents(req, resp);
                break;
        }                
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "create";  // Mặc định là thêm sinh viên
        }

        switch (action) {
            case "update":
                updateStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "create":
            default:
                createStudent(req, resp);
                break;
        }
    }
    // Hiển thị form thêm sinh viên
    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add-student.jsp").forward(req, resp);
    }
    // Hiển thị form chỉnh sửa thông tin sinh viên
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student existingStudent = studentSessionBean.findStudentById(id);
        req.setAttribute("student", existingStudent);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
    // Hiển thị danh sách sinh viên
    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //call method
        List<Student> students = studentSessionBean.getAllStudents();
        // Gửi danh sách sinh viên xuống trang JSP
        req.setAttribute("students", students);
        
        // Chuyển tiếp request và response tới trang JSP để hiển thị
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }

    // Cập nhật thông tin sinh viên
    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        Student student = new Student(id, name, age, email);
        studentSessionBean.updateStudent(student);

        resp.sendRedirect("StudentServlet?action=list");
    }
    // Tạo sinh viên mới
    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setEmail(email);
        studentSessionBean.addStudent(student);  // Thêm sinh viên vào cơ sở dữ liệu

        // Quay lại danh sách sinh viên sau khi thêm
        resp.sendRedirect("StudentServlet?action=list");
    }

    // Xoá sinh viên
    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentSessionBean.deleteStudent(id);
        resp.sendRedirect("StudentServlet?action=list");
    }

}
