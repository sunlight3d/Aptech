/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.models.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.*;  

public class CategoryServlet extends HttpServlet {
    
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("de08PU")
            .createEntityManager();  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");        
        List<Category> categories = 
                    (List<Category>)entityManager
                        .createNamedQuery("Category.findAll", Category.class)
                .getResultList();        
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("category.jsp").forward(request, response);                        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            out.println("<h1>GET Category Servlet<h1>");                
    }
}
