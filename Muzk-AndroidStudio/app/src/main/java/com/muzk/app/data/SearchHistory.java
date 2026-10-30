package com.muzk.app.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchHistory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/muzk/app/data/SearchHistory;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "_items", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", SearchHistory.KEY, "Lkotlinx/coroutines/flow/StateFlow;", "getItems", "()Lkotlinx/coroutines/flow/StateFlow;", "add", "", "query", "remove", "save", "list", "read", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchHistory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY = "items";
    private static final int MAX = 8;
    private static volatile SearchHistory instance;
    private final MutableStateFlow<List<String>> _items;
    private final StateFlow<List<String>> items;
    private final SharedPreferences prefs;

    public /* synthetic */ SearchHistory(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private SearchHistory(Context context) {
        this.prefs = context.getSharedPreferences("search_history", 0);
        this._items = StateFlowKt.MutableStateFlow(read());
        this.items = FlowKt.asStateFlow(this._items);
    }

    public final StateFlow<List<String>> getItems() {
        return this.items;
    }

    public final synchronized void add(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        String q = StringsKt.trim((CharSequence) query).toString();
        if (!(q.length() == 0) && !YtDlpRepository.INSTANCE.isUrl(q)) {
            List listListOf = CollectionsKt.listOf(q);
            Iterable $this$filterNot$iv = this._items.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterNot$iv) {
                String it = (String) element$iv$iv;
                if (!StringsKt.equals(it, q, true)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            save(CollectionsKt.plus((Collection) listListOf, (Iterable) CollectionsKt.take((List) destination$iv$iv, 7)));
        }
    }

    public final synchronized void remove(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        save(CollectionsKt.minus(this._items.getValue(), query));
    }

    private final void save(List<String> list) {
        this._items.setValue(list);
        SharedPreferences prefs = this.prefs;
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor editor$iv = prefs.edit();
        editor$iv.putString(KEY, new JSONArray((Collection) list).toString());
        editor$iv.apply();
    }

    private final List<String> read() {
        Object objM663constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            SearchHistory $this$read_u24lambda_u243 = this;
            JSONArray arr = new JSONArray($this$read_u24lambda_u243.prefs.getString(KEY, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
            Iterable $this$map$iv = RangesKt.until(0, arr.length());
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterator<Integer> it = $this$map$iv.iterator();
            while (it.hasNext()) {
                int item$iv$iv = ((IntIterator) it).nextInt();
                destination$iv$iv.add(arr.getString(item$iv$iv));
            }
            objM663constructorimpl = Result.m663constructorimpl((List) destination$iv$iv);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
        }
        List listEmptyList = CollectionsKt.emptyList();
        if (Result.m669isFailureimpl(objM663constructorimpl)) {
            objM663constructorimpl = listEmptyList;
        }
        return (List) objM663constructorimpl;
    }

    /* JADX INFO: compiled from: SearchHistory.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/muzk/app/data/SearchHistory$Companion;", "", "<init>", "()V", "KEY", "", "MAX", "", "instance", "Lcom/muzk/app/data/SearchHistory;", "get", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SearchHistory get(Context context) {
            SearchHistory it;
            Intrinsics.checkNotNullParameter(context, "context");
            SearchHistory searchHistory = SearchHistory.instance;
            if (searchHistory == null) {
                synchronized (this) {
                    it = SearchHistory.instance;
                    if (it == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        it = new SearchHistory(applicationContext, null);
                        Companion companion = SearchHistory.INSTANCE;
                        SearchHistory.instance = it;
                    }
                }
                return it;
            }
            return searchHistory;
        }
    }
}
