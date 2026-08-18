package multispace.multiapp.clone.type.cam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.ImageReader;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.ByteCompanionObject;
import org.osmdroid.library.BuildConfig;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooO {
    public static Surface OooO_f;
    public static SurfaceTexture OooOO0;
    public static MediaPlayer OooOO0O;
    public static SurfaceTexture OooOO0o;
    public static Camera OooOOO;
    public static Camera OooOOO0;
    public static Camera OooOOOO;
    public static int OooOOo;
    public static byte[] OooOOo0;
    public static int OooOOoo;
    public static multispace.multiapp.clone.type.cam.o000oOoO OooOo;
    public static boolean OooOo0;
    public static boolean OooOo00;
    public static multispace.multiapp.clone.type.cam.o000oOoO OooOo0O;
    public static multispace.multiapp.clone.type.cam.o000oOoO OooOo0o;
    public static Surface OooOoO;
    public static SurfaceTexture OooOoO0;
    public static SurfaceHolder OooOoOO;
    public static Camera OooOoo;
    public static MediaPlayer OooOoo0;
    public static int OooOooO;
    public static int OooOooo;
    public static CaptureRequest.Builder Oooo;
    public static Surface Oooo0;
    public static Class Oooo000;
    public static Surface Oooo00O;
    public static Surface Oooo00o;
    public static Surface Oooo0O0;
    public static MediaPlayer Oooo0OO;
    public static Surface Oooo0o;
    public static MediaPlayer Oooo0o0;
    public static SurfaceTexture Oooo0oO;
    public static CameraDevice.StateCallback Oooo0oo;
    public static Class OoooO;
    public static SessionConfiguration OoooO0;
    public static SessionConfiguration OoooO00;
    public static OutputConfiguration OoooO0O;
    public static int o000oOoO;
    public boolean OooO0O0;
    private Context OooO0oo;
    public static volatile byte[] OooOOOo = {0};
    public static HashMap<Surface, ImageReader> OoooOO0 = new HashMap<>();
    public static HashMap<String, Integer> OoooOOO = new HashMap<>();
    public int OooO00o = 0;
    public boolean OooO0OO = false;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public boolean f155OooO0Oo = true;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public int f157OooO0o0 = 1280;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public int f156OooO0o = 720;

    /* JADX INFO: renamed from: OooO0oO, reason: collision with root package name */
    private multispace.multiapp.clone.type.cam.OooO0OO f158OooO0oO = null;

    /* JADX INFO: renamed from: multispace.multiapp.clone.type.cam.OooO$OooO, reason: collision with other inner class name */
    class C0070OooO extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        C0070OooO(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            Object obj = methodHookParam.thisObject;
            if (obj == null || obj.equals(OooO.Oooo)) {
                return;
            }
            OooO.Oooo = (CaptureRequest.Builder) methodHookParam.thisObject;
            if (!this.OooOO0.OooO00o() && OooO.this.OooO0OO) {
                multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{60, 79, 53, 1, -72, -28, -25, -58, 30, 6, 52, 28, -66, -73, -3, -121}, new byte[]{106, 38, 81, 100, -41, -60, -119, -87}));
            } else if (this.OooOO0.OooO0O0) {
                OooO.this.OooOo00();
            }
        }
    }

    class OooO00o extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        /* JADX INFO: renamed from: multispace.multiapp.clone.type.cam.OooO$OooO00o$OooO00o, reason: collision with other inner class name */
        class C0071OooO00o implements MediaPlayer.OnPreparedListener {
            C0071OooO00o() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                OooO.OooOoo0.start();
            }
        }

        class OooO0O0 implements MediaPlayer.OnPreparedListener {
            OooO0O0() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                OooO.OooOO0O.start();
            }
        }

        OooO00o(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            Surface surface;
            MediaPlayer mediaPlayer;
            MediaPlayer mediaPlayer2;
            if (!this.OooOO0.OooO00o()) {
                if (OooO.this.OooO0OO) {
                    multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-4, 10, 84, 20, 47, -108, 100, -59, -34, 67, 85, 9, 41, -57, 126, -124}, new byte[]{-86, 99, 48, 113, 64, -76, 10, -86}));
                    return;
                }
                return;
            }
            if (this.OooOO0.OooO0O0) {
                OooO.OooOo00 = false;
                OooO.OooOOOO = (Camera) methodHookParam.thisObject;
                if (OooO.OooOoOO != null) {
                    MediaPlayer mediaPlayer3 = OooO.OooOoo0;
                    if (mediaPlayer3 == null) {
                        mediaPlayer2 = new MediaPlayer();
                    } else {
                        mediaPlayer3.release();
                        OooO.OooOoo0 = null;
                        mediaPlayer2 = new MediaPlayer();
                    }
                    OooO.OooOoo0 = mediaPlayer2;
                    if (!OooO.OooOoOO.getSurface().isValid() || OooO.OooOoOO == null) {
                        return;
                    }
                    OooO.OooOoo0.setSurface(OooO.OooOoOO.getSurface());
                    if (!this.OooOO0.f162OooO0Oo || OooO.OooOo00) {
                        OooO.OooOoo0.setVolume(0.0f, 0.0f);
                        OooO.OooOo00 = false;
                    } else {
                        OooO.OooOo00 = true;
                    }
                    OooO.OooOoo0.setLooping(true);
                    OooO.OooOoo0.setOnPreparedListener(new C0071OooO00o());
                    try {
                        OooO.OooOoo0.setDataSource(OooO.this.f158OooO0oO.OooO00o);
                        OooO.OooOoo0.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                        multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-114, -34, -67, 46, -68, -63, 85, -3, -65, -37, -80, 109}, new byte[]{-34, -78, -36, 87, -39, -77, 117, -101}) + e.toString());
                    }
                }
                if (OooO.OooOO0 != null) {
                    Surface surface2 = OooO.OooO_f;
                    if (surface2 == null) {
                        surface = new Surface(OooO.OooOO0);
                    } else {
                        surface2.release();
                        surface = new Surface(OooO.OooOO0);
                    }
                    OooO.OooO_f = surface;
                    MediaPlayer mediaPlayer4 = OooO.OooOO0O;
                    if (mediaPlayer4 == null) {
                        mediaPlayer = new MediaPlayer();
                    } else {
                        mediaPlayer4.release();
                        mediaPlayer = new MediaPlayer();
                    }
                    OooO.OooOO0O = mediaPlayer;
                    OooO.OooOO0O.setSurface(OooO.OooO_f);
                    if (!this.OooOO0.f162OooO0Oo || OooO.OooOo00) {
                        OooO.OooOO0O.setVolume(0.0f, 0.0f);
                        OooO.OooOo00 = false;
                    } else {
                        OooO.OooOo00 = true;
                    }
                    OooO.OooOO0O.setLooping(true);
                    OooO.OooOO0O.setOnPreparedListener(new OooO0O0());
                    try {
                        OooO.OooOO0O.setDataSource(this.OooOO0.OooO00o);
                        OooO.OooOO0O.prepare();
                    } catch (IOException e2) {
                        multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{6, 42, 70, -91, 25, -115, 2, 100, 55, 47, 75, -18, 70}, new byte[]{86, 70, 39, -36, 124, -1, 34, 2}) + e2.toString());
                    }
                }
            }
        }
    }

    class OooO0O0 extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        OooO0O0(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            SurfaceTexture surfaceTexture;
            Surface surface;
            if (!this.OooOO0.OooO00o()) {
                if (OooO.this.OooO0OO) {
                    multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{20, -37, 119, -29, -31, 41, -29, 89, 54, -110, 118, -2, -25, 122, -7, 24}, new byte[]{66, -78, 19, -122, -114, 9, -115, 54}));
                    return;
                }
                return;
            }
            if (this.OooOO0.OooO0O0) {
                OooO.OooOoo = (Camera) methodHookParam.thisObject;
                OooO.OooOoOO = (SurfaceHolder) methodHookParam.args[0];
                SurfaceTexture surfaceTexture2 = OooO.OooOoO0;
                if (surfaceTexture2 == null) {
                    surfaceTexture = new SurfaceTexture(11);
                } else {
                    surfaceTexture2.release();
                    OooO.OooOoO0 = null;
                    surfaceTexture = new SurfaceTexture(11);
                }
                OooO.OooOoO0 = surfaceTexture;
                Surface surface2 = OooO.OooOoO;
                if (surface2 == null) {
                    surface = new Surface(OooO.OooOoO0);
                } else {
                    surface2.release();
                    OooO.OooOoO = null;
                    surface = new Surface(OooO.OooOoO0);
                }
                OooO.OooOoO = surface;
                OooO.OooOo0 = true;
                OooO.OooOoo.setPreviewTexture(OooO.OooOoO0);
                methodHookParam.setResult((Object) null);
            }
        }
    }

    class OooO0OO extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        OooO0OO(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            if (methodHookParam.args[0] == null || methodHookParam.thisObject == null) {
                return;
            }
            if (!this.OooOO0.OooO00o()) {
                if (OooO.this.OooO0OO) {
                    multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-99, 5, 94, 120, -53, -125, 121, -91, -65, 76, 95, 101, -51, -48, 99, -28}, new byte[]{-53, 108, 58, 29, -92, -93, 23, -54}));
                    return;
                }
                return;
            }
            if (!methodHookParam.args[0].equals(OooO.Oooo0o) && this.OooOO0.OooO0O0) {
                if (methodHookParam.args[0].toString().contains(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-15, -12, -23, -51, -15, -76, 34, 48, -52, -32, -10, -50, -83, -71, 50, 116, -50, -88}, new byte[]{-94, -127, -101, -85, -112, -41, 71, 24}))) {
                    Surface surface = OooO.Oooo0;
                    if (surface == null) {
                        OooO.Oooo0 = (Surface) methodHookParam.args[0];
                    } else if (!surface.equals(methodHookParam.args[0]) && OooO.Oooo0O0 == null) {
                        OooO.Oooo0O0 = (Surface) methodHookParam.args[0];
                    }
                } else {
                    Surface surface2 = OooO.Oooo00O;
                    if (surface2 == null) {
                        OooO.Oooo00O = (Surface) methodHookParam.args[0];
                    } else if (!surface2.equals(methodHookParam.args[0]) && OooO.Oooo00o == null) {
                        OooO.Oooo00o = (Surface) methodHookParam.args[0];
                    }
                }
                methodHookParam.args[0] = OooO.Oooo0o;
            }
        }
    }

    class OooO0o extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        OooO0o(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            if (methodHookParam.args[0] == null || methodHookParam.thisObject == null) {
                return;
            }
            if (!this.OooOO0.OooO00o()) {
                if (OooO.this.OooO0OO) {
                    multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-6, 8, -49, -40, 46, 98, -92, 92, -40, 65, -50, -59, 40, 49, -66, 29}, new byte[]{-84, 97, -85, -67, 65, 66, -54, 51}));
                }
            } else if (this.OooOO0.OooO0O0) {
                Surface surface = (Surface) methodHookParam.args[0];
                OooO.OoooOO0.remove(surface);
                if (surface.equals(OooO.Oooo00O)) {
                    OooO.Oooo00O = null;
                }
                if (surface.equals(OooO.Oooo00o)) {
                    OooO.Oooo00o = null;
                }
                if (surface.equals(OooO.Oooo0O0)) {
                    OooO.Oooo0O0 = null;
                }
                if (surface.equals(OooO.Oooo0)) {
                    OooO.Oooo0 = null;
                }
            }
        }
    }

    class OooOO0 extends XC_MethodHook {
        OooOO0() {
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            String stackTraceString = Log.getStackTraceString(new Throwable());
            if (stackTraceString.contains(multispace.multiapp.clone.type.cam.o000oOoO.class.getCanonicalName()) || stackTraceString.contains(multispace.multiapp.clone.type.cam.OooOOO0.class.getCanonicalName())) {
                return;
            }
            OooO.this.f157OooO0o0 = ((Integer) methodHookParam.args[0]).intValue();
            OooO.this.f156OooO0o = ((Integer) methodHookParam.args[1]).intValue();
            OooO.this.OooO00o = ((Integer) methodHookParam.args[2]).intValue();
            ImageReader imageReader = (ImageReader) methodHookParam.getResult();
            OooO.OoooOO0.put(imageReader.getSurface(), imageReader);
            if (OooO.this.f155OooO0Oo) {
                multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-117, 26, 97, -14, -54, -70, -42, 27, -79, 55, 105, -31, ByteCompanionObject.MIN_VALUE, -31, -22, 27, -89, 26, 98, -32, -39, -66, -22, 29, -75, 14, 44, -48, -52, -78, -31, 12, -79, 115, ByteCompanionObject.MAX_VALUE, -6, -41, -70, -92, 22, -75, 33, 105, -77, -60, -84, -92, 37, -89, 58, 104, -25, -59, -27}, new byte[]{-48, 83, 12, -109, -83, -33, -124, 126}) + OooO.this.f157OooO0o0 + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-51, 22, -90, 97, -45, 108, 35, 118}, new byte[]{-31, 126, -61, 8, -76, 4, 87, 76}) + OooO.this.f156OooO0o + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{45}, new byte[]{112, -62, 41, -112, 83, -127, 40, -73}));
            }
        }
    }

    class OooOO0O extends XC_MethodHook {
        OooOO0O() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{74, ByteCompanionObject.MIN_VALUE, -127, -29, 23, 123, 25, 73, 64, -88, -93, -21, 11, 106, 8, 1}, new byte[]{37, -18, -62, -126, 103, 15, 108, 59}) + ((CaptureFailure) methodHookParam.args[2]).getReason());
        }
    }

    class OooOOO extends XC_MethodHook {
        OooOOO() {
        }

        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            if (!Log.getStackTraceString(new Throwable()).contains(multispace.multiapp.clone.type.cam.OooOOO0.class.getCanonicalName())) {
                multispace.multiapp.clone.type.cam.o000oOoO o000oooo = OooO.OooOo0o;
                if (multispace.multiapp.clone.type.cam.o000oOoO.OooOoo0 != methodHookParam.thisObject) {
                    return;
                }
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo2 = OooO.OooOo0o;
            if (o000oooo2 == null && (o000oooo2 = OooO.OooOo) == null) {
                return;
            }
            methodHookParam.setResult(o000oooo2.OooOo00_f.OooO0OO());
        }
    }

    class OooOOO0 extends XC_MethodHook {
        OooOOO0() {
        }

        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            if (!Log.getStackTraceString(new Throwable()).contains(multispace.multiapp.clone.type.cam.OooOOO0.class.getCanonicalName())) {
                multispace.multiapp.clone.type.cam.o000oOoO o000oooo = OooO.OooOo0o;
                if (multispace.multiapp.clone.type.cam.o000oOoO.OooOoo0 != methodHookParam.thisObject) {
                    return;
                }
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo2 = OooO.OooOo0o;
            if (o000oooo2 == null && (o000oooo2 = OooO.OooOo) == null) {
                return;
            }
            methodHookParam.setResult(o000oooo2.OooOo00_f.OooO0OO());
        }
    }

    class OooOOOO extends XC_MethodHook {
        OooOOOO() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            int iIntValue = ((Integer) methodHookParam.args[0]).intValue();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(iIntValue, cameraInfo);
            OooO.o000oOoO = cameraInfo.orientation;
        }
    }

    class OooOo extends XC_MethodHook {
        OooOo() {
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            OooO.OoooOOO.put((String) methodHookParam.args[0], Integer.valueOf(((Integer) ((CameraCharacteristics) methodHookParam.getResult()).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue()));
        }
    }

    class OooOo00 extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        OooOo00(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            SurfaceTexture surfaceTexture;
            if (!this.OooOO0.OooO00o()) {
                if (OooO.this.OooO0OO) {
                    multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{2, 34, -24, -19, 34, 80, -98, -56, 32, 107, -23, -16, 36, 3, -124, -119}, new byte[]{84, 75, -116, -120, 77, 112, -16, -89}));
                    return;
                }
                return;
            }
            if (this.OooOO0.OooO0O0) {
                if (OooO.OooOo0) {
                    OooO.OooOo0 = false;
                    return;
                }
                Object[] objArr = methodHookParam.args;
                if (objArr[0] == null || objArr[0].equals(OooO.OooOoO0)) {
                    return;
                }
                Camera camera = OooO.OooOOO0;
                if (camera != null && camera.equals(methodHookParam.thisObject)) {
                    methodHookParam.args[0] = OooO.OooOO0o;
                    return;
                }
                OooO.OooOOO0 = (Camera) methodHookParam.thisObject;
                OooO.OooOO0 = (SurfaceTexture) methodHookParam.args[0];
                SurfaceTexture surfaceTexture2 = OooO.OooOO0o;
                if (surfaceTexture2 == null) {
                    surfaceTexture = new SurfaceTexture(10);
                } else {
                    surfaceTexture2.release();
                    surfaceTexture = new SurfaceTexture(10);
                }
                OooO.OooOO0o = surfaceTexture;
                methodHookParam.args[0] = OooO.OooOO0o;
            }
        }
    }

    class Oooo0 implements MediaPlayer.OnPreparedListener {
        Oooo0() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            OooO.Oooo0o0.start();
        }
    }

    class Oooo000 implements MediaPlayer.OnPreparedListener {
        Oooo000() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            OooO.Oooo0OO.start();
        }
    }

    class o000OOo extends XC_MethodHook {
        o000OOo() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            super.beforeHookedMethod(methodHookParam);
            if (OooO.this.OooO0OO) {
                multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-108, -46, 81, -104, 55, 78, 58, -108, -80, -40, 90, -46}, new byte[]{-36, -67, 62, -13, 23, 40, 91, -3}));
            }
        }
    }

    class o000oOoO extends XC_MethodHook {

        /* JADX INFO: renamed from: multispace.multiapp.clone.type.cam.OooO$o000oOoO$OooO, reason: collision with other inner class name */
        class C0072OooO extends XC_MethodHook {
            C0072OooO() {
            }

            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                super.beforeHookedMethod(methodHookParam);
                if (methodHookParam.args[1] != null) {
                    OutputConfiguration outputConfiguration = new OutputConfiguration(OooO.Oooo0o);
                    OooO.OoooO0O = outputConfiguration;
                    methodHookParam.args[0] = Arrays.asList(outputConfiguration);
                    Object[] objArr = methodHookParam.args;
                    if (objArr[2] != null) {
                        OooO.this.OooOOo((CameraCaptureSession.StateCallback) objArr[2]);
                    }
                }
            }
        }

        class OooO00o extends XC_MethodHook {
            OooO00o() {
            }

            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                Object[] objArr = methodHookParam.args;
                if (objArr[0] != null) {
                    objArr[0] = Arrays.asList(OooO.Oooo0o);
                    Object[] objArr2 = methodHookParam.args;
                    if (objArr2[1] != null) {
                        OooO.this.OooOOo((CameraCaptureSession.StateCallback) objArr2[1]);
                    }
                }
            }
        }

        class OooO0O0 extends XC_MethodHook {
            OooO0O0() {
            }

            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                super.beforeHookedMethod(methodHookParam);
                if (methodHookParam.args[0] != null) {
                    OutputConfiguration outputConfiguration = new OutputConfiguration(OooO.Oooo0o);
                    OooO.OoooO0O = outputConfiguration;
                    methodHookParam.args[0] = Arrays.asList(outputConfiguration);
                    Object[] objArr = methodHookParam.args;
                    if (objArr[1] != null) {
                        OooO.this.OooOOo((CameraCaptureSession.StateCallback) objArr[1]);
                    }
                }
            }
        }

        class OooO0OO extends XC_MethodHook {
            OooO0OO() {
            }

            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                super.beforeHookedMethod(methodHookParam);
                Object[] objArr = methodHookParam.args;
                if (objArr[0] != null) {
                    objArr[0] = Arrays.asList(OooO.Oooo0o);
                    Object[] objArr2 = methodHookParam.args;
                    if (objArr2[1] != null) {
                        OooO.this.OooOOo((CameraCaptureSession.StateCallback) objArr2[1]);
                    }
                }
            }
        }

        class OooO0o extends XC_MethodHook {
            OooO0o() {
            }

            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                super.beforeHookedMethod(methodHookParam);
                Object[] objArr = methodHookParam.args;
                if (objArr[1] != null) {
                    objArr[1] = Arrays.asList(OooO.Oooo0o);
                    Object[] objArr2 = methodHookParam.args;
                    if (objArr2[2] != null) {
                        OooO.this.OooOOo((CameraCaptureSession.StateCallback) objArr2[2]);
                    }
                }
            }
        }

        class OooOO0 extends XC_MethodHook {
            OooOO0() {
            }

            public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                super.beforeHookedMethod(methodHookParam);
                Object[] objArr = methodHookParam.args;
                if (objArr[0] != null) {
                    OooO.OoooO0 = (SessionConfiguration) objArr[0];
                    OooO.OoooO0O = new OutputConfiguration(OooO.Oooo0o);
                    SessionConfiguration sessionConfiguration = new SessionConfiguration(OooO.OoooO0.getSessionType(), Arrays.asList(OooO.OoooO0O), OooO.OoooO0.getExecutor(), OooO.OoooO0.getStateCallback());
                    OooO.OoooO00 = sessionConfiguration;
                    methodHookParam.args[0] = sessionConfiguration;
                    OooO.this.OooOOo(OooO.OoooO0.getStateCallback());
                }
            }
        }

        o000oOoO() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            OooO oooO = OooO.this;
            oooO.OooO0O0 = true;
            oooO.OooOO0O();
            MediaPlayer mediaPlayer = OooO.Oooo0OO;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                OooO.Oooo0OO.reset();
                OooO.Oooo0OO.release();
                OooO.Oooo0OO = null;
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo = OooO.OooOo;
            if (o000oooo != null) {
                o000oooo.OooOOOo();
                OooO.OooOo = null;
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo2 = OooO.OooOo0o;
            if (o000oooo2 != null) {
                o000oooo2.OooOOOo();
                OooO.OooOo0o = null;
            }
            MediaPlayer mediaPlayer2 = OooO.Oooo0o0;
            if (mediaPlayer2 != null) {
                mediaPlayer2.stop();
                OooO.Oooo0o0.reset();
                OooO.Oooo0o0.release();
                OooO.Oooo0o0 = null;
            }
            OooO.Oooo00o = null;
            OooO.Oooo0O0 = null;
            OooO.Oooo0 = null;
            OooO.Oooo00O = null;
            Iterator<Surface> it = OooO.OoooOO0.keySet().iterator();
            while (it.hasNext()) {
                if (!it.next().isValid()) {
                    it.remove();
                }
            }
            if (!OooO.this.f158OooO0oO.OooO00o()) {
                if (OooO.this.OooO0OO) {
                    multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-1, -95, -74, 42, -93, -79, -55, 69, -35, -24, -73, 55, -91, -30, -45, 4}, new byte[]{-87, -56, -46, 79, -52, -111, -89, 42}));
                }
            } else {
                XposedHelpers.findAndHookMethod(methodHookParam.args[0].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{39, 56, -41, 79, 68, -82, 24, 27, 52, 62, -57, 92, 85, -104, 62, 9, 55, 35, -35, 64}, new byte[]{68, 74, -78, 46, 48, -53, 91, 122}), new Object[]{List.class, CameraCaptureSession.StateCallback.class, Handler.class, new OooO00o()});
                XposedHelpers.findAndHookMethod(methodHookParam.args[0].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-89, 56, 14, -98, -47, 51, 44, 82, -76, 62, 30, -115, -64, 5, 10, 64, -73, 35, 4, -111, -25, 47, 32, 70, -80, 58, 30, -117, -26, 57, 1, 85, -83, 45, 30, -115, -60, 34, 6, 92, -86, 57}, new byte[]{-60, 74, 107, -1, -91, 86, 111, 51}), new Object[]{List.class, CameraCaptureSession.StateCallback.class, Handler.class, new OooO0O0()});
                XposedHelpers.findAndHookMethod(methodHookParam.args[0].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{0, -67, 66, ByteCompanionObject.MAX_VALUE, -11, -99, 52, -56, 13, -68, 83, 108, -32, -111, 25, -62, 7, -121, 78, 121, -23, -85, 7, -62, 6, -85, 100, ByteCompanionObject.MAX_VALUE, -15, -116, 2, -43, 6, -100, 66, 109, -14, -111, 24, -55}, new byte[]{99, -49, 39, 30, -127, -8, 119, -89}), new Object[]{List.class, CameraCaptureSession.StateCallback.class, Handler.class, new OooO0OO()});
                XposedHelpers.findAndHookMethod(methodHookParam.args[0].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{83, -87, 43, -82, -3, 122, -127, -107, 64, -87, 33, -84, -20, 108, -96, -111, 82, -73, 43, -116, -24, 111, -89, -123, 66, -66, 29, -86, -6, 108, -70, -97, 94}, new byte[]{48, -37, 78, -49, -119, 31, -45, -16}), new Object[]{InputConfiguration.class, List.class, CameraCaptureSession.StateCallback.class, Handler.class, new OooO0o()});
                XposedHelpers.findAndHookMethod(methodHookParam.args[0].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{ByteCompanionObject.MAX_VALUE, 118, -98, -66, 101, 55, 62, -56, 108, 118, -108, -68, 116, 33, 31, -52, 126, 104, -98, -100, 112, 34, 24, -40, 110, 97, -88, -70, 98, 33, 5, -62, 114, 70, -126, -100, 126, 60, 10, -60, 123, 113, -119, -66, 101, 59, 3, -61, 111}, new byte[]{28, 4, -5, -33, 17, 82, 108, -83}), new Object[]{InputConfiguration.class, List.class, CameraCaptureSession.StateCallback.class, Handler.class, new C0072OooO()});
                XposedHelpers.findAndHookMethod(methodHookParam.args[0].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-79, -42, 92, -47, 81, -74, 80, -28, -94, -48, 76, -62, 64, ByteCompanionObject.MIN_VALUE, 118, -10, -95, -51, 86, -34}, new byte[]{-46, -92, 57, -80, 37, -45, 19, -123}), new Object[]{SessionConfiguration.class, new OooOO0()});
            }
        }
    }

    class o00O0O extends XC_MethodHook {
        o00O0O() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
        }
    }

    class o00Oo0 extends XC_MethodHook {
        o00Oo0() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            try {
                Camera camera = (Camera) methodHookParam.args[1];
                OooO.OooOooo = camera.getParameters().getPreviewSize().width;
                OooO.OooOooO = camera.getParameters().getPreviewSize().height;
                OooO oooO = OooO.this;
                boolean z = oooO.f155OooO0Oo;
                if (oooO.f158OooO0oO.OooO0O0) {
                    Bitmap bitmapOooOO0o = OooO.this.OooOO0o(new File(OooO.this.f158OooO0oO.OooO00o).getParentFile().getAbsolutePath() + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{54, 46, 48, -122, -77, 87, -55, 97, 105}, new byte[]{25, 31, 0, -74, -125, 121, -85, 12}));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmapOooOO0o.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    methodHookParam.args[0] = byteArrayOutputStream.toByteArray();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class o00Ooo extends XC_MethodHook {
        o00Ooo() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            try {
                Camera camera = (Camera) methodHookParam.args[1];
                OooO.OooOooo = camera.getParameters().getPreviewSize().width;
                OooO.OooOooO = camera.getParameters().getPreviewSize().height;
                OooO oooO = OooO.this;
                boolean z = oooO.f155OooO0Oo;
                if (oooO.f158OooO0oO.OooO0O0) {
                    byte[] bArrOooOOO0 = OooO.OooOOO0(OooO.this.OooOO0o(new File(OooO.this.f158OooO0oO.OooO00o).getParentFile().getAbsolutePath() + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{97, -81, 35, 51, -37, 46, 20, 103, 62}, new byte[]{78, -98, 19, 3, -21, 0, 118, 10})));
                    OooO.OooOOo0 = bArrOooOOO0;
                    methodHookParam.args[0] = bArrOooOOO0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class o00oO0o extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        o00oO0o(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            Object[] objArr = methodHookParam.args;
            if (objArr[1] == null || objArr[1].equals(OooO.Oooo0oo)) {
                return;
            }
            Object[] objArr2 = methodHookParam.args;
            OooO.Oooo0oo = (CameraDevice.StateCallback) objArr2[1];
            OooO.OoooO = objArr2[1].getClass();
            multispace.multiapp.clone.type.cam.OooO0OO oooO0OO = this.OooOO0;
            if (oooO0OO.OooO0O0) {
                if (!oooO0OO.OooO00o()) {
                    if (OooO.this.OooO0OO) {
                        multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-73, -76, 99, -116, -122, -53, 70, -54, -107, -3, 98, -111, ByteCompanionObject.MIN_VALUE, -104, 92, -117}, new byte[]{-31, -35, 7, -23, -23, -21, 40, -91}));
                    }
                } else {
                    String str = (String) methodHookParam.args[0];
                    if (!TextUtils.isEmpty(str)) {
                        OooO.o000oOoO = OooO.OoooOOO.get(str).intValue();
                    }
                    OooO.this.OooOOoo(OooO.OoooO);
                }
            }
        }
    }

    class o0O0O00 extends XC_MethodHook {
        o0O0O00() {
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            if (methodHookParam.args[1] != null) {
                OooO.this.OooOOOO(methodHookParam);
            }
            if (methodHookParam.args[3] != null) {
                OooO.this.OooOOOo(methodHookParam, 3);
            }
        }
    }

    class o0OO00O extends XC_MethodHook {
        o0OO00O() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            if (methodHookParam.args[0] != null) {
                OooO.this.OooOOo0(methodHookParam);
            }
        }
    }

    class o0OOO0o extends XC_MethodHook {
        o0OOO0o() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            if (methodHookParam.args[0] != null) {
                OooO.this.OooOOo0(methodHookParam);
            }
        }
    }

    class o0Oo0oo extends XC_MethodHook {
        o0Oo0oo() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            Object[] objArr = methodHookParam.args;
            if (objArr[0] != null) {
                objArr[0] = new byte[((byte[]) objArr[0]).length];
            }
        }
    }

    class o0OoOo0 extends XC_MethodHook {
        o0OoOo0() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{14, -65, -38, 114, -73, -110, -121, -11, -35, 75}, new byte[]{97, -47, -97, 0, -59, -3, -11, 26}) + ((Integer) methodHookParam.args[1]).intValue());
        }
    }

    class o0ooOOo extends XC_MethodHook {
        final /* synthetic */ multispace.multiapp.clone.type.cam.OooO0OO OooOO0;

        o0ooOOo(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) {
            this.OooOO0 = oooO0OO;
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            Object[] objArr = methodHookParam.args;
            if (objArr[2] == null || objArr[2].equals(OooO.Oooo0oo)) {
                return;
            }
            OooO.Oooo0oo = (CameraDevice.StateCallback) methodHookParam.args[2];
            multispace.multiapp.clone.type.cam.OooO0OO oooO0OO = this.OooOO0;
            if (oooO0OO.OooO0O0) {
                if (!oooO0OO.OooO00o()) {
                    if (OooO.this.OooO0OO) {
                        multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-87, 38, 6, 51, -117, -101, -119, 97, -117, 111, 7, 46, -115, -56, -109, 32}, new byte[]{-1, 79, 98, 86, -28, -69, -25, 14}));
                    }
                } else {
                    OooO.OoooO = methodHookParam.args[2].getClass();
                    String str = (String) methodHookParam.args[0];
                    if (!TextUtils.isEmpty(str)) {
                        OooO.o000oOoO = OooO.OoooOOO.get(str).intValue();
                    }
                    OooO.this.OooOOoo(OooO.OoooO);
                }
            }
        }
    }

    class oo000o extends XC_MethodHook {
        final /* synthetic */ Class OooOO0;
        final /* synthetic */ int OooOO0O;

        oo000o(Class cls, int i) {
            this.OooOO0 = cls;
            this.OooOO0O = i;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            if (((Camera) methodHookParam.args[1]).equals(OooO.OooOOO)) {
                while (OooO.OooOOOo == null) {
                }
                System.arraycopy(OooO.OooOOOo, 0, methodHookParam.args[0], 0, Math.min(OooO.OooOOOo.length, ((byte[]) methodHookParam.args[0]).length));
                return;
            }
            OooO.Oooo000 = this.OooOO0;
            Camera camera = (Camera) methodHookParam.args[1];
            OooO.OooOOO = camera;
            OooO.OooOOoo = camera.getParameters().getPreviewSize().width;
            OooO.OooOOo = OooO.OooOOO.getParameters().getPreviewSize().height;
            OooO.OooOOO.getParameters().getPreviewFrameRate();
            if (OooO.this.f155OooO0Oo) {
                multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-44, -78, -37, 8, 47, 57, -7, -127, -22, -86, -13, 42, 60, 49, -22, -75, -81, -98, -44, 53, 56, 46, -18, -56, -4, -76, -49, 61, 125, 52, -22, -102, -22, -3, -36, 43, 125, 7, -8, -127, -21, -87, -35, 98}, new byte[]{-113, -35, -75, 88, 93, 92, -113, -24}) + OooO.OooOOoo + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{45, 83, -10, 11, -93, -8, -50, -117}, new byte[]{1, 59, -109, 98, -60, -112, -70, -79}) + OooO.OooOOo + multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{116}, new byte[]{41, ByteCompanionObject.MAX_VALUE, -50, 30, -94, -51, -52, 29}));
            }
            if (this.OooOO0O == 1) {
                return;
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo = OooO.OooOo0O;
            if (o000oooo != null) {
                o000oooo.OooOOOo();
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo2 = new multispace.multiapp.clone.type.cam.o000oOoO();
            OooO.OooOo0O = o000oooo2;
            o000oooo2.OooOOO0(BuildConfig.FLAVOR, multispace.multiapp.clone.type.cam.OooOo00.NV21);
            OooO.OooOo0O.OooO0Oo(OooO.this.f158OooO0oO.OooO00o);
            while (OooO.OooOOOo == null) {
            }
            System.arraycopy(OooO.OooOOOo, 0, methodHookParam.args[0], 0, Math.min(OooO.OooOOOo.length, ((byte[]) methodHookParam.args[0]).length));
        }
    }

    class oo0o0Oo extends XC_MethodHook {
        oo0o0Oo() {
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            if (methodHookParam.args[0] != null) {
                OooO.this.OooOOo0(methodHookParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Surface OooOO0O() {
        if (this.OooO0O0) {
            SurfaceTexture surfaceTexture = Oooo0oO;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                Oooo0oO = null;
            }
            Surface surface = Oooo0o;
            if (surface != null) {
                surface.release();
                Oooo0o = null;
            }
            Oooo0oO = new SurfaceTexture(15);
            Oooo0o = new Surface(Oooo0oO);
            this.OooO0O0 = false;
        } else if (Oooo0o == null) {
            this.OooO0O0 = true;
            Oooo0o = OooOO0O();
        }
        return Oooo0o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap OooOO0o(String str) throws Throwable {
        return BitmapFactory.decodeFile(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] OooOOO0(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return OooOo0(iArr, width, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOOOO(XC_MethodHook.MethodHookParam methodHookParam) {
        XposedHelpers.findAndHookMethod(methodHookParam.args[1].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{74, -123, -102, 111, 7, 93, -38, 81, 64, -65, -85, 109, 1, 71}, new byte[]{37, -21, -54, 6, 100, 41, -81, 35}), new Object[]{byte[].class, Camera.class, new o00Ooo()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOOOo(XC_MethodHook.MethodHookParam methodHookParam, int i) {
        XposedHelpers.findAndHookMethod(methodHookParam.args[i].getClass(), multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{29, 55, 62, 51, -64, 124, -112, 10, 23, 13, 15, 49, -58, 102}, new byte[]{114, 89, 110, 90, -93, 8, -27, 120}), new Object[]{byte[].class, Camera.class, new o00Oo0()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOOo(CameraCaptureSession.StateCallback stateCallback) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOOo0(XC_MethodHook.MethodHookParam methodHookParam) {
        Class<?> cls = methodHookParam.args[0].getClass();
        multispace.multiapp.clone.type.cam.OooO0OO oooO0OO = this.f158OooO0oO;
        int i = !oooO0OO.OooO0O0 ? 1 : 0;
        if (!oooO0OO.OooO00o()) {
            if (this.OooO0OO) {
                multispace.multiapp.clone.util.o0OOO0o.OooO0oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{24, -121, 92, -43, -116, -25, 109, -62, 58, -50, 93, -56, -118, -76, 119, -125}, new byte[]{78, -18, 56, -80, -29, -57, 3, -83}));
            }
            i = 1;
        }
        XposedHelpers.findAndHookMethod(cls, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-19, 89, -40, 42, -90, -23, -32, -102, -11, 113, -6, 57, -82, -6}, new byte[]{-126, 55, -120, 88, -61, -97, -119, -1}), new Object[]{byte[].class, Camera.class, new oo000o(cls, i)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOOoo(Class cls) {
        XposedHelpers.findAndHookMethod(cls, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-37, -5, ByteCompanionObject.MAX_VALUE, -1, 22, -37, -38, -63}, new byte[]{-76, -107, 48, -113, 115, -75, -65, -91}), new Object[]{CameraDevice.class, new o000oOoO()});
        XposedHelpers.findAndHookMethod(cls, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-84, -42, 33, 100, 11, -61, 100}, new byte[]{-61, -72, 100, 22, 121, -84, 22, -27}), new Object[]{CameraDevice.class, Integer.TYPE, new o0OoOo0()});
        XposedHelpers.findAndHookMethod(cls, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{83, 82, -26, 106, -67, 69, -78, -21, 82, 89, -63, 119, -85, 66}, new byte[]{60, 60, -94, 3, -50, 38, -35, -123}), new Object[]{CameraDevice.class, new o00O0O()});
    }

    private static byte[] OooOo0(int[] iArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[(i3 * 3) / 2];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = (i4 * i) + i5;
                int i7 = iArr[i6] & 16777215;
                int i8 = i7 & 255;
                int i9 = (i7 >> 8) & 255;
                int i10 = (i7 >> 16) & 255;
                int i11 = ((((i10 * 25) + ((i9 * 129) + (i8 * 66))) + 128) >> 8) + 16;
                int i12 = ((((i10 * 112) + ((i8 * (-38)) - (i9 * 74))) + 128) >> 8) + 128;
                int i13 = (((((i8 * 112) - (i9 * 94)) - (i10 * 18)) + 128) >> 8) + 128;
                int iMin = i11 >= 16 ? Math.min(i11, 255) : 16;
                int iMin2 = i12 < 0 ? 0 : Math.min(i12, 255);
                int iMin3 = i13 < 0 ? 0 : Math.min(i13, 255);
                bArr[i6] = (byte) iMin;
                int i14 = ((i4 >> 1) * i) + i3 + (i5 & (-2));
                bArr[i14] = (byte) iMin2;
                bArr[i14 + 1] = (byte) iMin3;
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooOo00() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        String strOooO00o;
        multispace.multiapp.clone.type.cam.OooOo00 oooOo00;
        if (Oooo0 != null) {
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo = OooOo0o;
            if (o000oooo != null) {
                o000oooo.OooOOOo();
                OooOo0o = null;
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo2 = new multispace.multiapp.clone.type.cam.o000oOoO();
            OooOo0o = o000oooo2;
            try {
                if (this.OooO00o == 256) {
                    o000oooo2.OooOOO0(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{77, -6, 101, -110}, new byte[]{35, -113, 9, -2, -89, -9, 96, 118}), multispace.multiapp.clone.type.cam.OooOo00.JPEG);
                } else {
                    o000oooo2.OooOOO0(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-56, 26, 107, 47}, new byte[]{-90, 111, 7, 67, 57, 26, -13, -94}), multispace.multiapp.clone.type.cam.OooOo00.NV21);
                }
                OooOo0o.OooOOO(Oooo0);
                OooOo0o.OooO0Oo(this.f158OooO0oO.OooO00o);
            } catch (Throwable th) {
                th.printStackTrace();
                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{ByteCompanionObject.MAX_VALUE, -23, 103, 96, 84, -24, -125, 98, 116, -85}, new byte[]{26, -111, 4, 5, 36, -100, -22, 13}) + th);
            }
        }
        if (Oooo0O0 != null) {
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo3 = OooOo;
            if (o000oooo3 != null) {
                o000oooo3.OooOOOo();
                OooOo = null;
            }
            multispace.multiapp.clone.type.cam.o000oOoO o000oooo4 = new multispace.multiapp.clone.type.cam.o000oOoO();
            OooOo = o000oooo4;
            try {
                if (this.OooO00o == 256) {
                    strOooO00o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-68, -42, 121, -117}, new byte[]{-46, -93, 21, -25, -37, 84, -116, 12});
                    oooOo00 = multispace.multiapp.clone.type.cam.OooOo00.JPEG;
                } else {
                    strOooO00o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-5, -70, -46, -71}, new byte[]{-107, -49, -66, -43, 9, -43, -71, 25});
                    oooOo00 = multispace.multiapp.clone.type.cam.OooOo00.NV21;
                }
                o000oooo4.OooOOO0(strOooO00o, oooOo00);
                OooOo.OooOOO(Oooo0O0);
                OooOo.OooO0Oo(this.f158OooO0oO.OooO00o);
            } catch (Throwable th2) {
                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{35, -116, 103, -77, -75, 58, -14, -13, 40, -50}, new byte[]{70, -12, 4, -42, -59, 78, -101, -100}) + th2);
            }
        }
        if (Oooo00O != null) {
            MediaPlayer mediaPlayer3 = Oooo0OO;
            if (mediaPlayer3 == null) {
                mediaPlayer2 = new MediaPlayer();
            } else {
                mediaPlayer3.release();
                mediaPlayer2 = new MediaPlayer();
            }
            Oooo0OO = mediaPlayer2;
            Oooo0OO.setSurface(Oooo00O);
            if (!this.f158OooO0oO.f162OooO0Oo) {
                Oooo0OO.setVolume(0.0f, 0.0f);
            }
            Oooo0OO.setLooping(true);
            try {
                Oooo0OO.setOnPreparedListener(new Oooo000());
                Oooo0OO.setDataSource(this.f158OooO0oO.OooO00o);
                Oooo0OO.prepare();
            } catch (Exception e) {
                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{4, -4, -125, -52, -85, -8, 28, 48, 15, -66}, new byte[]{97, -124, -32, -87, -37, -116, 117, 95}) + e);
            }
        }
        if (Oooo00o != null) {
            MediaPlayer mediaPlayer4 = Oooo0o0;
            if (mediaPlayer4 == null) {
                mediaPlayer = new MediaPlayer();
            } else {
                mediaPlayer4.release();
                mediaPlayer = new MediaPlayer();
            }
            Oooo0o0 = mediaPlayer;
            Oooo0o0.setSurface(Oooo00o);
            if (!this.f158OooO0oO.f162OooO0Oo) {
                Oooo0o0.setVolume(0.0f, 0.0f);
            }
            Oooo0o0.setLooping(true);
            try {
                Oooo0o0.setOnPreparedListener(new Oooo0());
                Oooo0o0.setDataSource(this.f158OooO0oO.OooO00o);
                Oooo0o0.prepare();
            } catch (Exception e2) {
                multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{97, -111, 126, 21, 97, -51, 57, 80, 106, -45}, new byte[]{4, -23, 29, 112, 17, -71, 80, 63}) + e2);
            }
        }
    }

    public void OooOOO(multispace.multiapp.clone.type.cam.OooO0OO oooO0OO) throws Exception {
        this.f158OooO0oO = oooO0OO;
        this.OooO0oo = multispace.multiapp.clone.type.cam.OooO0o.OooO00o();
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-112, 46, 123, 29, 30, 38, -126, 25, -122, 60, 91, 40, 20, 55, -127, 2, -122}, new byte[]{-29, 75, 15, 77, 108, 67, -12, 112}), new Object[]{SurfaceTexture.class, new OooOo00(oooO0OO)});
        XposedHelpers.findAndHookMethod(CameraManager.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{18, -39, -91, 100, 83, -51, -98, 108, 15, -56}, new byte[]{125, -87, -64, 10, 16, -84, -13, 9}), new Object[]{String.class, CameraDevice.StateCallback.class, Handler.class, new o00oO0o(oooO0OO)});
        XposedHelpers.findAndHookMethod(CameraManager.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-119, -105, 89, 28, 41, 37, 89, 17, -108, -122}, new byte[]{-26, -25, 60, 114, 106, 68, 52, 116}), new Object[]{String.class, Executor.class, CameraDevice.StateCallback.class, new o0ooOOo(oooO0OO)});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{115, 49, -93, 17, 1, 55, -126, -111, 101, 35, -108, 32, 31, 62, -106, -103, 99, 63, ByteCompanionObject.MIN_VALUE, 40, 7, 58, -74, -115, 102, 50, -78, 51}, new byte[]{0, 84, -41, 65, 115, 82, -12, -8}), new Object[]{Camera.PreviewCallback.class, new o0OOO0o()});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{5, 86, 121, 77, -49, -4, -5, 101, 5, 81, 118, 76, -37, -10, -15, 98, 22}, new byte[]{100, 50, 29, 14, -82, -112, -105, 7}), new Object[]{byte[].class, new o0Oo0oo()});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-48, 97, -74, 43, -108, 20, 105, 113, -58, 115, -127, 26, -118, 29, 125, 121, -64, 111}, new byte[]{-93, 4, -62, 123, -26, 113, 31, 24}), new Object[]{Camera.PreviewCallback.class, new o0OO00O()});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{36, -78, 114, -121, 22, 54, -97, -75, 56, -93, 86, -70, 29, 37, -91, -72, 32, -108, 103, -92, 20, 49, -83, -66, 60}, new byte[]{87, -41, 6, -56, 120, 83, -52, -35}), new Object[]{Camera.PreviewCallback.class, new oo0o0Oo()});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{66, -74, -25, 27, -28, 12, -83, -14, 67, -91, -23}, new byte[]{54, -41, -116, 126, -76, 101, -50, -122}), new Object[]{Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class, new o0O0O00()});
        XposedHelpers.findAndHookMethod(MediaRecorder.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-11, -13, 54, 4, 85, 29, 32, 101, -25}, new byte[]{-122, -106, 66, 71, 52, 112, 69, 23}), new Object[]{Camera.class, new o000OOo()});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{50, 10, -107, -26, -88, -21, 101, -110, 55, 23, -111, -29}, new byte[]{65, 126, -12, -108, -36, -69, 23, -9}), new Object[]{new OooO00o(oooO0OO)});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{109, 48, 59, -124, 43, 27, -85, -124, 123, 34, 11, -67, 42, 14, -79, -116, 103}, new byte[]{30, 85, 79, -44, 89, 126, -35, -19}), new Object[]{SurfaceHolder.class, new OooO0O0(oooO0OO)});
        XposedHelpers.findAndHookMethod(CaptureRequest.Builder.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{30, -80, -124, 124, -22, -115, 44, 79, 11}, new byte[]{ByteCompanionObject.MAX_VALUE, -44, -32, 40, -117, -1, 75, 42}), new Object[]{Surface.class, new OooO0OO(oooO0OO)});
        XposedHelpers.findAndHookMethod(CaptureRequest.Builder.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{81, 61, -113, -113, 117, -79, 97, -16, 81, 63, -121, -108}, new byte[]{35, 88, -30, -32, 3, -44, 53, -111}), new Object[]{Surface.class, new OooO0o(oooO0OO)});
        XposedHelpers.findAndHookMethod(CaptureRequest.Builder.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-123, 45, 103, -11, 54}, new byte[]{-25, 88, 14, -103, 82, 65, -37, -52}), new Object[]{new C0070OooO(oooO0OO)});
        String strOooO00o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{106, 93, 23, 57, -37, 66, 76, 79, 106, 91, 5}, new byte[]{4, 56, 96, 112, -75, 49, 56, 46});
        Class cls = Integer.TYPE;
        XposedHelpers.findAndHookMethod(ImageReader.class, strOooO00o, new Object[]{cls, cls, cls, cls, new OooOO0()});
        XposedHelpers.findAndHookMethod(CameraCaptureSession.CaptureCallback.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{126, -110, 117, 114, 109, 67, 58, 92, 116, -70, 87, 122, 113, 82, 43}, new byte[]{17, -4, 54, 19, 29, 55, 79, 46}), new Object[]{CameraCaptureSession.class, CaptureRequest.class, CaptureFailure.class, new OooOO0O()});
        multispace.multiapp.clone.util.Oooo000.OooO00o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-90, -103, -33, -111, 9, -119, -7, -31, -85, -40}, new byte[]{-50, -10, -80, -6, 41, -19, -106, -113}));
        XposedHelpers.findAndHookMethod(ImageReader.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{42, -72, 102, 101, 112, -53, -111, -28, 42, -81, 114, 99, 109, -16, -103, -55, 44, -66}, new byte[]{75, -37, 23, 16, 25, -71, -12, -88}), new Object[]{new OooOOO0()});
        XposedHelpers.findAndHookMethod(ImageReader.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{1, -25, -21, -68, 22, -126, 36, 20, 5, -4, -18, ByteCompanionObject.MIN_VALUE, 18, -111, 38, 63}, new byte[]{96, -124, -102, -55, ByteCompanionObject.MAX_VALUE, -16, 65, 90}), new Object[]{new OooOOO()});
        XposedHelpers.findAndHookMethod(Camera.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-106, 18, -34, 44}, new byte[]{-7, 98, -69, 66, -50, -108, 45, -53}), new Object[]{cls, new OooOOOO()});
        XposedHelpers.findAndHookMethod(CameraManager.class, multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{106, -35, -4, 10, -32, 22, 18, 37, 108, -5, -32, 40, -13, 26, 20, 35, 104, -54, -31, 58, -11, 18, 20, 36}, new byte[]{13, -72, -120, 73, -127, 123, 119, 87}), new Object[]{String.class, new OooOo()});
    }
}
