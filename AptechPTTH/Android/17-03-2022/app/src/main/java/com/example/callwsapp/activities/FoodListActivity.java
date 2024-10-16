package com.example.callwsapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
import com.example.callwsapp.adapters.PhotoAdapter;
import com.example.callwsapp.models.Food;
import com.example.callwsapp.models.Photo;
import com.example.callwsapp.services.IPhotoServiceResponse;
import com.example.callwsapp.services.PhotoService;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {
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
        recycleViewFoods = findViewById(R.id.recycleViewFoods);
        getFoods();
        foodAdapter = new FoodAdapter(this, foods);
        recycleViewFoods.setAdapter(foodAdapter);
        //Horizontal or Vertical ?
        layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recycleViewFoods.setLayoutManager(layoutManager);
    }
}