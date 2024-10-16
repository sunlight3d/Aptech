/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.de07.session;

import com.aptech.de07.jpa.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeFacade extends AbstractFacade<Employee>{
    @PersistenceContext(unitName = "com.aptech_de07_war_1.0-SNAPSHOTPU")
    private EntityManager entityManager;
    public EmployeeFacade(){
        super(Employee.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    public void Save(String employeeNo, String name, String placeOfWork, String phoneNo) {
        try {
           Employee employee = new Employee(employeeNo, name, placeOfWork, phoneNo);
           this.insert(employee);
        }catch(Exception e) {            
            System.err.println("Error insert data : "+e.getLocalizedMessage());
        }
    }
}
