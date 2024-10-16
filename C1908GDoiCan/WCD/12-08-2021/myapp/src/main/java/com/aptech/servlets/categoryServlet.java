/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.servlets;

import com.aptech.Database;
import com.aptech.models.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class categoryServlet extends HttpServlet {    
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    } 
    */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selectedCategoryName = request.getParameter("categories");
        int productId = Integer.valueOf(request.getParameter("productId"));
        
        Category category = Database.GetInstance().getCategoryFromName(selectedCategoryName);        
        Database.GetInstance().updateProduct(productId, category.getId());
        request.getRequestDispatcher("productlist.jsp").forward(request, response);
    }
}
