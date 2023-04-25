package com.example.tikoshopping.API;

import com.example.tikoshopping.Service.PassWord;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.ResultMyProfile;
import com.example.tikoshopping.Service.ResultTypeGoods;
import com.example.tikoshopping.Service.User;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APIUser {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    APIUser apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.153:3000")
//            .baseUrl("http://192.168.5.240:3000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIUser.class);
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"})
    @GET("/api/user/myprofile")
    Call<ResultMyProfile> getMyProfile();


    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"})
    @POST("/api/user/changepassword")
    Call<ResultBase> changePassword (@Body  PassWord passWord);


    @GET("/api/user/find")
    Call<User> findUserById(@Query("id") int idUser);

    @GET("/api/user/findname")
    Call<UserData> findUserIncludeName(@Query("user_name") String userName);



    // cập nhật thông tin người dùng
    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MjQyMjMwMSwiZXhwIjoxNjg1MDE0MzAxfQ.z-9xUBo-eIxX8-uqTUU_hOB2SUjogUS8AEApUq_5S58"
    })
    @PUT("/api/user/update")
    Call<ResultBase> UpdateUser ( @Body User user);





}
