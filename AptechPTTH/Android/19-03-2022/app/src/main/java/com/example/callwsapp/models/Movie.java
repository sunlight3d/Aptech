package com.example.callwsapp.models;

public class Movie {
    private String title, genre, year, url;
    //private String title, genre, year;

    public Movie() {
    }

    public Movie(String title, String genre, String year, String url) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
