package com.muzk.app.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.muzk.app.MuzkApp;
import com.muzk.app.download.DownloadWorker;
import com.yausername.youtubedl_android.YoutubeDL;
import com.yausername.youtubedl_android.YoutubeDLRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: YtDlpRepository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u000b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/muzk/app/data/YtDlpRepository;", "", "<init>", "()V", "ytdl", "Lcom/yausername/youtubedl_android/YoutubeDL;", "getYtdl", "()Lcom/yausername/youtubedl_android/YoutubeDL;", "isUrl", "", "text", "", "search", "", "Lcom/muzk/app/data/RemoteTrack;", "query", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "streamUrl", "pageUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "str", "Lorg/json/JSONObject;", "key", "parse", "o", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class YtDlpRepository {
    public static final YtDlpRepository INSTANCE = new YtDlpRepository();

    private YtDlpRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YoutubeDL getYtdl() {
        return YoutubeDL.getInstance();
    }

    public final boolean isUrl(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return StringsKt.startsWith$default(text, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(text, "https://", false, 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.muzk.app.data.YtDlpRepository$search$2, reason: invalid class name */
    /* JADX INFO: compiled from: YtDlpRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/muzk/app/data/RemoteTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.data.YtDlpRepository$search$2", f = "YtDlpRepository.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends RemoteTrack>>, Object> {
        final /* synthetic */ int $limit;
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$query = str;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$query, this.$limit, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends RemoteTrack>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<RemoteTrack>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<RemoteTrack>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            String target;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (MuzkApp.INSTANCE.getYtdlReady().await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (YtDlpRepository.INSTANCE.isUrl(this.$query)) {
                target = this.$query;
            } else {
                target = "ytsearch" + this.$limit + ":" + this.$query;
            }
            YoutubeDLRequest $this$invokeSuspend_u24lambda_u240 = new YoutubeDLRequest(target);
            $this$invokeSuspend_u24lambda_u240.addOption("--dump-single-json");
            $this$invokeSuspend_u24lambda_u240.addOption("--flat-playlist");
            $this$invokeSuspend_u24lambda_u240.addOption("--no-warnings");
            JSONObject json = new JSONObject(YtDlpRepository.INSTANCE.getYtdl().execute($this$invokeSuspend_u24lambda_u240, (String) null, (Function3<? super Float, ? super Long, ? super String, Unit>) null).getOut());
            JSONArray entries = json.optJSONArray("entries");
            if (entries == null) {
                return CollectionsKt.listOfNotNull(YtDlpRepository.INSTANCE.parse(json));
            }
            Iterable $this$forEach$iv$iv$iv = RangesKt.until(0, entries.length());
            Collection destination$iv$iv = new ArrayList();
            Iterator<Integer> it = $this$forEach$iv$iv$iv.iterator();
            while (it.hasNext()) {
                int i = ((IntIterator) it).nextInt();
                JSONObject p0 = entries.optJSONObject(i);
                RemoteTrack remoteTrack = p0 != null ? YtDlpRepository.INSTANCE.parse(p0) : null;
                if (remoteTrack != null) {
                    destination$iv$iv.add(remoteTrack);
                }
            }
            return (List) destination$iv$iv;
        }
    }

    public static /* synthetic */ Object search$default(YtDlpRepository ytDlpRepository, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return ytDlpRepository.search(str, i, continuation);
    }

    public final Object search(String query, int limit, Continuation<? super List<RemoteTrack>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(query, limit, null), continuation);
    }

    /* JADX INFO: renamed from: com.muzk.app.data.YtDlpRepository$streamUrl$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: YtDlpRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.data.YtDlpRepository$streamUrl$2", f = "YtDlpRepository.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    static final class C01122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $pageUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01122(String str, Continuation<? super C01122> continuation) {
            super(2, continuation);
            this.$pageUrl = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01122(this.$pageUrl, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((C01122) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x008e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x008f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (MuzkApp.INSTANCE.getYtdlReady().await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            YoutubeDLRequest request = new YoutubeDLRequest(this.$pageUrl);
            request.addOption("-f", "bestaudio[ext=m4a]/bestaudio/best");
            request.addOption("--get-url");
            request.addOption("--no-playlist");
            request.addOption("--no-warnings");
            Object obj = null;
            Sequence $this$firstOrNull$iv = SequencesKt.map(StringsKt.lineSequence(YtDlpRepository.INSTANCE.getYtdl().execute(request, (String) null, (Function3<? super Float, ? super Long, ? super String, Unit>) null).getOut()), new Function1() { // from class: com.muzk.app.data.YtDlpRepository$streamUrl$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return YtDlpRepository.C01122.invokeSuspend$lambda$1((String) obj2);
                }
            });
            for (Object element$iv : $this$firstOrNull$iv) {
                String it = (String) element$iv;
                if (StringsKt.startsWith$default(it, "http", false, 2, (Object) null)) {
                    obj = element$iv;
                    str = (String) obj;
                    if (str != null) {
                        throw new IllegalStateException("O yt-dlp não devolveu uma URL de áudio".toString());
                    }
                    return str;
                }
            }
            str = (String) obj;
            if (str != null) {
                throw new IllegalStateException("O yt-dlp não devolveu uma URL de áudio".toString());
            }
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(String it) {
            return StringsKt.trim((CharSequence) it).toString();
        }
    }

    public final Object streamUrl(String pageUrl, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01122(pageUrl, null), continuation);
    }

    private final String str(JSONObject $this$str, String key) {
        if ($this$str.isNull(key)) {
            return "";
        }
        String strOptString = $this$str.optString(key);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        return StringsKt.trim((CharSequence) strOptString).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteTrack parse(JSONObject o) {
        Object element$iv;
        String thumb;
        JSONObject jSONObjectOptJSONObject;
        String str = str(o, TtmlNode.ATTR_ID);
        if (StringsKt.isBlank(str)) {
            return null;
        }
        String id = str;
        String str2 = str(o, "ie_key");
        if (StringsKt.isBlank(str2)) {
            str2 = INSTANCE.str(o, "extractor_key");
        }
        String extractor = str2;
        boolean isYoutube = StringsKt.contains((CharSequence) extractor, (CharSequence) "youtube", true) || (StringsKt.isBlank(extractor) && id.length() == 11);
        String str3 = str(o, "webpage_url");
        if (StringsKt.isBlank(str3)) {
            String it = INSTANCE.str(o, DownloadWorker.KEY_URL);
            if (!StringsKt.startsWith$default(it, "http", false, 2, (Object) null)) {
                it = null;
            }
            if (it != null) {
                str3 = it;
            } else {
                if (!isYoutube) {
                    return null;
                }
                str3 = "https://www.youtube.com/watch?v=" + id;
            }
        }
        String pageUrl = str3;
        String str4 = str(o, "track");
        if (StringsKt.isBlank(str4)) {
            str4 = INSTANCE.str(o, DownloadWorker.KEY_TITLE);
        }
        String str5 = str4;
        if (StringsKt.isBlank(str5)) {
            return null;
        }
        String title = str5;
        Iterable $this$map$iv = CollectionsKt.listOf((Object[]) new String[]{"artist", "creator", "channel", "uploader"});
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(INSTANCE.str(o, (String) item$iv$iv));
        }
        Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
        } while (StringsKt.isBlank((String) element$iv));
        String str6 = (String) element$iv;
        String artist = str6 == null ? "" : str6;
        if (isYoutube) {
            thumb = "https://i.ytimg.com/vi/" + id + "/hqdefault.jpg";
        } else if (StringsKt.isBlank(str(o, "thumbnail"))) {
            JSONArray arr = o.optJSONArray("thumbnails");
            thumb = arr != null ? (arr.length() <= 0 || (jSONObjectOptJSONObject = arr.optJSONObject(arr.length() - 1)) == null) ? null : INSTANCE.str(jSONObjectOptJSONObject, DownloadWorker.KEY_URL) : null;
        } else {
            thumb = str(o, "thumbnail");
        }
        double it3 = o.optDouble(TypedValues.TransitionType.S_DURATION, 0.0d);
        return new RemoteTrack(id, pageUrl, title, artist, thumb, Double.isNaN(it3) ? 0L : (long) it3);
    }
}
