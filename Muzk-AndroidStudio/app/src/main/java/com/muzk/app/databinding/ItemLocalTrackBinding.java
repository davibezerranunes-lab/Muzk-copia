package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemLocalTrackBinding implements ViewBinding {
    public final MaterialButton btnMore;
    public final ImageView check;
    public final ShapeableImageView cover;
    private final LinearLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    private ItemLocalTrackBinding(LinearLayout rootView, MaterialButton btnMore, ImageView check, ShapeableImageView cover, TextView subtitle, TextView title) {
        this.rootView = rootView;
        this.btnMore = btnMore;
        this.check = check;
        this.cover = cover;
        this.subtitle = subtitle;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemLocalTrackBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemLocalTrackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_local_track, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemLocalTrackBinding bind(View rootView) {
        int id = R.id.btn_more;
        MaterialButton btnMore = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
        if (btnMore != null) {
            id = R.id.check;
            ImageView check = (ImageView) ViewBindings.findChildViewById(rootView, id);
            if (check != null) {
                id = R.id.cover;
                ShapeableImageView cover = (ShapeableImageView) ViewBindings.findChildViewById(rootView, id);
                if (cover != null) {
                    id = R.id.subtitle;
                    TextView subtitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (subtitle != null) {
                        id = R.id.title;
                        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (title != null) {
                            return new ItemLocalTrackBinding((LinearLayout) rootView, btnMore, check, cover, subtitle, title);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
