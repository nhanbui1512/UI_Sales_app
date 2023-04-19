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

public class ProfileFragment extends Fragment {

    private EditText inputUserName ;
    private EditText inputEmail ;
    private EditText inputPhoneNumber ;
    private ImageView avatar ;

    public static final int PICK_IMAGE_REQUEST = 101;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment,container,false);
        inputUserName = view.findViewById(R.id.pro_name);
        inputEmail = view.findViewById(R.id.pro_email);
        inputPhoneNumber = view.findViewById(R.id.pro_number);
        avatar = view.findViewById(R.id.profile_img);
        
        
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST);

            }
        });
        
        callAPIProfile();

        return view;
    }


    public void callAPIProfile(){
        APIUser.apiService.getMyProfile().enqueue(new Callback<ResultMyProfile>() {
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