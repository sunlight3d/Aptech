/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
CREATE DATABASE de06;
USE de06;
CREATE TABLE tblUser(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    username VARCHAR(50),
    password VARCHAR(200)
);
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");           
    }
    private String sha1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());            
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
              sb.append(Integer
                      .toString((messageDigest[i] & 0xff) + 0x100, 16)
                      .substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
          throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String firstName = request.getParameter("firstName");        
        String lastName = request.getParameter("lastName");        
        String username = request.getParameter("username");        
        String password = request.getParameter("password");        
        String retypedPassword = request.getParameter("retypedPassword");        
        Hashtable<String, Object> errors = new Hashtable<String, Object>();
        errors.put("firstName", firstName.equals("") ? "You must enter first name" : "");
        errors.put("lastName", firstName.equals("") ? "You must enter last name" : "");
        errors.put("username", firstName.equals("") ? "Please enter username" : "");
        errors.put("password", firstName.equals("") ? "Please enter password" : "");
        errors.put("retypedPassword", firstName.equals("") ? "Please enter password" : "");
        errors.put("twoPasswordSame", !password.equals(retypedPassword) ? "Two passwords must be the same" : "");        
        
        boolean validationError = ((String)errors.get("firstName")).length() > 0 ||
                ((String)errors.get("lastName")).length() > 0 ||
                ((String)errors.get("username")).length() > 0 ||
                ((String)errors.get("password")).length() > 0 ||
                ((String)errors.get("retypedPassword")).length() > 0 ||
                ((String)errors.get("twoPasswordSame")).length() > 0;
        if(validationError) {
            request.setAttribute("errors",errors);
        } else {
            try {
                String hashedPassword = this.sha1(password);
                
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        
        
        request.getRequestDispatcher("register.jsp").forward(request, response);                          
    }

}
