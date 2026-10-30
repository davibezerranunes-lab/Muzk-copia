package com.muzk.app.ui;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import com.muzk.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Palette.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/muzk/app/ui/AppPalette;", "", "<init>", "()V", "PREF", "", "WALLPAPER", "current", "context", "Landroid/content/Context;", "overlay", "", "(Landroid/content/Context;)Ljava/lang/Integer;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AppPalette {
    public static final AppPalette INSTANCE = new AppPalette();
    public static final String PREF = "palette";
    public static final String WALLPAPER = "wallpaper";

    private AppPalette() {
    }

    public final String current(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(PREF, "muzk");
        return string == null ? "muzk" : string;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Integer overlay(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strCurrent = current(context);
        switch (strCurrent.hashCode()) {
            case -1008851410:
                if (strCurrent.equals("orange")) {
                    return Integer.valueOf(R.style.ThemeOverlay_Muzk_Orange);
                }
                break;
            case -976943172:
                if (strCurrent.equals("purple")) {
                    return Integer.valueOf(R.style.ThemeOverlay_Muzk_Purple);
                }
                break;
            case 3027034:
                if (strCurrent.equals("blue")) {
                    return Integer.valueOf(R.style.ThemeOverlay_Muzk_Blue);
                }
                break;
            case 3441014:
                if (strCurrent.equals("pink")) {
                    return Integer.valueOf(R.style.ThemeOverlay_Muzk_Pink);
                }
                break;
            case 98619139:
                if (strCurrent.equals("green")) {
                    return Integer.valueOf(R.style.ThemeOverlay_Muzk_Green);
                }
                break;
            case 1474694658:
                if (strCurrent.equals(WALLPAPER)) {
                    return null;
                }
                break;
        }
        return Integer.valueOf(R.style.ThemeOverlay_Muzk_Brand);
    }
}
