package com.muzk.app.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PlayStats.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/muzk/app/data/PlayStats;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "_counts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "", "counts", "Lkotlinx/coroutines/flow/StateFlow;", "getCounts", "()Lkotlinx/coroutines/flow/StateFlow;", "record", "", "mediaId", "", "read", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlayStats {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile PlayStats instance;
    private final MutableStateFlow<Map<Long, Integer>> _counts;
    private final StateFlow<Map<Long, Integer>> counts;
    private final SharedPreferences prefs;

    public /* synthetic */ PlayStats(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private PlayStats(Context context) {
        this.prefs = context.getSharedPreferences("play_stats", 0);
        this._counts = StateFlowKt.MutableStateFlow(read());
        this.counts = FlowKt.asStateFlow(this._counts);
    }

    public final StateFlow<Map<Long, Integer>> getCounts() {
        return this.counts;
    }

    public final synchronized void record(String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        if (StringsKt.startsWith$default(mediaId, "content://", false, 2, (Object) null)) {
            Long longOrNull = StringsKt.toLongOrNull(StringsKt.substringAfterLast$default(mediaId, '/', (String) null, 2, (Object) null));
            if (longOrNull != null) {
                long id = longOrNull.longValue();
                Map<Long, Integer> value = this._counts.getValue();
                Long lValueOf = Long.valueOf(id);
                Integer num = this._counts.getValue().get(Long.valueOf(id));
                Map<Long, Integer> mapPlus = MapsKt.plus(value, TuplesKt.to(lValueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1)));
                this._counts.setValue(mapPlus);
                SharedPreferences prefs = this.prefs;
                Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
                SharedPreferences.Editor editor$iv = prefs.edit();
                editor$iv.putInt(String.valueOf(id), ((Number) MapsKt.getValue(mapPlus, Long.valueOf(id))).intValue());
                editor$iv.apply();
            }
        }
    }

    private final Map<Long, Integer> read() {
        Map<String, ?> all = this.prefs.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        int $i$f$mapNotNull = 0;
        Collection destination$iv$iv = new ArrayList();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            Intrinsics.checkNotNull(k);
            Long longOrNull = StringsKt.toLongOrNull(k);
            Pair pair = null;
            if (longOrNull != null) {
                long id = longOrNull.longValue();
                Integer num = v instanceof Integer ? (Integer) v : null;
                if (num != null) {
                    int it = num.intValue();
                    pair = TuplesKt.to(Long.valueOf(id), Integer.valueOf(it));
                }
            }
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
            all = all;
            $i$f$mapNotNull = $i$f$mapNotNull;
        }
        return MapsKt.toMap((List) destination$iv$iv);
    }

    /* JADX INFO: compiled from: PlayStats.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/muzk/app/data/PlayStats$Companion;", "", "<init>", "()V", "instance", "Lcom/muzk/app/data/PlayStats;", "get", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlayStats get(Context context) {
            PlayStats it;
            Intrinsics.checkNotNullParameter(context, "context");
            PlayStats playStats = PlayStats.instance;
            if (playStats == null) {
                synchronized (this) {
                    it = PlayStats.instance;
                    if (it == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        it = new PlayStats(applicationContext, null);
                        Companion companion = PlayStats.INSTANCE;
                        PlayStats.instance = it;
                    }
                }
                return it;
            }
            return playStats;
        }
    }
}
