// Generated by view binder compiler. Do not edit!
package com.android.foodorderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.foodorderapp.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogUpdatePasswordBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextInputLayout newpass;

  @NonNull
  public final EditText newpasslog;

  @NonNull
  public final TextInputLayout oldpass;

  @NonNull
  public final EditText oldpasslog;

  @NonNull
  public final Button updatepass;

  private DialogUpdatePasswordBinding(@NonNull LinearLayout rootView,
      @NonNull TextInputLayout newpass, @NonNull EditText newpasslog,
      @NonNull TextInputLayout oldpass, @NonNull EditText oldpasslog, @NonNull Button updatepass) {
    this.rootView = rootView;
    this.newpass = newpass;
    this.newpasslog = newpasslog;
    this.oldpass = oldpass;
    this.oldpasslog = oldpasslog;
    this.updatepass = updatepass;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogUpdatePasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogUpdatePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_update_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogUpdatePasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.newpass;
      TextInputLayout newpass = ViewBindings.findChildViewById(rootView, id);
      if (newpass == null) {
        break missingId;
      }

      id = R.id.newpasslog;
      EditText newpasslog = ViewBindings.findChildViewById(rootView, id);
      if (newpasslog == null) {
        break missingId;
      }

      id = R.id.oldpass;
      TextInputLayout oldpass = ViewBindings.findChildViewById(rootView, id);
      if (oldpass == null) {
        break missingId;
      }

      id = R.id.oldpasslog;
      EditText oldpasslog = ViewBindings.findChildViewById(rootView, id);
      if (oldpasslog == null) {
        break missingId;
      }

      id = R.id.updatepass;
      Button updatepass = ViewBindings.findChildViewById(rootView, id);
      if (updatepass == null) {
        break missingId;
      }

      return new DialogUpdatePasswordBinding((LinearLayout) rootView, newpass, newpasslog, oldpass,
          oldpasslog, updatepass);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
