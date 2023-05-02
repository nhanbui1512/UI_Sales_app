package com.example.tikoshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tikoshopping.API.APICart;
import com.example.tikoshopping.API._Constant;
import com.example.tikoshopping.Service.FormAddProductIntoCart;
import com.example.tikoshopping.Service.ResultAddProductIntoCart;
import com.example.tikoshopping.models.ViewAllModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {
    TextView quantity;
    int totalquantity = 1;
    int totalPrice = 0;
    ImageView detailedImg;
    TextView name,price,description;
    Button addToCart;
    ImageView addItem,removeItem;
    Toolbar toolbar;

    ViewAllModel viewAllModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int idPost = intent.getIntExtra("idPost",1);
        String name = intent.getStringExtra("Name");
        String description = intent.getStringExtra("Description");
        int price = intent.getIntExtra("Price",1);
        String path = _Constant.baseUrl+intent.getStringExtra("Path");
        setContentView(R.layout.activity_product_details);


        initView();
        initData(name,description,price,path);
        AddToCart();

    }

    private void initData(String title, String Description, int Price, String path)
    {
        name.setText(title);
        description.setText(Description);
        price.setText("Giá: "+Price+"VND");
        Glide.with(getApplicationContext()).load(path).into(detailedImg);

        totalPrice =Price * totalquantity;
    }

    private void initView()
    {
        quantity = findViewById(R.id.quantity);
        toolbar = findViewById(R.id.toolbar);
        detailedImg = findViewById(R.id.detailed_img);
        addItem = findViewById(R.id.add_img);
        removeItem = findViewById(R.id.remove_img);
        name = findViewById(R.id.detailed_name);
        price = findViewById(R.id.detailed_price);
        description = findViewById(R.id.detailed_description);
        addToCart = findViewById(R.id.add_to_cart);
    }
    private void ActionToolBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AddToCart()
    {
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("Mypref", Context.MODE_PRIVATE);
                String token = sharedPreferences.getString("token", null);

                int idPost = getIntent().getIntExtra("idPost",0);
                int count = Integer.parseInt(quantity.getText().toString());

                FormAddProductIntoCart form = new FormAddProductIntoCart(idPost, count);
                APICart.apiService.AddProductInCart(token,form).enqueue(new Callback<ResultAddProductIntoCart>() {
                    @Override
                    public void onResponse(Call<ResultAddProductIntoCart> call, Response<ResultAddProductIntoCart> response) {
                        ResultAddProductIntoCart result = response.body();
                        if(result != null && result.result)
                        {
                            Toast.makeText(ProductDetailsActivity.this, "Add product to cart successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(ProductDetailsActivity.this, "Add product to cart fail", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultAddProductIntoCart> call, Throwable t) {
                        Log.e("ADD Product into Cart" , t.getMessage());

                    }
                });

            }
        });
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalquantity < 10)
                {
                    totalquantity++;
                    quantity.setText(String.valueOf(totalquantity));
                }
            }
        });
        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalquantity > 0)
                {
                    totalquantity--;
                    quantity.setText(String.valueOf(totalquantity));
                }
            }
        });
    }

    private void addToCart(){
        String saveCurrentDate,saveCurrentTime;
        Calendar calForDate = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MM dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForDate.getTime());

        final HashMap<String,Object> cartMap = new HashMap<>();

        cartMap.put("producName",viewAllModel.getName());
        cartMap.put("producPrice",price.getText().toString());
        cartMap.put("currentDate",saveCurrentDate);
        cartMap.put("currentTime",saveCurrentTime);
        cartMap.put("totalQuantity",quantity.getText().toString());
        cartMap.put("producName",viewAllModel.getName());
    }

}