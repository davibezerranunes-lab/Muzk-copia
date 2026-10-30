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
public final class ItemHeaderBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView title;

    private ItemHeaderBinding(LinearLayout rootView, TextView title) {
        this.rootView = rootView;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemHeaderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemHeaderBinding bind(View rootView) {
        int id = R.id.title;
        TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (title != null) {
            return new ItemHeaderBinding((LinearLayout) rootView, title);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
