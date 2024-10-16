/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jakarta.servlet.*;
import models.Category;
import com.mysql.cj.jdbc.Driver;


import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Category;
import models.Product;

public class ProductServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory 
            = Persistence.createEntityManagerFactory("myappPU");
    
    @Override
    //get products by category_id
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        EntityManager entityManager = null;
        String type = request.getParameter("type");            
        //assign, findAll
        try {
            if(type.equals("assign")) {                
                Integer productId = Integer.valueOf(request.getParameter("product_id")); 
                // Get detail product by id
                Product product = getProductById(productId);
                // Get all categories
                List<Category> categories = getAllCategories();

                RequestDispatcher dispatcher = request.getRequestDispatcher("assign.jsp");
                request.setAttribute("product", product);
                request.setAttribute("categories", categories);                        
                dispatcher.forward(request, response);
            } else if(type.equals("findAll")) {
                String categoryId = request.getParameter("category_id");            
                entityManager = entityManagerFactory.createEntityManager();
                TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.categoryId.id = :categoryId", Product.class);
                query.setParameter("categoryId", categoryId); // Assuming categoryId is of type Long
                List<Product> products = query.getResultList();
                // Set the products as an attribute in the request
                request.setAttribute("products", products);

                RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
                dispatcher.forward(request, response);
            }
            
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace(); // This is just for demonstration, you should handle exceptions appropriately
        } finally {
            // Ensure that the EntityManager is closed to release resources
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    private Product getProductById(int productId) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.find(Product.class, productId);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    public List<Category> getAllCategories() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
            return query.getResultList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      EntityManager entityManager = null;
      try {
        // Retrieve selected category ID and productId from the form
        String categoryId = request.getParameter("category");
        String productId = request.getParameter("productId");
        entityManager = entityManagerFactory.createEntityManager();
        Category category = entityManager.find(Category.class, Long.parseLong(categoryId));
        entityManager.getTransaction().begin();

        // Find the product with the given productId
        Product product = entityManager.find(Product.class, Long.parseLong(productId));
        product.setCategoryId( category);                
        entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Rollback the transaction if an exception occurs
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            // Handle any exceptions
            e.printStackTrace(); // This is just for demonstration, you should handle exceptions appropriately
        } finally {
            // Close the EntityManager
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
