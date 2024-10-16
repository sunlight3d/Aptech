/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/login"})
@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("nguyenvana") && password.equals("123456")) {
            // Lưu username vào session
            request.getSession().setAttribute("username", username);
            // Chuyển hướng đến trang index.jsp
            response.sendRedirect("index.jsp");
        } else {
             // Gửi thông báo lỗi cho trang đăng nhập
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);;
        }
    }    
}
