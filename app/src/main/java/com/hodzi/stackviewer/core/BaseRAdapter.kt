package com.hodzi.stackviewer.core

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hodzi.stackviewer.utils.OnClickListener

abstract class BaseRAdapter<T : Any, VH : BaseHolder<T>>(array: Array<T>,
                                                         val creator: (ViewGroup?) -> VH,
                                                         val onClickListener: OnClickListener<T>? =
                                                             null) :
    RecyclerView.Adapter<VH>() {
    var items: Array<T> = array
        set(value) {
            field = value
            notifyItemChanged(0, value.size)
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(items[position])
        holder.setClickListener(onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = creator(parent)

    fun updateList(array: Array<*>) {
        items = array as Array<T>
    }
}
