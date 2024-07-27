/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String retypedPassword = request.getParameter("retypedPassword");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        //if ..else to validate(not recommended)
        Map<String, String> errors = new HashMap();
        if(username.isEmpty()) {
            errors.put("username", "username cannot be empty");
            request.setAttribute("errors", errors);
        }
        if(password.isEmpty()) {
            errors.put("password", "Password cannot be empty");
            request.setAttribute("errors", errors);
        }
        if(retypedPassword.isEmpty()) {
            errors.put("retypedPassword", "retypedPassword cannot be empty");
            request.setAttribute("errors", errors);
        }
        if(email.isEmpty()) {
            errors.put("email", "email cannot be empty");
            request.setAttribute("errors", errors);
        }
        if(phoneNumber.isEmpty()) {
            errors.put("phoneNumber", "phoneNumber cannot be empty");
            request.setAttribute("errors", errors);
        }
        //validate email        
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 
                Pattern.CASE_INSENSITIVE)
                            .matcher(email);        
        if(!matcher.matches()) {
            errors.put("email", "Email must be in correct format");
            request.setAttribute("errors", errors);
        }                    
        if(!password.equals(retypedPassword)){
            errors.put("retypedPassword", "Password and retype password must be the same");
            request.setAttribute("errors", errors);
        }        
        request.getRequestDispatcher(errors.isEmpty() ? "/success.jsp":"/register.jsp").forward(request, response);        
    }
}
