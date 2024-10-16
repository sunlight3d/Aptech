/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import validations.*;

//@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String className = request.getParameter("className");
        List<ValidationError> errors = new ArrayList<>();

        if (isEmpty(name)) {
            errors.add(new ValidationError("name", "Name is required"));
        }

        if (isEmpty(address)) {
            errors.add(new ValidationError("address", "Address is required"));
        }

        if (isEmpty(phone)) {
            errors.add(new ValidationError("phone", "Phone number is required"));
        }

        if (isEmpty(className)) {
            errors.add(new ValidationError("className", "Class name is required"));
        }

        if (!errors.isEmpty()) {
            // Nếu có lỗi, lưu danh sách lỗi vào request attribute
            request.setAttribute("errors", errors);

            // Forward đến trang JSP để hiển thị lỗi
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }  

        // Tạo cookie và lưu thông tin
        Cookie nameCookie = new Cookie("name", name);
        Cookie addressCookie = new Cookie("address", address);
        Cookie phoneCookie = new Cookie("phone", phone);
        Cookie classNameCookie = new Cookie("className", className);

        // Đặt thời gian tồn tại của cookie (ví dụ: 1 giờ)
        nameCookie.setMaxAge(3600);
        addressCookie.setMaxAge(3600);
        phoneCookie.setMaxAge(3600);
        classNameCookie.setMaxAge(3600);

        // Thêm các cookie vào response
        response.addCookie(nameCookie);
        response.addCookie(addressCookie);
        response.addCookie(phoneCookie);
        response.addCookie(classNameCookie);

        // Chuyển hướng đến trang welcome.jsp
        response.sendRedirect("welcome.jsp");
    }
    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

}

