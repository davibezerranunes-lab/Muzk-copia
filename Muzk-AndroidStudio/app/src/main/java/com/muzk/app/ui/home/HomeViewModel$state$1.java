package com.muzk.app.ui.home;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.Playlist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\n"}, d2 = {"<anonymous>", "Lcom/muzk/app/ui/home/HomeUiState;", TtmlNode.COMBINE_ALL, "", "Lcom/muzk/app/data/LocalTrack;", "playlists", "Lcom/muzk/app/data/Playlist;", "counts", "", "", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.muzk.app.ui.home.HomeViewModel$state$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HomeViewModel$state$1 extends SuspendLambda implements Function5<List<? extends LocalTrack>, List<? extends Playlist>, Map<Long, ? extends Integer>, Pair<? extends Boolean, ? extends Boolean>, Continuation<? super HomeUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;

    HomeViewModel$state$1(Continuation<? super HomeViewModel$state$1> continuation) {
        super(5, continuation);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(List<? extends LocalTrack> list, List<? extends Playlist> list2, Map<Long, ? extends Integer> map, Pair<? extends Boolean, ? extends Boolean> pair, Continuation<? super HomeUiState> continuation) {
        return invoke2((List<LocalTrack>) list, (List<Playlist>) list2, (Map<Long, Integer>) map, (Pair<Boolean, Boolean>) pair, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<LocalTrack> list, List<Playlist> list2, Map<Long, Integer> map, Pair<Boolean, Boolean> pair, Continuation<? super HomeUiState> continuation) {
        HomeViewModel$state$1 homeViewModel$state$1 = new HomeViewModel$state$1(continuation);
        homeViewModel$state$1.L$0 = list;
        homeViewModel$state$1.L$1 = list2;
        homeViewModel$state$1.L$2 = map;
        homeViewModel$state$1.L$3 = pair;
        return homeViewModel$state$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                List all = (List) this.L$0;
                List playlists = (List) this.L$1;
                final Map counts = (Map) this.L$2;
                Pair pair = (Pair) this.L$3;
                boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                boolean zBooleanValue2 = ((Boolean) pair.component2()).booleanValue();
                List $this$associateBy$iv = all;
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                for (Object element$iv$iv : $this$associateBy$iv) {
                    destination$iv$iv.put(Boxing.boxLong(((LocalTrack) element$iv$iv).getId()), element$iv$iv);
                }
                List tiles = new ArrayList();
                Iterable $this$forEach$iv = CollectionsKt.take(playlists, 4);
                for (Object element$iv : $this$forEach$iv) {
                    Playlist p = (Playlist) element$iv;
                    Iterable $this$forEach$iv$iv$iv = p.getTrackIds();
                    Collection destination$iv$iv2 = new ArrayList();
                    Iterator it = $this$forEach$iv$iv$iv.iterator();
                    while (it.hasNext()) {
                        long p0 = ((Number) it.next()).longValue();
                        LocalTrack localTrack = (LocalTrack) destination$iv$iv.get(Boxing.boxLong(p0));
                        if (localTrack != null) {
                            destination$iv$iv2.add(localTrack);
                        }
                    }
                    List list = (List) destination$iv$iv2;
                    List list2 = tiles;
                    HomeTile.Kind kind = HomeTile.Kind.PLAYLIST;
                    String id = p.getId();
                    String name = p.getName();
                    LocalTrack localTrack2 = (LocalTrack) CollectionsKt.firstOrNull(list);
                    list2.add(new HomeTile(kind, id, name, localTrack2 != null ? localTrack2.getUri() : null, list));
                }
                if (tiles.size() < 4 && !all.isEmpty()) {
                    tiles.add(new HomeTile(HomeTile.Kind.RECENT, "recent", "Todas as músicas", null, all));
                }
                if (tiles.size() < 4) {
                    List $this$groupByTo$iv$iv = all;
                    Map destination$iv$iv3 = new LinkedHashMap();
                    for (Object element$iv$iv2 : $this$groupByTo$iv$iv) {
                        String folderPath = ((LocalTrack) element$iv$iv2).getFolderPath();
                        Object answer$iv$iv$iv = destination$iv$iv3.get(folderPath);
                        if (answer$iv$iv$iv == null) {
                            answer$iv$iv$iv = new ArrayList();
                            destination$iv$iv3.put(folderPath, answer$iv$iv$iv);
                        }
                        List list$iv$iv = (List) answer$iv$iv$iv;
                        list$iv$iv.add(element$iv$iv2);
                    }
                    Iterable $this$sortedByDescending$iv = destination$iv$iv3.entrySet();
                    Iterable $this$forEach$iv2 = CollectionsKt.take(CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.muzk.app.ui.home.HomeViewModel$state$1$invokeSuspend$$inlined$sortedByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Map.Entry it2 = (Map.Entry) t2;
                            Map.Entry it3 = (Map.Entry) t;
                            return ComparisonsKt.compareValues(Integer.valueOf(((List) it2.getValue()).size()), Integer.valueOf(((List) it3.getValue()).size()));
                        }
                    }), 4 - tiles.size());
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Map.Entry entry = (Map.Entry) element$iv2;
                        String path = (String) entry.getKey();
                        List list3 = (List) entry.getValue();
                        tiles.add(new HomeTile(HomeTile.Kind.FOLDER, path, ((LocalTrack) CollectionsKt.first(list3)).getFolderName(), ((LocalTrack) CollectionsKt.first(list3)).getUri(), list3));
                    }
                }
                List $this$filterTo$iv$iv = all;
                Collection destination$iv$iv4 = new ArrayList();
                Iterator it2 = $this$filterTo$iv$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        Iterable $this$sortedByDescending$iv2 = (List) destination$iv$iv4;
                        Iterable played = CollectionsKt.take(CollectionsKt.sortedWith($this$sortedByDescending$iv2, new Comparator() { // from class: com.muzk.app.ui.home.HomeViewModel$state$1$invokeSuspend$$inlined$sortedByDescending$2
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                LocalTrack it3 = (LocalTrack) t2;
                                Integer num = (Integer) counts.get(Long.valueOf(it3.getId()));
                                LocalTrack it4 = (LocalTrack) t;
                                return ComparisonsKt.compareValues(num, (Integer) counts.get(Long.valueOf(it4.getId())));
                            }
                        }), 5);
                        Iterable $this$map$iv = played;
                        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            LocalTrack it3 = (LocalTrack) item$iv$iv;
                            Integer num = (Integer) counts.get(Boxing.boxLong(it3.getId()));
                            destination$iv$iv5.add(new HomeTrack(it3, num != null ? num.intValue() : 0));
                        }
                        return new HomeUiState(zBooleanValue, zBooleanValue2, tiles, (List) destination$iv$iv5);
                    }
                    Object element$iv$iv3 = it2.next();
                    Integer num2 = (Integer) counts.get(Boxing.boxLong(((LocalTrack) element$iv$iv3).getId()));
                    if ((num2 != null ? num2.intValue() : 0) > 0) {
                        destination$iv$iv4.add(element$iv$iv3);
                    }
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
