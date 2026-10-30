package com.muzk.app.playback;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.download.DownloadWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J§\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001a¨\u0006<"}, d2 = {"Lcom/muzk/app/playback/PlayerUiState;", "", "hasMedia", "", DownloadWorker.KEY_TITLE, "", "artist", "cover", "isPlaying", "isBuffering", "positionMs", "", "durationMs", "shuffle", "repeatMode", "", "mediaId", "isRemote", "source", "album", DownloadWorker.KEY_ERROR, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;ZZJJZILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHasMedia", "()Z", "getTitle", "()Ljava/lang/String;", "getArtist", "getCover", "()Ljava/lang/Object;", "getPositionMs", "()J", "getDurationMs", "getShuffle", "getRepeatMode", "()I", "getMediaId", "getSource", "getAlbum", "getError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class PlayerUiState {
    private final String album;
    private final String artist;
    private final Object cover;
    private final long durationMs;
    private final String error;
    private final boolean hasMedia;
    private final boolean isBuffering;
    private final boolean isPlaying;
    private final boolean isRemote;
    private final String mediaId;
    private final long positionMs;
    private final int repeatMode;
    private final boolean shuffle;
    private final String source;
    private final String title;

    public PlayerUiState() {
        this(false, null, null, null, false, false, 0L, 0L, false, 0, null, false, null, null, null, 32767, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasMedia() {
        return this.hasMedia;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getRepeatMode() {
        return this.repeatMode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsRemote() {
        return this.isRemote;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getAlbum() {
        return this.album;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getArtist() {
        return this.artist;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object getCover() {
        return this.cover;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsBuffering() {
        return this.isBuffering;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getPositionMs() {
        return this.positionMs;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getShuffle() {
        return this.shuffle;
    }

    public final PlayerUiState copy(boolean hasMedia, String title, String artist, Object cover, boolean isPlaying, boolean isBuffering, long positionMs, long durationMs, boolean shuffle, int repeatMode, String mediaId, boolean isRemote, String source, String album, String error) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(album, "album");
        return new PlayerUiState(hasMedia, title, artist, cover, isPlaying, isBuffering, positionMs, durationMs, shuffle, repeatMode, mediaId, isRemote, source, album, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerUiState)) {
            return false;
        }
        PlayerUiState playerUiState = (PlayerUiState) other;
        return this.hasMedia == playerUiState.hasMedia && Intrinsics.areEqual(this.title, playerUiState.title) && Intrinsics.areEqual(this.artist, playerUiState.artist) && Intrinsics.areEqual(this.cover, playerUiState.cover) && this.isPlaying == playerUiState.isPlaying && this.isBuffering == playerUiState.isBuffering && this.positionMs == playerUiState.positionMs && this.durationMs == playerUiState.durationMs && this.shuffle == playerUiState.shuffle && this.repeatMode == playerUiState.repeatMode && Intrinsics.areEqual(this.mediaId, playerUiState.mediaId) && this.isRemote == playerUiState.isRemote && Intrinsics.areEqual(this.source, playerUiState.source) && Intrinsics.areEqual(this.album, playerUiState.album) && Intrinsics.areEqual(this.error, playerUiState.error);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Boolean.hashCode(this.hasMedia) * 31) + this.title.hashCode()) * 31) + this.artist.hashCode()) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + Boolean.hashCode(this.isPlaying)) * 31) + Boolean.hashCode(this.isBuffering)) * 31) + Long.hashCode(this.positionMs)) * 31) + Long.hashCode(this.durationMs)) * 31) + Boolean.hashCode(this.shuffle)) * 31) + Integer.hashCode(this.repeatMode)) * 31) + (this.mediaId == null ? 0 : this.mediaId.hashCode())) * 31) + Boolean.hashCode(this.isRemote)) * 31) + (this.source == null ? 0 : this.source.hashCode())) * 31) + this.album.hashCode()) * 31) + (this.error != null ? this.error.hashCode() : 0);
    }

    public String toString() {
        return "PlayerUiState(hasMedia=" + this.hasMedia + ", title=" + this.title + ", artist=" + this.artist + ", cover=" + this.cover + ", isPlaying=" + this.isPlaying + ", isBuffering=" + this.isBuffering + ", positionMs=" + this.positionMs + ", durationMs=" + this.durationMs + ", shuffle=" + this.shuffle + ", repeatMode=" + this.repeatMode + ", mediaId=" + this.mediaId + ", isRemote=" + this.isRemote + ", source=" + this.source + ", album=" + this.album + ", error=" + this.error + ")";
    }

    public PlayerUiState(boolean hasMedia, String title, String artist, Object cover, boolean isPlaying, boolean isBuffering, long positionMs, long durationMs, boolean shuffle, int repeatMode, String mediaId, boolean isRemote, String source, String album, String error) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        Intrinsics.checkNotNullParameter(album, "album");
        this.hasMedia = hasMedia;
        this.title = title;
        this.artist = artist;
        this.cover = cover;
        this.isPlaying = isPlaying;
        this.isBuffering = isBuffering;
        this.positionMs = positionMs;
        this.durationMs = durationMs;
        this.shuffle = shuffle;
        this.repeatMode = repeatMode;
        this.mediaId = mediaId;
        this.isRemote = isRemote;
        this.source = source;
        this.album = album;
        this.error = error;
    }

    public /* synthetic */ PlayerUiState(boolean z, String str, String str2, Object obj, boolean z2, boolean z3, long j, long j2, boolean z4, int i, String str3, boolean z5, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? null : obj, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? false : z3, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? j2 : 0L, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? 0 : i, (i2 & 1024) != 0 ? null : str3, (i2 & 2048) != 0 ? false : z5, (i2 & 4096) != 0 ? null : str4, (i2 & 8192) != 0 ? "" : str5, (i2 & 16384) != 0 ? null : str6);
    }

    public final boolean getHasMedia() {
        return this.hasMedia;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final Object getCover() {
        return this.cover;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final boolean isBuffering() {
        return this.isBuffering;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final boolean getShuffle() {
        return this.shuffle;
    }

    public final int getRepeatMode() {
        return this.repeatMode;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final boolean isRemote() {
        return this.isRemote;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getError() {
        return this.error;
    }
}
