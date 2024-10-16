package com.example.callwsapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import com.example.callwsapp.R;
import com.example.callwsapp.adapters.BlogAdapter;
import com.example.callwsapp.adapters.PhotoAdapter;
import com.example.callwsapp.models.Blog;
import com.example.callwsapp.models.Photo;
import com.example.callwsapp.services.IPhotoServiceResponse;
import com.example.callwsapp.services.PhotoService;

import java.util.ArrayList;


public class GridViewActivity extends AppCompatActivity {
    private GridView gridView;
    private BlogAdapter blogAdapter;
    private ArrayList<Blog> blogs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_activity);
        gridView = findViewById(R.id.gridView);
        blogAdapter = new BlogAdapter(blogs, this);
        gridView.setAdapter(blogAdapter);
        //Sau khi bam vao tung phan tu cua GridView => Hien AlertDialog
    }
}