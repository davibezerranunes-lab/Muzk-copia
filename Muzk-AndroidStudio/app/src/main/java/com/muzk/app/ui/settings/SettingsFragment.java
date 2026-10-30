package com.muzk.app.ui.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.muzk.app.BuildConfig;
import com.muzk.app.R;
import com.muzk.app.playback.PlaybackService;
import com.muzk.app.ui.AppPalette;
import com.yausername.youtubedl_android.YoutubeDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J+\u0010\u0013\u001a\u00020\u00052\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0002¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fH\u0002¨\u0006\u001b"}, d2 = {"Lcom/muzk/app/ui/settings/SettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "", "openSystemEqualizer", "openAppEqualizer", "refreshYtDlpVersion", "pref", "Landroidx/preference/Preference;", "updateYtDlp", "launchUi", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "toast", "text", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SettingsFragment extends PreferenceFragmentCompat {
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setDivider(null);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        Preference preferenceFindPreference = findPreference("version");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setSummary(BuildConfig.VERSION_NAME);
        }
        Preference preferenceFindPreference2 = findPreference(AppPalette.PREF);
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.muzk.app.ui.settings.SettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return SettingsFragment.onCreatePreferences$lambda$1(this.f$0, preference, obj);
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference("eq_system");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.muzk.app.ui.settings.SettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SettingsFragment.onCreatePreferences$lambda$2(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference4 = findPreference("eq_app");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.muzk.app.ui.settings.SettingsFragment$$ExternalSyntheticLambda3
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SettingsFragment.onCreatePreferences$lambda$3(this.f$0, preference);
                }
            });
        }
        Preference update = findPreference("update_ytdlp");
        refreshYtDlpVersion(update);
        if (update != null) {
            update.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.muzk.app.ui.settings.SettingsFragment$$ExternalSyntheticLambda4
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SettingsFragment.onCreatePreferences$lambda$4(this.f$0, preference);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$1(final SettingsFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        View view = this$0.getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.muzk.app.ui.settings.SettingsFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SettingsFragment.onCreatePreferences$lambda$1$lambda$0(this.f$0);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreatePreferences$lambda$1$lambda$0(SettingsFragment this$0) {
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.recreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$2(SettingsFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.openSystemEqualizer();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$3(SettingsFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.openAppEqualizer();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$4(SettingsFragment this$0, Preference pref) {
        Intrinsics.checkNotNullParameter(pref, "pref");
        this$0.updateYtDlp(pref);
        return true;
    }

    private final void openSystemEqualizer() {
        int session = PlaybackService.INSTANCE.getAudioSessionId();
        if (session == 0) {
            String string = getString(R.string.eq_need_playback);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toast(string);
        } else {
            Intent intent = new Intent("android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL").putExtra("android.media.extra.AUDIO_SESSION", session).putExtra("android.media.extra.PACKAGE_NAME", requireContext().getPackageName()).putExtra("android.media.extra.CONTENT_TYPE", 0);
            Intrinsics.checkNotNullExpressionValue(intent, "putExtra(...)");
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                openAppEqualizer();
            }
        }
    }

    private final void openAppEqualizer() {
        if (PlaybackService.INSTANCE.getAudioSessionId() == 0) {
            String string = getString(R.string.eq_need_playback);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toast(string);
        } else {
            EqualizerDialog equalizerDialog = EqualizerDialog.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            equalizerDialog.show(contextRequireContext);
        }
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.settings.SettingsFragment$refreshYtDlpVersion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.settings.SettingsFragment$refreshYtDlpVersion$1", f = "SettingsFragment.kt", i = {}, l = {Base64.mimeLineLength}, m = "invokeSuspend", n = {}, s = {})
    static final class C01141 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Preference $pref;
        int label;
        final /* synthetic */ SettingsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01141(Preference preference, SettingsFragment settingsFragment, Continuation<? super C01141> continuation) {
            super(1, continuation);
            this.$pref = preference;
            this.this$0 = settingsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C01141(this.$pref, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C01141) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SettingsFragment$refreshYtDlpVersion$1$version$1(this.this$0, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String version = (String) $result;
            Preference preference = this.$pref;
            SettingsFragment settingsFragment = this.this$0;
            int i = R.string.pref_update_summary;
            if (version == null) {
                version = "?";
            }
            preference.setSummary(settingsFragment.getString(i, version));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshYtDlpVersion(Preference pref) {
        if (pref == null) {
            return;
        }
        launchUi(new C01141(pref, this, null));
    }

    private final void updateYtDlp(Preference pref) {
        pref.setEnabled(false);
        pref.setSummary(getString(R.string.updating));
        Context app = requireContext().getApplicationContext();
        launchUi(new C01151(pref, this, app, null));
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.settings.SettingsFragment$updateYtDlp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.settings.SettingsFragment$updateYtDlp$1", f = "SettingsFragment.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m = "invokeSuspend", n = {}, s = {})
    static final class C01151 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $app;
        final /* synthetic */ Preference $pref;
        int label;
        final /* synthetic */ SettingsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01151(Preference preference, SettingsFragment settingsFragment, Context context, Continuation<? super C01151> continuation) {
            super(1, continuation);
            this.$pref = preference;
            this.this$0 = settingsFragment;
            this.$app = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C01151(this.$pref, this.this$0, this.$app, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C01151) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new SettingsFragment$updateYtDlp$1$result$1(this.$app, null), this);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objWithContext;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object value = ((Result) $result).getValue();
            SettingsFragment settingsFragment = this.this$0;
            if (Result.m670isSuccessimpl(value)) {
                String string = settingsFragment.getString(((YoutubeDL.UpdateStatus) value) == YoutubeDL.UpdateStatus.DONE ? R.string.update_done : R.string.update_latest);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                settingsFragment.toast(string);
            }
            SettingsFragment settingsFragment2 = this.this$0;
            Throwable it = Result.m666exceptionOrNullimpl(value);
            if (it != null) {
                int i = R.string.update_failed;
                String message = it.getMessage();
                if (message == null) {
                    message = "";
                }
                String string2 = settingsFragment2.getString(i, message);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                settingsFragment2.toast(string2);
            }
            this.$pref.setEnabled(true);
            this.this$0.refreshYtDlpVersion(this.$pref);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.settings.SettingsFragment$launchUi$1, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.settings.SettingsFragment$launchUi$1", f = "SettingsFragment.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private final void launchUi(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(block, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toast(String text) {
        Context it = getContext();
        if (it != null) {
            Toast.makeText(it, text, 0).show();
        }
    }
}
