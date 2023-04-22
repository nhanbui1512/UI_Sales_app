package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.ResultPostSales;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIPostSales {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIPostSales apiService = new Retrofit.Builder()
            .baseUrl("http://10.10.53.234:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIPostSales.class);
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MTk3MTE3NCwiZXhwIjoxNjg0NTYzMTc0fQ.pvsYNnuY5MYR24hWFQhBVCuDI2i1QfWWoiFABfGjix8"
    })
    @GET("/api/sales/getall")
    Call<ResultPostSales> getAllPostSales();


    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MTk3MTE3NCwiZXhwIjoxNjg0NTYzMTc0fQ.pvsYNnuY5MYR24hWFQhBVCuDI2i1QfWWoiFABfGjix8"
    })
    @GET("/api/sales/getrand")
    Call<ResultPostSales> getPostSalesRandom(@Query("rand_number") int randNumber);

}
