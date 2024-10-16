/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Employee;

/**
 *
 * @author ChungTV
 */
public class EmployeeServlet extends HttpServlet {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("de07PU");
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = null;
        String type = req.getParameter("type");   
        try {
            if (type == null || !type.equals("addNew")) {
                entityManager = entityManagerFactory.createEntityManager();
                List<Employee> employees = entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
                req.setAttribute("employees", employees);
                RequestDispatcher dispatcher = req.getRequestDispatcher("employees.jsp");
                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("employeeForm.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            System.err.println(e.toString());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("DELETE".equalsIgnoreCase(req.getParameter("_method"))) {
            doDelete(req, resp);
            return;
        }
        String employeeNo = req.getParameter("employeeNo");
        String employeeName = req.getParameter("employeeName");
        String placeOfWork = req.getParameter("placeOfWork");
        String phoneNo = req.getParameter("phoneNo");
       
        if (employeeNo.isEmpty()) {
            req.setAttribute("employeeNoError", "You must input employee number");
        }
        if (employeeName.isEmpty()) {
            req.setAttribute("employeeNameError", "You must input employee name");
        }
        if (placeOfWork.isEmpty()) {
            req.setAttribute("placeOfWorkError", "You must input place of work");
        }
        if (phoneNo.isEmpty()) {
            req.setAttribute("phoneNoError", "You must input phone no");
        }
        if (!employeeNo.isEmpty() && !employeeName.isEmpty() && !placeOfWork.isEmpty() && !phoneNo.isEmpty()) {  
             EntityManager entityManager = null;
             try {
                entityManager = entityManagerFactory.createEntityManager();
                Employee employeeExists = entityManager.find(Employee.class, employeeNo);
                if (employeeExists != null) {
                    req.setAttribute("errorMessage", "This employee is existed, please try other!!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("employeeForm.jsp");
                    dispatcher.include(req, resp);
                } else {
                    entityManager.getTransaction().begin();

                    Employee employee = new Employee();
                    employee.setEmployeeNo(employeeNo);
                    employee.setEmployeeName(employeeName);
                    employee.setPlaceOfWork(placeOfWork);
                    employee.setPhoneNo(phoneNo);
                    entityManager.persist(employee);
                    entityManager.getTransaction().commit();
                    resp.sendRedirect("EmployeeServlet");
                }
            } catch (ServletException | IOException e) {
                if (entityManager != null && entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                // Ensure that the EntityManager is closed to release resources
                if (entityManager != null && entityManager.isOpen()) {
                    entityManager.close();
                }
            }
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("employeeForm.jsp");
            dispatcher.include(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeNo = req.getParameter("employeeNo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
             if (!employeeNo.isEmpty()) {
                entityManager.getTransaction().begin();
                Employee employee = entityManager.find(Employee.class, employeeNo);
                if (employee != null) {
                    entityManager.remove(employee);
                }
                entityManager.getTransaction().commit();
            }
            resp.sendRedirect("EmployeeServlet");
        } catch (IOException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }
}
/*
CREATE DATABASE c2206l_ex2;
USE c2206l_ex2;

CREATE TABLE TblEmployee  (
    EmployeeNo  VARCHAR(20) PRIMARY KEY,
    EmployeeName VARCHAR(30),
	PlaceOfWork VARCHAR(30),
    PhoneNo VARCHAR(10)
);
*/