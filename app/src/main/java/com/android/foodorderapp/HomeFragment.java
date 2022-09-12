package com.android.foodorderapp;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.adapters.RestaurantListAdapter1;
import com.android.foodorderapp.adapters.RestaurantListAdapter3;
import com.android.foodorderapp.adapters.SliderAdapter;
import com.android.foodorderapp.model.RestaurantModel;
import com.google.gson.Gson;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment implements RestaurantListAdapter1.RestaurantListClickListener, RestaurantListAdapter3.RestaurantListClickListener {

    ImageView img1,img2,img3,img4;
    ImageView cartButtonHome;

    RecyclerView rcv;
    SliderView sliderView;
    int[] images = {R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven};


    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager layoutManager3;
    View view;
    RestaurantListAdapter1 recyclerAdapter;
    private SearchView searchView;
    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cartButtonHome = view.findViewById(R.id.cartButtonHome);
        cartButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CartScreens.class);
                startActivity(intent);
            }
        });

        img1 =(ImageView) view.findViewById(R.drawable.one);

        searchView = view.findViewById(R.id.search_bar);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });

        sliderView = view.findViewById(R.id.image_slider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.one));
        sliderItems.add(new SliderItem(R.drawable.two));
        sliderItems.add(new SliderItem(R.drawable.three));
        sliderItems.add(new SliderItem(R.drawable.four));
        sliderItems.add(new SliderItem(R.drawable.five));

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

// for Restaurant

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView5);
        layoutManager= new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        List<RestaurantModel> restaurantModelList = getRestaurantData();
        RestaurantListAdapter1 adapter = new RestaurantListAdapter1(restaurantModelList,this);
        recyclerView.setAdapter(adapter);

        //

        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerView3);
        layoutManager3= new GridLayoutManager(getContext(),3);
        recyclerView3.setLayoutManager(layoutManager3);
        List<RestaurantModel> restaurantModelList3 =getRestaurantData1();
        RestaurantListAdapter3 adapter1 = new RestaurantListAdapter3(restaurantModelList3, this);
        recyclerView3.setAdapter(adapter1);


        return view;
    }

    private void filterList(String newText) {
        List<ClipData.Item> filteredList = new ArrayList<>();


    }

    private List<RestaurantModel> getRestaurantData1() {
        InputStream is = getResources().openRawResource(R.raw.restaurent3);
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


    private List<RestaurantModel> getRestaurantData() {
        InputStream is = getResources().openRawResource(R.raw.restaurent1);
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
    public class SliderItem {
        private int image;

        SliderItem(int image) {
            this.image = image;
        }

        public int getImage() {
            return image;
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

  /*  @Override
    public void onItemClick(RestaurantModel restaurantModel) {
        Intent intent = new Intent(getContext(), RestaurantMenuActivity.class);
        intent.putExtra("RestaurantModel", restaurantModel);
        startActivity(intent);

    }*/


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