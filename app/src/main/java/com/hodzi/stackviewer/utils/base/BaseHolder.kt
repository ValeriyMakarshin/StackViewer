package com.hodzi.stackviewer.utils.base

import android.support.v7.widget.RecyclerView
import android.view.View
import com.hodzi.stackviewer.utils.OnClickListener

abstract class BaseHolder<T : Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected lateinit var item: T

    fun setData(item: T) {
        this.item = item
        onDraw(item)
    }

    open fun setClickListener(onClickListener: OnClickListener<T>?) {
        itemView.setOnClickListener { onClickListener?.onClick(item) }
    }

    abstract fun onDraw(item: T)
}
