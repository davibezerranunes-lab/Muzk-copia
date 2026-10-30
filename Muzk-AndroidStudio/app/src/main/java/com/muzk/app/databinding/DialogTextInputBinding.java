package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class DialogTextInputBinding implements ViewBinding {
    public final TextInputEditText input;
    public final TextInputLayout inputLayout;
    private final FrameLayout rootView;

    private DialogTextInputBinding(FrameLayout rootView, TextInputEditText input, TextInputLayout inputLayout) {
        this.rootView = rootView;
        this.input = input;
        this.inputLayout = inputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogTextInputBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogTextInputBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_text_input, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static DialogTextInputBinding bind(View rootView) {
        int id = R.id.input;
        TextInputEditText input = (TextInputEditText) ViewBindings.findChildViewById(rootView, id);
        if (input != null) {
            id = R.id.input_layout;
            TextInputLayout inputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, id);
            if (inputLayout != null) {
                return new DialogTextInputBinding((FrameLayout) rootView, input, inputLayout);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
