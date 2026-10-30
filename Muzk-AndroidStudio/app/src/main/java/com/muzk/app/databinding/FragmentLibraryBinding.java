package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentLibraryBinding implements ViewBinding {
    public final Chip chipFolders;
    public final Chip chipPlaylists;
    public final Chip chipTracks;
    public final ChipGroup chips;
    public final LinearLayout empty;
    public final MaterialButton emptyAction;
    public final TextView emptyText;
    public final ExtendedFloatingActionButton fab;
    public final RecyclerView list;
    private final LinearLayout rootView;
    public final MaterialToolbar selectionBar;
    public final HorizontalScrollView tabs;

    private FragmentLibraryBinding(LinearLayout rootView, Chip chipFolders, Chip chipPlaylists, Chip chipTracks, ChipGroup chips, LinearLayout empty, MaterialButton emptyAction, TextView emptyText, ExtendedFloatingActionButton fab, RecyclerView list, MaterialToolbar selectionBar, HorizontalScrollView tabs) {
        this.rootView = rootView;
        this.chipFolders = chipFolders;
        this.chipPlaylists = chipPlaylists;
        this.chipTracks = chipTracks;
        this.chips = chips;
        this.empty = empty;
        this.emptyAction = emptyAction;
        this.emptyText = emptyText;
        this.fab = fab;
        this.list = list;
        this.selectionBar = selectionBar;
        this.tabs = tabs;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLibraryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentLibraryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_library, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentLibraryBinding bind(View rootView) {
        int id = R.id.chip_folders;
        Chip chipFolders = (Chip) ViewBindings.findChildViewById(rootView, id);
        if (chipFolders != null) {
            id = R.id.chip_playlists;
            Chip chipPlaylists = (Chip) ViewBindings.findChildViewById(rootView, id);
            if (chipPlaylists != null) {
                id = R.id.chip_tracks;
                Chip chipTracks = (Chip) ViewBindings.findChildViewById(rootView, id);
                if (chipTracks != null) {
                    id = R.id.chips;
                    ChipGroup chips = (ChipGroup) ViewBindings.findChildViewById(rootView, id);
                    if (chips != null) {
                        id = R.id.empty;
                        LinearLayout empty = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                        if (empty != null) {
                            id = R.id.empty_action;
                            MaterialButton emptyAction = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                            if (emptyAction != null) {
                                id = R.id.empty_text;
                                TextView emptyText = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (emptyText != null) {
                                    id = R.id.fab;
                                    ExtendedFloatingActionButton fab = (ExtendedFloatingActionButton) ViewBindings.findChildViewById(rootView, id);
                                    if (fab != null) {
                                        id = R.id.list;
                                        RecyclerView list = (RecyclerView) ViewBindings.findChildViewById(rootView, id);
                                        if (list != null) {
                                            id = R.id.selection_bar;
                                            MaterialToolbar selectionBar = (MaterialToolbar) ViewBindings.findChildViewById(rootView, id);
                                            if (selectionBar != null) {
                                                id = R.id.tabs;
                                                HorizontalScrollView tabs = (HorizontalScrollView) ViewBindings.findChildViewById(rootView, id);
                                                if (tabs != null) {
                                                    return new FragmentLibraryBinding((LinearLayout) rootView, chipFolders, chipPlaylists, chipTracks, chips, empty, emptyAction, emptyText, fab, list, selectionBar, tabs);
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
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
