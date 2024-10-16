/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;

//@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("de08PU");
        EntityManager em = emf.createEntityManager();

        // Sử dụng @NamedQuery "Category.findAll" để truy vấn danh sách các thể loại
        TypedQuery<Category> query = em.createNamedQuery("Category.findAll", Category.class);
        List<Category> categories = query.getResultList();

        em.close();
        emf.close();

        // Đặt danh sách thể loại vào request attribute để truy cập trong JSP
        request.setAttribute("categories", categories);

        // Chuyển hướng đến trang JSP để hiển thị danh sách thể loại
        request.getRequestDispatcher("list-categories.jsp").forward(request, response);
    }
}


