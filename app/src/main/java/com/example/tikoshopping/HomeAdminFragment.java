package com.example.tikoshopping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tikoshopping.API.APITypeGoods;
import com.example.tikoshopping.API.APIUser;
import com.example.tikoshopping.Service.Admin.ResultAllUser;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.Service.User;
import com.example.tikoshopping.Service.UserData;
import com.example.tikoshopping.adapters.PostSalesAdapter;
import com.example.tikoshopping.adapters.TypeGoodsAdapter;
import com.example.tikoshopping.adapters.UserAdapter;
import com.example.tikoshopping.models.TypeGoods;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAdminFragment extends Fragment {
    private RecyclerView recyclerViewCustomer;
    private RecyclerView recyclerViewSale ;
    private UserAdapter SaleAdapter ;
    private UserAdapter CustomerAdapter ;
    private ArrayList<User> CustomerList;
    private ArrayList<User> SaleList ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_admin_user,container,false);
        CustomerList = new ArrayList<User> ();
        SaleList = new ArrayList<User> ();
        recyclerViewCustomer = view.findViewById(R.id.customer_rec);
        recyclerViewSale = view.findViewById(R.id.sale_rec);

        callAPIUser();
        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if (SaleAdapter !=null){
            SaleAdapter.release();
        }
        if (CustomerAdapter !=null){
            CustomerAdapter.release();
        }
    }

    public void callAPIUser (){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MzUzNDY5MiwiZXhwIjoxNjg2MTI2NjkyfQ.YIb5zSJrwIlJP0LlFUT89NoWXpl9BwIXhLZ5Es79bVo";
        APIUser.apiService.getAllSalesAccount("Bearer " + token).enqueue(new Callback<ResultAllUser>() {
            @Override
            public void onResponse(Call<ResultAllUser> call, Response<ResultAllUser> response) {
                ResultAllUser res = response.body();
                if(res.result == true && res != null){
                    SaleList = res.data;
                    SaleAdapter = new UserAdapter(getContext(),SaleList);
                    recyclerViewSale.setAdapter(SaleAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerViewSale.setLayoutManager(layoutManager);
                }
            }

            @Override
            public void onFailure(Call<ResultAllUser> call, Throwable t) {

            }
        });

        APIUser.apiService.getAllUsersAccount("Bearer " + token).enqueue(new Callback<ResultAllUser>() {
            @Override
            public void onResponse(Call<ResultAllUser> call, Response<ResultAllUser> response) {
                ResultAllUser res = response.body();
                if(res.result == true && res != null){
                    CustomerList = res.data;
                    CustomerAdapter = new UserAdapter(getContext(),SaleList);
                    recyclerViewCustomer.setAdapter(CustomerAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerViewCustomer.setLayoutManager(layoutManager);
                }
            }

            @Override
            public void onFailure(Call<ResultAllUser> call, Throwable t) {

            }
        });
    }
}

