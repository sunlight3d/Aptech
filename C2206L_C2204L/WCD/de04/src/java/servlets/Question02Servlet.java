/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nguyen Duc Hoang
 */
public class Question02Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin ngôn ngữ từ request (ví dụ: từ parameter hoặc session)
        String language = request.getParameter("lang");

        // Xác định ngôn ngữ mặc định nếu không có ngôn ngữ được chỉ định
        if (language == null) {
            language = "en"; // Tiếng Anh là ngôn ngữ mặc định
        }

        // Đặt ngôn ngữ hiện tại cho ResourceBundle
        Locale locale = new Locale(language);        
        request.setAttribute("male", ResourceBundle.getBundle("male", locale));
        request.setAttribute("female", ResourceBundle.getBundle("female", locale));

        // Forward đến trang JSP
        request.getRequestDispatcher("question02.jsp").forward(request, response);
    }

}
