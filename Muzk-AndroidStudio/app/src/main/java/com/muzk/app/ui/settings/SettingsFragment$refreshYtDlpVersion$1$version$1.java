package com.muzk.app.ui.settings;

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
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.muzk.app.ui.settings.SettingsFragment$refreshYtDlpVersion$1$version$1", f = "SettingsFragment.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class SettingsFragment$refreshYtDlpVersion$1$version$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingsFragment$refreshYtDlpVersion$1$version$1(SettingsFragment settingsFragment, Continuation<? super SettingsFragment$refreshYtDlpVersion$1$version$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SettingsFragment$refreshYtDlpVersion$1$version$1 settingsFragment$refreshYtDlpVersion$1$version$1 = new SettingsFragment$refreshYtDlpVersion$1$version$1(this.this$0, continuation);
        settingsFragment$refreshYtDlpVersion$1$version$1.L$0 = obj;
        return settingsFragment$refreshYtDlpVersion$1$version$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((SettingsFragment$refreshYtDlpVersion$1$version$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object objM663constructorimpl;
        SettingsFragment settingsFragment;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SettingsFragment settingsFragment2 = this.this$0;
                    Result.Companion companion = Result.INSTANCE;
                    CompletableDeferred<Unit> ytdlReady = MuzkApp.INSTANCE.getYtdlReady();
                    this.L$0 = settingsFragment2;
                    this.label = 1;
                    if (ytdlReady.await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    settingsFragment = settingsFragment2;
                    break;
                case 1:
                    settingsFragment = (SettingsFragment) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objM663constructorimpl = Result.m663constructorimpl(YoutubeDL.getInstance().versionName(settingsFragment.requireContext().getApplicationContext()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m669isFailureimpl(objM663constructorimpl)) {
            return null;
        }
        return objM663constructorimpl;
    }
}
