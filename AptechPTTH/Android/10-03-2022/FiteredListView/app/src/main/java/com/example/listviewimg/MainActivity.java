package com.example.listviewimg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.listviewimg.adapters.ProductAdapter;
import com.example.listviewimg.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Product> products;
    private ProductAdapter customAdapter;

    private void getProducts() {
        //sau nay co the goi web service tai day !
        //fake data
        products = products == null ? new ArrayList<>() : products; //lazy init
        products.add(new Product("Apple", "This is apple", R.drawable.apple));
        products.add(new Product("Banana", "This is banana", R.drawable.banana));
        products.add(new Product("Kiwi", "This is kiwi", R.drawable.kiwi));
        products.add(new Product("Lemon", "This is lemon", R.drawable.lemon));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        getProducts(); //get from web services(.net web api,Java Spring, free web service, NOT SOAP)
        //free WS: https://jsonplaceholder.typicode.com/todos
        customAdapter = new ProductAdapter(products,this);
        listView.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                customAdapter.getFilter().filter(s);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.search_view){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}