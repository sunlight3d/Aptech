package com.example.callwsapp.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.callwsapp.R;
import com.example.callwsapp.models.Food;

public class FoodItemView extends RecyclerView.ViewHolder {
    private TextView textViewFoodName;
    private TextView textViewDescription;
    private TextView textViewPrice;
    private ImageView imageViewFood;
    private Food food;

    public void setFood(Food food) {
        this.food = food;
        //data change => UI update
        textViewFoodName.setText(food.getFoodName());
        textViewDescription.setText(food.getDescription());
        textViewPrice.setText(String.format("$ %f", food.getPrice()));
        //imageViewFood => using Picasso
    }

    public Food getFood() {
        return food;
    }

    public FoodItemView(@NonNull View itemView) {
        super(itemView);
        //itemView = inflated from xml
        textViewFoodName = itemView.findViewById(R.id.textViewFoodName);
        textViewDescription = itemView.findViewById(R.id.textViewDescription);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        imageViewFood = itemView.findViewById(R.id.imageViewFood);
    }
}
