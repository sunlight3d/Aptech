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
    @NamedQuery(name = "Schedulers.findAll", query = "SELECT s FROM Schedulers s"),
    @NamedQuery(name = "Schedulers.findById", query = "SELECT s FROM Schedulers s WHERE s.id = :id"),
    @NamedQuery(name = "Schedulers.findByTimeSlot", query = "SELECT s FROM Schedulers s WHERE s.timeSlot = :timeSlot"),
    @NamedQuery(name = "Schedulers.findByLocation", query = "SELECT s FROM Schedulers s WHERE s.location = :location"),
    @NamedQuery(name = "Schedulers.findByExamSitter", query = "SELECT s FROM Schedulers s WHERE s.examSitter = :examSitter"),
    @NamedQuery(name = "Schedulers.findByStartAt", query = "SELECT s FROM Schedulers s WHERE s.startAt = :startAt"),
    @NamedQuery(name = "Schedulers.findByEndAt", query = "SELECT s FROM Schedulers s WHERE s.endAt = :endAt")})
public class Scheduler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "time_slot")
    private String timeSlot;
    private String location;
    @Column(name = "exam_sitter")
    private String examSitter;
    @Column(name = "start_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startAt;
    @Column(name = "end_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endAt;
    @OneToMany(mappedBy = "schedulerId")
    private Collection<ExamAttendance> examAttendanceCollection;

    public Scheduler() {
    }

    public Scheduler(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExamSitter() {
        return examSitter;
    }

    public void setExamSitter(String examSitter) {
        this.examSitter = examSitter;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
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
        if (!(object instanceof Scheduler)) {
            return false;
        }
        Scheduler other = (Scheduler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Schedulers[ id=" + id + " ]";
    }
    
}
