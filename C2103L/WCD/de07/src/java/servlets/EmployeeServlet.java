/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import models.Employee;

public class EmployeeServlet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("de07PU");
    }

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            // Lấy danh sách tất cả nhân viên
            List<Employee> employeeList = getAllEmployees();
            request.setAttribute("employees", employeeList);//ViewBag
            request.getRequestDispatcher("employees.jsp").forward(request, response);
            //return View();
        } else if (action.equals("edit")) {
            String employeeNo = request.getParameter("employeeNo");
            Employee employee = findEmployee(employeeNo);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("edit_employee.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
        // Thêm nhân viên mới
        String employeeNo = request.getParameter("employeeNo");
        String employeeName = request.getParameter("employeeName");
        String placeOfWork = request.getParameter("placeOfWork");
        String phoneNo = request.getParameter("placeOfWork");

        createEmployee(employeeNo, employeeName, placeOfWork, phoneNo);
    } else if (action.equals("update")) {
        // Cập nhật thông tin nhân viên
        String employeeNo = request.getParameter("employeeNo");
        String employeeName = request.getParameter("employeeName");
        String placeOfWork = request.getParameter("placeOfWork");

        updateEmployee(employeeNo, employeeName, placeOfWork);
    } else if (action.equals("delete")) {
        // Xóa nhân viên
        String employeeNo = request.getParameter("employeeNo");
        deleteEmployee(employeeNo);
    } else if (action.equals("add")) {
        // Thêm nhân viên mới
        String employeeNo = request.getParameter("employeeNo");
        String employeeName = request.getParameter("employeeName");
        String placeOfWork = request.getParameter("placeOfWork");
        String phoneNo = request.getParameter("phoneNo");

        // Tạo đối tượng HashMap để lưu trữ thông báo lỗi
        HashMap<String, String> errorMessages = new HashMap<>();
        // Kiểm tra trường bỏ trống và thêm thông báo lỗi vào HashMap
        if (employeeNo.isEmpty()) {
            errorMessages.put("employeeNo", "Employee No is required");
        }
        if (employeeName.isEmpty()) {
            errorMessages.put("employeeName", "Employee Name is required");
        }
        if (placeOfWork.isEmpty()) {
            errorMessages.put("placeOfWork", "Place of Work is required");
        }
        if (phoneNo.isEmpty()) {
            errorMessages.put("phoneNo", "Phone No is required");
        }
        // Kiểm tra trường Employee No trùng lặp
        if (isDuplicateEmployeeName(employeeName)) {
            errorMessages.put("duplicateName", "Employee Name already exists");
        }
        // Kiểm tra nếu có thông báo lỗi thì chuyển hướng trở lại trang JSP
        if (!errorMessages.isEmpty()) {
            request.setAttribute("errorMessages", errorMessages);
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("add_employee.jsp");
            dispatcher.forward(request, response);
            return;
        }        
        createEmployee(employeeNo, employeeName, placeOfWork, phoneNo);
    }
    response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
}


    @Override
    public void destroy() {
        emf.close();
    }

    private List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Employee.findAll", 
                    Employee.class).getResultList();
        } finally {
            em.close();
        }
    }
    private boolean isDuplicateEmployeeName(String employeeName) {
    // Gọi phương thức truy vấn tương ứng từ JPA EntityManager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("de07PU");
    EntityManager em = emf.createEntityManager();
    
    try {
        // Sử dụng NamedQuery để truy vấn nhân viên dựa trên tên
        TypedQuery<Employee> query = em
                .createNamedQuery("Employee.findByEmployeeName", Employee.class);
        query.setParameter("employeeName", employeeName);
        
        // Lấy danh sách nhân viên có cùng tên
        List<Employee> employees = query.getResultList();
        
        // Kiểm tra xem có nhân viên nào trùng tên hay không
        return !employees.isEmpty();
        } finally {
            em.close();
            emf.close();
        }
    }


    private Employee findEmployee(String employeeNo) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Employee.class, employeeNo);
        } finally {
            em.close();
        }
    }

    private void createEmployee(String employeeNo, 
            String employeeName, 
            String placeOfWork,
            String phoneNo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Employee employee = new Employee(employeeNo, employeeName, placeOfWork);
            employee.setPhoneNo(phoneNo);
            em.persist(employee);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private void updateEmployee(String employeeNo, String employeeName, String placeOfWork) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Employee employee = em.find(Employee.class, employeeNo);
            if (employee != null) {
                employee.setEmployeeName(employeeName);
                employee.setPlaceOfWork(placeOfWork);
                em.merge(employee);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private void deleteEmployee(String employeeNo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Employee employee = em.find(Employee.class, employeeNo);
            if (employee != null) {
                em.remove(employee);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

