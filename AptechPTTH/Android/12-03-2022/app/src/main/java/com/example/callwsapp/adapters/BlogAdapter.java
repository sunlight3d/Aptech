package com.example.callwsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.callwsapp.R;
import com.example.callwsapp.models.Blog;
import com.example.callwsapp.models.Photo;

import java.util.ArrayList;

public class BlogAdapter extends BaseAdapter {
    private ArrayList<Blog> blogs;
    private Context context;
    public BlogAdapter(ArrayList<Blog> blogs, Context context) {
        super();
        this.blogs = blogs;
        this.context = context;
    }
    @Override
    public int getCount() {
        return blogs.size();
    }

    @Override
    public Object getItem(int position) {
        return blogs.get(position);
    }

    @Override
    public long getItemId(int i) {
        return blogs.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(this.context)
                .inflate(R.layout.gridview_blog_item, viewGroup, false);
        //Activity + Service
        //cac field khac ??
        return view;
    }
}
