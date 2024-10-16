/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;


import entities.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.*;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.*;
import org.apache.tomcat.util.digester.EnvironmentPropertySource;

public class EmployeeServlet extends HttpServlet {
    private RequestDispatcher dispatcher;    
    private EntityManager entityManager;    

    @Override
    public void init() throws ServletException {
        super.init(); 
        System.out.println("init...");                             
    }    

    @Override
    public void destroy() {
        super.destroy(); 
        System.out.println("destroy...");
        
    }
    
    @Override    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
        try {   
             // Lấy giá trị của tham số employeeNo từ URL
            String employeeNo = request.getParameter("employeeNo");        
            // Lấy giá trị của tham số action từ URL
            String action = request.getParameter("action") == null ? "" : 
                    request.getParameter("action");            
            this.entityManager = Persistence
                        .createEntityManagerFactory(Environment.PERSISTENCE_UNIT)
                .createEntityManager();
            if(action.toLowerCase().equals("delete")) {                
                entityManager.getTransaction().begin();
                // Tìm nhân viên cần xóa dựa trên mã số nhân viên
                Employee employee = entityManager.find(Employee.class, employeeNo);
                if (employee != null) {
                    // Xóa nhân viên
                    entityManager.remove(employee);
                }
                entityManager.getTransaction().commit();
                //entityManager.close();
            } 
            List<Employee> employees = entityManager.createNamedQuery(
                        "Employee.findAll", Employee.class).getResultList();
                request.setAttribute("employees", employees);
            this.dispatcher = request.getRequestDispatcher("employees.jsp");
            dispatcher.forward(request, response);                                  
        } catch (ServletException | IOException e) {
            System.err.println(e.toString());        
        } finally {
            this.entityManager.close();
            this.entityManager.getEntityManagerFactory().close();  
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : 
                    request.getParameter("action");
        if(action.toLowerCase().equals("insert")) {
            String employeeNo = request.getParameter("employeeNo");
            String name = request.getParameter("name");
            String placeOfWork = request.getParameter("placeOfWork");
            String phoneNo = request.getParameter("phoneNo");    
            // Kiểm tra và lưu các trường null vào Hashtable
            Hashtable<String, String> errorFields = new Hashtable<>();
            if (employeeNo == null || employeeNo.isEmpty()) {
                errorFields.put("employeeNo", "Employee No is required");
            }
            if (name == null || name.isEmpty()) {
                errorFields.put("name", "Name is required");
            }
            if (placeOfWork == null || placeOfWork.isEmpty()) {
                errorFields.put("placeOfWork", "Place of Work is required");
            }
            if (phoneNo == null || phoneNo.isEmpty()) {
                errorFields.put("phoneNo", "Phone No is required");
            }
            if (!errorFields.isEmpty()) {
                request.setAttribute("errorFields", errorFields);
                request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
                return;
            }            
            try {
                
                //check if phoneno exists               
                this.entityManager = Persistence
                                    .createEntityManagerFactory(Environment.PERSISTENCE_UNIT)
                                    .createEntityManager();
                TypedQuery<Employee> query = entityManager.createNamedQuery(
                        "Employee.findByPhoneNumber", 
                        Employee.class);
                query.setParameter("phoneNumber", phoneNo);
                if(!query.getResultList().isEmpty()) {
                    //send error to jsp
                    request.setAttribute("employeeExist", 
                            "This employee is existed, please try other");
                    request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
                    return;
                }
                
                entityManager.getTransaction().begin();
                // Tạo một đối tượng Employee mới
                Employee employee = new Employee();
                employee.setEmployeeNo(employeeNo);
                employee.setEmployeeName(name);                
                employee.setPlaceOfWork(placeOfWork);
                employee.setPhoneNumber(phoneNo);

                // Chèn nhân viên vào cơ sở dữ liệu
                entityManager.persist(employee);
                entityManager.getTransaction().commit();                
                response.sendRedirect("EmployeeServlet");
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                entityManager.close();
            }
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
