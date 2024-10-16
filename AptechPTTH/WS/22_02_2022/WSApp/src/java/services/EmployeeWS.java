/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.*;
import models.Employee;

@WebService(serviceName = "EmployeeWS")
public class EmployeeWS {   
    //@PersistenceContext(unitName = "WSAppPU")
    private EntityManager entityManager = Persistence.createEntityManagerFactory("WSAppPU")
                .createEntityManager();
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {        
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "findAll")
    public java.util.List<Employee> findAll() {
        //HashMap<String, Object> result = new HashMap<>();        
        java.util.List<Employee> employees = new ArrayList<Employee>();
        try {
            Query query = entityManager.createNamedQuery("Employee.findAll", Employee.class);
            employees = query.getResultList();
            return employees;            
        } catch(Exception e) {
            return employees;
        }        
    }
    
    @WebMethod(operationName = "insertEmployee")
    public Employee insertEmployee(
            @WebParam(name = "employeeNo") String employeeNo,
            @WebParam(name = "employeeName") String employeeName,
            @WebParam(name = "placeOfWork") String placeOfWork,
            @WebParam(name = "phoneNo") String phoneNo) {        
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Employee newEmployee = new Employee(employeeNo, employeeName, placeOfWork, phoneNo);            
            entityManager.persist(newEmployee);
            entityTransaction.commit();
            return newEmployee;
        } catch(Exception e) {
            return null;
        }        
    }
    @WebMethod(operationName = "updateEmployee")
    public Employee updateEmployee(
            @WebParam(name = "employeeNo") String employeeNo,
            @WebParam(name = "employeeName") String employeeName,
            @WebParam(name = "placeOfWork") String placeOfWork,
            @WebParam(name = "phoneNo") String phoneNo) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            Query query = entityManager.createNamedQuery("Employee.findByEmployeeNo", Employee.class);
            query.setParameter(1, employeeNo);
            Employee employee = (Employee) query.getSingleResult();
            if(employee != null) {                                
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                employee.setEmployeeName(employeeName != null ? employeeName : employee.getEmployeeName());
                employee.setPlaceOfWork(placeOfWork != null ? placeOfWork : employee.getPlaceOfWork());
                employee.setPhoneNo(phoneNo != null ? phoneNo : employee.getPhoneNo());                                
                entityManager.persist(employee);
                entityTransaction.commit();            
                return employee;
            } else {
                return null;
            }                             
        } catch(Exception e) {
            return null;   
        }        
    }
    @WebMethod(operationName = "deleteEmployee")
    public int deleteEmployee(
            @WebParam(name = "employeeNo") String employeeNo) {        
        try {
            Query query = entityManager.createNamedQuery("Employee.findByEmployeeNo", Employee.class);
            query.setParameter("employeeNo", employeeNo);
            Employee employee = (Employee) query.getSingleResult();            
            if(employee != null) {
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                entityManager.remove(employee);
                entityTransaction.commit();                            
            }                                                                        
            return 1;            
        } catch(Exception e) {
            return 0;
        }        
    }   
}
