package com.muzk.app.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.ActivityKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.BottomNavigationViewKt;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import coil.Coil;
import coil.ImageLoader;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;
import com.muzk.app.R;
import com.muzk.app.data.LocalMusicRepository;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.ModelsKt;
import com.muzk.app.databinding.ActivityMainBinding;
import com.muzk.app.databinding.ViewMiniPlayerBinding;
import com.muzk.app.download.DownloadWorker;
import com.muzk.app.download.Downloads;
import com.muzk.app.playback.PlayerUiState;
import com.muzk.app.playback.PlayerViewModel;
import com.muzk.app.ui.search.SearchViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0015H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0002J\u0017\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0017H\u0002J\u0012\u0010/\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u00100\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/muzk/app/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/muzk/app/databinding/ActivityMainBinding;", "navController", "Landroidx/navigation/NavController;", "player", "Lcom/muzk/app/playback/PlayerViewModel;", "getPlayer", "()Lcom/muzk/app/playback/PlayerViewModel;", "player$delegate", "Lkotlin/Lazy;", "search", "Lcom/muzk/app/ui/search/SearchViewModel;", "getSearch", "()Lcom/muzk/app/ui/search/SearchViewModel;", "search$delegate", "notificationPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onSupportNavigateUp", "", "setupMiniPlayer", "celebrated", "", "Ljava/util/UUID;", "downloadsPrimed", "watchDownloads", "playDownloaded", DownloadWorker.KEY_TITLE, "renderMiniPlayer", CmcdData.Factory.STREAMING_FORMAT_SS, "Lcom/muzk/app/playback/PlayerUiState;", "tintMiniPlayer", "color", "", "(Ljava/lang/Integer;)V", "openPlayer", "handleIntent", "askNotificationPermission", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MainActivity extends AppCompatActivity {
    public static final String EXTRA_OPEN_PLAYER = "open_player";
    private ActivityMainBinding binding;
    private boolean downloadsPrimed;
    private NavController navController;

    /* JADX INFO: renamed from: player$delegate, reason: from kotlin metadata */
    private final Lazy player;

    /* JADX INFO: renamed from: search$delegate, reason: from kotlin metadata */
    private final Lazy search;
    private final ActivityResultLauncher<String> notificationPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda8
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity.notificationPermission$lambda$0(((Boolean) obj).booleanValue());
        }
    });
    private final Set<UUID> celebrated = new LinkedHashSet();

    public MainActivity() {
        final MainActivity $this$viewModels_u24default$iv = this;
        final Function0 extrasProducer$iv = null;
        this.player = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PlayerViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.MainActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.MainActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        final MainActivity $this$viewModels_u24default$iv2 = this;
        final Function0 extrasProducer$iv2 = null;
        this.search = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SearchViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.MainActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$viewModels_u24default$iv2.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.MainActivity$special$$inlined$viewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$viewModels_u24default$iv2.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.MainActivity$special$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv2.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayerViewModel getPlayer() {
        return (PlayerViewModel) this.player.getValue();
    }

    private final SearchViewModel getSearch() {
        return (SearchViewModel) this.search.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notificationPermission$lambda$0(boolean it) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Integer numOverlay = AppPalette.INSTANCE.overlay(this);
        if (numOverlay != null) {
            int it = numOverlay.intValue();
            getTheme().applyStyle(it, true);
        }
        NavController navController = null;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        setContentView(activityMainBinding.root);
        ActivityMainBinding activityMainBinding2 = this.binding;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding2 = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(activityMainBinding2.root, new OnApplyWindowInsetsListener() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda6
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.onCreate$lambda$2(view, windowInsetsCompat);
            }
        });
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding3 = null;
        }
        setSupportActionBar(activityMainBinding3.toolbar);
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.nav_host);
        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavHostFragment host = (NavHostFragment) fragmentFindFragmentById;
        this.navController = host.getNavController();
        Set topLevelDestinationIds$iv = SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(R.id.homeFragment), Integer.valueOf(R.id.searchFragment), Integer.valueOf(R.id.libraryFragment), Integer.valueOf(R.id.settingsFragment)});
        Function0 fallbackOnNavigateUpListener$iv = new Function0<Boolean>() { // from class: com.muzk.app.ui.MainActivity$onCreate$$inlined$AppBarConfiguration$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        };
        AppBarConfiguration topLevel = new AppBarConfiguration.Builder((Set<Integer>) topLevelDestinationIds$iv).setOpenableLayout(null).setFallbackOnNavigateUpListener(new MainActivity$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener$iv)).build();
        MainActivity mainActivity = this;
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        ActivityKt.setupActionBarWithNavController(mainActivity, navController2, topLevel);
        ActivityMainBinding activityMainBinding4 = this.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding4 = null;
        }
        BottomNavigationView bottomNav = activityMainBinding4.bottomNav;
        Intrinsics.checkNotNullExpressionValue(bottomNav, "bottomNav");
        BottomNavigationView bottomNavigationView = bottomNav;
        NavController navController3 = this.navController;
        if (navController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController3 = null;
        }
        BottomNavigationViewKt.setupWithNavController(bottomNavigationView, navController3);
        ActivityMainBinding activityMainBinding5 = this.binding;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding5 = null;
        }
        activityMainBinding5.bottomNav.setItemActiveIndicatorEnabled(false);
        NavController navController4 = this.navController;
        if (navController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
        } else {
            navController = navController4;
        }
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda7
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController5, NavDestination navDestination, Bundle bundle) {
                MainActivity.onCreate$lambda$3(this.f$0, navController5, navDestination, bundle);
            }
        });
        setupMiniPlayer();
        watchDownloads();
        askNotificationPermission();
        handleIntent(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$2(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(bars, "getInsets(...)");
        v.setPadding(bars.left, bars.top, bars.right, 0);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(MainActivity this$0, NavController navController, NavDestination dest, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "<unused var>");
        Intrinsics.checkNotNullParameter(dest, "dest");
        boolean fullPlayer = dest.getId() == R.id.playerFragment;
        ActivityMainBinding activityMainBinding = this$0.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        View toolbar = activityMainBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        View $this$isVisible$iv = toolbar;
        boolean value$iv = (fullPlayer || dest.getId() == R.id.homeFragment) ? false : true;
        $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
        ActivityMainBinding activityMainBinding3 = this$0.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding3;
        }
        View bottomNav = activityMainBinding2.bottomNav;
        Intrinsics.checkNotNullExpressionValue(bottomNav, "bottomNav");
        View $this$isVisible$iv2 = bottomNav;
        boolean value$iv2 = fullPlayer ? false : true;
        $this$isVisible$iv2.setVisibility(value$iv2 ? 0 : 8);
        this$0.renderMiniPlayer(this$0.getPlayer().getState().getValue());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    private final void setupMiniPlayer() {
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        ViewMiniPlayerBinding miniPlayer = activityMainBinding.miniPlayer;
        Intrinsics.checkNotNullExpressionValue(miniPlayer, "miniPlayer");
        miniPlayer.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openPlayer();
            }
        });
        miniPlayer.miniPlay.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupMiniPlayer$lambda$5(this.f$0, view);
            }
        });
        miniPlayer.miniNext.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupMiniPlayer$lambda$6(this.f$0, view);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass4(miniPlayer, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupMiniPlayer$lambda$5(MainActivity this$0, View it) {
        this$0.getPlayer().togglePlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupMiniPlayer$lambda$6(MainActivity this$0, View it) {
        this$0.getPlayer().next();
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.MainActivity$setupMiniPlayer$4, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.MainActivity$setupMiniPlayer$4", f = "MainActivity.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewMiniPlayerBinding $mini;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ViewMiniPlayerBinding viewMiniPlayerBinding, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$mini = viewMiniPlayerBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new AnonymousClass4(this.$mini, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.muzk.app.ui.MainActivity$setupMiniPlayer$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "com.muzk.app.ui.MainActivity$setupMiniPlayer$4$1", f = "MainActivity.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ViewMiniPlayerBinding $mini;
            int label;
            final /* synthetic */ MainActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MainActivity mainActivity, ViewMiniPlayerBinding viewMiniPlayerBinding, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mainActivity;
                this.$mini = viewMiniPlayerBinding;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$mini, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [T, kotlin.Unit] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Ref.ObjectRef lastCover = new Ref.ObjectRef();
                        lastCover.element = Unit.INSTANCE;
                        StateFlow<PlayerUiState> state = this.this$0.getPlayer().getState();
                        final MainActivity mainActivity = this.this$0;
                        final ViewMiniPlayerBinding viewMiniPlayerBinding = this.$mini;
                        this.label = 1;
                        if (state.collect(new FlowCollector() { // from class: com.muzk.app.ui.MainActivity.setupMiniPlayer.4.1.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((PlayerUiState) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(PlayerUiState playerUiState, Continuation<? super Unit> continuation) {
                                mainActivity.renderMiniPlayer(playerUiState);
                                if (!Intrinsics.areEqual(playerUiState.getCover(), lastCover.element)) {
                                    lastCover.element = (T) playerUiState.getCover();
                                    ShapeableImageView miniCover = viewMiniPlayerBinding.miniCover;
                                    Intrinsics.checkNotNullExpressionValue(miniCover, "miniCover");
                                    ShapeableImageView shapeableImageView = miniCover;
                                    Object cover = playerUiState.getCover();
                                    final MainActivity mainActivity2 = mainActivity;
                                    ImageLoader imageLoader = Coil.imageLoader(shapeableImageView.getContext());
                                    ImageRequest.Builder builderTarget = new ImageRequest.Builder(shapeableImageView.getContext()).data(cover).target(shapeableImageView);
                                    builderTarget.placeholder(R.drawable.cover_placeholder);
                                    builderTarget.error(R.drawable.cover_placeholder);
                                    builderTarget.allowHardware(false);
                                    builderTarget.listener(new ImageRequest.Listener(mainActivity2) { // from class: com.muzk.app.ui.MainActivity$setupMiniPlayer$4$1$1$emit$lambda$2$$inlined$listener$default$1
                                        @Override // coil.request.ImageRequest.Listener
                                        public void onStart(ImageRequest request) {
                                        }

                                        @Override // coil.request.ImageRequest.Listener
                                        public void onCancel(ImageRequest request) {
                                        }

                                        @Override // coil.request.ImageRequest.Listener
                                        public void onError(ImageRequest request, ErrorResult result) {
                                            this.this$0.tintMiniPlayer(null);
                                        }

                                        @Override // coil.request.ImageRequest.Listener
                                        public void onSuccess(ImageRequest request, SuccessResult result) {
                                            this.this$0.tintMiniPlayer(CoverColors.INSTANCE.extract(result.getDrawable()));
                                        }
                                    });
                                    imageLoader.enqueue(builderTarget.build());
                                }
                                String error = playerUiState.getError();
                                if (error != null) {
                                    MainActivity mainActivity3 = mainActivity;
                                    ActivityMainBinding activityMainBinding = mainActivity3.binding;
                                    ActivityMainBinding activityMainBinding2 = null;
                                    if (activityMainBinding == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                        activityMainBinding = null;
                                    }
                                    Snackbar snackbarMake = Snackbar.make(activityMainBinding.root, error, 0);
                                    ActivityMainBinding activityMainBinding3 = mainActivity3.binding;
                                    if (activityMainBinding3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                    } else {
                                        activityMainBinding2 = activityMainBinding3;
                                    }
                                    snackbarMake.setAnchorView(activityMainBinding2.bottomNav).show();
                                    mainActivity3.getPlayer().clearError();
                                }
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
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(MainActivity.this, Lifecycle.State.STARTED, new AnonymousClass1(MainActivity.this, this.$mini, null), this) == coroutine_suspended) {
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

    private final void watchDownloads() {
        WorkManager.INSTANCE.getInstance(this).getWorkInfosByTagLiveData(Downloads.TAG).observe(this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.watchDownloads$lambda$12(this.f$0, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit watchDownloads$lambda$12(final MainActivity this$0, List infos) {
        FrameLayout bottomNav;
        Intrinsics.checkNotNull(infos);
        List $this$filter$iv = infos;
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$filter$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            WorkInfo it2 = (WorkInfo) element$iv$iv;
            if (it2.getState() == WorkInfo.State.SUCCEEDED) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable done = (List) destination$iv$iv;
        if (!this$0.downloadsPrimed) {
            this$0.downloadsPrimed = true;
            Iterable $this$forEach$iv = done;
            for (Object element$iv : $this$forEach$iv) {
                WorkInfo it3 = (WorkInfo) element$iv;
                this$0.celebrated.add(it3.getId());
            }
            return Unit.INSTANCE;
        }
        Iterable $this$filter$iv2 = done;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            WorkInfo it4 = (WorkInfo) element$iv$iv2;
            if (this$0.celebrated.add(it4.getId())) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        Iterable $this$forEach$iv2 = (List) destination$iv$iv2;
        for (Object element$iv2 : $this$forEach$iv2) {
            WorkInfo info = (WorkInfo) element$iv2;
            final String title = info.getOutputData().getString(DownloadWorker.KEY_TITLE);
            if (title != null) {
                ActivityMainBinding activityMainBinding = this$0.binding;
                ActivityMainBinding activityMainBinding2 = null;
                if (activityMainBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityMainBinding = null;
                }
                Snackbar snackbarMake = Snackbar.make(activityMainBinding.root, this$0.getString(R.string.dl_finished_snack, new Object[]{title}), 0);
                ActivityMainBinding activityMainBinding3 = this$0.binding;
                if (activityMainBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityMainBinding3 = null;
                }
                View root = activityMainBinding3.miniPlayer.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                View $this$isVisible$iv = root;
                if ($this$isVisible$iv.getVisibility() == 0) {
                    ActivityMainBinding activityMainBinding4 = this$0.binding;
                    if (activityMainBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding2 = activityMainBinding4;
                    }
                    bottomNav = activityMainBinding2.miniPlayer.getRoot();
                    Intrinsics.checkNotNullExpressionValue(bottomNav, "getRoot(...)");
                } else {
                    ActivityMainBinding activityMainBinding5 = this$0.binding;
                    if (activityMainBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMainBinding2 = activityMainBinding5;
                    }
                    bottomNav = activityMainBinding2.bottomNav;
                    Intrinsics.checkNotNullExpressionValue(bottomNav, "bottomNav");
                }
                snackbarMake.setAnchorView(bottomNav).setAction(R.string.play, new View.OnClickListener() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.playDownloaded(title);
                    }
                }).show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.MainActivity$playDownloaded$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.MainActivity$playDownloaded$1", f = "MainActivity.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $title;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$title = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new AnonymousClass1(this.$title, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0059  */
        /* JADX WARN: Code duplicated, block: B:23:0x0067  */
        /* JADX WARN: Code duplicated, block: B:26:0x0072  */
        /* JADX WARN: Code duplicated, block: B:29:0x008c  */
        /* JADX WARN: Code duplicated, block: B:35:0x009c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object maxElem$iv;
            Object element$iv;
            LocalTrack localTrack;
            LocalTrack match;
            Iterator iterator$iv;
            long maxValue$iv;
            Object e$iv;
            long v$iv;
            LocalTrack it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object objLoadTracks = LocalMusicRepository.INSTANCE.loadTracks(MainActivity.this, this);
                    if (objLoadTracks == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objLoadTracks;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterable tracks = (List) $result;
            Iterable $this$firstOrNull$iv = tracks;
            String str = this.$title;
            Iterator it2 = $this$firstOrNull$iv.iterator();
            do {
                maxElem$iv = null;
                if (it2.hasNext()) {
                    element$iv = it2.next();
                    it = (LocalTrack) element$iv;
                } else {
                    element$iv = null;
                }
                localTrack = (LocalTrack) element$iv;
                if (localTrack == null) {
                    Iterable $this$maxByOrNull$iv = tracks;
                    iterator$iv = $this$maxByOrNull$iv.iterator();
                    if (iterator$iv.hasNext()) {
                        maxElem$iv = iterator$iv.next();
                        if (iterator$iv.hasNext()) {
                            LocalTrack it3 = (LocalTrack) maxElem$iv;
                            maxValue$iv = it3.getDateAdded();
                            do {
                                e$iv = iterator$iv.next();
                                LocalTrack it4 = (LocalTrack) e$iv;
                                v$iv = it4.getDateAdded();
                                if (maxValue$iv < v$iv) {
                                    maxValue$iv = v$iv;
                                    maxElem$iv = e$iv;
                                }
                            } while (iterator$iv.hasNext());
                        }
                    }
                    localTrack = (LocalTrack) maxElem$iv;
                }
                match = localTrack;
                if (match != null) {
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.getPlayer().playQueue(CollectionsKt.listOf(ModelsKt.toMediaItem(match)), 0, mainActivity.getString(R.string.source_downloads));
                }
                return Unit.INSTANCE;
            } while (!StringsKt.equals(it.getTitle(), str, true));
            localTrack = (LocalTrack) element$iv;
            if (localTrack == null) {
                Iterable $this$maxByOrNull$iv2 = tracks;
                iterator$iv = $this$maxByOrNull$iv2.iterator();
                if (iterator$iv.hasNext()) {
                    maxElem$iv = iterator$iv.next();
                    if (iterator$iv.hasNext()) {
                        LocalTrack it5 = (LocalTrack) maxElem$iv;
                        maxValue$iv = it5.getDateAdded();
                        do {
                            e$iv = iterator$iv.next();
                            LocalTrack it6 = (LocalTrack) e$iv;
                            v$iv = it6.getDateAdded();
                            if (maxValue$iv < v$iv) {
                                maxValue$iv = v$iv;
                                maxElem$iv = e$iv;
                            }
                        } while (iterator$iv.hasNext());
                    }
                }
                localTrack = (LocalTrack) maxElem$iv;
            }
            match = localTrack;
            if (match != null) {
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.getPlayer().playQueue(CollectionsKt.listOf(ModelsKt.toMediaItem(match)), 0, mainActivity2.getString(R.string.source_downloads));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playDownloaded(String title) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(title, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderMiniPlayer(PlayerUiState s) {
        NavController navController = this.navController;
        ActivityMainBinding activityMainBinding = null;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavDestination currentDestination = navController.getCurrentDestination();
        boolean onPlayerScreen = currentDestination != null && currentDestination.getId() == R.id.playerFragment;
        ActivityMainBinding activityMainBinding2 = this.binding;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding2;
        }
        ViewMiniPlayerBinding miniPlayer = activityMainBinding.miniPlayer;
        Intrinsics.checkNotNullExpressionValue(miniPlayer, "miniPlayer");
        View root = miniPlayer.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        View $this$isVisible$iv = root;
        boolean value$iv = s.getHasMedia() && !onPlayerScreen;
        $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
        miniPlayer.miniTitle.setText(s.getTitle());
        miniPlayer.miniArtist.setText(s.getArtist());
        miniPlayer.miniPlay.setIconResource(s.isPlaying() ? R.drawable.ic_pause : R.drawable.ic_play);
        miniPlayer.miniProgress.setIndeterminate(false);
        miniPlayer.miniProgress.setProgress(s.getDurationMs() > 0 ? (int) ((s.getPositionMs() * ((long) 1000)) / s.getDurationMs()) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tintMiniPlayer(Integer color) {
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        MaterialCardView card = activityMainBinding.miniPlayer.getRoot();
        Intrinsics.checkNotNullExpressionValue(card, "getRoot(...)");
        int base = MaterialColors.getColor(card, com.google.android.material.R.attr.colorSurfaceContainerHigh);
        card.setCardBackgroundColor(color == null ? base : ColorUtils.blendARGB(base, color.intValue(), 0.45f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPlayer() {
        NavController navController = this.navController;
        NavController navController2 = null;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavDestination currentDestination = navController.getCurrentDestination();
        boolean z = false;
        if (currentDestination != null && currentDestination.getId() == R.id.playerFragment) {
            z = true;
        }
        if (!z) {
            NavController navController3 = this.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController2 = navController3;
            }
            navController2.navigate(R.id.action_open_player);
        }
    }

    private final void handleIntent(Intent intent) {
        String text;
        String url;
        if (intent == null) {
            return;
        }
        ActivityMainBinding activityMainBinding = null;
        if (intent.getBooleanExtra(EXTRA_OPEN_PLAYER, false)) {
            intent.removeExtra(EXTRA_OPEN_PLAYER);
            ActivityMainBinding activityMainBinding2 = this.binding;
            if (activityMainBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMainBinding2 = null;
            }
            activityMainBinding2.root.post(new Runnable() { // from class: com.muzk.app.ui.MainActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.handleIntent$lambda$13(this.f$0);
                }
            });
        }
        if (!Intrinsics.areEqual(intent.getAction(), "android.intent.action.SEND") || (text = intent.getStringExtra("android.intent.extra.TEXT")) == null) {
            return;
        }
        MatchResult matchResultFind$default = Regex.find$default(new Regex("https?://\\S+"), text, 0, 2, null);
        if (matchResultFind$default == null || (url = matchResultFind$default.getValue()) == null) {
            url = text;
        }
        intent.setAction(null);
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding3;
        }
        activityMainBinding.bottomNav.setSelectedItemId(R.id.searchFragment);
        getSearch().search(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleIntent$lambda$13(MainActivity this$0) {
        if (this$0.getPlayer().getState().getValue().getHasMedia()) {
            this$0.openPlayer();
        }
    }

    private final void askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            this.notificationPermission.launch("android.permission.POST_NOTIFICATIONS");
        }
    }
}
