package com.example.tikoshopping.Service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tikoshopping.API.APIUser;
import com.example.tikoshopping.HomeAdminFragment;
import com.example.tikoshopping.LoginActivity;
import com.example.tikoshopping.R;
import com.example.tikoshopping.RegistrationActivity;
import com.example.tikoshopping.Service.Admin.ResultAllUser;
import com.example.tikoshopping.adapters.UserAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        Intent intent = getIntent();
        int user_id = intent.getIntExtra("id",0);
        Log.e("id ",String.valueOf(user_id));
        //call api getid
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MzUzNDY5MiwiZXhwIjoxNjg2MTI2NjkyfQ.YIb5zSJrwIlJP0LlFUT89NoWXpl9BwIXhLZ5Es79bVo";
        APIUser.apiService.findUserById("Bearer "+token, user_id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User userdetail = response.body();
                Log.e("Name: ",userdetail.getUserName());
                if (userdetail!= null) {
                    EditText edtNameUser = findViewById(R.id.edt_user_name);
                    edtNameUser.setText(userdetail.getUserName());
                    EditText edtPhoneUser = findViewById(R.id.edt_user_phone);
                    edtPhoneUser.setText(userdetail.getPhoneNumber());
                    EditText edtMailUser = findViewById(R.id.edt_user_mail);
                    edtMailUser.setText(userdetail.getEmail());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        Button btn_block = findViewById(R.id.btn_block);
        btn_block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MzUzNDY5MiwiZXhwIjoxNjg2MTI2NjkyfQ.YIb5zSJrwIlJP0LlFUT89NoWXpl9BwIXhLZ5Es79bVo";
                APIUser.apiService.findUserById("Bearer "+token, user_id).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User userdetail = response.body();
                        Log.e("Name: ",userdetail.getUserName());
                        if (userdetail!= null) {
                            EditText edtNameUser = findViewById(R.id.edt_user_name);
                            edtNameUser.setText(userdetail.getUserName());
                            EditText edtPhoneUser = findViewById(R.id.edt_user_phone);
                            edtPhoneUser.setText(userdetail.getPhoneNumber());
                            EditText edtMailUser = findViewById(R.id.edt_user_mail);
                            edtMailUser.setText(userdetail.getEmail());
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
                startActivity(new Intent(DetailUserActivity.this, HomeAdminFragment.class));
            }
        });


    }
}
