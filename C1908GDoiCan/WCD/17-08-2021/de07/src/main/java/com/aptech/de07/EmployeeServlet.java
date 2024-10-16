/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.de07;

import com.aptech.de07.session.EmployeeFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {

       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> errors = new HashMap<String, String>();
        String employeeNo = request.getParameter("employeeNo");
        String name = request.getParameter("name");
        String placeOfWork = request.getParameter("placeOfWork");
        String phoneNo = request.getParameter("phoneNo");
        
        if (employeeNo.trim().length() == 0) {
           errors.put("employeeNo", "You must input employee number");
        }
        if (name.trim().length() == 0) {
           errors.put("name", "You must input name");
        }
        
        if (placeOfWork.trim().length() == 0) {
           errors.put("placeOfWork", "You must input placeOfWork");
        }
        if (phoneNo.trim().length() == 0) {
           errors.put("phoneNo", "You must input phone number");
        }
        //insert to db, JPA
        if (errors.isEmpty()) {                     
            EmployeeFacade employeeFacade = new EmployeeFacade();
            employeeFacade.insert(employeeNo, name, placeOfWork, phoneNo);                        
            request.getRequestDispatcher("employees.jsp").forward(request, response);            
        } else {            
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
        }
    }    

}
