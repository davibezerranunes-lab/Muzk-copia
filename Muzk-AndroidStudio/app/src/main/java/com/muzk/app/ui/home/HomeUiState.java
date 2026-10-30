package com.muzk.app.ui.home;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/muzk/app/ui/home/HomeUiState;", "", "hasPermission", "", "loaded", "tiles", "", "Lcom/muzk/app/ui/home/HomeTile;", "mostPlayed", "Lcom/muzk/app/ui/home/HomeTrack;", "<init>", "(ZZLjava/util/List;Ljava/util/List;)V", "getHasPermission", "()Z", "getLoaded", "getTiles", "()Ljava/util/List;", "getMostPlayed", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class HomeUiState {
    private final boolean hasPermission;
    private final boolean loaded;
    private final List<HomeTrack> mostPlayed;
    private final List<HomeTile> tiles;

    public HomeUiState() {
        this(false, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeUiState copy$default(HomeUiState homeUiState, boolean z, boolean z2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = homeUiState.hasPermission;
        }
        if ((i & 2) != 0) {
            z2 = homeUiState.loaded;
        }
        if ((i & 4) != 0) {
            list = homeUiState.tiles;
        }
        if ((i & 8) != 0) {
            list2 = homeUiState.mostPlayed;
        }
        return homeUiState.copy(z, z2, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasPermission() {
        return this.hasPermission;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getLoaded() {
        return this.loaded;
    }

    public final List<HomeTile> component3() {
        return this.tiles;
    }

    public final List<HomeTrack> component4() {
        return this.mostPlayed;
    }

    public final HomeUiState copy(boolean hasPermission, boolean loaded, List<HomeTile> tiles, List<HomeTrack> mostPlayed) {
        Intrinsics.checkNotNullParameter(tiles, "tiles");
        Intrinsics.checkNotNullParameter(mostPlayed, "mostPlayed");
        return new HomeUiState(hasPermission, loaded, tiles, mostPlayed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeUiState)) {
            return false;
        }
        HomeUiState homeUiState = (HomeUiState) other;
        return this.hasPermission == homeUiState.hasPermission && this.loaded == homeUiState.loaded && Intrinsics.areEqual(this.tiles, homeUiState.tiles) && Intrinsics.areEqual(this.mostPlayed, homeUiState.mostPlayed);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.hasPermission) * 31) + Boolean.hashCode(this.loaded)) * 31) + this.tiles.hashCode()) * 31) + this.mostPlayed.hashCode();
    }

    public String toString() {
        return "HomeUiState(hasPermission=" + this.hasPermission + ", loaded=" + this.loaded + ", tiles=" + this.tiles + ", mostPlayed=" + this.mostPlayed + ")";
    }

    public HomeUiState(boolean hasPermission, boolean loaded, List<HomeTile> tiles, List<HomeTrack> mostPlayed) {
        Intrinsics.checkNotNullParameter(tiles, "tiles");
        Intrinsics.checkNotNullParameter(mostPlayed, "mostPlayed");
        this.hasPermission = hasPermission;
        this.loaded = loaded;
        this.tiles = tiles;
        this.mostPlayed = mostPlayed;
    }

    public /* synthetic */ HomeUiState(boolean z, boolean z2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final boolean getHasPermission() {
        return this.hasPermission;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    public final List<HomeTile> getTiles() {
        return this.tiles;
    }

    public final List<HomeTrack> getMostPlayed() {
        return this.mostPlayed;
    }
}
