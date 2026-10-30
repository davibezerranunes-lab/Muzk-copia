package com.muzk.app.data;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.download.DownloadWorker;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LocalMusicRepository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/muzk/app/data/LocalMusicRepository;", "", "<init>", "()V", "loadTracks", "", "Lcom/muzk/app/data/LocalTrack;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LocalMusicRepository {
    public static final LocalMusicRepository INSTANCE = new LocalMusicRepository();

    private LocalMusicRepository() {
    }

    /* JADX INFO: renamed from: com.muzk.app.data.LocalMusicRepository$loadTracks$2, reason: invalid class name */
    /* JADX INFO: compiled from: LocalMusicRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/muzk/app/data/LocalTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.data.LocalMusicRepository$loadTracks$2", f = "LocalMusicRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<LocalTrack>>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LocalTrack>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:51:0x0134  */
        /* JADX WARN: Code duplicated, block: B:58:0x0147  */
        /* JADX WARN: Code duplicated, block: B:64:0x0156  */
        /* JADX WARN: Code duplicated, block: B:67:0x0160  */
        /* JADX WARN: Code duplicated, block: B:68:0x0163  */
        /* JADX WARN: Code duplicated, block: B:71:0x017c  */
        /* JADX WARN: Code duplicated, block: B:95:0x0181 A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            int relCol;
            boolean z;
            String folderPath;
            String string;
            String str;
            boolean z2;
            String str2;
            String string2;
            String str3;
            String strSubstringAfterLast$default;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Object $result = obj;
                    Uri collection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    Collection projection = CollectionsKt.mutableListOf("_id", DownloadWorker.KEY_TITLE, "artist", "album", TypedValues.TransitionType.S_DURATION, "date_added", "_data");
                    if (Build.VERSION.SDK_INT >= 29) {
                        projection.add("relative_path");
                    }
                    List tracks = new ArrayList();
                    Collection $this$toTypedArray$iv = projection;
                    Cursor cursorQuery = this.$context.getContentResolver().query(collection, (String[]) $this$toTypedArray$iv.toArray(new String[0]), "is_music != 0", null, "date_added DESC");
                    if (cursorQuery != null) {
                        Cursor cursor = cursorQuery;
                        try {
                            Cursor c = cursor;
                            int i = 0;
                            int idCol = c.getColumnIndexOrThrow("_id");
                            int titleCol = c.getColumnIndexOrThrow(DownloadWorker.KEY_TITLE);
                            int artistCol = c.getColumnIndexOrThrow("artist");
                            int albumCol = c.getColumnIndexOrThrow("album");
                            int durCol = c.getColumnIndexOrThrow(TypedValues.TransitionType.S_DURATION);
                            int dateCol = c.getColumnIndexOrThrow("date_added");
                            int dataCol = c.getColumnIndexOrThrow("_data");
                            if (Build.VERSION.SDK_INT >= 29) {
                                try {
                                    relCol = c.getColumnIndex("relative_path");
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(cursor, th);
                                        throw th3;
                                    }
                                }
                            } else {
                                relCol = -1;
                            }
                            while (c.moveToNext()) {
                                long id = c.getLong(idCol);
                                String string3 = relCol >= 0 ? c.getString(relCol) : null;
                                try {
                                    if (string3 != null) {
                                        z = false;
                                        folderPath = StringsKt.trimEnd(string3, '/');
                                        if (folderPath == null) {
                                        }
                                        String artist = c.getString(artistCol);
                                        List list = tracks;
                                        Object $result2 = $result;
                                        int i2 = i;
                                        int idCol2 = idCol;
                                        Uri uriWithAppendedId = ContentUris.withAppendedId(collection, id);
                                        Uri collection2 = collection;
                                        Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                                        string = c.getString(titleCol);
                                        if (string == null) {
                                            string = "Sem título";
                                        }
                                        String str4 = string;
                                        str = artist;
                                        if (str != null || StringsKt.isBlank(str)) {
                                            z2 = true;
                                        } else {
                                            z2 = z;
                                        }
                                        if (!z2 || Intrinsics.areEqual(artist, "<unknown>")) {
                                            str2 = "Artista desconhecido";
                                        } else {
                                            str2 = artist;
                                        }
                                        string2 = c.getString(albumCol);
                                        if (string2 == null) {
                                            str3 = "";
                                        } else {
                                            str3 = string2;
                                        }
                                        long j = c.getLong(durCol);
                                        int titleCol2 = titleCol;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(folderPath, '/', (String) null, 2, (Object) null);
                                        if (StringsKt.isBlank(strSubstringAfterLast$default)) {
                                            strSubstringAfterLast$default = "Raiz";
                                        }
                                        list.add(new LocalTrack(id, uriWithAppendedId, str4, str2, str3, j, folderPath, strSubstringAfterLast$default, c.getLong(dateCol)));
                                        titleCol = titleCol2;
                                        i = i2;
                                        idCol = idCol2;
                                        $result = $result2;
                                        collection = collection2;
                                    } else {
                                        z = false;
                                    }
                                    Uri uriWithAppendedId2 = ContentUris.withAppendedId(collection, id);
                                    Uri collection3 = collection;
                                    Intrinsics.checkNotNullExpressionValue(uriWithAppendedId2, "withAppendedId(...)");
                                    string = c.getString(titleCol);
                                    if (string == null) {
                                        string = "Sem título";
                                    }
                                    String str5 = string;
                                    str = artist;
                                    if (str != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        str2 = "Artista desconhecido";
                                    } else {
                                        str2 = "Artista desconhecido";
                                    }
                                    string2 = c.getString(albumCol);
                                    if (string2 == null) {
                                        str3 = "";
                                    } else {
                                        str3 = string2;
                                    }
                                    long j2 = c.getLong(durCol);
                                    int titleCol3 = titleCol;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(folderPath, '/', (String) null, 2, (Object) null);
                                    if (StringsKt.isBlank(strSubstringAfterLast$default)) {
                                        strSubstringAfterLast$default = "Raiz";
                                    }
                                    list.add(new LocalTrack(id, uriWithAppendedId2, str5, str2, str3, j2, folderPath, strSubstringAfterLast$default, c.getLong(dateCol)));
                                    titleCol = titleCol3;
                                    i = i2;
                                    idCol = idCol2;
                                    $result = $result2;
                                    collection = collection3;
                                } catch (Throwable th4) {
                                    th = th4;
                                    throw th;
                                }
                                String it = c.getString(dataCol);
                                String parent = it != null ? new File(it).getParent() : null;
                                folderPath = parent == null ? "" : parent;
                                String artist2 = c.getString(artistCol);
                                List list2 = tracks;
                                Object $result3 = $result;
                                int i3 = i;
                                int idCol3 = idCol;
                                break;
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(cursor, null);
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    return tracks;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object loadTracks(Context context, Continuation<? super List<LocalTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, null), continuation);
    }
}
