/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.de07.session;

import com.aptech.de07.jpa.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class EmployeeFacade extends AbstractFacade<Employee>{    
    public EmployeeFacade(){
        super(Employee.class);
    }    
    public void insert(String employeeNo, String name, String placeOfWork, String phoneNo) {
        try {
           Employee employee = new Employee(employeeNo, name, placeOfWork, phoneNo);           
           EntityManager entityManager = getEntityManager();   
           entityManager.getTransaction().begin();  
           entityManager.persist(employee);           
           entityManager.getTransaction().commit();                         
        }catch(Exception e) {     
            System.err.println("haha");
            System.err.println("Error insert data : "+e.getLocalizedMessage());
        }
    }
    public List<Employee> getAllEmployees() {
        Query query = getEntityManager().createNamedQuery("TblEmployee.findAll");
        List<Employee> employees = query.getResultList(); 
        return employees;
    }
}
