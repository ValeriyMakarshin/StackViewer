package com.hodzi.stackviewer.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.database.entities.Message
import com.hodzi.stackviewer.utils.base.BaseHolder
import kotlinx.android.synthetic.main.item_message.view.*
import java.util.*

class MessageHolder(itemView: View) : BaseHolder<Message>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> MessageHolder =
            { viewGroup ->
                MessageHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_message, viewGroup, false))
            }
    }

    override fun onDraw(item: Message) {
        itemView.uiNameTv.text = item.text

        itemView.uiTimeTv.text = item.time?.let { Date(it) }?.toString()
    }
}