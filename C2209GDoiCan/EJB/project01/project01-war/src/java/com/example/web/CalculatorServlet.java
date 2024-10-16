/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
//http://localhost:8089/project01-war/CalculatorServlet
package com.example.web;
import com.example.ejb.CalculatorBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @EJB
    private CalculatorBeanLocal calculatorBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int a = 10;
        int b = 5;
        int sum = calculatorBean.add(a, b);
        int difference = calculatorBean.subtract(a, b);
        
        response.getWriter().println("Sum: " + sum);
        response.getWriter().println("Difference: " + difference);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
