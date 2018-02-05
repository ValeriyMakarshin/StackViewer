package com.hodzi.stackviewer.adapters.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.Tag
import com.hodzi.stackviewer.utils.base.BaseHolder
import kotlinx.android.synthetic.main.item_tag_preview.view.*

class TagsHolder(itemView: View) : BaseHolder<Tag>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> TagsHolder =
            { viewGroup ->
                TagsHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_tag_preview, viewGroup, false))
            }
    }

    override fun onDraw(item: Tag) {
        itemView.uiTagNameTv.text = item.name
    }
}
