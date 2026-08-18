package cbfg.rvadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class RVHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun setContent(item: T, isSelected: Boolean, payload: Any?)
}