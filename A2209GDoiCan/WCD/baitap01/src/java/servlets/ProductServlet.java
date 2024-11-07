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
import java.util.List;
import models.Product;

public class ProductServlet extends HttpServlet {
    private List<Product> products = List.of(
            //int id, String name, float price, float quantity, String description
            new Product(1, "iphone 15 pro 128gb 8 RAM", 1234.7f, 23, "This is iphone"), 
            new Product(2, "Samsung galazy dnuhd 12", 872.7f, 23, "sam sunggg"), 
            new Product(3, "laptop gaming", 983.7f, 2, "lap riuehjru kjd")
            );
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("products", products);
        req.getRequestDispatcher("products.jsp").forward(req, resp);  
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}