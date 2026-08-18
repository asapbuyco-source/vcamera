package multispace.multiapp.clone.type.cam;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageReader;
import android.util.Log;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
import multispace.multiapp.clone.util.o0OoOo0;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooOOO0 {
    private static final String OooO0OO = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{116, 3, 57, 90, 5}, new byte[]{69, 50, 8, 107, 52, 80, 93, ByteCompanionObject.MIN_VALUE});
    private OooOO0O OooO00o_f = null;
    private ByteBuffer OooO0O0 = ByteBuffer.allocate(201326592);

    private OooOOO0() {
    }

    public static OooOOO0 OooO00o() {
        return new OooOOO0();
    }

    public void OooO0O0() {
        try {
            OooOO0O oooOO0O = this.OooO00o_f;
            if (oooOO0O != null) {
                oooOO0O.close();
            }
        } catch (Throwable unused) {
        }
    }

    public OooOO0O OooO0OO() {
        return this.OooO00o_f;
    }

    public void OooO0Oo(Image image, ImageReader imageReader, o000oOoO o000oooo) {
        try {
            int width = image.getWidth();
            int height = image.getHeight();
            multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-55, 66, 43, 48, -98, -126, 111, -74, -38, 71, 56, 111, -122, -51, 114, -67, -60, 95, 103}, new byte[]{-80, 55, 93, 8, -90, -70, 27, -39}) + width + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{30, -15, -78, -72, 85, -24, 27, 68}, new byte[]{50, -103, -41, -47, 50, ByteCompanionObject.MIN_VALUE, 111, 126}) + height);
            if (image.getPlanes().length <= 1) {
                return;
            }
            Bitmap bitmapOooO0OO = multispace.multiapp.clone.type.cam.OooO00o.OooO0OO(OooOO0.OooO00o(image), width, height);
            Bitmap bitmapOooO0O0 = multispace.multiapp.clone.type.cam.OooO00o.OooO0O0(bitmapOooO0OO, OooO.o000oOoO);
            byte[] bArrOooO00o = multispace.multiapp.clone.type.cam.OooO00o.OooO00o(bitmapOooO0O0);
            bitmapOooO0OO.recycle();
            bitmapOooO0O0.recycle();
            this.OooO0O0.clear();
            this.OooO0O0.limit(bArrOooO00o.length);
            this.OooO0O0.put(bArrOooO00o);
            this.OooO0O0.position(0);
            multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{9, 8, 3, -29, 45, 19, 90, -103, 26, 13, 16, -68, 53, 65, 94, -109, 23, 63, 12, -81, 112, 88, 20}, new byte[]{112, 125, 117, -37, 21, 43, 46, -10}) + this.OooO0O0.remaining());
            if (this.OooO00o_f == null) {
                this.OooO00o_f = new OooOO0O();
            }
            this.OooO00o_f.OooOO0 = image.getFormat();
            this.OooO00o_f.OooOO0O = image.getWidth();
            this.OooO00o_f.OooOO0o = image.getHeight();
            this.OooO00o_f.OooOOO0 = image.getTimestamp();
            this.OooO00o_f.OooO0O0(this.OooO0O0);
            ImageReader.OnImageAvailableListener onImageAvailableListener = (ImageReader.OnImageAvailableListener) o0OoOo0.OooOo(imageReader).OooOO0O(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{24, -47, 52, 40, -96, 80, 32, 55, 7}, new byte[]{117, -99, 93, 91, -44, 53, 78, 82})).OooOOOo();
            if (o000oooo.OooOOO0_f) {
                return;
            }
            onImageAvailableListener.onImageAvailable(imageReader);
            multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-78, -18, -95, -116, -36, 94, 32, 96, -26, -21, -91, -121, -103, 0, 103, 45}, new byte[]{-58, -113, -54, -23, -4, 46, 73, 3}));
        } catch (Throwable th) {
            Log.w(OooO0OO, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{6, -106, -48, 90, -122, 21, 123, -119, 21, -109, -61, 5, -98, 75, 110, -113, 19, -122, -62, 88}, new byte[]{ByteCompanionObject.MAX_VALUE, -29, -90, 98, -66, 45, 15, -26}) + th);
        }
    }
}
