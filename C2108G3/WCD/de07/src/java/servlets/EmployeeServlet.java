/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;


import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import models.Employee;

//@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("de07PU");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @Override
    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create" -> createEmployee(request);
                case "update" -> updateEmployee(request);
                case "delete" -> deleteEmployee(request);
            }
        }

        response.sendRedirect("EmployeeServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "edit" -> showEditForm(request, response);
                case "delete" -> showDeleteConfirmation(request, response);
                default -> response.sendRedirect("EmployeeServlet");
            }
        } else {
            listEmployees(request, response);
        }
    }
    
    

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAll", Employee.class);
        List<Employee> employees = query.getResultList();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("employees.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
        Employee employee = entityManager.find(Employee.class, employeeNo);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee-form.jsp").forward(request, response);
    }

    private void showDeleteConfirmation(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
        Employee employee = entityManager.find(Employee.class, employeeNo);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("delete-confirmation.jsp").forward(request, response);
    }

    private boolean isEmployeeExists(String employeeName, String phoneNo) {
        TypedQuery<Long> query = entityManager.createNamedQuery("Employee.checkExists", Long.class);
        query.setParameter("name", employeeName);
        query.setParameter("phone", phoneNo);
        return query.getSingleResult() > 0;
    }


    private void createEmployee(HttpServletRequest request) {
        String employeeNo = request.getParameter("employeeNo");
        String employeeName = request.getParameter("employeeName");
        String placeOfWork = request.getParameter("placeOfWork");
        String phoneNo = request.getParameter("phoneNo");

        entityManager.getTransaction().begin();

        // Kiểm tra xem Employee có trùng tên hoặc số điện thoại không
        if (!isEmployeeExists(employeeName, phoneNo)) {
            Employee employee = new Employee(employeeNo, employeeName, placeOfWork, phoneNo);
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } else {
            // Xử lý trường hợp Employee trùng tên hoặc số điện thoại
            // Có thể hiển thị thông báo lỗi hoặc xử lý theo ý muốn của bạn
            entityManager.getTransaction().rollback(); // Quay lại trạng thái trước khi commit
        }
}


    private void updateEmployee(HttpServletRequest request) {
        int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));
        String employeeName = request.getParameter("employeeName");
        String placeOfWork = request.getParameter("placeOfWork");
        String phoneNo = request.getParameter("phoneNo");

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, employeeNo);
        if (employee != null) {
            employee.setEmployeeName(employeeName);
            employee.setPlaceOfWork(placeOfWork);
            employee.setPhoneNo(phoneNo);
        }
        entityManager.getTransaction().commit();
    }

    private void deleteEmployee(HttpServletRequest request) {
        int employeeNo = Integer.parseInt(request.getParameter("employeeNo"));

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, employeeNo);
        if (employee != null) {
            entityManager.remove(employee);
        }
        entityManager.getTransaction().commit();
    }
}

