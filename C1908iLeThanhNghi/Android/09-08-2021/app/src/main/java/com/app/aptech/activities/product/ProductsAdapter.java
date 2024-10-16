package com.app.aptech.activities.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.aptech.R;
import com.app.aptech.models.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter {
    private List<Product> products;
    private ProductListActivity activity;
    ProductViewItem productViewItem;
    ProductsAdapter(List<Product> products) {
        this.products = products;
    }
    @NonNull
    @Override
    public ProductViewItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //get object from UI(getElementById trong html)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        this.productViewItem = new ProductViewItem(view);
        return productViewItem;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        productViewItem.setProduct(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();

    }
}
