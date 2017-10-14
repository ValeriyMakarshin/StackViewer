package com.hodzi.stackviewer.utils.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class BaseRAdapter< T : Any, VH : BaseHolder<T>>(val array: Array<T>,
                                                          val creator : (ViewGroup?) -> VH) :
    RecyclerView.Adapter<VH>() {
    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(array[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH = creator(parent)
}