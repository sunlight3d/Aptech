/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author w11
 */
public class InputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        String password = request.getParameter("password"); 
        String retypePassword = request.getParameter("retypePassword"); 
        error = password.equals(retypePassword) ? "" : "Password must be the same";
        request.setAttribute("error",error);
        request.getRequestDispatcher("input.jsp").forward(request, response);              
    }

}
