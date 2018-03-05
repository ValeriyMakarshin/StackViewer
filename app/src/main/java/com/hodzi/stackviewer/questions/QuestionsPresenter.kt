package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.core.BasePresenter

class QuestionsPresenter(val questionsInteractor: QuestionsInteractor)
    : BasePresenter<QuestionsView>() {

    override fun loadData() {
        baseObservableListDefaultError(questionsInteractor.getAllQuestions())
    }
}
