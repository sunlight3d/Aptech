package com.aptech.models;

import java.util.Date;

public class Exam {
    private int id;
    private String examName;
    private Date examDate;
    private int examDuration;
    private String examRoom;

    public Exam() {
    }
    public Exam(int id, String examName, Date examDate, int examDuration, String examRoom) {
        this.id = id;
        this.examName = examName;
        this.examDate = examDate;
        this.examDuration = examDuration;
        this.examRoom = examRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public String getExamRoom() {
        return examRoom;
    }

    public void setExamRoom(String examRoom) {
        this.examRoom = examRoom;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", examDate=" + examDate +
                ", examDuration=" + examDuration +
                ", examRoom='" + examRoom + '\'' +
                '}';
    }
}
