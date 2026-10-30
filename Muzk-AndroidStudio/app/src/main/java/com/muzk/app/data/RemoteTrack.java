package com.muzk.app.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.muzk.app.download.DownloadWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/muzk/app/data/RemoteTrack;", "", TtmlNode.ATTR_ID, "", "pageUrl", DownloadWorker.KEY_TITLE, "artist", "thumbnail", "durationSec", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getPageUrl", "getTitle", "getArtist", "getThumbnail", "getDurationSec", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class RemoteTrack {
    private final String artist;
    private final long durationSec;
    private final String id;
    private final String pageUrl;
    private final String thumbnail;
    private final String title;

    public static /* synthetic */ RemoteTrack copy$default(RemoteTrack remoteTrack, String str, String str2, String str3, String str4, String str5, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteTrack.id;
        }
        if ((i & 2) != 0) {
            str2 = remoteTrack.pageUrl;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = remoteTrack.title;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = remoteTrack.artist;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = remoteTrack.thumbnail;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            j = remoteTrack.durationSec;
        }
        return remoteTrack.copy(str, str6, str7, str8, str9, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPageUrl() {
        return this.pageUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getArtist() {
        return this.artist;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getDurationSec() {
        return this.durationSec;
    }

    public final RemoteTrack copy(String id, String pageUrl, String title, String artist, String thumbnail, long durationSec) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        return new RemoteTrack(id, pageUrl, title, artist, thumbnail, durationSec);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteTrack)) {
            return false;
        }
        RemoteTrack remoteTrack = (RemoteTrack) other;
        return Intrinsics.areEqual(this.id, remoteTrack.id) && Intrinsics.areEqual(this.pageUrl, remoteTrack.pageUrl) && Intrinsics.areEqual(this.title, remoteTrack.title) && Intrinsics.areEqual(this.artist, remoteTrack.artist) && Intrinsics.areEqual(this.thumbnail, remoteTrack.thumbnail) && this.durationSec == remoteTrack.durationSec;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.pageUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.artist.hashCode()) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + Long.hashCode(this.durationSec);
    }

    public String toString() {
        return "RemoteTrack(id=" + this.id + ", pageUrl=" + this.pageUrl + ", title=" + this.title + ", artist=" + this.artist + ", thumbnail=" + this.thumbnail + ", durationSec=" + this.durationSec + ")";
    }

    public RemoteTrack(String id, String pageUrl, String title, String artist, String thumbnail, long durationSec) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        this.id = id;
        this.pageUrl = pageUrl;
        this.title = title;
        this.artist = artist;
        this.thumbnail = thumbnail;
        this.durationSec = durationSec;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getDurationSec() {
        return this.durationSec;
    }
}
