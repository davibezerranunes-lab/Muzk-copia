package com.muzk.app.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.key.Keyer;
import coil.request.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCover.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/muzk/app/data/AudioCoverKeyer;", "Lcoil/key/Keyer;", "Lcom/muzk/app/data/AudioCover;", "<init>", "()V", "key", "", "data", "options", "Lcoil/request/Options;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AudioCoverKeyer implements Keyer<AudioCover> {
    @Override // coil.key.Keyer
    public String key(AudioCover data, Options options) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(options, "options");
        return "cover:" + data.getUri();
    }
}
