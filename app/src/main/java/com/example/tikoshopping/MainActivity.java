package com.example.tikoshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tikoshopping.API.APIUser;
import com.example.tikoshopping.Service.ResultMyProfile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    Button btn_login,btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String token = sharedPreferences.getString("token", null);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_signup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });


        // kiểm tra xem token có ở local hay không
        if(token !=null){
            APIUser.apiService.getMyProfile("Bearer "+token).enqueue(new Callback<ResultMyProfile>() {
                @Override
                public void onResponse(Call<ResultMyProfile> call, Response<ResultMyProfile> response) {
                    ResultMyProfile res = response.body();
                    if(res != null)
                    {
                        if(res.getResult() == true) // nếu get API thành công và lấy được thông tin user
                        {
                            if(res.getData().getAccess() == 0){ // nếu user là admin
                                startActivity(new Intent(MainActivity.this, AdminActivity.class));
                            }
                            else { // nếu user là người dùng or người bán hàng
                                startActivity(new Intent(MainActivity.this, ShopActivity.class));
                            }
                        }
                        else {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResultMyProfile> call, Throwable t) {
                    Log.e("API profile", t.getMessage());
//                    startActivity(new Intent(MainActivity.this,ShopActivity.class));
                }
            });

        }

    }
}