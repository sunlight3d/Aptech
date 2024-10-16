/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra username và password
        if (username.equals("nguyenvana") 
                && password.equals("nguyenvana")) {
            // Lưu thông tin vào session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);

            // Redirect sang trang index.jsp
            response.sendRedirect("index.jsp");
        } else {
            // Gửi thông báo lỗi
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('Thông tin đăng nhập không chính xác!');</script>");
            response.getWriter().println("<script>window.location.href='login.jsp';</script>");
        }
    }   
}
/*
CREATE DATABASE de01;
use de01;
CREATE TABLE products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name NVARCHAR(100) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  quantity INT DEFAULT 1 CHECK (quantity >= 0)
);
INSERT INTO products (name, price, quantity)
VALUES
    ('Product 1', 10.99, 1),
    ('Product 2', 19.99, 1),
    ('Product 3', 8.5, 1),
    ('Product 4', 14.75, 1),
    ('Product 5', 5.99, 1),
    ('Product 6', 12.99, 1),
    ('Product 7', 9.25, 1),
    ('Product 8', 17.5, 1),
    ('Product 9', 6.99, 1),
    ('Product 10', 11.99, 1),
    ('Product 11', 13.5, 1),
    ('Product 12', 7.99, 1),
    ('Product 13', 16.25, 1),
    ('Product 14', 4.99, 1),
    ('Product 15', 9.99, 1),
    ('Product 16', 15.5, 1),
    ('Product 17', 8.99, 1),
    ('Product 18', 12.25, 1),
    ('Product 19', 3.99, 1),
    ('Product 20', 10.5, 1);
*/
