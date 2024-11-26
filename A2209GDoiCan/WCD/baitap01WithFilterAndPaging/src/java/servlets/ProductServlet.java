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
//import com.mysql.cj.jdbc.Driver;

public class ProductServlet extends HttpServlet {
    private EntityManagerFactory emf 
            = Persistence.createEntityManagerFactory("baitap01PU");  // Tên Persistence Unit    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = null;
        try {
            String httpMethod = request.getParameter("_method");

            em = emf.createEntityManager();

            if (httpMethod != null && httpMethod.equals("update")) {
                Integer id = Integer.valueOf(request.getParameter("id"));

                // Tìm sản phẩm theo ID trong cơ sở dữ liệu
                Product foundProduct = em.find(Product.class, id);

                if (foundProduct != null) {
                    // Đặt sản phẩm vào request attribute
                    request.setAttribute("product", foundProduct);

                    // Chuyển tiếp đến trang updateProduct.jsp
                    request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
                } else {
                    // Nếu không tìm thấy sản phẩm
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                }
            } else {
                // Lấy danh sách tất cả sản phẩm từ cơ sở dữ liệu
                List<Product> products;
                // Lấy tham số searchText từ request
                String searchText = request.getParameter("searchText");

                if (searchText != null && !searchText.trim().isEmpty()) {
                    // Tìm kiếm sản phẩm theo tên (case-insensitive) hoặc mô tả
                    products = em.createQuery(
                            "SELECT p FROM Product p WHERE LOWER(p.name) LIKE :searchText OR LOWER(p.description) LIKE :searchText", Product.class)
                            .setParameter("searchText", "%" + searchText.toLowerCase() + "%")
                            .getResultList();

                } else {
                    // Lấy tất cả sản phẩm nếu không có từ khóa tìm kiếm
                    products = em.createNamedQuery("Product.findAll", Product.class).getResultList();
                }
                // Đặt danh sách sản phẩm vào request attribute
                request.setAttribute("products", products);
                request.getRequestDispatcher("products.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý các lỗi khác
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request");
        } finally {
            // Đóng EntityManager để giải phóng tài nguyên
            if (em != null) {
                em.close();
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         // Lấy dữ liệu từ form
        try {            
            String httpMethod = request.getParameter("_method");
            EntityManager em = null;
            if(httpMethod.equals("delete")) {
                // Lấy ID từ request
                Integer id = Integer.valueOf(request.getParameter("id"));
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                // Bắt đầu giao dịch
                transaction.begin();                
                // Tìm sản phẩm theo ID
                Product product = em.find(Product.class, id);
                if (product != null) {
                    // Xóa sản phẩm
                    em.remove(product);
                }   
                transaction.commit();
            } else if(httpMethod.equals("update")) {
                Integer id = Integer.valueOf(request.getParameter("id"));
                // Tạo EntityManager từ EntityManagerFactory
                em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();

                // Bắt đầu giao dịch
                transaction.begin(); 
                // Tìm sản phẩm theo ID
                Product product = em.find(Product.class, id);
                if (product != null) {
                    // Cập nhật thông tin sản phẩm
                    String productName = request.getParameter("productName");
                    float price = Float.parseFloat(request.getParameter("price"));
                    String description = request.getParameter("description");

                    product.setName(productName);
                    product.setPrice(new BigDecimal(price)); // Chuyển float sang BigDecimal
                    product.setDescription(description);

                    // Gọi merge để lưu thay đổi
                    em.merge(product);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                }

                // Cam kết giao dịch
                transaction.commit();

            } else {                                
                String productName = request.getParameter("productName");
                BigDecimal price = BigDecimal
                        .valueOf(Double.parseDouble(request.getParameter("price")));
                String description = request.getParameter("description");

                // Tạo đối tượng Temp mới từ dữ liệu form
                em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                Product product = new Product();
                
                product.setName(productName);
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