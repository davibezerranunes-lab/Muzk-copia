package com.muzk.app.ui.home;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* synthetic */ class HomeFragment$onViewCreated$tiles$1 extends FunctionReferenceImpl implements Function1<HomeTile, Unit> {
    HomeFragment$onViewCreated$tiles$1(Object obj) {
        super(1, obj, HomeFragment.class, "openTile", "openTile(Lcom/muzk/app/ui/home/HomeTile;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HomeTile homeTile) {
        invoke2(homeTile);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HomeTile p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((HomeFragment) this.receiver).openTile(p0);
    }
}
