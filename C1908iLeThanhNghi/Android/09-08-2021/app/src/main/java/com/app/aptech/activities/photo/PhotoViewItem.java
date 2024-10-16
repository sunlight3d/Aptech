package com.app.aptech.activities.photo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.aptech.R;
import com.app.aptech.models.Photo;
import com.squareup.picasso.Picasso;

public class PhotoViewItem extends RecyclerView.ViewHolder{
    private ImageView imageViewPhoto;
    private TextView txtTitle;
    private TextView txtAlbumId;
    private Photo photo;

    public void setPhoto(Photo photo) {
        this.photo = photo;
        Picasso.get().load(photo.getUrl()).into(this.imageViewPhoto);
        this.txtTitle.setText(photo.getTitle());
        this.txtAlbumId.setText(String.format("%s", photo.getAlbumId()));
    }

    public PhotoViewItem(@NonNull View view) {
        super(view);
        imageViewPhoto = view.findViewById(R.id.imageViewPhoto);
        txtTitle = view.findViewById(R.id.txtTitle);
        txtAlbumId = view.findViewById(R.id.txtAlbumId);
    }
}
