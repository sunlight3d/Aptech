package nguyenvana.aprotrain.myapp.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.*;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import nguyenvana.aprotrain.myapp.DetailProductActivity;
import nguyenvana.aprotrain.myapp.R;
import nguyenvana.aprotrain.myapp.models.Product;

public class ProductsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Product> products = new ArrayList<>();
    private ProductsAdapter productsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity);
        recyclerView = findViewById(R.id.recyclerView);
        generateFakeData();
        LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        productsAdapter = new ProductsAdapter(this, products);
        recyclerView.setAdapter(productsAdapter);
        testSaveLocalStorage();
    }
    private void testSaveLocalStorage(){
        SharedPreferences sharedPref = this.getSharedPreferences("savedUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", "hoang");
        editor.putInt("age", 18);
        editor.apply();
        //sharedPref.getString("username", "")
        //sharedPref.getInt("age", 0)
    }
    public void navigateToDetail(Product selectedProduct){
        Toast.makeText(this, String.format("You pressed %s",
                        selectedProduct.getName()),
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DetailProductActivity.class);
        intent.putExtra("detailProduct", selectedProduct);
        startActivity(intent);
    }
    private void generateFakeData() {
        //fake data
        products.add(new Product(1, "iphone xxx",
                "This is iphone xx",
                new Date(),
                100,
                200,
                "heavy"
        ));
        products.add(new Product(1, "iphone xxx",
                "This is iphone xx",
                new Date(),
                67,
                89,
                "light"
        ));
        products.add(new Product(1, "iphone xxx",
                "This is iphone xx",
                new Date(),
                30,
                100,
                "straight"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));
        products.add(new Product(1, "iphone 21dsdsd",
                "This is ewewew xx",
                new Date(),
                200,
                500,
                "something"
        ));


    }
}