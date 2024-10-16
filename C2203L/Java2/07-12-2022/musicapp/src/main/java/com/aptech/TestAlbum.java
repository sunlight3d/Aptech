package com.aptech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestAlbum {
    public static void main(String[] args) {
        Artist tungDuong = new Artist("Tung Duong");
        Artist quangTho = new Artist("Quang Tho");
        Artist quangLe = new Artist("Quang Le");
        Artist nhuQuynh = new Artist("Nhu Quynh");
        List<Track> tracks1 = new ArrayList<Track>(List.of(
                new Track("Bai ca hi vong", 15000),
                new Track("Ao mua dong", 12000),
                new Track("Mau hoa do", 130),
                new Track("Que nha", 1500),
                new Track("Me yeu con", 12300)
        ));
        tracks1.forEach(new Consumer<Track>() {
            @Override
            public void accept(Track track) {

            }
        });
        List<Track> tracks2 = new ArrayList<Track>(List.of(
                new Track("Ha buon", 500),
                new Track("Vung la me bay", 1000),
                new Track("Noi buon hoa phuong", 134),
                new Track("Phuong hong", 10000)
        ));
        Album album1 = new Album("Tung Duong hat tinh ca",
                                tracks1, List.of(tungDuong, quangTho));
        Album album2 = new Album("Nhac vang hay nhat",
                tracks2, List.of(quangLe, nhuQuynh));

        int minViewCount = Integer.MAX_VALUE;
        int maxViewCount = Integer.MIN_VALUE;
        Track trackWithMinCount = null;
        Track trackWithMaxCount = null;
        for(Track track: tracks1) {
            if(track.getViewCount() < minViewCount) {
                minViewCount = track.getViewCount();
                trackWithMinCount = track;
            }
            if(track.getViewCount() > maxViewCount) {
                maxViewCount = track.getViewCount();
                trackWithMaxCount = track;
            }
        }
        for(Track track: tracks2) {
            if(track.getViewCount() < minViewCount) {
                minViewCount = track.getViewCount();
                trackWithMinCount = track;
            }
            if(track.getViewCount() > maxViewCount) {
                maxViewCount = track.getViewCount();
                trackWithMaxCount = track;
            }
        }
        if(trackWithMinCount != null) {
            System.out.println("Track with min view count: ");
            System.out.println(trackWithMinCount.toString());
        }
        if(trackWithMaxCount != null) {
            System.out.println("Track with max view count: ");
            System.out.println(trackWithMaxCount.toString());
        }


    }
}