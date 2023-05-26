package com.example.tikoshopping.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tikoshopping.API.APICart;
import com.example.tikoshopping.API._Constant;
import com.example.tikoshopping.LoginActivity;
import com.example.tikoshopping.ProductDetailsActivity;
import com.example.tikoshopping.R;
import com.example.tikoshopping.Service.CartItem;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.models.PostSales;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        holder.order_name.setText(item.Title);
        holder.order_price.setText("Giá sản phẩm: "+ item.Price +" VND");
        holder.order_count.setText(Integer.toString(item.getCount()));
        Glide.with(context).load(_Constant.baseUrl+item.getImages().get(0).getPath()).into(holder.order_img);

        holder.plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(holder.order_count.getText().toString());
                count ++ ;
                holder.order_count.setText(Integer.toString(count));

                int idCart = mData.get(position).IDCart;
                SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
                String token = sharedPreferences.getString("token", "null");

                APICart.apiService.UpdateCountProductInCart("bearer " + token,idCart,count).enqueue(new Callback<ResultBase>() {
                    @Override
                    public void onResponse(Call<ResultBase> call, Response<ResultBase> response) {
                        ResultBase res = response.body();

                        if(res != null && res.result == true){
                            Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Update fail", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultBase> call, Throwable t) {
                        Log.e("Upload count Cart", t.getMessage());
                    }
                });

            }
        });

        holder.minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(holder.order_count.getText().toString());
                if(count > 0){
                    count -- ;
                    holder.order_count.setText(Integer.toString(count));

                    int idCart = mData.get(position).IDCart;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
                    String token = sharedPreferences.getString("token", "null");

                    APICart.apiService.UpdateCountProductInCart("bearer " + token,idCart,count).enqueue(new Callback<ResultBase>() {
                        @Override
                        public void onResponse(Call<ResultBase> call, Response<ResultBase> response) {
                            ResultBase res = response.body();

                            if(res != null && res.result == true){
                                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(context, "Update fail", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResultBase> call, Throwable t) {
                            Log.e("Upload count Cart", t.getMessage());
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView order_img;
        TextView order_name,order_price,order_count;
        Button plusBtn ,minusBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            order_name = itemView.findViewById(R.id.order_name);
            order_price = itemView.findViewById(R.id.order_price);
            order_count = itemView.findViewById(R.id.count_order);
            order_img = itemView.findViewById(R.id.order_img);
            plusBtn = itemView.findViewById(R.id.plus_order);
            minusBtn = itemView.findViewById(R.id.minus_order);

        }


    }
}
