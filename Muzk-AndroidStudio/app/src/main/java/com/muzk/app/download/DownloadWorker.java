package com.muzk.app.download;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.muzk.app.MuzkApp;
import com.muzk.app.R;
import com.yausername.youtubedl_android.YoutubeDL;
import com.yausername.youtubedl_android.YoutubeDLRequest;
import com.yausername.youtubedl_android.YoutubeDLResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: compiled from: DownloadWorker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\tH\u0002J$\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\tH\u0003R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/muzk/app/download/DownloadWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", DownloadWorker.KEY_URL, "", DownloadWorker.KEY_TITLE, "notificationId", "", "processId", "lastNotified", "", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildRequest", "Lcom/yausername/youtubedl_android/YoutubeDLRequest;", "dir", "Ljava/io/File;", "format", "publishToMusic", "", "file", "foregroundInfo", "Landroidx/work/ForegroundInfo;", "progress", "text", "notifyDone", "name", "success", "", DownloadWorker.KEY_ERROR, "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DownloadWorker extends CoroutineWorker {
    public static final String FOLDER = "Muzk";
    public static final String FORMAT_MP3 = "mp3";
    public static final String KEY_ERROR = "error";
    public static final String KEY_NOTIFICATION_ID = "notification_id";
    public static final String KEY_PROGRESS = "progress";
    public static final String KEY_TITLE = "title";
    public static final String KEY_URL = "url";
    public static final String PREF_FORMAT = "audio_format";
    private long lastNotified;
    private final int notificationId;
    private final String processId;
    private final String title;
    private final String url;

    /* JADX INFO: renamed from: com.muzk.app.download.DownloadWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadWorker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.download.DownloadWorker", f = "DownloadWorker.kt", i = {}, l = {41}, m = "doWork", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        String string = getInputData().getString(KEY_URL);
        this.url = string == null ? "" : string;
        String string2 = getInputData().getString(KEY_TITLE);
        this.title = string2 != null ? string2 : "";
        this.notificationId = getInputData().getInt(KEY_NOTIFICATION_ID, this.url.hashCode());
        String string3 = getId().toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        this.processId = string3;
    }

    /* JADX INFO: renamed from: com.muzk.app.download.DownloadWorker$doWork$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadWorker.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.download.DownloadWorker$doWork$2", f = "DownloadWorker.kt", i = {1, 2}, l = {45, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m = "invokeSuspend", n = {"workDir", "workDir"}, s = {"L$0", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = DownloadWorker.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:110:0x0167 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:47:0x00e9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:53:0x0112 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:54:0x0113  */
        /* JADX WARN: Code duplicated, block: B:58:0x011e A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:60:0x012b A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:62:0x0164 A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:66:0x0182  */
        /* JADX WARN: Code duplicated, block: B:67:0x0184 A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:69:0x018f  */
        /* JADX WARN: Code duplicated, block: B:70:0x0190 A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:73:0x01aa  */
        /* JADX WARN: Code duplicated, block: B:78:0x01b7 A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:80:0x01dc A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        /* JADX WARN: Code duplicated, block: B:83:0x01f4 A[Catch: all -> 0x0026, Exception -> 0x0029, CanceledException -> 0x002c, CancellationException -> 0x002f, LOOP:1: B:82:0x01f2->B:83:0x01f4, LOOP_END, TryCatch #4 {all -> 0x0026, blocks: (B:7:0x0021, B:56:0x0117, B:58:0x011e, B:60:0x012b, B:62:0x0164, B:63:0x0167, B:64:0x016d, B:76:0x01b3, B:78:0x01b7, B:80:0x01dc, B:81:0x01e3, B:83:0x01f4, B:84:0x0207, B:67:0x0184, B:70:0x0190, B:71:0x0199, B:74:0x01ac, B:85:0x0210, B:86:0x021b, B:87:0x021c, B:89:0x022e, B:90:0x0234, B:93:0x0249, B:95:0x0259, B:96:0x026c, B:97:0x0275, B:101:0x028b), top: B:104:0x000f }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            File workDir;
            final File workDir2;
            Object $result2;
            final String format;
            final DownloadWorker downloadWorker;
            ListenableWorker.Result resultFailure;
            File[] fileArrListFiles;
            Collection destination$iv$iv;
            int length;
            int i;
            Iterator iterator$iv;
            Object maxElem$iv;
            long maxValue$iv;
            Object e$iv;
            long v$iv;
            File audio;
            Pair[] pairs$iv;
            String nameWithoutExtension;
            Data.Builder dataBuilder$iv;
            int i2;
            File file;
            Set of;
            String lowerCase;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            char c = 3;
            char c2 = 2;
            try {
                try {
                    try {
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                $result2 = $result;
                                if (StringsKt.isBlank(DownloadWorker.this.url)) {
                                    return ListenableWorker.Result.failure();
                                }
                                DownloadWorker downloadWorker2 = DownloadWorker.this;
                                Result.Companion companion = Result.INSTANCE;
                                String string = downloadWorker2.getApplicationContext().getString(R.string.dl_preparing);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                ForegroundInfo foregroundInfo = downloadWorker2.foregroundInfo(-1, string);
                                this.label = 1;
                                if (downloadWorker2.setForeground(foregroundInfo, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Result.m663constructorimpl(Unit.INSTANCE);
                                workDir2 = new File(DownloadWorker.this.getApplicationContext().getCacheDir(), "downloads/" + DownloadWorker.this.processId);
                                workDir2.mkdirs();
                                this.L$0 = workDir2;
                                this.label = 2;
                                if (MuzkApp.INSTANCE.getYtdlReady().await(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                format = PreferenceManager.getDefaultSharedPreferences(DownloadWorker.this.getApplicationContext()).getString(DownloadWorker.PREF_FORMAT, DownloadWorker.FORMAT_MP3);
                                if (format == null) {
                                    format = DownloadWorker.FORMAT_MP3;
                                }
                                downloadWorker = DownloadWorker.this;
                                this.L$0 = workDir2;
                                this.label = 3;
                                if (InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: com.muzk.app.download.DownloadWorker$doWork$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return DownloadWorker.AnonymousClass2.invokeSuspend$lambda$3(downloadWorker, workDir2, format);
                                    }
                                }, this, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                workDir = workDir2;
                                fileArrListFiles = workDir.listFiles();
                                if (fileArrListFiles != null) {
                                    destination$iv$iv = new ArrayList();
                                    length = fileArrListFiles.length;
                                    i = 0;
                                    while (i < length) {
                                        file = fileArrListFiles[i];
                                        String[] strArr = new String[5];
                                        strArr[0] = DownloadWorker.FORMAT_MP3;
                                        strArr[1] = "m4a";
                                        strArr[c2] = "opus";
                                        strArr[c] = "ogg";
                                        strArr[4] = "webm";
                                        of = SetsKt.setOf((Object[]) strArr);
                                        Intrinsics.checkNotNull(file);
                                        lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        if (of.contains(lowerCase)) {
                                            destination$iv$iv.add(file);
                                        }
                                        i++;
                                        c = 3;
                                        c2 = 2;
                                    }
                                    Iterable $this$maxByOrNull$iv = (List) destination$iv$iv;
                                    iterator$iv = $this$maxByOrNull$iv.iterator();
                                    if (iterator$iv.hasNext()) {
                                        maxElem$iv = iterator$iv.next();
                                        if (!iterator$iv.hasNext()) {
                                            File it = (File) maxElem$iv;
                                            maxValue$iv = it.length();
                                            do {
                                                e$iv = iterator$iv.next();
                                                File it2 = (File) e$iv;
                                                v$iv = it2.length();
                                                if (maxValue$iv < v$iv) {
                                                    maxElem$iv = e$iv;
                                                    maxValue$iv = v$iv;
                                                }
                                            } while (iterator$iv.hasNext());
                                        }
                                    } else {
                                        maxElem$iv = null;
                                    }
                                    audio = (File) maxElem$iv;
                                    if (audio != null) {
                                        DownloadWorker.this.publishToMusic(audio);
                                        DownloadWorker.notifyDone$default(DownloadWorker.this, FilesKt.getNameWithoutExtension(audio), true, null, 4, null);
                                        pairs$iv = new Pair[1];
                                        nameWithoutExtension = DownloadWorker.this.title;
                                        if (StringsKt.isBlank(nameWithoutExtension)) {
                                            nameWithoutExtension = FilesKt.getNameWithoutExtension(audio);
                                        }
                                        pairs$iv[0] = TuplesKt.to(DownloadWorker.KEY_TITLE, nameWithoutExtension);
                                        dataBuilder$iv = new Data.Builder();
                                        for (Pair pair$iv : pairs$iv) {
                                            dataBuilder$iv.put((String) pair$iv.getFirst(), pair$iv.getSecond());
                                        }
                                        resultFailure = ListenableWorker.Result.success(dataBuilder$iv.build());
                                        YoutubeDL.getInstance().destroyProcessById(DownloadWorker.this.processId);
                                        FilesKt.deleteRecursively(workDir);
                                        return resultFailure;
                                    }
                                }
                                throw new IllegalStateException("Arquivo de áudio não encontrado após o download".toString());
                            case 1:
                                $result2 = $result;
                                ResultKt.throwOnFailure($result2);
                                Result.m663constructorimpl(Unit.INSTANCE);
                                workDir2 = new File(DownloadWorker.this.getApplicationContext().getCacheDir(), "downloads/" + DownloadWorker.this.processId);
                                workDir2.mkdirs();
                                this.L$0 = workDir2;
                                this.label = 2;
                                if (MuzkApp.INSTANCE.getYtdlReady().await(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                format = PreferenceManager.getDefaultSharedPreferences(DownloadWorker.this.getApplicationContext()).getString(DownloadWorker.PREF_FORMAT, DownloadWorker.FORMAT_MP3);
                                if (format == null) {
                                    format = DownloadWorker.FORMAT_MP3;
                                }
                                downloadWorker = DownloadWorker.this;
                                this.L$0 = workDir2;
                                this.label = 3;
                                if (InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: com.muzk.app.download.DownloadWorker$doWork$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return DownloadWorker.AnonymousClass2.invokeSuspend$lambda$3(downloadWorker, workDir2, format);
                                    }
                                }, this, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                workDir = workDir2;
                                fileArrListFiles = workDir.listFiles();
                                if (fileArrListFiles != null) {
                                    destination$iv$iv = new ArrayList();
                                    length = fileArrListFiles.length;
                                    i = 0;
                                    while (i < length) {
                                        file = fileArrListFiles[i];
                                        String[] strArr2 = new String[5];
                                        strArr2[0] = DownloadWorker.FORMAT_MP3;
                                        strArr2[1] = "m4a";
                                        strArr2[c2] = "opus";
                                        strArr2[c] = "ogg";
                                        strArr2[4] = "webm";
                                        of = SetsKt.setOf((Object[]) strArr2);
                                        Intrinsics.checkNotNull(file);
                                        lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        if (of.contains(lowerCase)) {
                                            destination$iv$iv.add(file);
                                        }
                                        i++;
                                        c = 3;
                                        c2 = 2;
                                    }
                                    Iterable $this$maxByOrNull$iv2 = (List) destination$iv$iv;
                                    iterator$iv = $this$maxByOrNull$iv2.iterator();
                                    if (iterator$iv.hasNext()) {
                                        maxElem$iv = null;
                                    } else {
                                        maxElem$iv = iterator$iv.next();
                                        if (!iterator$iv.hasNext()) {
                                            File it3 = (File) maxElem$iv;
                                            maxValue$iv = it3.length();
                                            do {
                                                e$iv = iterator$iv.next();
                                                File it4 = (File) e$iv;
                                                v$iv = it4.length();
                                                if (maxValue$iv < v$iv) {
                                                    maxElem$iv = e$iv;
                                                    maxValue$iv = v$iv;
                                                }
                                            } while (iterator$iv.hasNext());
                                        }
                                    }
                                    audio = (File) maxElem$iv;
                                    if (audio != null) {
                                        DownloadWorker.this.publishToMusic(audio);
                                        DownloadWorker.notifyDone$default(DownloadWorker.this, FilesKt.getNameWithoutExtension(audio), true, null, 4, null);
                                        pairs$iv = new Pair[1];
                                        nameWithoutExtension = DownloadWorker.this.title;
                                        if (StringsKt.isBlank(nameWithoutExtension)) {
                                            nameWithoutExtension = FilesKt.getNameWithoutExtension(audio);
                                        }
                                        pairs$iv[0] = TuplesKt.to(DownloadWorker.KEY_TITLE, nameWithoutExtension);
                                        dataBuilder$iv = new Data.Builder();
                                        while (i2 < r5) {
                                            dataBuilder$iv.put((String) pair$iv.getFirst(), pair$iv.getSecond());
                                        }
                                        resultFailure = ListenableWorker.Result.success(dataBuilder$iv.build());
                                        YoutubeDL.getInstance().destroyProcessById(DownloadWorker.this.processId);
                                        FilesKt.deleteRecursively(workDir);
                                        return resultFailure;
                                    }
                                }
                                throw new IllegalStateException("Arquivo de áudio não encontrado após o download".toString());
                            case 2:
                                $result2 = $result;
                                workDir2 = (File) this.L$0;
                                ResultKt.throwOnFailure($result2);
                                format = PreferenceManager.getDefaultSharedPreferences(DownloadWorker.this.getApplicationContext()).getString(DownloadWorker.PREF_FORMAT, DownloadWorker.FORMAT_MP3);
                                if (format == null) {
                                    format = DownloadWorker.FORMAT_MP3;
                                }
                                downloadWorker = DownloadWorker.this;
                                this.L$0 = workDir2;
                                this.label = 3;
                                if (InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: com.muzk.app.download.DownloadWorker$doWork$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return DownloadWorker.AnonymousClass2.invokeSuspend$lambda$3(downloadWorker, workDir2, format);
                                    }
                                }, this, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                workDir = workDir2;
                                fileArrListFiles = workDir.listFiles();
                                if (fileArrListFiles != null) {
                                    destination$iv$iv = new ArrayList();
                                    length = fileArrListFiles.length;
                                    i = 0;
                                    while (i < length) {
                                        file = fileArrListFiles[i];
                                        String[] strArr3 = new String[5];
                                        strArr3[0] = DownloadWorker.FORMAT_MP3;
                                        strArr3[1] = "m4a";
                                        strArr3[c2] = "opus";
                                        strArr3[c] = "ogg";
                                        strArr3[4] = "webm";
                                        of = SetsKt.setOf((Object[]) strArr3);
                                        Intrinsics.checkNotNull(file);
                                        lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        if (of.contains(lowerCase)) {
                                            destination$iv$iv.add(file);
                                        }
                                        i++;
                                        c = 3;
                                        c2 = 2;
                                    }
                                    Iterable $this$maxByOrNull$iv3 = (List) destination$iv$iv;
                                    iterator$iv = $this$maxByOrNull$iv3.iterator();
                                    if (iterator$iv.hasNext()) {
                                        maxElem$iv = null;
                                    } else {
                                        maxElem$iv = iterator$iv.next();
                                        if (!iterator$iv.hasNext()) {
                                            File it5 = (File) maxElem$iv;
                                            maxValue$iv = it5.length();
                                            do {
                                                e$iv = iterator$iv.next();
                                                File it6 = (File) e$iv;
                                                v$iv = it6.length();
                                                if (maxValue$iv < v$iv) {
                                                    maxElem$iv = e$iv;
                                                    maxValue$iv = v$iv;
                                                }
                                            } while (iterator$iv.hasNext());
                                        }
                                    }
                                    audio = (File) maxElem$iv;
                                    if (audio != null) {
                                        DownloadWorker.this.publishToMusic(audio);
                                        DownloadWorker.notifyDone$default(DownloadWorker.this, FilesKt.getNameWithoutExtension(audio), true, null, 4, null);
                                        pairs$iv = new Pair[1];
                                        nameWithoutExtension = DownloadWorker.this.title;
                                        if (StringsKt.isBlank(nameWithoutExtension)) {
                                            nameWithoutExtension = FilesKt.getNameWithoutExtension(audio);
                                        }
                                        pairs$iv[0] = TuplesKt.to(DownloadWorker.KEY_TITLE, nameWithoutExtension);
                                        dataBuilder$iv = new Data.Builder();
                                        while (i2 < r5) {
                                            dataBuilder$iv.put((String) pair$iv.getFirst(), pair$iv.getSecond());
                                        }
                                        resultFailure = ListenableWorker.Result.success(dataBuilder$iv.build());
                                        YoutubeDL.getInstance().destroyProcessById(DownloadWorker.this.processId);
                                        FilesKt.deleteRecursively(workDir);
                                        return resultFailure;
                                    }
                                }
                                throw new IllegalStateException("Arquivo de áudio não encontrado após o download".toString());
                            case 3:
                                workDir = (File) this.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    fileArrListFiles = workDir.listFiles();
                                    if (fileArrListFiles != null) {
                                        destination$iv$iv = new ArrayList();
                                        length = fileArrListFiles.length;
                                        i = 0;
                                        while (i < length) {
                                            file = fileArrListFiles[i];
                                            String[] strArr4 = new String[5];
                                            strArr4[0] = DownloadWorker.FORMAT_MP3;
                                            strArr4[1] = "m4a";
                                            strArr4[c2] = "opus";
                                            strArr4[c] = "ogg";
                                            strArr4[4] = "webm";
                                            of = SetsKt.setOf((Object[]) strArr4);
                                            Intrinsics.checkNotNull(file);
                                            lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                            if (of.contains(lowerCase)) {
                                                destination$iv$iv.add(file);
                                            }
                                            i++;
                                            c = 3;
                                            c2 = 2;
                                        }
                                        Iterable $this$maxByOrNull$iv4 = (List) destination$iv$iv;
                                        iterator$iv = $this$maxByOrNull$iv4.iterator();
                                        if (iterator$iv.hasNext()) {
                                            maxElem$iv = null;
                                        } else {
                                            maxElem$iv = iterator$iv.next();
                                            if (!iterator$iv.hasNext()) {
                                                File it7 = (File) maxElem$iv;
                                                maxValue$iv = it7.length();
                                                do {
                                                    e$iv = iterator$iv.next();
                                                    File it8 = (File) e$iv;
                                                    v$iv = it8.length();
                                                    if (maxValue$iv < v$iv) {
                                                        maxElem$iv = e$iv;
                                                        maxValue$iv = v$iv;
                                                    }
                                                } while (iterator$iv.hasNext());
                                            }
                                        }
                                        audio = (File) maxElem$iv;
                                        if (audio != null) {
                                            DownloadWorker.this.publishToMusic(audio);
                                            DownloadWorker.notifyDone$default(DownloadWorker.this, FilesKt.getNameWithoutExtension(audio), true, null, 4, null);
                                            pairs$iv = new Pair[1];
                                            nameWithoutExtension = DownloadWorker.this.title;
                                            if (StringsKt.isBlank(nameWithoutExtension)) {
                                                nameWithoutExtension = FilesKt.getNameWithoutExtension(audio);
                                            }
                                            pairs$iv[0] = TuplesKt.to(DownloadWorker.KEY_TITLE, nameWithoutExtension);
                                            dataBuilder$iv = new Data.Builder();
                                            while (i2 < r5) {
                                                dataBuilder$iv.put((String) pair$iv.getFirst(), pair$iv.getSecond());
                                            }
                                            resultFailure = ListenableWorker.Result.success(dataBuilder$iv.build());
                                            YoutubeDL.getInstance().destroyProcessById(DownloadWorker.this.processId);
                                            FilesKt.deleteRecursively(workDir);
                                            return resultFailure;
                                        }
                                    }
                                    throw new IllegalStateException("Arquivo de áudio não encontrado após o download".toString());
                                } catch (YoutubeDL.CanceledException e) {
                                    resultFailure = ListenableWorker.Result.failure();
                                } catch (CancellationException e2) {
                                    throw e2;
                                } catch (Exception e3) {
                                    e = e3;
                                    DownloadWorker downloadWorker3 = DownloadWorker.this;
                                    String str = DownloadWorker.this.title;
                                    DownloadWorker downloadWorker4 = DownloadWorker.this;
                                    if (StringsKt.isBlank(str)) {
                                        str = downloadWorker4.url;
                                    }
                                    downloadWorker3.notifyDone(str, false, e.getMessage());
                                    Pair[] pairs$iv2 = new Pair[1];
                                    String message = e.getMessage();
                                    if (message == null) {
                                        message = "erro";
                                    }
                                    pairs$iv2[0] = TuplesKt.to(DownloadWorker.KEY_ERROR, message);
                                    Data.Builder dataBuilder$iv2 = new Data.Builder();
                                    for (Pair pair$iv2 : pairs$iv2) {
                                        dataBuilder$iv2.put((String) pair$iv2.getFirst(), pair$iv2.getSecond());
                                    }
                                    resultFailure = ListenableWorker.Result.failure(dataBuilder$iv2.build());
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Throwable th) {
                        e = th;
                        YoutubeDL.getInstance().destroyProcessById(DownloadWorker.this.processId);
                        FilesKt.deleteRecursively(workDir);
                        throw e;
                    }
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m663constructorimpl(ResultKt.createFailure(th2));
                }
            } catch (YoutubeDL.CanceledException e4) {
                workDir = workDir2;
            } catch (CancellationException e5) {
                throw e5;
            } catch (Exception e6) {
                e = e6;
                workDir = workDir2;
            } catch (Throwable th3) {
                e = th3;
                File workDir3 = workDir2;
                YoutubeDL.getInstance().destroyProcessById(DownloadWorker.this.processId);
                FilesKt.deleteRecursively(workDir3);
                throw e;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final YoutubeDLResponse invokeSuspend$lambda$3(final DownloadWorker this$0, File $workDir, String $format) {
            return YoutubeDL.getInstance().execute(this$0.buildRequest($workDir, $format), this$0.processId, new Function3() { // from class: com.muzk.app.download.DownloadWorker$doWork$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DownloadWorker.AnonymousClass2.invokeSuspend$lambda$3$lambda$2(this$0, ((Float) obj).floatValue(), ((Long) obj2).longValue(), (String) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$3$lambda$2(DownloadWorker this$0, float progress, long j, String str) {
            int pct = RangesKt.coerceIn((int) progress, 0, 100);
            Pair[] pairs$iv = {TuplesKt.to("progress", Integer.valueOf(pct))};
            Data.Builder dataBuilder$iv = new Data.Builder();
            for (Pair pair$iv : pairs$iv) {
                dataBuilder$iv.put((String) pair$iv.getFirst(), pair$iv.getSecond());
            }
            this$0.setProgressAsync(dataBuilder$iv.build());
            long now = System.currentTimeMillis();
            if (now - this$0.lastNotified > 700) {
                this$0.lastNotified = now;
                this$0.setForegroundAsync(this$0.foregroundInfo(pct, pct + "%"));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objWithContext;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineDispatcher io = Dispatchers.getIO();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(io, anonymousClass2, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNullExpressionValue(objWithContext, "withContext(...)");
        return objWithContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YoutubeDLRequest buildRequest(File dir, String format) {
        YoutubeDLRequest $this$buildRequest_u24lambda_u240 = new YoutubeDLRequest(this.url);
        $this$buildRequest_u24lambda_u240.addOption("--no-playlist");
        $this$buildRequest_u24lambda_u240.addOption("--no-mtime");
        $this$buildRequest_u24lambda_u240.addOption("--no-warnings");
        $this$buildRequest_u24lambda_u240.addOption("-f", "bestaudio/best");
        $this$buildRequest_u24lambda_u240.addOption("-x");
        if (Intrinsics.areEqual(format, FORMAT_MP3)) {
            $this$buildRequest_u24lambda_u240.addOption("--audio-format", FORMAT_MP3);
            $this$buildRequest_u24lambda_u240.addOption("--audio-quality", "320K");
        } else {
            $this$buildRequest_u24lambda_u240.addOption("--audio-format", "m4a");
            $this$buildRequest_u24lambda_u240.addOption("--audio-quality", "0");
        }
        $this$buildRequest_u24lambda_u240.addOption("--embed-thumbnail");
        $this$buildRequest_u24lambda_u240.addOption("--convert-thumbnails", "jpg");
        $this$buildRequest_u24lambda_u240.addOption("--ppa", "ThumbnailsConvertor:-qmin 1 -q:v 1 -vf crop=\"'if(gt(ih,iw),iw,ih)':'if(gt(iw,ih),ih,iw)'\"");
        $this$buildRequest_u24lambda_u240.addOption("--embed-metadata");
        $this$buildRequest_u24lambda_u240.addOption("--parse-metadata", "%(artist,creator,uploader,channel)s:%(meta_artist)s");
        $this$buildRequest_u24lambda_u240.addOption("--parse-metadata", "%(track,title)s:%(meta_title)s");
        $this$buildRequest_u24lambda_u240.addOption("-o", dir.getAbsolutePath() + "/%(track,title)s.%(ext)s");
        $this$buildRequest_u24lambda_u240.addOption("--windows-filenames");
        return $this$buildRequest_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    public final void publishToMusic(File file) throws Exception {
        String str;
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase) {
            case "m4a":
                str = MimeTypes.AUDIO_MP4;
                break;
            case "mp3":
                str = MimeTypes.AUDIO_MPEG;
                break;
            case "ogg":
            case "opus":
                str = MimeTypes.AUDIO_OGG;
                break;
            default:
                str = "audio/*";
                break;
        }
        String mime = str;
        if (Build.VERSION.SDK_INT < 29) {
            File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), FOLDER);
            dir.mkdirs();
            File target = new File(dir, file.getName());
            int n = 1;
            while (target.exists()) {
                File file2 = new File(dir, FilesKt.getNameWithoutExtension(file) + " (" + n + ")." + FilesKt.getExtension(file));
                n++;
                target = file2;
            }
            FilesKt.copyTo$default(file, target, false, 0, 6, null);
            MediaScannerConnection.scanFile(getApplicationContext(), new String[]{target.getAbsolutePath()}, new String[]{mime}, null);
            return;
        }
        ContentResolver resolver = getApplicationContext().getContentResolver();
        ContentValues $this$publishToMusic_u24lambda_u241 = new ContentValues();
        $this$publishToMusic_u24lambda_u241.put("_display_name", file.getName());
        $this$publishToMusic_u24lambda_u241.put("mime_type", mime);
        $this$publishToMusic_u24lambda_u241.put("relative_path", Environment.DIRECTORY_MUSIC + "/Muzk");
        $this$publishToMusic_u24lambda_u241.put("is_music", (Integer) 1);
        $this$publishToMusic_u24lambda_u241.put("is_pending", (Integer) 1);
        Uri collection = MediaStore.Audio.Media.getContentUri("external_primary");
        Uri uri = resolver.insert(collection, $this$publishToMusic_u24lambda_u241);
        if (uri == null) {
            throw new IllegalStateException("Não consegui criar o arquivo em Música".toString());
        }
        try {
            OutputStream outputStreamOpenOutputStream = resolver.openOutputStream(uri);
            try {
                if (outputStreamOpenOutputStream == null) {
                    throw new IllegalStateException("Não consegui gravar em Música".toString());
                }
                OutputStream outputStream = outputStreamOpenOutputStream;
                try {
                    OutputStream out = outputStream;
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            FileInputStream it = fileInputStream;
                            ByteStreamsKt.copyTo$default(it, out, 0, 2, null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            CloseableKt.closeFinally(outputStream, null);
                            $this$publishToMusic_u24lambda_u241.clear();
                            $this$publishToMusic_u24lambda_u241.put("is_pending", (Integer) 0);
                            resolver.update(uri, $this$publishToMusic_u24lambda_u241, null, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(fileInputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        Throwable th4 = th;
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(outputStream, th4);
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e) {
                e = e;
                resolver.delete(uri, null, null);
                throw e;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ForegroundInfo foregroundInfo(int progress, String text) {
        boolean z;
        WorkManager.Companion companion = WorkManager.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        WorkManager companion2 = companion.getInstance(applicationContext);
        UUID id = getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        PendingIntent cancel = companion2.createCancelPendingIntent(id);
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(getApplicationContext(), MuzkApp.CHANNEL_DOWNLOADS).setSmallIcon(R.drawable.ic_download);
        String str = this.title;
        if (StringsKt.isBlank(str)) {
            String string = getApplicationContext().getString(R.string.dl_downloading);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        }
        NotificationCompat.Builder ongoing = smallIcon.setContentTitle(str).setContentText(text).setOnlyAlertOnce(true).setOngoing(true);
        int iCoerceAtLeast = RangesKt.coerceAtLeast(progress, 0);
        if (progress < 0) {
            z = true;
        } else {
            z = false;
        }
        Notification notification = ongoing.setProgress(100, iCoerceAtLeast, z).addAction(0, getApplicationContext().getString(R.string.cancel), cancel).build();
        Intrinsics.checkNotNullExpressionValue(notification, "build(...)");
        if (Build.VERSION.SDK_INT >= 29) {
            return new ForegroundInfo(this.notificationId, notification, 1);
        }
        return new ForegroundInfo(this.notificationId, notification);
    }

    static /* synthetic */ void notifyDone$default(DownloadWorker downloadWorker, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        downloadWorker.notifyDone(str, z, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyDone(String name, boolean success, String error) {
        String str;
        Context ctx = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(ctx, "getApplicationContext(...)");
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(ctx, MuzkApp.CHANNEL_DOWNLOADS).setSmallIcon(success ? R.drawable.ic_check : R.drawable.ic_error).setContentTitle(ctx.getString(success ? R.string.dl_done : R.string.dl_failed));
        if (success) {
            str = name;
        } else {
            str = name + ": " + StringsKt.take(error == null ? "" : error, 120);
        }
        Notification notification = contentTitle.setContentText(str).setAutoCancel(true).build();
        Intrinsics.checkNotNullExpressionValue(notification, "build(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            DownloadWorker $this$notifyDone_u24lambda_u246 = this;
            NotificationManagerCompat.from(ctx).notify($this$notifyDone_u24lambda_u246.notificationId + 1, notification);
            Result.m663constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m663constructorimpl(ResultKt.createFailure(th));
        }
    }
}
