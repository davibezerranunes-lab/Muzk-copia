package com.muzk.app.ui.home;

import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.muzk.app.R;
import com.muzk.app.data.ModelsKt;
import com.muzk.app.databinding.FragmentHomeBinding;
import com.muzk.app.playback.PlayerViewModel;
import com.muzk.app.ui.library.LibraryTab;
import com.muzk.app.ui.library.LibraryViewModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020*H\u0016J&\u0010.\u001a\u00020*2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001aH\u0002J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u000203H\u0002J\b\u0010:\u001a\u00020*H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001a0\u001a0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006;"}, d2 = {"Lcom/muzk/app/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/muzk/app/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/muzk/app/databinding/FragmentHomeBinding;", "vm", "Lcom/muzk/app/ui/home/HomeViewModel;", "getVm", "()Lcom/muzk/app/ui/home/HomeViewModel;", "vm$delegate", "Lkotlin/Lazy;", "library", "Lcom/muzk/app/ui/library/LibraryViewModel;", "getLibrary", "()Lcom/muzk/app/ui/library/LibraryViewModel;", "library$delegate", "player", "Lcom/muzk/app/playback/PlayerViewModel;", "getPlayer", "()Lcom/muzk/app/playback/PlayerViewModel;", "player$delegate", "audioPermission", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "mediaObserver", "com/muzk/app/ui/home/HomeFragment$mediaObserver$1", "Lcom/muzk/app/ui/home/HomeFragment$mediaObserver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "playFrom", "items", "", "Lcom/muzk/app/ui/home/HomeTrack;", "index", "", "source", "openTile", "tile", "Lcom/muzk/app/ui/home/HomeTile;", "selectTab", TtmlNode.ATTR_ID, "onDestroyView", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HomeFragment extends Fragment {
    private FragmentHomeBinding _binding;
    private final String audioPermission;

    /* JADX INFO: renamed from: library$delegate, reason: from kotlin metadata */
    private final Lazy library;
    private final HomeFragment$mediaObserver$1 mediaObserver;
    private final ActivityResultLauncher<String> permissionLauncher;

    /* JADX INFO: renamed from: player$delegate, reason: from kotlin metadata */
    private final Lazy player;

    /* JADX INFO: renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;

    /* JADX INFO: compiled from: HomeFragment.kt */
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
                iArr[HomeTile.Kind.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HomeTile.Kind.RECENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.muzk.app.ui.home.HomeFragment$mediaObserver$1] */
    public HomeFragment() {
        final HomeFragment $this$viewModels_u24default$iv = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Function0 extrasProducer$iv = null;
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        this.vm = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m93viewModels$lambda1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = extrasProducer$iv;
                if (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) {
                    ViewModelStoreOwner viewModelStoreOwnerM93viewModels$lambda1 = FragmentViewModelLazyKt.m93viewModels$lambda1(owner$delegate$iv);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM93viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM93viewModels$lambda1 : null;
                    return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM93viewModels$lambda1 = FragmentViewModelLazyKt.m93viewModels$lambda1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM93viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM93viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
        final HomeFragment $this$activityViewModels_u24default$iv = this;
        final Function0 extrasProducer$iv2 = null;
        this.library = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = extrasProducer$iv2;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        final HomeFragment $this$activityViewModels_u24default$iv2 = this;
        final Function0 extrasProducer$iv3 = null;
        this.player = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv2, Reflection.getOrCreateKotlinClass(PlayerViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$activityViewModels_u24default$iv2.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = extrasProducer$iv3;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? $this$activityViewModels_u24default$iv2.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.home.HomeFragment$special$$inlined$activityViewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$activityViewModels_u24default$iv2.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.audioPermission = Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_AUDIO" : "android.permission.READ_EXTERNAL_STORAGE";
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.muzk.app.ui.home.HomeFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeFragment.permissionLauncher$lambda$0(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = activityResultLauncherRegisterForActivityResult;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mediaObserver = new ContentObserver(handler) { // from class: com.muzk.app.ui.home.HomeFragment$mediaObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                if (this.this$0.getVm().getState().getValue().getHasPermission()) {
                    this.this$0.getVm().reload();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentHomeBinding getBinding() {
        FragmentHomeBinding fragmentHomeBinding = this._binding;
        Intrinsics.checkNotNull(fragmentHomeBinding);
        return fragmentHomeBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeViewModel getVm() {
        return (HomeViewModel) this.vm.getValue();
    }

    private final LibraryViewModel getLibrary() {
        return (LibraryViewModel) this.library.getValue();
    }

    private final PlayerViewModel getPlayer() {
        return (PlayerViewModel) this.player.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void permissionLauncher$lambda$0(HomeFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getVm().setPermission(it.booleanValue());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentHomeBinding.inflate(inflater, container, false);
        NestedScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        TextView textView = getBinding().greeting;
        int i2 = Calendar.getInstance().get(11);
        if (5 <= i2 && i2 < 12) {
            i = R.string.greeting_morning;
        } else {
            i = 12 <= i2 && i2 < 18 ? R.string.greeting_afternoon : R.string.greeting_evening;
        }
        textView.setText(getString(i));
        HomeTileAdapter tiles = new HomeTileAdapter(new HomeFragment$onViewCreated$tiles$1(this));
        getBinding().tiles.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        getBinding().tiles.setAdapter(tiles);
        HomeTrackAdapter top = new HomeTrackAdapter(new Function1() { // from class: com.muzk.app.ui.home.HomeFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeFragment.onViewCreated$lambda$1(this.f$0, ((Integer) obj).intValue());
            }
        });
        getBinding().topList.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().topList.setAdapter(top);
        getBinding().emptyAction.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.home.HomeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        getBinding().goSearch.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.home.HomeFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeFragment.onViewCreated$lambda$3(this.f$0, view2);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass3(tiles, top, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(HomeFragment this$0, int index) {
        List<HomeTrack> mostPlayed = this$0.getVm().getState().getValue().getMostPlayed();
        String string = this$0.getString(R.string.home_most_played);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this$0.playFrom(mostPlayed, index, string);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(HomeFragment this$0, View it) {
        this$0.permissionLauncher.launch(this$0.audioPermission);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(HomeFragment this$0, View it) {
        this$0.selectTab(R.id.searchFragment);
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.home.HomeFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.home.HomeFragment$onViewCreated$3", f = "HomeFragment.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HomeTileAdapter $tiles;
        final /* synthetic */ HomeTrackAdapter $top;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(HomeTileAdapter homeTileAdapter, HomeTrackAdapter homeTrackAdapter, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$tiles = homeTileAdapter;
            this.$top = homeTrackAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeFragment.this.new AnonymousClass3(this.$tiles, this.$top, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.muzk.app.ui.home.HomeFragment$onViewCreated$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: HomeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "com.muzk.app.ui.home.HomeFragment$onViewCreated$3$1", f = "HomeFragment.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ HomeTileAdapter $tiles;
            final /* synthetic */ HomeTrackAdapter $top;
            int label;
            final /* synthetic */ HomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(HomeFragment homeFragment, HomeTileAdapter homeTileAdapter, HomeTrackAdapter homeTrackAdapter, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = homeFragment;
                this.$tiles = homeTileAdapter;
                this.$top = homeTrackAdapter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$tiles, this.$top, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        StateFlow<HomeUiState> state = this.this$0.getVm().getState();
                        final HomeTileAdapter homeTileAdapter = this.$tiles;
                        final HomeTrackAdapter homeTrackAdapter = this.$top;
                        final HomeFragment homeFragment = this.this$0;
                        this.label = 1;
                        if (state.collect(new FlowCollector() { // from class: com.muzk.app.ui.home.HomeFragment.onViewCreated.3.1.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((HomeUiState) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(HomeUiState s, Continuation<? super Unit> continuation) {
                                homeTileAdapter.submitList(s.getTiles());
                                homeTrackAdapter.submitList(s.getMostPlayed());
                                View tiles = homeFragment.getBinding().tiles;
                                Intrinsics.checkNotNullExpressionValue(tiles, "tiles");
                                View $this$isVisible$iv = tiles;
                                boolean value$iv = !s.getTiles().isEmpty();
                                $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
                                View topTitle = homeFragment.getBinding().topTitle;
                                Intrinsics.checkNotNullExpressionValue(topTitle, "topTitle");
                                View $this$isVisible$iv2 = topTitle;
                                boolean value$iv2 = !s.getMostPlayed().isEmpty();
                                $this$isVisible$iv2.setVisibility(value$iv2 ? 0 : 8);
                                boolean empty = !s.getHasPermission() || (s.getLoaded() && s.getTiles().isEmpty() && s.getMostPlayed().isEmpty());
                                View empty2 = homeFragment.getBinding().empty;
                                Intrinsics.checkNotNullExpressionValue(empty2, "empty");
                                View $this$isVisible$iv3 = empty2;
                                $this$isVisible$iv3.setVisibility(empty ? 0 : 8);
                                homeFragment.getBinding().emptyText.setText(!s.getHasPermission() ? R.string.lib_no_permission : R.string.home_empty);
                                View emptyAction = homeFragment.getBinding().emptyAction;
                                Intrinsics.checkNotNullExpressionValue(emptyAction, "emptyAction");
                                View $this$isVisible$iv4 = emptyAction;
                                boolean value$iv3 = true ^ s.getHasPermission();
                                $this$isVisible$iv4.setVisibility(value$iv3 ? 0 : 8);
                                View goSearch = homeFragment.getBinding().goSearch;
                                Intrinsics.checkNotNullExpressionValue(goSearch, "goSearch");
                                View $this$isVisible$iv5 = goSearch;
                                boolean value$iv4 = s.getHasPermission();
                                $this$isVisible$iv5.setVisibility(value$iv4 ? 0 : 8);
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LifecycleOwner viewLifecycleOwner = HomeFragment.this.getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(HomeFragment.this, this.$tiles, this.$top, null), this) == coroutine_suspended) {
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

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        boolean granted = ContextCompat.checkSelfPermission(requireContext(), this.audioPermission) == 0;
        getVm().setPermission(granted);
        if (!granted && !getVm().getAskedPermission()) {
            getVm().setAskedPermission(true);
            this.permissionLauncher.launch(this.audioPermission);
        }
        requireContext().getContentResolver().registerContentObserver(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, true, this.mediaObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        requireContext().getContentResolver().unregisterContentObserver(this.mediaObserver);
        super.onStop();
    }

    private final void playFrom(List<HomeTrack> items, int index, String source) {
        boolean z = false;
        if (index >= 0 && index < items.size()) {
            z = true;
        }
        if (!z) {
            return;
        }
        PlayerViewModel player = getPlayer();
        List<HomeTrack> $this$map$iv = items;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            HomeTrack it = (HomeTrack) item$iv$iv;
            destination$iv$iv.add(ModelsKt.toMediaItem(it.getTrack()));
        }
        player.playQueue((List) destination$iv$iv, index, source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openTile(HomeTile tile) {
        switch (WhenMappings.$EnumSwitchMapping$0[tile.getKind().ordinal()]) {
            case 1:
                getLibrary().selectTab(LibraryTab.PLAYLISTS);
                getLibrary().openPlaylist(tile.getKey());
                break;
            case 2:
                getLibrary().selectTab(LibraryTab.FOLDERS);
                getLibrary().openFolder(tile.getKey());
                break;
            case 3:
                getLibrary().selectTab(LibraryTab.TRACKS);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        selectTab(R.id.libraryFragment);
    }

    private final void selectTab(int id) {
        ((BottomNavigationView) requireActivity().findViewById(R.id.bottom_nav)).setSelectedItemId(id);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        getBinding().tiles.setAdapter(null);
        getBinding().topList.setAdapter(null);
        this._binding = null;
        super.onDestroyView();
    }
}
