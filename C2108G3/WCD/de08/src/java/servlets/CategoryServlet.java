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

@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
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

        if ("createCategory".equals(action)) {
            // Create a new Category
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();
                Category category = new Category();
                category.setName(request.getParameter("categoryName"));
                category.setDescription(request.getParameter("categoryDescription"));
                em.persist(category);
                tx.commit();
            } catch (Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }
            response.sendRedirect("category.jsp"); // Redirect to a suitable page
        } else if ("updateCategory".equals(action)) {
            // Update an existing Category
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();
                Long categoryId = Long.parseLong(request.getParameter("categoryId"));
                Category category = em.find(Category.class, categoryId);
                if (category != null) {
                    category.setName(request.getParameter("categoryName"));
                    category.setDescription(request.getParameter("categoryDescription"));
                }
                tx.commit();
            } catch (Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }
            response.sendRedirect("category.jsp"); // Redirect to a suitable page
        } else if ("deleteCategory".equals(action)) {
            // Delete an existing Category
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();
                Long categoryId = Long.parseLong(request.getParameter("categoryId"));
                Category category = em.find(Category.class, categoryId);
                if (category != null) {
                    em.remove(category);
                }
                tx.commit();
            } catch (Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }
            response.sendRedirect("category.jsp"); // Redirect to a suitable page
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> categories = query.getResultList();
        
        // Store categories as request attribute for JSP rendering
        
        if ("retrieve".equals(action)) {
            // Retrieve all Categories
            request.setAttribute("categories", categories);    
            em.close();
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        }
        // You can add similar logic for other CRUD operations (retrieve, update, delete)
    }
}

