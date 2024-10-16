/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author w11
 */
public class Question2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //validate
        Hashtable<String, String> errors =  new Hashtable<String, String>();
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNo = request.getParameter("phoneNo");
        String className = request.getParameter("className");
        if(name == null || name == "") {
            errors.put("name", "Name is required");            
        }
        if(address == null || address == "") {
            errors.put("address", "address is required");            
        }
        if(phoneNo == null || phoneNo == "") {
            errors.put("phoneNo", "phoneNo is required");            
        }
        if(className == null || className == "") {
            errors.put("className", "className is required");            
        }
        Boolean isValid = errors.size() == 0;
        request.setAttribute("errors", errors);
        if(isValid) {
            //ok      
            response.reset();
            response.addCookie(new Cookie("name", name));
            response.addCookie(new Cookie("address", address));
            response.addCookie(new Cookie("phoneNo", phoneNo));
            response.addCookie(new Cookie("className", className));   
            response.sendRedirect("detail.jsp");           
        } else {            
            request.getRequestDispatcher("question02.jsp").forward(request, response);                        
        }
        
        
        
    }

}
