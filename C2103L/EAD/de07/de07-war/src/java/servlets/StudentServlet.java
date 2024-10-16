/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Student;
import services.StudentService;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    @EJB
    private StudentService studentService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gọi các phương thức của StudentService để thực hiện các thao tác CRUD
        // Lưu danh sách sinh viên vào request để hiển thị trong JSP
        List<Student> studentList = studentService.getAllStudents();
        request.setAttribute("studentList", studentList);

        // Chuyển hướng đến trang JSP để hiển thị danh sách sinh viên
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form trên trang JSP
        String rollnumber = request.getParameter("rollnumber");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        // Tạo đối tượng Student
        Student newStudent = new Student();
        newStudent.setRollnumber(rollnumber);
        newStudent.setName(name);
        newStudent.setEmail(email);
        newStudent.setAge(age);

        // Gọi phương thức thêm sinh viên từ StudentService
        studentService.createStudent(newStudent);

        // Sau khi thêm, chuyển hướng lại đến trang hiển thị danh sách sinh viên
        response.sendRedirect(request.getContextPath() + "/studentServlet");
    }

    // Các phương thức khác để xử lý thêm, xóa, cập nhật sinh viên
}
