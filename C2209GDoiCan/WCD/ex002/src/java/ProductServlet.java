/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import entities.*;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ex002PU");
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        //get product list from db
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ex002PU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            List<Product> products = entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
            //send list to jsp(view)
            //display objects in view
            request.setAttribute("products", products);//ViewBag
            request.getRequestDispatcher("products.jsp").forward(request, response);
        }catch(ServletException | IOException e) {
            this.entityManagerFactory.close();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); 
    }
    
}
