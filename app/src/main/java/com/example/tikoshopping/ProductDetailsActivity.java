package com.example.tikoshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tikoshopping.models.ViewAllModel;

public class ProductDetailsActivity extends AppCompatActivity {
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
        String path = "http://192.168.1.153:3000"+intent.getStringExtra("Path");
        setContentView(R.layout.activity_product_details);


        initView();
        initData(name,description,price,path);

    }

    private void initData(String title, String Description, int Price, String path)
    {
        name.setText(title);
        description.setText(Description);
        price.setText("Giá: "+Price+"VND");
        Glide.with(getApplicationContext()).load(path).into(detailedImg);
//        price.setText(postSales.getPrice();postSales
//
    }

    private void initView()
    {
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
}