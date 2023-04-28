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
import retrofit2.http.Query;

public interface APIOrders {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIOrders apiService = new Retrofit.Builder()
//            .baseUrl("http://192.168.1.153:3000")
            .baseUrl(_Constant.baseUrl)
//            .baseUrl("http://192.168.5.240:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIOrders.class);

    // Order 1 đơn hàng ( có thể 1 hoặc nhiều sản phẩm )
    @Headers({
            "Content-Type: application/json",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"
    })
    @GET("/api/order/orders")
    Call<ResultBase> orders(@Body Bill bill);


    // Lấy ra thông tin của 1 hóa đơn
    @Headers({
            "Content-Type: application/json",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"
    })
    @GET("/api/order/find")
    Call<com.example.tikoshopping.Service.Order_Model.Bill> getAllOrderByBill(@Query("bill_id")  int idBill);


}
