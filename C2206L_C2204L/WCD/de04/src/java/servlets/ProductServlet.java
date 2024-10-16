/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entities.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nguyen Duc Hoang
 */
public class ProductServlet extends HttpServlet {
    private EntityManager entityManager;   
    private RequestDispatcher dispatcher;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
             String productId = request.getParameter("id");
             this.entityManager = Persistence
                        .createEntityManagerFactory("de04PU")
                .createEntityManager();
             if(productId == null) {                 
                List<Product> products = entityManager.createNamedQuery(
                                "Product.findAll", Product.class).getResultList();
                        request.setAttribute("products", products);
                this.dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);                                  
             } else {
                 //lấy thông tin chi tiết sản phẩm từ productId và gửi thông tin đó xuống jsp
                TypedQuery<Product> query = entityManager.createNamedQuery("Product.findById", Product.class);
                query.setParameter("id", Integer.valueOf(productId));
                Product product = query.getSingleResult();
                request.setAttribute("product", product);
                this.dispatcher = request.getRequestDispatcher("mobileDetail.jsp");
                dispatcher.forward(request, response);                                  
             }
            
        }catch(Exception e) {
            System.err.println(e.toString());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
}
