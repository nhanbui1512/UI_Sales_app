package com.example.tikoshopping.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tikoshopping.API._Constant;
import com.example.tikoshopping.ProductDetailsActivity;
import com.example.tikoshopping.R;
import com.example.tikoshopping.Service.CartItem;
import com.example.tikoshopping.models.PostSales;

import java.util.List;

public class Cart1Adapter extends RecyclerView.Adapter<Cart1Adapter.ViewHolder> {
    private List<CartItem> mData = null;
    private Context context;
    String url ="https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg";
    public Cart1Adapter(List<CartItem> data, Context context) {
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
        holder.orderName.setText(item.getTitle());
        holder.orderPrice.setText("Giá sản phẩm : " +item.getPrice()+ "VND");
        holder.orderCount.setText(item.getCount());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView orderName, orderPrice, orderCount;

        public ViewHolder(View itemView) {
            super(itemView);
            orderName = itemView.findViewById(R.id.order_name);
            orderPrice = itemView.findViewById(R.id.order_price);
            orderCount = itemView.findViewById(R.id.count_order);


        }
    }
}
