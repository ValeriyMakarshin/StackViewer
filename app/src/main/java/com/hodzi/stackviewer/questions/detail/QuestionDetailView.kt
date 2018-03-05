package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.core.BaseView

interface QuestionDetailView : BaseView {
    fun showQuestion(question: Question)

    fun goToAuth()

    fun voiceAccepted()
}
