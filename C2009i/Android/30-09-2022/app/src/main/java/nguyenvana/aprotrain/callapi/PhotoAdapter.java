package nguyenvana.aprotrain.callapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nguyenvana.aprotrain.callapi.pojo.Photo;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoItemView> {
    private ArrayList<Photo> photos;//NOT init here

    public PhotoAdapter(ArrayList<Photo> photos) {
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotoItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.photo_item_view, viewGroup, false);

        return new PhotoItemView(view,viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoItemView photoItemView, int position) {
        Photo photo = this.photos.get(position);
        photoItemView.setPhoto(photo);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }
}
