/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("de08PU");
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();

        try {
            if ("insert".equals(action)) {
                createProduct(request, em);
            } else if ("update".equals(action)) {
                updateProduct(request, em);
            } else if ("delete".equals(action)) {
                deleteProduct(request, em);
            } else if ("assignCategory".equals(action)) {
                assignCategory(request, em);
            }
            response.sendRedirect("productlist.jsp"); // Redirect to a suitable page
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }    
    private void createProduct(HttpServletRequest request, EntityManager em) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Product product = new Product();
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setCategoryId(em.find(Category.class, Long.parseLong(request.getParameter("categoryId"))));
            em.persist(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, EntityManager em) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Long productId = Long.parseLong(request.getParameter("productId"));
            Product product = em.find(Product.class, productId);
            if (product != null) {
                product.setName(request.getParameter("productName"));
                product.setDescription(request.getParameter("productDescription"));
                product.setPrice(Double.parseDouble(request.getParameter("productPrice")));
                product.setCategoryId(em.find(Category.class, Long.parseLong(request.getParameter("categoryId"))));
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, EntityManager em) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Long productId = Long.parseLong(request.getParameter("productId"));
            Product product = em.find(Product.class, productId);
            if (product != null) {
                em.remove(product);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    private void assignCategory(HttpServletRequest request, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));
        Long productId = Long.parseLong(request.getParameter("productId"));
        Product product = em.find(Product.class, productId);
        Category category = em.find(Category.class, categoryId);

        try {
            tx.begin();
            if (product != null) {
                product.setCategoryId(category);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();
        if ("retrieve".equals(action)) {
            // Retrieve all Products
            
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            List<Product> products = query.getResultList();
            em.close();

            // Store products as request attribute for JSP rendering
            request.setAttribute("products", products);
            request.getRequestDispatcher("productlist.jsp").forward(request, response);
        } else if("chooseCategory".equals(action)) {
            int productId = Integer.valueOf(request.getParameter("productId"));
            Product product = em.find(Product.class, productId);
            em.close();
            request.setAttribute("category", product);    
            request.getRequestDispatcher("choose-category.jsp").forward(request, response);
            
        }
        // Handle other CRUD operations (retrieve, update, delete) similarly
    }
}
