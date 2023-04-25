package com.example.tikoshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.tikoshopping.API.APIPostSales;
import com.example.tikoshopping.Service.ResultPostSales;
import com.example.tikoshopping.adapters.PostsByTypeAdapter;
import com.example.tikoshopping.models.PostSales;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostsByTypeAdapter postsByTypeAdapter;
    ArrayList<PostSales> postSalesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int idType = intent.getIntExtra("IDType",1);
        Log.e("IDType",Integer.toString(idType));
        setContentView(R.layout.activity_view_all);

//        int idType = Integer.parseInt(getIntent().getStringExtra("idType"));
        recyclerView = findViewById(R.id.view_all_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CallAPIPostSalesByType(idType);

    }


    public void CallAPIPostSalesByType(int idType){
        APIPostSales.apiService.getPostSalesByTypeGoodsID(idType).enqueue(new Callback<ResultPostSales>() {
            @Override
            public void onResponse(Call<ResultPostSales> call, Response<ResultPostSales> response) {
                ResultPostSales result = response.body();
                if(result != null ){
                    postSalesArrayList = result.getData();
                    postsByTypeAdapter = new PostsByTypeAdapter(postSalesArrayList,findViewById(R.id.view_all_rec));
                    recyclerView.setAdapter(postsByTypeAdapter);
                }
                else{
                    Log.e("API postsales" ,"khong co du lieu");
                }
            }

            @Override
            public void onFailure(Call<ResultPostSales> call, Throwable t) {
                Log.e("API postsales", t.getMessage());
            }
        });
    }

}