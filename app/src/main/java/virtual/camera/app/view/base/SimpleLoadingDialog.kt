package virtual.camera.app.view.base

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import virtual.camera.app.R

class SimpleLoadingDialog : DialogFragment() {

    private var backgroundColor: Int? = null
    private var clickCancelAble = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        backgroundColor?.let {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(it))
        }
        return inflater.inflate(R.layout.dialog_loading, container, false)
    }

    override fun onStart() {
        super.onStart()
        dialog?.setCanceledOnTouchOutside(clickCancelAble)
        dialog?.setCancelable(clickCancelAble)
    }

    fun setBackgroundColor(color: Int) {
        backgroundColor = color
    }

    fun setClickCancelAble(cancelAble: Boolean) {
        clickCancelAble = cancelAble
    }
}