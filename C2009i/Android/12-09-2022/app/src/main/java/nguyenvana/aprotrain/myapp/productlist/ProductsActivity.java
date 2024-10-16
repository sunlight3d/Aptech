package nguyenvana.aprotrain.myapp.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.*;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;

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
    }
}