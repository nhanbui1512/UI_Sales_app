package com.example.tikoshopping;

import static com.example.tikoshopping.R.id.log_btn;
import static com.example.tikoshopping.R.id.userName_log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tikoshopping.API.APILogin;
import com.example.tikoshopping.Service.Login;
import com.example.tikoshopping.Service.LoginResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button signIn,login;
    private EditText userName,password;
    private TextView signUp;
    private Boolean isLoginSuccess = false ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName_log);
        password = findViewById(R.id.password_log);
        signUp = findViewById(R.id.sign_up);
        login = findViewById(log_btn);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String token = sharedPreferences.getString("token", null);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Login BTN", "Clicked");
                callAPILogin();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });



        userName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    userName.setText("");
                }
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    password.setText("");
                }
            }
        });
    }

    public void callAPILogin(){

        String name = userName.getText().toString();
        String pass = password.getText().toString();

        Login info = new Login(name,pass);

        APILogin.apiService.Login(info).enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                LoginResult result = response.body();
                Log.e("API login", "Call API Thanh COng");
                if(result != null && result.getResult()){ // Nếu đăng nhập tài khoản và mật khẩu đúng

                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", result.getToken());
                    editor.apply();

                    if (result.getUser().getAccess() == 0) { // nếu người dùng là admin
                        startActivity(new Intent(LoginActivity.this,AdminActivity.class));
                    } else  {
                        startActivity(new Intent(LoginActivity.this,ShopActivity.class));
                    }
                }
                else{ // sai tài khoản or mật khẩu
                    Toast.makeText(LoginActivity.this, "Incorrect account or password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Login " , t.getMessage());
                isLoginSuccess = false;
            }
        });
    }
}