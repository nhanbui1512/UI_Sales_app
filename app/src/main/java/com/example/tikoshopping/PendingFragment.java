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
import com.example.tikoshopping.Service.RequestSales.Request;
import com.example.tikoshopping.Service.ResultAllRequest;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.Service.User;
import com.example.tikoshopping.Service.UserData;
import com.example.tikoshopping.adapters.PostSalesAdapter;
import com.example.tikoshopping.adapters.RequestAdapter;
import com.example.tikoshopping.adapters.TypeGoodsAdapter;
import com.example.tikoshopping.adapters.UserAdapter;
import com.example.tikoshopping.models.TypeGoods;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingFragment extends Fragment {
    private RecyclerView recyclerViewRequest;
    private RequestAdapter RequestAdapter;
    private ArrayList<Request> RequestList = new ArrayList<Request> ();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pending_fragment,container,false);
        recyclerViewRequest = view.findViewById(R.id.pending_rec);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MzUzNDY5MiwiZXhwIjoxNjg2MTI2NjkyfQ.YIb5zSJrwIlJP0LlFUT89NoWXpl9BwIXhLZ5Es79bVo";
        APIUser.apiService.GetAllRequest("Bearer "+token).enqueue(new Callback<ResultAllRequest>() {
            @Override
            public void onResponse(Call<ResultAllRequest> call, Response<ResultAllRequest> response) {
                ResultAllRequest res = response.body();
                Log.e("API request " ,response.body().toString());
                if(res != null){
                    RequestList = res.getData();
                    RequestAdapter = new RequestAdapter(getContext(),RequestList);
                    recyclerViewRequest.setAdapter(RequestAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerViewRequest.setLayoutManager(layoutManager);
                }
                else{
                    Log.e("API postsales" ,"khong co du lieu");
                }
            }

            @Override
            public void onFailure(Call<ResultAllRequest> call, Throwable t) {

            }
        });
        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if (RequestAdapter !=null){
            RequestAdapter.release();
        }
    }
}
