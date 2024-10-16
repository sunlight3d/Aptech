package com.aptech.androidclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.aptech.androidclient.adapters.ProductAdapter;
import com.aptech.androidclient.models.Product;
import com.aptech.androidclient.services.ProductApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button btnReload;
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private List<Product> fakedProducts = new ArrayList<>();
    private void generateFakeProductData() {
        fakedProducts.add(new Product(1, "p11", "d111", 123.3f, 10));
        fakedProducts.add(new Product(2, "p2", "d22", 123.3f, 10));
        fakedProducts.add(new Product(3, "p33", "d33", 123.3f, 10));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btnReload = findViewById(R.id.btnReload);
        btnReload.setOnClickListener((View view) -> {
            Toast.makeText(MainActivity.this, "Haha", Toast.LENGTH_LONG).show();
        });
        this.generateFakeProductData();
        listViewProducts = findViewById(R.id.listViewProducts);
        /*
        productAdapter = new ProductAdapter(this,fakedProducts);
        listViewProducts.setAdapter(productAdapter);
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:7020/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductApiService productApiService = retrofit.create(ProductApiService.class);

        Call<List<Product>> call = productApiService.getProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> productList = response.body();
                    //UI thread ?
                    productAdapter = new ProductAdapter(MainActivity.this,fakedProducts);
                    listViewProducts.setAdapter(productAdapter);
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Handle failure
                System.err.println("eeee");
            }
        });
        System.out.println("haha");
    }
}