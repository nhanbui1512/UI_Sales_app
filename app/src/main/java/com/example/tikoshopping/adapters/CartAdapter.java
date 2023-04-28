package com.example.tikoshopping.adapters;

import android.content.Context;
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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartItem> mData = null;
    private Context context;
    String url ="https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg";
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
        holder.order_name.setText(item.Title);
        holder.order_price.setText("Giá sản phẩm: "+ item.Price +" VND");
        holder.order_count.setText(Integer.toString(item.getCount()));
        Glide.with(context).load(_Constant.baseUrl+item.getImages().get(0).getPath()).into(holder.order_img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView order_img;
        TextView order_name,order_price,order_count;

        public ViewHolder(View itemView) {
            super(itemView);
            order_name = itemView.findViewById(R.id.order_name);
            order_price = itemView.findViewById(R.id.order_price);
            order_count = itemView.findViewById(R.id.count_order);
            order_img = itemView.findViewById(R.id.order_img);
        }
    }
}
