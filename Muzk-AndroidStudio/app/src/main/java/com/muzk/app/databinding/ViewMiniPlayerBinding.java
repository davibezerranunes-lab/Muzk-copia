package com.muzk.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewMiniPlayerBinding implements ViewBinding {
    public final TextView miniArtist;
    public final MaterialCardView miniCard;
    public final ShapeableImageView miniCover;
    public final MaterialButton miniNext;
    public final MaterialButton miniPlay;
    public final LinearProgressIndicator miniProgress;
    public final TextView miniTitle;
    private final MaterialCardView rootView;

    private ViewMiniPlayerBinding(MaterialCardView rootView, TextView miniArtist, MaterialCardView miniCard, ShapeableImageView miniCover, MaterialButton miniNext, MaterialButton miniPlay, LinearProgressIndicator miniProgress, TextView miniTitle) {
        this.rootView = rootView;
        this.miniArtist = miniArtist;
        this.miniCard = miniCard;
        this.miniCover = miniCover;
        this.miniNext = miniNext;
        this.miniPlay = miniPlay;
        this.miniProgress = miniProgress;
        this.miniTitle = miniTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ViewMiniPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewMiniPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.view_mini_player, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ViewMiniPlayerBinding bind(View rootView) {
        int id = R.id.mini_artist;
        TextView miniArtist = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (miniArtist != null) {
            MaterialCardView miniCard = (MaterialCardView) rootView;
            id = R.id.mini_cover;
            ShapeableImageView miniCover = (ShapeableImageView) ViewBindings.findChildViewById(rootView, id);
            if (miniCover != null) {
                id = R.id.mini_next;
                MaterialButton miniNext = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                if (miniNext != null) {
                    id = R.id.mini_play;
                    MaterialButton miniPlay = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
                    if (miniPlay != null) {
                        id = R.id.mini_progress;
                        LinearProgressIndicator miniProgress = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, id);
                        if (miniProgress != null) {
                            id = R.id.mini_title;
                            TextView miniTitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (miniTitle != null) {
                                return new ViewMiniPlayerBinding((MaterialCardView) rootView, miniArtist, miniCard, miniCover, miniNext, miniPlay, miniProgress, miniTitle);
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
