package com.muzk.app.ui.search;

import android.app.Application;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.container.MdtaMetadataEntry;
import com.muzk.app.data.RemoteTrack;
import com.muzk.app.data.SearchHistory;
import com.muzk.app.data.YtDlpRepository;
import com.muzk.app.download.Downloads;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SearchViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\f\u0010&\u001a\u00020\u0018*\u00020'H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/muzk/app/ui/search/SearchViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/muzk/app/ui/search/SearchUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/muzk/app/ui/search/SearchEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "history", "Lcom/muzk/app/data/SearchHistory;", "recentSearches", "", "", "getRecentSearches", "searchJob", "Lkotlinx/coroutines/Job;", "resolveJob", "search", "", "query", "removeRecent", "clear", "listen", "track", "Lcom/muzk/app/data/RemoteTrack;", "download", "shortMessage", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchViewModel extends AndroidViewModel {
    private final MutableSharedFlow<SearchEvent> _events;
    private final MutableStateFlow<SearchUiState> _state;
    private final SharedFlow<SearchEvent> events;
    private final SearchHistory history;
    private final StateFlow<List<String>> recentSearches;
    private Job resolveJob;
    private Job searchJob;
    private final StateFlow<SearchUiState> state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this._state = StateFlowKt.MutableStateFlow(new SearchUiState(null, false, null, null, null, null, 63, null));
        this.state = FlowKt.asStateFlow(this._state);
        this._events = SharedFlowKt.MutableSharedFlow$default(0, 4, null, 5, null);
        this.events = FlowKt.asSharedFlow(this._events);
        this.history = SearchHistory.INSTANCE.get(app);
        this.recentSearches = this.history.getItems();
    }

    public final StateFlow<SearchUiState> getState() {
        return this.state;
    }

    public final SharedFlow<SearchEvent> getEvents() {
        return this.events;
    }

    public final StateFlow<List<String>> getRecentSearches() {
        return this.recentSearches;
    }

    public final void search(String query) {
        SearchUiState value;
        SearchUiState it;
        Intrinsics.checkNotNullParameter(query, "query");
        String q = StringsKt.trim((CharSequence) query).toString();
        if (q.length() == 0) {
            return;
        }
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.history.add(q);
        MutableStateFlow<SearchUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, SearchUiState.copy$default(it, q, true, null, null, null, null, 52, null)));
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01132(q, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchViewModel$search$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.search.SearchViewModel$search$2", f = "SearchViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class C01132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $q;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SearchViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01132(String str, SearchViewModel searchViewModel, Continuation<? super C01132> continuation) {
            super(2, continuation);
            this.$q = str;
            this.this$0 = searchViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01132 c01132 = new C01132(this.$q, this.this$0, continuation);
            c01132.L$0 = obj;
            return c01132;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01132) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0059  */
        /* JADX WARN: Code duplicated, block: B:28:0x008c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object $result;
            Object $result2;
            Throwable th;
            Object objM663constructorimpl;
            SearchViewModel searchViewModel;
            SearchViewModel searchViewModel2;
            Throwable e;
            MutableStateFlow $this$update$iv;
            Object prevValue$iv;
            SearchUiState it;
            List list;
            MutableStateFlow $this$update$iv2;
            Object prevValue$iv2;
            SearchUiState it2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    $result = obj;
                    String str = this.$q;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        YtDlpRepository ytDlpRepository = YtDlpRepository.INSTANCE;
                        this.label = 1;
                        $result2 = YtDlpRepository.search$default(ytDlpRepository, str, 0, this, 2, null);
                        if ($result2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objM663constructorimpl = Result.m663constructorimpl((List) $result2);
                        searchViewModel = this.this$0;
                        if (Result.m670isSuccessimpl(objM663constructorimpl)) {
                            list = (List) objM663constructorimpl;
                            $this$update$iv2 = searchViewModel._state;
                            do {
                                prevValue$iv2 = $this$update$iv2.getValue();
                                it2 = (SearchUiState) prevValue$iv2;
                            } while (!$this$update$iv2.compareAndSet(prevValue$iv2, SearchUiState.copy$default(it2, null, false, list, null, null, null, 57, null)));
                        }
                        searchViewModel2 = this.this$0;
                        e = Result.m666exceptionOrNullimpl(objM663constructorimpl);
                        if (e != null) {
                            $this$update$iv = searchViewModel2._state;
                            do {
                                prevValue$iv = $this$update$iv.getValue();
                                it = (SearchUiState) prevValue$iv;
                            } while (!$this$update$iv.compareAndSet(prevValue$iv, SearchUiState.copy$default(it, null, false, CollectionsKt.emptyList(), searchViewModel2.shortMessage(e), null, null, 49, null)));
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        $result2 = $result;
                        Result.Companion companion2 = Result.INSTANCE;
                        objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
                    }
                    break;
                case 1:
                    $result2 = obj;
                    try {
                        ResultKt.throwOnFailure($result2);
                        $result = $result2;
                        objM663constructorimpl = Result.m663constructorimpl((List) $result2);
                        break;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion3 = Result.INSTANCE;
                        objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
                    }
                    searchViewModel = this.this$0;
                    if (Result.m670isSuccessimpl(objM663constructorimpl)) {
                        list = (List) objM663constructorimpl;
                        $this$update$iv2 = searchViewModel._state;
                        do {
                            prevValue$iv2 = $this$update$iv2.getValue();
                            it2 = (SearchUiState) prevValue$iv2;
                        } while (!$this$update$iv2.compareAndSet(prevValue$iv2, SearchUiState.copy$default(it2, null, false, list, null, null, null, 57, null)));
                    }
                    searchViewModel2 = this.this$0;
                    e = Result.m666exceptionOrNullimpl(objM663constructorimpl);
                    if (e != null) {
                        $this$update$iv = searchViewModel2._state;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                            it = (SearchUiState) prevValue$iv;
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, SearchUiState.copy$default(it, null, false, CollectionsKt.emptyList(), searchViewModel2.shortMessage(e), null, null, 49, null)));
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void removeRecent(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.history.remove(query);
    }

    public final void clear() {
        SearchUiState value;
        SearchUiState it;
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        MutableStateFlow<SearchUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, SearchUiState.copy$default(it, "", false, CollectionsKt.emptyList(), null, null, null, 48, null)));
    }

    public final void listen(RemoteTrack track) {
        SearchUiState value;
        SearchUiState it;
        Intrinsics.checkNotNullParameter(track, "track");
        Job job = this.resolveJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        MutableStateFlow<SearchUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, SearchUiState.copy$default(it, null, false, null, null, track.getId(), null, 47, null)));
        this.resolveJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(track, null), 3, null);
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchViewModel$listen$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.search.SearchViewModel$listen$2", f = "SearchViewModel.kt", i = {}, l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, 79, 80}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RemoteTrack $track;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RemoteTrack remoteTrack, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$track = remoteTrack;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = SearchViewModel.this.new AnonymousClass2(this.$track, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0076  */
        /* JADX WARN: Code duplicated, block: B:26:0x008e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x008f  */
        /* JADX WARN: Code duplicated, block: B:31:0x0099  */
        /* JADX WARN: Code duplicated, block: B:33:0x00c5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00c6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object $result2;
            Object $result3;
            SearchViewModel searchViewModel;
            RemoteTrack remoteTrack;
            MutableSharedFlow mutableSharedFlow;
            SearchEvent.Play play;
            SearchViewModel searchViewModel2;
            Throwable it;
            MutableSharedFlow mutableSharedFlow2;
            SearchEvent.Message message;
            MutableStateFlow $this$update$iv;
            Object prevValue$iv;
            Object $result4;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        RemoteTrack remoteTrack2 = this.$track;
                        Result.Companion companion = Result.INSTANCE;
                        YtDlpRepository ytDlpRepository = YtDlpRepository.INSTANCE;
                        String pageUrl = remoteTrack2.getPageUrl();
                        this.label = 1;
                        Object objStreamUrl = ytDlpRepository.streamUrl(pageUrl, this);
                        if (objStreamUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result4 = $result;
                        $result5 = objStreamUrl;
                        try {
                            $result2 = (String) $result5;
                            $result3 = Result.m663constructorimpl($result2);
                        } catch (Throwable th) {
                            th = th;
                            $result2 = $result4;
                            Result.Companion companion2 = Result.INSTANCE;
                            $result3 = Result.m663constructorimpl(ResultKt.createFailure(th));
                        }
                        searchViewModel = SearchViewModel.this;
                        remoteTrack = this.$track;
                        if (Result.m670isSuccessimpl($result3)) {
                            mutableSharedFlow = searchViewModel._events;
                            play = new SearchEvent.Play(remoteTrack, (String) $result3);
                            this.L$0 = $result3;
                            this.label = 2;
                            if (mutableSharedFlow.emit(play, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        searchViewModel2 = SearchViewModel.this;
                        it = Result.m666exceptionOrNullimpl($result3);
                        if (it != null) {
                            mutableSharedFlow2 = searchViewModel2._events;
                            message = new SearchEvent.Message("Não consegui abrir o áudio: " + searchViewModel2.shortMessage(it));
                            this.L$0 = $result3;
                            this.label = 3;
                            if (mutableSharedFlow2.emit(message, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        $this$update$iv = SearchViewModel.this._state;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, SearchUiState.copy$default((SearchUiState) prevValue$iv, null, false, null, null, null, null, 47, null)));
                        return Unit.INSTANCE;
                    case 1:
                        $result5 = $result;
                        ResultKt.throwOnFailure($result5);
                        $result4 = $result5;
                        $result2 = (String) $result5;
                        $result3 = Result.m663constructorimpl($result2);
                        searchViewModel = SearchViewModel.this;
                        remoteTrack = this.$track;
                        if (Result.m670isSuccessimpl($result3)) {
                            mutableSharedFlow = searchViewModel._events;
                            play = new SearchEvent.Play(remoteTrack, (String) $result3);
                            this.L$0 = $result3;
                            this.label = 2;
                            if (mutableSharedFlow.emit(play, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        searchViewModel2 = SearchViewModel.this;
                        it = Result.m666exceptionOrNullimpl($result3);
                        if (it != null) {
                            mutableSharedFlow2 = searchViewModel2._events;
                            message = new SearchEvent.Message("Não consegui abrir o áudio: " + searchViewModel2.shortMessage(it));
                            this.L$0 = $result3;
                            this.label = 3;
                            if (mutableSharedFlow2.emit(message, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        $this$update$iv = SearchViewModel.this._state;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, SearchUiState.copy$default((SearchUiState) prevValue$iv, null, false, null, null, null, null, 47, null)));
                        return Unit.INSTANCE;
                    case 2:
                        $result3 = this.L$0;
                        ResultKt.throwOnFailure($result);
                        searchViewModel2 = SearchViewModel.this;
                        it = Result.m666exceptionOrNullimpl($result3);
                        if (it != null) {
                            mutableSharedFlow2 = searchViewModel2._events;
                            message = new SearchEvent.Message("Não consegui abrir o áudio: " + searchViewModel2.shortMessage(it));
                            this.L$0 = $result3;
                            this.label = 3;
                            if (mutableSharedFlow2.emit(message, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        $this$update$iv = SearchViewModel.this._state;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, SearchUiState.copy$default((SearchUiState) prevValue$iv, null, false, null, null, null, null, 47, null)));
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        $this$update$iv = SearchViewModel.this._state;
                        do {
                            prevValue$iv = $this$update$iv.getValue();
                        } while (!$this$update$iv.compareAndSet(prevValue$iv, SearchUiState.copy$default((SearchUiState) prevValue$iv, null, false, null, null, null, null, 47, null)));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void download(RemoteTrack track) {
        SearchUiState value;
        SearchUiState it;
        Intrinsics.checkNotNullParameter(track, "track");
        Downloads.Enqueued result = Downloads.INSTANCE.enqueue(getApplication(), track);
        MutableStateFlow<SearchUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, SearchUiState.copy$default(it, null, false, null, null, null, SetsKt.plus(it.getDownloadedIds(), track.getId()), 31, null)));
        this._events.tryEmit(new SearchEvent.Downloading(track, result == Downloads.Enqueued.WAITING_WIFI));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String shortMessage(Throwable $this$shortMessage) {
        String message = $this$shortMessage.getMessage();
        if (message == null) {
            message = $this$shortMessage.getClass().getSimpleName();
        }
        Intrinsics.checkNotNull(message);
        Sequence $this$lastOrNull$iv = SequencesKt.map(StringsKt.lineSequence(message), new Function1() { // from class: com.muzk.app.ui.search.SearchViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchViewModel.shortMessage$lambda$4((String) obj);
            }
        });
        Object last$iv = null;
        for (Object element$iv : $this$lastOrNull$iv) {
            String it = (String) element$iv;
            if (StringsKt.startsWith$default(it, "ERROR", false, 2, (Object) null)) {
                last$iv = element$iv;
            }
        }
        String str = (String) last$iv;
        if (str != null) {
            return str;
        }
        String message2 = $this$shortMessage.getMessage();
        if (message2 == null) {
            message2 = "erro";
        }
        return StringsKt.take((String) SequencesKt.first(StringsKt.lineSequence(message2)), 140);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String shortMessage$lambda$4(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trim((CharSequence) it).toString();
    }
}
