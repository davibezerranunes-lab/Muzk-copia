package com.muzk.app.ui.player;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.navigation.fragment.FragmentKt;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.slider.Slider;
import com.muzk.app.R;
import com.muzk.app.data.ModelsKt;
import com.muzk.app.data.Playlist;
import com.muzk.app.data.PlaylistStore;
import com.muzk.app.databinding.DialogTextInputBinding;
import com.muzk.app.databinding.FragmentPlayerBinding;
import com.muzk.app.playback.PlayerUiState;
import com.muzk.app.playback.PlayerViewModel;
import com.muzk.app.ui.CoverColors;
import com.muzk.app.ui.settings.EqualizerDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: PlayerFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001dH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0002J\u0017\u0010-\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u001aH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/muzk/app/ui/player/PlayerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/muzk/app/databinding/FragmentPlayerBinding;", "binding", "getBinding", "()Lcom/muzk/app/databinding/FragmentPlayerBinding;", "player", "Lcom/muzk/app/playback/PlayerViewModel;", "getPlayer", "()Lcom/muzk/app/playback/PlayerViewModel;", "player$delegate", "Lkotlin/Lazy;", "dragging", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "currentTrackId", "", "()Ljava/lang/Long;", "renderLike", "toggleLike", "toggleTint", "Landroid/content/res/ColorStateList;", DebugKt.DEBUG_PROPERTY_VALUE_ON, "offAttr", "", "showMenu", "anchor", "pickPlaylist", "trackId", "toast", "text", "", "applyCoverColor", "color", "(Ljava/lang/Integer;)V", "onDestroyView", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PlayerFragment extends Fragment {
    private FragmentPlayerBinding _binding;
    private boolean dragging;

    /* JADX INFO: renamed from: player$delegate, reason: from kotlin metadata */
    private final Lazy player;

    public PlayerFragment() {
        final PlayerFragment $this$activityViewModels_u24default$iv = this;
        final Function0 extrasProducer$iv = null;
        this.player = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(PlayerViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.player.PlayerFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.player.PlayerFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.player.PlayerFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentPlayerBinding getBinding() {
        FragmentPlayerBinding fragmentPlayerBinding = this._binding;
        Intrinsics.checkNotNull(fragmentPlayerBinding);
        return fragmentPlayerBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayerViewModel getPlayer() {
        return (PlayerViewModel) this.player.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentPlayerBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().playerRoot, new OnApplyWindowInsetsListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda7
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return PlayerFragment.onViewCreated$lambda$0(view2, windowInsetsCompat);
            }
        });
        final FragmentPlayerBinding $this$onViewCreated_u24lambda_u2410 = getBinding();
        $this$onViewCreated_u24lambda_u2410.btnCollapse.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayerFragment.onViewCreated$lambda$10$lambda$1(this.f$0, view2);
            }
        });
        $this$onViewCreated_u24lambda_u2410.btnPlay.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayerFragment.onViewCreated$lambda$10$lambda$2(this.f$0, view2);
            }
        });
        $this$onViewCreated_u24lambda_u2410.btnNext.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayerFragment.onViewCreated$lambda$10$lambda$3(this.f$0, view2);
            }
        });
        $this$onViewCreated_u24lambda_u2410.btnPrev.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayerFragment.onViewCreated$lambda$10$lambda$4(this.f$0, view2);
            }
        });
        $this$onViewCreated_u24lambda_u2410.btnShuffle.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayerFragment.onViewCreated$lambda$10$lambda$5(this.f$0, view2);
            }
        });
        $this$onViewCreated_u24lambda_u2410.btnRepeat.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayerFragment.onViewCreated$lambda$10$lambda$6(this.f$0, view2);
            }
        });
        $this$onViewCreated_u24lambda_u2410.btnMenu.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayerFragment.onViewCreated$lambda$10$lambda$7(this.f$0, view2);
            }
        });
        $this$onViewCreated_u24lambda_u2410.btnLike.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.toggleLike();
            }
        });
        $this$onViewCreated_u24lambda_u2410.title.setSelected(true);
        $this$onViewCreated_u24lambda_u2410.seek.addOnSliderTouchListener(new Slider.OnSliderTouchListener() { // from class: com.muzk.app.ui.player.PlayerFragment$onViewCreated$2$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.Slider.OnSliderTouchListener, com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStartTrackingTouch(Slider slider) {
                Intrinsics.checkNotNullParameter(slider, "slider");
                this.this$0.dragging = true;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.Slider.OnSliderTouchListener, com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStopTrackingTouch(Slider slider) {
                Intrinsics.checkNotNullParameter(slider, "slider");
                this.this$0.dragging = false;
                this.this$0.getPlayer().seekTo((long) slider.getValue());
            }
        });
        $this$onViewCreated_u24lambda_u2410.seek.addOnChangeListener(new Slider.OnChangeListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.Slider.OnChangeListener, com.google.android.material.slider.BaseOnChangeListener
            public final void onValueChange(Slider slider, float f, boolean z) {
                PlayerFragment.onViewCreated$lambda$10$lambda$9($this$onViewCreated_u24lambda_u2410, slider, f, z);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass3(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onViewCreated$lambda$0(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int bottom$iv = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int left$iv = v.getPaddingLeft();
        int top$iv = v.getPaddingTop();
        int right$iv = v.getPaddingRight();
        v.setPadding(left$iv, top$iv, right$iv, bottom$iv);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$1(PlayerFragment this$0, View it) {
        FragmentKt.findNavController(this$0).popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$2(PlayerFragment this$0, View it) {
        this$0.getPlayer().togglePlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$3(PlayerFragment this$0, View it) {
        this$0.getPlayer().next();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$4(PlayerFragment this$0, View it) {
        this$0.getPlayer().previous();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$5(PlayerFragment this$0, View it) {
        this$0.getPlayer().toggleShuffle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$6(PlayerFragment this$0, View it) {
        this$0.getPlayer().cycleRepeat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$7(PlayerFragment this$0, View it) {
        Intrinsics.checkNotNull(it);
        this$0.showMenu(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$9(FragmentPlayerBinding $this_with, Slider slider, float value, boolean fromUser) {
        Intrinsics.checkNotNullParameter(slider, "<unused var>");
        if (fromUser) {
            $this_with.position.setText(ModelsKt.formatDuration((long) value));
        }
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.player.PlayerFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: PlayerFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.player.PlayerFragment$onViewCreated$3", f = "PlayerFragment.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlayerFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.muzk.app.ui.player.PlayerFragment$onViewCreated$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: PlayerFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "com.muzk.app.ui.player.PlayerFragment$onViewCreated$3$1", f = "PlayerFragment.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PlayerFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PlayerFragment playerFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = playerFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlin.Unit] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CoroutineScope $this$repeatOnLifecycle = (CoroutineScope) this.L$0;
                        final Ref.ObjectRef lastCover = new Ref.ObjectRef();
                        lastCover.element = Unit.INSTANCE;
                        BuildersKt__Builders_commonKt.launch$default($this$repeatOnLifecycle, null, null, new C00361(this.this$0, null), 3, null);
                        StateFlow<PlayerUiState> state = this.this$0.getPlayer().getState();
                        final PlayerFragment playerFragment = this.this$0;
                        this.label = 1;
                        if (state.collect(new FlowCollector() { // from class: com.muzk.app.ui.player.PlayerFragment.onViewCreated.3.1.2
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((PlayerUiState) value, (Continuation<? super Unit>) $completion);
                            }

                            /* JADX WARN: Code duplicated, block: B:12:0x0055 A[PHI: r6
  0x0055: PHI (r6v24 java.lang.String) = (r6v7 java.lang.String), (r6v9 java.lang.String) binds: [B:11:0x0053, B:23:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
                            public final Object emit(PlayerUiState playerUiState, Continuation<? super Unit> continuation) {
                                String str;
                                if (playerUiState.getHasMedia()) {
                                    FragmentPlayerBinding binding = playerFragment.getBinding();
                                    final PlayerFragment playerFragment2 = playerFragment;
                                    Ref.ObjectRef<Object> objectRef = lastCover;
                                    playerFragment2.renderLike();
                                    binding.title.setText(playerUiState.getTitle());
                                    binding.artist.setText(playerUiState.getArtist());
                                    binding.contextLabel.setText(playerUiState.isRemote() ? R.string.playing_from_search : R.string.playing_from_library);
                                    TextView textView = binding.contextName;
                                    String source = playerUiState.getSource();
                                    if (source != null) {
                                        str = source;
                                    } else {
                                        source = playerUiState.getAlbum();
                                        if (!Boxing.boxBoolean((StringsKt.isBlank(source) || playerUiState.isRemote()) ? false : true).booleanValue()) {
                                            source = null;
                                        }
                                        if (source != null) {
                                            str = source;
                                        } else {
                                            String string = playerFragment2.getString(playerUiState.isRemote() ? R.string.tab_search : R.string.source_all_tracks);
                                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                            str = string;
                                        }
                                    }
                                    textView.setText(str);
                                    if (!Intrinsics.areEqual(playerUiState.getCover(), objectRef.element)) {
                                        objectRef.element = (T) playerUiState.getCover();
                                        ShapeableImageView cover = binding.cover;
                                        Intrinsics.checkNotNullExpressionValue(cover, "cover");
                                        ShapeableImageView shapeableImageView = cover;
                                        Object cover2 = playerUiState.getCover();
                                        ImageLoader imageLoader = Coil.imageLoader(shapeableImageView.getContext());
                                        ImageRequest.Builder builderTarget = new ImageRequest.Builder(shapeableImageView.getContext()).data(cover2).target(shapeableImageView);
                                        builderTarget.placeholder(R.drawable.cover_placeholder);
                                        builderTarget.error(R.drawable.cover_placeholder);
                                        builderTarget.allowHardware(false);
                                        builderTarget.listener(new ImageRequest.Listener(playerFragment2) { // from class: com.muzk.app.ui.player.PlayerFragment$onViewCreated$3$1$2$emit$lambda$4$lambda$3$$inlined$listener$default$1
                                            @Override // coil.request.ImageRequest.Listener
                                            public void onStart(ImageRequest request) {
                                            }

                                            @Override // coil.request.ImageRequest.Listener
                                            public void onCancel(ImageRequest request) {
                                            }

                                            @Override // coil.request.ImageRequest.Listener
                                            public void onError(ImageRequest request, ErrorResult result) {
                                                this.this$0.applyCoverColor(null);
                                            }

                                            @Override // coil.request.ImageRequest.Listener
                                            public void onSuccess(ImageRequest request, SuccessResult result) {
                                                this.this$0.applyCoverColor(CoverColors.INSTANCE.extract(result.getDrawable()));
                                            }
                                        });
                                        imageLoader.enqueue(builderTarget.build());
                                    }
                                    binding.btnPlay.setIconResource(playerUiState.isPlaying() ? R.drawable.ic_pause : R.drawable.ic_play);
                                    binding.btnShuffle.setIconTint(PlayerFragment.toggleTint$default(playerFragment2, playerUiState.getShuffle(), 0, 2, null));
                                    binding.btnRepeat.setIconTint(PlayerFragment.toggleTint$default(playerFragment2, playerUiState.getRepeatMode() != 0, 0, 2, null));
                                    binding.btnRepeat.setIconResource(playerUiState.getRepeatMode() == 1 ? R.drawable.ic_repeat_one : R.drawable.ic_repeat);
                                    float fCoerceAtLeast = RangesKt.coerceAtLeast(playerUiState.getDurationMs(), 1.0f);
                                    if (!playerFragment2.dragging) {
                                        if (!(binding.seek.getValueTo() == fCoerceAtLeast)) {
                                            binding.seek.setValue(0.0f);
                                            binding.seek.setValueTo(fCoerceAtLeast);
                                        }
                                        binding.seek.setValue(RangesKt.coerceIn(playerUiState.getPositionMs(), 0.0f, fCoerceAtLeast));
                                        binding.position.setText(ModelsKt.formatDuration(playerUiState.getPositionMs()));
                                    }
                                    binding.duration.setText(ModelsKt.formatDuration(playerUiState.getDurationMs()));
                                    return Unit.INSTANCE;
                                }
                                FragmentKt.findNavController(playerFragment).popBackStack();
                                return Unit.INSTANCE;
                            }
                        }, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            }

            /* JADX INFO: renamed from: com.muzk.app.ui.player.PlayerFragment$onViewCreated$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PlayerFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "com.muzk.app.ui.player.PlayerFragment$onViewCreated$3$1$1", f = "PlayerFragment.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
            static final class C00361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ PlayerFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00361(PlayerFragment playerFragment, Continuation<? super C00361> continuation) {
                    super(2, continuation);
                    this.this$0 = playerFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00361(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            PlaylistStore.Companion companion = PlaylistStore.INSTANCE;
                            Context contextRequireContext = this.this$0.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                            StateFlow<List<Playlist>> playlists = companion.get(contextRequireContext).getPlaylists();
                            final PlayerFragment playerFragment = this.this$0;
                            this.label = 1;
                            if (playlists.collect(new FlowCollector() { // from class: com.muzk.app.ui.player.PlayerFragment.onViewCreated.3.1.1.1
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                    return emit((List<Playlist>) value, (Continuation<? super Unit>) $completion);
                                }

                                public final Object emit(List<Playlist> list, Continuation<? super Unit> continuation) {
                                    playerFragment.renderLike();
                                    return Unit.INSTANCE;
                                }
                            }, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw new KotlinNothingValueException();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LifecycleOwner viewLifecycleOwner = PlayerFragment.this.getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(PlayerFragment.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private final Long currentTrackId() {
        String strSubstringAfterLast$default;
        String it = getPlayer().getState().getValue().getMediaId();
        if (it == null) {
            return null;
        }
        if (!StringsKt.startsWith$default(it, "content://", false, 2, (Object) null)) {
            it = null;
        }
        if (it == null || (strSubstringAfterLast$default = StringsKt.substringAfterLast$default(it, '/', (String) null, 2, (Object) null)) == null) {
            return null;
        }
        return StringsKt.toLongOrNull(strSubstringAfterLast$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    public final void renderLike() {
        boolean z;
        FragmentPlayerBinding b = this._binding;
        if (b == null) {
            return;
        }
        Long id = currentTrackId();
        View btnLike = b.btnLike;
        Intrinsics.checkNotNullExpressionValue(btnLike, "btnLike");
        View $this$isVisible$iv = btnLike;
        boolean value$iv = id != null;
        $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
        if (id != null) {
            PlaylistStore.Companion companion = PlaylistStore.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            z = companion.get(contextRequireContext).isLiked(id.longValue());
        }
        boolean liked = z;
        b.btnLike.setIconResource(liked ? R.drawable.ic_favorite : R.drawable.ic_favorite_border);
        b.btnLike.setIconTint(toggleTint(liked, com.google.android.material.R.attr.colorOnSurface));
        b.btnLike.setContentDescription(getString(liked ? R.string.unlike : R.string.like));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleLike() {
        MaterialButton materialButton;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorScaleX;
        ViewPropertyAnimator viewPropertyAnimatorScaleY;
        ViewPropertyAnimator duration;
        Long lCurrentTrackId = currentTrackId();
        if (lCurrentTrackId != null) {
            long id = lCurrentTrackId.longValue();
            PlaylistStore.Companion companion = PlaylistStore.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            boolean liked = companion.get(contextRequireContext).toggleLike(id);
            FragmentPlayerBinding fragmentPlayerBinding = this._binding;
            if (fragmentPlayerBinding != null && (materialButton = fragmentPlayerBinding.btnLike) != null && (viewPropertyAnimatorAnimate = materialButton.animate()) != null && (viewPropertyAnimatorScaleX = viewPropertyAnimatorAnimate.scaleX(1.25f)) != null && (viewPropertyAnimatorScaleY = viewPropertyAnimatorScaleX.scaleY(1.25f)) != null && (duration = viewPropertyAnimatorScaleY.setDuration(120L)) != null) {
                duration.withEndAction(new Runnable() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlayerFragment.toggleLike$lambda$12(this.f$0);
                    }
                });
            }
            String string = getString(liked ? R.string.liked_added : R.string.liked_removed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleLike$lambda$12(PlayerFragment this$0) {
        MaterialButton materialButton;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorScaleX;
        ViewPropertyAnimator viewPropertyAnimatorScaleY;
        FragmentPlayerBinding fragmentPlayerBinding = this$0._binding;
        if (fragmentPlayerBinding == null || (materialButton = fragmentPlayerBinding.btnLike) == null || (viewPropertyAnimatorAnimate = materialButton.animate()) == null || (viewPropertyAnimatorScaleX = viewPropertyAnimatorAnimate.scaleX(1.0f)) == null || (viewPropertyAnimatorScaleY = viewPropertyAnimatorScaleX.scaleY(1.0f)) == null) {
            return;
        }
        viewPropertyAnimatorScaleY.setDuration(120L);
    }

    static /* synthetic */ ColorStateList toggleTint$default(PlayerFragment playerFragment, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = com.google.android.material.R.attr.colorOnSurfaceVariant;
        }
        return playerFragment.toggleTint(z, i);
    }

    private final ColorStateList toggleTint(boolean on, int offAttr) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(MaterialColors.getColor(getBinding().getRoot(), on ? androidx.appcompat.R.attr.colorPrimary : offAttr));
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        return colorStateListValueOf;
    }

    private final void showMenu(View anchor) {
        String strSubstringAfterLast$default;
        PlayerUiState s = getPlayer().getState().getValue();
        String it = s.getMediaId();
        Long longOrNull = null;
        if (it != null) {
            if (!StringsKt.startsWith$default(it, "content://", false, 2, (Object) null)) {
                it = null;
            }
            if (it != null && (strSubstringAfterLast$default = StringsKt.substringAfterLast$default(it, '/', (String) null, 2, (Object) null)) != null) {
                longOrNull = StringsKt.toLongOrNull(strSubstringAfterLast$default);
            }
        }
        final Long trackId = longOrNull;
        PopupMenu popup = new PopupMenu(requireContext(), anchor);
        if (trackId != null) {
            popup.getMenu().add(0, 1, 0, R.string.add_to_playlist);
        }
        popup.getMenu().add(0, 2, 1, R.string.equalizer);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda4
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return PlayerFragment.showMenu$lambda$14(trackId, this, menuItem);
            }
        });
        popup.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showMenu$lambda$14(Long $trackId, PlayerFragment this$0, MenuItem it) {
        switch (it.getItemId()) {
            case 1:
                if ($trackId != null) {
                    long p0 = $trackId.longValue();
                    this$0.pickPlaylist(p0);
                }
                break;
            case 2:
                EqualizerDialog equalizerDialog = EqualizerDialog.INSTANCE;
                Context contextRequireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                equalizerDialog.show(contextRequireContext);
                break;
        }
        return true;
    }

    private final void pickPlaylist(final long trackId) {
        PlaylistStore.Companion companion = PlaylistStore.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PlaylistStore store = companion.get(contextRequireContext);
        final List<Playlist> value = store.getPlaylists().getValue();
        List<Playlist> $this$map$iv = value;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Playlist it = (Playlist) item$iv$iv;
            destination$iv$iv.add(it.getName());
        }
        Collection $this$toTypedArray$iv = CollectionsKt.plus((Collection<? extends String>) destination$iv$iv, getString(R.string.new_playlist));
        String[] names = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        new MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.add_to_playlist).setItems((CharSequence[]) names, new DialogInterface.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PlayerFragment.pickPlaylist$lambda$17(value, store, trackId, this, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickPlaylist$lambda$17(List $playlists, final PlaylistStore $store, final long $trackId, final PlayerFragment this$0, DialogInterface dialogInterface, int which) {
        if (which < $playlists.size()) {
            $store.addTrack(((Playlist) $playlists.get(which)).getId(), $trackId);
            String string = this$0.getString(R.string.added_to, ((Playlist) $playlists.get(which)).getName());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this$0.toast(string);
            return;
        }
        final DialogTextInputBinding input = DialogTextInputBinding.inflate(this$0.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(input, "inflate(...)");
        new MaterialAlertDialogBuilder(this$0.requireContext()).setTitle(R.string.new_playlist).setView((View) input.getRoot()).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.create, new DialogInterface.OnClickListener() { // from class: com.muzk.app.ui.player.PlayerFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i) {
                PlayerFragment.pickPlaylist$lambda$17$lambda$16(input, $store, $trackId, this$0, dialogInterface2, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickPlaylist$lambda$17$lambda$16(DialogTextInputBinding $input, PlaylistStore $store, long $trackId, PlayerFragment this$0, DialogInterface dialogInterface, int i) {
        String string;
        Editable text = $input.input.getText();
        String name = (text == null || (string = text.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString();
        if (name == null) {
            name = "";
        }
        if (name.length() > 0) {
            $store.addTrack($store.create(name), $trackId);
            String string2 = this$0.getString(R.string.added_to, name);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this$0.toast(string2);
        }
    }

    private final void toast(String text) {
        Toast.makeText(requireContext(), text, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyCoverColor(Integer color) {
        LinearLayout root;
        int it;
        FragmentPlayerBinding fragmentPlayerBinding = this._binding;
        if (fragmentPlayerBinding == null || (root = fragmentPlayerBinding.playerRoot) == null) {
            return;
        }
        int surface = MaterialColors.getColor(root, com.google.android.material.R.attr.colorSurface);
        if (color != null) {
            int it2 = color.intValue();
            it = CoverColors.INSTANCE.withAlpha(it2, 0.85f);
        } else {
            it = surface;
        }
        root.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtils.compositeColors(it, surface), surface, surface}));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }
}
