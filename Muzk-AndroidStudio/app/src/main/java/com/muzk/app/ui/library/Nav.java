package com.muzk.app.ui.library;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/muzk/app/ui/library/Nav;", "", "hasPermission", "", "loaded", "tab", "Lcom/muzk/app/ui/library/LibraryTab;", "folder", "", "playlistId", "<init>", "(ZZLcom/muzk/app/ui/library/LibraryTab;Ljava/lang/String;Ljava/lang/String;)V", "getHasPermission", "()Z", "getLoaded", "getTab", "()Lcom/muzk/app/ui/library/LibraryTab;", "getFolder", "()Ljava/lang/String;", "getPlaylistId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final /* data */ class Nav {
    private final String folder;
    private final boolean hasPermission;
    private final boolean loaded;
    private final String playlistId;
    private final LibraryTab tab;

    public Nav() {
        this(false, false, null, null, null, 31, null);
    }

    public static /* synthetic */ Nav copy$default(Nav nav, boolean z, boolean z2, LibraryTab libraryTab, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = nav.hasPermission;
        }
        if ((i & 2) != 0) {
            z2 = nav.loaded;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            libraryTab = nav.tab;
        }
        LibraryTab libraryTab2 = libraryTab;
        if ((i & 8) != 0) {
            str = nav.folder;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = nav.playlistId;
        }
        return nav.copy(z, z3, libraryTab2, str3, str2);
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
    public final String getFolder() {
        return this.folder;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPlaylistId() {
        return this.playlistId;
    }

    public final Nav copy(boolean hasPermission, boolean loaded, LibraryTab tab, String folder, String playlistId) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        return new Nav(hasPermission, loaded, tab, folder, playlistId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Nav)) {
            return false;
        }
        Nav nav = (Nav) other;
        return this.hasPermission == nav.hasPermission && this.loaded == nav.loaded && this.tab == nav.tab && Intrinsics.areEqual(this.folder, nav.folder) && Intrinsics.areEqual(this.playlistId, nav.playlistId);
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.hasPermission) * 31) + Boolean.hashCode(this.loaded)) * 31) + this.tab.hashCode()) * 31) + (this.folder == null ? 0 : this.folder.hashCode())) * 31) + (this.playlistId != null ? this.playlistId.hashCode() : 0);
    }

    public String toString() {
        return "Nav(hasPermission=" + this.hasPermission + ", loaded=" + this.loaded + ", tab=" + this.tab + ", folder=" + this.folder + ", playlistId=" + this.playlistId + ")";
    }

    public Nav(boolean hasPermission, boolean loaded, LibraryTab tab, String folder, String playlistId) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.hasPermission = hasPermission;
        this.loaded = loaded;
        this.tab = tab;
        this.folder = folder;
        this.playlistId = playlistId;
    }

    public /* synthetic */ Nav(boolean z, boolean z2, LibraryTab libraryTab, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? LibraryTab.TRACKS : libraryTab, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
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

    public final String getFolder() {
        return this.folder;
    }

    public final String getPlaylistId() {
        return this.playlistId;
    }
}
