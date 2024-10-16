/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.StudentBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Student;

/**
 *
 * @author w11
 */
public class StudentServlet extends HttpServlet {
    

    @EJB
    private StudentBeanLocal studentBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type") == null ? "" 
                : (String)request.getParameter("type");
        if(type.equals("")) {
            request.getRequestDispatcher("list.jsp").forward(request, response);     
        } else {
            if(type.equals("delete")) {
                String rollNumber = (String)request.getParameter("rollnumber");
                studentBean.delete(rollNumber);
                
            }
            request.setAttribute("employees", studentBean.findAll());
            request.getRequestDispatcher("employees.jsp").forward(request, response);     
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Insert code => call Enterprise Beans
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
