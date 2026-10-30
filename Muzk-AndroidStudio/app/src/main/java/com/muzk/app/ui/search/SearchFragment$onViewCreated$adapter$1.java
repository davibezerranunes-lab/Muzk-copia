package com.muzk.app.ui.search;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.data.RemoteTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* synthetic */ class SearchFragment$onViewCreated$adapter$1 extends FunctionReferenceImpl implements Function1<RemoteTrack, Unit> {
    SearchFragment$onViewCreated$adapter$1(Object obj) {
        super(1, obj, SearchViewModel.class, "listen", "listen(Lcom/muzk/app/data/RemoteTrack;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RemoteTrack remoteTrack) {
        invoke2(remoteTrack);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RemoteTrack p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SearchViewModel) this.receiver).listen(p0);
    }
}
