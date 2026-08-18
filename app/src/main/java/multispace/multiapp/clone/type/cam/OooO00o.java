package multispace.multiapp.clone.type.cam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooO00o {
    public static byte[] OooO00o(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                return byteArray;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            byteArrayOutputStream = null;
            return null;
        }
    }

    public static Bitmap OooO0O0(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public static Bitmap OooO0OO(byte[] bArr, int i, int i2) {
        Bitmap bitmapDecodeByteArray = null;
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
            return bitmapDecodeByteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeByteArray;
        }
    }

    public static void OooO0Oo(Bitmap bitmap) {
        try {
            File file = new File(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-119, 35, -110, 109, -1, 60, -122, 121, -119, 53, -117, 119, -31, 60, -107, 121, -62, ByteCompanionObject.MAX_VALUE, -42, 45, -52, 51, -123, 110, -55, 57, -126, 45, -23, 60, -107, 125, -119, 51, -119, 111, -93, 63, ByteCompanionObject.MIN_VALUE, 114, -45, 50, -121, 44, -30, 59, -121, 111, -59, 34, -125, 103, -29, 115, -123, 121, -53, 63, -55, 100, -28, 49, -124, 111, -119, 50, -113, 118, -93, 55, -111, 123}, new byte[]{-90, 80, -26, 2, -115, 93, -31, 28}));
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            file.delete();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
