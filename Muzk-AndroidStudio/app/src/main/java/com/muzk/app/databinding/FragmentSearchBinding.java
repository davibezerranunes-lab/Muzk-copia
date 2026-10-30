package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentSearchBinding implements ViewBinding {
    public final NestedScrollView discover;
    public final LinearLayout genres;
    public final LinearLayout recentList;
    public final TextView recentTitle;
    public final RecyclerView results;
    private final LinearLayout rootView;
    public final ImageButton searchClear;
    public final TextView searchEmpty;
    public final EditText searchInput;
    public final LinearLayout searchLayout;
    public final LinearProgressIndicator searchProgress;

    private FragmentSearchBinding(LinearLayout rootView, NestedScrollView discover, LinearLayout genres, LinearLayout recentList, TextView recentTitle, RecyclerView results, ImageButton searchClear, TextView searchEmpty, EditText searchInput, LinearLayout searchLayout, LinearProgressIndicator searchProgress) {
        this.rootView = rootView;
        this.discover = discover;
        this.genres = genres;
        this.recentList = recentList;
        this.recentTitle = recentTitle;
        this.results = results;
        this.searchClear = searchClear;
        this.searchEmpty = searchEmpty;
        this.searchInput = searchInput;
        this.searchLayout = searchLayout;
        this.searchProgress = searchProgress;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSearchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_search, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentSearchBinding bind(View rootView) {
        int id = R.id.discover;
        NestedScrollView discover = (NestedScrollView) ViewBindings.findChildViewById(rootView, id);
        if (discover != null) {
            id = R.id.genres;
            LinearLayout genres = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (genres != null) {
                id = R.id.recent_list;
                LinearLayout recentList = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                if (recentList != null) {
                    id = R.id.recent_title;
                    TextView recentTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (recentTitle != null) {
                        id = R.id.results;
                        RecyclerView results = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                        if (results != null) {
                            id = R.id.search_clear;
                            ImageButton searchClear = (ImageButton) ViewBindings.findChildViewById(rootView, id);
                            if (searchClear != null) {
                                id = R.id.search_empty;
                                TextView searchEmpty = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (searchEmpty != null) {
                                    id = R.id.search_input;
                                    EditText searchInput = (EditText) ViewBindings.findChildViewById(rootView, id);
                                    if (searchInput != null) {
                                        id = R.id.search_layout;
                                        LinearLayout searchLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                                        if (searchLayout != null) {
                                            id = R.id.search_progress;
                                            LinearProgressIndicator searchProgress = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, id);
                                            if (searchProgress != null) {
                                                return new FragmentSearchBinding((LinearLayout) rootView, discover, genres, recentList, recentTitle, results, searchClear, searchEmpty, searchInput, searchLayout, searchProgress);
                                            }
                                        }
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
