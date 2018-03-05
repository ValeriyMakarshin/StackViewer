package com.hodzi.stackviewer.adapters.holders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.questions.detail.AnswerClickListener
import com.hodzi.stackviewer.utils.OnClickListener
import com.hodzi.stackviewer.utils.Vote
import com.hodzi.stackviewer.core.BaseHolder
import kotlinx.android.synthetic.main.item_answer_preview.view.*
import kotlinx.android.synthetic.main.view_web_content.view.*

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
            itemView.uiArrowUpIv.setOnClickListener {
                onClickListener.vote(item.answerId, Vote.ANSWER_UP)
            }
            itemView.uiArrowDownIv.setOnClickListener {
                onClickListener.vote(item.answerId, Vote.ANSWER_DOWN)
            }
        }

    }

    override fun onDraw(item: Answer) {
        itemView.uiPointsTv.text = item.score.toString()
        itemView.uiBodyWv.loadDataWithBaseURL(null, item.body, "text/html",
            "utf-8", null)
        itemView.uiBestAnswerIv.visibility =
            if (item.isAccepted) {
                View.VISIBLE
            } else {
                View.GONE
            }

        itemView.uiBodyWv.setBackgroundColor(Color.WHITE)
    }
}
