package com.hodzi.stackviewer.questions.detail

import android.os.Bundle
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity.Companion.EXTRA_QUESTION
import com.hodzi.stackviewer.utils.base.BasePresenter

class QuestionDetailPresenter(val questionsInteractor: QuestionsInteractor) :
    BasePresenter<QuestionDetailView>(){
    lateinit var question: Question

    override fun parseArguments(extras: Bundle) {
        question = bundle?.getSerializable(EXTRA_QUESTION) as Question
    }

    override fun loadData() {
        baseObservableListDefaultError(questionsInteractor.getQuestionAnswers(question.questionId), {})
    }
}