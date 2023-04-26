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
import com.example.tikoshopping.ProductDetailsActivity;
import com.example.tikoshopping.R;
import com.example.tikoshopping.models.PostSales;

import java.util.ArrayList;
import java.util.List;

public class RecommenAdapter extends RecyclerView.Adapter<RecommenAdapter.ViewHolder> {
    private ArrayList<PostSales> mData = null;
    private Context context;
    String url ="https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg";
    public RecommenAdapter(ArrayList<PostSales> data, Context context) {
        mData = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommended_items, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostSales item = mData.get(position);
        holder.name.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        Glide.with(context).load("http://10.10.28.165:3000"+item.getImages().get(0).getPath()).into(holder.postImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("idPost",item.getIDPost());
                intent.putExtra("Name",item.getTitle());
                intent.putExtra("Price",item.getPrice());
                intent.putExtra("Description",item.getDescription());
                intent.putExtra("Path",item.getImages().get(0).getPath());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView postImage;
        TextView name,description;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rec_prod);
            description = itemView.findViewById(R.id.rec_des);
            postImage = itemView.findViewById(R.id.rec_img);

        }
    }
}
