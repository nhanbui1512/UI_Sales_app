package com.example.tikoshopping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tikoshopping.API.APICart;
import com.example.tikoshopping.API.APIService;
import com.example.tikoshopping.Service.Login;
import com.example.tikoshopping.Service.LoginResult;
import com.example.tikoshopping.Service.ResultCart;
import com.example.tikoshopping.Service.User;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment,container,false);
        getAllProductInCart();
        return view;

    }

    public void getAllProductInCart()
    {
        APICart.apiService.getAllProduct().enqueue(new Callback<ResultCart>() {
            @Override
            public void onResponse(Call<ResultCart> call, Response<ResultCart> response) {
                ResultCart result = response.body();
                Log.e("Cart", "Call API Thanh Cong");
                if(result != null && result.result){

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

}