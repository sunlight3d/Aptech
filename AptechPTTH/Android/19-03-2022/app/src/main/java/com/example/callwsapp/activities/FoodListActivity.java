package com.example.callwsapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.Toast;

import com.example.callwsapp.R;
import com.example.callwsapp.adapters.FoodAdapter;
import com.example.callwsapp.adapters.MoviesAdapter;
import com.example.callwsapp.adapters.PhotoAdapter;
import com.example.callwsapp.models.Food;
import com.example.callwsapp.models.Movie;
import com.example.callwsapp.models.Photo;
import com.example.callwsapp.services.IPhotoServiceResponse;
import com.example.callwsapp.services.PhotoService;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {
    //Movie
    private ArrayList<Movie> movies = new ArrayList<>();
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerViewMovie;



    private RecyclerView recycleViewFoods;
    private FoodAdapter foodAdapter;
    private ArrayList<Food> foods = new ArrayList();
    //Horizontal or Vertical ?
    private RecyclerView.LayoutManager layoutManager;

    private void getFoods() {
        //call api later
        //mock
        foods.add(new Food(
                "sudhy",
                "this is Sushy Japana",
                123.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy11",
                "this is Sushy Japana11",
                234.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy33",
                "this is Sushy Japana33",
                44.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy44",
                "this is Sushy Japana",
                666.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy33",
                "this is Sushy Japana33",
                44.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy44",
                "this is Sushy Japana",
                666.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy33",
                "this is Sushy Japana33",
                44.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy44",
                "this is Sushy Japana",
                666.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy33",
                "this is Sushy Japana33",
                44.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );
        foods.add(new Food(
                "sudhy44",
                "this is Sushy Japana",
                666.0,
                "https://upload.wikimedia.org/wikipedia/commons/2/2a/Sasazushi.jpg")
        );

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list_activity);
        //Movie
        recyclerViewMovie = findViewById(R.id.recyclerViewMovies);

        moviesAdapter = new MoviesAdapter(movies);
        prepareMovieData();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewMovie.setLayoutManager(mLayoutManager);
        recyclerViewMovie.setItemAnimator(new DefaultItemAnimator());

        recyclerViewMovie.setAdapter(moviesAdapter);

        //Food
        recycleViewFoods = findViewById(R.id.recycleViewFoods);
        getFoods();
        foodAdapter = new FoodAdapter(this, foods);
        recycleViewFoods.setAdapter(foodAdapter);
        //Horizontal or Vertical ?
        layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recycleViewFoods.setLayoutManager(layoutManager);
    }
    private void prepareMovieData() {
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Cat-MaineCoon-Cookie.png/253px-Cat-MaineCoon-Cookie.png"));
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Cat-MaineCoon-Cookie.png/253px-Cat-MaineCoon-Cookie.png"));
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movies.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));

        moviesAdapter.notifyDataSetChanged();
    }
}