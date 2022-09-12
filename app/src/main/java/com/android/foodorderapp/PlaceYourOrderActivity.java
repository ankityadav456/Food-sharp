package com.android.foodorderapp;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.foodorderapp.adapters.PlaceYourOrderAdapter;
import com.android.foodorderapp.model.Menu;
import com.android.foodorderapp.model.RestaurantModel;

import java.util.List;

public class PlaceYourOrderActivity extends AppCompatActivity  {

    private EditText inputName, inputAddress, inputCity, inputState, inputZip, cod, inputCardNumber, inputCardExpiry, inputCardPin;
    private RecyclerView cartItemsRecyclerView;
    private TextView tvSubtotalAmount, tvDeliveryChargeAmount, tvDeliveryCharge, tvTotalAmount, buttonPlaceYourOrder;
    private SwitchCompat switchDelivery;
    private boolean isDeliveryOn;
    private PlaceYourOrderAdapter placeYourOrderAdapter;
    private int totalItemInCart = 0;
    private List<Menu> itemsInCartList;
    private List<Menu> menuList = null;
    private static String value;
    public static String getValue() {
        return value;
    }
/*
    private ActivityPlaceYourOrderBinding binding;
    private String addressId;
    private ProgressDialog pd;
    private CheckoutAdapter adapter;
    private ArrayList<ProductListItem> productList;
    private LinearLayoutManager llm;
    private int cartTotal = 0;
    private String completeAddress;
    private String paymentMode;
    int GOOGLE_PAY_REQUEST_CODE = 123;
    public static final String GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
    // payment code
    String amount;
    String name = "Yasier";
    String upiId = "yasirmohammed122002@okicici";
    String transactionNote = "Order purchase";
    String status;
    Uri uri;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_your_order);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorBlack));
        }

        RestaurantModel restaurantModel = getIntent().getParcelableExtra("RestaurantModel");
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#009688"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle("Menu");
        actionBar.setTitle(restaurantModel.getName());
        actionBar.setSubtitle(restaurantModel.getAddress());
        actionBar.setDisplayHomeAsUpEnabled(true);

        inputName = findViewById(R.id.inputName);
        inputAddress = findViewById(R.id.inputAddress);
        inputCity = findViewById(R.id.inputCity);
        inputState = findViewById(R.id.inputState);
        inputZip = findViewById(R.id.inputZip);


        tvSubtotalAmount = findViewById(R.id.tvSubtotalAmount);
        tvDeliveryChargeAmount = findViewById(R.id.tvDeliveryChargeAmount);
        tvDeliveryCharge = findViewById(R.id.tvDeliveryCharge);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        buttonPlaceYourOrder = findViewById(R.id.placeOrder);
        switchDelivery = findViewById(R.id.switchDelivery);
        cartItemsRecyclerView = findViewById(R.id.cartItemsRecyclerView);

        buttonPlaceYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemsInCartList != null && itemsInCartList.size() <= 1) {
                    Toast.makeText(PlaceYourOrderActivity.this, "Please add some items in cart.", Toast.LENGTH_SHORT).show();
                    return;
                }
                onPlaceOrderButtonClick(restaurantModel);
            }
        });

        switchDelivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    inputAddress.setVisibility(View.VISIBLE);
                    inputCity.setVisibility(View.VISIBLE);
                    inputState.setVisibility(View.VISIBLE);
                    inputZip.setVisibility(View.VISIBLE);
                    tvDeliveryChargeAmount.setVisibility(View.VISIBLE);
                    tvDeliveryCharge.setVisibility(View.VISIBLE);
                    isDeliveryOn = true;
                    calculateTotalAmount(restaurantModel);
                } else {
                    inputAddress.setVisibility(View.GONE);
                    inputCity.setVisibility(View.GONE);
                    inputState.setVisibility(View.GONE);
                    inputZip.setVisibility(View.GONE);
                    tvDeliveryChargeAmount.setVisibility(View.GONE);
                    tvDeliveryCharge.setVisibility(View.GONE);
                    isDeliveryOn = false;
                    calculateTotalAmount(restaurantModel);
                }
            }
        });
        initRecyclerView(restaurantModel);
        calculateTotalAmount(restaurantModel);
    }

    //payment code start


//payment code end



    private void calculateTotalAmount(RestaurantModel restaurantModel) {
        float subTotalAmount = 0f;

        for (Menu m : restaurantModel.getMenus()) {
            subTotalAmount += m.getPrice() * m.getTotalInCart();
        }

        tvSubtotalAmount.setText("₹" + String.format("%.2f", subTotalAmount));
        if (isDeliveryOn) {
            tvDeliveryChargeAmount.setText("₹" + String.format("%.2f", restaurantModel.getDelivery_charge()));
            subTotalAmount += restaurantModel.getDelivery_charge();
        }
        tvTotalAmount.setText("₹" + String.format("%.2f", subTotalAmount));
    }



    private void onPlaceOrderButtonClick(RestaurantModel restaurantModel) {
        if(TextUtils.isEmpty(inputName.getText().toString())) {
            inputName.setError("Please enter name ");
            return;
        } else if(isDeliveryOn && TextUtils.isEmpty(inputAddress.getText().toString())) {
            inputAddress.setError("Please enter address ");
            return;
        }else if(isDeliveryOn && TextUtils.isEmpty(inputCity.getText().toString())) {
            inputCity.setError("Please enter city ");
            return;
        }else if(isDeliveryOn && TextUtils.isEmpty(inputState.getText().toString())) {
            inputState.setError("Please enter zip ");
            return;
        }
        value = tvTotalAmount.getText().toString().trim();
        Intent i = new Intent(PlaceYourOrderActivity.this, MainActivity3.class);
        i.putExtra("RestaurantModel", restaurantModel);
        startActivityForResult(i, 1000);
    }

    private void initRecyclerView(RestaurantModel restaurantModel) {
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        placeYourOrderAdapter = new PlaceYourOrderAdapter(restaurantModel.getMenus());
        cartItemsRecyclerView.setAdapter(placeYourOrderAdapter);
    }

//
//    @Override
//    public void onAddToCartClick(Menu menu) {
//        if (itemsInCartList == null) {
//            itemsInCartList = new ArrayList<>();
//        }
//        itemsInCartList.add(menu);
//        totalItemInCart = 0;
//
//        for (Menu m : itemsInCartList) {
//            totalItemInCart = totalItemInCart + m.getTotalInCart();
//        }
//        buttonPlaceYourOrder.setText("Checkout (" + totalItemInCart + ") items");
//    }
//
//    @Override
//    public void onUpdateCartClick(Menu menu) {
//        if (itemsInCartList.contains(menu)) {
//            int index = itemsInCartList.indexOf(menu);
//            itemsInCartList.remove(index);
//            itemsInCartList.add(index, menu);
//
//            totalItemInCart = 0;
//
//            for (Menu m : itemsInCartList) {
//                totalItemInCart = totalItemInCart + m.getTotalInCart();
//            }
//            buttonPlaceYourOrder.setText("Checkout (" + totalItemInCart + ") items");
//        }
//    }
//
//    @Override
//    public void onRemoveFromCartClick(Menu menu) {
//        if (itemsInCartList.contains(menu)) {
//            itemsInCartList.remove(menu);
//            totalItemInCart = 0;
//
//            for (Menu m : itemsInCartList) {
//                totalItemInCart = totalItemInCart + m.getTotalInCart();
//            }
//            buttonPlaceYourOrder.setText("Checkout (" + totalItemInCart + ") items");
//        }
//    }
//

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
            default:
                //do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(Activity.RESULT_CANCELED);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000 && resultCode == Activity.RESULT_OK) {
            //
            finish();
        }
    }
}