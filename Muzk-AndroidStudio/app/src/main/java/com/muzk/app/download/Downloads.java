package com.muzk.app.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.muzk.app.data.RemoteTrack;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Downloads.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/muzk/app/download/Downloads;", "", "<init>", "()V", "TAG", "", "PREF_WIFI_ONLY", "enqueue", "Lcom/muzk/app/download/Downloads$Enqueued;", "context", "Landroid/content/Context;", "track", "Lcom/muzk/app/data/RemoteTrack;", "tagFor", "pageUrl", "isOnUnmetered", "", "Enqueued", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class Downloads {
    public static final Downloads INSTANCE = new Downloads();
    public static final String PREF_WIFI_ONLY = "wifi_only";
    public static final String TAG = "muzk_download";

    private Downloads() {
    }

    /* JADX INFO: compiled from: Downloads.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/muzk/app/download/Downloads$Enqueued;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "WAITING_WIFI", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum Enqueued {
        STARTED,
        WAITING_WIFI;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Enqueued> getEntries() {
            return $ENTRIES;
        }
    }

    public final Enqueued enqueue(Context context, RemoteTrack track) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(track, "track");
        boolean wifiOnly = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_WIFI_ONLY, false);
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) DownloadWorker.class);
        Pair[] pairs$iv = {TuplesKt.to(DownloadWorker.KEY_URL, track.getPageUrl()), TuplesKt.to(DownloadWorker.KEY_TITLE, track.getTitle()), TuplesKt.to(DownloadWorker.KEY_NOTIFICATION_ID, Integer.valueOf(track.getPageUrl().hashCode() & Integer.MAX_VALUE))};
        Data.Builder dataBuilder$iv = new Data.Builder();
        for (Pair pair$iv : pairs$iv) {
            dataBuilder$iv.put((String) pair$iv.getFirst(), pair$iv.getSecond());
        }
        OneTimeWorkRequest request = builder.setInputData(dataBuilder$iv.build()).setConstraints(new Constraints.Builder().setRequiredNetworkType(wifiOnly ? NetworkType.UNMETERED : NetworkType.CONNECTED).build()).addTag(TAG).addTag(tagFor(track.getPageUrl())).build();
        WorkManager.INSTANCE.getInstance(context).enqueueUniqueWork(tagFor(track.getPageUrl()), ExistingWorkPolicy.KEEP, request);
        return (!wifiOnly || isOnUnmetered(context)) ? Enqueued.STARTED : Enqueued.WAITING_WIFI;
    }

    public final String tagFor(String pageUrl) {
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        return "dl_" + pageUrl.hashCode();
    }

    private final boolean isOnUnmetered(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
        NetworkCapabilities caps = cm.getNetworkCapabilities(cm.getActiveNetwork());
        if (caps == null) {
            return false;
        }
        return caps.hasCapability(11);
    }
}
