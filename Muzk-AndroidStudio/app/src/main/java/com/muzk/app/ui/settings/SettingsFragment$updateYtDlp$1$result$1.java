package com.muzk.app.ui.settings;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.MuzkApp;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/yausername/youtubedl_android/YoutubeDL$UpdateStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.muzk.app.ui.settings.SettingsFragment$updateYtDlp$1$result$1", f = "SettingsFragment.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class SettingsFragment$updateYtDlp$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends YoutubeDL.UpdateStatus>>, Object> {
    final /* synthetic */ Context $app;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingsFragment$updateYtDlp$1$result$1(Context context, Continuation<? super SettingsFragment$updateYtDlp$1$result$1> continuation) {
        super(2, continuation);
        this.$app = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SettingsFragment$updateYtDlp$1$result$1 settingsFragment$updateYtDlp$1$result$1 = new SettingsFragment$updateYtDlp$1$result$1(this.$app, continuation);
        settingsFragment$updateYtDlp$1$result$1.L$0 = obj;
        return settingsFragment$updateYtDlp$1$result$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends YoutubeDL.UpdateStatus>> continuation) {
        return ((SettingsFragment$updateYtDlp$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object objM663constructorimpl;
        Context context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Context context2 = this.$app;
                    Result.Companion companion = Result.INSTANCE;
                    CompletableDeferred<Unit> ytdlReady = MuzkApp.INSTANCE.getYtdlReady();
                    this.L$0 = context2;
                    this.label = 1;
                    if (ytdlReady.await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    context = context2;
                    break;
                case 1:
                    context = (Context) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            YoutubeDL youtubeDL = YoutubeDL.getInstance();
            Intrinsics.checkNotNull(context);
            objM663constructorimpl = Result.m663constructorimpl(YoutubeDL.updateYoutubeDL$default(youtubeDL, context, null, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m662boximpl(objM663constructorimpl);
    }
}
