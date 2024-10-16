package com.aptech;

import com.aptech.models.Album;
import com.aptech.models.Artist;
import com.aptech.models.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class AlbumManagement {
    private List<Album> albums = new ArrayList<Album>();
    public List<Album> initiateAlbumnList() {
        albums.clear();
        albums.add(new Album(
                "Tùng Dương Hát Tình Ca",
                (List<Track>)Arrays.asList(new Track[] {
                        new Track("Bai ca hy vong", 15000),
                        new Track("Ao mua dong", 12000),
                        new Track("Mau hoa do", 130),
                        new Track("Que nha", 1500),
                        new Track("Me yeu con", 12300)
                }),
                (List<Artist>)Arrays.asList(new Artist[] {
                        new Artist("Tung Duong"),
                        new Artist("Quang Tho")
                })));

        albums.add(new Album(
                "Nhac vang hay nhat ve mua Ha",
                (List<Track>)Arrays.asList(new Track[] {
                        new Track("Ha Buon", 500),
                        new Track("Vung la me bay", 1000),
                        new Track("Noi buon hoa Phuong", 134),
                        new Track("Phuong hong", 10000),
                }),
                (List<Artist>)Arrays.asList(new Artist[] {
                        new Artist("Quang Le"),
                        new Artist("Nhu Quynh")
                })));
        return albums;
    }
    private List<Track> getAllTracks() {
        List<Track> allTracks = new ArrayList<Track>();
        albums.forEach((Album album) -> {
            album.getTracks().forEach((Track track) -> {
                allTracks.add(track);
            });
        });
        return allTracks;
    }
    public Track getMaxViewCount() {
        List<Track> allTracks = getAllTracks();
        int maxViewCount = allTracks.stream()
                .mapToInt((Track track) -> track.getViewCount())
                .max().getAsInt();
        return allTracks.stream()
                .filter((Track track) -> track.getViewCount() == maxViewCount)
                .findFirst()
                .get();

    }
    public Track getMinViewCount() {
        List<Track> allTracks = getAllTracks();
        int minViewCount = allTracks.stream()
                .mapToInt((Track track) -> track.getViewCount())
                .min().getAsInt();
        return allTracks.stream()
                .filter((Track track) -> track.getViewCount() == minViewCount)
                .findFirst()
                .get();

    }
}
