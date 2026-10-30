package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.slider.Slider;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class FragmentPlayerBinding implements ViewBinding {
    public final TextView artist;
    public final MaterialButton btnCollapse;
    public final MaterialButton btnLike;
    public final MaterialButton btnMenu;
    public final MaterialButton btnNext;
    public final MaterialButton btnPlay;
    public final MaterialButton btnPrev;
    public final MaterialButton btnRepeat;
    public final MaterialButton btnShuffle;
    public final TextView contextLabel;
    public final TextView contextName;
    public final ShapeableImageView cover;
    public final TextView duration;
    public final LinearLayout playerRoot;
    public final TextView position;
    private final LinearLayout rootView;
    public final Slider seek;
    public final TextView title;

    private FragmentPlayerBinding(LinearLayout rootView, TextView artist, MaterialButton btnCollapse, MaterialButton btnLike, MaterialButton btnMenu, MaterialButton btnNext, MaterialButton btnPlay, MaterialButton btnPrev, MaterialButton btnRepeat, MaterialButton btnShuffle, TextView contextLabel, TextView contextName, ShapeableImageView cover, TextView duration, LinearLayout playerRoot, TextView position, Slider seek, TextView title) {
        this.rootView = rootView;
        this.artist = artist;
        this.btnCollapse = btnCollapse;
        this.btnLike = btnLike;
        this.btnMenu = btnMenu;
        this.btnNext = btnNext;
        this.btnPlay = btnPlay;
        this.btnPrev = btnPrev;
        this.btnRepeat = btnRepeat;
        this.btnShuffle = btnShuffle;
        this.contextLabel = contextLabel;
        this.contextName = contextName;
        this.cover = cover;
        this.duration = duration;
        this.playerRoot = playerRoot;
        this.position = position;
        this.seek = seek;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_player, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static FragmentPlayerBinding bind(View rootView) {
        int id = R.id.artist;
        TextView artist = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (artist != null) {
            id = R.id.btn_collapse;
            MaterialButton btnCollapse = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
            if (btnCollapse != null) {
                id = R.id.btn_like;
                MaterialButton btnLike = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                if (btnLike != null) {
                    id = R.id.btn_menu;
                    MaterialButton btnMenu = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                    if (btnMenu != null) {
                        id = R.id.btn_next;
                        MaterialButton btnNext = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                        if (btnNext != null) {
                            id = R.id.btn_play;
                            MaterialButton btnPlay = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                            if (btnPlay != null) {
                                id = R.id.btn_prev;
                                MaterialButton btnPrev = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                                if (btnPrev != null) {
                                    id = R.id.btn_repeat;
                                    MaterialButton btnRepeat = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                                    if (btnRepeat != null) {
                                        id = R.id.btn_shuffle;
                                        MaterialButton btnShuffle = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                                        if (btnShuffle != null) {
                                            id = R.id.context_label;
                                            TextView contextLabel = (TextView) ViewBindings.findChildViewById(rootView, id);
                                            if (contextLabel != null) {
                                                id = R.id.context_name;
                                                TextView contextName = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                if (contextName != null) {
                                                    id = R.id.cover;
                                                    ShapeableImageView cover = (ShapeableImageView) ViewBindings.findChildViewById(rootView, id);
                                                    if (cover != null) {
                                                        id = R.id.duration;
                                                        TextView duration = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                        if (duration != null) {
                                                            LinearLayout playerRoot = (LinearLayout) rootView;
                                                            id = R.id.position;
                                                            TextView position = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                            if (position != null) {
                                                                id = R.id.seek;
                                                                Slider seek = (Slider) ViewBindings.findChildViewById(rootView, id);
                                                                if (seek != null) {
                                                                    id = R.id.title;
                                                                    TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                                    if (title != null) {
                                                                        return new FragmentPlayerBinding((LinearLayout) rootView, artist, btnCollapse, btnLike, btnMenu, btnNext, btnPlay, btnPrev, btnRepeat, btnShuffle, contextLabel, contextName, cover, duration, playerRoot, position, seek, title);
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
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
