package com.example.tikoshopping.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikoshopping.R;
import com.example.tikoshopping.Service.DetailUserActivity;
import com.example.tikoshopping.Service.RequestSales.Request;
import com.example.tikoshopping.Service.User;

import org.w3c.dom.Text;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {
    private List<Request> mData = null;
    private Context mContext;

    public RequestAdapter(Context context, List<Request> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public RequestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_request, parent, false);
        return new RequestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Request item = mData.get(position);
        holder.pendingidTV.setText(item.getRequestID());
        holder.pendingcreateatTV.setText(String.valueOf(item.getDate()));
        holder.pendinguseridTV.setText(item.getRequestUserID());
        holder.pendingstatus.setText(String.valueOf(item.getStatus()));
        holder.pendinguserphoneTV.setText(item.getPhoneNumber());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToDetail(item);
            }
        });
    }

    private void onClickToDetail(Request request) {
        Intent intent = new Intent(mContext, DetailUserActivity.class);
        intent.putExtra("id",request.getRequestID());
        mContext.startActivity(intent);
    }
    public void release(){
        mContext = null;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layoutItem;
        public TextView pendingstatus;
        public TextView pendinguseridTV;
        public TextView pendinguserphoneTV;
        public TextView pendingidTV;
        public TextView pendingcreateatTV;


        public ViewHolder(View itemView) {
            super(itemView);
            pendingstatus = itemView.findViewById(R.id.tv_request_status);
            pendinguseridTV = itemView.findViewById(R.id.tv_request_user_id);
            pendinguserphoneTV = itemView.findViewById(R.id.tv_user_phone);
            pendingidTV = itemView.findViewById(R.id.tv_request_id);
            pendingcreateatTV = itemView.findViewById(R.id.tv_request_create_at);
            layoutItem = itemView.findViewById(R.id.layout_item_request);
        }
    }
}
