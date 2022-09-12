package com.android.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.adapters.RestaurantListAdapter;
import com.android.foodorderapp.model.RestaurantModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;


public class ProfileFragment extends Fragment implements RestaurantListAdapter.RestaurantListClickListener {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);



        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<RestaurantModel> restaurantModelList = getRestaurantData();
        RestaurantListAdapter adapter = new RestaurantListAdapter(restaurantModelList,this);
        recyclerView.setAdapter(adapter);
        return view;
    }



    private List<RestaurantModel> getRestaurantData() {
        InputStream is = getResources().openRawResource(R.raw.restaurent);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {

        }

        String jsonStr = writer.toString();
        Gson gson = new Gson();
        RestaurantModel[] restaurantModels = gson.fromJson(jsonStr, RestaurantModel[].class);
        List<RestaurantModel> restList = Arrays.asList(restaurantModels);

        return restList;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onItemClick(RestaurantModel restaurantModel) {
        Intent intent = new Intent(getContext(), RestaurantMenuActivity.class);
        intent.putExtra("RestaurantModel", restaurantModel);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {

    }
}