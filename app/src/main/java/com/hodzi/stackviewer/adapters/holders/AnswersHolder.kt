package com.hodzi.stackviewer.adapters.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.utils.base.BaseHolder
import kotlinx.android.synthetic.main.item_answer_preview.view.*

class AnswersHolder(itemView: View) : BaseHolder<Answer>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> AnswersHolder =
            { viewGroup ->
                AnswersHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_answer_preview, viewGroup, false))
            }
    }

    override fun onDraw(item: Answer) {
        itemView.uiBodyTv.text = item.body
    }
}