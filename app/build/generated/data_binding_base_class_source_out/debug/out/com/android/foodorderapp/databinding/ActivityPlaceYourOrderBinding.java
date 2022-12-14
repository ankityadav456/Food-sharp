// Generated by view binder compiler. Do not edit!
package com.android.foodorderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.foodorderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPlaceYourOrderBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final RecyclerView cartItemsRecyclerView;

  @NonNull
  public final EditText inputAddress;

  @NonNull
  public final EditText inputCity;

  @NonNull
  public final EditText inputName;

  @NonNull
  public final EditText inputState;

  @NonNull
  public final EditText inputZip;

  @NonNull
  public final Button placeOrder;

  @NonNull
  public final SwitchCompat switchDelivery;

  @NonNull
  public final TextView tvCustomerDetails;

  @NonNull
  public final TextView tvDelivery;

  @NonNull
  public final TextView tvDeliveryCharge;

  @NonNull
  public final TextView tvDeliveryChargeAmount;

  @NonNull
  public final TextView tvPickup;

  @NonNull
  public final TextView tvSubtotal;

  @NonNull
  public final TextView tvSubtotalAmount;

  @NonNull
  public final TextView tvTotal;

  @NonNull
  public final TextView tvTotalAmount;

  @NonNull
  public final TextView tvTotalItems;

  private ActivityPlaceYourOrderBinding(@NonNull ScrollView rootView,
      @NonNull RecyclerView cartItemsRecyclerView, @NonNull EditText inputAddress,
      @NonNull EditText inputCity, @NonNull EditText inputName, @NonNull EditText inputState,
      @NonNull EditText inputZip, @NonNull Button placeOrder, @NonNull SwitchCompat switchDelivery,
      @NonNull TextView tvCustomerDetails, @NonNull TextView tvDelivery,
      @NonNull TextView tvDeliveryCharge, @NonNull TextView tvDeliveryChargeAmount,
      @NonNull TextView tvPickup, @NonNull TextView tvSubtotal, @NonNull TextView tvSubtotalAmount,
      @NonNull TextView tvTotal, @NonNull TextView tvTotalAmount, @NonNull TextView tvTotalItems) {
    this.rootView = rootView;
    this.cartItemsRecyclerView = cartItemsRecyclerView;
    this.inputAddress = inputAddress;
    this.inputCity = inputCity;
    this.inputName = inputName;
    this.inputState = inputState;
    this.inputZip = inputZip;
    this.placeOrder = placeOrder;
    this.switchDelivery = switchDelivery;
    this.tvCustomerDetails = tvCustomerDetails;
    this.tvDelivery = tvDelivery;
    this.tvDeliveryCharge = tvDeliveryCharge;
    this.tvDeliveryChargeAmount = tvDeliveryChargeAmount;
    this.tvPickup = tvPickup;
    this.tvSubtotal = tvSubtotal;
    this.tvSubtotalAmount = tvSubtotalAmount;
    this.tvTotal = tvTotal;
    this.tvTotalAmount = tvTotalAmount;
    this.tvTotalItems = tvTotalItems;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPlaceYourOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPlaceYourOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_place_your_order, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPlaceYourOrderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cartItemsRecyclerView;
      RecyclerView cartItemsRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (cartItemsRecyclerView == null) {
        break missingId;
      }

      id = R.id.inputAddress;
      EditText inputAddress = ViewBindings.findChildViewById(rootView, id);
      if (inputAddress == null) {
        break missingId;
      }

      id = R.id.inputCity;
      EditText inputCity = ViewBindings.findChildViewById(rootView, id);
      if (inputCity == null) {
        break missingId;
      }

      id = R.id.inputName;
      EditText inputName = ViewBindings.findChildViewById(rootView, id);
      if (inputName == null) {
        break missingId;
      }

      id = R.id.inputState;
      EditText inputState = ViewBindings.findChildViewById(rootView, id);
      if (inputState == null) {
        break missingId;
      }

      id = R.id.inputZip;
      EditText inputZip = ViewBindings.findChildViewById(rootView, id);
      if (inputZip == null) {
        break missingId;
      }

      id = R.id.placeOrder;
      Button placeOrder = ViewBindings.findChildViewById(rootView, id);
      if (placeOrder == null) {
        break missingId;
      }

      id = R.id.switchDelivery;
      SwitchCompat switchDelivery = ViewBindings.findChildViewById(rootView, id);
      if (switchDelivery == null) {
        break missingId;
      }

      id = R.id.tvCustomerDetails;
      TextView tvCustomerDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvCustomerDetails == null) {
        break missingId;
      }

      id = R.id.tvDelivery;
      TextView tvDelivery = ViewBindings.findChildViewById(rootView, id);
      if (tvDelivery == null) {
        break missingId;
      }

      id = R.id.tvDeliveryCharge;
      TextView tvDeliveryCharge = ViewBindings.findChildViewById(rootView, id);
      if (tvDeliveryCharge == null) {
        break missingId;
      }

      id = R.id.tvDeliveryChargeAmount;
      TextView tvDeliveryChargeAmount = ViewBindings.findChildViewById(rootView, id);
      if (tvDeliveryChargeAmount == null) {
        break missingId;
      }

      id = R.id.tvPickup;
      TextView tvPickup = ViewBindings.findChildViewById(rootView, id);
      if (tvPickup == null) {
        break missingId;
      }

      id = R.id.tvSubtotal;
      TextView tvSubtotal = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotal == null) {
        break missingId;
      }

      id = R.id.tvSubtotalAmount;
      TextView tvSubtotalAmount = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotalAmount == null) {
        break missingId;
      }

      id = R.id.tvTotal;
      TextView tvTotal = ViewBindings.findChildViewById(rootView, id);
      if (tvTotal == null) {
        break missingId;
      }

      id = R.id.tvTotalAmount;
      TextView tvTotalAmount = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalAmount == null) {
        break missingId;
      }

      id = R.id.tvTotalItems;
      TextView tvTotalItems = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalItems == null) {
        break missingId;
      }

      return new ActivityPlaceYourOrderBinding((ScrollView) rootView, cartItemsRecyclerView,
          inputAddress, inputCity, inputName, inputState, inputZip, placeOrder, switchDelivery,
          tvCustomerDetails, tvDelivery, tvDeliveryCharge, tvDeliveryChargeAmount, tvPickup,
          tvSubtotal, tvSubtotalAmount, tvTotal, tvTotalAmount, tvTotalItems);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
