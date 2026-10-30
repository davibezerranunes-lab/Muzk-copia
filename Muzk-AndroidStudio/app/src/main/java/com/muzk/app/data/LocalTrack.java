package com.muzk.app.data;

import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.muzk.app.download.DownloadWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lcom/muzk/app/data/LocalTrack;", "", TtmlNode.ATTR_ID, "", "uri", "Landroid/net/Uri;", DownloadWorker.KEY_TITLE, "", "artist", "album", "durationMs", "folderPath", "folderName", "dateAdded", "<init>", "(JLandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "getUri", "()Landroid/net/Uri;", "getTitle", "()Ljava/lang/String;", "getArtist", "getAlbum", "getDurationMs", "getFolderPath", "getFolderName", "getDateAdded", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class LocalTrack {
    private final String album;
    private final String artist;
    private final long dateAdded;
    private final long durationMs;
    private final String folderName;
    private final String folderPath;
    private final long id;
    private final String title;
    private final Uri uri;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Uri getUri() {
        return this.uri;
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
    public final String getAlbum() {
        return this.album;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFolderPath() {
        return this.folderPath;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getDateAdded() {
        return this.dateAdded;
    }

    public final LocalTrack copy(long id, Uri uri, String title, String artist, String album, long durationMs, String folderPath, String folderName, long dateAdded) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(album, "album");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        return new LocalTrack(id, uri, title, artist, album, durationMs, folderPath, folderName, dateAdded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalTrack)) {
            return false;
        }
        LocalTrack localTrack = (LocalTrack) other;
        return this.id == localTrack.id && Intrinsics.areEqual(this.uri, localTrack.uri) && Intrinsics.areEqual(this.title, localTrack.title) && Intrinsics.areEqual(this.artist, localTrack.artist) && Intrinsics.areEqual(this.album, localTrack.album) && this.durationMs == localTrack.durationMs && Intrinsics.areEqual(this.folderPath, localTrack.folderPath) && Intrinsics.areEqual(this.folderName, localTrack.folderName) && this.dateAdded == localTrack.dateAdded;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.id) * 31) + this.uri.hashCode()) * 31) + this.title.hashCode()) * 31) + this.artist.hashCode()) * 31) + this.album.hashCode()) * 31) + Long.hashCode(this.durationMs)) * 31) + this.folderPath.hashCode()) * 31) + this.folderName.hashCode()) * 31) + Long.hashCode(this.dateAdded);
    }

    public String toString() {
        return "LocalTrack(id=" + this.id + ", uri=" + this.uri + ", title=" + this.title + ", artist=" + this.artist + ", album=" + this.album + ", durationMs=" + this.durationMs + ", folderPath=" + this.folderPath + ", folderName=" + this.folderName + ", dateAdded=" + this.dateAdded + ")";
    }

    public LocalTrack(long id, Uri uri, String title, String artist, String album, long durationMs, String folderPath, String folderName, long dateAdded) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(album, "album");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        this.id = id;
        this.uri = uri;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationMs = durationMs;
        this.folderPath = folderPath;
        this.folderName = folderName;
        this.dateAdded = dateAdded;
    }

    public final long getId() {
        return this.id;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getFolderPath() {
        return this.folderPath;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }
}
