package com.example.tikoshopping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tikoshopping.API.APICart;
import com.example.tikoshopping.Service.CartItem;
import com.example.tikoshopping.Service.ResultCart;
import com.example.tikoshopping.adapters.CartAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {

    private Button buyBtn ;

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private ArrayList<CartItem> orders;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment,container,false);

        recyclerView = view.findViewById(R.id.cart_recyclerView);


        buyBtn = view.findViewById(R.id.btnDatHang);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(CartFragment.this,RegistrationActivity.class));
            }
        });
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
                    orders = result.data;
                    cartAdapter = new CartAdapter(orders,getContext());
                    recyclerView.setAdapter(cartAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(layoutManager);
                    Log.e("API gio hang",Double.toString(result.data.get(0).getPrice()));

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