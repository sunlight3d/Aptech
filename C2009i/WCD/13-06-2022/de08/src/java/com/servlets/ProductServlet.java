/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.models.Category;
import com.models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductServlet extends HttpServlet {
    private EntityManager entityManager() {
        return Persistence
            .createEntityManagerFactory("de08PU")
            .createEntityManager();      
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter("actionName");        
        if(actionName == null) {
            this.showProducts(request, response);
        } else {
            if (actionName.equals("assignCategory")) {
                assignCategory(request, response);
            }
        }               
    }
    //like action result
    private void showProducts(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {        
        
        TypedQuery<Product> query = entityManager()
                        .createNamedQuery("Product.findAll", Product.class);
        List<Product> products = query.getResultList();
        
        request.setAttribute("products",products);
        request.getRequestDispatcher("productlist.jsp").forward(request, response);           
    }
    private void assignCategory(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.valueOf(request.getParameter("productId"));
        Product product = entityManager()
                        .createNamedQuery("Product.findById", Product.class)
                        .setParameter("id", productId)
                        .getSingleResult();
        request.setAttribute("product",product);
        
        List<Category> categories = 
                    (List<Category>)entityManager()
                        .createNamedQuery("Category.findAll", Category.class)
                .getResultList();
        
        request.setAttribute("product",product);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("assign.jsp").forward(request, response);                   
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.valueOf(request.getParameter("productId"));
        int categoryId = Integer.valueOf(request.getParameter("categoryId"));        
        EntityManager entityManager = this.entityManager();
        Product product = entityManager
                        .createNamedQuery("Product.findById", Product.class)  
                        .setParameter("id", productId)
                        .getSingleResult();        
        Category category = entityManager
                        .createNamedQuery("Category.findById", Category.class)                        
                        .setParameter("id", categoryId)
                        .getSingleResult();        
        //update success
        entityManager.getTransaction().begin();
        product.setCategory(category);        
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        //redirect
        response.sendRedirect("ProductServlet");  
    }
    
}
