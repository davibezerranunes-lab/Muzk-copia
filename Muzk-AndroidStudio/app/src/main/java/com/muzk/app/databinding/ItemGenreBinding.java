package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemGenreBinding implements ViewBinding {
    public final TextView name;
    private final FrameLayout rootView;

    private ItemGenreBinding(FrameLayout rootView, TextView name) {
        this.rootView = rootView;
        this.name = name;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemGenreBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemGenreBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_genre, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemGenreBinding bind(View rootView) {
        int id = R.id.name;
        TextView name = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (name != null) {
            return new ItemGenreBinding((FrameLayout) rootView, name);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
