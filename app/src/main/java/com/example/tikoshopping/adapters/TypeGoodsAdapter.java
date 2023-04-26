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
import com.example.tikoshopping.R;
import com.example.tikoshopping.ViewAllActivity;
import com.example.tikoshopping.models.PopularModel;
import com.example.tikoshopping.models.TypeGoods;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TypeGoodsAdapter extends RecyclerView.Adapter<TypeGoodsAdapter.ViewHolder> {
    private List<TypeGoods> mData;
    private Context context;


    public TypeGoodsAdapter(List<TypeGoods> data,Context context) {
        this.mData = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TypeGoods item = mData.get(position);
        Glide.with(context).load(_Constant.baseUrl+item.getIconPath()).into(holder.catImg);
        holder.cat_name.setText(item.getNameType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("idType",item.getIDType());
                intent.putExtra("IDType",item.getIDType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView catImg;
        public TextView  cat_name;

        public ViewHolder(View itemView) {
            super(itemView);
            cat_name = itemView.findViewById(R.id.cat_name);
            catImg = itemView.findViewById(R.id.home_cat_img);
        }
    }
}
