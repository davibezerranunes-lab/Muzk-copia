package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemSwatchBinding implements ViewBinding {
    public final View dot;
    public final TextView label;
    public final FrameLayout ring;
    private final LinearLayout rootView;

    private ItemSwatchBinding(LinearLayout rootView, View dot, TextView label, FrameLayout ring) {
        this.rootView = rootView;
        this.dot = dot;
        this.label = label;
        this.ring = ring;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemSwatchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemSwatchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_swatch, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemSwatchBinding bind(View rootView) {
        int id = R.id.dot;
        View dot = ViewBindings.findChildViewById(rootView, id);
        if (dot != null) {
            id = R.id.label;
            TextView label = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (label != null) {
                id = R.id.ring;
                FrameLayout ring = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (ring != null) {
                    return new ItemSwatchBinding((LinearLayout) rootView, dot, label, ring);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
