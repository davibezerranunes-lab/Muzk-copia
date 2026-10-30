package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemHomeTileBinding implements ViewBinding {
    public final ImageView cover;
    public final ImageView icon;
    public final FrameLayout iconBox;
    private final MaterialCardView rootView;
    public final TextView title;

    private ItemHomeTileBinding(MaterialCardView rootView, ImageView cover, ImageView icon, FrameLayout iconBox, TextView title) {
        this.rootView = rootView;
        this.cover = cover;
        this.icon = icon;
        this.iconBox = iconBox;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemHomeTileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemHomeTileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_home_tile, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemHomeTileBinding bind(View rootView) {
        int id = R.id.cover;
        ImageView cover = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (cover != null) {
            id = R.id.icon;
            ImageView icon = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (icon != null) {
                id = R.id.icon_box;
                FrameLayout iconBox = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (iconBox != null) {
                    id = R.id.title;
                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (title != null) {
                        return new ItemHomeTileBinding((MaterialCardView) rootView, cover, icon, iconBox, title);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
