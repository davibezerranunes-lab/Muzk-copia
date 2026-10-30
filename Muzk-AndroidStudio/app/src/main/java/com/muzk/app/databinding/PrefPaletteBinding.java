package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class PrefPaletteBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout swatches;
    public final TextView title;

    private PrefPaletteBinding(LinearLayout rootView, LinearLayout swatches, TextView title) {
        this.rootView = rootView;
        this.swatches = swatches;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PrefPaletteBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PrefPaletteBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.pref_palette, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static PrefPaletteBinding bind(View rootView) {
        int id = R.id.swatches;
        LinearLayout swatches = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (swatches != null) {
            id = android.R.id.title;
            TextView title = (TextView) ViewBindings.findChildViewById(rootView, android.R.id.title);
            if (title != null) {
                return new PrefPaletteBinding((LinearLayout) rootView, swatches, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
