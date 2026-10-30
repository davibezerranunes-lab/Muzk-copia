package com.muzk.app.playback;

import android.app.Application;
import android.content.ComponentName;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.session.MediaController;
import androidx.media3.session.SessionToken;
import com.google.common.util.concurrent.ListenableFuture;
import com.muzk.app.data.ModelsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PlayerViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0019\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u001b\u001a\u00020\u00122\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J*\u0010\u001d\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020 J\u0006\u0010'\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\u0012J\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u0012J\u0006\u0010.\u001a\u00020\u0012J\u0006\u0010/\u001a\u00020\u0012J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0012H\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u00065"}, d2 = {"Lcom/muzk/app/playback/PlayerViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/muzk/app/playback/PlayerUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "controller", "Landroidx/media3/session/MediaController;", "pending", "", "Lkotlin/Function1;", "", "ticker", "Lkotlinx/coroutines/Job;", "controllerFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lkotlin/jvm/internal/EnhancedNullability;", "listener", "com/muzk/app/playback/PlayerViewModel$listener$1", "Lcom/muzk/app/playback/PlayerViewModel$listener$1;", "withController", "block", "playQueue", "items", "", "Landroidx/media3/common/MediaItem;", "startIndex", "", "source", "", "playNext", "item", "togglePlay", "next", "previous", "seekTo", "ms", "", "toggleShuffle", "cycleRepeat", "clearError", "sync", TtmlNode.TAG_P, "Landroidx/media3/common/Player;", "startTicker", "onCleared", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlayerViewModel extends AndroidViewModel {
    private final MutableStateFlow<PlayerUiState> _state;
    private MediaController controller;
    private final ListenableFuture<MediaController> controllerFuture;
    private final PlayerViewModel$listener$1 listener;
    private final List<Function1<MediaController, Unit>> pending;
    private final StateFlow<PlayerUiState> state;
    private Job ticker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.muzk.app.playback.PlayerViewModel$listener$1] */
    public PlayerViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this._state = StateFlowKt.MutableStateFlow(new PlayerUiState(false, null, null, null, false, false, 0L, 0L, false, 0, null, false, null, null, null, 32767, null));
        this.state = FlowKt.asStateFlow(this._state);
        this.pending = new ArrayList();
        ListenableFuture<MediaController> listenableFutureBuildAsync = new MediaController.Builder(app, new SessionToken(app, new ComponentName(app, (Class<?>) PlaybackService.class))).buildAsync();
        Intrinsics.checkNotNullExpressionValue(listenableFutureBuildAsync, "buildAsync(...)");
        this.controllerFuture = listenableFutureBuildAsync;
        this.listener = new Player.Listener() { // from class: com.muzk.app.playback.PlayerViewModel$listener$1
            @Override // androidx.media3.common.Player.Listener
            public void onEvents(Player player, Player.Events events) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(events, "events");
                this.this$0.sync(player);
            }
        };
        this.controllerFuture.addListener(new Runnable() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PlayerViewModel._init_$lambda$2(this.f$0);
            }
        }, ContextCompat.getMainExecutor(app));
    }

    public final StateFlow<PlayerUiState> getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(PlayerViewModel this$0) {
        Object objM663constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM663constructorimpl = Result.m663constructorimpl(this$0.controllerFuture.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m669isFailureimpl(objM663constructorimpl)) {
            objM663constructorimpl = null;
        }
        MediaController c = (MediaController) objM663constructorimpl;
        if (c == null) {
            return;
        }
        this$0.controller = c;
        c.addListener(this$0.listener);
        this$0.sync(c);
        Iterable $this$forEach$iv = this$0.pending;
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1) element$iv;
            it.invoke(c);
        }
        this$0.pending.clear();
    }

    private final void withController(Function1<? super MediaController, Unit> block) {
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            block.invoke(mediaController);
        } else {
            this.pending.add(block);
        }
    }

    public static /* synthetic */ void playQueue$default(PlayerViewModel playerViewModel, List list, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        playerViewModel.playQueue(list, i, str);
    }

    public final void playQueue(final List<MediaItem> items, final int startIndex, final String source) {
        Intrinsics.checkNotNullParameter(items, "items");
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.playQueue$lambda$4(this.f$0, items, startIndex, source, (MediaController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playQueue$lambda$4(PlayerViewModel this$0, List $items, int $startIndex, String $source, MediaController it) {
        PlayerUiState value;
        PlayerUiState s;
        Intrinsics.checkNotNullParameter(it, "it");
        MutableStateFlow<PlayerUiState> mutableStateFlow = this$0._state;
        do {
            value = mutableStateFlow.getValue();
            s = value;
        } while (!mutableStateFlow.compareAndSet(value, s.copy((32575 & 1) != 0 ? s.hasMedia : false, (32575 & 2) != 0 ? s.title : null, (32575 & 4) != 0 ? s.artist : null, (32575 & 8) != 0 ? s.cover : null, (32575 & 16) != 0 ? s.isPlaying : false, (32575 & 32) != 0 ? s.isBuffering : false, (32575 & 64) != 0 ? s.positionMs : 0L, (32575 & 128) != 0 ? s.durationMs : 0L, (32575 & 256) != 0 ? s.shuffle : false, (32575 & 512) != 0 ? s.repeatMode : 0, (32575 & 1024) != 0 ? s.mediaId : null, (32575 & 2048) != 0 ? s.isRemote : false, (32575 & 4096) != 0 ? s.source : $source, (32575 & 8192) != 0 ? s.album : null, (32575 & 16384) != 0 ? s.error : null)));
        it.setMediaItems($items, $startIndex, 0L);
        it.prepare();
        it.play();
        return Unit.INSTANCE;
    }

    public final void playNext(final MediaItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.playNext$lambda$5(item, (MediaController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playNext$lambda$5(MediaItem $item, MediaController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getMediaItemCount() == 0) {
            it.setMediaItem($item);
            it.prepare();
            it.play();
        } else {
            it.addMediaItem(it.getCurrentMediaItemIndex() + 1, $item);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit togglePlay$lambda$6(MediaController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isPlaying()) {
            it.pause();
        } else {
            if (it.getPlaybackState() == 1) {
                it.prepare();
            }
            it.play();
        }
        return Unit.INSTANCE;
    }

    public final void togglePlay() {
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.togglePlay$lambda$6((MediaController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit next$lambda$7(MediaController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.seekToNext();
        return Unit.INSTANCE;
    }

    public final void next() {
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.next$lambda$7((MediaController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit previous$lambda$8(MediaController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.seekToPrevious();
        return Unit.INSTANCE;
    }

    public final void previous() {
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.previous$lambda$8((MediaController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit seekTo$lambda$9(long $ms, MediaController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.seekTo($ms);
        return Unit.INSTANCE;
    }

    public final void seekTo(final long ms) {
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.seekTo$lambda$9(ms, (MediaController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toggleShuffle$lambda$10(MediaController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setShuffleModeEnabled(!it.getShuffleModeEnabled());
        return Unit.INSTANCE;
    }

    public final void toggleShuffle() {
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.toggleShuffle$lambda$10((MediaController) obj);
            }
        });
    }

    public final void cycleRepeat() {
        withController(new Function1() { // from class: com.muzk.app.playback.PlayerViewModel$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayerViewModel.cycleRepeat$lambda$11((MediaController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cycleRepeat$lambda$11(MediaController it) {
        int i;
        Intrinsics.checkNotNullParameter(it, "it");
        switch (it.getRepeatMode()) {
            case 0:
                i = 2;
                break;
            case 1:
            default:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
        }
        it.setRepeatMode(i);
        return Unit.INSTANCE;
    }

    public final void clearError() {
        PlayerUiState value;
        PlayerUiState it;
        MutableStateFlow<PlayerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((32575 & 1) != 0 ? it.hasMedia : false, (32575 & 2) != 0 ? it.title : null, (32575 & 4) != 0 ? it.artist : null, (32575 & 8) != 0 ? it.cover : null, (32575 & 16) != 0 ? it.isPlaying : false, (32575 & 32) != 0 ? it.isBuffering : false, (32575 & 64) != 0 ? it.positionMs : 0L, (32575 & 128) != 0 ? it.durationMs : 0L, (32575 & 256) != 0 ? it.shuffle : false, (32575 & 512) != 0 ? it.repeatMode : 0, (32575 & 1024) != 0 ? it.mediaId : null, (32575 & 2048) != 0 ? it.isRemote : false, (32575 & 4096) != 0 ? it.source : null, (32575 & 8192) != 0 ? it.album : null, (32575 & 16384) != 0 ? it.error : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x009a  */
    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:60:0x0112 A[LOOP:0: B:3:0x0012->B:60:0x0112, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x0100 A[EDGE_INSN: B:61:0x0100->B:53:0x0100 BREAK  A[LOOP:0: B:3:0x0012->B:60:0x0112], SYNTHETIC] */
    public final void sync(Player p) {
        boolean z;
        String str;
        int i;
        boolean z2;
        CharSequence charSequence;
        String string;
        String str2;
        PlaybackException e;
        String error;
        MediaItem item;
        MediaMetadata meta;
        int i2;
        String str3;
        MediaItem item2 = p.getCurrentMediaItem();
        MediaMetadata meta2 = p.getMediaMetadata();
        Intrinsics.checkNotNullExpressionValue(meta2, "getMediaMetadata(...)");
        MutableStateFlow<PlayerUiState> mutableStateFlow = this._state;
        while (true) {
            PlayerUiState value = mutableStateFlow.getValue();
            PlayerUiState it = value;
            boolean z3 = item2 != null;
            CharSequence charSequence2 = meta2.title;
            String string2 = charSequence2 != null ? charSequence2.toString() : null;
            if (string2 == null) {
                string2 = "";
            }
            CharSequence charSequence3 = meta2.artist;
            String string3 = charSequence3 != null ? charSequence3.toString() : null;
            if (string3 == null) {
                string3 = "";
            }
            Object objCoverModel = ModelsKt.coverModel(item2 != null ? item2.mediaId : null, meta2.artworkUri);
            boolean zIsPlaying = p.isPlaying();
            boolean z4 = p.getPlaybackState() == 2;
            long currentPosition = p.getCurrentPosition();
            boolean z5 = z3;
            boolean z6 = z4;
            long jCoerceAtLeast = RangesKt.coerceAtLeast(p.getDuration(), 0L);
            boolean shuffleModeEnabled = p.getShuffleModeEnabled();
            int repeatMode = p.getRepeatMode();
            String str4 = item2 != null ? item2.mediaId : null;
            if (item2 == null || (str3 = item2.mediaId) == null) {
                z = false;
                str = null;
                i = 1;
            } else {
                z = false;
                str = null;
                i = 1;
                if (StringsKt.startsWith$default(str3, "http", false, 2, (Object) null)) {
                    z2 = true;
                }
                charSequence = meta2.albumTitle;
                if (charSequence != null) {
                    string = charSequence.toString();
                } else {
                    string = str;
                }
                if (string == null) {
                    str2 = "";
                } else {
                    str2 = string;
                }
                e = p.getPlayerError();
                if (e != null) {
                    error = "Não consegui tocar: " + e.getErrorCodeName();
                    if (error == null) {
                        error = it.getError();
                    }
                } else {
                    error = it.getError();
                }
                item = item2;
                meta = meta2;
                i2 = i;
                if (mutableStateFlow.compareAndSet(value, it.copy((32575 & 1) != 0 ? it.hasMedia : z5, (32575 & 2) != 0 ? it.title : string2, (32575 & 4) != 0 ? it.artist : string3, (32575 & 8) != 0 ? it.cover : objCoverModel, (32575 & 16) != 0 ? it.isPlaying : zIsPlaying, (32575 & 32) != 0 ? it.isBuffering : z6, (32575 & 64) != 0 ? it.positionMs : currentPosition, (32575 & 128) != 0 ? it.durationMs : jCoerceAtLeast, (32575 & 256) != 0 ? it.shuffle : shuffleModeEnabled, (32575 & 512) != 0 ? it.repeatMode : repeatMode, (32575 & 1024) != 0 ? it.mediaId : str4, (32575 & 2048) != 0 ? it.isRemote : z2, (32575 & 4096) != 0 ? it.source : null, (32575 & 8192) != 0 ? it.album : str2, (32575 & 16384) != 0 ? it.error : error))) {
                    break;
                }
                item2 = item;
                meta2 = meta;
            }
            z2 = z;
            charSequence = meta2.albumTitle;
            if (charSequence != null) {
                string = charSequence.toString();
            } else {
                string = str;
            }
            if (string == null) {
                str2 = "";
            } else {
                str2 = string;
            }
            e = p.getPlayerError();
            if (e != null) {
                error = "Não consegui tocar: " + e.getErrorCodeName();
                if (error == null) {
                    error = it.getError();
                }
            } else {
                error = it.getError();
            }
            item = item2;
            meta = meta2;
            i2 = i;
            if (mutableStateFlow.compareAndSet(value, it.copy((32575 & 1) != 0 ? it.hasMedia : z5, (32575 & 2) != 0 ? it.title : string2, (32575 & 4) != 0 ? it.artist : string3, (32575 & 8) != 0 ? it.cover : objCoverModel, (32575 & 16) != 0 ? it.isPlaying : zIsPlaying, (32575 & 32) != 0 ? it.isBuffering : z6, (32575 & 64) != 0 ? it.positionMs : currentPosition, (32575 & 128) != 0 ? it.durationMs : jCoerceAtLeast, (32575 & 256) != 0 ? it.shuffle : shuffleModeEnabled, (32575 & 512) != 0 ? it.repeatMode : repeatMode, (32575 & 1024) != 0 ? it.mediaId : str4, (32575 & 2048) != 0 ? it.isRemote : z2, (32575 & 4096) != 0 ? it.source : null, (32575 & 8192) != 0 ? it.album : str2, (32575 & 16384) != 0 ? it.error : error))) {
                break;
                break;
            } else {
                item2 = item;
                meta2 = meta;
            }
        }
        if (!p.isPlaying()) {
            Job job = this.ticker;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, i2, (Object) null);
                return;
            }
            return;
        }
        startTicker();
    }

    /* JADX INFO: renamed from: com.muzk.app.playback.PlayerViewModel$startTicker$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlayerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.playback.PlayerViewModel$startTicker$1", f = "PlayerViewModel.kt", i = {0}, l = {142}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = PlayerViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$launch;
            Object prevValue$iv;
            PlayerUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$launch = (CoroutineScope) this.L$0;
                    break;
                case 1:
                    $this$launch = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (CoroutineScopeKt.isActive($this$launch)) {
                MediaController c = PlayerViewModel.this.controller;
                if (c != null) {
                    MutableStateFlow $this$update$iv = PlayerViewModel.this._state;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                        it = (PlayerUiState) prevValue$iv;
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((32575 & 1) != 0 ? it.hasMedia : false, (32575 & 2) != 0 ? it.title : null, (32575 & 4) != 0 ? it.artist : null, (32575 & 8) != 0 ? it.cover : null, (32575 & 16) != 0 ? it.isPlaying : false, (32575 & 32) != 0 ? it.isBuffering : false, (32575 & 64) != 0 ? it.positionMs : c.getCurrentPosition(), (32575 & 128) != 0 ? it.durationMs : RangesKt.coerceAtLeast(c.getDuration(), 0L), (32575 & 256) != 0 ? it.shuffle : false, (32575 & 512) != 0 ? it.repeatMode : 0, (32575 & 1024) != 0 ? it.mediaId : null, (32575 & 2048) != 0 ? it.isRemote : false, (32575 & 4096) != 0 ? it.source : null, (32575 & 8192) != 0 ? it.album : null, (32575 & 16384) != 0 ? it.error : null)));
                }
                this.L$0 = $this$launch;
                this.label = 1;
                if (DelayKt.delay(500L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final void startTicker() {
        Job job = this.ticker;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        this.ticker = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            mediaController.removeListener(this.listener);
        }
        MediaController.releaseFuture(this.controllerFuture);
        super.onCleared();
    }
}
