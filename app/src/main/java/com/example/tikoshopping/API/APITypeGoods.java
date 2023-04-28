package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.Login;
import com.example.tikoshopping.Service.LoginResult;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APITypeGoods {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APITypeGoods apiService = new Retrofit.Builder()
            .baseUrl(_Constant.baseUrl)
//            .baseUrl("http://192.168.5.240:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APITypeGoods.class);
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjY2OTQ1MiwiZXhwIjoxNjg1MjYxNDUyfQ.S6megJcAmwwfF2jiiC1LWZsOy4xzv8UVyHsItJhwD-E"
    })
    @GET("/api/type/getall")
    Call<ResultTypeGoods> getAllType();



    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjUwNDYyMSwiZXhwIjoxNjg1MDk2NjIxfQ.xL_uudjTi0z1HMEz3AHIISvwwwdDKZ_SpPCTQQI6U4o"
    })
    @Multipart
    @POST("/api/type/add")
    Call<ResultBase> createTypeGoods(
            @Part("nameType") RequestBody nameType,
            @Part MultipartBody.Part icon
    );


}
