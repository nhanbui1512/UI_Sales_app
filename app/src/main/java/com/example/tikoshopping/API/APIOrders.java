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
import retrofit2.http.Header;
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
    @GET("/api/order/orders")
    Call<ResultBase> orders( @Header("Authorization") String token, @Body Bill bill);


    // Lấy ra thông tin của 1 hóa đơn

    @GET("/api/order/find")
    Call<com.example.tikoshopping.Service.Order_Model.Bill> getAllOrderByBill(@Header("Authorization") String token,@Query("bill_id")  int idBill);


}
