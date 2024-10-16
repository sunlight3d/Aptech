package com.example.callwsapp.models;

import org.json.JSONObject;

import java.io.Serializable;

public class Photo implements Serializable {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo(int albumId, int id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }
    public static Photo getFromJSONObject(JSONObject jsonObject) throws Exception{
        //validate HERE !
        try {
            Integer albumId = jsonObject.getInt("albumId");
            Integer id = jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            String url = jsonObject.getString("url");
            String thumbnailUrl = jsonObject.getString("thumbnailUrl");
            return new Photo(albumId, id, title, url, thumbnailUrl);
        }catch (Exception e) {
            throw e;
        }
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
