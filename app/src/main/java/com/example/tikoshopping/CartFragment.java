package com.example.tikoshopping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tikoshopping.API.APICart;
import com.example.tikoshopping.API.APIService;
import com.example.tikoshopping.Service.CartItem;
import com.example.tikoshopping.Service.Login;
import com.example.tikoshopping.Service.LoginResult;
import com.example.tikoshopping.Service.ResultCart;
import com.example.tikoshopping.Service.User;
import com.example.tikoshopping.Service.UserData;
import com.example.tikoshopping.adapters.CartAdapter;
import com.example.tikoshopping.adapters.RecommenAdapter;
import com.example.tikoshopping.models.PostSales;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {

    private RecyclerView ordersRecycleView;
    private ArrayList<CartItem> orders = new ArrayList<CartItem>();
    private CartAdapter cartAdapter;
    private Button btnthanhtoan;

    private TextView total ;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment,container,false);
        ordersRecycleView = view.findViewById(R.id.order_recycler);
        btnthanhtoan = view.findViewById(R.id.btnMuaHang);
        total = view.findViewById(R.id.cart_price);

        getAllProductInCart();
        clickthanhtoan();


        return view;

    }

    public void getAllProductInCart()
    {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);

        APICart.apiService.getAllProduct("Bearer "+ token ).enqueue(new Callback<ResultCart>() {
            @Override
            public void onResponse(Call<ResultCart> call, Response<ResultCart> response) {
                ResultCart result = response.body();
                Log.e("Cart", "Call API Thanh Cong");
                if(result != null && result.result){
                    orders = result.data;
                    cartAdapter = new CartAdapter(orders,getContext());
                    ordersRecycleView.setAdapter(cartAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    ordersRecycleView.setLayoutManager(layoutManager);
                    total.setText(result.total.toString() + " VND");
                }
                else {
                    Log.e("Cart", "is empty");
                }
            }

            @Override
            public void onFailure(Call<ResultCart> call, Throwable t) {
                Log.e("API cart", t.getMessage());

            }
        });

    }
    private void clickthanhtoan()
    {
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PayActivity.class);
                startActivity(intent);
            }
        });
    }

}