package com.app.aptech.activities.photo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.aptech.R;
import com.app.aptech.activities.photo.PhotoListActivity;
import com.app.aptech.activities.photo.PhotoViewItem;
import com.app.aptech.models.Photo;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter {
    private List<Photo> photos;

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    PhotoViewItem photoViewItem;
    PhotosAdapter(List<Photo> photos) {
        this.photos = photos;
    }
    @NonNull
    @Override
    public PhotoViewItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //get object from UI(getElementById trong html)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_item, parent, false);
        this.photoViewItem = new PhotoViewItem(view);
        return photoViewItem;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        photoViewItem.setPhoto(photos.get(position));
    }

    @Override
    public int getItemCount() {
        return photos.size();

    }
}
