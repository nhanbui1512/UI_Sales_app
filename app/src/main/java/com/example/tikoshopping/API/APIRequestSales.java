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
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APIRequestSales {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIRequestSales apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.153:3000")
//            .baseUrl("http://192.168.5.240:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIRequestSales.class);


    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"
    })
    // Đăng ký tài khoản bán hàng
    @POST("/api/user/registerSales")
    Call<ResultBase> Register(@Body FormRequest form);


    // Lấy ra tất cả request

    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"
    })
    @GET("/api/user/allrequest")
    Call<ResultAllRequest> GetAllRequest();


    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"
    })
    @PUT("/api/user/acceptrequeset")
    Call<ResultBase> AcceptRequest (@Query("id_request") int idRequest) ;

}
