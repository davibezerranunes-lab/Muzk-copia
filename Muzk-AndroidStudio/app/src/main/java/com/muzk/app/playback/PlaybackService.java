package com.muzk.app.playback;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.Equalizer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import androidx.preference.PreferenceManager;
import com.muzk.app.data.PlayStats;
import com.muzk.app.ui.MainActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PlaybackService.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/muzk/app/playback/PlaybackService;", "Landroidx/media3/session/MediaSessionService;", "<init>", "()V", "session", "Landroidx/media3/session/MediaSession;", "onCreate", "", "onGetSession", "controllerInfo", "Landroidx/media3/session/MediaSession$ControllerInfo;", "onTaskRemoved", "rootIntent", "Landroid/content/Intent;", "onDestroy", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlaybackService extends MediaSessionService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PREF_EQ_BANDS = "eq_bands";
    public static final String PREF_EQ_ENABLED = "eq_enabled";
    private static volatile int audioSessionId;
    private static volatile Equalizer equalizer;
    private MediaSession session;

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ExoPlayer player = new ExoPlayer.Builder(this).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), true).setHandleAudioBecomingNoisy(true).build();
        Intrinsics.checkNotNullExpressionValue(player, "build(...)");
        final PlayStats stats = PlayStats.INSTANCE.get(this);
        player.addListener(new Player.Listener() { // from class: com.muzk.app.playback.PlaybackService.onCreate.1
            @Override // androidx.media3.common.Player.Listener
            public void onMediaItemTransition(MediaItem mediaItem, int reason) {
                String p0;
                if (mediaItem != null && (p0 = mediaItem.mediaId) != null) {
                    stats.record(p0);
                }
            }
        });
        audioSessionId = player.getAudioSessionId();
        sendBroadcast(new Intent("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION").putExtra("android.media.extra.AUDIO_SESSION", audioSessionId).putExtra("android.media.extra.PACKAGE_NAME", getPackageName()).putExtra("android.media.extra.CONTENT_TYPE", 0));
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(PREF_EQ_ENABLED, false)) {
            INSTANCE.obtainEqualizer(this);
        }
        PendingIntent openApp = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class).putExtra(MainActivity.EXTRA_OPEN_PLAYER, true), 201326592);
        this.session = new MediaSession.Builder(this, player).setSessionActivity(openApp).build();
    }

    @Override // androidx.media3.session.MediaSessionService
    public MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo) {
        Intrinsics.checkNotNullParameter(controllerInfo, "controllerInfo");
        return this.session;
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        MediaSession mediaSession = this.session;
        Player player = mediaSession != null ? mediaSession.getPlayer() : null;
        if (player == null || !player.getPlayWhenReady() || player.getMediaItemCount() == 0) {
            stopSelf();
        }
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public void onDestroy() {
        sendBroadcast(new Intent("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION").putExtra("android.media.extra.AUDIO_SESSION", audioSessionId).putExtra("android.media.extra.PACKAGE_NAME", getPackageName()));
        Equalizer equalizer2 = equalizer;
        if (equalizer2 != null) {
            equalizer2.release();
        }
        equalizer = null;
        audioSessionId = 0;
        MediaSession $this$onDestroy_u24lambda_u240 = this.session;
        if ($this$onDestroy_u24lambda_u240 != null) {
            $this$onDestroy_u24lambda_u240.getPlayer().release();
            $this$onDestroy_u24lambda_u240.release();
        }
        this.session = null;
        super.onDestroy();
    }

    /* JADX INFO: compiled from: PlaybackService.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/muzk/app/playback/PlaybackService$Companion;", "", "<init>", "()V", "PREF_EQ_ENABLED", "", "PREF_EQ_BANDS", "value", "", "audioSessionId", "getAudioSessionId", "()I", "Landroid/media/audiofx/Equalizer;", "equalizer", "getEqualizer", "()Landroid/media/audiofx/Equalizer;", "obtainEqualizer", "context", "Landroid/content/Context;", "saveEqualizer", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getAudioSessionId() {
            return PlaybackService.audioSessionId;
        }

        public final Equalizer getEqualizer() {
            return PlaybackService.equalizer;
        }

        public final Equalizer obtainEqualizer(Context context) {
            Object objM663constructorimpl;
            List saved;
            Iterable iterableSplit$default;
            Intrinsics.checkNotNullParameter(context, "context");
            if (getAudioSessionId() == 0) {
                return null;
            }
            Equalizer it = getEqualizer();
            if (it != null) {
                return it;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion $this$obtainEqualizer_u24lambda_u244 = this;
                Equalizer $this$obtainEqualizer_u24lambda_u244_u24lambda_u243 = new Equalizer(0, $this$obtainEqualizer_u24lambda_u244.getAudioSessionId());
                String string = PreferenceManager.getDefaultSharedPreferences(context).getString(PlaybackService.PREF_EQ_BANDS, null);
                if (string == null || (iterableSplit$default = StringsKt.split$default((CharSequence) string, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    saved = null;
                } else {
                    Iterable $this$mapNotNull$iv = iterableSplit$default;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Short shortOrNull = StringsKt.toShortOrNull((String) element$iv$iv$iv);
                        if (shortOrNull != null) {
                            destination$iv$iv.add(shortOrNull);
                        }
                    }
                    saved = (List) destination$iv$iv;
                }
                if (saved != null) {
                    List $this$forEachIndexed$iv = saved;
                    int band = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv = band + 1;
                        if (band < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        short level = ((Number) item$iv).shortValue();
                        if (band < $this$obtainEqualizer_u24lambda_u244_u24lambda_u243.getNumberOfBands()) {
                            $this$obtainEqualizer_u24lambda_u244_u24lambda_u243.setBandLevel((short) band, level);
                        }
                        band = index$iv;
                    }
                }
                $this$obtainEqualizer_u24lambda_u244_u24lambda_u243.setEnabled(true);
                objM663constructorimpl = Result.m663constructorimpl($this$obtainEqualizer_u24lambda_u244_u24lambda_u243);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
            }
            Object obj = Result.m669isFailureimpl(objM663constructorimpl) ? null : objM663constructorimpl;
            Companion companion3 = PlaybackService.INSTANCE;
            PlaybackService.equalizer = (Equalizer) obj;
            return (Equalizer) obj;
        }

        public final void saveEqualizer(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            final Equalizer eq = getEqualizer();
            if (eq == null) {
                return;
            }
            String levels = CollectionsKt.joinToString$default(RangesKt.until(0, eq.getNumberOfBands()), ",", null, null, 0, null, new Function1() { // from class: com.muzk.app.playback.PlaybackService$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlaybackService.Companion.saveEqualizer$lambda$6(eq, ((Integer) obj).intValue());
                }
            }, 30, null);
            SharedPreferences $this$edit_u24default$iv = PreferenceManager.getDefaultSharedPreferences(context);
            Intrinsics.checkNotNullExpressionValue($this$edit_u24default$iv, "getDefaultSharedPreferences(...)");
            SharedPreferences.Editor editor$iv = $this$edit_u24default$iv.edit();
            editor$iv.putString(PlaybackService.PREF_EQ_BANDS, levels);
            editor$iv.putBoolean(PlaybackService.PREF_EQ_ENABLED, eq.getEnabled());
            editor$iv.apply();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence saveEqualizer$lambda$6(Equalizer $eq, int it) {
            return String.valueOf((int) $eq.getBandLevel((short) it));
        }
    }
}
