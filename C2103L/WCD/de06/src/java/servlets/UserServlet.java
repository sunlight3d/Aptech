/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author sunli
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Kiểm tra các trường phải được nhập giá trị
        if (firstName.isEmpty() || lastName.isEmpty() || loginName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Kiểm tra mật khẩu và mật khẩu gõ lại phải trùng nhau
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Kiểm tra độ dài mật khẩu
        if (password.length() <= 10) {
            request.setAttribute("errorMessage", "Password must be longer than 10 characters");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng User
        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setLoginName(loginName);
        user.setPassword(password);

        // Lưu bản ghi vào cơ sở dữ liệu bằng JPA
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("de07PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng đến trang báo lỗi
            response.sendRedirect("error.jsp");
            return;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        // Chuyển hướng đến trang thành công
        response.sendRedirect("success.jsp");
    }


}
/*
Viết câu lệnh MySQL tạo bảng tblUser có các trường firstname, lastname, login_name, password
với các ràng buộc: login_name phải duy nhất và bắt buộc nhập, password phải > 10 ký tự
USE c2103l;
CREATE TABLE tblUser (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    login_name VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) CHECK(CHAR_LENGTH(password) > 10)
);
*/