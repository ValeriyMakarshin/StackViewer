package com.hodzi.stackviewer.questions

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseHolder
import com.hodzi.stackviewer.utils.setBackgroundEx
import kotlinx.android.synthetic.main.item_question_preview.view.*


class QuestionsHolder(itemView: View) : BaseHolder<Question>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> QuestionsHolder =
            { viewGroup ->
                QuestionsHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_question_preview, viewGroup, false))
            }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onDraw(item: Question) {
        itemView.uiTitleTv.text = item.title
//        itemView.uiPointsTv.text = "%+d".format(item.score)
        itemView.uiPointsTv.text = "${item.score}"

        itemView.uiPointsTv.setTextColor(
            if (item.isAnswered)
                Color.WHITE
            else
                R.color.colorPrimaryDark)

        itemView.uiPointsTv.setBackgroundEx(
            if (item.isAnswered)
                R.drawable.border_green_finished
            else
                R.drawable.border_green)


        itemView.uiTimeTv.text = item.creationDate.toString()
        itemView.uiTagsTv.text = item.tags.joinToString { s: String -> s + ", " }
    }
}