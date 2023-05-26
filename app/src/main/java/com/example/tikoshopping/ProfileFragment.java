package com.example.tikoshopping;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tikoshopping.API.APIUser;
import com.example.tikoshopping.Service.ResultBase;
import com.example.tikoshopping.Service.ResultMyProfile;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private static final int MY_REQUEST_CODE = 10;

    private EditText inputUserName ;
    private EditText inputEmail ;
    private EditText inputPhoneNumber ;
    private ImageView avatar ;
    private Button Sua,DoiMK,Up;

    private ActivityResultLauncher<Intent> imagePickerLauncher;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment,container,false);
        inputUserName = view.findViewById(R.id.pro_name);
        inputEmail = view.findViewById(R.id.pro_email);
        inputPhoneNumber = view.findViewById(R.id.pro_number);
        avatar = view.findViewById(R.id.profile_img);
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


        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");

                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    // Quyền đã được cấp, bạn có thể thực hiện hành động liên quan đến tệp tin ở đây
                    imagePickerLauncher.launch(intent);
                }

            }
        });




        imagePickerLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        // Lấy Uri của hình ảnh đã chọn
                        Uri selectedImageUri = result.getData().getData();
//
                        File imageFile = convertUriToFile(selectedImageUri);

                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
                        String token = sharedPreferences.getString("token", null);



                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), imageFile);
                        MultipartBody.Part photo = MultipartBody.Part.createFormData("photo",imageFile.getName(),requestBody);


                        APIUser.apiService.ChangeAvatar("Bearer " +token , photo).enqueue(new Callback<ResultBase>() {
                            @Override
                            public void onResponse(Call<ResultBase> call, Response<ResultBase> response) {
                                ResultBase res = response.body();

                                if(res != null){
                                    Log.e("API change ava", "successful");
                                }
                                else {
                                    Log.e("API change ava", "fail");
                                }
                            }

                            @Override
                            public void onFailure(Call<ResultBase> call, Throwable t) {
                                Log.e("API change ava" , t.getMessage());
                            }
                        });

                        avatar.setImageURI(selectedImageUri);
                    }
                });



        return view;
    }

    private File convertUriToFile(Uri uri) {
        File file = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContext().getContentResolver().query(uri, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String filePath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                cursor.close();
                file = new File(filePath);
            }
        } else if (uri.getScheme().equals("file")) {
            file = new File(uri.getPath());
        }
        return file;
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