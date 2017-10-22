package com.hodzi.stackviewer.questions.detail

import android.os.Bundle
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity.Companion.EXTRA_QUESTION
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.base.BasePresenter

class QuestionDetailPresenter(val questionsInteractor: QuestionsInteractor, val shared: Shared) :
    BasePresenter<QuestionDetailView>() {
    lateinit var question: Question

    override fun parseArguments(extras: Bundle) {
        question = bundle?.getSerializable(EXTRA_QUESTION) as Question
    }

    override fun attach(v: QuestionDetailView, bundle: Bundle?) {
        super.attach(v, bundle)
        view?.showQuestion(question)
    }

    override fun loadData() {
        baseObservableListDefaultError(questionsInteractor.getQuestionAnswers(question.questionId),
            { block ->
                view?.showArray(block.items.toTypedArray())
            })
    }

    fun vote(answerId : Int, up: Boolean){
        shared.getToken()
        shared.getToken()
    }
}