package com.app.aptech.models;

import com.google.gson.JsonObject;

public class Photo {
    private int id;
    private int albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo(int id, int albumId, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }
    public static Photo fromJson(JsonObject jsonObject) {
        int id = Integer.valueOf(jsonObject.get("id").toString());
        int albumId = Integer.valueOf(jsonObject.get("albumId").toString());
        String title = jsonObject.get("title").toString().substring(1);
        title = title.substring(0, title.length() - 1);
        String url = jsonObject.get("url").toString().substring(1);
        url = url.substring(0, url.length() - 1);
        String thumbnailUrl = jsonObject.get("thumbnailUrl").toString().substring(1);
        thumbnailUrl = thumbnailUrl.substring(0, thumbnailUrl.length() - 1);
        return new Photo(id, albumId, title, url, thumbnailUrl);
    }
    //convert from json object to Photo object
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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
