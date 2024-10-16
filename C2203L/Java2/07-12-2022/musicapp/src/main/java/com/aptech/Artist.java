package com.aptech;

public class Artist {
    private String name;

    public Artist() {}
    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                '}';
    }
}
