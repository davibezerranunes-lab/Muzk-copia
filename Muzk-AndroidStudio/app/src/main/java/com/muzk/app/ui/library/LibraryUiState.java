package com.muzk.app.ui.library;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.Playlist;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u007f\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015¨\u00062"}, d2 = {"Lcom/muzk/app/ui/library/LibraryUiState;", "", "hasPermission", "", "loaded", "tab", "Lcom/muzk/app/ui/library/LibraryTab;", "openFolder", "", "openPlaylistId", "rows", "", "Lcom/muzk/app/ui/library/LibraryRow;", "queue", "Lcom/muzk/app/data/LocalTrack;", "playlists", "Lcom/muzk/app/data/Playlist;", "selected", "<init>", "(ZZLcom/muzk/app/ui/library/LibraryTab;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getHasPermission", "()Z", "getLoaded", "getTab", "()Lcom/muzk/app/ui/library/LibraryTab;", "getOpenFolder", "()Ljava/lang/String;", "getOpenPlaylistId", "getRows", "()Ljava/util/List;", "getQueue", "getPlaylists", "getSelected", "isInside", "isSelecting", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class LibraryUiState {
    private final boolean hasPermission;
    private final boolean loaded;
    private final String openFolder;
    private final String openPlaylistId;
    private final List<Playlist> playlists;
    private final List<LocalTrack> queue;
    private final List<LibraryRow> rows;
    private final List<LocalTrack> selected;
    private final LibraryTab tab;

    public LibraryUiState() {
        this(false, false, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasPermission() {
        return this.hasPermission;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getLoaded() {
        return this.loaded;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LibraryTab getTab() {
        return this.tab;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOpenFolder() {
        return this.openFolder;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOpenPlaylistId() {
        return this.openPlaylistId;
    }

    public final List<LibraryRow> component6() {
        return this.rows;
    }

    public final List<LocalTrack> component7() {
        return this.queue;
    }

    public final List<Playlist> component8() {
        return this.playlists;
    }

    public final List<LocalTrack> component9() {
        return this.selected;
    }

    public final LibraryUiState copy(boolean hasPermission, boolean loaded, LibraryTab tab, String openFolder, String openPlaylistId, List<? extends LibraryRow> rows, List<LocalTrack> queue, List<Playlist> playlists, List<LocalTrack> selected) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(rows, "rows");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(playlists, "playlists");
        Intrinsics.checkNotNullParameter(selected, "selected");
        return new LibraryUiState(hasPermission, loaded, tab, openFolder, openPlaylistId, rows, queue, playlists, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryUiState)) {
            return false;
        }
        LibraryUiState libraryUiState = (LibraryUiState) other;
        return this.hasPermission == libraryUiState.hasPermission && this.loaded == libraryUiState.loaded && this.tab == libraryUiState.tab && Intrinsics.areEqual(this.openFolder, libraryUiState.openFolder) && Intrinsics.areEqual(this.openPlaylistId, libraryUiState.openPlaylistId) && Intrinsics.areEqual(this.rows, libraryUiState.rows) && Intrinsics.areEqual(this.queue, libraryUiState.queue) && Intrinsics.areEqual(this.playlists, libraryUiState.playlists) && Intrinsics.areEqual(this.selected, libraryUiState.selected);
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.hasPermission) * 31) + Boolean.hashCode(this.loaded)) * 31) + this.tab.hashCode()) * 31) + (this.openFolder == null ? 0 : this.openFolder.hashCode())) * 31) + (this.openPlaylistId != null ? this.openPlaylistId.hashCode() : 0)) * 31) + this.rows.hashCode()) * 31) + this.queue.hashCode()) * 31) + this.playlists.hashCode()) * 31) + this.selected.hashCode();
    }

    public String toString() {
        return "LibraryUiState(hasPermission=" + this.hasPermission + ", loaded=" + this.loaded + ", tab=" + this.tab + ", openFolder=" + this.openFolder + ", openPlaylistId=" + this.openPlaylistId + ", rows=" + this.rows + ", queue=" + this.queue + ", playlists=" + this.playlists + ", selected=" + this.selected + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LibraryUiState(boolean hasPermission, boolean loaded, LibraryTab tab, String openFolder, String openPlaylistId, List<? extends LibraryRow> rows, List<LocalTrack> queue, List<Playlist> playlists, List<LocalTrack> selected) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(rows, "rows");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(playlists, "playlists");
        Intrinsics.checkNotNullParameter(selected, "selected");
        this.hasPermission = hasPermission;
        this.loaded = loaded;
        this.tab = tab;
        this.openFolder = openFolder;
        this.openPlaylistId = openPlaylistId;
        this.rows = rows;
        this.queue = queue;
        this.playlists = playlists;
        this.selected = selected;
    }

    public /* synthetic */ LibraryUiState(boolean z, boolean z2, LibraryTab libraryTab, String str, String str2, List list, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? LibraryTab.TRACKS : libraryTab, (i & 8) != 0 ? null : str, (i & 16) == 0 ? str2 : null, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2, (i & 128) != 0 ? CollectionsKt.emptyList() : list3, (i & 256) != 0 ? CollectionsKt.emptyList() : list4);
    }

    public final boolean getHasPermission() {
        return this.hasPermission;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    public final LibraryTab getTab() {
        return this.tab;
    }

    public final String getOpenFolder() {
        return this.openFolder;
    }

    public final String getOpenPlaylistId() {
        return this.openPlaylistId;
    }

    public final List<LibraryRow> getRows() {
        return this.rows;
    }

    public final List<LocalTrack> getQueue() {
        return this.queue;
    }

    public final List<Playlist> getPlaylists() {
        return this.playlists;
    }

    public final List<LocalTrack> getSelected() {
        return this.selected;
    }

    public final boolean isInside() {
        return (this.openFolder == null && this.openPlaylistId == null) ? false : true;
    }

    public final boolean isSelecting() {
        return !this.selected.isEmpty();
    }
}
