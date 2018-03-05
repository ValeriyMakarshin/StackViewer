package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.core.BasePresenter

class QuestionsPresenter(val questionsInteractor: QuestionsInteractor)
    : BasePresenter<QuestionContract.View>(), QuestionContract.Presenter {

    override fun loadData() {
        baseObservableListDefaultError(questionsInteractor.getAllQuestions())
    }
}
