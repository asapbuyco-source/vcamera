package multispace.multiapp.clone.type.cam;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
enum OooOo00 {
    I420(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-50, 29, -10, 95}, new byte[]{-121, 41, -60, 111, 74, -2, 80, -80})),
    NV21(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-112, 37, 106, 48}, new byte[]{-34, 115, 88, 1, 50, -73, 45, 87})),
    JPEG(multispace.multiapp.clone.OooO0O0.OooO00o(new byte[]{-37, -21, 48, -23}, new byte[]{-111, -69, 117, -82, 65, -4, -48, -72}));

    private final String friendlyName;

    OooOo00(String str) {
        this.friendlyName = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.friendlyName;
    }
}
