package com.muzk.app.ui.library;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.Playlist;
import com.muzk.app.download.DownloadWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/muzk/app/ui/library/LibraryRow;", "", "Header", "Track", "Folder", "PlaylistItem", "Lcom/muzk/app/ui/library/LibraryRow$Folder;", "Lcom/muzk/app/ui/library/LibraryRow$Header;", "Lcom/muzk/app/ui/library/LibraryRow$PlaylistItem;", "Lcom/muzk/app/ui/library/LibraryRow$Track;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface LibraryRow {

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/muzk/app/ui/library/LibraryRow$Header;", "Lcom/muzk/app/ui/library/LibraryRow;", DownloadWorker.KEY_TITLE, "", "<init>", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Header implements LibraryRow {
        private final String title;

        public static /* synthetic */ Header copy$default(Header header, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = header.title;
            }
            return header.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final Header copy(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new Header(title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Header) && Intrinsics.areEqual(this.title, ((Header) other).title);
        }

        public int hashCode() {
            return this.title.hashCode();
        }

        public String toString() {
            return "Header(title=" + this.title + ")";
        }

        public Header(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/muzk/app/ui/library/LibraryRow$Track;", "Lcom/muzk/app/ui/library/LibraryRow;", "track", "Lcom/muzk/app/data/LocalTrack;", "playlistId", "", "selecting", "", "selected", "<init>", "(Lcom/muzk/app/data/LocalTrack;Ljava/lang/String;ZZ)V", "getTrack", "()Lcom/muzk/app/data/LocalTrack;", "getPlaylistId", "()Ljava/lang/String;", "getSelecting", "()Z", "getSelected", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Track implements LibraryRow {
        private final String playlistId;
        private final boolean selected;
        private final boolean selecting;
        private final LocalTrack track;

        public static /* synthetic */ Track copy$default(Track track, LocalTrack localTrack, String str, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                localTrack = track.track;
            }
            if ((i & 2) != 0) {
                str = track.playlistId;
            }
            if ((i & 4) != 0) {
                z = track.selecting;
            }
            if ((i & 8) != 0) {
                z2 = track.selected;
            }
            return track.copy(localTrack, str, z, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LocalTrack getTrack() {
            return this.track;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPlaylistId() {
            return this.playlistId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getSelecting() {
            return this.selecting;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getSelected() {
            return this.selected;
        }

        public final Track copy(LocalTrack track, String playlistId, boolean selecting, boolean selected) {
            Intrinsics.checkNotNullParameter(track, "track");
            return new Track(track, playlistId, selecting, selected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.track, track.track) && Intrinsics.areEqual(this.playlistId, track.playlistId) && this.selecting == track.selecting && this.selected == track.selected;
        }

        public int hashCode() {
            return (((((this.track.hashCode() * 31) + (this.playlistId == null ? 0 : this.playlistId.hashCode())) * 31) + Boolean.hashCode(this.selecting)) * 31) + Boolean.hashCode(this.selected);
        }

        public String toString() {
            return "Track(track=" + this.track + ", playlistId=" + this.playlistId + ", selecting=" + this.selecting + ", selected=" + this.selected + ")";
        }

        public Track(LocalTrack track, String playlistId, boolean selecting, boolean selected) {
            Intrinsics.checkNotNullParameter(track, "track");
            this.track = track;
            this.playlistId = playlistId;
            this.selecting = selecting;
            this.selected = selected;
        }

        public /* synthetic */ Track(LocalTrack localTrack, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(localTrack, str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
        }

        public final LocalTrack getTrack() {
            return this.track;
        }

        public final String getPlaylistId() {
            return this.playlistId;
        }

        public final boolean getSelecting() {
            return this.selecting;
        }

        public final boolean getSelected() {
            return this.selected;
        }
    }

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/muzk/app/ui/library/LibraryRow$Folder;", "Lcom/muzk/app/ui/library/LibraryRow;", "path", "", "name", "count", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getPath", "()Ljava/lang/String;", "getName", "getCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Folder implements LibraryRow {
        private final int count;
        private final String name;
        private final String path;

        public static /* synthetic */ Folder copy$default(Folder folder, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = folder.path;
            }
            if ((i2 & 2) != 0) {
                str2 = folder.name;
            }
            if ((i2 & 4) != 0) {
                i = folder.count;
            }
            return folder.copy(str, str2, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final Folder copy(String path, String name, int count) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(name, "name");
            return new Folder(path, name, count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Folder)) {
                return false;
            }
            Folder folder = (Folder) other;
            return Intrinsics.areEqual(this.path, folder.path) && Intrinsics.areEqual(this.name, folder.name) && this.count == folder.count;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.count);
        }

        public String toString() {
            return "Folder(path=" + this.path + ", name=" + this.name + ", count=" + this.count + ")";
        }

        public Folder(String path, String name, int count) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(name, "name");
            this.path = path;
            this.name = name;
            this.count = count;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPath() {
            return this.path;
        }
    }

    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/muzk/app/ui/library/LibraryRow$PlaylistItem;", "Lcom/muzk/app/ui/library/LibraryRow;", "playlist", "Lcom/muzk/app/data/Playlist;", "count", "", "<init>", "(Lcom/muzk/app/data/Playlist;I)V", "getPlaylist", "()Lcom/muzk/app/data/Playlist;", "getCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class PlaylistItem implements LibraryRow {
        private final int count;
        private final Playlist playlist;

        public static /* synthetic */ PlaylistItem copy$default(PlaylistItem playlistItem, Playlist playlist, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                playlist = playlistItem.playlist;
            }
            if ((i2 & 2) != 0) {
                i = playlistItem.count;
            }
            return playlistItem.copy(playlist, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Playlist getPlaylist() {
            return this.playlist;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final PlaylistItem copy(Playlist playlist, int count) {
            Intrinsics.checkNotNullParameter(playlist, "playlist");
            return new PlaylistItem(playlist, count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlaylistItem)) {
                return false;
            }
            PlaylistItem playlistItem = (PlaylistItem) other;
            return Intrinsics.areEqual(this.playlist, playlistItem.playlist) && this.count == playlistItem.count;
        }

        public int hashCode() {
            return (this.playlist.hashCode() * 31) + Integer.hashCode(this.count);
        }

        public String toString() {
            return "PlaylistItem(playlist=" + this.playlist + ", count=" + this.count + ")";
        }

        public PlaylistItem(Playlist playlist, int count) {
            Intrinsics.checkNotNullParameter(playlist, "playlist");
            this.playlist = playlist;
            this.count = count;
        }

        public final int getCount() {
            return this.count;
        }

        public final Playlist getPlaylist() {
            return this.playlist;
        }
    }
}
