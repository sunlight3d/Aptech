/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/UserServlet")
class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy giá trị username và password từ yêu cầu POST
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra username và password
        if ("nguyenvana".equals(username) && "nguyenvana".equals(password)) {
            // Nếu đăng nhập thành công, chuyển hướng đến trang welcome.jsp
            response.sendRedirect("welcome.jsp");
        } else {
            // Nếu đăng nhập thất bại, gửi thông báo lỗi
            response.getWriter().println("Login failed. Please check your username and password.");
        }
    }
}
