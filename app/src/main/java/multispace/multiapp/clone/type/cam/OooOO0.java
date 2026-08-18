package multispace.multiapp.clone.type.cam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooOO0 {
    public static void OooO(byte[] bArr, int i, int i2, Image image) {
        int i3 = i;
        int i4 = i2;
        Image.Plane[] planes = image.getPlanes();
        int i5 = 0;
        int rowStride = (planes[0].getRowStride() * i4) - (planes[0].getRowStride() - i3);
        byte[] bArr2 = new byte[rowStride];
        int rowStride2 = ((planes[1].getRowStride() * i4) / 2) - (planes[1].getRowStride() - i3);
        byte[] bArr3 = new byte[rowStride2];
        int rowStride3 = ((planes[2].getRowStride() * i4) / 2) - (planes[2].getRowStride() - i3);
        byte[] bArr4 = new byte[rowStride3];
        System.currentTimeMillis();
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i5;
            while (i7 < i3) {
                int i8 = ((((i4 - 1) - i6) * i3) + i7) * 4;
                int i9 = bArr[i8];
                if (i9 < 0) {
                    i9 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i10 = bArr[i8 + 1];
                if (i10 < 0) {
                    i10 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i11 = bArr[i8 + 2];
                if (i11 < 0) {
                    i11 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int iOooO0O0 = (OooO0O0(i11, 25, (i9 * 66) + (i10 * 129), 128) >> 8) + 16;
                int iOooO0O1 = (OooO0O0(i11, 112, (i9 * (-38)) - (i10 * 74), 128) >> 8) + 128;
                int i12 = (((((i9 * 112) - (i10 * 94)) - (i11 * 18)) + 128) >> 8) + 128;
                int i13 = 255;
                if (iOooO0O0 < 16) {
                    iOooO0O0 = 16;
                } else if (iOooO0O0 > 255) {
                    iOooO0O0 = 255;
                }
                if (iOooO0O1 < 0) {
                    iOooO0O1 = 0;
                } else if (iOooO0O1 > 255) {
                    iOooO0O1 = 255;
                }
                if (i12 < 0) {
                    i13 = 0;
                } else if (i12 <= 255) {
                    i13 = i12;
                }
                bArr2[(planes[0].getRowStride() * i6) + i7] = (byte) iOooO0O0;
                int i14 = i6 >> 1;
                int i15 = i7 & (-2);
                byte b = (byte) iOooO0O1;
                bArr3[(planes[1].getRowStride() * i14) + i15 + 0] = b;
                byte b2 = (byte) i13;
                bArr3[(planes[1].getRowStride() * i14) + i15 + 1] = b2;
                bArr4[(planes[2].getRowStride() * i14) + i15 + 0] = b2;
                bArr4[(planes[2].getRowStride() * i14) + i15 + 1] = b;
                i7++;
                i3 = i;
                i4 = i2;
            }
            i6++;
            i3 = i;
            i4 = i2;
            i5 = 0;
        }
        int i16 = i5;
        ByteBuffer buffer = planes[i16].getBuffer();
        buffer.clear();
        buffer.put(bArr2, i16, rowStride);
        ByteBuffer buffer2 = planes[1].getBuffer();
        buffer2.clear();
        buffer2.put(bArr3, i16, rowStride2 - 1);
        ByteBuffer buffer3 = planes[2].getBuffer();
        buffer3.clear();
        buffer3.put(bArr4, i16, rowStride3 - 1);
    }

    public static byte[] OooO00o(Image image) throws Exception {
        int width = image.getWidth();
        int height = image.getHeight();
        ByteBuffer byteBufferOooO0Oo = OooO0Oo(image.getPlanes()[0].getBuffer(), image.getWidth(), image.getPlanes()[0].getRowStride(), image.getHeight(), false);
        ByteBuffer byteBufferOooO0Oo2 = OooO0Oo(image.getPlanes()[2].getBuffer(), image.getWidth(), image.getPlanes()[2].getRowStride(), image.getHeight() / 2, true);
        int iRemaining = byteBufferOooO0Oo.remaining();
        int iRemaining2 = byteBufferOooO0Oo2.remaining();
        int i = ((width * height) * 3) / 2;
        byte[] bArr = new byte[i];
        byteBufferOooO0Oo.get(bArr, 0, iRemaining);
        byteBufferOooO0Oo2.get(bArr, iRemaining, iRemaining2);
        ByteBuffer buffer = image.getPlanes()[1].getBuffer();
        bArr[i - 1] = buffer.get(buffer.capacity() - 1);
        return bArr;
    }

    public static int OooO0O0(int i, int i2, int i3, int i4) {
        return (i * i2) + i3 + i4;
    }

    public static int OooO0OO(int i) {
        return i < 0 ? i + multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo : i;
    }

    public static ByteBuffer OooO0Oo(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z) throws Exception {
        if (i == i2) {
            return byteBuffer;
        }
        byteBuffer.capacity();
        int i4 = i3 * i;
        byte[] bArr = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            byteBuffer.position(i5);
            if (z && i7 == i3 - 1) {
                i--;
            }
            try {
                byteBuffer.get(bArr, i6, i);
                i5 += i2;
                i6 += i;
            } catch (Exception e) {
                throw e;
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i4);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static void OooO0o(byte[] bArr, int i, int i2, Image image) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[(i3 * 3) / 2];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = ((((i2 - 1) - i4) * i) + i5) * 4;
                int i7 = bArr[i6];
                if (i7 < 0) {
                    i7 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i8 = bArr[i6 + 1];
                if (i8 < 0) {
                    i8 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i9 = bArr[i6 + 2];
                if (i9 < 0) {
                    i9 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int iOooO0O0 = (OooO0O0(i9, 25, (i7 * 66) + (i8 * 129), 128) >> 8) + 16;
                int iOooO0O1 = (OooO0O0(i9, 112, (i7 * (-38)) - (i8 * 74), 128) >> 8) + 128;
                int i10 = (((((i7 * 112) - (i8 * 94)) - (i9 * 18)) + 128) >> 8) + 128;
                int i11 = iOooO0O0 >= 16 ? iOooO0O0 > 255 ? 255 : iOooO0O0 : 16;
                if (iOooO0O1 < 0) {
                    iOooO0O1 = 0;
                } else if (iOooO0O1 > 255) {
                    iOooO0O1 = 255;
                }
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 > 255) {
                    i10 = 255;
                }
                bArr2[(i4 * i) + i5] = (byte) i11;
                int i12 = ((i4 >> 1) * i) / 2;
                int i13 = i5 >> 1;
                bArr2[i3 + i12 + i13] = (byte) iOooO0O1;
                bArr2[((i3 * 5) / 4) + i12 + i13] = (byte) i10;
            }
        }
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.clear();
        buffer.put(bArr2, 0, i3);
        ByteBuffer buffer2 = planes[1].getBuffer();
        buffer2.clear();
        float f = i;
        float f2 = i2;
        int i14 = (int) (0.25f * f * f2);
        buffer2.put(bArr2, i3, i14);
        ByteBuffer buffer3 = planes[2].getBuffer();
        buffer3.clear();
        buffer3.put(bArr2, (int) (f * 1.25f * f2), i14);
    }

    public static void OooO0o0(byte[] bArr, Image image) {
        Image.Plane[] planes = image.getPlanes();
        boolean z = planes[0].getRowStride() != planes[1].getRowStride() && planes[1].getPixelStride() == 1;
        if (image.getWidth() == planes[0].getRowStride()) {
            int width = image.getWidth();
            int height = image.getHeight();
            if (z) {
                OooO0o(bArr, width, height, image);
                return;
            } else {
                OooO0oo(bArr, width, height, image);
                return;
            }
        }
        int width2 = image.getWidth();
        int height2 = image.getHeight();
        if (z) {
            OooO0oO(bArr, width2, height2, image);
        } else {
            OooO(bArr, width2, height2, image);
        }
    }

    public static void OooO0oO(byte[] bArr, int i, int i2, Image image) {
        int i3 = i;
        int i4 = i2;
        Image.Plane[] planes = image.getPlanes();
        int i5 = 0;
        int rowStride = (planes[0].getRowStride() * i4) - (planes[0].getRowStride() - i3);
        byte[] bArr2 = new byte[rowStride];
        int rowStride2 = ((planes[1].getRowStride() * i4) / 4) - (planes[1].getRowStride() - i3);
        byte[] bArr3 = new byte[rowStride2];
        int rowStride3 = ((planes[2].getRowStride() * i4) / 4) - (planes[2].getRowStride() - i3);
        byte[] bArr4 = new byte[rowStride3];
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i5;
            while (i7 < i3) {
                int i8 = ((((i4 - 1) - i6) * i3) + i7) * 4;
                int i9 = bArr[i8];
                if (i9 < 0) {
                    i9 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i10 = bArr[i8 + 1];
                if (i10 < 0) {
                    i10 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i11 = bArr[i8 + 2];
                if (i11 < 0) {
                    i11 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int iOooO0O0 = (OooO0O0(i11, 25, (i9 * 66) + (i10 * 129), 128) >> 8) + 16;
                int iOooO0O1 = (OooO0O0(i11, 112, (i9 * (-38)) - (i10 * 74), 128) >> 8) + 128;
                int i12 = (((((i9 * 112) - (i10 * 94)) - (i11 * 18)) + 128) >> 8) + 128;
                int i13 = 255;
                if (iOooO0O0 < 16) {
                    iOooO0O0 = 16;
                } else if (iOooO0O0 > 255) {
                    iOooO0O0 = 255;
                }
                if (iOooO0O1 < 0) {
                    iOooO0O1 = 0;
                } else if (iOooO0O1 > 255) {
                    iOooO0O1 = 255;
                }
                if (i12 < 0) {
                    i13 = 0;
                } else if (i12 <= 255) {
                    i13 = i12;
                }
                bArr2[(planes[0].getRowStride() * i6) + i7] = (byte) iOooO0O0;
                int i14 = i6 >> 1;
                int i15 = i7 >> 1;
                bArr3[((planes[1].getRowStride() * i14) / 2) + i15] = (byte) iOooO0O1;
                bArr4[((planes[1].getRowStride() * i14) / 2) + i15] = (byte) i13;
                i7++;
                i3 = i;
                i4 = i2;
            }
            i6++;
            i3 = i;
            i4 = i2;
            i5 = 0;
        }
        int i16 = i5;
        ByteBuffer buffer = planes[i16].getBuffer();
        buffer.clear();
        buffer.put(bArr2, i16, rowStride);
        ByteBuffer buffer2 = planes[1].getBuffer();
        buffer2.clear();
        buffer2.put(bArr3, i16, rowStride2);
        ByteBuffer buffer3 = planes[2].getBuffer();
        buffer3.clear();
        buffer3.put(bArr4, i16, rowStride3);
    }

    public static void OooO0oo(byte[] bArr, int i, int i2, Image image) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3 * 2];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = ((((i2 - 1) - i4) * i) + i5) * 4;
                int i7 = bArr[i6];
                if (i7 < 0) {
                    i7 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i8 = bArr[i6 + 1];
                if (i8 < 0) {
                    i8 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i9 = bArr[i6 + 2];
                if (i9 < 0) {
                    i9 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int iOooO0O0 = (OooO0O0(i9, 25, (i7 * 66) + (i8 * 129), 128) >> 8) + 16;
                int iOooO0O1 = (OooO0O0(i9, 112, (i7 * (-38)) - (i8 * 74), 128) >> 8) + 128;
                int i10 = (((((i7 * 112) - (i8 * 94)) - (i9 * 18)) + 128) >> 8) + 128;
                int i11 = iOooO0O0 >= 16 ? iOooO0O0 > 255 ? 255 : iOooO0O0 : 16;
                if (iOooO0O1 < 0) {
                    iOooO0O1 = 0;
                } else if (iOooO0O1 > 255) {
                    iOooO0O1 = 255;
                }
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 > 255) {
                    i10 = 255;
                }
                bArr2[(i4 * i) + i5] = (byte) i11;
                int i12 = (i4 >> 1) * i;
                int i13 = i5 & (-2);
                int i14 = i3 + i12 + i13;
                byte b = (byte) iOooO0O1;
                bArr2[i14 + 0] = b;
                byte b2 = (byte) i10;
                bArr2[i14 + 1] = b2;
                int i15 = ((i3 * 3) / 2) + i12 + i13;
                bArr2[i15 + 0] = b2;
                bArr2[i15 + 1] = b;
            }
        }
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.clear();
        buffer.put(bArr2, 0, i3);
        ByteBuffer buffer2 = planes[1].getBuffer();
        buffer2.clear();
        int i16 = ((int) ((i * 0.5f) * i2)) - 1;
        buffer2.put(bArr2, i3, i16);
        ByteBuffer buffer3 = planes[2].getBuffer();
        buffer3.clear();
        buffer3.put(bArr2, (int) (((double) i) * 1.5d * ((double) i2)), i16);
    }

    public static byte[] OooOO0(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[(i3 * 3) / 2];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = ((((i2 - 1) - i4) * i) + i5) * 4;
                int i7 = bArr[i6];
                if (i7 < 0) {
                    i7 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i8 = bArr[i6 + 1];
                if (i8 < 0) {
                    i8 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i9 = bArr[i6 + 2];
                if (i9 < 0) {
                    i9 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int iOooO0O0 = (OooO0O0(i9, 25, (i7 * 66) + (i8 * 129), 128) >> 8) + 16;
                int iOooO0O1 = (OooO0O0(i9, 112, (i7 * (-38)) - (i8 * 74), 128) >> 8) + 128;
                int i10 = (((((i7 * 112) - (i8 * 94)) - (i9 * 18)) + 128) >> 8) + 128;
                int i11 = iOooO0O0 >= 16 ? iOooO0O0 > 255 ? 255 : iOooO0O0 : 16;
                if (iOooO0O1 < 0) {
                    iOooO0O1 = 0;
                } else if (iOooO0O1 > 255) {
                    iOooO0O1 = 255;
                }
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 > 255) {
                    i10 = 255;
                }
                bArr2[(i4 * i) + i5] = (byte) i11;
                int i12 = ((i4 >> 1) * i) + i3 + (i5 & (-2));
                bArr2[i12 + 0] = (byte) i10;
                bArr2[i12 + 1] = (byte) iOooO0O1;
            }
        }
        return bArr2;
    }

    public static byte[] OooOO0O(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[(i3 * 3) / 2];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = ((((i2 - 1) - i4) * i) + i5) * 4;
                int i7 = bArr[i6];
                if (i7 < 0) {
                    i7 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i8 = bArr[i6 + 1];
                if (i8 < 0) {
                    i8 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i9 = bArr[i6 + 2];
                if (i9 < 0) {
                    i9 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int iOooO0O0 = (OooO0O0(i9, 25, (i7 * 66) + (i8 * 129), 128) >> 8) + 16;
                int iOooO0O1 = (OooO0O0(i9, 112, (i7 * (-38)) - (i8 * 74), 128) >> 8) + 128;
                int i10 = (((((i7 * 112) - (i8 * 94)) - (i9 * 18)) + 128) >> 8) + 128;
                int i11 = iOooO0O0 >= 16 ? iOooO0O0 > 255 ? 255 : iOooO0O0 : 16;
                if (iOooO0O1 < 0) {
                    iOooO0O1 = 0;
                } else if (iOooO0O1 > 255) {
                    iOooO0O1 = 255;
                }
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 > 255) {
                    i10 = 255;
                }
                bArr2[(i4 * i) + i5] = (byte) i11;
                int i12 = ((i4 >> 1) * i) / 2;
                int i13 = i5 >> 1;
                bArr2[i3 + i12 + i13] = (byte) i10;
                bArr2[((i3 * 5) / 4) + i12 + i13] = (byte) iOooO0O1;
            }
        }
        return bArr2;
    }

    public static byte[] OooOO0o(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3 * 2];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = (i4 * i) + i5;
                int i7 = i6 * 4;
                int i8 = bArr[i7];
                if (i8 < 0) {
                    i8 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i9 = bArr[i7 + 1];
                if (i9 < 0) {
                    i9 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int i10 = bArr[i7 + 2];
                if (i10 < 0) {
                    i10 += multispace.multiapp.clone.util.OooOOO.OooO0O0.f170OooO0Oo;
                }
                int iOooO0O0 = (OooO0O0(i10, 25, (i8 * 66) + (i9 * 129), 128) >> 8) + 16;
                int iOooO0O1 = (OooO0O0(i10, 112, (i8 * (-38)) - (i9 * 74), 128) >> 8) + 128;
                int i11 = (((((i8 * 112) - (i9 * 94)) - (i10 * 18)) + 128) >> 8) + 128;
                int i12 = iOooO0O0 >= 16 ? iOooO0O0 > 255 ? 255 : iOooO0O0 : 16;
                if (iOooO0O1 < 0) {
                    iOooO0O1 = 0;
                } else if (iOooO0O1 > 255) {
                    iOooO0O1 = 255;
                }
                if (i11 < 0) {
                    i11 = 0;
                } else if (i11 > 255) {
                    i11 = 255;
                }
                bArr2[i6] = (byte) i12;
                int i13 = (i4 >> 1) * i;
                int i14 = i5 & (-2);
                int i15 = i3 + i13 + i14;
                byte b = (byte) iOooO0O1;
                bArr2[i15 + 0] = b;
                byte b2 = (byte) i11;
                bArr2[i15 + 1] = b2;
                int i16 = ((i3 * 3) / 2) + i13 + i14;
                bArr2[i16 + 0] = b2;
                bArr2[i16 + 1] = b;
            }
        }
        return bArr2;
    }

    public static Bitmap OooOOO0(byte[] bArr, int i, int i2) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmapDecodeByteArray;
    }
}
