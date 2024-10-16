package nguyenvana.aprotrain.callapi;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import nguyenvana.aprotrain.callapi.pojo.Photo;

public class PhotoItemView extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textViewTitle;
    private TextView textViewDescription;
    private Photo photo;
    private Context context;
    //draw UI of PhotoItemView
    public PhotoItemView(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        imageView = itemView.findViewById(R.id.imageView);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        textViewDescription = itemView.findViewById(R.id.textViewDescription);
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        //fetch Data to UI
        Glide.with(this.context).load(photo.url).into(imageView);
        textViewTitle.setText(photo.title);
        textViewDescription.setText(
                String.format("albumId = %d, id = %d",
                photo.albumId, photo.id));

    }
}
