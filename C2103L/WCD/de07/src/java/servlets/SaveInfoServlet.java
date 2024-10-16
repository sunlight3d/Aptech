/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String className = request.getParameter("className");
        
        // Create cookies
        Cookie nameCookie = new Cookie("name", name);
        Cookie addressCookie = new Cookie("address", address);
        Cookie phoneCookie = new Cookie("phone", phone);
        Cookie classNameCookie = new Cookie("className", className);
        
        // Set cookie path and max age
        nameCookie.setPath("/");
        addressCookie.setPath("/");
        phoneCookie.setPath("/");
        classNameCookie.setPath("/");
        int expiredTime = 60 * 60 * 24;
        nameCookie.setMaxAge(expiredTime); // 1 day
        addressCookie.setMaxAge(expiredTime);
        phoneCookie.setMaxAge(expiredTime);
        classNameCookie.setMaxAge(expiredTime);
        
        // Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(addressCookie);
        response.addCookie(phoneCookie);
        response.addCookie(classNameCookie);
        
        // Redirect to display_info.jsp
        response.sendRedirect("display_info.jsp");
    }
}
