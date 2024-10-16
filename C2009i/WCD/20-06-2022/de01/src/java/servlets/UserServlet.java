/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author w11
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String username = request.getParameter("username"); 
            String password = request.getParameter("password"); 
            String error = "";
            HttpSession session = request.getSession();
            if(username.equals("hoangnv") && password.equals("123456")) {
                session.setAttribute("username",username); 
                request.setAttribute("error",error);
                request.getRequestDispatcher("index.jsp").forward(request, response);  
            } else {
                error = "Wrong username and password";
                request.setAttribute("error",error);
                request.getRequestDispatcher("login.jsp").forward(request, response);  
            }                        
    }

}
