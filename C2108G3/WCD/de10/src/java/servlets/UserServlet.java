/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;


public class UserServlet extends HttpServlet {
    @PersistenceContext(unitName = "de10PU")
    private javax.persistence.EntityManagerFactory entityManagerFactory;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        super.doPost(request, response);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        entityManager.close();
        if(users.size() > 0) {
            request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Wrong email or password");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); 
    }


}
