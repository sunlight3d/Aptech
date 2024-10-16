/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dtos.requests.StudentRegistrationRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import lombok.*;
public class UserServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("haha");
        //post here        
        StudentRegistrationRequest registrationDTO = StudentRegistrationRequest
                .builder()
                .name(request.getParameter("name"))                
                .className(request.getParameter("className"))
                .address(request.getParameter("address"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .build();
        if (!registrationDTO.isValid()) {
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        } else {
            // Store data in cookies
            Cookie nameCookie = new Cookie("name", registrationDTO.getName());
            Cookie classCookie = new Cookie("className", registrationDTO.getClassName());
            Cookie addressCookie = new Cookie("address", registrationDTO.getAddress());
            Cookie phoneCookie = new Cookie("phoneNumber", registrationDTO.getPhoneNumber());

            // Setting a max age to cookies (e.g., 24 hours)
            int maxAge = 24 * 60 * 60;
            nameCookie.setMaxAge(maxAge);
            classCookie.setMaxAge(maxAge);
            addressCookie.setMaxAge(maxAge);
            phoneCookie.setMaxAge(maxAge);

            // Add cookies to response
            response.addCookie(nameCookie);
            response.addCookie(classCookie);
            response.addCookie(addressCookie);
            response.addCookie(phoneCookie);
            
            request.getRequestDispatcher("/home.jsp").forward(request, response);
            return;            
        }

    }       
}
