package com.example.tikoshopping.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.example.tikoshopping.models.PostSales;

import java.util.List;

public class PostsByTypeAdapter extends RecyclerView.Adapter<PostsByTypeAdapter.ViewHolder> {
    private List<PostSales> mData = null;
    private Context context;

    public PostsByTypeAdapter(List<PostSales> data,View view) {
        mData = data;
        this.context = view.getContext();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_all_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostSales item = mData.get(position);
        holder.name.setText(item.getTitle());
        holder.view_des.setText(item.getDescription());
        holder.view_price.setText("Giá: " + item.getPrice()+ "VND");
        holder.view_discount.setText(item.getDiscount()+ "% Off");
//        holder.price.setText(item.getPrice().toString());
        Log.e("image",item.getImages().get(0).getPath());
        Glide.with(context).load(_Constant.baseUrl+item.getImages().get(0).getPath()).into(holder.pos_img);
//
//       Picasso.get().load(mData.get(position).getImg_url()).into(holder.recImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                int idPost = item.getIDPost();
//                intent.putExtra("idPost",idPost);
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
        ImageView pos_img;
        TextView name,view_des,view_discount,view_price;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.view_name);
            view_des = itemView.findViewById(R.id.view_des);
            pos_img = itemView.findViewById(R.id.view_img);
            view_price = itemView.findViewById(R.id.view_price);
            view_discount = itemView.findViewById(R.id.view_discount);
        }
    }
}
