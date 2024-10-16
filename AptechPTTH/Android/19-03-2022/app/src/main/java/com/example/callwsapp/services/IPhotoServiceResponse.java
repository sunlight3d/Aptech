package com.example.callwsapp.services;

import com.example.callwsapp.models.Photo;

import java.util.ArrayList;

public interface IPhotoServiceResponse {
    public void getPhotos(ArrayList<Photo> photos, String error);
}

