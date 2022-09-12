package com.android.foodorderapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.adapters.CartAdapter;
import com.android.foodorderapp.model.ProductListItem;

import java.util.ArrayList;

public class CartScreens extends AppCompatActivity  {
    private ArrayList<ProductListItem> cartItemList;
    RecyclerView recyclerView;
    private CartAdapter adapter;

    private LinearLayoutManager llm;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_screens);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().hide();




        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}