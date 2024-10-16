package nguyenvana.aprotrain.myapp.productlist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nguyenvana.aprotrain.myapp.R;
import nguyenvana.aprotrain.myapp.models.Product;

class ProductViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewProductId;
    private TextView textViewSelectedDate;
    private TextView textViewName;
    private TextView textViewDescription;
    private TextView textViewNumberOfRequests;
    private TextView textViewNumberOfPledge;
    private TextView textViewWeight;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewProductId = itemView.findViewById(R.id.textViewProductId);
        textViewSelectedDate = itemView.findViewById(R.id.textViewSelectedDate);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewDescription = itemView.findViewById(R.id.textViewDescription);
        textViewNumberOfRequests = itemView.findViewById(R.id.textViewNumberOfRequests);
        textViewNumberOfPledge = itemView.findViewById(R.id.textViewNumberOfPledge);
        textViewWeight = itemView.findViewById(R.id.textViewWeight);
    }
    public void setProduct(Product product) {
        textViewProductId.setText(String.valueOf(product.getId()));
        textViewName.setText(product.getName());
        textViewDescription.setText(product.getDescription());
        textViewNumberOfRequests.setText(String.valueOf(product.getNumberOfRequests()));
        textViewNumberOfPledge.setText(String.valueOf(product.getNumberOfPledge()));
        textViewWeight.setText(product.getWeight());
    }
}
