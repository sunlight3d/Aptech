/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Employee;

public class EmployeeServlet extends HttpServlet {
    public EntityManager getEntityManager() {
        return Persistence
                .createEntityManagerFactory("de07PU")
                .createEntityManager();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type") == null ? "" 
                : (String)request.getParameter("type");
        if(type.equals("insert")) {
            request.getRequestDispatcher("addnew.jsp").forward(request, response);     
        } else {
            if(type.equals("delete")) {
                String employeeNo = (String)request.getParameter("employeeNo");
                EntityManager entityManager = getEntityManager();
                Employee employee = entityManager
                            .createNamedQuery("Employee.findByEmployeeNo", Employee.class)  
                            .setParameter("employeeNo", employeeNo)
                            .getSingleResult();        
                entityManager.getTransaction().begin();
                entityManager.remove(employee);            
                entityManager.getTransaction().commit();                  
            }
            EntityManager entityManager = getEntityManager();
            List<Employee> employees = 
                        (List<Employee>)entityManager
                            .createNamedQuery("Employee.findAll", Employee.class)                            
                            .getResultList();           
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("employees.jsp").forward(request, response);     
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
        String employeeNo = request.getParameter("employeeNo") == null ? "":
                request.getParameter("employeeNo");        
        String name = request.getParameter("name") == null ? "":
                request.getParameter("name");        
        String placeOfWork = request.getParameter("placeOfWork") == null ? "":
                request.getParameter("placeOfWork");       
        String phoneNo = request.getParameter("phoneNo") == null ? "":
                request.getParameter("phoneNo"); 
        Hashtable<String, Object> errors = new Hashtable<String, Object>();
        errors.put("employeeNo", employeeNo.equals("") ? "You must enter employeeNo" : "");
        errors.put("name", name.equals("") ? "You must enter name" : "");
        errors.put("placeOfWork", placeOfWork.equals("") ? "Please enter placeOfWork" : "");
        errors.put("phoneNo", phoneNo.equals("") ? "Please enter phoneNo" : "");        
        
        boolean validationError = ((String)errors.get("employeeNo")).length() > 0 ||
                ((String)errors.get("name")).length() > 0 ||
                ((String)errors.get("placeOfWork")).length() > 0 ||
                ((String)errors.get("phoneNo")).length() > 0;
        
        if(validationError) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("addnew.jsp").forward(request, response);     
        } else {     
            EntityManager entityManager = getEntityManager();
            Employee employee = entityManager
                            .createNamedQuery("Employee.findByEmployeeNo", Employee.class)  
                            .setParameter("employeeNo", employeeNo)
                            .getSingleResult();        
            
            if(employee != null) {
                errors.put("exist", "This employee is existed, please try other!");        
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("addnew.jsp").forward(request, response);     
            }
            //update success
            entityManager.getTransaction().begin();                        
            entityManager.persist(new Employee(employeeNo, name, placeOfWork, phoneNo));
            entityManager.getTransaction().commit();
            entityManager.close();
            //redirect
            response.sendRedirect("EmployeeServlet");  
        }
        
    }

}
