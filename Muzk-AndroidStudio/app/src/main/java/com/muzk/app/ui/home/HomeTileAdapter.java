package com.muzk.app.ui.home;

import android.content.Context;
import android.content.res.ColorStateList;
import android.net.Uri;
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
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import coil.util.CoilUtils;
import com.google.android.material.color.MaterialColors;
import com.muzk.app.R;
import com.muzk.app.data.AudioCover;
import com.muzk.app.data.PlaylistStore;
import com.muzk.app.databinding.ItemHomeTileBinding;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeAdapters.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/muzk/app/ui/home/HomeTileAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/muzk/app/ui/home/HomeTile;", "Lcom/muzk/app/ui/home/HomeTileAdapter$VH;", "onClick", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "defaultIconTint", "Landroid/content/res/ColorStateList;", "onBindViewHolder", "holder", "position", "VH", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HomeTileAdapter extends ListAdapter<HomeTile, VH> {
    private static final HomeTileAdapter$Companion$DIFF$1 DIFF = new DiffUtil.ItemCallback<HomeTile>() { // from class: com.muzk.app.ui.home.HomeTileAdapter$Companion$DIFF$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(HomeTile a, HomeTile b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return a.getKind() == b.getKind() && Intrinsics.areEqual(a.getKey(), b.getKey());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(HomeTile a, HomeTile b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return Intrinsics.areEqual(a, b);
        }
    };
    private ColorStateList defaultIconTint;
    private final Function1<HomeTile, Unit> onClick;

    /* JADX INFO: compiled from: HomeAdapters.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HomeTile.Kind.values().length];
            try {
                iArr[HomeTile.Kind.PLAYLIST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[HomeTile.Kind.RECENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HomeTile.Kind.FOLDER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeTileAdapter(Function1<? super HomeTile, Unit> onClick) {
        super(DIFF);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemHomeTileBinding itemHomeTileBindingInflate = ItemHomeTileBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemHomeTileBindingInflate, "inflate(...)");
        return new VH(itemHomeTileBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int position) {
        int fallback;
        ColorStateList colorStateListValueOf;
        Uri uri;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final ItemHomeTileBinding $this$onBindViewHolder_u24lambda_u244 = holder.getB();
        final HomeTile tile = getItem(position);
        if (this.defaultIconTint == null) {
            this.defaultIconTint = $this$onBindViewHolder_u24lambda_u244.icon.getImageTintList();
        }
        $this$onBindViewHolder_u24lambda_u244.title.setText(tile.getTitle());
        switch (WhenMappings.$EnumSwitchMapping$0[tile.getKind().ordinal()]) {
            case 1:
                fallback = R.drawable.ic_playlist;
                break;
            case 2:
                fallback = R.drawable.ic_library;
                break;
            case 3:
                fallback = R.drawable.ic_folder;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        boolean liked = tile.getKind() == HomeTile.Kind.PLAYLIST && Intrinsics.areEqual(tile.getKey(), PlaylistStore.LIKED_ID);
        boolean all = tile.getKind() == HomeTile.Kind.RECENT;
        if (liked) {
            $this$onBindViewHolder_u24lambda_u244.iconBox.setBackgroundResource(R.drawable.bg_liked);
        } else if (all) {
            $this$onBindViewHolder_u24lambda_u244.iconBox.setBackgroundResource(R.drawable.bg_all_art);
        } else {
            $this$onBindViewHolder_u24lambda_u244.iconBox.setBackgroundColor(MaterialColors.getColor($this$onBindViewHolder_u24lambda_u244.iconBox, com.google.android.material.R.attr.colorSecondaryContainer));
        }
        $this$onBindViewHolder_u24lambda_u244.icon.setImageResource(liked ? R.drawable.ic_favorite : fallback);
        ImageView imageView = $this$onBindViewHolder_u24lambda_u244.icon;
        if (liked) {
            colorStateListValueOf = ColorStateList.valueOf(-1);
        } else {
            colorStateListValueOf = all ? ColorStateList.valueOf(MaterialColors.getColor($this$onBindViewHolder_u24lambda_u244.icon, androidx.appcompat.R.attr.colorPrimary)) : this.defaultIconTint;
        }
        imageView.setImageTintList(colorStateListValueOf);
        View icon = $this$onBindViewHolder_u24lambda_u244.icon;
        Intrinsics.checkNotNullExpressionValue(icon, "icon");
        View $this$isVisible$iv = icon;
        $this$isVisible$iv.setVisibility(0);
        View cover = $this$onBindViewHolder_u24lambda_u244.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        CoilUtils.dispose(cover);
        ImageView $this$dispose$iv = $this$onBindViewHolder_u24lambda_u244.cover;
        $this$dispose$iv.setImageDrawable(null);
        if (!liked && (uri = tile.getCover()) != null) {
            ImageView cover2 = $this$onBindViewHolder_u24lambda_u244.cover;
            Intrinsics.checkNotNullExpressionValue(cover2, "cover");
            Object data$iv = new AudioCover(uri);
            Context $this$imageLoader$iv$iv = cover2.getContext();
            ImageLoader imageLoader$iv = Coil.imageLoader($this$imageLoader$iv$iv);
            ImageRequest.Builder $this$onBindViewHolder_u24lambda_u244_u24lambda_u242_u24lambda_u241 = new ImageRequest.Builder(cover2.getContext()).data(data$iv).target(cover2);
            $this$onBindViewHolder_u24lambda_u244_u24lambda_u242_u24lambda_u241.listener(new ImageRequest.Listener() { // from class: com.muzk.app.ui.home.HomeTileAdapter$onBindViewHolder$lambda$4$lambda$2$lambda$1$$inlined$listener$default$1
                @Override // coil.request.ImageRequest.Listener
                public void onStart(ImageRequest request) {
                }

                @Override // coil.request.ImageRequest.Listener
                public void onCancel(ImageRequest request) {
                }

                @Override // coil.request.ImageRequest.Listener
                public void onError(ImageRequest request, ErrorResult result) {
                }

                @Override // coil.request.ImageRequest.Listener
                public void onSuccess(ImageRequest request, SuccessResult result) {
                    View icon2 = $this$onBindViewHolder_u24lambda_u244.icon;
                    Intrinsics.checkNotNullExpressionValue(icon2, "icon");
                    View $this$isVisible$iv2 = icon2;
                    $this$isVisible$iv2.setVisibility(8);
                }
            });
            ImageRequest request$iv = $this$onBindViewHolder_u24lambda_u244_u24lambda_u242_u24lambda_u241.build();
            imageLoader$iv.enqueue(request$iv);
        }
        $this$onBindViewHolder_u24lambda_u244.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.home.HomeTileAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeTileAdapter.onBindViewHolder$lambda$4$lambda$3(this.f$0, tile, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4$lambda$3(HomeTileAdapter this$0, HomeTile $tile, View it) {
        Function1<HomeTile, Unit> function1 = this$0.onClick;
        Intrinsics.checkNotNull($tile);
        function1.invoke($tile);
    }

    /* JADX INFO: compiled from: HomeAdapters.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/home/HomeTileAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/muzk/app/databinding/ItemHomeTileBinding;", "<init>", "(Lcom/muzk/app/databinding/ItemHomeTileBinding;)V", "getB", "()Lcom/muzk/app/databinding/ItemHomeTileBinding;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class VH extends RecyclerView.ViewHolder {
        private final ItemHomeTileBinding b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemHomeTileBinding b) {
            super(b.getRoot());
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
        }

        public final ItemHomeTileBinding getB() {
            return this.b;
        }
    }
}
