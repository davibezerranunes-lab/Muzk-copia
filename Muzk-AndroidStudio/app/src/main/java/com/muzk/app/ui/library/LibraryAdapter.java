package com.muzk.app.ui.library;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.google.android.material.color.MaterialColors;
import com.muzk.app.R;
import com.muzk.app.data.AudioCover;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.ModelsKt;
import com.muzk.app.data.PlaylistStore;
import com.muzk.app.databinding.ItemCollectionBinding;
import com.muzk.app.databinding.ItemHeaderBinding;
import com.muzk.app.databinding.ItemLocalTrackBinding;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u001e\u001f !B\u0099\u0001\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/muzk/app/ui/library/LibraryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/muzk/app/ui/library/LibraryRow;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onTrackClick", "Lkotlin/Function1;", "Lcom/muzk/app/ui/library/LibraryRow$Track;", "", "onTrackMore", "Lkotlin/Function2;", "Landroid/view/View;", "onTrackLongClick", "onFolderClick", "Lcom/muzk/app/ui/library/LibraryRow$Folder;", "onPlaylistClick", "Lcom/muzk/app/ui/library/LibraryRow$PlaylistItem;", "onPlaylistMore", "onHeaderClick", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "HeaderVH", "TrackVH", "CollectionVH", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LibraryAdapter extends ListAdapter<LibraryRow, RecyclerView.ViewHolder> {
    private static final LibraryAdapter$Companion$DIFF$1 DIFF = new DiffUtil.ItemCallback<LibraryRow>() { // from class: com.muzk.app.ui.library.LibraryAdapter$Companion$DIFF$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(LibraryRow a, LibraryRow b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            if ((a instanceof LibraryRow.Header) && (b instanceof LibraryRow.Header)) {
                return true;
            }
            if ((a instanceof LibraryRow.Track) && (b instanceof LibraryRow.Track)) {
                return ((LibraryRow.Track) a).getTrack().getId() == ((LibraryRow.Track) b).getTrack().getId();
            }
            if ((a instanceof LibraryRow.Folder) && (b instanceof LibraryRow.Folder)) {
                return Intrinsics.areEqual(((LibraryRow.Folder) a).getPath(), ((LibraryRow.Folder) b).getPath());
            }
            if ((a instanceof LibraryRow.PlaylistItem) && (b instanceof LibraryRow.PlaylistItem)) {
                return Intrinsics.areEqual(((LibraryRow.PlaylistItem) a).getPlaylist().getId(), ((LibraryRow.PlaylistItem) b).getPlaylist().getId());
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(LibraryRow a, LibraryRow b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            return Intrinsics.areEqual(a, b);
        }
    };
    private static final int TYPE_COLLECTION = 2;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_TRACK = 1;
    private final Function1<LibraryRow.Folder, Unit> onFolderClick;
    private final Function0<Unit> onHeaderClick;
    private final Function1<LibraryRow.PlaylistItem, Unit> onPlaylistClick;
    private final Function2<LibraryRow.PlaylistItem, View, Unit> onPlaylistMore;
    private final Function1<LibraryRow.Track, Unit> onTrackClick;
    private final Function1<LibraryRow.Track, Unit> onTrackLongClick;
    private final Function2<LibraryRow.Track, View, Unit> onTrackMore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LibraryAdapter(Function1<? super LibraryRow.Track, Unit> onTrackClick, Function2<? super LibraryRow.Track, ? super View, Unit> onTrackMore, Function1<? super LibraryRow.Track, Unit> onTrackLongClick, Function1<? super LibraryRow.Folder, Unit> onFolderClick, Function1<? super LibraryRow.PlaylistItem, Unit> onPlaylistClick, Function2<? super LibraryRow.PlaylistItem, ? super View, Unit> onPlaylistMore, Function0<Unit> onHeaderClick) {
        super(DIFF);
        Intrinsics.checkNotNullParameter(onTrackClick, "onTrackClick");
        Intrinsics.checkNotNullParameter(onTrackMore, "onTrackMore");
        Intrinsics.checkNotNullParameter(onTrackLongClick, "onTrackLongClick");
        Intrinsics.checkNotNullParameter(onFolderClick, "onFolderClick");
        Intrinsics.checkNotNullParameter(onPlaylistClick, "onPlaylistClick");
        Intrinsics.checkNotNullParameter(onPlaylistMore, "onPlaylistMore");
        Intrinsics.checkNotNullParameter(onHeaderClick, "onHeaderClick");
        this.onTrackClick = onTrackClick;
        this.onTrackMore = onTrackMore;
        this.onTrackLongClick = onTrackLongClick;
        this.onFolderClick = onFolderClick;
        this.onPlaylistClick = onPlaylistClick;
        this.onPlaylistMore = onPlaylistMore;
        this.onHeaderClick = onHeaderClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        LibraryRow item = getItem(position);
        if (item instanceof LibraryRow.Header) {
            return 0;
        }
        if (item instanceof LibraryRow.Track) {
            return 1;
        }
        if (!(item instanceof LibraryRow.Folder) && !(item instanceof LibraryRow.PlaylistItem)) {
            throw new NoWhenBranchMatchedException();
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater inf = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0:
                ItemHeaderBinding itemHeaderBindingInflate = ItemHeaderBinding.inflate(inf, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemHeaderBindingInflate, "inflate(...)");
                return new HeaderVH(itemHeaderBindingInflate);
            case 1:
                ItemLocalTrackBinding itemLocalTrackBindingInflate = ItemLocalTrackBinding.inflate(inf, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemLocalTrackBindingInflate, "inflate(...)");
                return new TrackVH(itemLocalTrackBindingInflate);
            default:
                ItemCollectionBinding itemCollectionBindingInflate = ItemCollectionBinding.inflate(inf, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemCollectionBindingInflate, "inflate(...)");
                return new CollectionVH(itemCollectionBindingInflate);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final LibraryRow row = getItem(position);
        if (row instanceof LibraryRow.Header) {
            ItemHeaderBinding $this$onBindViewHolder_u24lambda_u241 = ((HeaderVH) holder).getB();
            $this$onBindViewHolder_u24lambda_u241.title.setText(((LibraryRow.Header) row).getTitle());
            $this$onBindViewHolder_u24lambda_u241.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibraryAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, view);
                }
            });
            return;
        }
        if (row instanceof LibraryRow.Track) {
            ItemLocalTrackBinding $this$onBindViewHolder_u24lambda_u246 = ((TrackVH) holder).getB();
            LocalTrack t = ((LibraryRow.Track) row).getTrack();
            $this$onBindViewHolder_u24lambda_u246.title.setText(t.getTitle());
            $this$onBindViewHolder_u24lambda_u246.subtitle.setText(t.getArtist() + " · " + ModelsKt.formatDuration(t.getDurationMs()));
            ImageView cover = $this$onBindViewHolder_u24lambda_u246.cover;
            Intrinsics.checkNotNullExpressionValue(cover, "cover");
            ImageView $this$load_u24default$iv = cover;
            Object data$iv = new AudioCover(t.getUri());
            Context $this$imageLoader$iv$iv = $this$load_u24default$iv.getContext();
            ImageLoader imageLoader$iv = Coil.imageLoader($this$imageLoader$iv$iv);
            ImageRequest.Builder $this$onBindViewHolder_u24lambda_u246_u24lambda_u242 = new ImageRequest.Builder($this$load_u24default$iv.getContext()).data(data$iv).target($this$load_u24default$iv);
            $this$onBindViewHolder_u24lambda_u246_u24lambda_u242.placeholder(R.drawable.cover_placeholder);
            $this$onBindViewHolder_u24lambda_u246_u24lambda_u242.error(R.drawable.cover_placeholder);
            ImageRequest request$iv = $this$onBindViewHolder_u24lambda_u246_u24lambda_u242.build();
            imageLoader$iv.enqueue(request$iv);
            View check = $this$onBindViewHolder_u24lambda_u246.check;
            Intrinsics.checkNotNullExpressionValue(check, "check");
            View $this$isVisible$iv = check;
            boolean value$iv = ((LibraryRow.Track) row).getSelected();
            $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
            $this$onBindViewHolder_u24lambda_u246.cover.setAlpha(((LibraryRow.Track) row).getSelected() ? 0.45f : 1.0f);
            $this$onBindViewHolder_u24lambda_u246.getRoot().setBackgroundColor(((LibraryRow.Track) row).getSelected() ? ColorUtils.setAlphaComponent(MaterialColors.getColor($this$onBindViewHolder_u24lambda_u246.getRoot(), androidx.appcompat.R.attr.colorPrimary), 51) : 0);
            View btnMore = $this$onBindViewHolder_u24lambda_u246.btnMore;
            Intrinsics.checkNotNullExpressionValue(btnMore, "btnMore");
            View $this$isVisible$iv2 = btnMore;
            boolean value$iv2 = !((LibraryRow.Track) row).getSelecting();
            $this$isVisible$iv2.setVisibility(value$iv2 ? 0 : 8);
            $this$onBindViewHolder_u24lambda_u246.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibraryAdapter.onBindViewHolder$lambda$6$lambda$3(this.f$0, row, view);
                }
            });
            $this$onBindViewHolder_u24lambda_u246.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.muzk.app.ui.library.LibraryAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return LibraryAdapter.onBindViewHolder$lambda$6$lambda$4(this.f$0, row, view);
                }
            });
            $this$onBindViewHolder_u24lambda_u246.btnMore.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibraryAdapter.onBindViewHolder$lambda$6$lambda$5(this.f$0, row, view);
                }
            });
            return;
        }
        if (row instanceof LibraryRow.Folder) {
            ItemCollectionBinding $this$onBindViewHolder_u24lambda_u248 = ((CollectionVH) holder).getB();
            $this$onBindViewHolder_u24lambda_u248.iconBox.setBackgroundResource(R.drawable.bg_icon_tile);
            $this$onBindViewHolder_u24lambda_u248.icon.setImageTintList(ColorStateList.valueOf(MaterialColors.getColor($this$onBindViewHolder_u24lambda_u248.icon, com.google.android.material.R.attr.colorOnSurfaceVariant)));
            $this$onBindViewHolder_u24lambda_u248.icon.setImageResource(R.drawable.ic_folder);
            $this$onBindViewHolder_u24lambda_u248.title.setText(((LibraryRow.Folder) row).getName());
            $this$onBindViewHolder_u24lambda_u248.subtitle.setText($this$onBindViewHolder_u24lambda_u248.getRoot().getContext().getString(R.string.tracks_count, Integer.valueOf(((LibraryRow.Folder) row).getCount())) + " · " + ((LibraryRow.Folder) row).getPath());
            View btnMore2 = $this$onBindViewHolder_u24lambda_u248.btnMore;
            Intrinsics.checkNotNullExpressionValue(btnMore2, "btnMore");
            View $this$isVisible$iv3 = btnMore2;
            $this$isVisible$iv3.setVisibility(8);
            $this$onBindViewHolder_u24lambda_u248.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibraryAdapter.onBindViewHolder$lambda$8$lambda$7(this.f$0, row, view);
                }
            });
            return;
        }
        if (!(row instanceof LibraryRow.PlaylistItem)) {
            throw new NoWhenBranchMatchedException();
        }
        ItemCollectionBinding $this$onBindViewHolder_u24lambda_u2411 = ((CollectionVH) holder).getB();
        boolean liked = Intrinsics.areEqual(((LibraryRow.PlaylistItem) row).getPlaylist().getId(), PlaylistStore.LIKED_ID);
        $this$onBindViewHolder_u24lambda_u2411.iconBox.setBackgroundResource(liked ? R.drawable.bg_liked_rounded : R.drawable.bg_icon_tile);
        $this$onBindViewHolder_u24lambda_u2411.icon.setImageTintList(ColorStateList.valueOf(liked ? -1 : MaterialColors.getColor($this$onBindViewHolder_u24lambda_u2411.icon, com.google.android.material.R.attr.colorOnSurfaceVariant)));
        $this$onBindViewHolder_u24lambda_u2411.icon.setImageResource(liked ? R.drawable.ic_favorite : R.drawable.ic_playlist);
        $this$onBindViewHolder_u24lambda_u2411.title.setText(((LibraryRow.PlaylistItem) row).getPlaylist().getName());
        $this$onBindViewHolder_u24lambda_u2411.subtitle.setText($this$onBindViewHolder_u24lambda_u2411.getRoot().getContext().getString(R.string.playlist_subtitle, Integer.valueOf(((LibraryRow.PlaylistItem) row).getCount())));
        View btnMore3 = $this$onBindViewHolder_u24lambda_u2411.btnMore;
        Intrinsics.checkNotNullExpressionValue(btnMore3, "btnMore");
        View $this$isVisible$iv4 = btnMore3;
        boolean value$iv3 = !liked;
        $this$isVisible$iv4.setVisibility(value$iv3 ? 0 : 8);
        $this$onBindViewHolder_u24lambda_u2411.btnMore.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryAdapter.onBindViewHolder$lambda$11$lambda$9(this.f$0, row, view);
            }
        });
        $this$onBindViewHolder_u24lambda_u2411.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryAdapter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryAdapter.onBindViewHolder$lambda$11$lambda$10(this.f$0, row, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(LibraryAdapter this$0, View it) {
        this$0.onHeaderClick.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$6$lambda$3(LibraryAdapter this$0, LibraryRow $row, View it) {
        this$0.onTrackClick.invoke($row);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$6$lambda$4(LibraryAdapter this$0, LibraryRow $row, View it) {
        this$0.onTrackLongClick.invoke($row);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$6$lambda$5(LibraryAdapter this$0, LibraryRow $row, View it) {
        Function2<LibraryRow.Track, View, Unit> function2 = this$0.onTrackMore;
        Intrinsics.checkNotNull(it);
        function2.invoke($row, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$8$lambda$7(LibraryAdapter this$0, LibraryRow $row, View it) {
        this$0.onFolderClick.invoke($row);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$11$lambda$9(LibraryAdapter this$0, LibraryRow $row, View it) {
        Function2<LibraryRow.PlaylistItem, View, Unit> function2 = this$0.onPlaylistMore;
        Intrinsics.checkNotNull(it);
        function2.invoke($row, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$11$lambda$10(LibraryAdapter this$0, LibraryRow $row, View it) {
        this$0.onPlaylistClick.invoke($row);
    }

    /* JADX INFO: compiled from: LibraryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/library/LibraryAdapter$HeaderVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/muzk/app/databinding/ItemHeaderBinding;", "<init>", "(Lcom/muzk/app/databinding/ItemHeaderBinding;)V", "getB", "()Lcom/muzk/app/databinding/ItemHeaderBinding;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class HeaderVH extends RecyclerView.ViewHolder {
        private final ItemHeaderBinding b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderVH(ItemHeaderBinding b) {
            super(b.getRoot());
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
        }

        public final ItemHeaderBinding getB() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: LibraryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/library/LibraryAdapter$TrackVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/muzk/app/databinding/ItemLocalTrackBinding;", "<init>", "(Lcom/muzk/app/databinding/ItemLocalTrackBinding;)V", "getB", "()Lcom/muzk/app/databinding/ItemLocalTrackBinding;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class TrackVH extends RecyclerView.ViewHolder {
        private final ItemLocalTrackBinding b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrackVH(ItemLocalTrackBinding b) {
            super(b.getRoot());
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
        }

        public final ItemLocalTrackBinding getB() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: LibraryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/library/LibraryAdapter$CollectionVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/muzk/app/databinding/ItemCollectionBinding;", "<init>", "(Lcom/muzk/app/databinding/ItemCollectionBinding;)V", "getB", "()Lcom/muzk/app/databinding/ItemCollectionBinding;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class CollectionVH extends RecyclerView.ViewHolder {
        private final ItemCollectionBinding b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CollectionVH(ItemCollectionBinding b) {
            super(b.getRoot());
            Intrinsics.checkNotNullParameter(b, "b");
            this.b = b;
        }

        public final ItemCollectionBinding getB() {
            return this.b;
        }
    }
}
