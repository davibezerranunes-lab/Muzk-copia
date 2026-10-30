package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRecentSearchBinding implements ViewBinding {
    public final TextView query;
    public final ImageButton remove;
    private final LinearLayout rootView;

    private ItemRecentSearchBinding(LinearLayout rootView, TextView query, ImageButton remove) {
        this.rootView = rootView;
        this.query = query;
        this.remove = remove;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemRecentSearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemRecentSearchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_recent_search, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemRecentSearchBinding bind(View rootView) {
        int id = R.id.query;
        TextView query = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (query != null) {
            id = R.id.remove;
            ImageButton remove = (ImageButton) ViewBindings.findChildViewById(rootView, id);
            if (remove != null) {
                return new ItemRecentSearchBinding((LinearLayout) rootView, query, remove);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
