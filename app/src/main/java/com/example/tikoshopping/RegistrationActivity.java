package com.example.tikoshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tikoshopping.API.APIRegister;
import com.example.tikoshopping.Service.Register.FormRegisterUser;
import com.example.tikoshopping.Service.Register.ResultRegisterUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    Button signUp;
    EditText inputEmail,inputPassword,inputUserName,inputRepeatPass;
    TextView signIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signUp = findViewById(R.id.reg_btn);
        inputUserName = findViewById(R.id.editText_name);
        inputEmail = findViewById(R.id.Email_reg);
        inputPassword = findViewById(R.id.password_reg);
        signIn = findViewById(R.id.sign_in);
        inputRepeatPass = findViewById(R.id.repeat_pass);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void CallAPIRegister () {

        String userName = inputUserName.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String repeatPass= inputRepeatPass.getText().toString();

        if(password != repeatPass){
            Toast.makeText(RegistrationActivity.this, "password does not match", Toast.LENGTH_SHORT).show();
        }
        else {
            FormRegisterUser form = new FormRegisterUser(userName,password,email,""); // view thiếu trường phonenumber
            APIRegister.apiService.Register(form).enqueue(new Callback<ResultRegisterUser>() {
                @Override
                public void onResponse(Call<ResultRegisterUser> call, Response<ResultRegisterUser> response) {
                    ResultRegisterUser res = response.body();
                    if(res != null && res.result)
                    {
                        Toast.makeText(RegistrationActivity.this, "Register account successful", Toast.LENGTH_SHORT).show();
                    }
                    else {

                    }
                }

                @Override
                public void onFailure(Call<ResultRegisterUser> call, Throwable t) {

                }
            });
        }



    }
}