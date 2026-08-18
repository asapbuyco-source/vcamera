package multispace.multiapp.clone.type.cam;

import android.content.Context;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooOOO {
    public static ConcatenatingMediaSource OooO00o(String str, Context context) {
        DefaultMediaSourceFactory defaultMediaSourceFactory;
        MediaItem mediaItemFromUri;
        multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-117, 21, -94, -126, 92, -65, 106, 62, -116, 14, -90, -80, 71, -81, 85, 56, -115, 71, -73, -126, 92, -78, 29}, new byte[]{-24, 103, -57, -29, 40, -38, 39, 91}) + str);
        if (str.startsWith(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{2, 126, 0, -90, 40, -33}, new byte[]{45, 26, 97, -46, 73, -16, 114, 28}))) {
            mediaItemFromUri = new MediaItem.Builder().setUri(new File(str).getAbsolutePath()).build();
            defaultMediaSourceFactory = new DefaultMediaSourceFactory(context);
        } else {
            defaultMediaSourceFactory = new DefaultMediaSourceFactory(context);
            mediaItemFromUri = MediaItem.fromUri(str);
        }
        return new ConcatenatingMediaSource(true, new MediaSource[]{defaultMediaSourceFactory.createMediaSource(mediaItemFromUri)});
    }
}
