package com.example.callwsapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.callwsapp.R;
import com.example.callwsapp.adapters.PhotoAdapter;
import com.example.callwsapp.models.Photo;

import java.util.ArrayList;
//ListView
public class PhotoListActivity extends AppCompatActivity {
    private ListView listViewPhotos;
    private ArrayList<Photo> photos = new ArrayList<Photo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_activity);
        listViewPhotos = findViewById(R.id.listViewPhotos);
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        listViewPhotos.setAdapter(new PhotoAdapter(photos));
        //Activity call service
    }
}