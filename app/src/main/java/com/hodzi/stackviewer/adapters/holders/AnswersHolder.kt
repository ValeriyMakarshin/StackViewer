package com.hodzi.stackviewer.adapters.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.questions.detail.AnswerClickListener
import com.hodzi.stackviewer.utils.OnClickListener
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

    override fun setClickListener(onClickListener: OnClickListener<Answer>?) {
        if (onClickListener is AnswerClickListener) {
//            itemView.uiArrowUpIv.setOnClickListener { onClickListener.voteUp(item.answerId) }
//            itemView.uiArrowDownIv.setOnClickListener { onClickListener.voteDown(item.answerId) }
        }

    }

    override fun onDraw(item: Answer) {
        itemView.uiBodyWv.loadDataWithBaseURL(null, item.body, "text/html",
            "utf-8", null)

//        itemView.uiBodyTv.text = Html.fromHtml(item.body)
    }
}