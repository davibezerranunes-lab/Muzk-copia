package com.muzk.app.ui.search;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.muzk.app.R;
import com.muzk.app.data.ModelsKt;
import com.muzk.app.databinding.FragmentSearchBinding;
import com.muzk.app.databinding.ItemGenreBinding;
import com.muzk.app.databinding.ItemRecentSearchBinding;
import com.muzk.app.playback.PlayerViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: SearchFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u001dH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/muzk/app/ui/search/SearchFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/muzk/app/databinding/FragmentSearchBinding;", "binding", "getBinding", "()Lcom/muzk/app/databinding/FragmentSearchBinding;", "vm", "Lcom/muzk/app/ui/search/SearchViewModel;", "getVm", "()Lcom/muzk/app/ui/search/SearchViewModel;", "vm$delegate", "Lkotlin/Lazy;", "player", "Lcom/muzk/app/playback/PlayerViewModel;", "getPlayer", "()Lcom/muzk/app/playback/PlayerViewModel;", "player$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "buildGenres", "searchFor", "q", "", "snack", "text", "hideKeyboard", "v", "onDestroyView", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchFragment extends Fragment {
    private static final int[] GENRE_COLORS = {-1550068, -4053668, -9418520, -3593686, -13923778, -1673472, -11972521, -15109694, -10535484, -2537457, -16027003, -5890483};
    private FragmentSearchBinding _binding;

    /* JADX INFO: renamed from: player$delegate, reason: from kotlin metadata */
    private final Lazy player;

    /* JADX INFO: renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;

    public SearchFragment() {
        final SearchFragment $this$activityViewModels_u24default$iv = this;
        final Function0 extrasProducer$iv = null;
        this.vm = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(SearchViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.search.SearchFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.search.SearchFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.search.SearchFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        final SearchFragment $this$activityViewModels_u24default$iv2 = this;
        final Function0 extrasProducer$iv2 = null;
        this.player = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv2, Reflection.getOrCreateKotlinClass(PlayerViewModel.class), new Function0<ViewModelStore>() { // from class: com.muzk.app.ui.search.SearchFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$activityViewModels_u24default$iv2.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.muzk.app.ui.search.SearchFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.muzk.app.ui.search.SearchFragment$special$$inlined$activityViewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$activityViewModels_u24default$iv2.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    public static final /* synthetic */ void access$searchFor(SearchFragment $this, String q) {
        $this.searchFor(q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSearchBinding getBinding() {
        FragmentSearchBinding fragmentSearchBinding = this._binding;
        Intrinsics.checkNotNull(fragmentSearchBinding);
        return fragmentSearchBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchViewModel getVm() {
        return (SearchViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayerViewModel getPlayer() {
        return (PlayerViewModel) this.player.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentSearchBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        SearchAdapter adapter = new SearchAdapter(new SearchFragment$onViewCreated$adapter$1(getVm()), new SearchFragment$onViewCreated$adapter$2(getVm()));
        getBinding().results.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().results.setAdapter(adapter);
        RecyclerView.ItemAnimator itemAnimator = getBinding().results.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        getBinding().searchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.muzk.app.ui.search.SearchFragment$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return SearchFragment.onViewCreated$lambda$0(this.f$0, textView, i, keyEvent);
            }
        });
        buildGenres();
        getBinding().searchClear.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.search.SearchFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SearchFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        TextView searchInput = getBinding().searchInput;
        Intrinsics.checkNotNullExpressionValue(searchInput, "searchInput");
        TextView $this$doAfterTextChanged$iv = searchInput;
        $this$doAfterTextChanged$iv.addTextChangedListener(new TextWatcher() { // from class: com.muzk.app.ui.search.SearchFragment$onViewCreated$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                View searchClear = this.this$0.getBinding().searchClear;
                Intrinsics.checkNotNullExpressionValue(searchClear, "searchClear");
                View $this$isVisible$iv = searchClear;
                Editable editable = s;
                boolean value$iv = !(editable == null || editable.length() == 0);
                $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
                Editable editable2 = s;
                if (editable2 == null || editable2.length() == 0) {
                    this.this$0.getVm().clear();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass4(adapter, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(SearchFragment this$0, TextView v, int actionId, KeyEvent keyEvent) {
        if (actionId == 3) {
            this$0.getVm().search(v.getText().toString());
            Intrinsics.checkNotNull(v);
            this$0.hideKeyboard(v);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(SearchFragment this$0, View it) {
        this$0.getBinding().searchInput.setText("");
        this$0.getVm().clear();
    }

    /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchFragment$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: SearchFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.muzk.app.ui.search.SearchFragment$onViewCreated$4", f = "SearchFragment.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SearchAdapter $adapter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(SearchAdapter searchAdapter, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$adapter = searchAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchFragment.this.new AnonymousClass4(this.$adapter, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: SearchFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1", f = "SearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SearchAdapter $adapter;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SearchFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SearchFragment searchFragment, SearchAdapter searchAdapter, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = searchFragment;
                this.$adapter = searchAdapter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$adapter, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SearchFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$1", f = "SearchFragment.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
            static final class C00381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ SearchAdapter $adapter;
                int label;
                final /* synthetic */ SearchFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00381(SearchFragment searchFragment, SearchAdapter searchAdapter, Continuation<? super C00381> continuation) {
                    super(2, continuation);
                    this.this$0 = searchFragment;
                    this.$adapter = searchAdapter;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00381(this.this$0, this.$adapter, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            StateFlow<SearchUiState> state = this.this$0.getVm().getState();
                            final SearchFragment searchFragment = this.this$0;
                            final SearchAdapter searchAdapter = this.$adapter;
                            this.label = 1;
                            if (state.collect(new FlowCollector() { // from class: com.muzk.app.ui.search.SearchFragment.onViewCreated.4.1.1.1
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                    return emit((SearchUiState) value, (Continuation<? super Unit>) $completion);
                                }

                                public final Object emit(SearchUiState s, Continuation<? super Unit> continuation) {
                                    String str;
                                    String it;
                                    Editable text = searchFragment.getBinding().searchInput.getText();
                                    if (text == null || text.length() == 0) {
                                        if (s.getQuery().length() > 0) {
                                            searchFragment.getBinding().searchInput.setText(s.getQuery());
                                        }
                                    }
                                    View searchProgress = searchFragment.getBinding().searchProgress;
                                    Intrinsics.checkNotNullExpressionValue(searchProgress, "searchProgress");
                                    View $this$isInvisible$iv = searchProgress;
                                    boolean value$iv = !s.getLoading();
                                    $this$isInvisible$iv.setVisibility(value$iv ? 4 : 0);
                                    searchAdapter.submitList(s.getResults());
                                    searchAdapter.setStatus(s.getResolvingId(), s.getDownloadedIds());
                                    boolean idle = (s.getQuery().length() == 0) && !s.getLoading();
                                    View discover = searchFragment.getBinding().discover;
                                    Intrinsics.checkNotNullExpressionValue(discover, "discover");
                                    View $this$isVisible$iv = discover;
                                    $this$isVisible$iv.setVisibility(idle ? 0 : 8);
                                    View results = searchFragment.getBinding().results;
                                    Intrinsics.checkNotNullExpressionValue(results, "results");
                                    View $this$isVisible$iv2 = results;
                                    boolean value$iv2 = !idle;
                                    $this$isVisible$iv2.setVisibility(value$iv2 ? 0 : 8);
                                    View searchEmpty = searchFragment.getBinding().searchEmpty;
                                    Intrinsics.checkNotNullExpressionValue(searchEmpty, "searchEmpty");
                                    View $this$isVisible$iv3 = searchEmpty;
                                    boolean value$iv3 = (idle || s.getLoading() || !s.getResults().isEmpty()) ? false : true;
                                    $this$isVisible$iv3.setVisibility(value$iv3 ? 0 : 8);
                                    TextView textView = searchFragment.getBinding().searchEmpty;
                                    String it2 = s.getError();
                                    if (it2 == null || (it = searchFragment.getString(R.string.search_error, it2)) == null) {
                                        String string = searchFragment.getString(R.string.search_no_results);
                                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                        str = string;
                                    } else {
                                        str = it;
                                    }
                                    textView.setText(str);
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
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope $this$repeatOnLifecycle = (CoroutineScope) this.L$0;
                        BuildersKt__Builders_commonKt.launch$default($this$repeatOnLifecycle, null, null, new C00381(this.this$0, this.$adapter, null), 3, null);
                        BuildersKt__Builders_commonKt.launch$default($this$repeatOnLifecycle, null, null, new AnonymousClass2(this.this$0, null), 3, null);
                        BuildersKt__Builders_commonKt.launch$default($this$repeatOnLifecycle, null, null, new AnonymousClass3(this.this$0, null), 3, null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: SearchFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$2", f = "SearchFragment.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SearchFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(SearchFragment searchFragment, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = searchFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$2$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: SearchFragment.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                static final class C00401<T> implements FlowCollector {
                    final /* synthetic */ SearchFragment this$0;

                    C00401(SearchFragment searchFragment) {
                        this.this$0 = searchFragment;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((List<String>) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(List<String> list, Continuation<? super Unit> continuation) {
                        this.this$0.getBinding().recentList.removeAllViews();
                        List<String> $this$forEach$iv = list;
                        final SearchFragment searchFragment = this.this$0;
                        for (Object element$iv : $this$forEach$iv) {
                            final String q = (String) element$iv;
                            ItemRecentSearchBinding row = ItemRecentSearchBinding.inflate(searchFragment.getLayoutInflater(), searchFragment.getBinding().recentList, true);
                            Intrinsics.checkNotNullExpressionValue(row, "inflate(...)");
                            row.query.setText(q);
                            row.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$2$1$$ExternalSyntheticLambda0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    SearchFragment.access$searchFor(searchFragment, q);
                                }
                            });
                            row.remove.setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$2$1$$ExternalSyntheticLambda1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    SearchFragment.AnonymousClass4.AnonymousClass1.AnonymousClass2.C00401.emit$lambda$2$lambda$1(searchFragment, q, view);
                                }
                            });
                        }
                        View recentTitle = this.this$0.getBinding().recentTitle;
                        Intrinsics.checkNotNullExpressionValue(recentTitle, "recentTitle");
                        View $this$isVisible$iv = recentTitle;
                        boolean value$iv = !list.isEmpty();
                        $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
                        View recentList = this.this$0.getBinding().recentList;
                        Intrinsics.checkNotNullExpressionValue(recentList, "recentList");
                        View $this$isVisible$iv2 = recentList;
                        boolean value$iv2 = !list.isEmpty();
                        $this$isVisible$iv2.setVisibility(value$iv2 ? 0 : 8);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void emit$lambda$2$lambda$1(SearchFragment this$0, String $q, View it) {
                        this$0.getVm().removeRecent($q);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (this.this$0.getVm().getRecentSearches().collect(new C00401(this.this$0), this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: SearchFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "com.muzk.app.ui.search.SearchFragment$onViewCreated$4$1$3", f = "SearchFragment.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SearchFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(SearchFragment searchFragment, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = searchFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            SharedFlow<SearchEvent> events = this.this$0.getVm().getEvents();
                            final SearchFragment searchFragment = this.this$0;
                            this.label = 1;
                            if (events.collect(new FlowCollector() { // from class: com.muzk.app.ui.search.SearchFragment.onViewCreated.4.1.3.1
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                    return emit((SearchEvent) value, (Continuation<? super Unit>) $completion);
                                }

                                public final Object emit(SearchEvent e, Continuation<? super Unit> continuation) {
                                    if (e instanceof SearchEvent.Play) {
                                        searchFragment.getPlayer().playQueue(CollectionsKt.listOf(ModelsKt.toMediaItem(((SearchEvent.Play) e).getTrack(), ((SearchEvent.Play) e).getStreamUrl())), 0, searchFragment.getVm().getState().getValue().getQuery());
                                    } else if (e instanceof SearchEvent.Message) {
                                        searchFragment.snack(((SearchEvent.Message) e).getText());
                                    } else {
                                        if (!(e instanceof SearchEvent.Downloading)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        SearchFragment searchFragment2 = searchFragment;
                                        String string = searchFragment.getString(((SearchEvent.Downloading) e).getWaitingWifi() ? R.string.dl_waiting_wifi : R.string.dl_started, ((SearchEvent.Downloading) e).getTrack().getTitle());
                                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                        searchFragment2.snack(string);
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
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LifecycleOwner viewLifecycleOwner = SearchFragment.this.getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(SearchFragment.this, this.$adapter, null), this) == coroutine_suspended) {
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

    private final void buildGenres() {
        Iterable $this$forEachIndexed$iv;
        String[] queries = getResources().getStringArray(R.array.explore_queries);
        Intrinsics.checkNotNullExpressionValue(queries, "getStringArray(...)");
        int gap = getResources().getDimensionPixelSize(R.dimen.genre_gap);
        float radius = getResources().getDisplayMetrics().density * 8;
        Iterable $this$forEachIndexed$iv2 = CollectionsKt.chunked(ArraysKt.toList(queries), 2);
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        Iterator it = $this$forEachIndexed$iv2.iterator();
        while (it.hasNext()) {
            Object item$iv = it.next();
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List pair = (List) item$iv;
            LinearLayout $this$buildGenres_u24lambda_u249_u24lambda_u244 = new LinearLayout(requireContext());
            $this$buildGenres_u24lambda_u249_u24lambda_u244.setOrientation(0);
            String[] queries2 = queries;
            LinearLayout.LayoutParams $this$buildGenres_u24lambda_u249_u24lambda_u244_u24lambda_u243 = new LinearLayout.LayoutParams(-1, -2);
            if (index$iv > 0) {
                $this$buildGenres_u24lambda_u249_u24lambda_u244_u24lambda_u243.topMargin = gap;
            }
            $this$buildGenres_u24lambda_u249_u24lambda_u244.setLayoutParams($this$buildGenres_u24lambda_u249_u24lambda_u244_u24lambda_u243);
            int index$iv3 = 0;
            Iterator it2 = pair.iterator();
            while (true) {
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                if (!it2.hasNext()) {
                    break;
                }
                Object item$iv2 = it2.next();
                int index$iv4 = index$iv3 + 1;
                if (index$iv3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final String q = (String) item$iv2;
                int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
                Iterator it3 = it;
                Object item$iv3 = item$iv;
                ItemGenreBinding card = ItemGenreBinding.inflate(getLayoutInflater(), $this$buildGenres_u24lambda_u249_u24lambda_u244, false);
                Intrinsics.checkNotNullExpressionValue(card, "inflate(...)");
                card.name.setText(q);
                FrameLayout root = card.getRoot();
                GradientDrawable $this$buildGenres_u24lambda_u249_u24lambda_u247_u24lambda_u245 = new GradientDrawable();
                int index$iv5 = index$iv2;
                $this$buildGenres_u24lambda_u249_u24lambda_u247_u24lambda_u245.setCornerRadius(radius);
                float radius2 = radius;
                $this$buildGenres_u24lambda_u249_u24lambda_u247_u24lambda_u245.setColor(GENRE_COLORS[((index$iv * 2) + index$iv3) % GENRE_COLORS.length]);
                root.setBackground($this$buildGenres_u24lambda_u249_u24lambda_u247_u24lambda_u245);
                card.getRoot().setClipToOutline(true);
                ViewGroup.LayoutParams layoutParams = card.getRoot().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams) layoutParams).setMarginStart(index$iv3 == 1 ? gap : 0);
                card.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.search.SearchFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchFragment.buildGenres$lambda$9$lambda$7$lambda$6(this.f$0, q, view);
                    }
                });
                $this$buildGenres_u24lambda_u249_u24lambda_u244.addView(card.getRoot());
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                index$iv3 = index$iv4;
                $i$f$forEachIndexed = $i$f$forEachIndexed2;
                it = it3;
                item$iv = item$iv3;
                index$iv2 = index$iv5;
                radius = radius2;
            }
            float radius3 = radius;
            int $i$f$forEachIndexed3 = $i$f$forEachIndexed;
            Iterator it4 = it;
            int index$iv6 = index$iv2;
            if (pair.size() == 1) {
                View view = new View(requireContext());
                LinearLayout.LayoutParams $this$buildGenres_u24lambda_u249_u24lambda_u248 = new LinearLayout.LayoutParams(0, 0, 1.0f);
                $this$buildGenres_u24lambda_u249_u24lambda_u248.setMarginStart(gap);
                Unit unit = Unit.INSTANCE;
                $this$buildGenres_u24lambda_u249_u24lambda_u244.addView(view, $this$buildGenres_u24lambda_u249_u24lambda_u248);
            }
            getBinding().genres.addView($this$buildGenres_u24lambda_u249_u24lambda_u244);
            queries = queries2;
            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            $i$f$forEachIndexed = $i$f$forEachIndexed3;
            it = it4;
            index$iv = index$iv6;
            radius = radius3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildGenres$lambda$9$lambda$7$lambda$6(SearchFragment this$0, String $q, View it) {
        Intrinsics.checkNotNull($q);
        this$0.searchFor($q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void searchFor(String q) {
        getBinding().searchInput.setText(q);
        getBinding().searchInput.setSelection(q.length());
        EditText searchInput = getBinding().searchInput;
        Intrinsics.checkNotNullExpressionValue(searchInput, "searchInput");
        hideKeyboard(searchInput);
        getVm().search(q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void snack(String text) {
        View anchor = requireActivity().findViewById(R.id.mini_player);
        Intrinsics.checkNotNull(anchor);
        if (!(anchor.getVisibility() == 0)) {
            anchor = null;
        }
        if (anchor == null) {
            anchor = requireActivity().findViewById(R.id.bottom_nav);
            Intrinsics.checkNotNullExpressionValue(anchor, "findViewById(...)");
        }
        Snackbar.make(getBinding().getRoot(), text, -1).setAnchorView(anchor).show();
    }

    private final void hideKeyboard(View v) {
        v.clearFocus();
        ((InputMethodManager) requireContext().getSystemService(InputMethodManager.class)).hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        getBinding().results.setAdapter(null);
        this._binding = null;
        super.onDestroyView();
    }
}
