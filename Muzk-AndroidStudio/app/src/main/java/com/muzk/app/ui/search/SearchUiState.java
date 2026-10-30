package com.muzk.app.ui.search;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.data.RemoteTrack;
import com.muzk.app.download.DownloadWorker;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003JU\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/muzk/app/ui/search/SearchUiState;", "", "query", "", "loading", "", "results", "", "Lcom/muzk/app/data/RemoteTrack;", DownloadWorker.KEY_ERROR, "resolvingId", "downloadedIds", "", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getQuery", "()Ljava/lang/String;", "getLoading", "()Z", "getResults", "()Ljava/util/List;", "getError", "getResolvingId", "getDownloadedIds", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SearchUiState {
    private final Set<String> downloadedIds;
    private final String error;
    private final boolean loading;
    private final String query;
    private final String resolvingId;
    private final List<RemoteTrack> results;

    public SearchUiState() {
        this(null, false, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchUiState copy$default(SearchUiState searchUiState, String str, boolean z, List list, String str2, String str3, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchUiState.query;
        }
        if ((i & 2) != 0) {
            z = searchUiState.loading;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            list = searchUiState.results;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            str2 = searchUiState.error;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = searchUiState.resolvingId;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            set = searchUiState.downloadedIds;
        }
        return searchUiState.copy(str, z2, list2, str4, str5, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getLoading() {
        return this.loading;
    }

    public final List<RemoteTrack> component3() {
        return this.results;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getResolvingId() {
        return this.resolvingId;
    }

    public final Set<String> component6() {
        return this.downloadedIds;
    }

    public final SearchUiState copy(String query, boolean loading, List<RemoteTrack> results, String error, String resolvingId, Set<String> downloadedIds) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(results, "results");
        Intrinsics.checkNotNullParameter(downloadedIds, "downloadedIds");
        return new SearchUiState(query, loading, results, error, resolvingId, downloadedIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchUiState)) {
            return false;
        }
        SearchUiState searchUiState = (SearchUiState) other;
        return Intrinsics.areEqual(this.query, searchUiState.query) && this.loading == searchUiState.loading && Intrinsics.areEqual(this.results, searchUiState.results) && Intrinsics.areEqual(this.error, searchUiState.error) && Intrinsics.areEqual(this.resolvingId, searchUiState.resolvingId) && Intrinsics.areEqual(this.downloadedIds, searchUiState.downloadedIds);
    }

    public int hashCode() {
        return (((((((((this.query.hashCode() * 31) + Boolean.hashCode(this.loading)) * 31) + this.results.hashCode()) * 31) + (this.error == null ? 0 : this.error.hashCode())) * 31) + (this.resolvingId != null ? this.resolvingId.hashCode() : 0)) * 31) + this.downloadedIds.hashCode();
    }

    public String toString() {
        return "SearchUiState(query=" + this.query + ", loading=" + this.loading + ", results=" + this.results + ", error=" + this.error + ", resolvingId=" + this.resolvingId + ", downloadedIds=" + this.downloadedIds + ")";
    }

    public SearchUiState(String query, boolean loading, List<RemoteTrack> results, String error, String resolvingId, Set<String> downloadedIds) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(results, "results");
        Intrinsics.checkNotNullParameter(downloadedIds, "downloadedIds");
        this.query = query;
        this.loading = loading;
        this.results = results;
        this.error = error;
        this.resolvingId = resolvingId;
        this.downloadedIds = downloadedIds;
    }

    public /* synthetic */ SearchUiState(String str, boolean z, List list, String str2, String str3, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? SetsKt.emptySet() : set);
    }

    public final String getQuery() {
        return this.query;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final List<RemoteTrack> getResults() {
        return this.results;
    }

    public final String getError() {
        return this.error;
    }

    public final String getResolvingId() {
        return this.resolvingId;
    }

    public final Set<String> getDownloadedIds() {
        return this.downloadedIds;
    }
}
