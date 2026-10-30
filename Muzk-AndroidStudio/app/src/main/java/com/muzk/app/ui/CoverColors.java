package com.muzk.app.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CoverColors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/muzk/app/ui/CoverColors;", "", "<init>", "()V", "extract", "", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Integer;", "withAlpha", "color", "alpha", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CoverColors {
    public static final CoverColors INSTANCE = new CoverColors();

    private CoverColors() {
    }

    public final Integer extract(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return null;
        }
        Palette palette = Palette.from(bitmap).maximumColorCount(16).generate();
        Intrinsics.checkNotNullExpressionValue(palette, "generate(...)");
        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
        if (vibrantSwatch == null && (vibrantSwatch = palette.getDominantSwatch()) == null && (vibrantSwatch = palette.getMutedSwatch()) == null) {
            return null;
        }
        Palette.Swatch swatch = vibrantSwatch;
        float[] hsl = new float[3];
        ColorUtils.colorToHSL(swatch.getRgb(), hsl);
        hsl[2] = RangesKt.coerceIn(hsl[2], 0.18f, 0.32f);
        return Integer.valueOf(ColorUtils.HSLToColor(hsl));
    }

    public final int withAlpha(int color, float alpha) {
        return Color.argb((int) (255 * alpha), Color.red(color), Color.green(color), Color.blue(color));
    }
}
