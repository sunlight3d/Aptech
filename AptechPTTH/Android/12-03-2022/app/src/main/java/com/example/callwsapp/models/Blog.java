package com.example.callwsapp.models;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private int id;
    private String title;
    private String content;
    private Date createdAt;
    private String url;

    public Blog(int id, String title, String content, Date createdAt, String url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
