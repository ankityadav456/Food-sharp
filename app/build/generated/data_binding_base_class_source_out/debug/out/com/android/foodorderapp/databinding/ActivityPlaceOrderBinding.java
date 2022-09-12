// Generated by view binder compiler. Do not edit!
package com.android.foodorderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.foodorderapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPlaceOrderBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView Cod;

  @NonNull
  public final RecyclerView allItemRecyclerView;

  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final ConstraintLayout constraintLayout4;

  @NonNull
  public final TextView orderDetailsText;

  @NonNull
  public final TextView paymentModeText;

  @NonNull
  public final Button placeOrderButton;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView tvDeliveryCharge1;

  @NonNull
  public final TextView tvDeliveryChargeAmount2;

  @NonNull
  public final TextView tvSubtotal1;

  @NonNull
  public final TextView tvSubtotalAmount2;

  @NonNull
  public final TextView tvTotal1;

  @NonNull
  public final TextView tvTotalAmount2;

  private ActivityPlaceOrderBinding(@NonNull ConstraintLayout rootView, @NonNull TextView Cod,
      @NonNull RecyclerView allItemRecyclerView, @NonNull ConstraintLayout constraintLayout3,
      @NonNull ConstraintLayout constraintLayout4, @NonNull TextView orderDetailsText,
      @NonNull TextView paymentModeText, @NonNull Button placeOrderButton,
      @NonNull TextView textView6, @NonNull TextView tvDeliveryCharge1,
      @NonNull TextView tvDeliveryChargeAmount2, @NonNull TextView tvSubtotal1,
      @NonNull TextView tvSubtotalAmount2, @NonNull TextView tvTotal1,
      @NonNull TextView tvTotalAmount2) {
    this.rootView = rootView;
    this.Cod = Cod;
    this.allItemRecyclerView = allItemRecyclerView;
    this.constraintLayout3 = constraintLayout3;
    this.constraintLayout4 = constraintLayout4;
    this.orderDetailsText = orderDetailsText;
    this.paymentModeText = paymentModeText;
    this.placeOrderButton = placeOrderButton;
    this.textView6 = textView6;
    this.tvDeliveryCharge1 = tvDeliveryCharge1;
    this.tvDeliveryChargeAmount2 = tvDeliveryChargeAmount2;
    this.tvSubtotal1 = tvSubtotal1;
    this.tvSubtotalAmount2 = tvSubtotalAmount2;
    this.tvTotal1 = tvTotal1;
    this.tvTotalAmount2 = tvTotalAmount2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPlaceOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPlaceOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_place_order, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPlaceOrderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Cod;
      TextView Cod = ViewBindings.findChildViewById(rootView, id);
      if (Cod == null) {
        break missingId;
      }

      id = R.id.allItemRecyclerView;
      RecyclerView allItemRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (allItemRecyclerView == null) {
        break missingId;
      }

      id = R.id.constraintLayout3;
      ConstraintLayout constraintLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout3 == null) {
        break missingId;
      }

      id = R.id.constraintLayout4;
      ConstraintLayout constraintLayout4 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout4 == null) {
        break missingId;
      }

      id = R.id.orderDetailsText;
      TextView orderDetailsText = ViewBindings.findChildViewById(rootView, id);
      if (orderDetailsText == null) {
        break missingId;
      }

      id = R.id.paymentModeText;
      TextView paymentModeText = ViewBindings.findChildViewById(rootView, id);
      if (paymentModeText == null) {
        break missingId;
      }

      id = R.id.placeOrderButton;
      Button placeOrderButton = ViewBindings.findChildViewById(rootView, id);
      if (placeOrderButton == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.tvDeliveryCharge1;
      TextView tvDeliveryCharge1 = ViewBindings.findChildViewById(rootView, id);
      if (tvDeliveryCharge1 == null) {
        break missingId;
      }

      id = R.id.tvDeliveryChargeAmount2;
      TextView tvDeliveryChargeAmount2 = ViewBindings.findChildViewById(rootView, id);
      if (tvDeliveryChargeAmount2 == null) {
        break missingId;
      }

      id = R.id.tvSubtotal1;
      TextView tvSubtotal1 = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotal1 == null) {
        break missingId;
      }

      id = R.id.tvSubtotalAmount2;
      TextView tvSubtotalAmount2 = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotalAmount2 == null) {
        break missingId;
      }

      id = R.id.tvTotal1;
      TextView tvTotal1 = ViewBindings.findChildViewById(rootView, id);
      if (tvTotal1 == null) {
        break missingId;
      }

      id = R.id.tvTotalAmount2;
      TextView tvTotalAmount2 = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalAmount2 == null) {
        break missingId;
      }

      return new ActivityPlaceOrderBinding((ConstraintLayout) rootView, Cod, allItemRecyclerView,
          constraintLayout3, constraintLayout4, orderDetailsText, paymentModeText, placeOrderButton,
          textView6, tvDeliveryCharge1, tvDeliveryChargeAmount2, tvSubtotal1, tvSubtotalAmount2,
          tvTotal1, tvTotalAmount2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
