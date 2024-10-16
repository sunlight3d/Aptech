/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentServlet extends HttpServlet {
 private static final Logger logger = Logger.getLogger(StudentServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         RequestDispatcher dispatcher = req.getRequestDispatcher("studentForm.jsp");
         dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String className = req.getParameter("className");
        
        if (name.isEmpty()) {
            req.setAttribute("nameError", "Please enter a name.");
        }
        if (address.isEmpty()) {
            req.setAttribute("addressError", "Please enter an address.");
        }
        if (phone.isEmpty()) {
            req.setAttribute("phoneError", "Please enter a phone number.");
        }
        if (className.isEmpty()) {
            req.setAttribute("classError", "Please enter a class name.");
        }
        if (!name.isEmpty() && !address.isEmpty() && !phone.isEmpty() && !className.isEmpty()) {
           
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
            
            Cookie nameCookie = new Cookie("name", name);
            Cookie addressCookie = new Cookie("address", address);
            Cookie phoneCookie = new Cookie("phone", phone);
            Cookie classCookie = new Cookie("className", className);

            // Set cookie expiration time (e.g., 24 hours)
            int cookieDuration = 24 * 60 * 60;
            nameCookie.setMaxAge(cookieDuration);
            addressCookie.setMaxAge(cookieDuration);
            phoneCookie.setMaxAge(cookieDuration);
            classCookie.setMaxAge(cookieDuration);

            resp.addCookie(nameCookie);
            resp.addCookie(addressCookie);
            resp.addCookie(phoneCookie);
            resp.addCookie(classCookie);
            
            logger.log(Level.INFO, name);
            logger.log(Level.INFO, address);
            logger.log(Level.INFO, phone);
            logger.log(Level.INFO, className);
            
            //RequestDispatcher dispatcher = req.getRequestDispatcher("studentDisplay.jsp");
            //dispatcher.forward(req, resp);
            resp.sendRedirect("studentDisplay.jsp");
        } else {
            //validate error
            RequestDispatcher dispatcher = req.getRequestDispatcher("studentForm.jsp");
            dispatcher.include(req, resp);
        }
    }
}

/*

*/