/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import entities.*;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.math.BigDecimal;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ex002PU");
    private EntityManager entityManager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (action == null) ? "query" : action;
        String searchText = request.getParameter("searchText");
        searchText = searchText.equalsIgnoreCase("null") ? "":searchText;
        /*
        Collections.list(request.getParameterNames()).forEach(key -> {
            String value = request.getParameter(key);
            System.out.println("key = "+key+", value = "+value);
        });
        */
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ex002PU");
            entityManager = entityManagerFactory.createEntityManager();
            if(action.equals("edit")) {
                int productId = Integer.parseInt(request.getParameter("id"));
                Product existingProduct = entityManager.find(Product.class, productId);
                //send data to edit_product.jsp
                request.setAttribute("product", existingProduct);
                request.getRequestDispatcher("edit_product.jsp").forward(request, response);
            } else {
                List<Product> products;
                int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
                int recordsPerPage = 5; // You can adjust this value
                /*
                if (searchText != null && !searchText.trim().isEmpty()) {
                    products = entityManager.createNamedQuery("Product.findByText", Product.class)
                                             .setParameter("searchText", "%" + searchText + "%")
                                             .getResultList();
                } else {
                    products = entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
                }
                */
                int totalRecords;

                if (searchText != null && !searchText.trim().isEmpty()) {
                    products = entityManager.createNamedQuery("Product.findByText", Product.class)
                                            .setParameter("searchText", "%" + searchText + "%")
                                            .setFirstResult((currentPage - 1) * recordsPerPage)
                                            .setMaxResults(recordsPerPage)
                                            .getResultList();
                    totalRecords = ((Number) entityManager.createNamedQuery("Product.countBySearchText")
                                                           .setParameter("searchText", "%" + searchText + "%")
                                                           .getSingleResult()).intValue();
                } else {
                    products = entityManager.createNamedQuery("Product.findAll", Product.class)
                                            .setFirstResult((currentPage - 1) * recordsPerPage)
                                            .setMaxResults(recordsPerPage)
                                            .getResultList();
                    totalRecords = ((Number) entityManager.createNamedQuery("Product.countAll")
                                                           .getSingleResult()).intValue();
                }
                int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("currentPage", currentPage);
                request.setAttribute("products", products);//ViewBag
                request.getRequestDispatcher("products.jsp").forward(request, response);
            }
        }catch(ServletException | IOException e) {
            this.entityManagerFactory.close();
        }
        
    }

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response
    ) 
            throws ServletException, IOException {        
        String action = request.getParameter("action");
        action = action == null ? "":action;
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float price = Float.parseFloat(request.getParameter("price"));
        entityManagerFactory = Persistence.createEntityManagerFactory("ex002PU");
        entityManager = entityManagerFactory.createEntityManager();
        
        if(action.equals("add")) {
            try {            
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                Product newProduct = new Product();
                newProduct.setName(name);
                newProduct.setQuantity(quantity);
                newProduct.setPrice(BigDecimal.valueOf(price));
                entityManager.persist(newProduct);
                entityTransaction.commit();
                response.sendRedirect(String.format("%s/ProductServlet", request.getContextPath()));
            }catch(IOException e) {
               e.printStackTrace();
            }
        } else if(action.equals("update")) {
            try {            
                int productId = Integer.parseInt(request.getParameter("productId"));
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                Product product = entityManager.find(Product.class, productId);
                product.setName(name == null ? product.getName() : name);
                product.setQuantity(quantity);
                product.setPrice(BigDecimal.valueOf(price));
                entityManager.persist(product);
                entityTransaction.commit();
                response.sendRedirect(String.format("%s/ProductServlet", request.getContextPath()));
            }catch(IOException e) {
               e.printStackTrace();
            }
        }
    }
    
}
