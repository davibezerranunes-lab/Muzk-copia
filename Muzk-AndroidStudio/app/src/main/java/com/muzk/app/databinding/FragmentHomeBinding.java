package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentHomeBinding implements ViewBinding {
    public final LinearLayout empty;
    public final MaterialButton emptyAction;
    public final TextView emptyText;
    public final MaterialButton goSearch;
    public final TextView greeting;
    private final NestedScrollView rootView;
    public final RecyclerView tiles;
    public final RecyclerView topList;
    public final TextView topTitle;

    private FragmentHomeBinding(NestedScrollView rootView, LinearLayout empty, MaterialButton emptyAction, TextView emptyText, MaterialButton goSearch, TextView greeting, RecyclerView tiles, RecyclerView topList, TextView topTitle) {
        this.rootView = rootView;
        this.empty = empty;
        this.emptyAction = emptyAction;
        this.emptyText = emptyText;
        this.goSearch = goSearch;
        this.greeting = greeting;
        this.tiles = tiles;
        this.topList = topList;
        this.topTitle = topTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentHomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHomeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_home, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentHomeBinding bind(View rootView) {
        int id = R.id.empty;
        LinearLayout empty = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (empty != null) {
            id = R.id.empty_action;
            MaterialButton emptyAction = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
            if (emptyAction != null) {
                id = R.id.empty_text;
                TextView emptyText = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (emptyText != null) {
                    id = R.id.go_search;
                    MaterialButton goSearch = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                    if (goSearch != null) {
                        id = R.id.greeting;
                        TextView greeting = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (greeting != null) {
                            id = R.id.tiles;
                            RecyclerView tiles = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                            if (tiles != null) {
                                id = R.id.top_list;
                                RecyclerView topList = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                                if (topList != null) {
                                    id = R.id.top_title;
                                    TextView topTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (topTitle != null) {
                                        return new FragmentHomeBinding((NestedScrollView) rootView, empty, emptyAction, emptyText, goSearch, greeting, tiles, topList, topTitle);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
