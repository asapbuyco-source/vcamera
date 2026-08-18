package multispace.multiapp.clone.type.cam;

import java.io.File;
import kotlin.jvm.internal.ByteCompanionObject;
import org.osmdroid.library.BuildConfig;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooO0OO {

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public static final int f159OooO0o = 2;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public static final int f160OooO0o0 = 1;

    /* JADX INFO: renamed from: OooO0oO, reason: collision with root package name */
    public static final int f161OooO0oO = 3;
    public static final int OooO0oo = 4;
    public String OooO00o = BuildConfig.FLAVOR;
    public boolean OooO0O0 = true;
    public boolean OooO0OO = true;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public boolean f162OooO0Oo = true;

    public static OooO0OO OooO0O0() {
        multispace.multiapp.clone.sp.OooO00o oooO00oOooO0OO = null;
        String strOooO00o = null;
        OooO0OO oooO0OO = new OooO0OO();
        int iOooO0Oo = multispace.multiapp.clone.sp.OooO00o.OooO0OO().OooO0Oo(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{53, -56, 108, -100, -18, -18, 39, 91, 33, -35, 125}, new byte[]{88, -83, 24, -12, -127, -118, 120, 47}), 1);
        if (iOooO0Oo != 1) {
            if (iOooO0Oo == 2) {
                oooO0OO.OooO0O0 = true;
                oooO0OO.OooO00o = multispace.multiapp.clone.sp.OooO00o.OooO0OO().OooO0o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{82, 12, 69, -98, 119, -18, -103, -31, 80, 13, 126, -105, 119, -46, -120, -20, 123, 3, 72, -107, 121, -35, -74, -17, 81, 17}, new byte[]{36, 101, 33, -5, 24, -79, -23, ByteCompanionObject.MIN_VALUE}));
                oooO00oOooO0OO = multispace.multiapp.clone.sp.OooO00o.OooO0OO();
                strOooO00o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-95, 115, -33, 85, 107, 89, 96, -19, -93, 114, -28, 92, 107, 101, 113, -32, -120, 123, -50, 84, 109, 105, 79, -23, -71, 123, -39, 92, 97}, new byte[]{-41, 26, -69, 48, 4, 6, 16, -116});
            } else if (iOooO0Oo == 3) {
                oooO0OO.OooO0O0 = true;
                oooO0OO.OooO00o = multispace.multiapp.clone.sp.OooO00o.OooO0OO().OooO0o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-12, 4, -43, -125, -23, -73, -74, -12, -10, 5, -18, -120, -29, -100, -79, -6, -16, 6}, new byte[]{-126, 109, -79, -26, -122, -24, -58, -107}));
                oooO00oOooO0OO = multispace.multiapp.clone.sp.OooO00o.OooO0OO();
                strOooO00o = multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-74, 86, 64, -14, 64, -35, -32, 120, -76, 87, 123, -7, 74, -10, -25, 118, -78, 84, 123, -10, 90, -26, -7, 118, -97, 90, 74, -10, 77, -18, -11}, new byte[]{-64, 63, 36, -105, 47, -126, -112, 25});
            } else if (iOooO0Oo == 4) {
                oooO0OO.OooO0O0 = true;
                oooO0OO.OooO00o = multispace.multiapp.clone.sp.OooO00o.OooO0OO().OooO0o(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-24, 59, 98, 50, -14, -91, -10, -99, -20, 47, 100, 63, -14, -95, -16, -95, -18, 51, 114, 63, -62}, new byte[]{-104, 90, 22, 90, -83, -43, -97, -2}));
                oooO0OO.f162OooO0Oo = false;
            }
            if (oooO00oOooO0OO != null) {
                oooO0OO.f162OooO0Oo = oooO00oOooO0OO.OooO0O0(strOooO00o, true);
            }
        } else {
            oooO0OO.OooO0O0 = false;
            oooO0OO.OooO00o = BuildConfig.FLAVOR;
        }
        return oooO0OO;
    }

    public boolean OooO00o() {
        if (this.OooO00o.startsWith(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{60, 27, 13, 85, 66}, new byte[]{19, ByteCompanionObject.MAX_VALUE, 108, 33, 35, -70, 32, 11}))) {
            return new File(this.OooO00o).exists();
        }
        return true;
    }
}
