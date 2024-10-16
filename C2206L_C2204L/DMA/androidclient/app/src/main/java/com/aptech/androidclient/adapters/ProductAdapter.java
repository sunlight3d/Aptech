package com.aptech.androidclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aptech.androidclient.R;
import com.aptech.androidclient.models.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    //adapter is bridge between UI and Data
    private Context context;
    private List<Product> products;
    public ProductAdapter(@NonNull Context context, List<Product> products) {
        super(context, 0, products);
        this.context = context;//ref to screen(Activity)
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        }

        Product currentProduct = products.get(position);

        TextView textViewName = listItem.findViewById(R.id.textViewName);
        textViewName.setText(currentProduct.getName());
        TextView textViewPrice = listItem.findViewById(R.id.textViewPrice);
        textViewPrice.setText(String.valueOf(currentProduct.getPrice()));

        return listItem;
        //return super.getView(position, convertView, parent);

    }
}
