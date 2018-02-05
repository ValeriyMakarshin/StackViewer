package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.utils.OnClickListener
import com.hodzi.stackviewer.utils.Vote

interface AnswerClickListener : OnClickListener<Answer>{
    fun vote(id: Int, vote: Vote)
}
