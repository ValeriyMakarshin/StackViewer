package com.hodzi.stackviewer.questions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseHolder

class QuestionHolder(itemView: View) : BaseHolder<Question>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> QuestionHolder =
            { viewGroup ->
                QuestionHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_question_preview, viewGroup, false))
            }
    }

    override fun onDraw(item: Question) {

    }

}