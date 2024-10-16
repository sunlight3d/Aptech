package com.example.callwsapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.callwsapp.R;
import com.example.callwsapp.adapters.PhotoAdapter;
import com.example.callwsapp.models.Photo;
import com.example.callwsapp.services.IPhotoServiceResponse;
import com.example.callwsapp.services.PhotoService;

import java.util.ArrayList;

//ListView
public class PhotoListActivity extends AppCompatActivity {
    private ListView listViewPhotos;
    private ArrayList<Photo> photos = new ArrayList<Photo>();
    private PhotoService photoService = new PhotoService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_activity);
        listViewPhotos = findViewById(R.id.listViewPhotos);
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
//        photos.add(new Photo(1, 1, "dsmikfjdfjdijfg", "hfdujdhfdhfhdhfu","mdjmdmd"));
        //Activity call "service"
        photoService.getPhotos(new IPhotoServiceResponse() {
            @Override
            public void getPhotos(ArrayList<Photo> photos, String error) {

                Log.d("ddd", "dsjmdjsd");
                //objectA send DATA to objectB => su dung interface
                //get photos HERE !
                runOnUiThread(new Runnable() {
                    public void run() {
                        listViewPhotos.setAdapter(new PhotoAdapter(photos));
                    }
                });


            }
        });
        //array of photos must be FILLED HERE !
        //solve => photoService send finished DATA to PhotoListActivity

        //Activity call service
    }
}