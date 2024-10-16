package com.app.aptech.activities.product;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.aptech.R;
import com.app.aptech.models.Product;
import com.squareup.picasso.Picasso;

public class ProductViewItem extends RecyclerView.ViewHolder{
    private ImageView imageViewProduct;
    private TextView txtProductName;
    private TextView txtProductDescription;
    private TextView txtPrice;
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
        Picasso.get().load(product.getUrl()).into(this.imageViewProduct);
        this.txtProductName.setText(product.getProductName());
        this.txtProductDescription.setText(product.getDescription());
        this.txtPrice.setText(String.format("%.1f $", product.getPrice()));
    }

    public ProductViewItem(@NonNull View view) {
        //lay tren UI
        super(view);
        imageViewProduct = view.findViewById(R.id.imageViewProduct);
        txtProductName = view.findViewById(R.id.txtProductName);
        txtProductDescription = view.findViewById(R.id.txtProductDescription);
        txtPrice = view.findViewById(R.id.txtPrice);
    }
}
