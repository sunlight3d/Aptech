/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.de07.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sunli
 */
@Entity
@Table(name = "tblEmployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmployee.findAll", query = "SELECT t FROM TblEmployee t")
    , @NamedQuery(name = "TblEmployee.findByEmployeeNo", query = "SELECT t FROM TblEmployee t WHERE t.employeeNo = :employeeNo")
    , @NamedQuery(name = "TblEmployee.findByEmployeeName", query = "SELECT t FROM TblEmployee t WHERE t.employeeName = :employeeName")
    , @NamedQuery(name = "TblEmployee.findByPlaceOfWork", query = "SELECT t FROM TblEmployee t WHERE t.placeOfWork = :placeOfWork")
    , @NamedQuery(name = "TblEmployee.findByPhoneNo", query = "SELECT t FROM TblEmployee t WHERE t.phoneNo = :phoneNo")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EmployeeNo")
    private String employeeNo;
    @Size(max = 300)
    @Column(name = "EmployeeName")
    private String employeeName;
    @Size(max = 300)
    @Column(name = "PlaceOfWork")
    private String placeOfWork;
    @Size(max = 300)
    @Column(name = "PhoneNo")
    private String phoneNo;

    public Employee() {
    }
    public Employee(String employeeNo, String employeeName, String placeOfWork, String phoneNo) {
        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.placeOfWork = placeOfWork;
        this.phoneNo = phoneNo;        
    }

    public Employee(String employeeNo) {
        this.employeeNo = employeeNo;
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
        return "com.aptech.de07.jpa.TblEmployee[ employeeNo=" + employeeNo + " ]";
    }
    
}
