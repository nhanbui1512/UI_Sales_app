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

import com.example.tikoshopping.API.APIPostSales;
import com.example.tikoshopping.API.APITypeGoods;
import com.example.tikoshopping.Service.ResultPostSales;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.adapters.PostSalesAdapter;
import com.example.tikoshopping.adapters.TypeGoodsAdapter;
import com.example.tikoshopping.models.PostSales;
import com.example.tikoshopping.models.TypeGoods;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewType;
    private RecyclerView recyclerViewPosts ;
    private PostSalesAdapter postSalesAdapter ;
    private TypeGoodsAdapter typeAdapter ;
    private ArrayList<TypeGoods> mDataList;
    private ArrayList<PostSales> posts ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment,container,false);

//         Tạo danh sách dữ liệu
        mDataList = new ArrayList<TypeGoods>();
        recyclerViewType = view.findViewById(R.id.exp_rec);
        recyclerViewPosts = view.findViewById(R.id.pop_rec);

        CallAPITypeGood();
        CallAPIPostSales();
//
        return view;
    }

    public void CallAPITypeGood(){
        APITypeGoods.apiService.getAllType().enqueue(new Callback<ResultTypeGoods>() {
            @Override
            public void onResponse(Call<ResultTypeGoods> call, Response<ResultTypeGoods> response) {
                    ResultTypeGoods result  = response.body();

                    if(result != null ){
                        mDataList = result.getData();
                        typeAdapter = new TypeGoodsAdapter(mDataList);
                        recyclerViewType.setAdapter(typeAdapter);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                        recyclerViewType.setLayoutManager(layoutManager);

                    }

            }

            @Override
            public void onFailure(Call<ResultTypeGoods> call, Throwable t) {
                Log.e("API: ", t.getMessage());
            }
        });
    }


    public void CallAPIPostSales(){
        APIPostSales.apiService.getPostSalesRandom(4).enqueue(new Callback<ResultPostSales>() {
            @Override
            public void onResponse(Call<ResultPostSales> call, Response<ResultPostSales> response) {
                ResultPostSales result = response.body();
                if(result != null ){
                    Log.e("API postsales" ,response.body().toString());
                    posts = result.getData();
                    postSalesAdapter = new PostSalesAdapter(posts);
                    recyclerViewPosts.setAdapter(postSalesAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerViewPosts.setLayoutManager(layoutManager);
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