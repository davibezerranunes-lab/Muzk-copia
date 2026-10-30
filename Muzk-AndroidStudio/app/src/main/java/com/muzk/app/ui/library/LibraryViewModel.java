package com.muzk.app.ui.library;

import android.app.Application;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.muzk.app.data.LocalMusicRepository;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.Playlist;
import com.muzk.app.data.PlaylistStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020!J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0010J\u0006\u0010&\u001a\u00020\u0017J\u0006\u0010'\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0019J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020!J\u0016\u00100\u001a\u00020\u00172\u0006\u0010#\u001a\u00020!2\u0006\u0010/\u001a\u00020!J\u000e\u00101\u001a\u00020\u00172\u0006\u0010#\u001a\u00020!J\u0016\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0010J\u0016\u00104\u001a\u00020\u00172\u0006\u00103\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0010J\u001c\u00105\u001a\u00020\u00172\u0006\u00103\u001a\u00020!2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\nJ\u001c\u00107\u001a\u00020\u00172\u0006\u00103\u001a\u00020!2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\nJ:\u00108\u001a\u00020\u00132\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\n2\u0006\u0010<\u001a\u00020\r2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010)\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006>"}, d2 = {"Lcom/muzk/app/ui/library/LibraryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "store", "Lcom/muzk/app/data/PlaylistStore;", "tracks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/muzk/app/data/LocalTrack;", "nav", "Lcom/muzk/app/ui/library/Nav;", "selection", "", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/muzk/app/ui/library/LibraryUiState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setPermission", "", "granted", "", "reload", "Lkotlinx/coroutines/Job;", "selectTab", "tab", "Lcom/muzk/app/ui/library/LibraryTab;", "openFolder", "path", "", "openPlaylist", TtmlNode.ATTR_ID, "toggleSelection", "trackId", "clearSelection", "selectAll", "back", "askedPermission", "getAskedPermission", "()Z", "setAskedPermission", "(Z)V", "createPlaylist", "name", "renamePlaylist", "deletePlaylist", "addToPlaylist", "playlistId", "removeFromPlaylist", "addAllToPlaylist", "trackIds", "removeAllFromPlaylist", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, TtmlNode.COMBINE_ALL, "playlists", "Lcom/muzk/app/data/Playlist;", "n", "sel", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LibraryViewModel extends AndroidViewModel {
    private boolean askedPermission;
    private final MutableStateFlow<Nav> nav;
    private final MutableStateFlow<Set<Long>> selection;
    private final StateFlow<LibraryUiState> state;
    private final PlaylistStore store;
    private final MutableStateFlow<List<LocalTrack>> tracks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.store = PlaylistStore.INSTANCE.get(app);
        this.tracks = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.nav = StateFlowKt.MutableStateFlow(new Nav(false, false, null, null, null, 31, null));
        this.selection = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.state = FlowKt.stateIn(FlowKt.combine(this.tracks, this.store.getPlaylists(), this.nav, this.selection, new LibraryViewModel$state$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), new LibraryUiState(false, false, null, null, null, null, null, null, null, 511, null));
    }

    public final StateFlow<LibraryUiState> getState() {
        return this.state;
    }

    public final void setPermission(boolean granted) {
        Nav value;
        Nav it;
        MutableStateFlow<Nav> mutableStateFlow = this.nav;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, Nav.copy$default(it, granted, false, null, null, null, 30, null)));
        if (granted) {
            reload();
        }
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.library.LibraryViewModel$reload$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.library.LibraryViewModel$reload$1", f = "LibraryViewModel.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = LibraryViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object prevValue$iv;
            Nav it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LibraryViewModel libraryViewModel = LibraryViewModel.this;
                        Result.Companion companion = Result.INSTANCE;
                        LocalMusicRepository localMusicRepository = LocalMusicRepository.INSTANCE;
                        Application application = libraryViewModel.getApplication();
                        this.label = 1;
                        Object objLoadTracks = localMusicRepository.loadTracks(application, this);
                        if (objLoadTracks == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objLoadTracks;
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    $result = Result.m663constructorimpl((List) $result);
                } catch (Throwable th) {
                    th = th;
                    $result = $result;
                    Result.Companion companion2 = Result.INSTANCE;
                    $result = Result.m663constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                th = th2;
            }
            LibraryViewModel libraryViewModel2 = LibraryViewModel.this;
            if (Result.m670isSuccessimpl($result)) {
                List it2 = (List) $result;
                libraryViewModel2.tracks.setValue(it2);
            }
            MutableStateFlow $this$update$iv = LibraryViewModel.this.nav;
            do {
                prevValue$iv = $this$update$iv.getValue();
                it = (Nav) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, Nav.copy$default(it, false, true, null, null, null, 29, null)));
            return Unit.INSTANCE;
        }
    }

    public final Job reload() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void selectTab(LibraryTab tab) {
        Nav value;
        Nav it;
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (this.nav.getValue().getTab() == tab) {
            return;
        }
        clearSelection();
        MutableStateFlow<Nav> mutableStateFlow = this.nav;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, Nav.copy$default(it, false, false, tab, null, null, 3, null)));
    }

    public final void openFolder(String path) {
        Nav value;
        Nav it;
        Intrinsics.checkNotNullParameter(path, "path");
        clearSelection();
        MutableStateFlow<Nav> mutableStateFlow = this.nav;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, Nav.copy$default(it, false, false, null, path, null, 23, null)));
    }

    public final void openPlaylist(String id) {
        Nav value;
        Nav it;
        Intrinsics.checkNotNullParameter(id, "id");
        clearSelection();
        MutableStateFlow<Nav> mutableStateFlow = this.nav;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, Nav.copy$default(it, false, false, null, null, id, 15, null)));
    }

    public final void toggleSelection(long trackId) {
        Set<Long> value;
        Set<Long> set;
        MutableStateFlow<Set<Long>> mutableStateFlow = this.selection;
        do {
            value = mutableStateFlow.getValue();
            set = value;
        } while (!mutableStateFlow.compareAndSet(value, set.contains(Long.valueOf(trackId)) ? SetsKt.minus(set, Long.valueOf(trackId)) : SetsKt.plus(set, Long.valueOf(trackId))));
    }

    public final void clearSelection() {
        this.selection.setValue(SetsKt.emptySet());
    }

    public final void selectAll() {
        Set<Long> value;
        Iterable $this$map$iv = this.state.getValue().getQueue();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LocalTrack it = (LocalTrack) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(it.getId()));
        }
        Set<Long> set = CollectionsKt.toSet((List) destination$iv$iv);
        MutableStateFlow<Set<Long>> mutableStateFlow = this.selection;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.containsAll(set) ? SetsKt.emptySet() : set));
    }

    public final boolean back() {
        Nav value;
        Nav it;
        if (!this.selection.getValue().isEmpty()) {
            clearSelection();
            return true;
        }
        Nav n = this.nav.getValue();
        if (n.getFolder() == null && n.getPlaylistId() == null) {
            return false;
        }
        clearSelection();
        MutableStateFlow<Nav> mutableStateFlow = this.nav;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, Nav.copy$default(it, false, false, null, null, null, 7, null)));
        return true;
    }

    public final boolean getAskedPermission() {
        return this.askedPermission;
    }

    public final void setAskedPermission(boolean z) {
        this.askedPermission = z;
    }

    public final String createPlaylist(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.store.create(name);
    }

    public final void renamePlaylist(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.store.rename(id, name);
    }

    public final void deletePlaylist(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.store.delete(id);
    }

    public final void addToPlaylist(String playlistId, long trackId) {
        Intrinsics.checkNotNullParameter(playlistId, "playlistId");
        this.store.addTrack(playlistId, trackId);
    }

    public final void removeFromPlaylist(String playlistId, long trackId) {
        Intrinsics.checkNotNullParameter(playlistId, "playlistId");
        this.store.removeTrack(playlistId, trackId);
    }

    public final void addAllToPlaylist(String playlistId, List<Long> trackIds) {
        Intrinsics.checkNotNullParameter(playlistId, "playlistId");
        Intrinsics.checkNotNullParameter(trackIds, "trackIds");
        List<Long> $this$forEach$iv = trackIds;
        for (Object element$iv : $this$forEach$iv) {
            long it = ((Number) element$iv).longValue();
            this.store.addTrack(playlistId, it);
        }
    }

    public final void removeAllFromPlaylist(String playlistId, List<Long> trackIds) {
        Intrinsics.checkNotNullParameter(playlistId, "playlistId");
        Intrinsics.checkNotNullParameter(trackIds, "trackIds");
        List<Long> $this$forEach$iv = trackIds;
        for (Object element$iv : $this$forEach$iv) {
            long it = ((Number) element$iv).longValue();
            this.store.removeTrack(playlistId, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryUiState build(List<LocalTrack> all, List<Playlist> playlists, Nav n, Set<Long> sel) {
        List<LocalTrack> list;
        int count$iv;
        List<LocalTrack> list2;
        Object answer$iv$iv$iv;
        List<LocalTrack> $this$associateBy$iv = all;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            LocalTrack it = (LocalTrack) element$iv$iv;
            destination$iv$iv.put(Long.valueOf(it.getId()), element$iv$iv);
        }
        List rows = new ArrayList();
        List<LocalTrack> listEmptyList = CollectionsKt.emptyList();
        if (n.getTab() == LibraryTab.TRACKS) {
            for (Object item$iv : all) {
                LocalTrack it2 = (LocalTrack) item$iv;
                rows.add(new LibraryRow.Track(it2, null, false, false, 12, null));
            }
            list = all;
        } else {
            Object obj = null;
            if (n.getTab() == LibraryTab.FOLDERS && n.getFolder() != null) {
                List<LocalTrack> $this$filter$iv = all;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv) {
                    LocalTrack it3 = (LocalTrack) element$iv$iv2;
                    if (Intrinsics.areEqual(it3.getFolderPath(), n.getFolder())) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                }
                ArrayList $this$mapTo$iv = (List) destination$iv$iv2;
                List list3 = rows;
                String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(n.getFolder(), '/', (String) null, 2, (Object) null);
                if (StringsKt.isBlank(strSubstringAfterLast$default)) {
                    strSubstringAfterLast$default = n.getFolder();
                }
                list3.add(new LibraryRow.Header(strSubstringAfterLast$default));
                for (Object item$iv2 : $this$mapTo$iv) {
                    LocalTrack it4 = (LocalTrack) item$iv2;
                    rows.add(new LibraryRow.Track(it4, null, false, false, 12, null));
                }
                list = $this$mapTo$iv;
            } else if (n.getTab() == LibraryTab.FOLDERS) {
                List<LocalTrack> $this$groupBy$iv = all;
                Map destination$iv$iv3 = new LinkedHashMap();
                for (Object element$iv$iv3 : $this$groupBy$iv) {
                    LocalTrack it5 = (LocalTrack) element$iv$iv3;
                    String folderPath = it5.getFolderPath();
                    Object value$iv$iv$iv = destination$iv$iv3.get(folderPath);
                    if (value$iv$iv$iv == null) {
                        answer$iv$iv$iv = new ArrayList();
                        destination$iv$iv3.put(folderPath, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv = (List) answer$iv$iv$iv;
                    list$iv$iv.add(element$iv$iv3);
                }
                Collection destination$iv$iv4 = new ArrayList(destination$iv$iv3.size());
                for (Map.Entry item$iv$iv : destination$iv$iv3.entrySet()) {
                    String path = (String) item$iv$iv.getKey();
                    List list4 = (List) item$iv$iv.getValue();
                    destination$iv$iv4.add(new LibraryRow.Folder(path, ((LocalTrack) CollectionsKt.first(list4)).getFolderName(), list4.size()));
                    listEmptyList = listEmptyList;
                }
                list = listEmptyList;
                Iterable $this$sortedBy$iv = (List) destination$iv$iv4;
                Boolean.valueOf(rows.addAll(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.muzk.app.ui.library.LibraryViewModel$build$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        LibraryRow.Folder it6 = (LibraryRow.Folder) t;
                        String lowerCase = it6.getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        LibraryRow.Folder it7 = (LibraryRow.Folder) t2;
                        String lowerCase2 = it7.getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                })));
            } else {
                list = listEmptyList;
                if (n.getPlaylistId() != null) {
                    List<Playlist> $this$firstOrNull$iv = playlists;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        Playlist it6 = (Playlist) element$iv;
                        if (Intrinsics.areEqual(it6.getId(), n.getPlaylistId())) {
                            obj = element$iv;
                            break;
                        }
                    }
                    Playlist p = (Playlist) obj;
                    if (p != null) {
                        Iterable $this$mapNotNull$iv = p.getTrackIds();
                        Collection destination$iv$iv5 = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            long p0 = ((Number) element$iv$iv$iv).longValue();
                            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            LocalTrack localTrack = (LocalTrack) destination$iv$iv.get(Long.valueOf(p0));
                            if (localTrack != null) {
                                destination$iv$iv5.add(localTrack);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        }
                        ArrayList $this$mapTo$iv2 = (List) destination$iv$iv5;
                        rows.add(new LibraryRow.Header(p.getName()));
                        for (Object item$iv3 : $this$mapTo$iv2) {
                            LocalTrack it7 = (LocalTrack) item$iv3;
                            rows.add(new LibraryRow.Track(it7, p.getId(), false, false, 12, null));
                        }
                        list2 = $this$mapTo$iv2;
                    } else {
                        list2 = list;
                    }
                    Unit unit = Unit.INSTANCE;
                    list = list2;
                } else {
                    List<Playlist> $this$mapTo$iv3 = playlists;
                    for (Object item$iv4 : $this$mapTo$iv3) {
                        List list5 = rows;
                        Playlist p2 = (Playlist) item$iv4;
                        Iterable $this$count$iv = p2.getTrackIds();
                        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                            count$iv = 0;
                        } else {
                            count$iv = 0;
                            Iterator it8 = $this$count$iv.iterator();
                            while (it8.hasNext()) {
                                long it9 = ((Number) it8.next()).longValue();
                                $this$mapTo$iv3 = $this$mapTo$iv3;
                                if (destination$iv$iv.containsKey(Long.valueOf(it9))) {
                                    count$iv++;
                                    if (count$iv < 0) {
                                        CollectionsKt.throwCountOverflow();
                                    }
                                }
                            }
                        }
                        list5.add(new LibraryRow.PlaylistItem(p2, count$iv));
                        $this$mapTo$iv3 = $this$mapTo$iv3;
                    }
                }
            }
        }
        Iterable $this$filter$iv2 = list;
        Collection destination$iv$iv6 = new ArrayList();
        for (Object element$iv$iv4 : $this$filter$iv2) {
            LocalTrack it10 = (LocalTrack) element$iv$iv4;
            if (sel.contains(Long.valueOf(it10.getId()))) {
                destination$iv$iv6.add(element$iv$iv4);
            }
        }
        List selected = (List) destination$iv$iv6;
        if (!selected.isEmpty()) {
            int size = rows.size();
            for (int i = 0; i < size; i++) {
                LibraryRow r = (LibraryRow) rows.get(i);
                if (r instanceof LibraryRow.Track) {
                    rows.set(i, LibraryRow.Track.copy$default((LibraryRow.Track) r, null, null, true, sel.contains(Long.valueOf(((LibraryRow.Track) r).getTrack().getId())), 3, null));
                }
            }
        }
        return new LibraryUiState(n.getHasPermission(), n.getLoaded(), n.getTab(), n.getFolder(), n.getPlaylistId(), rows, list, playlists, selected);
    }
}
