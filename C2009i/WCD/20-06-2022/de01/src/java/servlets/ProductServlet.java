/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.*;  
import models.*;

/**
CREATE DATABASE de01;
USE de01;
CREATE TABLE tblProduct(
   id INT PRIMARY KEY AUTO_INCREMENT,
   productName VARCHAR(100) UNIQUE,
   price FLOAT DEFAULT 0.0,
   quantity INT
);
INSERT INTO tblProduct(productName, price, quantity) VALUES
('macbook m1', 1234, 3),
('dell laptop', 542, 3),
('iphoine 14', 223, 2);
 */
public class ProductServlet extends HttpServlet {    
    public EntityManager getEntityManager() {
        return Persistence
                .createEntityManagerFactory("de01PU")
                .createEntityManager();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");   
        EntityManager entityManager = getEntityManager();
        if(request.getParameter("id") != null) {
            Integer productId = Integer.valueOf(request.getParameter("id"));                                
            Product product = entityManager
                        .createNamedQuery("Product.findById", Product.class)  
                        .setParameter("id", productId)
                        .getSingleResult();        
            entityManager.getTransaction().begin();
            entityManager.remove(product);            
            entityManager.getTransaction().commit();            
        }
        String typedText = request.getParameter("typedText") == null ? 
                "":request.getParameter("typedText");                      
        entityManager = getEntityManager();
        List<Product> products = 
                    (List<Product>)entityManager
                        .createNamedQuery("Product.filterProduct", Product.class)
                            .setParameter("typedText", "%"+typedText+"%")
                .getResultList();        
        request.setAttribute("products",products);
        entityManager.close();
        request.getRequestDispatcher("productlist.jsp").forward(request, response);                        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.valueOf(request.getParameter("id"));
        String productName = request.getParameter("productName");        
        Float price = Float.valueOf(request.getParameter("price"));   
        Integer quantity = Integer.valueOf(request.getParameter("price"));   
                        
        EntityManager entityManager = getEntityManager();
        //update success
        entityManager.getTransaction().begin();
        Product product = new Product(productId, productName, price, quantity);
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        //redirect
        response.sendRedirect("ProductServlet");  
    }

}
