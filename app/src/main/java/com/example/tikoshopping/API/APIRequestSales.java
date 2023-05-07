package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.RequestSales.FormRequest;
import com.example.tikoshopping.Service.RequestSales.Request;
import com.example.tikoshopping.Service.RequestSales.ResultAllRequest;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APIRequestSales {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIRequestSales apiService = new Retrofit.Builder()
            .baseUrl(_Constant.baseUrl)
//            .baseUrl("http://192.168.5.240:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIRequestSales.class);


    // Đăng ký tài khoản bán hàng
    @POST("/api/user/registerSales")
    Call<ResultBase> Register(@Header("Authorization") String token, @Body FormRequest form);


    // Lấy ra tất cả request

    @GET("/api/user/allrequest")
    Call<ResultAllRequest> GetAllRequest(@Header("Authorization") String token);


    @PUT("/api/user/acceptrequeset")
    Call<ResultBase> AcceptRequest (@Header ("Authorization")String token,@Query("id_request") int idRequest) ;

}
