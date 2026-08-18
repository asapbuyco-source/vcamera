package virtual.camera.app.app

import android.annotation.SuppressLint
import android.content.Context
import com.hack.opensdk.HackApplication
import virtual.camera.camera.MultiPreferences

/**
 *
 * @Description:
 * @Author: wukaicheng
 * @CreateDate: 2021/4/29 21:21
 */
class App : HackApplication() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private lateinit var mContext: Context

        @JvmStatic
        fun getContext(): Context {
            return mContext
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        mContext = base!!
        MultiPreferences.init(base)
    }

    override fun onCreate() {
        super.onCreate()
        try {
            multispace.multiapp.clone.type.cam.OooO0O0.OooO0O0()
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }
}