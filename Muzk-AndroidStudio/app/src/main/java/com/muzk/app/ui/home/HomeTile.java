package com.muzk.app.ui.home;

import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.download.DownloadWorker;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/muzk/app/ui/home/HomeTile;", "", "kind", "Lcom/muzk/app/ui/home/HomeTile$Kind;", "key", "", DownloadWorker.KEY_TITLE, "cover", "Landroid/net/Uri;", "tracks", "", "Lcom/muzk/app/data/LocalTrack;", "<init>", "(Lcom/muzk/app/ui/home/HomeTile$Kind;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/util/List;)V", "getKind", "()Lcom/muzk/app/ui/home/HomeTile$Kind;", "getKey", "()Ljava/lang/String;", "getTitle", "getCover", "()Landroid/net/Uri;", "getTracks", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Kind", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class HomeTile {
    private final Uri cover;
    private final String key;
    private final Kind kind;
    private final String title;
    private final List<LocalTrack> tracks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeTile copy$default(HomeTile homeTile, Kind kind, String str, String str2, Uri uri, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            kind = homeTile.kind;
        }
        if ((i & 2) != 0) {
            str = homeTile.key;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = homeTile.title;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            uri = homeTile.cover;
        }
        Uri uri2 = uri;
        if ((i & 16) != 0) {
            list = homeTile.tracks;
        }
        return homeTile.copy(kind, str3, str4, uri2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Kind getKind() {
        return this.kind;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Uri getCover() {
        return this.cover;
    }

    public final List<LocalTrack> component5() {
        return this.tracks;
    }

    public final HomeTile copy(Kind kind, String key, String title, Uri cover, List<LocalTrack> tracks) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        return new HomeTile(kind, key, title, cover, tracks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeTile)) {
            return false;
        }
        HomeTile homeTile = (HomeTile) other;
        return this.kind == homeTile.kind && Intrinsics.areEqual(this.key, homeTile.key) && Intrinsics.areEqual(this.title, homeTile.title) && Intrinsics.areEqual(this.cover, homeTile.cover) && Intrinsics.areEqual(this.tracks, homeTile.tracks);
    }

    public int hashCode() {
        return (((((((this.kind.hashCode() * 31) + this.key.hashCode()) * 31) + this.title.hashCode()) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + this.tracks.hashCode();
    }

    public String toString() {
        return "HomeTile(kind=" + this.kind + ", key=" + this.key + ", title=" + this.title + ", cover=" + this.cover + ", tracks=" + this.tracks + ")";
    }

    public HomeTile(Kind kind, String key, String title, Uri cover, List<LocalTrack> tracks) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        this.kind = kind;
        this.key = key;
        this.title = title;
        this.cover = cover;
        this.tracks = tracks;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Uri getCover() {
        return this.cover;
    }

    public final List<LocalTrack> getTracks() {
        return this.tracks;
    }

    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/muzk/app/ui/home/HomeTile$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYLIST", "RECENT", "FOLDER", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum Kind {
        PLAYLIST,
        RECENT,
        FOLDER;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }
    }
}
