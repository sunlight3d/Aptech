/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangnd
 */
public class UserServlet extends HttpServlet {
    // Tạo một HashMap để lưu trữ các thông báo lỗi
    Map<String, String> errors = new HashMap<>();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Lấy thông tin từ request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");        

        // Kiểm tra các điều kiện validation và thêm thông báo lỗi vào HashMap nếu có lỗi
        if (firstName.isEmpty()) {
            errors.put("firstNameError", "First Name is required.");
        }

        if (lastName.isEmpty()) {
            errors.put("lastNameError", "Last Name is required.");
        }

        if (email.isEmpty()) {
            errors.put("emailError", "Email is required.");
        }

        if (password.length() < 11) {
            errors.put("passwordError", "Password must be at least 11 characters long.");
        }

        if (!password.equals(confirmPassword)) {
            errors.put("confirmPasswordError", "Passwords do not match.");
        }

        if (!errors.isEmpty()) {
            // Nếu có lỗi, chuyển HashMap chứa thông báo lỗi đến trang JSP để hiển thị
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } 
        
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

}
