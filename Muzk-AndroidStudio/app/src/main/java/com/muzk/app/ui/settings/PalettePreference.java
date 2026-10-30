package com.muzk.app.ui.settings;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.google.android.material.color.MaterialColors;
import com.muzk.app.R;
import com.muzk.app.databinding.ItemSwatchBinding;
import com.muzk.app.download.DownloadWorker;
import com.muzk.app.ui.AppPalette;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PalettePreference.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/muzk/app/ui/settings/PalettePreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "Swatch", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PalettePreference extends Preference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Swatch> SWATCHES = CollectionsKt.listOf((Object[]) new Swatch[]{new Swatch("muzk", DownloadWorker.FOLDER, new int[]{INSTANCE.c(4283413503L), INSTANCE.c(4280110808L)}), new Swatch("purple", "Roxo", new int[]{INSTANCE.c(4288506879L), INSTANCE.c(4284165081L)}), new Swatch("green", "Verde", new int[]{INSTANCE.c(4280211296L), INSTANCE.c(4279204406L)}), new Swatch("pink", "Rosa", new int[]{INSTANCE.c(4294922123L), INSTANCE.c(4289730380L)}), new Swatch("orange", "Laranja", new int[]{INSTANCE.c(4294933053L), INSTANCE.c(4289938191L)}), new Swatch("blue", "Azul", new int[]{INSTANCE.c(4283272703L), INSTANCE.c(4280242119L)}), new Swatch(AppPalette.WALLPAPER, "Papel de\nparede", new int[]{INSTANCE.c(4294948971L), INSTANCE.c(4288506879L), INSTANCE.c(4283413503L)})});

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PalettePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutResource(R.layout.pref_palette);
        setSelectable(false);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder holder) {
        GradientDrawable gradientDrawable;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        View viewFindViewById = holder.findViewById(R.id.swatches);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout row = (LinearLayout) viewFindViewById;
        row.removeAllViews();
        AppPalette appPalette = AppPalette.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String current = appPalette.current(context);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        int onSurface = MaterialColors.getColor(row, com.google.android.material.R.attr.colorOnSurface);
        int muted = MaterialColors.getColor(row, com.google.android.material.R.attr.colorOnSurfaceVariant);
        Iterable $this$forEach$iv = SWATCHES;
        for (Object element$iv : $this$forEach$iv) {
            final Swatch sw = (Swatch) element$iv;
            ItemSwatchBinding b = ItemSwatchBinding.inflate(inflater, row, false);
            Intrinsics.checkNotNullExpressionValue(b, "inflate(...)");
            final boolean on = Intrinsics.areEqual(sw.getId(), current);
            View view = b.dot;
            String current2 = current;
            GradientDrawable $this$onBindViewHolder_u24lambda_u243_u24lambda_u240 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, sw.getColors());
            $this$onBindViewHolder_u24lambda_u243_u24lambda_u240.setShape(1);
            view.setBackground($this$onBindViewHolder_u24lambda_u243_u24lambda_u240);
            FrameLayout frameLayout = b.ring;
            if (on) {
                GradientDrawable $this$onBindViewHolder_u24lambda_u243_u24lambda_u241 = new GradientDrawable();
                $this$onBindViewHolder_u24lambda_u243_u24lambda_u241.setShape(1);
                $this$onBindViewHolder_u24lambda_u243_u24lambda_u241.setStroke((int) (3 * getContext().getResources().getDisplayMetrics().density), onSurface);
                gradientDrawable = $this$onBindViewHolder_u24lambda_u243_u24lambda_u241;
            } else {
                gradientDrawable = null;
            }
            frameLayout.setBackground(gradientDrawable);
            b.label.setText(sw.getName());
            b.label.setTextColor(on ? onSurface : muted);
            b.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.muzk.app.ui.settings.PalettePreference$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PalettePreference.onBindViewHolder$lambda$3$lambda$2(on, this, sw, view2);
                }
            });
            row.addView(b.getRoot());
            current = current2;
            inflater = inflater;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(boolean $on, PalettePreference this$0, Swatch $sw, View it) {
        if (!$on && this$0.callChangeListener($sw.getId())) {
            this$0.persistString($sw.getId());
            this$0.notifyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PalettePreference.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/muzk/app/ui/settings/PalettePreference$Swatch;", "", TtmlNode.ATTR_ID, "", "name", "colors", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;[I)V", "getId", "()Ljava/lang/String;", "getName", "getColors", "()[I", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class Swatch {
        private final int[] colors;
        private final String id;
        private final String name;

        public Swatch(String id, String name, int[] colors) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.id = id;
            this.name = name;
            this.colors = colors;
        }

        public final int[] getColors() {
            return this.colors;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: PalettePreference.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/muzk/app/ui/settings/PalettePreference$Companion;", "", "<init>", "()V", "c", "", "hex", "", "SWATCHES", "", "Lcom/muzk/app/ui/settings/PalettePreference$Swatch;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(long hex) {
            return (int) hex;
        }
    }
}
