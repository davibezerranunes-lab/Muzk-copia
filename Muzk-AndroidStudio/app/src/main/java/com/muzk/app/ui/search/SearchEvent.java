package com.muzk.app.ui.search;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.muzk.app.data.RemoteTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/muzk/app/ui/search/SearchEvent;", "", "Play", "Message", "Downloading", "Lcom/muzk/app/ui/search/SearchEvent$Downloading;", "Lcom/muzk/app/ui/search/SearchEvent$Message;", "Lcom/muzk/app/ui/search/SearchEvent$Play;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface SearchEvent {

    /* JADX INFO: compiled from: SearchViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/muzk/app/ui/search/SearchEvent$Play;", "Lcom/muzk/app/ui/search/SearchEvent;", "track", "Lcom/muzk/app/data/RemoteTrack;", "streamUrl", "", "<init>", "(Lcom/muzk/app/data/RemoteTrack;Ljava/lang/String;)V", "getTrack", "()Lcom/muzk/app/data/RemoteTrack;", "getStreamUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Play implements SearchEvent {
        private final String streamUrl;
        private final RemoteTrack track;

        public static /* synthetic */ Play copy$default(Play play, RemoteTrack remoteTrack, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteTrack = play.track;
            }
            if ((i & 2) != 0) {
                str = play.streamUrl;
            }
            return play.copy(remoteTrack, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RemoteTrack getTrack() {
            return this.track;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getStreamUrl() {
            return this.streamUrl;
        }

        public final Play copy(RemoteTrack track, String streamUrl) {
            Intrinsics.checkNotNullParameter(track, "track");
            Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
            return new Play(track, streamUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Play)) {
                return false;
            }
            Play play = (Play) other;
            return Intrinsics.areEqual(this.track, play.track) && Intrinsics.areEqual(this.streamUrl, play.streamUrl);
        }

        public int hashCode() {
            return (this.track.hashCode() * 31) + this.streamUrl.hashCode();
        }

        public String toString() {
            return "Play(track=" + this.track + ", streamUrl=" + this.streamUrl + ")";
        }

        public Play(RemoteTrack track, String streamUrl) {
            Intrinsics.checkNotNullParameter(track, "track");
            Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
            this.track = track;
            this.streamUrl = streamUrl;
        }

        public final String getStreamUrl() {
            return this.streamUrl;
        }

        public final RemoteTrack getTrack() {
            return this.track;
        }
    }

    /* JADX INFO: compiled from: SearchViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/muzk/app/ui/search/SearchEvent$Message;", "Lcom/muzk/app/ui/search/SearchEvent;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Message implements SearchEvent {
        private final String text;

        public static /* synthetic */ Message copy$default(Message message, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = message.text;
            }
            return message.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Message copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Message(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Message) && Intrinsics.areEqual(this.text, ((Message) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Message(text=" + this.text + ")";
        }

        public Message(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: SearchViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/muzk/app/ui/search/SearchEvent$Downloading;", "Lcom/muzk/app/ui/search/SearchEvent;", "track", "Lcom/muzk/app/data/RemoteTrack;", "waitingWifi", "", "<init>", "(Lcom/muzk/app/data/RemoteTrack;Z)V", "getTrack", "()Lcom/muzk/app/data/RemoteTrack;", "getWaitingWifi", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Downloading implements SearchEvent {
        private final RemoteTrack track;
        private final boolean waitingWifi;

        public static /* synthetic */ Downloading copy$default(Downloading downloading, RemoteTrack remoteTrack, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteTrack = downloading.track;
            }
            if ((i & 2) != 0) {
                z = downloading.waitingWifi;
            }
            return downloading.copy(remoteTrack, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RemoteTrack getTrack() {
            return this.track;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getWaitingWifi() {
            return this.waitingWifi;
        }

        public final Downloading copy(RemoteTrack track, boolean waitingWifi) {
            Intrinsics.checkNotNullParameter(track, "track");
            return new Downloading(track, waitingWifi);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Downloading)) {
                return false;
            }
            Downloading downloading = (Downloading) other;
            return Intrinsics.areEqual(this.track, downloading.track) && this.waitingWifi == downloading.waitingWifi;
        }

        public int hashCode() {
            return (this.track.hashCode() * 31) + Boolean.hashCode(this.waitingWifi);
        }

        public String toString() {
            return "Downloading(track=" + this.track + ", waitingWifi=" + this.waitingWifi + ")";
        }

        public Downloading(RemoteTrack track, boolean waitingWifi) {
            Intrinsics.checkNotNullParameter(track, "track");
            this.track = track;
            this.waitingWifi = waitingWifi;
        }

        public final RemoteTrack getTrack() {
            return this.track;
        }

        public final boolean getWaitingWifi() {
            return this.waitingWifi;
        }
    }
}
