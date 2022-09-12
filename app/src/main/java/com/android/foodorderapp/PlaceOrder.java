package com.android.foodorderapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

import com.android.foodorderapp.adapters.CheckoutAdapter;
import com.android.foodorderapp.adapters.PlaceOrderAdapter;
import com.android.foodorderapp.databinding.ActivityPlaceOrderBinding;
import com.android.foodorderapp.model.Menu;
import com.android.foodorderapp.model.Order;
import com.android.foodorderapp.model.ProductListItem;
import com.android.foodorderapp.model.RestaurantModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlaceOrder extends AppCompatActivity {
    private ActivityPlaceOrderBinding binding;
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
    String name = "ANKIT Y";
    String upiId = "ankitgolu20034@oksbi";
    String transactionNote = "Order purchase";
    String status;
    Uri uri;



    private EditText inputName, inputAddress, inputCity, inputState, inputZip, cod, inputCardNumber, inputCardExpiry, inputCardPin;
    private SwitchCompat switchDelivery;
    private boolean isDeliveryOn;
    private int totalItemInCart = 0;
    private List<Menu> itemsInCartList;
    private List<Menu> menuList = null;
    private static String value;
    public static String getValue() {
        return value;
    }



    private RecyclerView cartItemsRecyclerView;
    private PlaceOrderAdapter placeOrderAdapter;
    private TextView tvSubtotalAmount, tvDeliveryChargeAmount, tvDeliveryCharge, tvTotalAmount,buttonPlaceYourOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaceOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorBlack));
        }



        RestaurantModel restaurantModel = getIntent().getParcelableExtra("RestaurantModel");
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().hide();
//       ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#009688"));
//        actionBar.setBackgroundDrawable(colorDrawable);
//        actionBar.setTitle("Menu");
//        actionBar.setTitle(restaurantModel.getName());
//        actionBar.setSubtitle(restaurantModel.getAddress());
//        actionBar.setDisplayHomeAsUpEnabled(true);

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





        addressId = getIntent().getStringExtra("address");
        paymentMode = getIntent().getStringExtra("type");
        pd = new ProgressDialog(this);
        pd.setMessage("Wait a minute");
        productList = new ArrayList<>();
        llm = new LinearLayoutManager(this);

        tvSubtotalAmount = findViewById(R.id.tvSubtotalAmount2);
        tvDeliveryChargeAmount = findViewById(R.id.tvDeliveryChargeAmount2);
        tvDeliveryCharge = findViewById(R.id.tvDeliveryCharge1);
        tvTotalAmount = findViewById(R.id.tvTotalAmount2);
        cartItemsRecyclerView = findViewById(R.id.allItemRecyclerView);
        buttonPlaceYourOrder = findViewById(R.id.placeOrderButton);


        // G Pay
        // configuring the project.
        getProduct();

        if (paymentMode.equals("prepaid")) {
            binding.placeOrderButton.setText("Pay with GPay");
        }

        // placing the order on pressing place order button.
        binding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paymentMode.equals("cod")) {
                    completeOrder();
                } else {
                    // implement Gpay
                    uri = getUpiPaymentUri(name, upiId, transactionNote, amount);
                    payWithGpay();
                }
                if (itemsInCartList != null && itemsInCartList.size() <= 1) {
                    Toast.makeText(PlaceOrder.this, "Please add some items in cart.", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
//        initRecyclerView(restaurantModel);
//        calculateTotalAmount(restaurantModel);
    }

    //  <- payment code starts ->
    private void payWithGpay() {
        if(appIsInstalled(this, GOOGLE_PAY_PACKAGE_NAME)){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(GOOGLE_PAY_PACKAGE_NAME);
            startActivityForResult(intent, GOOGLE_PAY_REQUEST_CODE);
        } else {
            Toast.makeText(PlaceOrder.this, "Please Install GPay.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( data != null) {
            status = data.getStringExtra("Status").toLowerCase();
        }

        if ((RESULT_OK == requestCode) && status.equals("success")){
            completeOrder();
            Toast.makeText(PlaceOrder.this, "Transaction Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(PlaceOrder.this, "Transaction unsuccessful", Toast.LENGTH_SHORT).show();

        }
    }

    private static boolean appIsInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException exception) {
            return false;
        }
    }

    private static Uri getUpiPaymentUri(String name, String upiId, String transactionNote, String amount) {
        return new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tn", transactionNote)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();
    }


    private void getProduct() {
        FirebaseDatabase.getInstance().getReference().
                child("Carts").
                child(FirebaseAuth.getInstance().getUid()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        productList.clear();
                        for(DataSnapshot snapshot1: snapshot.getChildren()){
                            ProductListItem cartItem = snapshot1.getValue(ProductListItem.class);
                            cartTotal += cartItem.getProductPrice();
                            productList.add(cartItem);
                        }
                        // Setting total prices.
                        binding.tvSubtotalAmount2.setText(String.valueOf("₹ " + cartTotal));
                        amount = Integer.toString(cartTotal);
                        binding.tvTotalAmount2.setText(String.valueOf("₹ " + cartTotal));
                        // Setting up recyclerView
                        adapter = new CheckoutAdapter(PlaceOrder.this, productList);
                        binding.allItemRecyclerView.setAdapter(adapter);
                        binding.allItemRecyclerView.setLayoutManager(llm);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
//    // Payment code ends.
//    private void calculateTotalAmount(RestaurantModel restaurantModel) {
//        float subTotalAmount = 0f;
//
//        for (Menu m : restaurantModel.getMenus()) {
//            subTotalAmount += m.getPrice() * m.getTotalInCart();
//        }
//
//        tvSubtotalAmount.setText("₹" + String.format("%.2f", subTotalAmount));
//        tvTotalAmount.setText("₹" + String.format("%.2f", subTotalAmount));
//    }



    private void calculateTotalAmount(RestaurantModel restaurantModel) {
        float subTotalAmount = 0f;

        for (Menu m : restaurantModel.getMenus()) {
            subTotalAmount += m.getPrice() * m.getTotalInCart();
        }

        tvSubtotalAmount.setText("₹" + String.format("%.2f", subTotalAmount));

        tvTotalAmount.setText("₹" + String.format("%.2f", subTotalAmount));
    }

//
//    private void onPlaceOrderButtonClick(RestaurantModel restaurantModel) {
//
//        value = tvTotalAmount.getText().toString().trim();
//        Intent i = new Intent(PlaceOrder.this, MainActivity3.class);
//        i.putExtra("RestaurantModel", restaurantModel);
//        startActivityForResult(i, 1000);
//    }

    private void initRecyclerView(RestaurantModel restaurantModel) {
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        placeOrderAdapter = new PlaceOrderAdapter(restaurantModel.getMenus());
        cartItemsRecyclerView.setAdapter(placeOrderAdapter);
    }


    private void completeOrder() {
        String id = String.valueOf(System.currentTimeMillis()) + FirebaseAuth.getInstance().getUid();
        Order order = new Order(completeAddress, productList, String.valueOf(cartTotal), "placed", FirebaseAuth.getInstance().getUid(), id);
        FirebaseDatabase.getInstance().getReference()
                .child("Orders")
                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()))
                .child(id)
                .setValue(order).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        FirebaseDatabase.getInstance().getReference()
                                .child("Carts")
                                .child(FirebaseAuth.getInstance().getUid())
                                .removeValue().
                                addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(PlaceOrder.this, "Order Placed.", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(PlaceOrder.this, OrderSucceessActivity.class);
                                        startActivity(intent);
                                    }
                                });
                    } 
                });
    }
}