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
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.Service.UserData;
import com.example.tikoshopping.adapters.PostSalesAdapter;
import com.example.tikoshopping.adapters.TypeGoodsAdapter;
import com.example.tikoshopping.adapters.UserAdapter;
import com.example.tikoshopping.models.TypeGoods;
import com.example.tikoshopping.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAdminFragment extends Fragment {
//    private RecyclerView recyclerViewCustomer;
//    private RecyclerView recyclerViewSale ;
//    private UserAdapter SaleAdapter ;
//    private UserAdapter CustomerAdapter ;
//    private ArrayList<User> CustomerList;
//    private ArrayList<User> SaleList ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_admin_user,container,false);

//         Tạo danh sách dữ liệu
//        CustomerList = new ArrayList<User>();
//        SaleList = new ArrayList<User>();
//        recyclerViewCustomer = view.findViewById(R.id.customer_rec);
//        recyclerViewSale = view.findViewById(R.id.sale_rec);
//        SaleAdapter = new UserAdapter(SaleList);
//        CustomerAdapter = new UserAdapter(CustomerList);
//        recyclerViewSale.setAdapter(SaleAdapter);
//        recyclerViewCustomer.setAdapter(CustomerAdapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerViewSale.setLayoutManager(layoutManager);
        return view;
    }
}
