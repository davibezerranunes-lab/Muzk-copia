package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemCollectionBinding implements ViewBinding {
    public final MaterialButton btnMore;
    public final ImageView icon;
    public final FrameLayout iconBox;
    private final LinearLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    private ItemCollectionBinding(LinearLayout rootView, MaterialButton btnMore, ImageView icon, FrameLayout iconBox, TextView subtitle, TextView title) {
        this.rootView = rootView;
        this.btnMore = btnMore;
        this.icon = icon;
        this.iconBox = iconBox;
        this.subtitle = subtitle;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemCollectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemCollectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_collection, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemCollectionBinding bind(View rootView) {
        int id = R.id.btn_more;
        MaterialButton btnMore = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
        if (btnMore != null) {
            id = R.id.icon;
            ImageView icon = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (icon != null) {
                id = R.id.icon_box;
                FrameLayout iconBox = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
                if (iconBox != null) {
                    id = R.id.subtitle;
                    TextView subtitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (subtitle != null) {
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new ItemCollectionBinding((LinearLayout) rootView, btnMore, icon, iconBox, subtitle, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
