package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import models.Product;
import models.Temp;

public class ProductServlet extends HttpServlet {
    private EntityManagerFactory emf 
            = Persistence.createEntityManagerFactory("baitap01PU");  // Tên Persistence Unit    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String httpMethod = request.getParameter("_method");
        if(httpMethod != null && httpMethod.equals("update")) {
            Integer id = Integer.valueOf(request.getParameter("id")); 
            Temp foundProduct = null;
            for(Temp product: this.products) {
                if(product.getId() == id) {
                    foundProduct = product;
                    break;
                }
            }
            if(foundProduct != null) {
                request.setAttribute("product", foundProduct);
                request.getRequestDispatcher("updateProduct.jsp").forward(request, response);  
            }            
        } else {
            request.setAttribute("products", products);
            request.getRequestDispatcher("products.jsp").forward(request, response);  
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         // Lấy dữ liệu từ form
        try {
            String name = request.getParameter("name");            
            String httpMethod = request.getParameter("_method");
            if(httpMethod.equals("delete")) {
                Integer id = Integer.valueOf(request.getParameter("id"));                  
                this.products.removeIf(p -> p.getId()==id);                
            } else if(httpMethod.equals("update")) {
                Integer id = Integer.valueOf(request.getParameter("id"));                                  
                String productName = request.getParameter("productName");
                float price = Float.parseFloat(request.getParameter("price"));
                float quantity = Float.parseFloat(request.getParameter("quantity"));
                String description = request.getParameter("description");

                // Find the product by id and update its details
                for (Temp product : products) {
                    if (product.getId() == id) {
                        product.setName(productName);
                        product.setPrice(price);
                        product.setQuantity(quantity);
                        product.setDescription(description);
                        break;
                    }
                }              
            } else {                                
                BigDecimal price = BigDecimal
                        .valueOf(Double.parseDouble(request.getParameter("price")));
                String description = request.getParameter("description");

                // Tạo đối tượng Temp mới từ dữ liệu form
                EntityManager em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                Product product = new Product();
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                em.persist(product);
                tx.commit();
            }
            
        }catch(Exception e) {
            System.err.println("Error when inserting data");
        } finally {
            // Chuyển hướng về trang danh sách sản phẩm sau khi thêm thành công
            response.sendRedirect("products");        
        }        
    }    
}
/*
CREATE TABLE products(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	price DECIMAL(10, 2) DEFAULT 0,
	description TEXT
);
INSERT INTO products (name, price, description) VALUES
('iPhone 15 Pro 128GB', 1234.50, 'Latest model with advanced features'),
('Samsung Galaxy S21 Ultra', 1099.99, 'High-end smartphone with excellent camera'),
('MacBook Pro 14-inch', 2499.00, 'Powerful laptop with M1 Pro chip'),
('Dell XPS 13', 899.99, 'Compact laptop with stunning display'),
('Sony WH-1000XM5', 299.99, 'Noise-cancelling over-ear headphones'),
('iPad Air 64GB', 599.99, 'Lightweight and powerful tablet'),
('Kindle Paperwhite', 129.99, 'E-reader with high-resolution display'),
('Logitech MX Master 3', 99.99, 'Ergonomic wireless mouse'),
('Amazon Echo Dot 4th Gen', 49.99, 'Smart speaker with Alexa'),
('Fitbit Charge 5', 179.99, 'Fitness tracker with heart rate monitor');

*/