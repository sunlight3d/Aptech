/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author hoangnd
 */
@Entity
@Table(name = "exam_attendance", catalog = "examination", schema = "")
@NamedQueries({
    @NamedQuery(name = "ExamAttendance.findAll", query = "SELECT e FROM ExamAttendance e"),
    @NamedQuery(name = "ExamAttendance.findById", query = "SELECT e FROM ExamAttendance e WHERE e.id = :id")})
public class ExamAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    @ManyToOne
    private Exam examId;
    @JoinColumn(name = "scheduler_id", referencedColumnName = "id")
    @ManyToOne
    private Scheduler schedulerId;
    @JoinColumn(name = "student_roll_no", referencedColumnName = "roll_no")
    @ManyToOne
    private Student studentRollNo;

    public ExamAttendance() {
    }

    public ExamAttendance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }

    public Scheduler getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Scheduler schedulerId) {
        this.schedulerId = schedulerId;
    }

    public Student getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(Student studentRollNo) {
        this.studentRollNo = studentRollNo;
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
        if (!(object instanceof ExamAttendance)) {
            return false;
        }
        ExamAttendance other = (ExamAttendance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ExamAttendance[ id=" + id + " ]";
    }
    
}
