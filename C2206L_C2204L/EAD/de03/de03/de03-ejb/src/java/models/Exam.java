/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author hoangnd
 */
@Entity
@Table(catalog = "examination", schema = "")
@NamedQueries({
    @NamedQuery(name = "Exams.findAll", query = "SELECT e FROM Exams e"),
    @NamedQuery(name = "Exams.findById", query = "SELECT e FROM Exams e WHERE e.id = :id"),
    @NamedQuery(name = "Exams.findByName", query = "SELECT e FROM Exams e WHERE e.name = :name"),
    @NamedQuery(name = "Exams.findByDuration", query = "SELECT e FROM Exams e WHERE e.duration = :duration"),
    @NamedQuery(name = "Exams.findByDescription", query = "SELECT e FROM Exams e WHERE e.description = :description"),
    @NamedQuery(name = "Exams.findByCreatedAt", query = "SELECT e FROM Exams e WHERE e.createdAt = :createdAt"),
    @NamedQuery(name = "Exams.findByUpdatedAt", query = "SELECT e FROM Exams e WHERE e.updatedAt = :updatedAt")})
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String name;
    private Integer duration;
    private String description;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(mappedBy = "examId")
    private Collection<ExamAttendance> examAttendanceCollection;

    public Exam() {
    }

    public Exam(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Exams[ id=" + id + " ]";
    }
    
}
