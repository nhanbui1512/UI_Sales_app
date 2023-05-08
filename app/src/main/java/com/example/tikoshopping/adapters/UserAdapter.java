package com.example.tikoshopping.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikoshopping.Service.DetailUserActivity;
import com.example.tikoshopping.HomeAdminFragment;
import com.example.tikoshopping.R;
import com.example.tikoshopping.Service.DetailUserActivity;
import com.example.tikoshopping.Service.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private List<User> mData = null;
    private Context mContext;

    public UserAdapter(Context context, List<User> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User item = mData.get(position);
        holder.pendingusernameTV.setText(item.getUserName());
        holder.pendinguseridTV.setText(String.valueOf(item.getUserID()));
        holder.pendinguserphoneTV.setText(item.getPhoneNumber());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToDetail(item);
            }
        });
    }
    private void onClickToDetail(User user) {
        Intent intent = new Intent(mContext, DetailUserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user_id", user.getUserID());
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }
    public void release(){
        mContext = null;
    }
    public void onBindViewHolder(PostSalesAdapter.ViewHolder holder, int position) {
        User item = mData.get(position);
        //holder.mTitleView.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layoutItem;
        public TextView pendingusernameTV;
        public TextView pendinguseridTV;
        public TextView pendinguserphoneTV;

        public ViewHolder(View itemView) {
            super(itemView);
            pendingusernameTV = itemView.findViewById(R.id.tv_user_name);
            pendinguseridTV = itemView.findViewById(R.id.tv_user_id);
            pendinguserphoneTV = itemView.findViewById(R.id.tv_user_phone);
            layoutItem = itemView.findViewById(R.id.layout_item);
        }
    }
}
