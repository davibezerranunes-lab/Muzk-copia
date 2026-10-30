package com.muzk.app.data;

import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"toMediaItem", "Landroidx/media3/common/MediaItem;", "Lcom/muzk/app/data/LocalTrack;", "Lcom/muzk/app/data/RemoteTrack;", "streamUrl", "", "EXTRA_REMOTE", "coverModel", "", "mediaId", "artworkUri", "Landroid/net/Uri;", "formatDuration", "ms", "", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ModelsKt {
    public static final String EXTRA_REMOTE = "muzk.remote";

    public static final MediaItem toMediaItem(LocalTrack $this$toMediaItem) {
        Intrinsics.checkNotNullParameter($this$toMediaItem, "<this>");
        MediaItem mediaItemBuild = new MediaItem.Builder().setMediaId($this$toMediaItem.getUri().toString()).setUri($this$toMediaItem.getUri()).setMediaMetadata(new MediaMetadata.Builder().setTitle($this$toMediaItem.getTitle()).setArtist($this$toMediaItem.getArtist()).setAlbumTitle($this$toMediaItem.getAlbum()).setIsPlayable(true).build()).build();
        Intrinsics.checkNotNullExpressionValue(mediaItemBuild, "build(...)");
        return mediaItemBuild;
    }

    public static final MediaItem toMediaItem(RemoteTrack $this$toMediaItem, String streamUrl) {
        Intrinsics.checkNotNullParameter($this$toMediaItem, "<this>");
        Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
        MediaItem.Builder uri = new MediaItem.Builder().setMediaId($this$toMediaItem.getPageUrl()).setUri(streamUrl);
        MediaMetadata.Builder artist = new MediaMetadata.Builder().setTitle($this$toMediaItem.getTitle()).setArtist($this$toMediaItem.getArtist());
        String p0 = $this$toMediaItem.getThumbnail();
        MediaItem mediaItemBuild = uri.setMediaMetadata(artist.setArtworkUri(p0 != null ? Uri.parse(p0) : null).setIsPlayable(true).setExtras(BundleKt.bundleOf(TuplesKt.to(EXTRA_REMOTE, true))).build()).build();
        Intrinsics.checkNotNullExpressionValue(mediaItemBuild, "build(...)");
        return mediaItemBuild;
    }

    public static final Object coverModel(String mediaId, Uri artworkUri) {
        if (artworkUri != null) {
            return artworkUri;
        }
        if (mediaId == null || !StringsKt.startsWith$default(mediaId, "content://", false, 2, (Object) null)) {
            return null;
        }
        Uri uri = Uri.parse(mediaId);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return new AudioCover(uri);
    }

    public static final String formatDuration(long ms) {
        if (ms <= 0) {
            return "--:--";
        }
        long total = ms / ((long) 1000);
        long j = 3600;
        long h = total / j;
        long j2 = 60;
        long m = (total % j) / j2;
        long s = total % j2;
        String str = h > 0 ? String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(h), Long.valueOf(m), Long.valueOf(s)}, 3)) : String.format("%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(m), Long.valueOf(s)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
