package com.hodzi.stackviewer.questions

import android.os.Bundle
import com.hodzi.stackviewer.utils.base.BasePresenter

class QuestionsPresenter(val questionsInteractor: QuestionsInteractor)
    : BasePresenter<QuestionsView>() {
    override fun attach(v: QuestionsView, bundle: Bundle?) {
        super.attach(v, bundle)

        baseObservableListDefaultError(questionsInteractor.getAllQuestions(), {block ->
            view?.showArray(block.items.toTypedArray())})
    }
}