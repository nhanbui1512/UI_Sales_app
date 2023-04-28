package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.ResultPostSales;
import com.example.tikoshopping.Service.ResultRecommended;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.Service.Sales.FormCreatePostSales;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIPostSales {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIPostSales apiService = new Retrofit.Builder()
            .baseUrl(_Constant.baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIPostSales.class);

    @GET("/api/sales/getall")
    Call<ResultPostSales> getAllPostSales(@Header("Authorization") String token);




    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjY2OTQ1MiwiZXhwIjoxNjg1MjYxNDUyfQ.S6megJcAmwwfF2jiiC1LWZsOy4xzv8UVyHsItJhwD-E"
    })
    @GET("/api/sales/getrand")
    Call<ResultPostSales> getPostSalesRandom(@Query("rand_number") int randNumber);


    @GET("/api/sales/getrand")
    Call<ResultRecommended> getRecommendedRandom(@Query("rand_number") int randNumber);



    // Xóa bài bán hàng
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjY2OTEyOCwiZXhwIjoxNjg1MjYxMTI4fQ.FKNThQzlIuZCT75k9rPk6q6U-fyrNIr9jlUEKjDiAAw"
    })
    @DELETE("/api/sales/delete")
    Call<ResultBase> DeletePostSales (@Query("id_post") int idPost);

    // Tạo 1 bài bán hàng

    @Headers({
            "Content-Type: application/json",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjY2OTEyOCwiZXhwIjoxNjg1MjYxMTI4fQ.FKNThQzlIuZCT75k9rPk6q6U-fyrNIr9jlUEKjDiAAw"
    })
    @POST("/api/sales/add")
    Call<ResultBase> createPostSales(@Part("title") RequestBody title,
                                     @Part("description") RequestBody description,
                                     @Part("idType") RequestBody idType,
                                     @Part List<MultipartBody.Part> photos);


    @Headers({
            "Content-Type: application/json",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjY2OTQ1MiwiZXhwIjoxNjg1MjYxNDUyfQ.S6megJcAmwwfF2jiiC1LWZsOy4xzv8UVyHsItJhwD-E"
    })
    @GET("/api/sales/getbytypeid")
    Call<ResultPostSales> getPostSalesByTypeGoodsID(@Query("id_type") int idType);


}
