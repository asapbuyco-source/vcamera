package multispace.multiapp.clone.type.cam;

import android.media.Image;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\pc\vcfix\classes3.dex */
public class OooOO0O extends Image {
    public int OooOO0 = 0;
    public int OooOO0O = 0;
    public int OooOO0o = 0;
    public long OooOOO0 = 0;
    private ByteBuffer OooOOO = null;
    private Image.Plane[] OooOOOO = {new OooO00o()};

    class OooO00o extends Image.Plane {
        OooO00o() {
        }

        @Override // android.media.Image.Plane
        public ByteBuffer getBuffer() {
            return OooOO0O.this.OooOOO;
        }

        @Override // android.media.Image.Plane
        public int getPixelStride() {
            return 0;
        }

        @Override // android.media.Image.Plane
        public int getRowStride() {
            return 0;
        }
    }

    public void OooO0O0(ByteBuffer byteBuffer) {
        this.OooOOO = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // android.media.Image, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.Image
    public int getFormat() {
        return this.OooOO0;
    }

    @Override // android.media.Image
    public int getHeight() {
        return this.OooOO0o;
    }

    @Override // android.media.Image
    public Image.Plane[] getPlanes() {
        return this.OooOOOO;
    }

    public int getScalingMode() {
        return 0;
    }

    @Override // android.media.Image
    public long getTimestamp() {
        return this.OooOOO0;
    }

    public int getTransform() {
        return 0;
    }

    @Override // android.media.Image
    public int getWidth() {
        return this.OooOO0O;
    }
}
