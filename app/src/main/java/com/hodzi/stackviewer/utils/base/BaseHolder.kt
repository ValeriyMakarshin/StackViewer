package com.hodzi.stackviewer.utils.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseHolder<T : Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected lateinit var item: T

    fun setData(item: T) {
        this.item = item
        onDraw(item)
    }

    abstract fun onDraw(item: T)
}