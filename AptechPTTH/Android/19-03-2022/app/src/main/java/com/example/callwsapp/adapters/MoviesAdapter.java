package com.example.callwsapp.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.callwsapp.R;
import com.example.callwsapp.models.Movie;
import com.example.callwsapp.views.MovieListItem;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MovieListItem> {

    private ArrayList<Movie> movies;
    public MoviesAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_item, parent, false);
        return new MovieListItem(itemView);
    }

    //String url = "https://www.facebook.com/images/fb_icon_325x325.png";
    @Override
    public void onBindViewHolder(MovieListItem movieListItem, int position) {
        movieListItem.setMovie(movies.get(position));
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }
}
