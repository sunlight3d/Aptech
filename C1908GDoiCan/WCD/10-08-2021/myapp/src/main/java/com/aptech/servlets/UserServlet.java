/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");        
        
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html"); 
        if(!password.equals(retypePassword)) {
            out.println("<h1>Password and retype password are not the same</h1>");
        } else {
            response.addCookie(new Cookie("firstName", firstName));
            response.addCookie(new Cookie("lastName", lastName));
            response.addCookie(new Cookie("password", password));                        
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
            requestDispatcher.forward(request, response);
        }                 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }    

}
