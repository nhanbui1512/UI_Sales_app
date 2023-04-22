package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.Bill;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIOrders {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIOrders apiService = new Retrofit.Builder()
            .baseUrl("http://10.10.53.234:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIOrders.class);
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MTA0OTQxOSwiZXhwIjoxNjgzNjQxNDE5fQ.vHEF_WIe1D_g3IzdkjHRL4vGasFaNB3rlATBRZw89uE"
    })
    @GET("/api/order/orders")
    Call<ResultBase> orders(@Body Bill bill);

}
