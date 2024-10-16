package com.app.aptech.activities.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.aptech.R;
import com.app.aptech.activities.IActivity;
import com.app.aptech.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity implements IActivity {
    private ImageButton btnBack;
    private TextView txtTitle;
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    //data
    private List<Product> products = new ArrayList<Product>();
    public void createFakeProducts() {
        this.products.clear();
        //load photo list
        //https://jsonplaceholder.typicode.com/photos
        //Retrofit / okhttp
        this.products.add(
                new Product(1,
                        "iphone 3",
                        "this is iphone 3",
                        111,
                        2013,
                        "https://static.chotot.com/storage/chotot-kinhnghiem/c2c/2021/01/iPhone-3-ra-doi-nam-nao-04.jpg"
                        ));
        this.products.add(
                new Product(2,
                        "iphone 4",
                        "this is iphone 4",
                        222,
                        2014,
                        "https://htsmart.vn/wp-content/uploads/2019/03/history-iphone-4-hero.jpg"
                ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_activity);
        getSupportActionBar().hide();
        createFakeProducts();
        setupUI();
        setupActions();

    }

    @Override
    public void setupUI() {
        btnBack = findViewById(R.id.btnBack);
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("List of products");

        recyclerview = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getApplicationContext(),LinearLayoutManager.VERTICAL, false
        );
        recyclerview.setLayoutManager(layoutManager);
        adapter = new ProductsAdapter(products);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void setupActions() {
        btnBack.setOnClickListener((View v) -> {
            ProductListActivity.this.onBackPressed();
        });
    }
}