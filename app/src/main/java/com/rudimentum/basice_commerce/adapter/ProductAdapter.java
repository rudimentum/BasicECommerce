package com.rudimentum.basice_commerce.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rudimentum.basice_commerce.R;
import com.rudimentum.basice_commerce.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductViewHolder(productItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.productBackground.setCardBackgroundColor(Color.parseColor(products.get(position).getColor()));
        holder.productName.setText(products.get(position).getName());
        holder.productDate.setText(products.get(position).getDate());
        holder.productLevel.setText(products.get(position).getLevel());

        int imageId = context.getResources().getIdentifier("ic_" + products.get(position).getImg(), "drawable", context.getPackageName());
        holder.productImage.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView productBackground;
        ImageView productImage;
        TextView productName, productDate, productLevel;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productBackground = itemView.findViewById(R.id.productBackground);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            productDate = itemView.findViewById(R.id.productDate);
            productLevel = itemView.findViewById(R.id.productLevel);
        }
    }
}
