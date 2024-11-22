/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import models.Product;
import models.User;


public class UserServlet extends HttpServlet {
    private EntityManagerFactory emf 
            = Persistence.createEntityManagerFactory("baitap01PU");  // Tên Persistence Unit    

    @Override
    protected void doGet
        (HttpServletRequest request, 
                HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("_type");
        if("login".equalsIgnoreCase(type.trim())) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        
    }

    @Override    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("_action");

    if ("login".equalsIgnoreCase(action.trim())) {
        // Xử lý đăng nhập
        handleLogin(request, response);
    } else if ("register".equalsIgnoreCase(action.trim())) {
        // Xử lý đăng ký
        handleRegister(request, response);
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action.");
    }
}

// Hàm xử lý đăng nhập
private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    EntityManager em = null;

    try {
        em = emf.createEntityManager();

        User user = em.createQuery(
                "SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultStream()
                .findFirst()
                .orElse(null);

        if (user != null) {
            response.sendRedirect("products");
        } else {
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred during login.");
    } finally {
        if (em != null) {
            em.close();
        }
    }
}

// Hàm xử lý đăng ký
private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("confirmPassword");
    EntityManager em = null;

    try {
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // Kiểm tra email đã tồn tại
        boolean emailExists = !em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList()
                .isEmpty();

        if (emailExists) {
            request.setAttribute("error", "Email already exists.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Tạo user mới và lưu vào database
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password); // Mật khẩu không mã hóa
        em.persist(newUser);

        em.getTransaction().commit();
        response.sendRedirect("login.jsp");
    } catch (Exception e) {
        if (em != null && em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred during registration.");
    } finally {
        if (em != null) {
            em.close();
        }
    }
    }
 
}

/*
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(100) NOT NULL
);

*/