package multispace.multiapp.clone.type.cam;

import android.annotation.SuppressLint;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class o000oOoO implements Runnable {
    private static final boolean OooOo = false;
    private static final int OooOoO = 1;
    private static final long OooOoO0 = 10000;
    private static final int OooOoOO = 2;
    private LinkedBlockingQueue<byte[]> OooOO0O;
    private OooOo00 OooOO0o;
    private String OooOOO;
    private Throwable OooOOOO;
    private Thread OooOOOo;
    private OooO0o OooOOo;
    private Surface OooOOo0;
    private static final String OooOo0o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-56, 64, 113, -57, -21, -120, -101, -32, -20, 72, 120, -57, -9}, new byte[]{-98, 41, 21, -94, -124, -36, -12, -90});
    public static ImageReader OooOoo0 = null;
    private static boolean OooOoo = false;
    private final int OooOO0 = 2135033992;
    public boolean OooOOO0_f = false;
    private ImageReader OooOOoo = null;
    public OooOOO0 OooOo00_f = null;
    private boolean OooOo0 = false;
    private ImageReader.OnImageAvailableListener OooOo0O = new OooO00o();

    class OooO00o implements ImageReader.OnImageAvailableListener {
        OooO00o() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image imageAcquireNextImage = imageReader.acquireNextImage();
            try {
                o000oOoO o000oooo = o000oOoO.this;
                if (o000oooo.OooOOO0_f) {
                    imageAcquireNextImage.close();
                    return;
                }
                ImageReader imageReader2 = OooO.OoooOO0.get(o000oooo.OooOOo0);
                if (imageReader2 == null) {
                    imageAcquireNextImage.close();
                    return;
                }
                if (o000oOoO.this.OooOo0) {
                    imageAcquireNextImage.close();
                    return;
                }
                if (imageAcquireNextImage == null) {
                    Log.e(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-19, 18, 84, -83, 50}, new byte[]{-36, 35, 101, -100, 3, -4, -63, 74}), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{63, -68, -113, 60, -11, -33, -80, -81, 38, -77, -81, 61, -11, -38, -71, -117, 112, -85, -77, 39, -35, -43, -76, -119, 53, -14, -81, 34, -76, -42, -96, -126, 60, -4, -24}, new byte[]{80, -46, -58, 81, -108, -72, -43, -18}));
                    imageAcquireNextImage.close();
                } else {
                    o000oOoO.OooOoo0 = imageReader2;
                    o000oOoO o000oooo2 = o000oOoO.this;
                    o000oooo2.OooOo00_f.OooO0Oo(imageAcquireNextImage, imageReader2, o000oooo2);
                    o000oOoO.this.OooOo0 = true;
                }
            } catch (Throwable th) {
                try {
                    Log.e(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-48, 61, -18, -43, 67}, new byte[]{-31, 12, -33, -28, 114, -124, 71, 33}), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-99, -42, 67, 40, -115, 58, 58, -83, -124, -39, 99, 41, -115, 63, 51, -119, -56}, new byte[]{-14, -72, 10, 69, -20, 93, 95, -20}) + th);
                } finally {
                    imageAcquireNextImage.close();
                }
            }
        }
    }

    class OooO0O0 extends XC_MethodHook {
        OooO0O0() {
        }

        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            if (Log.getStackTraceString(new Throwable()).contains(OooOOO0.class.getCanonicalName())) {
                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-14, 87, 123, 121, -104, -56, 80, -91, -2, 87, 108, 109, -98, -43, 107, -83, -45, 81, 125, 40, ByteCompanionObject.MIN_VALUE, -24, 79, -95, -43, 83, 74, 109, -116, -64, 70, -91, -64, 111, 109, 126, -71, -50, 104, -80, -43, 12}, new byte[]{-78, 54, 24, 8, -19, -95, 34, -64}) + o000oOoO.this.OooOo00_f);
                methodHookParam.setResult(o000oOoO.this.OooOo00_f.OooO0OO());
            }
        }
    }

    class OooO0OO extends XC_MethodHook {
        OooO0OO() {
        }

        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            if (Log.getStackTraceString(new Throwable()).contains(OooOOO0.class.getCanonicalName())) {
                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{9, -33, -8, 4, 123, 93, -76, 82, 7, -37, -29, 1, 71, 89, -89, 80, 44, -98, -10, 60, 99, 85, -95, 82, 27, -37, -6, 20, 106, 81, -76, 110, 60, -56, -49, 26, 68, 68, -95, 13}, new byte[]{73, -66, -101, 117, 14, 52, -58, 55}) + o000oOoO.this.OooOo00_f);
                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{44, -52, 82, 119, 121, -121, 64, 110, 34, -56, 73, 114, 69, -125, 83, 108, 9, -115, 92, 79, 97, -113, 85, 110, 62, -56, 80, 103, 104, -117, 64, 82, 25, -37, 101, 105, 70, -98, 85, 49}, new byte[]{108, -83, 49, 6, 12, -18, 50, 11}) + o000oOoO.this.OooOo00_f + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{110, 67, -103, 44, -120, 117, 105}, new byte[]{66, 51, -21, 67, -16, 12, 83, -62}) + o000oOoO.this.OooOo00_f.OooO0OO() + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{82, 63, 34, 76, -110, 67, -27}, new byte[]{126, 93, 87, 42, -9, 49, -33, -40}) + o000oOoO.this.OooOo00_f.OooO0OO().getPlanes()[0].getBuffer());
                methodHookParam.setResult(o000oOoO.this.OooOo00_f.OooO0OO());
            }
        }
    }

    public interface OooO0o {
        void OooO00o(int i);

        void OooO0O0();
    }

    private static boolean OooO(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }

    private static byte[] OooO0o(Image image, int i) {
        int i2;
        int i3 = i;
        int i4 = 2;
        int i5 = 1;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{80, 111, 60, -101, -101, -84, 39, 12, 79, 110, 34, -106, -101, -100, 29, 48, 112, 83, 15, -92, -44, -83, 63, 29, 75, 72, 100, -48, -117, -1, 51, 18, 91, 33, 19, -83, -9, -112, 0, 35, 121, 110, 34, -113, -38, -85, 28, 42, 13, 48}, new byte[]{63, 1, 80, -30, -69, -33, 82, 124}));
        }
        if (!OooO(image)) {
            throw new RuntimeException(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{16, -71, 119, 92, -114, 24, 101, 12, 29, -82, 124, 9, -114, 24, 79, 14, 18, -65, 124, 91, -114, 87, 38, 1, 10, -84, 124, 91, -101, 74, 116, 2, 10, -12, 57, 29, -107, 74, 107, 2, 7, -8}, new byte[]{115, -40, 25, 123, -6, 56, 6, 99}) + image.getFormat());
        }
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int iWidth = cropRect.width();
        int iHeight = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i6 = iWidth * iHeight;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format) * i6) / 8];
        int i7 = 0;
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < planes.length) {
            if (i9 == 0) {
                i8 = i5;
                i10 = i7;
            } else if (i9 != i5) {
                if (i9 == i4) {
                    if (i3 == i5) {
                        i10 = (int) (((double) i6) * 1.25d);
                        i8 = i5;
                    } else if (i3 == i4) {
                        i8 = i4;
                        i10 = i6;
                    }
                }
            } else if (i3 == i5) {
                i8 = i5;
                i10 = i6;
            } else if (i3 == i4) {
                i10 = i6 + 1;
                i8 = i4;
            }
            ByteBuffer buffer = planes[i9].getBuffer();
            int rowStride = planes[i9].getRowStride();
            int pixelStride = planes[i9].getPixelStride();
            int i11 = i9 == 0 ? i7 : i5;
            int i12 = iWidth >> i11;
            int i13 = iHeight >> i11;
            int i14 = iWidth;
            buffer.position(((cropRect.left >> i11) * pixelStride) + ((cropRect.top >> i11) * rowStride));
            int i15 = 0;
            while (i15 < i13) {
                if (pixelStride == 1 && i8 == 1) {
                    buffer.get(bArr, i10, i12);
                    i10 += i12;
                    i2 = i12;
                } else {
                    i2 = ((i12 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    for (int i16 = 0; i16 < i12; i16++) {
                        bArr[i10] = bArr2[i16 * pixelStride];
                        i10 += i8;
                    }
                }
                if (i15 < i13 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
                i15++;
                cropRect = cropRect;
            }
            i9++;
            i3 = i;
            iWidth = i14;
            i4 = 2;
            i5 = 1;
            i7 = 0;
        }
        return bArr;
    }

    private void OooO0o0(MediaCodec mediaCodec, MediaExtractor mediaExtractor, MediaFormat mediaFormat) {
        Surface surface;
        int iDequeueInputBuffer;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        ImageReader imageReader = OooO.OoooOO0.get(this.OooOOo0);
        if (!this.OooOO0o.equals(OooOo00.JPEG) || imageReader == null) {
            surface = this.OooOOo0;
        } else {
            this.OooOOoo = ImageReader.newInstance(imageReader.getWidth(), imageReader.getHeight(), 35, imageReader.getMaxImages());
            if (this.OooOo00_f == null) {
                this.OooOo00_f = OooOOO0.OooO00o();
            }
            this.OooOOoo.setOnImageAvailableListener(this.OooOo0O, new Handler(Looper.getMainLooper()));
            surface = this.OooOOoo.getSurface();
        }
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        mediaCodec.start();
        mediaFormat.getInteger(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{101, 56, -95, 16, 106}, new byte[]{18, 81, -59, 100, 2, 52, 8, 99}));
        mediaFormat.getInteger(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-46, ByteCompanionObject.MIN_VALUE, -54, -21, 43, 49}, new byte[]{-70, -27, -93, -116, 67, 69, -46, -41}));
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        boolean z3 = false;
        long jCurrentTimeMillis = 0;
        while (!z && !this.OooOOO0_f) {
            if (!z2 && (iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(OooOoO0)) >= 0) {
                int sampleData = mediaExtractor.readSampleData(mediaCodec.getInputBuffer(iDequeueInputBuffer), 0);
                if (sampleData < 0) {
                    z2 = true;
                    mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                } else {
                    mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, mediaExtractor.getSampleTime(), 0);
                    mediaExtractor.advance();
                }
            }
            int iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
            if (iDequeueOutputBuffer >= 0) {
                boolean z4 = (bufferInfo.flags & 4) != 0 ? true : z;
                if (bufferInfo.size != 0) {
                    int i2 = i + 1;
                    OooO0o oooO0o = this.OooOOo;
                    if (oooO0o != null) {
                        oooO0o.OooO00o(i2);
                    }
                    if (!z3) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                        z3 = true;
                    }
                    if (this.OooOOo0 == null) {
                        Image outputImage = mediaCodec.getOutputImage(iDequeueOutputBuffer);
                        ByteBuffer buffer = outputImage.getPlanes()[0].getBuffer();
                        byte[] bArr = new byte[buffer.remaining()];
                        buffer.get(bArr);
                        LinkedBlockingQueue<byte[]> linkedBlockingQueue = this.OooOO0O;
                        if (linkedBlockingQueue != null) {
                            try {
                                linkedBlockingQueue.put(bArr);
                            } catch (InterruptedException e) {
                                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{0, -86, -36, -127, -29, 100, -62, -27, 99, -69}, new byte[]{-29, 42, 76, -41, -96, 37, -113, 6}) + e.toString());
                            }
                        }
                        if (this.OooOO0o != null) {
                            OooO.OooOOOo = OooO0o(outputImage, 2);
                        }
                        outputImage.close();
                    }
                    long jCurrentTimeMillis2 = (bufferInfo.presentationTimeUs / 1000) - (System.currentTimeMillis() - jCurrentTimeMillis);
                    if (jCurrentTimeMillis2 > 0) {
                        try {
                            Thread.sleep(jCurrentTimeMillis2);
                        } catch (InterruptedException e2) {
                            multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-49, -23, 5, 1, 106, 89, 72, -54, -84, -8}, new byte[]{44, 105, -107, 87, 41, 24, 5, 41}) + e2.toString());
                            multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{24, 110, 79, -50, -22, 114, 76, -122, 123, ByteCompanionObject.MAX_VALUE, 56, 34, 22, -44, -87, -18, 30, 85, 105, 112, 22, -84, -28, -30, 65, 7, 75, 1}, new byte[]{-5, -18, -33, -104, -87, 51, 1, 101}));
                        }
                    }
                    mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, true);
                    z = z4;
                    i = i2;
                } else {
                    z = z4;
                }
            }
        }
        OooO0o oooO0o2 = this.OooOOo;
        if (oooO0o2 != null) {
            oooO0o2.OooO0O0();
        }
    }

    private void OooO0oO() {
        if (OooOoo) {
            return;
        }
        OooOoo = true;
        XposedHelpers.findAndHookMethod(ImageReader.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-29, 26, 33, -46, -22, -71, 88, 7, -29, 13, 53, -44, -9, -126, 80, 42, -27, 28}, new byte[]{-126, 121, 80, -89, -125, -53, 61, 75}), new Object[]{new OooO0O0()});
        XposedHelpers.findAndHookMethod(ImageReader.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-112, -112, 84, -17, 102, 56, 122, -77, -108, -117, 81, -45, 98, 43, 120, -104}, new byte[]{-15, -13, 37, -102, 15, 74, 31, -3}), new Object[]{new OooO0OO()});
    }

    private boolean OooO0oo(int i, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        for (int i2 : codecCapabilities.colorFormats) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static int OooOO0(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{61, -90, -11, 9}, new byte[]{80, -49, -104, 108, 83, 38, -41, -114})).startsWith(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{9, 123, 59, 40, 47, 28}, new byte[]{ByteCompanionObject.MAX_VALUE, 18, 95, 77, 64, 51, 55, 11}))) {
                return i;
            }
        }
        return -1;
    }

    private void OooOOOO(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        System.out.print(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-20, -33, -37, -89, -33, 24, 2, 70, -5, -118, -56, -72, -36, 5, 4, 3, -7, -59, -39, -70, -47, 30, 76, 3}, new byte[]{-97, -86, -85, -41, -80, 106, 118, 35}));
        for (int i : codecCapabilities.colorFormats) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public void OooO0Oo(String str) throws Throwable {
        this.OooOOO = str;
        if (this.OooOOOo == null) {
            Thread thread = new Thread(this, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-109, -55, 19, 99, 26, 42}, new byte[]{-9, -84, 112, 12, 126, 79, -20, -125}));
            this.OooOOOo = thread;
            thread.start();
            Throwable th = this.OooOOOO;
            if (th != null) {
                throw th;
            }
        }
    }

    public void OooOO0O(OooO0o oooO0o) {
        this.OooOOo = oooO0o;
    }

    public void OooOO0o(LinkedBlockingQueue<byte[]> linkedBlockingQueue) {
        this.OooOO0O = linkedBlockingQueue;
    }

    public void OooOOO(Surface surface) {
        if (surface != null) {
            this.OooOOo0 = surface;
        }
    }

    public void OooOOO0(String str, OooOo00 oooOo00) throws IOException {
        this.OooOO0o = oooOo00;
    }

    public void OooOOOo() {
        this.OooOOO0_f = true;
    }

    @SuppressLint({"WrongConstant"})
    public void OooOOo0(String str) throws Throwable {
        Throwable th;
        Exception exc;
        OooOOO0 oooOOO0 = null;
        String strOooO00o;
        multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{4, -82, 122, -31, -47, -106, 100, 89, 103, -65, 9, 55, 2, -77, 76, -39, -120, 74, -113, -59, 113, 87, -72, 95, 91, -82, 15, 16, 25, 63, -114, 25, 0, -114, 107}, new byte[]{-25, 46, -22, -73, -110, -41, 41, -70}));
        MediaExtractor mediaExtractor = null;
        MediaCodec mediaCodec = null;
        try {
            try {
                new File(str);
                MediaExtractor mediaExtractor2 = new MediaExtractor();
                try {
                    mediaExtractor2.setDataSource(str);
                    int iOooOO0 = OooOO0(mediaExtractor2);
                    if (iOooOO0 < 0) {
                        multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{77, 116, -45, 47, 66, -94, -96, 70, 46, 101, -96, -7, -111, -121, -120, -58, -63, -112, 38, 11, -30, 99, 124, -21, -63, -44, 53, 16, 101, -122, -126, -123, -38, -122, 34, 26, 106, -61, -117, -54, -37, -102, 39, 89, 104, -115, -51}, new byte[]{-82, -12, 67, 121, 1, -29, -19, -91}) + str);
                    }
                    mediaExtractor2.selectTrack(iOooOO0);
                    MediaFormat trackFormat = mediaExtractor2.getTrackFormat(iOooOO0);
                    String string = trackFormat.getString(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{4, -37, -3, 43}, new byte[]{105, -78, -112, 78, -33, 27, -56, 79}));
                    MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(string);
                    try {
                        OooOOOO(mediaCodecCreateDecoderByType.getCodecInfo().getCapabilitiesForType(string));
                        if (OooO0oo(2135033992, mediaCodecCreateDecoderByType.getCodecInfo().getCapabilitiesForType(string))) {
                            trackFormat.setInteger(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-36, -83, -17, 23, -39, -42, 56, -65, -51, -81, -30, 12}, new byte[]{-65, -62, -125, 120, -85, -5, 94, -48}), 2135033992);
                            strOooO00o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{101, -62, 9, -24, 107, -103, 106, -91, 6, -45, 122, 62, -72, -68, 66, 37, -23, 38, -4, -52, -53, 88, -74, 53, -29, 54, -71, -38, 77, -69, 72, 34, -29, 98, -6, -47, 68, -73, 85, 102, -32, 45, -21, -45, 73, -84, 7, 50, -23, 98, -19, -57, 88, -67, 7, 116, -73, 113, -84, -114, 27, -21, 30, ByteCompanionObject.MAX_VALUE, -76}, new byte[]{-122, 66, -103, -66, 40, -40, 39, 70});
                        } else {
                            Log.i(OooOo0o, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-76, -81, -119, 126, -47, -23, -30, -18, -82, -31, -101, 121, -55, -84, -90, -1, -94, -82, -116, 121, -99, -17, -83, -10, -82, -77, -56, 122, -46, -2, -81, -5, -75, -19, -56, ByteCompanionObject.MAX_VALUE, -46, -32, -83, -24, -31, -89, -121, 110, -48, -19, -74, -70, -75, -72, -104, 121, -99, -66, -13, -87, -12, -15, -37, 47, -124, -75, -16, -70, -81, -82, -100, 60, -50, -7, -78, -22, -82, -77, -100, 121, -39}, new byte[]{-63, -63, -24, 28, -67, -116, -62, -102}));
                            strOooO00o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{115, -6, 47, -2, 83, 45, ByteCompanionObject.MAX_VALUE, -4, 16, -21, 92, 40, ByteCompanionObject.MIN_VALUE, 8, 87, 124, -1, 30, -38, -38, -13, -20, -93, 106, -2, 27, -35, -60, 117, 76, 70, 112, -80, 9, -38, -36, 48, 8, 87, 124, -1, 30, -38, -120, 115, 3, 94, 112, -30, 90, -39, -57, 98, 1, 83, 107, -68, 90, -36, -57, 124, 3, 64, 63, -10, 21, -51, -59, 113, 24, 18, 107, -23, 10, -38, -120, 34, 93, 1, 42, -96, 73, -116, -111, 41, 94, 18, 113, -1, 14, -97, -37, 101, 28, 66, 112, -30, 14, -38, -52}, new byte[]{-112, 122, -65, -88, 16, 108, 50, 31});
                        }
                        multispace.multiapp.clone.util.Oooo000.OooO00o(strOooO00o);
                        OooO0o0(mediaCodecCreateDecoderByType, mediaExtractor2, trackFormat);
                        mediaCodecCreateDecoderByType.stop();
                        while (!this.OooOOO0_f) {
                            mediaExtractor2.seekTo(0L, 0);
                            OooO0o0(mediaCodecCreateDecoderByType, mediaExtractor2, trackFormat);
                            mediaCodecCreateDecoderByType.stop();
                        }
                        mediaCodecCreateDecoderByType.stop();
                        mediaCodecCreateDecoderByType.release();
                        mediaExtractor2.release();
                        oooOOO0 = this.OooOo00_f;
                        if (oooOOO0 == null) {
                            return;
                        }
                    } catch (Exception e) {
                        exc = e;
                        mediaExtractor = mediaExtractor2;
                        mediaCodec = mediaCodecCreateDecoderByType;
                        multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-37, -100, 79, -48, 92, 116, 61, -112, -72, -115, -124, -16, 118, 81, 21, 28, 94, 117, -77, -29, 66}, new byte[]{56, 28, -33, -122, 31, 53, 112, 115}) + exc.toString());
                        if (mediaCodec != null) {
                            mediaCodec.stop();
                            mediaCodec.release();
                        }
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        oooOOO0 = this.OooOo00_f;
                        if (oooOOO0 == null) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        mediaExtractor = mediaExtractor2;
                        mediaCodec = mediaCodecCreateDecoderByType;
                        if (mediaCodec != null) {
                            mediaCodec.stop();
                            mediaCodec.release();
                        }
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        OooOOO0 oooOOO1 = this.OooOo00_f;
                        if (oooOOO1 == null) {
                            throw th;
                        }
                        try {
                            oooOOO1.OooO0O0();
                        } catch (Throwable unused) {
                        }
                        this.OooOo00_f = null;
                        throw th;
                    }
                } catch (Exception e2) {
                    exc = e2;
                    mediaExtractor = mediaExtractor2;
                } catch (Throwable th3) {
                    th = th3;
                    mediaExtractor = mediaExtractor2;
                }
            } catch (Exception e3) {
                exc = e3;
            }
            try {
                if (oooOOO0 != null) {
                    oooOOO0.OooO0O0();
                }
            } catch (Throwable unused2) {
            }
            this.OooOo00_f = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            OooOOo0(this.OooOOO);
        } catch (Throwable th) {
            this.OooOOOO = th;
        }
    }
}
