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

import models.Category;
import com.mysql.cj.jdbc.Driver;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;


public class CategoryServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory 
            = Persistence.createEntityManagerFactory("myappPU");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();

            // Perform database operations using the EntityManager, e.g., fetching categories
            // For demonstration purposes, let's assume you have a Category entity
            List<Category> categories = entityManager.createNamedQuery("Category.findAll", Category.class)
                                                     .getResultList();

            // Set the categories as an attribute in the request
            request.setAttribute("categories", categories);

            RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
            dispatcher.forward(request, response);
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
/*
CREATE DATABASE c2206LDoiCan;
USE c2206LDoiCan;
CREATE TABLE categories (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    description TEXT
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    price DECIMAL(10,2) CHECK (price > 0),
    category_id VARCHAR(10),
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- Tạo dữ liệu cho bảng categories
INSERT INTO categories (id, name, description) VALUES 
('X111', 'Electronics', 'Electronics products'),
('X222', 'Clothing', 'Clothing products'),
('X333', 'Books', 'Books and literature'),
('X444', 'Home & Garden', 'Home and garden products'),
('X555', 'Beauty & Personal Care', 'Beauty and personal care products');

-- Tạo dữ liệu cho bảng products
INSERT INTO products (name, price, category_id, description) VALUES 
('Laptop', 999.99, 'X111', 'High-performance laptop'),
('Smartphone', 699.99, 'X111', 'Latest smartphone model'),
('T-shirt', 19.99, 'X333', 'Casual cotton T-shirt'),
('Jeans', 49.99, 'X333', 'Slim-fit denim jeans'),
('Python Crash Course', 29.99, 'X444', 'Bestselling Python book'),
('Gardening Tools Set', 39.99, 'X555', 'Complete set of gardening tools'),
('Shampoo', 9.99, 'X555', 'Moisturizing shampoo for all hair types');

*/