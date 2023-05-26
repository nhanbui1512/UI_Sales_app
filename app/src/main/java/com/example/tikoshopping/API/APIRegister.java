package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.Sales.Register.FormRegisterUser;
import com.example.tikoshopping.Service.Sales.Register.ResultRegisterUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIRegister {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIRegister apiService = new Retrofit.Builder()
            .baseUrl(_Constant.baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIRegister.class);

    @POST("/api/user/register")
    Call<ResultRegisterUser> Register(@Body FormRegisterUser login);

}
