package multispace.multiapp.clone.util;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import virtual.camera.app.app.App;

public class o0OOO0o {
    static Toast OooO00o;

    static class OooO00o implements Runnable {
        final Context OooOO0;
        final String OooOO0O;
        final int OooOO0o;

        OooO00o(Context context, String str, int i) {
            this.OooOO0 = context;
            this.OooOO0O = str;
            this.OooOO0o = i;
        }

        @Override
        public void run() {
            o0OOO0o.OooOO0(this.OooOO0, this.OooOO0O, this.OooOO0o);
        }
    }

    public static void OooO(String str, int i) {
        OooO0oO(App.getContext(), str, i);
    }

    public static void OooO0O0(int i) {
        OooO0Oo(App.getContext(), i);
    }

    public static void OooO0OO(int i, int i2) {
        OooO0o0(App.getContext(), i, i2);
    }

    public static void OooO0Oo(Context context, int i) {
        OooO0oO(context, context.getString(i), 1);
    }

    public static void OooO0o(Context context, String str) {
        OooO0oO(context, str, 1);
    }

    public static void OooO0oo(String str) {
        OooO0o(App.getContext(), str);
    }

    private static void OooO0o0(Context context, int i, int i2) {
        OooO0oO(context, context.getString(i), i2);
    }

    private static void OooO0oO(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            OooOo00.OooO00o(new OooO00o(context, str, i));
        } else {
            OooOO0(context, str, i);
        }
    }

    private static void OooOO0(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        if (OooO00o != null) {
            OooO00o.cancel();
        }
        OooO00o = Toast.makeText(context.getApplicationContext(), str, i);
        OooO00o.show();
    }
}