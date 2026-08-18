package multispace.multiapp.clone.sp;

import virtual.camera.camera.MultiPreferences;

public class OooO00o {

    private static OooO00o instance;
    private final MultiPreferences prefs = MultiPreferences.getInstance();

    private OooO00o() {
    }

    public static OooO00o OooO0OO() {
        if (instance == null) {
            synchronized (OooO00o.class) {
                if (instance == null) {
                    instance = new OooO00o();
                }
            }
        }
        return instance;
    }

    public synchronized void OooO(String str, int i) {
        prefs.setInt(str, i);
    }

    public synchronized boolean OooO00o(String str) {
        return prefs.contains(str);
    }

    public synchronized boolean OooO0O0(String str, boolean z) {
        return prefs.getBoolean(str, z);
    }

    public synchronized int OooO0Oo(String str, int i) {
        return prefs.getInt(str, i);
    }

    public synchronized String OooO0o(String str) {
        return prefs.getString(str, "");
    }

    public synchronized void OooO0o0(String str, long j) {
        prefs.setLong(str, j);
    }

    public synchronized void OooO0oO(String str, float f) {
        prefs.setFloat(str, f);
    }

    public synchronized void OooO0oo(String str, boolean z) {
        prefs.setBoolean(str, z);
    }

    public synchronized void OooOO0(String str) {
        prefs.remove(str);
    }

    public synchronized void OooOO0O(String str, boolean z) {
        prefs.setBoolean(str, z);
    }

    public synchronized void OooOO0o(String str, String str2) {
        prefs.setString(str, str2);
    }
}