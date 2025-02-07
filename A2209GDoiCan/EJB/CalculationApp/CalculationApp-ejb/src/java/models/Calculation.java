/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "calculations", catalog = "calculator_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculation.findAll", query = "SELECT c FROM Calculation c"),
    @NamedQuery(name = "Calculation.findById", query = "SELECT c FROM Calculation c WHERE c.id = :id"),
    @NamedQuery(name = "Calculation.findByNum1", query = "SELECT c FROM Calculation c WHERE c.num1 = :num1"),
    @NamedQuery(name = "Calculation.findByNum2", query = "SELECT c FROM Calculation c WHERE c.num2 = :num2"),
    @NamedQuery(name = "Calculation.findByResult", query = "SELECT c FROM Calculation c WHERE c.result = :result"),
    @NamedQuery(name = "Calculation.findByCreatedAt", query = "SELECT c FROM Calculation c WHERE c.createdAt = :createdAt")})
public class Calculation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double num1;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double num2;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double result;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Calculation() {
    }

    public Calculation(Integer id) {
        this.id = id;
    }

    public Calculation(double num1, double num2, double result) {
        //this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculation)) {
            return false;
        }
        Calculation other = (Calculation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Calculation[ id=" + id + " ]";
    }
    
}
