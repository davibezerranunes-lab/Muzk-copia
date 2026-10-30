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
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.muzk.app.R;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRemoteTrackBinding implements ViewBinding {
    public final MaterialButton btnDownload;
    public final MaterialButton btnListen;
    public final ShapeableImageView cover;
    public final CircularProgressIndicator listenProgress;
    private final LinearLayout rootView;
    public final TextView subtitle;
    public final TextView title;

    private ItemRemoteTrackBinding(LinearLayout rootView, MaterialButton btnDownload, MaterialButton btnListen, ShapeableImageView cover, CircularProgressIndicator listenProgress, TextView subtitle, TextView title) {
        this.rootView = rootView;
        this.btnDownload = btnDownload;
        this.btnListen = btnListen;
        this.cover = cover;
        this.listenProgress = listenProgress;
        this.subtitle = subtitle;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemRemoteTrackBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemRemoteTrackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_remote_track, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static ItemRemoteTrackBinding bind(View rootView) {
        int id = R.id.btn_download;
        MaterialButton btnDownload = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
        if (btnDownload != null) {
            id = R.id.btn_listen;
            MaterialButton btnListen = (MaterialButton) ViewBindings.findChildViewById(rootView, id);
            if (btnListen != null) {
                id = R.id.cover;
                ShapeableImageView cover = (ShapeableImageView) ViewBindings.findChildViewById(rootView, id);
                if (cover != null) {
                    id = R.id.listen_progress;
                    CircularProgressIndicator listenProgress = (CircularProgressIndicator) ViewBindings.findChildViewById(rootView, id);
                    if (listenProgress != null) {
                        id = R.id.subtitle;
                        TextView subtitle = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (subtitle != null) {
                            id = R.id.title;
                            TextView title = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (title != null) {
                                return new ItemRemoteTrackBinding((LinearLayout) rootView, btnDownload, btnListen, cover, listenProgress, subtitle, title);
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
