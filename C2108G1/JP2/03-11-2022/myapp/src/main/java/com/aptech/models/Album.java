package com.aptech.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Album {
    private String name;
    private List<Track> tracks = new ArrayList<Track>();//eager
    //private List<Track> tracks;//lazy
    private List<Artist> musicians = new ArrayList<Artist>();
    public Album() {

    }

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        //return tracks == null ? new ArrayList<Track>() : tracks;//lazy init
        return tracks;//eager init
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
}
