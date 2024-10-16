/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sunli
 */
@Entity
@Table(name = "tblAuthor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAuthor.findAll", query = "SELECT t FROM TblAuthor t")
    , @NamedQuery(name = "TblAuthor.findByNickname", query = "SELECT t FROM TblAuthor t WHERE t.nickname = :nickname")
    , @NamedQuery(name = "TblAuthor.findByFullname", query = "SELECT t FROM TblAuthor t WHERE t.fullname = :fullname")
    , @NamedQuery(name = "TblAuthor.findByBirthday", query = "SELECT t FROM TblAuthor t WHERE t.birthday = :birthday")
    , @NamedQuery(name = "TblAuthor.findByAddress", query = "SELECT t FROM TblAuthor t WHERE t.address = :address")})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Size(max = 200)
    @Column(name = "address")
    private String address;

    public Author() {
    }

    public Author(String nickname) {
        this.nickname = nickname;
    }

    public Author(String nickname, String fullname) {
        this.nickname = nickname;
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.entities.TblAuthor[ nickname=" + nickname + " ]";
    }
    
}
