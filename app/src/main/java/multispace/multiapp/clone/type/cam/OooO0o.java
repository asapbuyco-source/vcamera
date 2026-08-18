package multispace.multiapp.clone.type.cam;

import android.content.Context;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooO0o {
    private static Context OooO00o;

    public static Context OooO00o() {
        if (OooO00o == null) {
            synchronized (OooO0o.class) {
                if (OooO00o == null) {
                    try {
                        Class<?> cls = Class.forName(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-85, 38, 1, -74, 91, -50, -12, 34, -85, 56, 21, -22, 117, -60, -28, 101, -68, 33, 17, -67, 96, -49, -30, 105, -85, 44}, new byte[]{-54, 72, 101, -60, 52, -89, -112, 12}));
                        Object objInvoke = cls.getMethod(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{98, 120, -78, 115, 1, 10, -79, -44, 98, 121, -87, 119, 13, 16, -68, -63, 105, ByteCompanionObject.MAX_VALUE, -91, 96, 0}, new byte[]{1, 13, -64, 1, 100, 100, -59, -107}), new Class[0]).invoke(cls, new Object[0]);
                        OooO00o = (Context) objInvoke.getClass().getMethod(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{1, 104, 81, -88, 16, -22, 58, -10, 5, 108, 81, ByteCompanionObject.MIN_VALUE, 15, -12}, new byte[]{102, 13, 37, -23, 96, -102, 86, -97}), new Class[0]).invoke(objInvoke, new Object[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return OooO00o;
    }
}
