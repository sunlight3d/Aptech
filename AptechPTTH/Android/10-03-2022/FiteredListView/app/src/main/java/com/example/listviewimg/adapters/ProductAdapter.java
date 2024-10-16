package com.example.listviewimg.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewimg.models.Product;
import com.example.listviewimg.R;

import java.util.ArrayList;
import java.util.List;
/*
Diem nhan quan trong nhat cua bai nay:
 ProductAdapter extends BaseAdapter implements Filterable
 BIEN ListView => filtered ListView
* */
public class ProductAdapter extends BaseAdapter implements Filterable {
    private List<Product> products;
    private List<Product> filteredProducts;
    private Context context;

    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.filteredProducts = products; //filteredProducts.length "less than or equal" products.length
        this.context = context;
    }

    @Override
    public int getCount() {
        return filteredProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);
        //View view = getLayoutInflater().inflate(R.layout.row_items,null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView itemName = view.findViewById(R.id.itemName);
        TextView itemDesc = view.findViewById(R.id.itemDesc);

        imageView.setImageResource(filteredProducts.get(position).getImageURL());
        itemName.setText(filteredProducts.get(position).getName());
        itemDesc.setText(filteredProducts.get(position).getDescription());

        return view;
    }

    //interface Filterable
    @Override
    public Filter getFilter() {
        return new Filter() {
            //gan giong adapter
            @Override
            //moi lan go, output list la gi ?
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if(charSequence == null || charSequence.length() == 0) {
                    //get full data
                    filterResults.count = products.size();
                    filterResults.values = products;
                }else{
                    //ADF1
                    String searchString = charSequence.toString().toLowerCase();
                    List<Product> resultData = new ArrayList<>();
                    for (Product product: products){
                        if(product.getName().toLowerCase().contains(searchString)
                                || product.getDescription().toLowerCase().contains(searchString)){
                            resultData.add(product);
                        }
                        //output list
                        filterResults.count = resultData.size();
                        filterResults.values = resultData;
                    }
                }

                return filterResults;
            }

            @Override
            //after commit,
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                //commit changed
                //sau khi su thay doi xong => update UI => "set state"
                filteredProducts = (List<Product>) filterResults.values;
                notifyDataSetChanged();//update/Refresh ListView
            }
        };
    }
}
