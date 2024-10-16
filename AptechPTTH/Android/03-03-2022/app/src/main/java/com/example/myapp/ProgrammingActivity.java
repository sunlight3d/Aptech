package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapp.models.Product;

public class ProgrammingActivity extends AppCompatActivity {
    private int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Product productA = new Product(1, "iphone X", 123.3);
        Toast.makeText(this,
                String.format("product's detail: %s", productA.toString()),
                Toast.LENGTH_LONG).show();
        setContentView(R.layout.programming_activity);
    }
}