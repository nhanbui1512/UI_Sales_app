package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.Comment.FormComment;
import com.example.tikoshopping.Service.Comment.ResultListComment;
import com.example.tikoshopping.Service.Login;
import com.example.tikoshopping.Service.LoginResult;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIComment {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIComment apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.9:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIComment.class);

    @POST("/api/comment/add/{id}")
    Call<ResultBase> CreateComment (@Path("id") int idPost, @Body FormComment form);


    @GET("/api/comment/find/{id}")
    Call<ResultListComment> GetCommentsByIDPosts (@Path("id") int idPost);


    @DELETE("/api/comment/delete/{id}")
    Call<ResultBase> DeleteComment (@Path("id") int idComment);


    @PUT("/api/comment/update/{id}")
    Call<ResultBase> UpdateComment (@Path("id") int idComment , @Body FormComment form);
}
