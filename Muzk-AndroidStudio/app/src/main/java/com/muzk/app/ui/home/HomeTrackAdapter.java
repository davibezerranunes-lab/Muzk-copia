package com.muzk.app.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.muzk.app.R;
import com.muzk.app.data.AudioCover;
import com.muzk.app.databinding.ItemHomeTrackBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeAdapters.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/muzk/app/ui/home/HomeTrackAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/muzk/app/ui/home/HomeTrack;", "Lcom/muzk/app/ui/home/HomeTrackAdapter$VH;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "VH", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HomeTrackAdapter extends ListAdapter<HomeTrack, VH> {
    private static final HomeTrackAdapter$Companion$DIFF$1 DIFF = new DiffUtil.ItemCallback<HomeTrack>() { // from class: com.muzk.app.ui.home.HomeTrackAdapter$Companion$DIFF$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(HomeTrack a, HomeTrack b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return a.getTrack().getId() == b.getTrack().getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(HomeTrack a, HomeTrack b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return Intrinsics.areEqual(a, b);
        }
    };
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeTrackAdapter(Function1<? super Integer, Unit> onClick) {
        super(DIFF);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemHomeTrackBinding itemHomeTrackBindingInflate = ItemHomeTrackBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemHomeTrackBindingInflate, "inflate(...)");
        return new VH(itemHomeTrackBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final VH holder, int position) {
        String artist;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemHomeTrackBinding $this$onBindViewHolder_u24lambda_u242 = holder.getB();
        HomeTrack item = getItem(position);
        $this$onBindViewHolder_u24lambda_u242.rank.setText(String.valueOf(position + 1));
        $this$onBindViewHolder_u24lambda_u242.title.setText(item.getTrack().getTitle());
        TextView textView = $this$onBindViewHolder_u24lambda_u242.subtitle;
        if (item.getPlays() > 0) {
            artist = $this$onBindViewHolder_u24lambda_u242.getRoot().getContext().getResources().getQuantityString(R.plurals.plays, item.getPlays(), item.getTrack().getArtist(), Integer.valueOf(item.getPlays()));
        } else {
            artist = item.getTrack().getArtist();
        }
        textView.setText(artist);
        ImageView cover = $this$onBindViewHolder_u24lambda_u242.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        ImageView $this$load_u24default$iv = cover;
        Object data$iv = new AudioCover(item.getTrack().getUri());
        Context $this$imageLoader$iv$iv = $this$load_u24default$iv.getContext();
        ImageLoader imageLoader$iv = Coil.imageLoader($this$imageLoader$iv$iv);
        ImageRequest.Builder $this$onBindViewHolder_u24lambda_u242_u24lambda_u240 = new ImageRequest.Builder($this$load_u24default$iv.getContext()).data(data$iv).target($this$load_u24default$iv);
        $this$onBindViewHolder_u24lambda_u242_u24lambda_u240.placeholder(R.drawable.cover_placeholder);
        $this$onBindViewHolder_u24lambda_u242_u24lambda_u240.error(R.drawable.cover_placeholder);
        ImageRequest request$iv = $this$onBindViewHolder_u24lambda_u242_u24lambda_u240.build();
        imageLoader$iv.enqueue(request$iv);
        $this$onBindViewHolder_u24lambda_u242.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.home.HomeTrackAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeTrackAdapter.onBindViewHolder$lambda$2$lambda$1(this.f$0, holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$1(HomeTrackAdapter this$0, VH $holder, View it) {
        this$0.onClick.invoke(Integer.valueOf($holder.getBindingAdapterPosition()));
    }

    /* JADX INFO: compiled from: HomeAdapters.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/home/HomeTrackAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/muzk/app/databinding/ItemHomeTrackBinding;", "<init>", "(Lcom/muzk/app/databinding/ItemHomeTrackBinding;)V", "getB", "()Lcom/muzk/app/databinding/ItemHomeTrackBinding;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class VH extends RecyclerView.ViewHolder {
        private final ItemHomeTrackBinding b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemHomeTrackBinding b) {
            super(b.getRoot());
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
        }

        public final ItemHomeTrackBinding getB() {
            return this.b;
        }
    }
}
