/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNo = request.getParameter("phoneNo");
        String className = request.getParameter("className");

        if (name.isEmpty() || address.isEmpty() || phoneNo.isEmpty() || className.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required");
            request.getRequestDispatcher("studentRegister.jsp").forward(request, response);
            return;
        }

        // Lưu dữ liệu vào Cookie
        Cookie nameCookie = new Cookie("name", name);
        Cookie addressCookie = new Cookie("address", address);
        Cookie phoneNoCookie = new Cookie("phoneNo", phoneNo);
        Cookie classNameCookie = new Cookie("className", className);

        response.addCookie(nameCookie);
        response.addCookie(addressCookie);
        response.addCookie(phoneNoCookie);
        response.addCookie(classNameCookie);

        // Chuyển hướng đến trang hiển thị thông tin sinh viên
        response.sendRedirect("studentDisplay.jsp");
    }
}
