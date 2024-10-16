/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author w11
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT b FROM Students b")
    , @NamedQuery(name = "Students.findById", query = "SELECT b FROM Students b WHERE b.id = :id")
    , @NamedQuery(name = "Students.findByStudentName", query = "SELECT b FROM Students b WHERE b.fullName = :fullName")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer rollNumber;
    @Size(max = 150)
    @Column(name = "fullName")
    private String fullName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String email;
    
    @Column(name = "age")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(Integer id) {
        this.rollNumber = id;
    }

    public Integer getId() {
        return rollNumber;
    }

    public void setId(Integer id) {
        this.rollNumber = id;
    }

    public String getStudentName() {
        return fullName;
    }

    public void setStudentName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return email;
    }

    public void setDescription(String description) {
        this.email = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rollNumber != null ? rollNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the rollNumber fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.rollNumber == null && other.rollNumber != null) || (this.rollNumber != null && !this.rollNumber.equals(other.rollNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Students[ id=" + rollNumber + " ]";
    }
    
}
