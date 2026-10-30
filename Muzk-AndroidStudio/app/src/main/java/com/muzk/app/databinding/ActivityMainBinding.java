package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final BottomNavigationView bottomNav;
    public final ViewMiniPlayerBinding miniPlayer;
    public final FragmentContainerView navHost;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final MaterialToolbar toolbar;

    private ActivityMainBinding(ConstraintLayout rootView, BottomNavigationView bottomNav, ViewMiniPlayerBinding miniPlayer, FragmentContainerView navHost, ConstraintLayout root, MaterialToolbar toolbar) {
        this.rootView = rootView;
        this.bottomNav = bottomNav;
        this.miniPlayer = miniPlayer;
        this.navHost = navHost;
        this.root = root;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ActivityMainBinding bind(View rootView) {
        View miniPlayer;
        int id = R.id.bottom_nav;
        BottomNavigationView bottomNav = (BottomNavigationView) ViewBindings.findChildViewById(rootView, id);
        if (bottomNav != null && (miniPlayer = ViewBindings.findChildViewById(rootView, (id = R.id.mini_player))) != null) {
            ViewMiniPlayerBinding binding_miniPlayer = ViewMiniPlayerBinding.bind(miniPlayer);
            id = R.id.nav_host;
            FragmentContainerView navHost = (FragmentContainerView) ViewBindings.findChildViewById(rootView, id);
            if (navHost != null) {
                ConstraintLayout root = (ConstraintLayout) rootView;
                id = R.id.toolbar;
                MaterialToolbar toolbar = (MaterialToolbar) ViewBindings.findChildViewById(rootView, id);
                if (toolbar != null) {
                    return new ActivityMainBinding((ConstraintLayout) rootView, bottomNav, binding_miniPlayer, navHost, root, toolbar);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
