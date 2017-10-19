package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.utils.OnClickListener

interface AnswerClickListener : OnClickListener<Answer>{
    fun voteUp(answerId: Int)

    fun voteDown(answerId: Int)
}