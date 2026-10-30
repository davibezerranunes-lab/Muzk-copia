package com.muzk.app.data;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlaylistStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011J\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u001e\u001a\u00020\u00192\u001e\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0 H\u0002J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010$\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/muzk/app/data/PlaylistStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "file", "Ljava/io/File;", "_playlists", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/muzk/app/data/Playlist;", "playlists", "Lkotlinx/coroutines/flow/StateFlow;", "getPlaylists", "()Lkotlinx/coroutines/flow/StateFlow;", "create", "", "name", "isLiked", "", "trackId", "", "toggleLike", "rename", "", TtmlNode.ATTR_ID, "delete", "addTrack", "removeTrack", "mutate", "block", "Lkotlin/Function1;", "withLiked", "list", "read", "write", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlaylistStore {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String LIKED_ID = "liked";
    public static final String LIKED_NAME = "Músicas curtidas";
    private static volatile PlaylistStore instance;
    private final MutableStateFlow<List<Playlist>> _playlists;
    private final File file;
    private final StateFlow<List<Playlist>> playlists;

    public /* synthetic */ PlaylistStore(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private PlaylistStore(Context context) {
        this.file = new File(context.getFilesDir(), "playlists.json");
        this._playlists = StateFlowKt.MutableStateFlow(withLiked(read()));
        this.playlists = FlowKt.asStateFlow(this._playlists);
    }

    public final StateFlow<List<Playlist>> getPlaylists() {
        return this.playlists;
    }

    public final String create(final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        final String id = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(id, "toString(...)");
        mutate(new Function1() { // from class: com.muzk.app.data.PlaylistStore$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaylistStore.create$lambda$0(id, name, (List) obj);
            }
        });
        return id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List create$lambda$0(String $id, String $name, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.plus((Collection<? extends Playlist>) it, new Playlist($id, StringsKt.trim((CharSequence) $name).toString(), CollectionsKt.emptyList()));
    }

    public final boolean isLiked(long trackId) {
        Object element$iv;
        List<Long> trackIds;
        Playlist it;
        Iterable $this$firstOrNull$iv = this._playlists.getValue();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (Playlist) element$iv;
        } while (!Intrinsics.areEqual(it.getId(), LIKED_ID));
        Playlist playlist = (Playlist) element$iv;
        return (playlist == null || (trackIds = playlist.getTrackIds()) == null || !trackIds.contains(Long.valueOf(trackId))) ? false : true;
    }

    public final boolean toggleLike(final long trackId) {
        final boolean liked = !isLiked(trackId);
        mutate(new Function1() { // from class: com.muzk.app.data.PlaylistStore$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaylistStore.toggleLike$lambda$3(liked, trackId, (List) obj);
            }
        });
        return liked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List toggleLike$lambda$3(boolean $liked, long $trackId, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Playlist it = (Playlist) item$iv$iv;
            if (Intrinsics.areEqual(it.getId(), LIKED_ID)) {
                it = Playlist.copy$default(it, null, null, $liked ? CollectionsKt.plus((Collection) CollectionsKt.listOf(Long.valueOf($trackId)), (Iterable) it.getTrackIds()) : CollectionsKt.minus(it.getTrackIds(), Long.valueOf($trackId)), 3, null);
            }
            destination$iv$iv.add(it);
        }
        return (List) destination$iv$iv;
    }

    public final void rename(final String id, final String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        mutate(new Function1() { // from class: com.muzk.app.data.PlaylistStore$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaylistStore.rename$lambda$5(id, name, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List rename$lambda$5(String $id, String $name, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Playlist it = (Playlist) item$iv$iv;
            if (Intrinsics.areEqual(it.getId(), $id)) {
                it = Playlist.copy$default(it, null, StringsKt.trim((CharSequence) $name).toString(), null, 5, null);
            }
            destination$iv$iv.add(it);
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List delete$lambda$7(String $id, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List $this$filterNot$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            Playlist it = (Playlist) element$iv$iv;
            if (!(Intrinsics.areEqual(it.getId(), $id) && !Intrinsics.areEqual($id, LIKED_ID))) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final void delete(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        mutate(new Function1() { // from class: com.muzk.app.data.PlaylistStore$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaylistStore.delete$lambda$7(id, (List) obj);
            }
        });
    }

    public final void addTrack(final String id, final long trackId) {
        Intrinsics.checkNotNullParameter(id, "id");
        mutate(new Function1() { // from class: com.muzk.app.data.PlaylistStore$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaylistStore.addTrack$lambda$9(id, trackId, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List addTrack$lambda$9(String $id, long $trackId, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Playlist it = (Playlist) item$iv$iv;
            if (Intrinsics.areEqual(it.getId(), $id) && !it.getTrackIds().contains(Long.valueOf($trackId))) {
                it = Playlist.copy$default(it, null, null, CollectionsKt.plus((Collection<? extends Long>) it.getTrackIds(), Long.valueOf($trackId)), 3, null);
            }
            destination$iv$iv.add(it);
        }
        return (List) destination$iv$iv;
    }

    public final void removeTrack(final String id, final long trackId) {
        Intrinsics.checkNotNullParameter(id, "id");
        mutate(new Function1() { // from class: com.muzk.app.data.PlaylistStore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaylistStore.removeTrack$lambda$11(id, trackId, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List removeTrack$lambda$11(String $id, long $trackId, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Playlist it = (Playlist) item$iv$iv;
            if (Intrinsics.areEqual(it.getId(), $id)) {
                it = Playlist.copy$default(it, null, null, CollectionsKt.minus(it.getTrackIds(), Long.valueOf($trackId)), 3, null);
            }
            destination$iv$iv.add(it);
        }
        return (List) destination$iv$iv;
    }

    private final synchronized void mutate(Function1<? super List<Playlist>, ? extends List<Playlist>> block) {
        List<Playlist> listInvoke = block.invoke(this._playlists.getValue());
        this._playlists.setValue(listInvoke);
        write(listInvoke);
    }

    private final List<Playlist> withLiked(List<Playlist> list) {
        Object element$iv;
        Playlist it;
        List<Playlist> $this$firstOrNull$iv = list;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (Playlist) element$iv;
        } while (!Intrinsics.areEqual(it.getId(), LIKED_ID));
        Playlist playlist = (Playlist) element$iv;
        if (playlist == null) {
            playlist = new Playlist(LIKED_ID, LIKED_NAME, CollectionsKt.emptyList());
        }
        Playlist liked = playlist;
        List listListOf = CollectionsKt.listOf(liked);
        List<Playlist> $this$filterNot$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            Playlist it3 = (Playlist) element$iv$iv;
            if (!Intrinsics.areEqual(it3.getId(), LIKED_ID)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return CollectionsKt.plus((Collection) listListOf, destination$iv$iv);
    }

    private final List<Playlist> read() {
        Object objM663constructorimpl;
        String str = "getString(...)";
        try {
            Result.Companion companion = Result.INSTANCE;
            PlaylistStore $this$read_u24lambda_u2416 = this;
            int i = 0;
            if (!$this$read_u24lambda_u2416.file.exists()) {
                return CollectionsKt.emptyList();
            }
            JSONArray arr = new JSONArray(FilesKt.readText$default($this$read_u24lambda_u2416.file, null, 1, null));
            Iterable $this$map$iv = RangesKt.until(0, arr.length());
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterator<Integer> it = $this$map$iv.iterator();
            while (it.hasNext()) {
                int item$iv$iv = ((IntIterator) it).nextInt();
                JSONObject o = arr.getJSONObject(item$iv$iv);
                JSONArray ids = o.getJSONArray("tracks");
                String string = o.getString(TtmlNode.ATTR_ID);
                Intrinsics.checkNotNullExpressionValue(string, str);
                PlaylistStore $this$read_u24lambda_u2417 = $this$read_u24lambda_u2416;
                String string2 = o.getString("name");
                Intrinsics.checkNotNullExpressionValue(string2, str);
                String str2 = str;
                int i2 = i;
                Iterable $this$map$iv2 = RangesKt.until(0, ids.length());
                JSONArray arr2 = arr;
                Iterable $this$map$iv3 = $this$map$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                Iterator<Integer> it2 = $this$map$iv2.iterator();
                while (it2.hasNext()) {
                    int item$iv$iv2 = ((IntIterator) it2).nextInt();
                    destination$iv$iv2.add(Long.valueOf(ids.getLong(item$iv$iv2)));
                }
                destination$iv$iv.add(new Playlist(string, string2, (List) destination$iv$iv2));
                $this$map$iv = $this$map$iv3;
                $this$read_u24lambda_u2416 = $this$read_u24lambda_u2417;
                str = str2;
                i = i2;
                arr = arr2;
            }
            objM663constructorimpl = Result.m663constructorimpl((List) destination$iv$iv);
            List listEmptyList = CollectionsKt.emptyList();
            if (Result.m669isFailureimpl(objM663constructorimpl)) {
                objM663constructorimpl = listEmptyList;
            }
            return (List) objM663constructorimpl;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void write(List<Playlist> list) {
        JSONArray arr = new JSONArray();
        List<Playlist> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            Playlist p = (Playlist) element$iv;
            arr.put(new JSONObject().put(TtmlNode.ATTR_ID, p.getId()).put("name", p.getName()).put("tracks", new JSONArray((Collection) p.getTrackIds())));
        }
        File file = this.file;
        String string = arr.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        FilesKt.writeText$default(file, string, null, 2, null);
    }

    /* JADX INFO: compiled from: PlaylistStore.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/muzk/app/data/PlaylistStore$Companion;", "", "<init>", "()V", "LIKED_ID", "", "LIKED_NAME", "instance", "Lcom/muzk/app/data/PlaylistStore;", "get", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlaylistStore get(Context context) {
            PlaylistStore it;
            Intrinsics.checkNotNullParameter(context, "context");
            PlaylistStore playlistStore = PlaylistStore.instance;
            if (playlistStore == null) {
                synchronized (this) {
                    it = PlaylistStore.instance;
                    if (it == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        it = new PlaylistStore(applicationContext, null);
                        Companion companion = PlaylistStore.INSTANCE;
                        PlaylistStore.instance = it;
                    }
                }
                return it;
            }
            return playlistStore;
        }
    }
}
