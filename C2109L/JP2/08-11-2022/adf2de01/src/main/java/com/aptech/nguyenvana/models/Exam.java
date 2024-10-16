package com.aptech.nguyenvana.models;

import java.util.Date;

public class Exam {
    private long id;
    private String name;
    private Date date;
    private Integer duration;
    private String room;

    //no-args constructor
    public Exam() {}
    public Exam(long    id,
                String  name,
                Date    date,
                Integer duration,
                String  room) {
        this.id         = id;
        this.name       = name;
        this.date       = date;
        this.duration   = duration;
        this.room       = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
