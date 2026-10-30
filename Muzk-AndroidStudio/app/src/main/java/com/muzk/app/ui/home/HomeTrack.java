package com.muzk.app.ui.home;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.data.LocalTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/muzk/app/ui/home/HomeTrack;", "", "track", "Lcom/muzk/app/data/LocalTrack;", "plays", "", "<init>", "(Lcom/muzk/app/data/LocalTrack;I)V", "getTrack", "()Lcom/muzk/app/data/LocalTrack;", "getPlays", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class HomeTrack {
    private final int plays;
    private final LocalTrack track;

    public static /* synthetic */ HomeTrack copy$default(HomeTrack homeTrack, LocalTrack localTrack, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            localTrack = homeTrack.track;
        }
        if ((i2 & 2) != 0) {
            i = homeTrack.plays;
        }
        return homeTrack.copy(localTrack, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LocalTrack getTrack() {
        return this.track;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPlays() {
        return this.plays;
    }

    public final HomeTrack copy(LocalTrack track, int plays) {
        Intrinsics.checkNotNullParameter(track, "track");
        return new HomeTrack(track, plays);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeTrack)) {
            return false;
        }
        HomeTrack homeTrack = (HomeTrack) other;
        return Intrinsics.areEqual(this.track, homeTrack.track) && this.plays == homeTrack.plays;
    }

    public int hashCode() {
        return (this.track.hashCode() * 31) + Integer.hashCode(this.plays);
    }

    public String toString() {
        return "HomeTrack(track=" + this.track + ", plays=" + this.plays + ")";
    }

    public HomeTrack(LocalTrack track, int plays) {
        Intrinsics.checkNotNullParameter(track, "track");
        this.track = track;
        this.plays = plays;
    }

    public final int getPlays() {
        return this.plays;
    }

    public final LocalTrack getTrack() {
        return this.track;
    }
}
