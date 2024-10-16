/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

@WebServlet(name = "ProductServlet", urlPatterns = { "/ProductServlet" })
public class ProductServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("de05PU");
    }

    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        entityManagerFactory = Persistence.createEntityManagerFactory("de05PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Product> query = entityManager.createNamedQuery("Product.findAll", Product.class);
            List<Product> productList = query.getResultList();

            request.setAttribute("productList", productList);
            request.getRequestDispatcher("productlist.jsp").forward(request, response);
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("insert")) {
            // Thêm sản phẩm mới
            // Lấy dữ liệu từ các trường nhập liệu
            String id = request.getParameter("id");
            String productName = request.getParameter("productName");
            String price = request.getParameter("price");
            String quantity = request.getParameter("quantity");

            // Thực hiện thêm sản phẩm mới vào CSDL sử dụng JPA
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            try {
                // Kiểm tra xem sản phẩm có tồn tại trong CSDL hay không
                Product existingProduct = entityManager.find(Product.class, id);
                if (existingProduct != null) {
                    // Sản phẩm đã tồn tại, có thể thông báo lỗi hoặc thực hiện xử lý khác tùy thuộc vào yêu cầu của bạn
                    // ...
                } else {
                    // Tạo một đối tượng Product mới
                    Product newProduct = new Product();
                    newProduct.setId(Integer.parseInt(id));
                    newProduct.setProductName(productName);
                    newProduct.setPrice(new BigDecimal(price));
                    newProduct.setQuantity(Integer.parseInt(quantity));

                    // Thực hiện thêm bản ghi vào CSDL
                    entityManager.getTransaction().begin();
                    entityManager.persist(newProduct);
                    entityManager.getTransaction().commit();
                }

                // Chuyển hướng về danh sách sản phẩm
                response.sendRedirect("ProductServlet");
            } finally {
                entityManager.close();
                entityManagerFactory.close();
            }
        }
    }
}
