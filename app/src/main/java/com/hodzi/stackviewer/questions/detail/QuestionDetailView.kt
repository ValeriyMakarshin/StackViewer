package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.model.Question

interface QuestionDetailView {
    fun showQuestion(question: Question)

    fun goToAuth()

    fun voiceAccepted()
}
