package com.example.tikoshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tikoshopping.Service.User;
import com.example.tikoshopping.Service.UserData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_login,btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        User user1 = new User(1,"NhanBUi","buithiennhan0345@gmail.com", "0913946857","path",1);
        User user2 = new User(2,"NhanBUi","buithiennhan0345@gmail.com", "0913946857","path",1);
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        UserData data = new UserData(list);

        Gson gson = new Gson();
        String strJson = gson.toJson(data);
        Log.e("JSON: " , strJson);





    }
}