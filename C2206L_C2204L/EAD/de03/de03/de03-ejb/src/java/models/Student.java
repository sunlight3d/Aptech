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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author hoangnd
 */
@Entity
@Table(catalog = "examination", schema = "")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByRollNo", query = "SELECT s FROM Students s WHERE s.rollNo = :rollNo"),
    @NamedQuery(name = "Students.findByFullName", query = "SELECT s FROM Students s WHERE s.fullName = :fullName"),
    @NamedQuery(name = "Students.findByClassName", query = "SELECT s FROM Students s WHERE s.className = :className")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roll_no")
    private String rollNo;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "class_name")
    private String className;
    @OneToMany(mappedBy = "studentRollNo")
    private Collection<ExamAttendance> examAttendanceCollection;

    public Student() {
    }

    public Student(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Collection<ExamAttendance> getExamAttendanceCollection() {
        return examAttendanceCollection;
    }

    public void setExamAttendanceCollection(Collection<ExamAttendance> examAttendanceCollection) {
        this.examAttendanceCollection = examAttendanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rollNo != null ? rollNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.rollNo == null && other.rollNo != null) || (this.rollNo != null && !this.rollNo.equals(other.rollNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Students[ rollNo=" + rollNo + " ]";
    }
    
}
