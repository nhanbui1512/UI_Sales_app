package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.Login;
import com.example.tikoshopping.Service.LoginResult;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APILogin {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APILogin apiService = new Retrofit.Builder()
            .baseUrl("http://172.20.10.3:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APILogin.class);

    @POST("/api/login/checklogin")
    Call<LoginResult> Login(@Body Login login);

}
