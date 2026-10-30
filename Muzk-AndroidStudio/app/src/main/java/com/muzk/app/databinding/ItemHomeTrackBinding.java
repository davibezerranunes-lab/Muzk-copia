package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemHomeTrackBinding implements ViewBinding {
    public final ShapeableImageView cover;
    public final TextView rank;
    private final LinearLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    private ItemHomeTrackBinding(LinearLayout rootView, ShapeableImageView cover, TextView rank, TextView subtitle, TextView title) {
        this.rootView = rootView;
        this.cover = cover;
        this.rank = rank;
        this.subtitle = subtitle;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemHomeTrackBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemHomeTrackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_home_track, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemHomeTrackBinding bind(View rootView) {
        int id = R.id.cover;
        ShapeableImageView cover = (ShapeableImageView) ViewBindings.findChildViewById(rootView, id);
        if (cover != null) {
            id = R.id.rank;
            TextView rank = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (rank != null) {
                id = R.id.subtitle;
                TextView subtitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (subtitle != null) {
                    id = R.id.title;
                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (title != null) {
                        return new ItemHomeTrackBinding((LinearLayout) rootView, cover, rank, subtitle, title);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
