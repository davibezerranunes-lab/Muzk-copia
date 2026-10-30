package com.muzk.app.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Size;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.Options;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioCover.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/muzk/app/data/AudioCoverFetcher;", "Lcoil/fetch/Fetcher;", "data", "Lcom/muzk/app/data/AudioCover;", "options", "Lcoil/request/Options;", "<init>", "(Lcom/muzk/app/data/AudioCover;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AudioCoverFetcher implements Fetcher {
    private final AudioCover data;
    private final Options options;

    public AudioCoverFetcher(AudioCover data, Options options) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(options, "options");
        this.data = data;
        this.options = options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) throws IOException {
        Object objM663constructorimpl;
        Context ctx = this.options.getContext();
        Object objDecodeByteArray = null;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AudioCoverFetcher $this$fetch_u24lambda_u240 = this;
                objM663constructorimpl = Result.m663constructorimpl(ctx.getContentResolver().loadThumbnail($this$fetch_u24lambda_u240.data.getUri(), new Size(512, 512), null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM663constructorimpl = Result.m663constructorimpl(ResultKt.createFailure(th));
            }
            objDecodeByteArray = (Bitmap) (Result.m669isFailureimpl(objM663constructorimpl) ? null : objM663constructorimpl);
        } else {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            try {
                mmr.setDataSource(ctx, this.data.getUri());
                byte[] it = mmr.getEmbeddedPicture();
                if (it != null) {
                    objDecodeByteArray = BitmapFactory.decodeByteArray(it, 0, it.length);
                }
            } catch (Exception e) {
            } finally {
                mmr.release();
            }
        }
        if (objDecodeByteArray == null) {
            throw new IOException("Arquivo sem capa");
        }
        Bitmap bitmap = objDecodeByteArray;
        Resources resources$iv = ctx.getResources();
        Intrinsics.checkNotNullExpressionValue(resources$iv, "getResources(...)");
        return new DrawableResult(new BitmapDrawable(resources$iv, bitmap), true, DataSource.DISK);
    }

    /* JADX INFO: compiled from: AudioCover.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/muzk/app/data/AudioCoverFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Lcom/muzk/app/data/AudioCover;", "<init>", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Factory implements Fetcher.Factory<AudioCover> {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(AudioCover data, Options options, ImageLoader imageLoader) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
            return new AudioCoverFetcher(data, options);
        }
    }
}
