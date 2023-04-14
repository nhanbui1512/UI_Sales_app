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

import com.example.tikoshopping.API.APITypeGoods;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.adapters.TypeGoodsAdapter;
import com.example.tikoshopping.models.TypeGoods;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewType;
    private TypeGoodsAdapter typeAdapter ;
    private ArrayList<TypeGoods> mDataList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment,container,false);

//         Tạo danh sách dữ liệu
        mDataList = new ArrayList<TypeGoods>();
        CallAPITypeGood();
//
        // Tạo RecyclerView và set adapter
        recyclerViewType = view.findViewById(R.id.exp_rec);

//        typeAdapter = new TypeGoodsAdapter(mDataList);
//        recyclerViewType.setAdapter(typeAdapter);
//
//        // Cấu hình RecyclerView với LayoutManager
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerViewType.setLayoutManager(layoutManager);

        return view;
    }

    public void CallAPITypeGood(){
        APITypeGoods.apiService.getAllType().enqueue(new Callback<ResultTypeGoods>() {
            @Override
            public void onResponse(Call<ResultTypeGoods> call, Response<ResultTypeGoods> response) {
                    ResultTypeGoods result  = response.body();

                    if(result != null ){
                        Log.e("API", result.getData().get(1).getNameType());
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
}