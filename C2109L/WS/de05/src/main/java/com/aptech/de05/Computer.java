/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aptech.de05;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author hoangnd
 */
@Entity
@Table(name = "tblComputer", catalog = "de05", schema = "")
@NamedQueries({
    @NamedQuery(name = "Computer.findAll", query = "SELECT c FROM Computer c"),
    @NamedQuery(name = "Computer.findById", query = "SELECT c FROM Computer c WHERE c.id = :id"),
    @NamedQuery(name = "Computer.findByName", query = "SELECT c FROM Computer c WHERE c.name = :name"),
    @NamedQuery(name = "Computer.findByPrice", query = "SELECT c FROM Computer c WHERE c.price = :price"),
    @NamedQuery(name = "Computer.findByManufacturer", query = "SELECT c FROM Computer c WHERE c.manufacturer = :manufacturer")})
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String id;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12, scale = 0)
    private Float price;
    @Column(length = 30)
    private String manufacturer;

    public Computer() {
    }

    public Computer(String id) {
        this.id = id;
    }

    public Computer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
        if (!(object instanceof Computer)) {
            return false;
        }
        Computer other = (Computer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.de05.Computer[ id=" + id + " ]";
    }
    
}
