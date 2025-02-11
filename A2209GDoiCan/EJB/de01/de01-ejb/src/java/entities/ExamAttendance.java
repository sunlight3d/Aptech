/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangnd
 */
@Entity
@Table(name = "exam_attendance", catalog = "exam_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamAttendance.findAll", query = "SELECT e FROM ExamAttendance e"),
    @NamedQuery(name = "ExamAttendance.findById", query = "SELECT e FROM ExamAttendance e WHERE e.id = :id")})
public class ExamAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    @ManyToOne
    private Exam examId;
    @JoinColumn(name = "scheduler_id", referencedColumnName = "id")
    @ManyToOne
    private Schedule schedulerId;
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

    public Schedule getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Schedule schedulerId) {
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
        return "entities.ExamAttendance[ id=" + id + " ]";
    }
    
}
