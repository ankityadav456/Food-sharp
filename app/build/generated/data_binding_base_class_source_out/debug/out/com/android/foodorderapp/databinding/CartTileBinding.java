// Generated by view binder compiler. Do not edit!
package com.android.foodorderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.foodorderapp.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CartTileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView deleteCartItem;

  @NonNull
  public final MaterialCardView materialCardView2;

  @NonNull
  public final ImageFilterView minusButtonCart;

  @NonNull
  public final ImageFilterView plusButtonCart;

  @NonNull
  public final ImageView productImageCart;

  @NonNull
  public final TextView productNameCart;

  @NonNull
  public final TextView productPriceCart;

  @NonNull
  public final TextView productQuantityCart;

  private CartTileBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView deleteCartItem,
      @NonNull MaterialCardView materialCardView2, @NonNull ImageFilterView minusButtonCart,
      @NonNull ImageFilterView plusButtonCart, @NonNull ImageView productImageCart,
      @NonNull TextView productNameCart, @NonNull TextView productPriceCart,
      @NonNull TextView productQuantityCart) {
    this.rootView = rootView;
    this.deleteCartItem = deleteCartItem;
    this.materialCardView2 = materialCardView2;
    this.minusButtonCart = minusButtonCart;
    this.plusButtonCart = plusButtonCart;
    this.productImageCart = productImageCart;
    this.productNameCart = productNameCart;
    this.productPriceCart = productPriceCart;
    this.productQuantityCart = productQuantityCart;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CartTileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CartTileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.cart_tile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CartTileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.delete_cart_item;
      ImageView deleteCartItem = ViewBindings.findChildViewById(rootView, id);
      if (deleteCartItem == null) {
        break missingId;
      }

      id = R.id.materialCardView2;
      MaterialCardView materialCardView2 = ViewBindings.findChildViewById(rootView, id);
      if (materialCardView2 == null) {
        break missingId;
      }

      id = R.id.minusButtonCart;
      ImageFilterView minusButtonCart = ViewBindings.findChildViewById(rootView, id);
      if (minusButtonCart == null) {
        break missingId;
      }

      id = R.id.plus_button_cart;
      ImageFilterView plusButtonCart = ViewBindings.findChildViewById(rootView, id);
      if (plusButtonCart == null) {
        break missingId;
      }

      id = R.id.product_image_cart;
      ImageView productImageCart = ViewBindings.findChildViewById(rootView, id);
      if (productImageCart == null) {
        break missingId;
      }

      id = R.id.product_name_cart;
      TextView productNameCart = ViewBindings.findChildViewById(rootView, id);
      if (productNameCart == null) {
        break missingId;
      }

      id = R.id.product_price_cart;
      TextView productPriceCart = ViewBindings.findChildViewById(rootView, id);
      if (productPriceCart == null) {
        break missingId;
      }

      id = R.id.product_quantity_cart;
      TextView productQuantityCart = ViewBindings.findChildViewById(rootView, id);
      if (productQuantityCart == null) {
        break missingId;
      }

      return new CartTileBinding((ConstraintLayout) rootView, deleteCartItem, materialCardView2,
          minusButtonCart, plusButtonCart, productImageCart, productNameCart, productPriceCart,
          productQuantityCart);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
