/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.entities;

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
@Table(name = "tblBook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBook.findAll", query = "SELECT t FROM TblBook t")
    , @NamedQuery(name = "TblBook.findByBookcode", query = "SELECT t FROM TblBook t WHERE t.bookcode = :bookcode")
    , @NamedQuery(name = "TblBook.findByName", query = "SELECT t FROM TblBook t WHERE t.name = :name")
    , @NamedQuery(name = "TblBook.findByNickname", query = "SELECT t FROM TblBook t WHERE t.nickname = :nickname")
    , @NamedQuery(name = "TblBook.findByProducer", query = "SELECT t FROM TblBook t WHERE t.producer = :producer")
    , @NamedQuery(name = "TblBook.findByPrice", query = "SELECT t FROM TblBook t WHERE t.price = :price")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "bookcode")
    private String bookcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "name")
    private String name;
    @Size(max = 25)
    @Column(name = "nickname")
    private String nickname;
    @Size(max = 100)
    @Column(name = "producer")
    private String producer;
    @Column(name = "price")
    private Integer price;

    public Book() {
    }

    public Book(String bookcode) {
        this.bookcode = bookcode;
    }

    public Book(String bookcode, String name) {
        this.bookcode = bookcode;
        this.name = name;
    }

    public String getBookcode() {
        return bookcode;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookcode != null ? bookcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookcode == null && other.bookcode != null) || (this.bookcode != null && !this.bookcode.equals(other.bookcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.entities.TblBook[ bookcode=" + bookcode + " ]";
    }
    
}
