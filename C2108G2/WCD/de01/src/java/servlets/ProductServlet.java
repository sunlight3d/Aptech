/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    public ProductServlet() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("de01PU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("search".equals(action)) {
            searchProducts(request, response);
        } else if ("getAll".equals(action)) {
            getAllProducts(request, response);
        } 
    }

    private void searchProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchTerm = request.getParameter("search");

        // Tạo truy vấn sử dụng NamedQuery
        TypedQuery<Product> query = entityManager
                .createNamedQuery("Product.findByName", Product.class);
        query.setParameter("name", "%" + searchTerm + "%"); // Tìm sản phẩm có tên chứa searchTerm

        List<Product> products = query.getResultList();

        // Đưa dữ liệu vào request attribute để hiển thị trên JSP
        request.setAttribute("products", products);

        // Forward request và response đến trang hiển thị danh sách sản phẩm (productlist.jsp)
        request.getRequestDispatcher("/productlist.jsp").forward(request, response);
    }

    private void getAllProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Tạo truy vấn sử dụng NamedQuery
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findAll", Product.class);

        List<Product> products = query.getResultList();

        // Đưa dữ liệu vào request attribute để hiển thị trên JSP
        request.setAttribute("products", products);

        // Forward request và response đến trang hiển thị danh sách sản phẩm (productlist.jsp)
        request.getRequestDispatcher("/productlist.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("add")) {
                // Xử lý thêm sản phẩm
                handleAddProduct(request, response);
            }
        }
    }
    
    private void handleAddProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Kiểm tra và xử lý lỗi
        Map<String, String> errors = new HashMap<String, String>();

        if (name == null || name.trim().isEmpty()) {
            errors.put("nameError", "Name is required.");
        }

        if (price < 0) {
            errors.put("priceError", "Price must be greater than zero.");
        }

        if (quantity <= 0) {
            errors.put("quantityError", "Quantity must be greater than zero.");
        }

        if (!errors.isEmpty()) {
            // Nếu có lỗi, đặt thông báo lỗi vào request attribute và forward lại trang add-product.jsp
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("add-product.jsp").forward(request, response);
        } else {
            // Nếu không có lỗi, thực hiện thêm sản phẩm vào cơ sở dữ liệu
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);

            em.persist(product);
            em.getTransaction().commit();
            em.close();

            // Sau khi thêm thành công, chuyển hướng đến trang danh sách sản phẩm
            response.sendRedirect("ProductServlet?action=getAll");
        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Lấy ID sản phẩm cần xóa từ request
        int productId = Integer.parseInt(request.getParameter("id"));

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        try {
            // Tìm sản phẩm theo ID
            Product product = em.find(Product.class, productId);

            if (product != null) {
                // Xóa sản phẩm nếu tồn tại
                em.remove(product);
                em.getTransaction().commit();
            } else {
                // Nếu không tìm thấy sản phẩm, có thể đặt thông báo lỗi
                // hoặc chuyển hướng đến trang lỗi tùy theo yêu cầu
                // Ví dụ: request.setAttribute("errorMessage", "Product not found");
                // request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            em.getTransaction().rollback();
            e.printStackTrace();
            // Có thể đặt thông báo lỗi hoặc chuyển hướng đến trang lỗi tùy theo yêu cầu
            // Ví dụ: request.setAttribute("errorMessage", "Error deleting product");
            // request.getRequestDispatcher("error.jsp").forward(request, response);
        } finally {
            em.close();
        }

    // Sau khi xóa thành công, chuyển hướng đến trang danh sách sản phẩm
    response.sendRedirect("ProductServlet?action=getAll");
}


    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

