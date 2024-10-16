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
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Book;

/**
 *
 * @author hoangnd
 */
public class BookServlet extends HttpServlet {   
private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
    private EntityManager em;

    public void init() {
        emf = Persistence.createEntityManagerFactory("de10PU");
        em = emf.createEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Book> books = getAllBooks();
        request.setAttribute("books", books);
        // Fetch distinct categories using a JPA query
        TypedQuery<String> query = em.createQuery("SELECT DISTINCT b.category FROM Book b", 
                String.class);
        // Set the categories list in the request scope
        request.setAttribute("categories", query.getResultList());
        
        request.getRequestDispatcher("/list-all-books.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
                //doGet(request, response);
            // Retrieve parameters from the request
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            float price = Float.parseFloat(request.getParameter("price"));
            if (price <= 0) {
                // Price is not valid, set an error message
                request.setAttribute("priceError", "Price must be greater than 0");
                // Forward back to the insert-book.jsp page
                request.getRequestDispatcher("/insert-book.jsp").forward(request, response);           
            } else {
                request.getRequestDispatcher("/list-all-books.jsp").forward(request, response);
            }       
            // Create a new Book entity
            Book newBook = new Book();
            newBook.setTitle(title);
            newBook.setCategory(category);
            newBook.setPrice(price);            
            // Begin a transaction, persist the new Book, and commit the transaction
            javax.persistence.EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(newBook);
            transaction.commit();

            // Close the EntityManager and EntityManagerFactory
            em.close();
            emf.close();

            // Redirect to the list-all-books.jsp page
            response.sendRedirect(request.getContextPath() + "/list-all-books.jsp");
    }

    private List<Book> getAllBooks() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    public void destroy() {
        em.close();
        emf.close();
    }
}
