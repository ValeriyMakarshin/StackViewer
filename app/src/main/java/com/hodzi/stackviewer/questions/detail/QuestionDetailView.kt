package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseView

interface QuestionDetailView : BaseView {
    fun showQuestion(question: Question)

    fun showArray(array: Array<Answer>)

    fun goToAuth()

    fun voiceAccepted()
}