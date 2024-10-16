/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;


/**
 *
 * @author Nguyen Duc Hoang
 */
public class StudentServlet extends HttpServlet {      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data        
        try {                                
            String name = request.getParameter("name");                        
            String address = request.getParameter("address");
            String phoneNo = request.getParameter("phoneNo");
            String className = request.getParameter("className");
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            
            Cookie nameCookie = new Cookie("name", name);
            Cookie addressCookie = new Cookie("address", address);
            Cookie phoneNoCookie = new Cookie("phoneNo", phoneNo);
            Cookie classNameCookie = new Cookie("name", className);            

            // Add the cookie to the response
            response.addCookie(nameCookie);
            response.addCookie(addressCookie);
            response.addCookie(phoneNoCookie);
            response.addCookie(classNameCookie);

            // Redirect to a confirmation page or any other desired page
            response.sendRedirect("confirmation.jsp");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    

}
