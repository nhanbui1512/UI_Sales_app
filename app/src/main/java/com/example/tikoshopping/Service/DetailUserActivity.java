package com.example.tikoshopping.Service;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tikoshopping.API.APIUser;
import com.example.tikoshopping.R;
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
        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        String user_id = (String) bundle.get("object_user_id");
        //call api getid
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MzUzNDY5MiwiZXhwIjoxNjg2MTI2NjkyfQ.YIb5zSJrwIlJP0LlFUT89NoWXpl9BwIXhLZ5Es79bVo";
        APIUser.apiService.getAllSalesAccount("Bearer " + token).enqueue(new Callback<ResultAllUser>() {

        });
                                                                         }
//        EditText edtNameUser = findViewById(R.id.edt_user_name);
//        edtNameUser.setText(user.getUserName());
//        EditText edtPhoneUser = findViewById(R.id.edt_user_phone);
//        edtPhoneUser.setText(user.getPhoneNumber());
//        EditText edtMailUser = findViewById(R.id.edt_user_mail);
//        edtMailUser.setText(user.getEmail());
//        EditText edtAddressUser = findViewById(R.id.edt_user_address);
//        edtAddressUser.setText(user.getAddressUser());
    }
}
