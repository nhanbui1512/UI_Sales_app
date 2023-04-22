package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.Login;
import com.example.tikoshopping.Service.LoginResult;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APITypeGoods {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APITypeGoods apiService = new Retrofit.Builder()
            .baseUrl("http://10.10.53.234:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APITypeGoods.class);
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MTk3MTE3NCwiZXhwIjoxNjg0NTYzMTc0fQ.pvsYNnuY5MYR24hWFQhBVCuDI2i1QfWWoiFABfGjix8"
    })
    @GET("/api/type/getall")
    Call<ResultTypeGoods> getAllType();

}
