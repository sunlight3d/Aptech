package com.aptech;

import com.aptech.models.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Artist tungDuong = new Artist("Tung Duong");
        Artist quangTho = new Artist("Quang Tho");
        Artist quangLe = new Artist("Quang Le");
        Artist nhuQuynh = new Artist("Nhu Quynh");

        //List<Track> track1 = new ArrayList<Track>();
        //track1.add(new Track("Bai ca hi vong", 12000));
        List<Track> tracks1 = Arrays.asList(
                new Track("Bai ca hi vong", 15000),
                new Track("Ao mua dong", 12000),
                new Track("Ao mua dong", 130),
                new Track("Que nha", 1500),
                new Track("Me yeu con", 12300)
        );
        List<Track> tracks2 = Arrays.asList(
                new Track("Ha buon", 500),
                new Track("Vung la me bay", 1000),
                new Track("Noi buon hoa phuong", 134),
                new Track("Phuong hong", 10000)
        );
        Album album1 = new Album("Tung Duong hat tinh ca");
        album1.setTracks(tracks1);
        album1.getMusicians().add(tungDuong);
        album1.getMusicians().add(quangLe);

        Album album2 = new Album("nhac vang hay nhat");

        album2.setTracks(tracks2);
        album2.getMusicians().add(quangLe);
        album2.getMusicians().add(nhuQuynh);

        int minCount = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;
        for (Track track: tracks1){
            minCount = track.getViewCount() < minCount ? track.getViewCount() : minCount;
            maxCount = track.getViewCount() > maxCount ? track.getViewCount() : maxCount;
        }
        for (Track track: tracks2){
            minCount = track.getViewCount() < minCount ? track.getViewCount() : minCount;
            maxCount = track.getViewCount() > maxCount ? track.getViewCount() : maxCount;
        }
        int finalMinCount = minCount;
        Track minCountTrack = ((Optional<Track>)Stream
                .concat(tracks1.stream(), tracks2.stream())
                .filter((Track track) -> track.getViewCount() == finalMinCount)
                .findFirst())
                .get();
        int finalMaxCount = maxCount;
        Track maxCountTrack = ((Optional<Track>)Stream
                .concat(tracks1.stream(), tracks2.stream())
                .filter((Track track) -> track.getViewCount() == finalMaxCount)
                .findFirst())
                .get();
        System.out.println("Track with minCount : "+minCountTrack.toString());
        System.out.println("Track with maxCount : "+maxCountTrack.toString());

        Numbers numbers = new Numbers();
        numbers.createFile();
        numbers.writeDataToFile();
        OddEven oddEven = new OddEven();
        oddEven.doQuestion3();
    }
}