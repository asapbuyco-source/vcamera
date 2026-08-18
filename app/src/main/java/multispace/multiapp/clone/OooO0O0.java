package multispace.multiapp.clone;

public final class OooO0O0 {
    public static String OooO00o(byte[] data, byte[] key) {
        byte[] out = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            out[i] = (byte) (data[i] ^ key[i % key.length]);
        }
        return new String(out);
    }
}