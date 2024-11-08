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
import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductServlet extends HttpServlet {
    private List<Product> products = new ArrayList<>(List.of(
            new Product("iphone 15 pro 128gb 8 RAM", 1234.7f, 23, "This is iphone"), 
            new Product("Samsung galaxy dnuhd 12", 872.7f, 23, "sam sunggg"), 
            new Product("laptop gaming", 983.7f, 2, "lap riuehjru kjd")
        ));
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("products", products);
        req.getRequestDispatcher("products.jsp").forward(req, resp);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         // Lấy dữ liệu từ form
        try {
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            float quantity = Float.parseFloat(request.getParameter("quantity"));
            String description = request.getParameter("description");

            // Tạo đối tượng Product mới từ dữ liệu form
            Product newProduct = new Product(name, price, quantity, description);//builder pattern        
            this.products.add(newProduct);
        }catch(Exception e) {
            System.err.println("Error when inserting data");
        }

        // Chuyển hướng về trang danh sách sản phẩm sau khi thêm thành công
        response.sendRedirect("products");        
    }
    
}