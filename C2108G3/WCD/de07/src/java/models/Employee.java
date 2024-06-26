/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author hoangnd
 */
@Entity
@Table(name = "tblEmployee", catalog = "c2108g3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeNo", query = "SELECT e FROM Employee e WHERE e.employeeNo = :employeeNo"),
    @NamedQuery(name = "Employee.findByEmployeeName", query = "SELECT e FROM Employee e WHERE e.employeeName = :employeeName"),
    @NamedQuery(name = "Employee.findByPlaceOfWork", query = "SELECT e FROM Employee e WHERE e.placeOfWork = :placeOfWork"),
    @NamedQuery(name = "Employee.findByPhoneNo", query = "SELECT e FROM Employee e WHERE e.phoneNo = :phoneNo")})
    @NamedQuery(name = "Employee.checkExists", query = "SELECT COUNT(e) FROM Employee e WHERE e.employeeName = :name OR e.phoneNo = :phone")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeNo", nullable = false, length = 80)
    private String employeeNo;
    @Basic(optional = false)
    @Column(name = "employeeName", nullable = false, length = 100)
    private String employeeName;
    @Column(name = "placeOfWork", length = 100)
    private String placeOfWork;
    @Column(name = "phoneNo", length = 30)
    private String phoneNo;
    

    public Employee(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Employee(String employeeNo, String employeeName) {
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
    }
    public Employee(String employeeNo, String employeeName, String placeOfWork, String phoneNo) {
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.placeOfWork = placeOfWork;
        this.phoneNo = phoneNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeNo != null ? employeeNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeNo == null && other.employeeNo != null) || (this.employeeNo != null && !this.employeeNo.equals(other.employeeNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servlets.Employee[ employeeNo=" + employeeNo + " ]";
    }
    
}
