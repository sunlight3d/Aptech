/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

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
        // Check if username and password match
        if(username.equals("nguyenvana") && password.equals("123456")) {
            // Save username to session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to index.jsp
            response.sendRedirect("index.jsp");
        } else {
            // If username and password don't match, redirect back to login page
            response.sendRedirect("login.jsp");
        }
    }

}
