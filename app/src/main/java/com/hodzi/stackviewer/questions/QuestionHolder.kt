package com.hodzi.stackviewer.questions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseHolder
import kotlinx.android.synthetic.main.item_question_preview.view.*


class QuestionHolder(itemView: View) : BaseHolder<Question>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> QuestionHolder =
            { viewGroup ->
                QuestionHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_question_preview, viewGroup, false))
            }
    }

    override fun onDraw(item: Question) {
        itemView.uiTitleTv.text = item.title
        itemView.uiPointsTv.text = item.score.toString()
        itemView.uiTimeTv.text = item.creationDate.toString()
        itemView.uiTagsTv.text = item.tags.joinToString { s: String -> s + ", " }
    }
}