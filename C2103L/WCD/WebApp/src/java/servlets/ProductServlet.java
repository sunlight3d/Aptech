package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.ProductDAO;
import java.util.List;
import models.*;

@WebServlet(urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = "Chuỗi dữ liệu gửi từ ProductServlet";

        request.setAttribute("data", data);
        RequestDispatcher dispatcher = request.getRequestDispatcher("temp.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        System.out.println("haha");
        //String id = request.getParameter("id");
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));        
        ProductDAO productDAO = new ProductDAO();
        productDAO.createProduct(new Product(quantity, productName, price, quantity));        
        response.sendRedirect("productlist.jsp");
    }
}
