package servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.Product;
import providers.EntityManagerFactoryProvider;


public class ProductServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory; 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String searchText = request.getParameter("searchText");
    List<Product> products = new ArrayList<>();

    EntityManager entityManager = null;
    try {
        entityManager = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();

        if (searchText == null || searchText.isEmpty()) {
            // If no search text is provided, retrieve all products from the database
            products = entityManager.createQuery("SELECT p FROM Product p", Product.class)
                                    .getResultList();
        } else {
            // If search text is provided, perform a search based on the text (e.g., product name)
            products = entityManager.createQuery("SELECT p FROM Product p WHERE p.name LIKE :searchText", Product.class)
                                    .setParameter("searchText", "%" + searchText + "%")
                                    .getResultList();
        }
    } catch (Exception e) {
        // Handle exceptions
        e.printStackTrace();
    } finally {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    // Set the list of products as an attribute in the request
    request.setAttribute("products", products);
    // Forward the request to a JSP page to display the products
    RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");
    dispatcher.forward(request, response);
}
        
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         // Retrieve product information from request parameters
          String action = request.getParameter("action");

        if ("insert".equals(action)) {
            // Insert action
            insertProduct(request, response);
        } else if ("delete".equals(action)) {
            // Delete action
            deleteProduct(request, response);
        } else {
            // Invalid action or no action specified
            // Handle error or redirect to an appropriate page
            response.sendRedirect("error.jsp");
        }         
     }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String productId = request.getParameter("productId");

    EntityManager entityManager = null;
    try {
        // Get EntityManager instance
        entityManager = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
        
        // Begin transaction
        entityManager.getTransaction().begin();

        // Find the product entity by ID
        Product product = entityManager.find(Product.class, Integer.valueOf(productId));

        // If the product exists, delete it from the database
        if (product != null) {
            entityManager.remove(product);
        }

        // Commit transaction
        entityManager.getTransaction().commit();
        doGet(request, response);
    } catch (Exception e) {
        // Handle exceptions
        e.printStackTrace();
        // Redirect to an error page or display an error message
        //response.sendRedirect("error.jsp");
    } finally {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
    }
    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.valueOf(request.getParameter("productId"));
         String productName = request.getParameter("productName");

         BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
         int quantity = Integer.parseInt(request.getParameter("quantity"));

         // Create a new Product entity object
         Product product = new Product();
         product.setId(id);
         product.setName(productName);
         product.setPrice(price);
         product.setQuantity(quantity);

         EntityManager entityManager = null;
         try {
             // Get EntityManager instance
             entityManager = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();

             // Begin transaction
             entityManager.getTransaction().begin();

             // Persist the product entity object to the database
             entityManager.persist(product);

             // Commit transaction
             entityManager.getTransaction().commit();

             doGet(request, response);
         } catch (Exception e) {
             // Handle exceptions
             e.printStackTrace();
             // Redirect to an error page or display an error message
             //response.sendRedirect("error.jsp");
         } finally {
             if (entityManager != null && entityManager.isOpen()) {
                 entityManager.close();
             }
         }
    } 

}

/*
-- Create the products table
CREATE TABLE tbl_product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    quantity INT NOT NULL CHECK (quantity >= 0)
);

-- Insert fake product data
INSERT INTO tbl_product (name, price, quantity) VALUES
('Product 1', 10.99, 100),
('Product 2', 20.49, 50),
('Product 3', 15.75, 75),
('Product 4', 5.99, 200),
('Product 5', 30.25, 30),
('Product 6', 8.50, 150),
('Product 7', 12.99, 80),
('Product 8', 25.00, 60),
('Product 9', 18.99, 90),
('Product 10', 22.75, 120);

*/