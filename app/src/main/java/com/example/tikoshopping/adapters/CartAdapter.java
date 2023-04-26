package com.example.tikoshopping.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tikoshopping.ProductDetailsActivity;
import com.example.tikoshopping.R;
import com.example.tikoshopping.Service.CartItem;
import com.example.tikoshopping.models.PostSales;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartItem> mData = null;
    private Context context;
    public CartAdapter(List<CartItem> data, Context context) {
        mData = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CartItem item = mData.get(position);
//        holder.title.setText(item.Title);
//        holder.description.setText(item.Description);
//        holder.price.setText(Double.toString(item.Price));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
//            title = itemView.findViewById(R.id.cart_item);
//            description = itemView.findViewById(R.id.cart_des);
//            price = itemView.findViewById(R.id.cart_price);
//            count = itemView.findViewById(R.id.cart_count);


        }
    }
}
