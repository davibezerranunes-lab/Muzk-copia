package com.muzk.app.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.media.audiofx.Equalizer;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;
import com.muzk.app.R;
import com.muzk.app.playback.PlaybackService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: EqualizerDialog.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/settings/EqualizerDialog;", "", "<init>", "()V", "show", "", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EqualizerDialog {
    public static final EqualizerDialog INSTANCE = new EqualizerDialog();

    private EqualizerDialog() {
    }

    public final void show(final Context context) {
        String label;
        Intrinsics.checkNotNullParameter(context, "context");
        final Equalizer eq = PlaybackService.INSTANCE.obtainEqualizer(context);
        int i = 0;
        if (eq == null) {
            Toast.makeText(context, R.string.eq_unavailable, 0).show();
            return;
        }
        float dp = context.getResources().getDisplayMetrics().density;
        short[] it = eq.getBandLevelRange();
        int i2 = 1;
        Pair pair = TuplesKt.to(Float.valueOf(it[0]), Float.valueOf(it[1]));
        final float minLevel = ((Number) pair.component1()).floatValue();
        final float maxLevel = ((Number) pair.component2()).floatValue();
        LinearLayout content = new LinearLayout(context);
        content.setOrientation(1);
        float f = 24;
        content.setPadding((int) (f * dp), (int) (8 * dp), (int) (f * dp), 0);
        MaterialSwitch enabledSwitch = new MaterialSwitch(context);
        enabledSwitch.setText(context.getString(R.string.eq_enabled));
        enabledSwitch.setChecked(eq.getEnabled());
        enabledSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.muzk.app.ui.settings.EqualizerDialog$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                eq.setEnabled(z);
            }
        });
        content.addView(enabledSwitch);
        final List sliders = new ArrayList();
        int band = 0;
        short numberOfBands = eq.getNumberOfBands();
        while (band < numberOfBands) {
            final short b = (short) band;
            int hz = eq.getCenterFreq(b) / 1000;
            if (hz >= 1000) {
                label = String.format("%.1f kHz", Arrays.copyOf(new Object[]{Float.valueOf(hz / 1000.0f)}, i2));
                Intrinsics.checkNotNullExpressionValue(label, "format(...)");
            } else {
                label = hz + " Hz";
            }
            LinearLayout $this$show_u24lambda_u244 = new LinearLayout(context);
            $this$show_u24lambda_u244.setOrientation(i);
            $this$show_u24lambda_u244.setGravity(16);
            TextView $this$show_u24lambda_u245 = new TextView(context);
            $this$show_u24lambda_u245.setText(label);
            $this$show_u24lambda_u245.setMinWidth((int) (64 * dp));
            $this$show_u24lambda_u244.addView($this$show_u24lambda_u245);
            Slider $this$show_u24lambda_u248 = new Slider(context);
            $this$show_u24lambda_u248.setValueFrom(minLevel);
            $this$show_u24lambda_u248.setValueTo(maxLevel);
            $this$show_u24lambda_u248.setValue(RangesKt.coerceIn(eq.getBandLevel(b), minLevel, maxLevel));
            $this$show_u24lambda_u248.setLabelFormatter(new LabelFormatter() { // from class: com.muzk.app.ui.settings.EqualizerDialog$$ExternalSyntheticLambda1
                @Override // com.google.android.material.slider.LabelFormatter
                public final String getFormattedValue(float f2) {
                    return EqualizerDialog.show$lambda$8$lambda$6(f2);
                }
            });
            $this$show_u24lambda_u248.addOnChangeListener(new Slider.OnChangeListener() { // from class: com.muzk.app.ui.settings.EqualizerDialog$$ExternalSyntheticLambda2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.android.material.slider.Slider.OnChangeListener, com.google.android.material.slider.BaseOnChangeListener
                public final void onValueChange(Slider slider, float f2, boolean z) {
                    EqualizerDialog.show$lambda$8$lambda$7(eq, b, slider, f2, z);
                }
            });
            $this$show_u24lambda_u244.addView($this$show_u24lambda_u248, new LinearLayout.LayoutParams(0, -2, 1.0f));
            content.addView($this$show_u24lambda_u244);
            sliders.add($this$show_u24lambda_u248);
            band++;
            i = 0;
            dp = dp;
            enabledSwitch = enabledSwitch;
            numberOfBands = numberOfBands;
            i2 = 1;
        }
        AlertDialog dialog = new MaterialAlertDialogBuilder(context).setTitle(R.string.pref_eq_app).setView((View) content).setNeutralButton(R.string.eq_reset, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.muzk.app.ui.settings.EqualizerDialog$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EqualizerDialog.show$lambda$9(context, dialogInterface);
            }
        }).show();
        dialog.getButton(-3).setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.settings.EqualizerDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EqualizerDialog.show$lambda$12$lambda$11(sliders, minLevel, maxLevel, eq, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String show$lambda$8$lambda$6(float v) {
        String str = String.format("%+.1f dB", Arrays.copyOf(new Object[]{Float.valueOf(v / 100.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$8$lambda$7(Equalizer $eq, short $b, Slider slider, float v, boolean fromUser) {
        Intrinsics.checkNotNullParameter(slider, "<unused var>");
        if (fromUser) {
            $eq.setBandLevel($b, (short) v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$9(Context $context, DialogInterface it) {
        PlaybackService.INSTANCE.saveEqualizer($context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$12$lambda$11(List $sliders, float $minLevel, float $maxLevel, Equalizer $eq, View it) {
        List $this$forEachIndexed$iv = $sliders;
        int i = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Slider s = (Slider) item$iv;
            float zero = RangesKt.coerceIn(0.0f, $minLevel, $maxLevel);
            s.setValue(zero);
            $eq.setBandLevel((short) i, (short) zero);
            i = index$iv;
        }
    }
}
