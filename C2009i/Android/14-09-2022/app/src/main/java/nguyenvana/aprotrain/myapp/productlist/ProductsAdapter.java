package nguyenvana.aprotrain.myapp.productlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nguyenvana.aprotrain.myapp.R;
import nguyenvana.aprotrain.myapp.models.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private ArrayList<Product> products;
    private Context context;
    public ProductsAdapter(Context context, ArrayList<Product> products) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //convert from xml to object(PlaceViewHolder)
        View view = LayoutInflater.from(this.context).inflate(R.layout.product_item_view, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);

        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder viewHolder, int position) {
        //map data to UI
        Product selectedProduct = products.get(position);
        viewHolder.setProduct(selectedProduct);
        viewHolder.itemView.setBackgroundColor(
                position %2 ==0 ? 0xFFFF0000 : 0xFF00FF00);
        viewHolder.itemView.setOnClickListener((View view) -> {
            if(context instanceof ProductsActivity) {
                ((ProductsActivity) context).navigateToDetail(selectedProduct);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

