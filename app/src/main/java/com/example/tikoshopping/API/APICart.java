package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.FormAddProductIntoCart;
import com.example.tikoshopping.Service.ResultAddProductIntoCart;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.ResultCart;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APICart {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APICart apiService = new Retrofit.Builder()
            .baseUrl(_Constant.baseUrl)
//            .baseUrl("http://192.168.5.240:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APICart.class);

    // Lấy ra tất cả sản phẩm trong giỏ hàng

    @GET("/api/cart/getall")
    Call<ResultCart> getAllProduct (@Header("Authorization") String token);


    // Thêm 1 sản phẩm vào giỏ hàng
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjUwNDYyMSwiZXhwIjoxNjg1MDk2NjIxfQ.xL_uudjTi0z1HMEz3AHIISvwwwdDKZ_SpPCTQQI6U4o"
    })
    @POST("/api/cart/addproduct")
    Call<ResultAddProductIntoCart> AddProductInCart(@Body FormAddProductIntoCart form);



    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjUwNDMwMCwiZXhwIjoxNjg1MDk2MzAwfQ.pGpiPOqL_FWBGnBoTq4agwFfbQi8bcwat7SU9VKwNBs"
    })
    @PUT("/api/cart/updatecount")
    Call<ResultBase> UpdateCountProductInCart (@Query("id_cart") int idCart, @Query("count") int count);


//     Xóa 1 Sản phẩm trong giỏ hàng
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjUwNDMwMCwiZXhwIjoxNjg1MDk2MzAwfQ.pGpiPOqL_FWBGnBoTq4agwFfbQi8bcwat7SU9VKwNBs"
    })
    @DELETE("/api/cart/delete")
    Call<ResultBase> DeleteProductInCart (@Query("id_cart") int idCart);

    // Xóa tất cả sản phẩm trong giỏ hàng

    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjUwNDMwMCwiZXhwIjoxNjg1MDk2MzAwfQ.pGpiPOqL_FWBGnBoTq4agwFfbQi8bcwat7SU9VKwNBs"
    })
    @DELETE("/api/cart/deleteall")
    Call<ResultBase> DeleteAllInCart ();


}
