package com.example.tikoshopping;

import static android.app.Activity.RESULT_OK;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tikoshopping.API.APIUser;
import com.example.tikoshopping.Service.ResultMyProfile;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminProfileActivity extends Fragment {

    private EditText inputUserName ;
    private EditText inputEmail ;
    private EditText inputPhoneNumber ;
    private ImageView avatar ;

    public static final int PICK_IMAGE_REQUEST = 101;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_admin_profile,container,false);
        inputUserName = view.findViewById(R.id.admin_profile_name);
        inputEmail = view.findViewById(R.id.admin_profile_email);
        inputPhoneNumber = view.findViewById(R.id.admin_profile_number);
        avatar = view.findViewById(R.id.admin_profile_img);


        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        callAPIProfile();

        return view;
    }


    public void callAPIProfile(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRFVzZXIiOjEsImFjY2VzcyI6MCwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTY4MzUzNDY5MiwiZXhwIjoxNjg2MTI2NjkyfQ.YIb5zSJrwIlJP0LlFUT89NoWXpl9BwIXhLZ5Es79bVo";

        APIUser.apiService.getMyProfile("Bearer " +token).enqueue(new Callback<ResultMyProfile>() {
            @Override
            public void onResponse(Call<ResultMyProfile> call, Response<ResultMyProfile> response) {
                ResultMyProfile result = response.body();
                if(result != null && result.getResult())
                {
                    inputUserName.setText(result.getData().getUserName());
                    inputEmail.setText(result.getData().getEmail());
                    inputPhoneNumber.setText(result.getData().getPhoneNumber());
                }
            }

            @Override
            public void onFailure(Call<ResultMyProfile> call, Throwable t) {
                Log.e("API myProfile", t.getMessage());
            }
        });
    }





}