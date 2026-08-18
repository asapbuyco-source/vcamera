package virtual.camera.app.view.base

import android.view.KeyEvent
import virtual.camera.app.R

abstract class LoadingActivity : BaseActivity() {

    private lateinit var loadingView: SimpleLoadingDialog


    fun showLoading() {
        if (!this::loadingView.isInitialized) {
            loadingView = SimpleLoadingDialog()
        }

        if (!loadingView.isAdded) {
            loadingView.setBackgroundColor(R.color.primary)
            loadingView.show(supportFragmentManager, "")
            supportFragmentManager.executePendingTransactions()
            loadingView.setClickCancelAble(false)
            loadingView.dialog?.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_ESCAPE) {
                    return@setOnKeyListener true
                }
                false
            }
        }
    }


    fun hideLoading() {
        if (this::loadingView.isInitialized) {
            loadingView.dismiss()
        }
    }
}