package cbfg.rvadapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RVAdapter<T>(context: Context, private val factory: RVHolderFactory) :
    RecyclerView.Adapter<RVHolder<*>>() {

    private val mItems = mutableListOf<T>()
    private var itemClickListener: ((View, T, Int) -> Unit)? = null
    private var itemLongClickListener: ((View, T, Int) -> Unit)? = null

    fun bind(recyclerView: RecyclerView): RVAdapter<T> {
        recyclerView.adapter = this
        return this
    }

    fun setItems(items: List<T>?) {
        mItems.clear()
        if (items != null) {
            mItems.addAll(items)
        }
        notifyDataSetChanged()
    }

    fun getItems(): MutableList<T> = mItems

    fun replaceAt(index: Int, item: T) {
        if (index in mItems.indices) {
            mItems[index] = item
            notifyItemChanged(index)
        }
    }

    fun setItemClickListener(listener: (View, T, Int) -> Unit): RVAdapter<T> {
        itemClickListener = listener
        return this
    }

    fun setItemLongClickListener(listener: (View, T, Int) -> Unit): RVAdapter<T> {
        itemLongClickListener = listener
        return this
    }

    override fun getItemCount(): Int = mItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder<*> {
        val item = if (mItems.isEmpty()) {
            Any()
        } else {
            mItems[viewType.coerceIn(mItems.indices)]
        }
        val holder = factory.createViewHolder(parent, viewType, item)
        holder.itemView.setOnClickListener { v ->
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemClickListener?.invoke(v, mItems[pos], pos)
            }
        }
        holder.itemView.setOnLongClickListener { v ->
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemLongClickListener?.invoke(v, mItems[pos], pos)
                true
            } else {
                false
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: RVHolder<*>, position: Int) {
        holder.setContent(mItems[position], false, null)
    }

    override fun onBindViewHolder(holder: RVHolder<*>, position: Int, payloads: MutableList<Any>) {
        holder.setContent(mItems[position], false, payloads.firstOrNull())
    }
}