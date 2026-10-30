package com.muzk.app.ui.home;

import android.app.Application;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.muzk.app.data.LocalMusicRepository;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.PlayStats;
import com.muzk.app.data.PlaylistStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/muzk/app/ui/home/HomeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "tracks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/muzk/app/data/LocalTrack;", "permission", "Lkotlin/Pair;", "", "askedPermission", "getAskedPermission", "()Z", "setAskedPermission", "(Z)V", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/muzk/app/ui/home/HomeUiState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setPermission", "", "granted", "reload", "Lkotlinx/coroutines/Job;", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HomeViewModel extends AndroidViewModel {
    public static final int TILE_COUNT = 4;
    public static final int TOP_COUNT = 5;
    private boolean askedPermission;
    private final MutableStateFlow<Pair<Boolean, Boolean>> permission;
    private final StateFlow<HomeUiState> state;
    private final MutableStateFlow<List<LocalTrack>> tracks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.tracks = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.permission = StateFlowKt.MutableStateFlow(TuplesKt.to(false, false));
        this.state = FlowKt.stateIn(FlowKt.combine(this.tracks, PlaylistStore.INSTANCE.get(app).getPlaylists(), PlayStats.INSTANCE.get(app).getCounts(), this.permission, new HomeViewModel$state$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), new HomeUiState(false, false, null, null, 15, null));
    }

    public final boolean getAskedPermission() {
        return this.askedPermission;
    }

    public final void setAskedPermission(boolean z) {
        this.askedPermission = z;
    }

    public final StateFlow<HomeUiState> getState() {
        return this.state;
    }

    public final void setPermission(boolean granted) {
        this.permission.setValue(TuplesKt.to(Boolean.valueOf(granted), this.permission.getValue().getSecond()));
        if (granted) {
            reload();
        }
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.home.HomeViewModel$reload$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.home.HomeViewModel$reload$1", f = "HomeViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HomeViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        HomeViewModel homeViewModel = HomeViewModel.this;
                        Result.Companion companion = Result.INSTANCE;
                        LocalMusicRepository localMusicRepository = LocalMusicRepository.INSTANCE;
                        Application application = homeViewModel.getApplication();
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
            HomeViewModel homeViewModel2 = HomeViewModel.this;
            if (Result.m670isSuccessimpl($result)) {
                List it = (List) $result;
                homeViewModel2.tracks.setValue(it);
            }
            HomeViewModel.this.permission.setValue(TuplesKt.to(((Pair) HomeViewModel.this.permission.getValue()).getFirst(), Boxing.boxBoolean(true)));
            return Unit.INSTANCE;
        }
    }

    public final Job reload() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
