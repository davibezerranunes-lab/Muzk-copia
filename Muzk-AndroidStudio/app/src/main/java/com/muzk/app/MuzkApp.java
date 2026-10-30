package com.muzk.app;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.ImageLoaderFactory;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.DynamicColorsOptions;
import com.muzk.app.data.AudioCover;
import com.muzk.app.data.AudioCoverFetcher;
import com.muzk.app.data.AudioCoverKeyer;
import com.muzk.app.ui.AppPalette;
import com.yausername.ffmpeg.FFmpeg;
import com.yausername.youtubedl_android.YoutubeDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: MuzkApp.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/muzk/app/MuzkApp;", "Landroid/app/Application;", "Lcoil/ImageLoaderFactory;", "<init>", "()V", "appScope", "Lkotlinx/coroutines/CoroutineScope;", "getAppScope", "()Lkotlinx/coroutines/CoroutineScope;", "onCreate", "", "initYtDlp", "Lkotlinx/coroutines/Job;", "createNotificationChannels", "newImageLoader", "Lcoil/ImageLoader;", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MuzkApp extends Application implements ImageLoaderFactory {
    public static final String CHANNEL_DOWNLOADS = "downloads";
    public static final String KEY_LAST_UPDATE = "ytdlp_last_update";
    private static final String TAG = "Muzk";
    private final CoroutineScope appScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CompletableDeferred<Unit> ytdlReady = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    public final CoroutineScope getAppScope() {
        return this.appScope;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this, new DynamicColorsOptions.Builder().setPrecondition(new DynamicColors.Precondition() { // from class: com.muzk.app.MuzkApp$$ExternalSyntheticLambda0
            @Override // com.google.android.material.color.DynamicColors.Precondition
            public final boolean shouldApplyDynamicColors(Activity activity, int i) {
                return MuzkApp.onCreate$lambda$0(activity, i);
            }
        }).build());
        createNotificationChannels();
        initYtDlp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return Intrinsics.areEqual(AppPalette.INSTANCE.current(activity), AppPalette.WALLPAPER);
    }

    /* JADX INFO: renamed from: com.muzk.app.MuzkApp$initYtDlp$1, reason: invalid class name */
    /* JADX INFO: compiled from: MuzkApp.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.MuzkApp$initYtDlp$1", f = "MuzkApp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = MuzkApp.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM663constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    try {
                        YoutubeDL.getInstance().init(MuzkApp.this);
                        FFmpeg.getInstance().init(MuzkApp.this);
                        MuzkApp.INSTANCE.getYtdlReady().complete(Unit.INSTANCE);
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MuzkApp.this);
                        long last = prefs.getLong(MuzkApp.KEY_LAST_UPDATE, 0L);
                        if (System.currentTimeMillis() - last > 86400000) {
                            MuzkApp muzkApp = MuzkApp.this;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                objM663constructorimpl = Result.m663constructorimpl(YoutubeDL.updateYoutubeDL$default(YoutubeDL.getInstance(), muzkApp, null, 2, null));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m670isSuccessimpl(objM663constructorimpl)) {
                                Intrinsics.checkNotNull(prefs);
                                SharedPreferences.Editor editor$iv = prefs.edit();
                                editor$iv.putLong(MuzkApp.KEY_LAST_UPDATE, System.currentTimeMillis());
                                editor$iv.apply();
                            }
                            Throwable it = Result.m666exceptionOrNullimpl(objM663constructorimpl);
                            if (it != null) {
                                Log.w("Muzk", "Não consegui atualizar o yt-dlp agora", it);
                            }
                            break;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e) {
                        Log.e("Muzk", "Falha ao iniciar yt-dlp", e);
                        MuzkApp.INSTANCE.getYtdlReady().completeExceptionally(e);
                        return Unit.INSTANCE;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final Job initYtDlp() {
        return BuildersKt__Builders_commonKt.launch$default(this.appScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void createNotificationChannels() {
        NotificationManager nm = (NotificationManager) getSystemService(NotificationManager.class);
        nm.createNotificationChannel(new NotificationChannel(CHANNEL_DOWNLOADS, getString(R.string.channel_downloads), 2));
    }

    @Override // coil.ImageLoaderFactory
    public ImageLoader newImageLoader() {
        ImageLoader.Builder this_$iv = new ImageLoader.Builder(this);
        ComponentRegistry.Builder $this$newImageLoader_u24lambda_u241 = new ComponentRegistry.Builder();
        $this$newImageLoader_u24lambda_u241.add(new AudioCoverKeyer(), AudioCover.class);
        $this$newImageLoader_u24lambda_u241.add(new AudioCoverFetcher.Factory(), AudioCover.class);
        return this_$iv.components($this$newImageLoader_u24lambda_u241.build()).crossfade(true).build();
    }

    /* JADX INFO: compiled from: MuzkApp.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/muzk/app/MuzkApp$Companion;", "", "<init>", "()V", "TAG", "", "CHANNEL_DOWNLOADS", "KEY_LAST_UPDATE", "ytdlReady", "Lkotlinx/coroutines/CompletableDeferred;", "", "getYtdlReady", "()Lkotlinx/coroutines/CompletableDeferred;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CompletableDeferred<Unit> getYtdlReady() {
            return MuzkApp.ytdlReady;
        }
    }
}
