package com.app.aptech.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.aptech.R;
public class ProductListActivity extends AppCompatActivity implements IActivity {
    private ImageButton btnBack;
    private TextView txtTitle;
    private RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_activity);
        getSupportActionBar().hide();
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        btnBack = findViewById(R.id.btnBack);
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("List of products");
        recyclerview = findViewById(R.id.recyclerview);
    }

    @Override
    public void setupActions() {
        btnBack.setOnClickListener((View v) -> {
            ProductListActivity.this.onBackPressed();
        });
    }
}