package virtual.camera.camera;

import android.content.Context;
import android.content.SharedPreferences;

public class MultiPreferences {

    private static MultiPreferences sInstance;

    private final SharedPreferences mSp;

    private MultiPreferences(Context context) {
        mSp = context.getSharedPreferences("virtual_camera_settings", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (sInstance == null && context != null) {
            sInstance = new MultiPreferences(context.getApplicationContext());
        }
    }

    public static MultiPreferences getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException("MultiPreferences not initialized");
        }
        return sInstance;
    }

    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }

    public void setInt(String key, int value) {
        mSp.edit().putInt(key, value).apply();
    }

    public long getLong(String key, long defValue) {
        return mSp.getLong(key, defValue);
    }

    public void setLong(String key, long value) {
        mSp.edit().putLong(key, value).apply();
    }

    public float getFloat(String key, float defValue) {
        return mSp.getFloat(key, defValue);
    }

    public void setFloat(String key, float value) {
        mSp.edit().putFloat(key, value).apply();
    }

    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    public void setString(String key, String value) {
        mSp.edit().putString(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }

    public void setBoolean(String key, boolean value) {
        mSp.edit().putBoolean(key, value).apply();
    }
}
