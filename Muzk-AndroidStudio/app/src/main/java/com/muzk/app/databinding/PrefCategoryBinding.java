package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class PrefCategoryBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView title;

    private PrefCategoryBinding(TextView rootView, TextView title) {
        this.rootView = rootView;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static PrefCategoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PrefCategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.pref_category, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static PrefCategoryBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TextView title = (TextView) rootView;
        return new PrefCategoryBinding((TextView) rootView, title);
    }
}
