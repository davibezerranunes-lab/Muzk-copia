package com.muzk.app.ui.library;

import android.app.PendingIntent;
import android.app.RecoverableSecurityException;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.muzk.app.R;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.ModelsKt;
import com.muzk.app.data.Playlist;
import com.muzk.app.databinding.DialogTextInputBinding;
import com.muzk.app.databinding.FragmentLibraryBinding;
import com.muzk.app.playback.PlayerViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: LibraryFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u001e!\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00104\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00152\u0006\u00101\u001a\u000202H\u0002J\u0018\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020$H\u0002J\u0018\u0010=\u001a\u00020,2\u0006\u0010:\u001a\u00020>2\u0006\u0010<\u001a\u00020$H\u0002J\u0016\u0010?\u001a\u00020,2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002070AH\u0002J,\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u00152\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,0FH\u0002J\u0016\u0010G\u001a\u00020,2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002070AH\u0002J\u0016\u0010H\u001a\u00020,2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002070AH\u0002J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u0015H\u0002J\b\u0010K\u001a\u00020,H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00150\u00150\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001c0\u001c0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"¨\u0006M"}, d2 = {"Lcom/muzk/app/ui/library/LibraryFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/muzk/app/databinding/FragmentLibraryBinding;", "binding", "getBinding", "()Lcom/muzk/app/databinding/FragmentLibraryBinding;", "vm", "Lcom/muzk/app/ui/library/LibraryViewModel;", "getVm", "()Lcom/muzk/app/ui/library/LibraryViewModel;", "vm$delegate", "Lkotlin/Lazy;", "player", "Lcom/muzk/app/playback/PlayerViewModel;", "getPlayer", "()Lcom/muzk/app/playback/PlayerViewModel;", "player$delegate", "audioPermission", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "pendingDeleteCount", "", "deleteLauncher", "Landroidx/activity/result/IntentSenderRequest;", "mediaObserver", "com/muzk/app/ui/library/LibraryFragment$mediaObserver$1", "Lcom/muzk/app/ui/library/LibraryFragment$mediaObserver$1;", "backCallback", "com/muzk/app/ui/library/LibraryFragment$backCallback$1", "Lcom/muzk/app/ui/library/LibraryFragment$backCallback$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "renderEmpty", CmcdData.Factory.STREAMING_FORMAT_SS, "Lcom/muzk/app/ui/library/LibraryUiState;", "renderSelection", "renderFab", "playFrom", "track", "Lcom/muzk/app/data/LocalTrack;", "sourceName", "showTrackMenu", "row", "Lcom/muzk/app/ui/library/LibraryRow$Track;", "anchor", "showPlaylistMenu", "Lcom/muzk/app/ui/library/LibraryRow$PlaylistItem;", "pickPlaylist", "tracks", "", "askName", "titleRes", "initial", "onOk", "Lkotlin/Function1;", "confirmDelete", "deleteFiles", "snack", "text", "onDestroyView", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LibraryFragment extends Fragment {
    private FragmentLibraryBinding _binding;
    private final String audioPermission;
    private final LibraryFragment$backCallback$1 backCallback;
    private final ActivityResultLauncher<IntentSenderRequest> deleteLauncher;
    private final LibraryFragment$mediaObserver$1 mediaObserver;
    private int pendingDeleteCount;
    private final ActivityResultLauncher<String> permissionLauncher;

    /* JADX INFO: renamed from: player$delegate, reason: from kotlin metadata */
    private final Lazy player;

    /* JADX INFO: renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;
    private static final Map<LibraryTab, Integer> CHIPS = MapsKt.mapOf(TuplesKt.to(LibraryTab.PLAYLISTS, Integer.valueOf(R.id.chip_playlists)), TuplesKt.to(LibraryTab.TRACKS, Integer.valueOf(R.id.chip_tracks)), TuplesKt.to(LibraryTab.FOLDERS, Integer.valueOf(R.id.chip_folders)));

    /* JADX WARN: Type inference failed for: r0v14, types: [com.muzk.app.ui.library.LibraryFragment$backCallback$1] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.muzk.app.ui.library.LibraryFragment$mediaObserver$1] */
    public LibraryFragment() {
        final LibraryFragment $this$activityViewModels_u24default$iv = this;
        final Function0 extrasProducer$iv = null;
        this.vm = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.library.LibraryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.library.LibraryFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.library.LibraryFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        final LibraryFragment $this$activityViewModels_u24default$iv2 = this;
        final Function0 extrasProducer$iv2 = null;
        this.player = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv2, Reflection.getOrCreateKotlinClass(PlayerViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.library.LibraryFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$activityViewModels_u24default$iv2.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.library.LibraryFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv2.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.library.LibraryFragment$special$$inlined$activityViewModels$default$6
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
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda13
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LibraryFragment.permissionLauncher$lambda$0(this.f$0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<IntentSenderRequest> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda14
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LibraryFragment.deleteLauncher$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.deleteLauncher = activityResultLauncherRegisterForActivityResult2;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mediaObserver = new ContentObserver(handler) { // from class: com.muzk.app.ui.library.LibraryFragment$mediaObserver$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                if (this.this$0.getVm().getState().getValue().getHasPermission()) {
                    this.this$0.getVm().reload();
                }
            }
        };
        this.backCallback = new OnBackPressedCallback() { // from class: com.muzk.app.ui.library.LibraryFragment$backCallback$1
            {
                super(false);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.getVm().back();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLibraryBinding getBinding() {
        FragmentLibraryBinding fragmentLibraryBinding = this._binding;
        Intrinsics.checkNotNull(fragmentLibraryBinding);
        return fragmentLibraryBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryViewModel getVm() {
        return (LibraryViewModel) this.vm.getValue();
    }

    private final PlayerViewModel getPlayer() {
        return (PlayerViewModel) this.player.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void permissionLauncher$lambda$0(LibraryFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getVm().setPermission(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteLauncher$lambda$1(LibraryFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            this$0.getVm().clearSelection();
            if (this$0.pendingDeleteCount > 1) {
                String quantityString = this$0.getResources().getQuantityString(R.plurals.deleted_many, this$0.pendingDeleteCount, Integer.valueOf(this$0.pendingDeleteCount));
                Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                this$0.snack(quantityString);
            }
        }
        this$0.getVm().reload();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentLibraryBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, this.backCallback);
        LibraryAdapter adapter = new LibraryAdapter(new Function1() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryFragment.onViewCreated$lambda$2(this.f$0, (LibraryRow.Track) obj);
            }
        }, new Function2() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LibraryFragment.onViewCreated$lambda$3(this.f$0, (LibraryRow.Track) obj, (View) obj2);
            }
        }, new Function1() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryFragment.onViewCreated$lambda$4(this.f$0, (LibraryRow.Track) obj);
            }
        }, new Function1() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryFragment.onViewCreated$lambda$5(this.f$0, (LibraryRow.Folder) obj);
            }
        }, new Function1() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryFragment.onViewCreated$lambda$6(this.f$0, (LibraryRow.PlaylistItem) obj);
            }
        }, new Function2() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LibraryFragment.onViewCreated$lambda$7(this.f$0, (LibraryRow.PlaylistItem) obj, (View) obj2);
            }
        }, new Function0() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LibraryFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        getBinding().list.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().list.setAdapter(adapter);
        getBinding().chips.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda24
            @Override // com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
            public final void onCheckedChanged(ChipGroup chipGroup, List list) {
                LibraryFragment.onViewCreated$lambda$12(this.f$0, chipGroup, list);
            }
        });
        for (Map.Entry<LibraryTab, Integer> entry : CHIPS.entrySet()) {
            final LibraryTab tab = entry.getKey();
            int id = entry.getValue().intValue();
            getBinding().getRoot().findViewById(id).setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LibraryFragment.onViewCreated$lambda$14$lambda$13(this.f$0, tab, view2);
                }
            });
        }
        getBinding().selectionBar.inflateMenu(R.menu.library_selection);
        getBinding().selectionBar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LibraryFragment.onViewCreated$lambda$15(this.f$0, view2);
            }
        });
        getBinding().selectionBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda11
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return LibraryFragment.onViewCreated$lambda$18(this.f$0, menuItem);
            }
        });
        getBinding().emptyAction.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LibraryFragment.onViewCreated$lambda$19(this.f$0, view2);
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new AnonymousClass6(adapter, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(LibraryFragment this$0, LibraryRow.Track row) {
        Intrinsics.checkNotNullParameter(row, "row");
        if (row.getSelecting()) {
            this$0.getVm().toggleSelection(row.getTrack().getId());
        } else {
            this$0.playFrom(row.getTrack());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(LibraryFragment this$0, LibraryRow.Track row, View anchor) {
        Intrinsics.checkNotNullParameter(row, "row");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this$0.showTrackMenu(row, anchor);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(LibraryFragment this$0, LibraryRow.Track row) {
        Intrinsics.checkNotNullParameter(row, "row");
        this$0.getBinding().list.performHapticFeedback(0);
        this$0.getVm().toggleSelection(row.getTrack().getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(LibraryFragment this$0, LibraryRow.Folder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getVm().openFolder(it.getPath());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(LibraryFragment this$0, LibraryRow.PlaylistItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getVm().openPlaylist(it.getPlaylist().getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(LibraryFragment this$0, LibraryRow.PlaylistItem row, View anchor) {
        Intrinsics.checkNotNullParameter(row, "row");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this$0.showPlaylistMenu(row, anchor);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8(LibraryFragment this$0) {
        this$0.getVm().back();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12(LibraryFragment this$0, ChipGroup chipGroup, List ids) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(chipGroup, "<unused var>");
        Intrinsics.checkNotNullParameter(ids, "ids");
        Integer num = (Integer) CollectionsKt.firstOrNull(ids);
        if (num != null) {
            int id = num.intValue();
            Iterable $this$firstOrNull$iv = CHIPS.entrySet();
            Iterator it = $this$firstOrNull$iv.iterator();
            do {
                if (!it.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it.next();
            } while (!(((Number) ((Map.Entry) element$iv).getValue()).intValue() == id));
            Map.Entry it2 = (Map.Entry) element$iv;
            if (it2 != null) {
                this$0.getVm().selectTab((LibraryTab) it2.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$14$lambda$13(LibraryFragment this$0, LibraryTab $tab, View it) {
        if (this$0.getVm().getState().getValue().getTab() == $tab) {
            this$0.getVm().back();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$15(LibraryFragment this$0, View it) {
        this$0.getVm().clearSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$18(LibraryFragment this$0, MenuItem item) {
        LibraryUiState s = this$0.getVm().getState().getValue();
        int itemId = item.getItemId();
        if (itemId != R.id.sel_all) {
            if (itemId != R.id.sel_add) {
                if (itemId != R.id.sel_remove) {
                    if (itemId == R.id.sel_delete) {
                        this$0.confirmDelete(s.getSelected());
                        return true;
                    }
                    return true;
                }
                String id = s.getOpenPlaylistId();
                if (id != null) {
                    int n = s.getSelected().size();
                    LibraryViewModel vm = this$0.getVm();
                    Iterable $this$map$iv = s.getSelected();
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        LocalTrack it = (LocalTrack) item$iv$iv;
                        destination$iv$iv.add(Long.valueOf(it.getId()));
                    }
                    vm.removeAllFromPlaylist(id, (List) destination$iv$iv);
                    this$0.getVm().clearSelection();
                    String quantityString = this$0.getResources().getQuantityString(R.plurals.removed_many, n, Integer.valueOf(n));
                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                    this$0.snack(quantityString);
                    return true;
                }
                return true;
            }
            this$0.pickPlaylist(s.getSelected());
            return true;
        }
        this$0.getVm().selectAll();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$19(LibraryFragment this$0, View it) {
        this$0.permissionLauncher.launch(this$0.audioPermission);
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.library.LibraryFragment$onViewCreated$6, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.library.LibraryFragment$onViewCreated$6", f = "LibraryFragment.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LibraryAdapter $adapter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(LibraryAdapter libraryAdapter, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$adapter = libraryAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFragment.this.new AnonymousClass6(this.$adapter, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.muzk.app.ui.library.LibraryFragment$onViewCreated$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: LibraryFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "com.muzk.app.ui.library.LibraryFragment$onViewCreated$6$1", f = "LibraryFragment.kt", i = {}, l = {TarConstants.PREFIXLEN_XSTAR}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ LibraryAdapter $adapter;
            int label;
            final /* synthetic */ LibraryFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LibraryFragment libraryFragment, LibraryAdapter libraryAdapter, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = libraryFragment;
                this.$adapter = libraryAdapter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$adapter, continuation);
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
                        StateFlow<LibraryUiState> state = this.this$0.getVm().getState();
                        final LibraryAdapter libraryAdapter = this.$adapter;
                        final LibraryFragment libraryFragment = this.this$0;
                        this.label = 1;
                        if (state.collect(new FlowCollector() { // from class: com.muzk.app.ui.library.LibraryFragment.onViewCreated.6.1.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((LibraryUiState) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(LibraryUiState s, Continuation<? super Unit> continuation) {
                                Integer num = (Integer) LibraryFragment.CHIPS.get(s.getTab());
                                if (num != null) {
                                    LibraryFragment libraryFragment2 = libraryFragment;
                                    int id = num.intValue();
                                    if (libraryFragment2.getBinding().chips.getCheckedChipId() != id) {
                                        libraryFragment2.getBinding().chips.check(id);
                                    }
                                }
                                libraryAdapter.submitList(s.getRows());
                                setEnabled(s.isInside() || s.isSelecting());
                                libraryFragment.renderEmpty(s);
                                libraryFragment.renderFab(s);
                                libraryFragment.renderSelection(s);
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
                    LifecycleOwner viewLifecycleOwner = LibraryFragment.this.getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(LibraryFragment.this, this.$adapter, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:23:0x0057  */
    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    /* JADX WARN: Code duplicated, block: B:29:0x006e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    public final void renderEmpty(LibraryUiState s) {
        String emptyText;
        boolean z;
        if (!s.getHasPermission()) {
            emptyText = getString(R.string.lib_no_permission);
        } else if (s.getRows().isEmpty()) {
            if (!s.getLoaded()) {
                emptyText = null;
            } else if (s.getOpenPlaylistId() != null) {
                emptyText = getString(R.string.lib_empty_playlist);
            } else if (s.getTab() == LibraryTab.PLAYLISTS) {
                emptyText = getString(R.string.lib_empty_playlists);
            } else {
                emptyText = getString(R.string.lib_empty_tracks);
            }
        } else {
            Iterable $this$any$iv = s.getRows();
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        LibraryRow it2 = (LibraryRow) element$iv;
                        if (!(it2 instanceof LibraryRow.Header)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            if (z) {
                emptyText = null;
            } else if (!s.getLoaded()) {
                emptyText = null;
            } else if (s.getOpenPlaylistId() != null) {
                emptyText = getString(R.string.lib_empty_playlist);
            } else if (s.getTab() == LibraryTab.PLAYLISTS) {
                emptyText = getString(R.string.lib_empty_playlists);
            } else {
                emptyText = getString(R.string.lib_empty_tracks);
            }
        }
        View empty = getBinding().empty;
        Intrinsics.checkNotNullExpressionValue(empty, "empty");
        View $this$isVisible$iv = empty;
        boolean value$iv = emptyText != null;
        $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
        getBinding().emptyText.setText(emptyText);
        View emptyAction = getBinding().emptyAction;
        Intrinsics.checkNotNullExpressionValue(emptyAction, "emptyAction");
        View $this$isVisible$iv2 = emptyAction;
        boolean value$iv2 = true ^ s.getHasPermission();
        $this$isVisible$iv2.setVisibility(value$iv2 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSelection(LibraryUiState s) {
        View selectionBar = getBinding().selectionBar;
        Intrinsics.checkNotNullExpressionValue(selectionBar, "selectionBar");
        View $this$isVisible$iv = selectionBar;
        boolean value$iv = s.isSelecting();
        $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
        View tabs = getBinding().tabs;
        Intrinsics.checkNotNullExpressionValue(tabs, "tabs");
        View $this$isVisible$iv2 = tabs;
        boolean value$iv2 = !s.isSelecting();
        $this$isVisible$iv2.setVisibility(value$iv2 ? 0 : 8);
        if (s.isSelecting()) {
            getBinding().selectionBar.setTitle(getResources().getQuantityString(R.plurals.selected_count, s.getSelected().size(), Integer.valueOf(s.getSelected().size())));
            getBinding().selectionBar.getMenu().findItem(R.id.sel_remove).setVisible(s.getOpenPlaylistId() != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderFab(final LibraryUiState s) {
        ExtendedFloatingActionButton fab = getBinding().fab;
        Intrinsics.checkNotNullExpressionValue(fab, "fab");
        if (!s.getHasPermission() || s.isSelecting()) {
            fab.hide();
            return;
        }
        if (s.getTab() == LibraryTab.PLAYLISTS && s.getOpenPlaylistId() == null) {
            fab.setText(getString(R.string.new_playlist));
            fab.setIconResource(R.drawable.ic_add);
            fab.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibraryFragment.renderFab$lambda$22(this.f$0, view);
                }
            });
            fab.show();
            return;
        }
        if (!s.getQueue().isEmpty()) {
            fab.setText(getString(R.string.play_all));
            fab.setIconResource(R.drawable.ic_play);
            fab.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LibraryFragment.renderFab$lambda$24(this.f$0, s, view);
                }
            });
            fab.show();
            return;
        }
        fab.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderFab$lambda$22(final LibraryFragment this$0, View it) {
        this$0.askName(R.string.new_playlist, "", new Function1() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryFragment.renderFab$lambda$22$lambda$21(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderFab$lambda$22$lambda$21(LibraryFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getVm().createPlaylist(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderFab$lambda$24(LibraryFragment this$0, LibraryUiState $s, View it) {
        PlayerViewModel player = this$0.getPlayer();
        Iterable $this$map$iv = $s.getQueue();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LocalTrack it2 = (LocalTrack) item$iv$iv;
            destination$iv$iv.add(ModelsKt.toMediaItem(it2));
        }
        player.playQueue((List) destination$iv$iv, 0, this$0.sourceName($s));
    }

    private final void playFrom(LocalTrack track) {
        List<LocalTrack> queue = getVm().getState().getValue().getQueue();
        int index$iv = 0;
        Iterator<LocalTrack> it = queue.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                LocalTrack it2 = (LocalTrack) item$iv;
                if (it2.getId() == track.getId()) {
                    break;
                } else {
                    index$iv++;
                }
            } else {
                index$iv = -1;
                break;
            }
        }
        int index = RangesKt.coerceAtLeast(index$iv, 0);
        PlayerViewModel player = getPlayer();
        List<LocalTrack> $this$map$iv = queue;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LocalTrack it3 = (LocalTrack) item$iv$iv;
            destination$iv$iv.add(ModelsKt.toMediaItem(it3));
        }
        player.playQueue((List) destination$iv$iv, index, sourceName(getVm().getState().getValue()));
    }

    private final String sourceName(LibraryUiState s) {
        String title;
        Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) s.getRows());
        LibraryRow.Header header = objFirstOrNull instanceof LibraryRow.Header ? (LibraryRow.Header) objFirstOrNull : null;
        if (header != null && (title = header.getTitle()) != null) {
            return title;
        }
        String string = getString(R.string.source_all_tracks);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void showTrackMenu(final LibraryRow.Track row, View anchor) {
        PopupMenu popup = new PopupMenu(requireContext(), anchor);
        popup.getMenu().add(0, 1, 0, R.string.play_next);
        popup.getMenu().add(0, 2, 1, R.string.add_to_playlist);
        if (row.getPlaylistId() != null) {
            popup.getMenu().add(0, 3, 2, R.string.remove_from_playlist);
        }
        popup.getMenu().add(0, 4, 3, R.string.delete);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda7
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return LibraryFragment.showTrackMenu$lambda$27(this.f$0, row, menuItem);
            }
        });
        popup.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showTrackMenu$lambda$27(LibraryFragment this$0, LibraryRow.Track $row, MenuItem it) {
        switch (it.getItemId()) {
            case 1:
                this$0.getPlayer().playNext(ModelsKt.toMediaItem($row.getTrack()));
                break;
            case 2:
                this$0.pickPlaylist(CollectionsKt.listOf($row.getTrack()));
                break;
            case 3:
                LibraryViewModel vm = this$0.getVm();
                String playlistId = $row.getPlaylistId();
                Intrinsics.checkNotNull(playlistId);
                vm.removeFromPlaylist(playlistId, $row.getTrack().getId());
                break;
            case 4:
                this$0.confirmDelete(CollectionsKt.listOf($row.getTrack()));
                break;
        }
        return true;
    }

    private final void showPlaylistMenu(final LibraryRow.PlaylistItem row, View anchor) {
        PopupMenu popup = new PopupMenu(requireContext(), anchor);
        popup.getMenu().add(0, 1, 0, R.string.rename);
        popup.getMenu().add(0, 2, 1, R.string.delete);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda3
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return LibraryFragment.showPlaylistMenu$lambda$30(this.f$0, row, menuItem);
            }
        });
        popup.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPlaylistMenu$lambda$30(final LibraryFragment this$0, final LibraryRow.PlaylistItem $row, MenuItem it) {
        switch (it.getItemId()) {
            case 1:
                this$0.askName(R.string.rename, $row.getPlaylist().getName(), new Function1() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LibraryFragment.showPlaylistMenu$lambda$30$lambda$28(this.f$0, $row, (String) obj);
                    }
                });
                break;
            case 2:
                new MaterialAlertDialogBuilder(this$0.requireContext()).setMessage((CharSequence) this$0.getString(R.string.delete_playlist_confirm, $row.getPlaylist().getName())).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda12
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        LibraryFragment.showPlaylistMenu$lambda$30$lambda$29(this.f$0, $row, dialogInterface, i);
                    }
                }).show();
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPlaylistMenu$lambda$30$lambda$28(LibraryFragment this$0, LibraryRow.PlaylistItem $row, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this$0.getVm().renamePlaylist($row.getPlaylist().getId(), name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPlaylistMenu$lambda$30$lambda$29(LibraryFragment this$0, LibraryRow.PlaylistItem $row, DialogInterface dialogInterface, int i) {
        this$0.getVm().deletePlaylist($row.getPlaylist().getId());
    }

    private final void pickPlaylist(List<LocalTrack> tracks) {
        if (tracks.isEmpty()) {
            return;
        }
        List<LocalTrack> $this$map$iv = tracks;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LocalTrack it = (LocalTrack) item$iv$iv;
            destination$iv$iv.add(Long.valueOf(it.getId()));
        }
        final List ids = (List) destination$iv$iv;
        final List<Playlist> playlists = getVm().getState().getValue().getPlaylists();
        List<Playlist> $this$map$iv2 = playlists;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Playlist it2 = (Playlist) item$iv$iv2;
            destination$iv$iv2.add(it2.getName());
        }
        Collection $this$toTypedArray$iv = CollectionsKt.plus((Collection<? extends String>) destination$iv$iv2, getString(R.string.new_playlist));
        String[] names = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        new MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.add_to_playlist).setItems((CharSequence[]) names, new DialogInterface.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LibraryFragment.pickPlaylist$lambda$34(playlists, this, ids, dialogInterface, i);
            }
        }).show();
    }

    private static final void pickPlaylist$added(LibraryFragment this$0, List<Long> list, String name) {
        this$0.getVm().clearSelection();
        String string = list.size() == 1 ? this$0.getString(R.string.added_to, name) : this$0.getResources().getQuantityString(R.plurals.added_many_to, list.size(), Integer.valueOf(list.size()), name);
        Intrinsics.checkNotNull(string);
        this$0.snack(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickPlaylist$lambda$34(List $playlists, final LibraryFragment this$0, final List $ids, DialogInterface dialogInterface, int which) {
        if (which < $playlists.size()) {
            this$0.getVm().addAllToPlaylist(((Playlist) $playlists.get(which)).getId(), $ids);
            pickPlaylist$added(this$0, $ids, ((Playlist) $playlists.get(which)).getName());
        } else {
            this$0.askName(R.string.new_playlist, "", new Function1() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LibraryFragment.pickPlaylist$lambda$34$lambda$33(this.f$0, $ids, (String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pickPlaylist$lambda$34$lambda$33(LibraryFragment this$0, List $ids, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this$0.getVm().addAllToPlaylist(this$0.getVm().createPlaylist(name), $ids);
        pickPlaylist$added(this$0, $ids, name);
        return Unit.INSTANCE;
    }

    private final void askName(int titleRes, String initial, final Function1<? super String, Unit> onOk) {
        final DialogTextInputBinding input = DialogTextInputBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(input, "inflate(...)");
        input.input.setText(initial);
        new MaterialAlertDialogBuilder(requireContext()).setTitle(titleRes).setView((View) input.getRoot()).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LibraryFragment.askName$lambda$35(input, onOk, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askName$lambda$35(DialogTextInputBinding $input, Function1 $onOk, DialogInterface dialogInterface, int i) {
        String string;
        Editable text = $input.input.getText();
        String name = (text == null || (string = text.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString();
        if (name == null) {
            name = "";
        }
        if (name.length() > 0) {
            $onOk.invoke(name);
        }
    }

    private final void confirmDelete(final List<LocalTrack> tracks) {
        if (tracks.isEmpty()) {
            return;
        }
        String message = tracks.size() == 1 ? getString(R.string.delete_file_confirm, tracks.get(0).getTitle()) : getResources().getQuantityString(R.plurals.delete_files_confirm, tracks.size(), Integer.valueOf(tracks.size()));
        Intrinsics.checkNotNull(message);
        new MaterialAlertDialogBuilder(requireContext()).setMessage((CharSequence) message).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: com.muzk.app.ui.library.LibraryFragment$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.deleteFiles(tracks);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteFiles(List<LocalTrack> tracks) {
        ContentResolver resolver = requireContext().getContentResolver();
        this.pendingDeleteCount = tracks.size();
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                List<LocalTrack> $this$map$iv = tracks;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    LocalTrack it = (LocalTrack) item$iv$iv;
                    destination$iv$iv.add(it.getUri());
                }
                PendingIntent pending = MediaStore.createDeleteRequest(resolver, (List) destination$iv$iv);
                Intrinsics.checkNotNullExpressionValue(pending, "createDeleteRequest(...)");
                ActivityResultLauncher<IntentSenderRequest> activityResultLauncher = this.deleteLauncher;
                IntentSender intentSender = pending.getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender, "getIntentSender(...)");
                activityResultLauncher.launch(new IntentSenderRequest.Builder(intentSender).build());
                return;
            }
            List<LocalTrack> $this$forEach$iv = tracks;
            for (Object element$iv : $this$forEach$iv) {
                LocalTrack it2 = (LocalTrack) element$iv;
                resolver.delete(it2.getUri(), null, null);
            }
            getVm().clearSelection();
            getVm().reload();
        } catch (SecurityException e) {
            if (Build.VERSION.SDK_INT >= 29 && (e instanceof RecoverableSecurityException)) {
                ActivityResultLauncher<IntentSenderRequest> activityResultLauncher2 = this.deleteLauncher;
                IntentSender intentSender2 = ((RecoverableSecurityException) e).getUserAction().getActionIntent().getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender2, "getIntentSender(...)");
                activityResultLauncher2.launch(new IntentSenderRequest.Builder(intentSender2).build());
                return;
            }
            String message = e.getMessage();
            if (message == null) {
                message = "Sem permissão para excluir";
            }
            snack(message);
        }
    }

    private final void snack(String text) {
        Snackbar.make(getBinding().getRoot(), text, -1).setAnchorView(getBinding().fab).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        getBinding().list.setAdapter(null);
        this._binding = null;
        super.onDestroyView();
    }
}
