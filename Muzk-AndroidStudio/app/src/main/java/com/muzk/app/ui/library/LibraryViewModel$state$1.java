package com.muzk.app.ui.library;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.muzk.app.data.LocalTrack;
import com.muzk.app.data.Playlist;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\n"}, d2 = {"<anonymous>", "Lcom/muzk/app/ui/library/LibraryUiState;", TtmlNode.COMBINE_ALL, "", "Lcom/muzk/app/data/LocalTrack;", "playlists", "Lcom/muzk/app/data/Playlist;", "n", "Lcom/muzk/app/ui/library/Nav;", "sel", "", ""}, k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.muzk.app.ui.library.LibraryViewModel$state$1", f = "LibraryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LibraryViewModel$state$1 extends SuspendLambda implements Function5<List<? extends LocalTrack>, List<? extends Playlist>, Nav, Set<? extends Long>, Continuation<? super LibraryUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;
    final /* synthetic */ LibraryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$state$1(LibraryViewModel libraryViewModel, Continuation<? super LibraryViewModel$state$1> continuation) {
        super(5, continuation);
        this.this$0 = libraryViewModel;
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(List<? extends LocalTrack> list, List<? extends Playlist> list2, Nav nav, Set<? extends Long> set, Continuation<? super LibraryUiState> continuation) {
        return invoke2((List<LocalTrack>) list, (List<Playlist>) list2, nav, (Set<Long>) set, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<LocalTrack> list, List<Playlist> list2, Nav nav, Set<Long> set, Continuation<? super LibraryUiState> continuation) {
        LibraryViewModel$state$1 libraryViewModel$state$1 = new LibraryViewModel$state$1(this.this$0, continuation);
        libraryViewModel$state$1.L$0 = list;
        libraryViewModel$state$1.L$1 = list2;
        libraryViewModel$state$1.L$2 = nav;
        libraryViewModel$state$1.L$3 = set;
        return libraryViewModel$state$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                List all = (List) this.L$0;
                List playlists = (List) this.L$1;
                Nav n = (Nav) this.L$2;
                Set sel = (Set) this.L$3;
                return this.this$0.build(all, playlists, n, sel);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
