package com.example.tikoshopping;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tikoshopping.API.APIUser;
import com.example.tikoshopping.API._Constant;
import com.example.tikoshopping.Service.ResultMyProfile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private EditText inputUserName ;
    private EditText inputEmail ;
    private EditText inputPhoneNumber ;
    private ImageView AvatarPath ;
    private Button Sua,DoiMK,Up;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment,container,false);
        inputUserName = view.findViewById(R.id.pro_name);
        inputEmail = view.findViewById(R.id.pro_email);
        inputPhoneNumber = view.findViewById(R.id.pro_number);
        AvatarPath = view.findViewById(R.id.profile_img);
        Sua = view.findViewById(R.id.btn_sua);
        DoiMK = view.findViewById(R.id.btn_doimk);
        Up = view.findViewById(R.id.btn_up);

        callAPIMyProfile();

        DoiMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ChangePassword.class));
            }
        });

        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),)

            }
        });


        return view;
    }


    public void callAPIMyProfile(){

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);
        APIUser.apiService.getMyProfile("Bearer "+token).enqueue(new Callback<ResultMyProfile>() {
            @Override
            public void onResponse(Call<ResultMyProfile> call, Response<ResultMyProfile> response) {
                ResultMyProfile result = response.body();
                if(result != null && result.getResult()){
                    inputEmail.setText(result.getData().getEmail());
                    inputPhoneNumber.setText(result.getData().getPhoneNumber());
                    inputUserName.setText(result.getData().getUserName());
                    String avatarPath = result.getData().getAvatarPath();
                    Glide.with(requireContext())
                            .load(_Constant.baseUrl+avatarPath)
                            .apply(RequestOptions.circleCropTransform())
                            .into(AvatarPath);
                }
                else {
                    Log.e("Profile", "Du lieu trong");
                }
            }

            @Override
            public void onFailure(Call<ResultMyProfile> call, Throwable t) {
                Log.e("API Profile" ,t.getMessage());
            }
        });
    }





}