package com.muzk.app.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.muzk.app.R;
import com.muzk.app.data.ModelsKt;
import com.muzk.app.data.RemoteTrack;
import com.muzk.app.databinding.ItemRemoteTrackBinding;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/muzk/app/ui/search/SearchAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/muzk/app/data/RemoteTrack;", "Lcom/muzk/app/ui/search/SearchAdapter$VH;", "onListen", "Lkotlin/Function1;", "", "onDownload", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "resolvingId", "", "downloadedIds", "", "setStatus", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "bindStatus", "t", "VH", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchAdapter extends ListAdapter<RemoteTrack, VH> {
    private static final SearchAdapter$Companion$DIFF$1 DIFF = new DiffUtil.ItemCallback<RemoteTrack>() { // from class: com.muzk.app.ui.search.SearchAdapter$Companion$DIFF$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(RemoteTrack a, RemoteTrack b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return Intrinsics.areEqual(a.getId(), b.getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(RemoteTrack a, RemoteTrack b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return Intrinsics.areEqual(a, b);
        }
    };
    private static final String PAYLOAD_STATUS = "status";
    private Set<String> downloadedIds;
    private final Function1<RemoteTrack, Unit> onDownload;
    private final Function1<RemoteTrack, Unit> onListen;
    private String resolvingId;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder p0, int p1, List p2) {
        onBindViewHolder((VH) p0, p1, (List<Object>) p2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchAdapter(Function1<? super RemoteTrack, Unit> onListen, Function1<? super RemoteTrack, Unit> onDownload) {
        super(DIFF);
        Intrinsics.checkNotNullParameter(onListen, "onListen");
        Intrinsics.checkNotNullParameter(onDownload, "onDownload");
        this.onListen = onListen;
        this.onDownload = onDownload;
        this.downloadedIds = SetsKt.emptySet();
    }

    public final void setStatus(String resolvingId, Set<String> downloadedIds) {
        Intrinsics.checkNotNullParameter(downloadedIds, "downloadedIds");
        if (Intrinsics.areEqual(resolvingId, this.resolvingId) && Intrinsics.areEqual(downloadedIds, this.downloadedIds)) {
            return;
        }
        this.resolvingId = resolvingId;
        this.downloadedIds = downloadedIds;
        notifyItemRangeChanged(0, getItemCount(), "status");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemRemoteTrackBinding itemRemoteTrackBindingInflate = ItemRemoteTrackBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemRemoteTrackBindingInflate, "inflate(...)");
        return new VH(itemRemoteTrackBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int position) {
        String dur;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final RemoteTrack t = getItem(position);
        ItemRemoteTrackBinding $this$onBindViewHolder_u24lambda_u243 = holder.getB();
        $this$onBindViewHolder_u24lambda_u243.title.setText(t.getTitle());
        if (t.getDurationSec() > 0) {
            dur = " · " + ModelsKt.formatDuration(t.getDurationSec() * ((long) 1000));
        } else {
            dur = "";
        }
        $this$onBindViewHolder_u24lambda_u243.subtitle.setText(t.getArtist() + dur);
        ImageView cover = $this$onBindViewHolder_u24lambda_u243.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        ImageView $this$load_u24default$iv = cover;
        Object data$iv = t.getThumbnail();
        Context $this$imageLoader$iv$iv = $this$load_u24default$iv.getContext();
        ImageLoader imageLoader$iv = Coil.imageLoader($this$imageLoader$iv$iv);
        ImageRequest.Builder $this$onBindViewHolder_u24lambda_u243_u24lambda_u240 = new ImageRequest.Builder($this$load_u24default$iv.getContext()).data(data$iv).target($this$load_u24default$iv);
        $this$onBindViewHolder_u24lambda_u243_u24lambda_u240.placeholder(R.drawable.cover_placeholder);
        $this$onBindViewHolder_u24lambda_u243_u24lambda_u240.error(R.drawable.cover_placeholder);
        ImageRequest request$iv = $this$onBindViewHolder_u24lambda_u243_u24lambda_u240.build();
        imageLoader$iv.enqueue(request$iv);
        $this$onBindViewHolder_u24lambda_u243.btnListen.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.search.SearchAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAdapter.onBindViewHolder$lambda$3$lambda$1(this.f$0, t, view);
            }
        });
        $this$onBindViewHolder_u24lambda_u243.btnDownload.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.search.SearchAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchAdapter.onBindViewHolder$lambda$3$lambda$2(this.f$0, t, view);
            }
        });
        Intrinsics.checkNotNull(t);
        bindStatus(holder, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$1(SearchAdapter this$0, RemoteTrack $t, View it) {
        Function1<RemoteTrack, Unit> function1 = this$0.onListen;
        Intrinsics.checkNotNull($t);
        function1.invoke($t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(SearchAdapter this$0, RemoteTrack $t, View it) {
        Function1<RemoteTrack, Unit> function1 = this$0.onDownload;
        Intrinsics.checkNotNull($t);
        function1.invoke($t);
    }

    public void onBindViewHolder(VH holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.contains("status")) {
            onBindViewHolder(holder, position);
            return;
        }
        RemoteTrack item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        bindStatus(holder, item);
    }

    private final void bindStatus(VH holder, RemoteTrack t) {
        ItemRemoteTrackBinding $this$bindStatus_u24lambda_u244 = holder.getB();
        boolean resolving = Intrinsics.areEqual(t.getId(), this.resolvingId);
        View listenProgress = $this$bindStatus_u24lambda_u244.listenProgress;
        Intrinsics.checkNotNullExpressionValue(listenProgress, "listenProgress");
        View $this$isVisible$iv = listenProgress;
        $this$isVisible$iv.setVisibility(resolving ? 0 : 8);
        View btnListen = $this$bindStatus_u24lambda_u244.btnListen;
        Intrinsics.checkNotNullExpressionValue(btnListen, "btnListen");
        View $this$isInvisible$iv = btnListen;
        $this$isInvisible$iv.setVisibility(resolving ? 4 : 0);
        boolean done = this.downloadedIds.contains(t.getId());
        $this$bindStatus_u24lambda_u244.btnDownload.setEnabled(!done);
        $this$bindStatus_u24lambda_u244.btnDownload.setIconResource(done ? R.drawable.ic_check : R.drawable.ic_download);
    }

    /* JADX INFO: compiled from: SearchAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/search/SearchAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/muzk/app/databinding/ItemRemoteTrackBinding;", "<init>", "(Lcom/muzk/app/databinding/ItemRemoteTrackBinding;)V", "getB", "()Lcom/muzk/app/databinding/ItemRemoteTrackBinding;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class VH extends RecyclerView.ViewHolder {
        private final ItemRemoteTrackBinding b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemRemoteTrackBinding b) {
            super(b.getRoot());
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
        }

        public final ItemRemoteTrackBinding getB() {
            return this.b;
        }
    }
}
