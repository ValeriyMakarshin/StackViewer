package com.hodzi.stackviewer.utils.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class BaseAdapter< T : Any, VH : BaseHolder<T>>(val list: Array<T>,
                                                         val creator : (ViewGroup?) -> VH) :
    RecyclerView.Adapter<VH>() {
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH = creator(parent)
}