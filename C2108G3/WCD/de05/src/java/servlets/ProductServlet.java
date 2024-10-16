/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import models.Product;

//@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("de05PU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "list":
                    listProducts(request, response);
                    break;
                case "show":
                    showProduct(request, response);
                    break;
                case "search":
                    searchProducts(request, response);
                    break;
                // Add more cases for other actions
            }
        } else {
            // Default behavior when no action is specified
            listProducts(request, response);
        }
    }
    private void searchProducts(HttpServletRequest request, HttpServletResponse response) throws 
        ServletException, IOException {
        // Lấy giá trị từ trường search trong request
        String searchTerm = request.getParameter("search");

        // Sử dụng JPQL để tìm các sản phẩm có name chứa searchTerm
        List<Product> products = entityManager.createQuery("SELECT p FROM Product p WHERE p.name LIKE :searchTerm", Product.class)
                .setParameter("searchTerm", "%" + searchTerm + "%")
                .getResultList();

        // Đặt danh sách sản phẩm kết quả vào request
        request.setAttribute("products", products);

        // Chuyển hướng đến trang jsp hiển thị danh sách sản phẩm
        request.getRequestDispatcher("/productlist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "create":
                    createProduct(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
            }
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws 
            ServletException, IOException {
        // Đọc danh sách sản phẩm từ cơ sở dữ liệu và đặt chúng trong request
        List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        request.setAttribute("products", products);

        // Chuyển hướng đến trang jsp hiển thị danh sách sản phẩm
        request.getRequestDispatcher("/productlist.jsp").forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws 
            ServletException, IOException {
        // Lấy thông tin sản phẩm theo ID từ request
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = entityManager.find(Product.class, productId);

        // Đặt sản phẩm vào request để hiển thị
        request.setAttribute("product", product);

        // Chuyển hướng đến trang jsp hiển thị thông tin sản phẩm
        request.getRequestDispatcher("/showProduct.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws 
            ServletException, IOException {
        // Lấy thông tin sản phẩm từ request
        // Lấy thông tin sản phẩm từ request
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity")); // Lấy thông tin "quantity" từ yêu cầu

        // Tạo một đối tượng Product mới và lưu vào cơ sở dữ liệu
        Product product = new Product(); 
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        // Chuyển hướng đến trang danh sách sản phẩm sau khi thêm thành công
        response.sendRedirect(request.getContextPath() + "/ProductServlet?action=list");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Lấy thông tin sản phẩm từ request
        int productId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity")); // Lấy thông tin "quantity" từ yêu cầu

        // Tìm sản phẩm theo ID và cập nhật thông tin
        Product product = entityManager.find(Product.class, productId);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity); // Cập nhật trường "quantity"

            entityManager.getTransaction().begin();
            entityManager.merge(product); // Sử dụng merge để cập nhật sản phẩm
            entityManager.getTransaction().commit();

            // Chuyển hướng đến trang danh sách sản phẩm sau khi cập nhật thành công
            response.sendRedirect(request.getContextPath() + "/ProductServlet?action=list");
        } else {
            // Xử lý trường hợp sản phẩm không tồn tại
            response.getWriter().println("Product with ID " + productId + " not found.");
        }
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws 
            ServletException, IOException {
        // Lấy thông tin sản phẩm từ request
        int productId = Integer.parseInt(request.getParameter("id"));

        // Xóa sản phẩm từ cơ sở dữ liệu
        Product product = entityManager.find(Product.class, productId);
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        // Chuyển hướng đến trang danh sách sản phẩm sau khi xóa thành công
        response.sendRedirect(request.getContextPath() + "/ProductServlet?action=list");
    }
}
