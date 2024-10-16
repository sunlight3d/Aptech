import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Product;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void init() throws ServletException {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("de08PU");
    }

    @Override
    public void destroy() {
        entityManagerFactory.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int xx = 123;
        String categoryId = request.getParameter("category_id");
        if (categoryId != null) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Category category = entityManager.find(Category.class, categoryId);
            if (category != null) {
                TypedQuery<Product> query = entityManager
                        .createQuery("SELECT p FROM Product p WHERE p.category_id = :category", Product.class);
                query.setParameter("category", category);
                List<Product> products = query.getResultList();

                request.setAttribute("category", category);
                request.setAttribute("products", products);
                request.getRequestDispatcher("productlist.jsp").forward(request, response);
                entityManager.close();
                return;
            }
            entityManager.close();
        } else {
            String productId = request.getParameter("product_id");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Product product = entityManager.find(Product.class, productId);

            // Lấy danh sách tất cả category từ database
            TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
            List<Category> categories = query.getResultList();

            request.setAttribute("product", product);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("assign.jsp").forward(request, response);

            entityManager.close();
        }
        // Nếu không tìm thấy category hoặc có lỗi xảy ra, chuyển hướng về trang chủ
        response.sendRedirect(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("assign")) {
            String categoryId = request.getParameter("categoryId");
            String productId = request.getParameter("productId");

            // Xử lý logic gán sản phẩm cho danh mục
            assignProductToCategory(productId, categoryId);

            // Chuyển hướng về danh sách sản phẩm sau khi gán thành công
            response.sendRedirect(request.getContextPath() + "/ProductListServlet");
        } else {
            // Xử lý các yêu cầu khác (nếu có)
            // ...
        }
    }

    private void assignProductToCategory(String productId, String categoryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Product product = entityManager.find(Product.class, productId);
            Category category = entityManager.find(Category.class, categoryId);

            if (product != null && category != null) {
                product.setCategoryId(category);
                entityManager.merge(product);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

}
