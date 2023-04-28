package com.example.tikoshopping.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikoshopping.R;
import com.example.tikoshopping.models.PostSales;
import com.example.tikoshopping.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private List<User> mData = null;

    public UserAdapter(List<User> data) {
        mData = data;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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
        public TextView mTitleView;

        public ViewHolder(View itemView) {
            super(itemView);
//            mTitleView = itemView.findViewById(R.id.name_product);
        }
    }
}
