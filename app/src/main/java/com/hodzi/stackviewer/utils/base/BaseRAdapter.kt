package com.hodzi.stackviewer.utils.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hodzi.stackviewer.utils.OnClickListener

abstract class BaseRAdapter<T : Any, VH : BaseHolder<T>>(val array: Array<T>,
                                                         val creator: (ViewGroup?) -> VH,
                                                         val onClickListener: OnClickListener<T>? =
                                                         null) :
    RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(array[position])
        holder.setClickListener(onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH = creator(parent)
}